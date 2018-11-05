package com.masspick.peak.dd.model;

import com.masspick.peak.dd.model.vo.BaseEntity;

/**
 * Created by admin on 2018/5/18 0018.
 */
public class TemplateControl extends BaseEntity {

    /**
     * id
     */
    private String id;

    /**
     * templateId
     */
    private String templateId;

    /**
     * controlId
     */
    private String controlId;

    /**
     * groupName
     */
    private String groupName;

    /**
     * groupSeq
     */
    private Integer groupSeq;

    /**
     * groupKey
     */
    private String groupKey;

    /**
     * controlSeq
     */
    private Integer controlSeq;

    /**
     * controlKey
     */
    private String controlKey;

    /**
     * controlShowName
     */
    private String controlShowName;

    /**
     * require
     */
    private String require;

    /**
     * placeInfo
     */
    private String placeInfo;

    /**
     * Gets placeInfo
     *
     * @return value of placeInfo
     */
    public String getPlaceInfo() {
        return placeInfo;
    }

    /**
     * @param placeInfo
     */
    public void setPlaceInfo(String placeInfo) {
        this.placeInfo = placeInfo;
    }

    /**
     * Gets controlKey
     *
     * @return value of controlKey
     */
    public String getControlKey() {
        return controlKey;
    }

    /**
     * @param controlKey
     */
    public void setControlKey(String controlKey) {
        this.controlKey = controlKey;
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
     * Gets controlShowName
     *
     * @return value of controlShowName
     */
    public String getControlShowName() {
        return controlShowName;
    }

    /**
     * @param controlShowName
     */
    public void setControlShowName(String controlShowName) {
        this.controlShowName = controlShowName;
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
     * Gets templateId
     *
     * @return value of templateId
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * @param templateId
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * Gets controlId
     *
     * @return value of controlId
     */
    public String getControlId() {
        return controlId;
    }

    /**
     * @param controlId
     */
    public void setControlId(String controlId) {
        this.controlId = controlId;
    }

    /**
     * Gets groupName
     *
     * @return value of groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
     * Gets controlSeq
     *
     * @return value of controlSeq
     */
    public Integer getControlSeq() {
        return controlSeq;
    }

    /**
     * @param controlSeq
     */
    public void setControlSeq(Integer controlSeq) {
        this.controlSeq = controlSeq;
    }

    /**
     * Gets require
     *
     * @return value of require
     */
    public String getRequire() {
        return require;
    }

    /**
     * @param require
     */
    public void setRequire(String require) {
        this.require = require;
    }
}
