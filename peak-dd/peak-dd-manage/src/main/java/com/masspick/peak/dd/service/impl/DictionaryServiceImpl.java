package com.masspick.peak.dd.service.impl;

import com.masspick.peak.dd.config.SystemConfig;
import com.masspick.peak.dd.service.DictionaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/6/21 0021.
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    /**
     * systemConfig
     */
    @Resource
    private SystemConfig systemConfig;

    /*@Override
    public List<Map<String, Object>> dic(String type) {
        String url = systemConfig.getZuulUrl() + "/provider/api/provider/getDictByType/dataSource";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);
        List<Map<String, Object>> list = responseEntity.getBody();
        return list;

    }*/

    @Override
    public List<Map<String, Object>> dic() {
        String url = systemConfig.getZuulUrl() + "/peak-resource/v1/resource/dictionaries";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);
        List<Map<String, Object>> list = responseEntity.getBody();
        return list;
    }
}
