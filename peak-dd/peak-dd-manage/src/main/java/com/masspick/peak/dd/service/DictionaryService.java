package com.masspick.peak.dd.service;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/6/21 0021.
 */
public interface DictionaryService {
    /**
     * @param type
     * @return List<Map<String, Object>>
     */
    //List<Map<String, Object>> dic(String type);

    /**
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> dic();
}
