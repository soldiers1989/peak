package com.masspick.peak.resource.service.impl;


import com.masspick.peak.common.util.DateUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.resource.config.COSConfig;
import com.masspick.peak.resource.config.SystemConfig;
import com.masspick.peak.resource.config.constant.CommonConstant;
import com.masspick.peak.resource.entity.SysIns;
import com.masspick.peak.resource.entity.SysInsStaff;
import com.masspick.peak.resource.mapper.SysInsMapper;
import com.masspick.peak.resource.mapper.SysInsStaffMapper;
import com.masspick.peak.resource.service.IInsService;
import com.masspick.peak.resource.service.IRandomService;
import com.masspick.peak.resource.utils.QRCodeUtil;
import com.masspick.peak.resource.vo.InsDataGridFindVo;
import com.masspick.peak.resource.vo.StaffDataGridFindVo;
import com.masspick.peak.resource.vo.StaffPageShowVo;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 机构服务实现类
 */
@Service
public class InsServiceImpl implements IInsService {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(InsServiceImpl.class);
    /**
     * sysInsMapper
     */
    @Autowired
    private SysInsMapper sysInsMapper;
    /**
     * sysInsStaffMapper
     */
    @Autowired
    private SysInsStaffMapper sysInsStaffMapper;

    /**
     * wxConfig
     */
    @Autowired
    private COSConfig cosConfig;

    /**
     * cosClient
     */
    @Autowired
    private COSClient cosClient;

    /**
     * sysProductMapper
     */
    @Resource
    private IRandomService iRandomService;

    /**
     *  systemConfig
     */
    @Autowired
    private SystemConfig systemConfig;

    /**
     * wxWidth
     */
    private final Integer wxWidth = 430;


    /**
     * @param insDataGridFindVo insDataGridFindVo
     * @return List<SysIns>
     */
    @Override
    public List<SysIns> findInsByPage(InsDataGridFindVo insDataGridFindVo) {
        return sysInsMapper.findByPage(insDataGridFindVo);
    }

    /**
     * @return List<SysIns>
     */
    @Override
    public List<SysIns> findAll() {
        return sysInsMapper.findAll();
    }

    /**
     * @return List<SysIns>
     */
    @Override
    public List<SysIns> findAllAble() {
        return sysInsMapper.findAllAble();
    }

    /**
     * @param sysIns sysIns
     * @return SysIns
     */
    @Override
    public SysIns addSysIns(SysIns sysIns) {
        sysIns.preInsert();
        sysInsMapper.insert(sysIns);
        return sysIns;
    }

    /**
     * @param sysIns sysIns
     * @return SysIns
     */
    @Override
    public SysIns modifyInsStatus(SysIns sysIns) {
        sysIns.setUpdateDate(new Date());
        sysInsMapper.update(sysIns);
        return sysInsMapper.findById(sysIns.getId());
    }

    /**
     * @param id id
     * @return SysIns
     */
    @Override
    public SysIns findOneIns(String id) {
        return sysInsMapper.findById(id);
    }

    @Override
    public Boolean checkUniqueCode(SysIns sysIns) {
        SysIns codeIns = sysInsMapper.findByCode(sysIns.getCode());
        if (codeIns != null && sysIns.getId() == null) {
            return false;
        }
        if (codeIns != null && !sysIns.getId().equals(codeIns.getId())) {
            return false;
        }
        return true;
    }

    /**
     * @param sysIns sysIns
     * @return SysIns
     */
    @Override
    public SysIns modifyIns(SysIns sysIns) {
        sysIns.setUpdateDate(new Date());
        sysInsMapper.update(sysIns);
        return sysInsMapper.findById(sysIns.getId());
    }

    /**
     * @param sysInsStaff sysInsStaff
     * @return SysInsStaff
     */
    @Override
    public SysInsStaff addInsStaff(SysInsStaff sysInsStaff) {
        //插入基本数据
        sysInsStaff.preInsert();
        sysInsStaff.setNumber(iRandomService.getRandom("1000"));
        uploadQRImg(sysInsStaff);
        sysInsStaffMapper.insert(sysInsStaff);
        return sysInsStaff;
    }

    /**
     *
     * @param sysInsStaff sysInsStaff
     * @return SysInsStaff
     */
    @Override
    public SysInsStaff findByMobile(SysInsStaff sysInsStaff) {
        return sysInsStaffMapper.findByInsMobile(sysInsStaff.getMobile());
    }

    /**
     * @param staffDataGridFindVo staffDataGridFindVo
     * @return List<StaffPageShowVo>
     */
    @Override
    public List<StaffPageShowVo> findByPage(StaffDataGridFindVo staffDataGridFindVo) {
        return sysInsStaffMapper.findByPage(staffDataGridFindVo);
    }

    /**
     * @param sysInsStaff sysInsStaff
     * @return StaffPageShowVo
     */
    @Override
    public StaffPageShowVo modifyStaffStatus(SysInsStaff sysInsStaff) {
        sysInsStaff.setUpdateDate(new Date());
        sysInsStaffMapper.update(sysInsStaff);
        return sysInsStaffMapper.findById(sysInsStaff.getId());
    }

