package com.masspick.peak.resource.service;



import com.masspick.peak.resource.model.SysDictionary;

import java.util.List;

/**
 * DictService
 */
public interface DictService {
    /**
     * @param type
     * @return List
     */
    List<SysDictionary> getByType(String type);

    /**
     * @param bussKey
     * @param type
     * @param defaultValue
     * @return String
     */
    String findDictName(String bussKey, String type, String defaultValue);

}
