package com.masspick.peak.resource.service.impl;

import com.masspick.peak.resource.mapper.SysDictionaryMapper;
import com.masspick.peak.resource.model.SysDictionary;
import com.masspick.peak.resource.service.DictService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DictServiceImpl
 */
@Service
public class DictServiceImpl implements DictService {

    /**
     * sysDictionaryMapper
     */
    @Autowired
    private SysDictionaryMapper sysDictionaryMapper;

    /**
     * @param type
     * @return List
     */
    @Override
    public List<SysDictionary> getByType(String type) {
        return sysDictionaryMapper.selectByQueryParams(type);
    }

    /**
     * @param bussKey
     * @param type
     * @param defaultValue
     * @return String
     */
    @Override
    public String findDictName(String bussKey, String type, String defaultValue) {
        if (StringUtils.isNotEmpty(bussKey) && StringUtils.isNotEmpty(type)) {
            Map<String, Object> queryParams = new HashMap<>();
            queryParams.put("type", type);
            queryParams.put("bussKey", bussKey);
            //数据库中保存同一type key下 正常的 只会存在一个
            List<SysDictionary> list = sysDictionaryMapper.select(queryParams);
            if (!CollectionUtils.isEmpty(list)) {
                SysDictionary dict = list.get(0);
                return dict.getName();
            }
        }
        return defaultValue;
    }

}
