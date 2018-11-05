package com.masspick.peak.guest.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.masspick.peak.common.util.StringHelper;
import com.masspick.peak.guest.model.BusLicenseCer;
import com.masspick.peak.guest.model.IdMobileCer;
import com.masspick.peak.guest.model.NameCardInfo;
import com.qcloud.image.ImageClient;
import com.qcloud.image.exception.AbstractImageException;
import com.qcloud.image.request.FaceIdCardLiveDetectFourRequest;
import com.qcloud.image.request.FaceLiveGetFourRequest;
import com.qcloud.image.request.IdcardDetectRequest;
import com.qcloud.image.request.NamecardDetectRequest;
import com.qcloud.image.request.OcrBizLicenseRequest;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * 图像识别处理类
 */
public final class CardUtils {


    /**
     * appId
     */
    private static final String APPID = "1255853614";
    /**
     * secretId
     */
    private static final String SECRETID = "AKIDPfAYmp5OuNgolWvVq35wd9TdcQ2THurd";
    /**
     * secretKey
     */
    private static final String SECRETKEY = "kM1Vo6KSVSJ3iGk9RcfXFoDYiiXB7uVu";
    /**
     * bucketName
     */
    private static final String BUCKETNAME = "backup-1255853614";

    /**
     * MIN
     */
    private static final int MIN = 80;

    // http请求发送对象


    /**
     * @param args
     * @throws AbstractImageException 异常
     * @throws Exception              异常
     */
    public static void main(String[] args) throws AbstractImageException, Exception {
       /* String ret = ocrNameCard("E:" + File.separator + "cer" + File.separator + "4.png");
        System.out.println(JsonHelper.removeRepeatItem(ret));*/

        /*String ret = ocrBizLicense("E:" + File.separator + "cer" + File.separator + "666.jpg");
        BusLicenseCer busLicenseCer = getBusLicenseCerByMap(ret);*/

    }


    /**
     * @param videoUrl
     * @param idCardNum
     * @param idCardName
     * @param validate
     * @return String
     */
    public static String faceLiveDetectFour(String videoUrl, String idCardNum, String idCardName, String validate) {
        String ret;
        // 1. url方式
        System.out.println("====================================================");
        File video = null;
        try {
            video = new File(videoUrl);
        } catch (Exception ex) {
        }

        ImageClient imageClient = new ImageClient(APPID, SECRETID, SECRETKEY);

        String liveDetectIdcardNumber = idCardNum;
        String liveDetectIdcardName = idCardName;

        FaceIdCardLiveDetectFourRequest liveDetectReq = new FaceIdCardLiveDetectFourRequest(BUCKETNAME,
                validate, video, liveDetectIdcardNumber, liveDetectIdcardName, "seq");
        ret = imageClient.faceIdCardLiveDetectFour(liveDetectReq);
        return ret;
    }

    /**
     * @param ret
     * @return String
     */
    public static String faceIdResult(String ret) {
        String res = "error";
        try {
            JSONObject object = JSONObject.parseObject(ret).getJSONObject("data");
            String msg = object.getString("compare_msg");
            if (!StringHelper.isEmpty(msg) && msg.equals("OK")) {
                Integer sim = object.getIntValue("sim");
                if (sim != null && sim.intValue() >= MIN) {
                    res = "success";
                }
            }
        } catch (Exception e) {
            return res;
        }
        return res;
    }


