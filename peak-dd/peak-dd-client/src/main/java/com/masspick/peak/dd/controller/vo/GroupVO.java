package com.masspick.peak.dd.controller.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/5/23 0023.
 */
public class GroupVO {

    /**
     * label
     */
    private String label;

    /**
     * groupKey
     */
    private String groupKey;

    /**
     * groupSeq
     */
    private Integer groupSeq;

    /**
     * controlList
     */
    private List<ControlVO> controlList = new ArrayList<>();

    /**
     * @param groupVO
     * @param map
     */
    public void transfer(GroupVO groupVO, Map<String, Object> map) {
        groupVO.setLabel((String) map.get("group_name"));
        groupVO.setGroupKey((String) map.get("group_key"));
        groupVO.setGroupSeq((Integer) map.get("group_seq"));
    }

    /**
     * Gets groupSeq
     *
     * @return value of groupSeq
     */
    public Integer getGroupSeq() {
        return groupSeq;
    }

    /**
     * @param groupSeq
     */
    public void setGroupSeq(Integer groupSeq) {
        this.groupSeq = groupSeq;
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

    /**
     * Gets groupKey
     *
     * @return value of groupKey
     */
    public String getGroupKey() {
        return groupKey;
    }

    /**
     * @param groupKey
     */
    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    /**
     * Gets controlList
     *
     * @return value of controlList
     */
    public List<ControlVO> getControlList() {
        return controlList;
    }

    /**
     * @param controlList
     */
    public void setControlList(List<ControlVO> controlList) {
        this.controlList = controlList;
    }
}
