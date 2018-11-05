package com.masspick.peak.guest.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.masspick.peak.common.mvel.MvelUtil;
import com.masspick.peak.common.util.AES;
import com.masspick.peak.common.util.Base64;
import com.masspick.peak.common.util.DateUtils;
import com.masspick.peak.common.util.FileUtils;
import com.masspick.peak.common.util.JsonHelper;
import com.masspick.peak.common.util.ReadUrlUtil;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.common.util.StringHelper;
import com.masspick.peak.guest.common.redis.RedisUtil;
import com.masspick.peak.guest.common.upload.BytesToFile;
import com.masspick.peak.guest.common.upload.CosPathConfig;
import com.masspick.peak.guest.common.upload.FileConfig;
import com.masspick.peak.guest.common.util.CardUtils;
import com.masspick.peak.guest.common.util.CheckOcrResult;
import com.masspick.peak.guest.common.util.SmsUtils;
import com.masspick.peak.guest.controller.vo.BaseVo;
import com.masspick.peak.guest.controller.vo.LocationVo;
import com.masspick.peak.guest.controller.vo.PicInfoVo;
import com.masspick.peak.guest.controller.vo.WeiXinInfo;
import com.masspick.peak.guest.mapper.MessageMapper;
import com.masspick.peak.guest.mapper.ProductMapper;
import com.masspick.peak.guest.model.BusLicenseCer;
import com.masspick.peak.guest.model.IdMobileCer;
import com.masspick.peak.guest.model.NameCardInfo;
import com.masspick.peak.guest.service.IHomeService;
import com.masspick.peak.guest.vo.ApiResponse;
import com.masspick.peak.service.IProductFeignApi;
import com.masspick.peak.service.dto.SysProductInterestDTO;
import com.masspick.peak.service.dto.SysProductServiceDTO;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 首页和消息接口
 */
