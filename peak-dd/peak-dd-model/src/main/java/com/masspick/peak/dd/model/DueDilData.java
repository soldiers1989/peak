package com.masspick.peak.dd.model;


import com.masspick.peak.dd.model.vo.BaseEntity;

/**
 * Created by admin on 2018/5/18 0018.
 *
 * 尽调数据
 */
public class DueDilData extends BaseEntity {

    /**
     * id
     */
    private String id;

    /**
     * 任务id
     */
    private String taskId;

    /**
     * 模板id
     */
    private String templateId;

    /**
     * 组名
     */
    private String groupName;

    /**
     * 组名
     */
    private String groupKey;

    /**
     * 控件id
     */
    private String controlId;

    /**
     * 控件key
     */
    private String controlKey;

    /**
     * 分组排序
     */
    private Integer groupSeq;

    /**
     * 控件排序
     */
    private Integer controlSeq;

    /**
     * 值
     */
    private String value;

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
     * Gets taskId
     *
     * @return value of taskId
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * @param taskId
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
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
}
