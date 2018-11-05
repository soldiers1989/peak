package com.masspick.peak.dd.controller.vo;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/5/17 0017.
 */
public class DictionaryVO {

    /**
     * code
     */
    private String code;

    /**
     * name
     */
    private String name;

    /**
     * @param sysDictionaryList
     * @param dictionaryVOList
     */
    public void transfer(List<Map<String, Object>> sysDictionaryList, List<DictionaryVO> dictionaryVOList) {
        for (Map<String, Object> sysDictionary : sysDictionaryList) {
            DictionaryVO dictionaryVO = new DictionaryVO((String) sysDictionary.get("code"), (String)
                    sysDictionary.get("name"));
            dictionaryVOList.add(dictionaryVO);
        }
    }

    /**
     * DictionaryVO
     */
    public DictionaryVO() {
    }


    /**
     * @param code
     * @param name
     */
    public DictionaryVO(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Gets code
     *
     * @return value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets name
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