@Service
public class HomeServiceImpl implements IHomeService {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeServiceImpl.class);

    /**
     * SMS_RANDOM
     */
    private static final int SMS_RANDOM = 899999;
    /**
     * RANDOM
     */
    private static final int RANDOM = 100000;

    /**
     * FileConfig
     */
    @Autowired
    private FileConfig fileConfig;

    /**
     * RedisUtil
     */
    @Autowired
    private RedisUtil redisUtil;

    /**
     * MessageMapper
     */
    @Autowired
    private MessageMapper messageMapper;

    /**
     * productMapper
     */
    @Autowired
    private ProductMapper productMapper;

    /**
     * CosPathConfig
     */
    @Autowired
    private CosPathConfig cosPathConfig;

    /**
     * RestTemplate
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * COSClient
     */
    @Autowired
    private COSClient cosClient;

    /**
     * productFeignRpc
     */
    @Autowired
    private IProductFeignApi productFeignApi;

    /**
     * 获取微信信息
     *
     * @param code code
     * @return ApiResponse
     */
    @Override
    public ApiResponse getUserWebChatInfo(String code) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        try {
            JSONObject object = ReadUrlUtil.
                    readJsonFromUrl("https://api.weixin.qq.com/sns/jscode2session?"
                            + "appid=wxcaddb5200aa94317&secret=d3a61a419bc0806613ee4d3f748a7104&"
                            + "grant_type=authorization_code&js_code=" + code);
            if (object == null) {
                return apiResponse.error("400").setReason("获取openID异常");
            }

            if (StringUtils.isEmpty(object.getString("openid"))) {
                return apiResponse.error("400").setReason("获取openID异常");
            }

            WeiXinInfo info = new WeiXinInfo();
            info.setOpenId(object.getString("openid"));
            info.setSessionKey(object.getString("session_key"));
            return apiResponse.success().setResult(info);
        } catch (Exception e) {
            return apiResponse.error("401").setReason("code转换失败!");
        }
    }

    /**
     * 获取所在市
     *
     * @param location 坐标
     * @return ApiResponse
     */
    @Override
    public ApiResponse findCityByLocation(LocationVo location, BindingResult bindingResult) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        //校验参数必填
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        String url = "http://api.map.baidu.com/geocoder/v2/?ak=FgsmUtd1vLcGxAVtobwuVd4MWN5YLT1Y&callback=renderReverse&output=json&pois=1";
        String params = "&location=" + location.getLatitude() + "," + location.getLongitude();
        String result = restTemplate.getForObject(url + params, String.class);
        int beginIndex = result.indexOf("city") + 7;
        int lastIndex = result.lastIndexOf("\",\"city_level\"");
        return apiResponse.success().setResult(result.substring(beginIndex, lastIndex));
    }


    /**
     * 文件上传
     *
     * @param file file
     * @return ApiResponse
     */
    @Override
    public ApiResponse uploadPic(MultipartFile file) {
        ApiResponse apiResponse = ApiResponse.getInstances();

        //非空校验
        if (file.isEmpty() || StringUtils.isEmpty(file.getOriginalFilename())) {
            return apiResponse.error("400").setReason("上传文件为空");
        }

        try {
            //将文件存放到本地临时目录
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String fileName = SequenceUtils.getUUID() + suffix;
            String path = fileConfig.getTempFilePath();
            File tempDir = new File(path);
            if (!tempDir.exists() && !tempDir.isDirectory()) {
                tempDir.mkdir();
            }
            String filePathAndName = fileConfig.getTempFilePath() + fileName;
            File tempFile = new File(filePathAndName);
            FileUtils.copyInputStreamToFile(file.getInputStream(), tempFile);


            InputStream inputStream = new FileInputStream(tempFile);
            byte[] byt = new byte[inputStream.available()];
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(byt.length);
            PutObjectRequest putObjectRequest = new PutObjectRequest(cosPathConfig.getCosBucketName(),
                    cosPathConfig.getCosDir() + fileName, inputStream, objectMetadata);
            cosClient.putObject(putObjectRequest);
            return apiResponse.success().setResult(cosPathConfig.getCosUrl() + "/" + cosPathConfig.getCosDir() + fileName);
        } catch (Exception e) {
            LOGGER.error("error message", e);
            return apiResponse.error("401").setReason("文件上传腾讯云失败");
        }
    }

    /**
     * h5文件上传
     *
     * @param file
     * @return ApiResponse
     */
    @Override
    public ApiResponse uploadHtmlPic(String file) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        String today = DateUtils.format(new Date(), DateUtils.YEARHOURDAY_FORMAT) + "/";
        //非空校验
        if (file == null) {
            return apiResponse.error("400").setReason("上传文件为空");
        }
        try {
            String suffix = "jpg";
            Pattern p = Pattern.compile("\t|\r|\n");
            if (file.contains(";base64,")) {
                String[] images = file.split(";base64,");
                file = images[1];
                String temp = images[0].substring(11).toString();
                if ("jpeg".equals(temp)) {
                    suffix = "jpg";
                } else {
                    suffix = temp;
                }
            }
            Matcher m = p.matcher(file);
            String imgStrReplace = m.replaceAll("").replaceAll(" ", "");
            Base64 decoder = new Base64();
            byte[] b = decoder.decodeBase64(imgStrReplace);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {

                    //调整异常数据
                    b[i] += 256;
                }
            }
            String fileName = SequenceUtils.getUUID() + "." + suffix;
            //将文件保存在至本地
            FileUtils.byteToFile(b, fileConfig.getTempFilePath(), fileName);
            InputStream inputStream = new ByteArrayInputStream(b);
            byte[] byt = new byte[inputStream.available()];
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(byt.length);
            PutObjectRequest putObjectRequest = new PutObjectRequest(cosPathConfig.getCosBucketName(),
                    cosPathConfig.getCosDir() + today + fileName, inputStream, objectMetadata);
            cosClient.putObject(putObjectRequest);
            return apiResponse.success().setResult(cosPathConfig.getCosUrl() + "/" + cosPathConfig.getCosDir() + today + fileName);
        } catch (Exception e) {
            LOGGER.error("error message", e);
            return apiResponse.error("401").setReason("文件上传腾讯云失败");
        } finally {
            cosClient.shutdown();
        }
    }

    /**
     * ocr识别
     *
     * @param picInfoVo 图片信息
     * @return ApiResponse
     */
    @Override
    public ApiResponse getPictureInfo(PicInfoVo picInfoVo, BindingResult bindingResult) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        //校验参数必填
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        String ret = "";
        JSONArray array = null;
        //名片
        String storeUrl = downloadImage(picInfoVo.getUrl());
        //URL的完整性
        String stffic = storeUrl.substring(storeUrl.lastIndexOf(File.separator) + 1);
        if (!StringUtils.isEmpty(stffic) && stffic.contains(".")) {
            if (FileConfig.getNameCard().equals(picInfoVo.getType())) {
                try {
                    ret = CardUtils.ocrNameCard(storeUrl);
                    array = JsonHelper.removeRepeatItem(ret);
                    NameCardInfo nameCardInfo = CardUtils.getPreCreditFromJsonArray(array);
                    nameCardInfo.setNameUrl(picInfoVo.getUrl());
                    if (!CheckOcrResult.checkNameCardInfo(nameCardInfo)) {
                        return apiResponse.error("402").setReason("您识别的可能不是一张名片或者拍摄太模糊，请重新识别！");
                    }
                    return apiResponse.success().setResult(nameCardInfo);
                } catch (Exception e) {
                    return apiResponse.error("402").setReason("您识别的可能不是一张名片或者拍摄太模糊，请重新识别！");
                }
            } else if (FileConfig.getBusCard().equals(picInfoVo.getType())) {
                //读取工商信息
                try {
                    ret = CardUtils.ocrBizLicense(storeUrl);
                    BusLicenseCer busLicenseCer = CardUtils.getBusLicenseCerByMap(ret);
                    busLicenseCer.setBusUrl(picInfoVo.getUrl());
                    if (!CheckOcrResult.checkBusInfo(busLicenseCer)) {
                        return apiResponse.error("402").setReason("您识别的可能不是一张营业执照或者拍摄太模糊，请重新识别！");
                    }
                    return apiResponse.success().setResult(busLicenseCer);
                } catch (Exception e) {
                    return apiResponse.error("402").setReason("您识别的可能不是一张营业执照或者拍摄太模糊，请重新识别！");
                }
            } else if (FileConfig.getIdCard().equals(picInfoVo.getType())) {
                try {
                    if (picInfoVo.getSide() == null) {
                        picInfoVo.setSide(0);
                    }
                    ret = CardUtils.ocrIdCard(storeUrl, picInfoVo.getSide());
                    IdMobileCer idMobileCer = CardUtils.getIdCerByMap(ret);
                    if (picInfoVo.getSide() == 0) {
                        idMobileCer.setIdUrl(picInfoVo.getUrl());
                    } else {
                        idMobileCer.setIdBackUrl(picInfoVo.getUrl());
                    }
                    if (!CheckOcrResult.checkIdInfo(idMobileCer, picInfoVo.getSide())) {
                        return apiResponse.error("402").setReason("您识别的可能不是一张身份证或者拍摄太模糊，请重新识别！");
                    }
                    return apiResponse.success().setResult(idMobileCer);
                } catch (Exception e) {
                    return apiResponse.error("402").setReason("您识别的可能不是一张身份证或者拍摄太模糊，请重新识别！");
                }
            }
        }
        return apiResponse.error("400").setReason("找不到相应文件");
    }

    /**
     * 发送短信验证码
     *
     * @param mobile 手机号
     * @return ApiResponse
     */
    @Override
    public ApiResponse getSmsCode(String mobile) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (StringHelper.isBlank(mobile)) {
            return apiResponse.error("400").setReason("手机号不能为空！");
        }

        String verifyCode = String
                .valueOf(new Random().nextInt(SMS_RANDOM) + RANDOM); //生成短信验证码
        //放到缓存redis中去 时间为1分钟
        try {
            redisUtil.putVerCodeMobile(mobile, verifyCode);
            SmsSingleSenderResult res = SmsUtils.sendSms(mobile, verifyCode);
            return apiResponse.success().setResult(res);
        } catch (Exception e) {
            return apiResponse.error("401").setReason("发送短信验证码失败！");
        }
    }

    /**
     * 手机验证码校验
     *
     * @param mobile  手机号
     * @param smsCode 验证码
     * @return ApiResponse
     */
    @Override
    public ApiResponse verSmsCode(String mobile, String smsCode) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (StringUtils.isEmpty(mobile)) {
            return apiResponse.error("400").setReason("手机号不能为空");
        }
        if (StringUtils.isEmpty(smsCode)) {
            return apiResponse.error("400").setReason("验证码不能为空");
        }

        //验证redis中是否有该手机号的验证码
        try {
            String code = redisUtil.getVerCodeByMobile(mobile);
            if (StringUtils.isEmpty(code)) {
                return apiResponse.error("401").setReason("验证码失效!");
            }
            if (!code.equals(smsCode)) {
                return apiResponse.error("402").setReason("输入的验证码不一致!");
            } else {
                return apiResponse.success().setResult("OK");
            }
        } catch (Exception e) {
            return apiResponse.error("403").setReason("验证码校验失败！");
        }
    }

    /**
     * 查询消息
     *
     * @param userId 用户id
     * @return ApiResponse
     */
    @Override
    public ApiResponse findMessagesByUserId(String userId) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (StringHelper.isEmpty(userId)) {
            return apiResponse.error("400").setReason("用户信息为空");
        }
        return apiResponse.success().setResult(messageMapper.findList(userId));
    }

    /**
     * 标记消息已读
     *
     * @param id id
     * @return ApiResponse
     */
    @Override
    @Transactional
    public ApiResponse readMessage(String id) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        try {
            messageMapper.readMessage(id);
        } catch (Exception e) {
            return apiResponse.error("201").setResult("FAILED");
        }
        return apiResponse.success().setResult("OK");
    }

    /**
     * 删除消息
     *
     * @param id 消息id
     * @return ApiResponse
     */
    @Override
    @Transactional
    public ApiResponse deleteMessage(String id) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        try {
            messageMapper.deleteById(id);
        } catch (Exception e) {
            return apiResponse.error("201").setResult("FAILED");
        }
        return apiResponse.success().setResult("OK");
    }

    /**
     * 获取用户手机号
     *
     * @param baseVo baseVo
     * @return ApiResponse
     */
    @Override
    public ApiResponse getUserMobile(BaseVo baseVo) {
        ApiResponse apiResponse = ApiResponse.getInstances();

        String encrypted = baseVo.getString("encryptedData");

        if (StringHelper.isBlank(encrypted)) {
            apiResponse.error("400").setReason("密文参数为空");
        }

        String sessionKey = baseVo.getString("sessionKey");
        if (StringHelper.isBlank(sessionKey)) {
            apiResponse.error("400").setReason("sessionKey参数为空");
        }

        String iv = baseVo.getString("iv");
        if (StringHelper.isBlank(iv)) {
            apiResponse.error("400").setReason("iv参数为空");
        }

        String openId = baseVo.getString("openId");
        if (openId == null || StringHelper.isBlank(openId)) {
            apiResponse.error("400").setReason("openId参数为空");
        }

        String purePhoneNumber = "";
        try {
            String json = AES.wxDecrypt(encrypted, sessionKey, iv);
            JSONObject object = JSONObject.parseObject(json);
            purePhoneNumber = object.getString("purePhoneNumber");
        } catch (Exception e) {
            return apiResponse.error("401").setReason("读取手机号码失败!");
        }
        return apiResponse.success().setResult(purePhoneNumber);
    }

    /**
     * 图片下载
     *
     * @param imageUrl imageUrl
     * @return String
     */
    @Override
    public String downloadImage(String imageUrl) {
        String fileName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
        String tempFile = fileConfig.getTempFilePath() + fileName;
        byte[] fileBytes = restTemplate.getForObject(imageUrl, byte[].class);
        BytesToFile.getFileByBytes(fileBytes, tempFile);
        return tempFile;
    }

    /**
     * 压缩文件上传
     *
     * @param zipFile zipFile
     * @return String
     */
    @Override
    public String uploadFile(File zipFile) {

        String url = "";
        try {
            String fileName = zipFile.getName();
            InputStream inputStream = new FileInputStream(zipFile);
            byte[] byt = new byte[inputStream.available()];
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(byt.length);
            PutObjectRequest putObjectRequest = new PutObjectRequest(cosPathConfig.getCosBucketName(),
                    cosPathConfig.getCosDir() + fileName, inputStream, objectMetadata);
            cosClient.putObject(putObjectRequest);
            url = cosPathConfig.getCosUrl() + "/" + cosPathConfig.getCosDir() + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return url;
        }
        return url;
    }

    /**
     * 获取所有可用的产品
     *
     * @return List<String>
     */
    @Override
    public List<String> findAllAbleProducts() {
        return productMapper.findAllAbleProducts();
    }

    /**
     *  根据审批额度和期限匹配表达式获取费率
     * @param productId 产品id
     * @param data 表达式key值
     * @return Map<String, String>
     */
    @Override
    public Map<String, String> getRateMap(String productId, Map<String, Object> data) {
        Map<String, String> rateMap = new HashMap<>();
        try {
            MvelUtil mvelUtil = new MvelUtil();
            List<SysProductInterestDTO> interestDTOList = productFeignApi.findId(productId).getProductInterestDTOS();
            List<SysProductServiceDTO> serviceDTOList = productFeignApi.findId(productId).getProductServiceDTOS();
            SysProductInterestDTO sysProductInterestDTO = mvelUtil.match(interestDTOList, data);
            if (sysProductInterestDTO != null) {
                rateMap.put("interestRate", sysProductInterestDTO.getRate());
            }
            SysProductServiceDTO sysProductServiceDTO = mvelUtil.match(serviceDTOList, data);
            if (sysProductServiceDTO != null) {
                rateMap.put("serviceRate", sysProductServiceDTO.getRate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  rateMap;
    }
}