    /**
     * @param url
     * @return String
     */
    public static String ocrNameCard(String url) {
        String ret;
        ImageClient imageClient = new ImageClient(APPID, SECRETID, SECRETKEY);
        String[] namecardNameList = new String[1];
        File[] namecardImageList = new File[1];
        try {
            namecardNameList[0] = url.substring(url.lastIndexOf(File.separator) + 1);
            namecardImageList[0] = new File(url);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        NamecardDetectRequest nameReq = new NamecardDetectRequest(BUCKETNAME, namecardNameList, namecardImageList, 0);
        ret = imageClient.namecardDetect(nameReq);
        return ret;
    }


    /**
     * @param url
     * @return String
     */
    public static String ocrBizLicense(String url) {
        String ret;
        ImageClient imageClient = new ImageClient(APPID, SECRETID, SECRETKEY);
        OcrBizLicenseRequest request = new OcrBizLicenseRequest(BUCKETNAME, new File(url));
        ret = imageClient.ocrBizLicense(request);
        return ret;
    }


    /**
     * 识别身份证
     * @param url 地址
     * @param side 面
     * @return
     * @throws Exception
     */
    public static String ocrIdCard(String url, Integer side) throws Exception {
        String ret;
        String[] idcardNameList = new String[1];
        File[] idcardImageList = new File[1];
        idcardNameList[0] = url.substring(url.lastIndexOf(File.separator) + 1);
        idcardImageList[0] = new File(url);
        if (side == null) {
            side = 0;
        }
        IdcardDetectRequest idReq = new IdcardDetectRequest(BUCKETNAME, idcardNameList, idcardImageList, side);
        ImageClient imageClient = new ImageClient(APPID, SECRETID, SECRETKEY);
        ret = imageClient.idcardDetect(idReq);
        return ret;
    }


    /**
     * @param array
     * @return NameCardInfo
     */
    public static NameCardInfo getPreCreditFromJsonArray(JSONArray array) {
        NameCardInfo nameCardInfo = null;
        if (!array.isEmpty()) {
            nameCardInfo = new NameCardInfo();
            for (int i = 0; i < array.size(); i++) {
                JSONObject object = array.getJSONObject(i);
                if (object != null) {
                    String item = object.getString("item");
                    String value = object.getString("value");
                    if (!StringUtils.isEmpty(item)) {
                        if (item.equals("姓名")) {
                            nameCardInfo.setLegalName(value);
                        }

                        if (item.equals("公司")) {
                            nameCardInfo.setEtpName(value);
                        }

                        if (item.equals("手机")) {
                            nameCardInfo.setMobile(value);
                        }

                        if (item.equals("职位")) {
                            nameCardInfo.setPosition(value);
                        }


                        if (item.equals("地址")) {
                            nameCardInfo.setAddress(value);
                        }

                        if (item.equals("邮箱")) {
                            nameCardInfo.setEmail(value);
                        }

                        if (item.equals("网址")) {
                            nameCardInfo.setWebsite(value);
                        }

                        if (item.equals("电话")) {
                            nameCardInfo.setPhone(value);
                        }
                    }

                }
            }
        }

        return nameCardInfo;
    }


    /**
     * @param ret
     * @return BusLicenseCer
     * @throws Exception 异常
     */
    public static BusLicenseCer getBusLicenseCerByMap(String ret) throws Exception {
        BusLicenseCer bus = new BusLicenseCer();
        try {
            JSONArray array = JSONObject.parseObject(ret).getJSONObject("data").getJSONArray("items");
            for (int i = 0; i < array.size(); i++) {

                JSONObject object = array.getJSONObject(i);
                String value = object.getString("itemstring");

                if (object.getString("item").equals("注册号")) {
                    bus.setCreditCode(value);
                }

                if (object.getString("item").equals("法定代表人")) {
                    bus.setLegalName(value);
                }

                if (object.getString("item").equals("公司名称")) {
                    bus.setEtpName(value);
                }

                if (object.getString("item").equals("地址")) {
                    bus.setAddress(value);
                }

                if (object.getString("item").equals("营业期限")) {
                    bus.setBusTerm(value);
                }

                if (object.getString("item").equals("注册资本")) {
                    bus.setRegCap(value);
                }

                if (object.getString("item").equals("成立日期")) {
                    bus.setRegDate(value);
                }

                if (object.getString("item").equals("类型")) {
                    bus.setType(value);
                }

                if (object.getString("item").equals("经营范围")) {
                    bus.setBusScope(value);
                }
            }

        } catch (Exception e) {
            throw new Exception("解析营业执照失败.");
        }
        return bus;
    }


    /**
     * @param ret
     * @return IdCer
     * @throws Exception 异常
     */
    public static IdMobileCer getIdCerByMap(String ret) throws Exception {
        IdMobileCer idMobileCer = new IdMobileCer();
        JSONArray array = JSONObject.parseObject(ret).getJSONArray("result_list");
        JSONObject object = array.getJSONObject(0);
        JSONObject jsonObject = object.getJSONObject("data");

        String name = jsonObject.getString("name");
        idMobileCer.setName(name);

        String sex = jsonObject.getString("sex");
        idMobileCer.setSex(sex);

        String nation = jsonObject.getString("nation");
        idMobileCer.setNation(nation);

        String birth = jsonObject.getString("birth");
        idMobileCer.setBirth(birth);

        String address = jsonObject.getString("address");
        idMobileCer.setAddress(address);

        String idCode = jsonObject.getString("id");
        idMobileCer.setIdCode(idCode);

        String authority  = jsonObject.getString("authority");
        idMobileCer.setIssuingAgency(authority);

        String validDate = jsonObject.getString("valid_date");
        idMobileCer.setValidityPeriod(validDate);
        return idMobileCer;
    }


    /**
     * @return String
     * @throws Exception 异常
     */
    public static String faceLiveGetFour() throws Exception {
        System.out.println("====================================================");
        String seq = "seq";
        FaceLiveGetFourRequest getFaceFourReq = new FaceLiveGetFourRequest(BUCKETNAME, seq);
        ImageClient imageClient = new ImageClient(APPID, SECRETID, SECRETKEY);
        String ret = imageClient.faceLiveGetFour(getFaceFourReq);

        System.out.println("face live get four  ret:" + ret);
        String validate = "";
        org.json.JSONObject jsonObject = new org.json.JSONObject(ret);
        org.json.JSONObject data = jsonObject.getJSONObject("data");
        if (null != data) {
            validate = data.getString("validate_data");
        }
        return validate;
    }
}