    /**
     * @param id id
     * @return StaffPageShowVo
     */
    @Override
    public StaffPageShowVo findOneStaff(String id) {
        return sysInsStaffMapper.findById(id);
    }


    /**
     *
     * @param mobile
     * @return StaffPageShowVo
     */
    @Override
    public StaffPageShowVo findOneSraffByMobile(String mobile) {
        return sysInsStaffMapper.findByMobile(mobile);
    }

    /**
     * @param sysInsStaff sysInsStaff
     * @return StaffPageShowVo
     */
    @Override
    public StaffPageShowVo modifyStaff(SysInsStaff sysInsStaff) {
        sysInsStaff.setUpdateDate(new Date());
        sysInsStaffMapper.update(sysInsStaff);
        return sysInsStaffMapper.findById(sysInsStaff.getId());
    }

    /**
     * @param sysInsStaff 机构员工
     * @return Boolean
     */
    @Override
    public Boolean checkInsStatus(SysInsStaff sysInsStaff) {
        StaffPageShowVo staffPageShowVo = sysInsStaffMapper.findById(sysInsStaff.getId());
        SysIns sysIns = sysInsMapper.findById(sysInsStaff.getInstitutionId());
        if (staffPageShowVo == null || sysIns == null) {
            return false;
        }
        if (!staffPageShowVo.getInstitutionId().equals(sysInsStaff.getInstitutionId())
                && sysIns.getStatus().equals(CommonConstant.DISABLE_STATUS)) {
            return false;
        }
        return true;
    }

    @Override
    public List<SysInsStaff> inIdS(List<String> list) {
        return sysInsStaffMapper.findByIds(list);
    }

    private void uploadImg(SysInsStaff sysInsStaff) {
        String destinationDir = DateUtils.format(new Date(), "yyyy-MM-dd");
        RestTemplate rest = new RestTemplate();
        ResponseEntity<Map> responseEntity = rest.getForEntity("https://api.weixin.qq"
                + ".com/cgi-bin/token?grant_type=client_credential&appid=wxcaddb5200aa94317&secret"
                + "=d3a61a419bc0806613ee4d3f748a7104", Map.class);
        Map<String, Object> map = responseEntity.getBody();
        String token = (String) map.get("access_token");
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            String url = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + token;
            Map<String, Object> param = new HashMap<>();
            param.put("scene", sysInsStaff.getNumber());
            param.put("page", "pages/start-up/start-up");
            param.put("width", wxWidth);
            param.put("auto_color", false);
            Map<String, Object> color = new HashMap<>();
            color.put("r", 0);
            color.put("g", 0);
            color.put("b", 0);
            param.put("line_color", color);
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            HttpEntity requestEntity = new HttpEntity(param, headers);
            ResponseEntity<byte[]> entity = rest.exchange(url, HttpMethod.POST, requestEntity, byte[].class, new
                    Object[0]);
            byte[] result = entity.getBody();
            inputStream = new ByteArrayInputStream(result);
            String uuid = SequenceUtils.getUUID();
            String key = cosConfig.getCosDir() + destinationDir + "/" + uuid + ".png";
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(result.length);
            PutObjectRequest putObjectRequest = new PutObjectRequest(cosConfig.getCosBucketName(),
                    key, inputStream, objectMetadata);
            cosClient.putObject(putObjectRequest);
            sysInsStaff.setUrl(cosConfig.getCosUrl() + "/" + key);
            sysInsStaff.setDownloadUrl(cosConfig.getCosDownloadUrl() + "/" + key);
        } catch (Exception e) {
            LOGGER.error("调用小程序生成微信永久二维码URL接口异常", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void uploadQRImg(SysInsStaff sysInsStaff) {
        // 本地生成临时二维码文件
        String insStaffNum = sysInsStaff.getNumber();
        String content = systemConfig.getGuestUrl() + "?type=promotion&insStaffNum=" + insStaffNum;
        File tempDir = new File(systemConfig.getFileDir());
        if (!tempDir.exists()) {
            tempDir.mkdir();
        }
        String fileName = systemConfig.getFileDir() + SequenceUtils.getUUID() + ".png";
        boolean result = QRCodeUtil.zxingCodeCreate(content, fileName);
        if (!result) {
            return;
        }
        //临时文件上传腾讯云
        String destinationDir = DateUtils.format(new Date(), "yyyy-MM-dd");
        File file =  new File(fileName);
        if (file.exists()) {
            try {
                InputStream inputStream = new FileInputStream(file);
                byte[] byt = new byte[inputStream.available()];
                String key = cosConfig.getCosDir() + destinationDir + "/" + file.getName();
                ObjectMetadata objectMetadata = new ObjectMetadata();
                objectMetadata.setContentLength(byt.length);
                PutObjectRequest putObjectRequest = new PutObjectRequest(cosConfig.getCosBucketName(),
                        key, inputStream, objectMetadata);
                cosClient.putObject(putObjectRequest);
                sysInsStaff.setUrl(cosConfig.getCosUrl() + "/" + key);
                sysInsStaff.setDownloadUrl(cosConfig.getCosDownloadUrl() + "/" + key);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
