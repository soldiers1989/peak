package com.masspick.peak.dd.controller.vo;


import com.masspick.peak.service.dto.SysDictionaryDTO;

import java.util.List;

/**
 * Created by admin on 2018/5/23 0023.
 */
public class DicVO {
    /**
     * id
     */
    private String id;

    /**
     * value
     */
    private String value;

    /**
     * label
     */
    private String label;

    /**
     * @param dicVOS
     * @param sysDictionaryList
     */
    public static void transfer(List<DicVO> dicVOS, List<SysDictionaryDTO> sysDictionaryList) {
        for (SysDictionaryDTO sysDictionary : sysDictionaryList) {
            DicVO dicVO = new DicVO();
            dicVO.setId(sysDictionary.getCode());
            dicVO.setValue(sysDictionary.getName());
            dicVO.setLabel(sysDictionary.getName());
            dicVOS.add(dicVO);
        }
    }

    /**
     * Gets id
     *
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets value
     *
     * @return value of value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets label
     *
     * @return value of label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }
}
