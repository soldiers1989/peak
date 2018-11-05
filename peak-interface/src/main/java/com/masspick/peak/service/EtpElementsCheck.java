package com.masspick.peak.service;

import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.config.EtpConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by Administrator on 2018\9\12 0012.
 */
@RestController
public class EtpElementsCheck implements EtpElementsFeignApi {
    /**
     *  restTemplate
     */
    @Autowired
    private RestTemplate restTemplate;
    /**
     * etpConfig
     */
    @Autowired
    private EtpConfig etpConfig;

    /**
     *  企业三要素校验
     * @param regNo 统一信用代码
     * @param companyName 公司名称
     * @param frname 法人姓名
     * @return Map
     * @throws Exception
     */
    @Override
    public Map etpElementsCheck(String regNo, String companyName, String frname) throws Exception {
        String params = "?key=" + etpConfig.getKey() + "&regNo=" + regNo + "&companyName=" + companyName + "&frname=" + frname;
        String url = etpConfig.getUrl() + params;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return JacksonUtils.readValue(responseEntity.getBody(), Map.class);
    }

}
