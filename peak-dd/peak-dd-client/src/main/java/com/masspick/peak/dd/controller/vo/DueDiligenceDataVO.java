package com.masspick.peak.dd.controller.vo;


import com.masspick.peak.dd.model.DueDilData;

import java.util.List;

/**
 * Created by admin on 2018/5/23 0023.
 */
public class DueDiligenceDataVO {

    /**
     * taskId
     */
    private String taskId;

    /**
     * templateId
     */
    private String templateId;

    /**
     * operate
     */
    private String operate;

    /**
     * data
     */
    private List<DueDilData> data;

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
     * Gets data
     *
     * @return value of data
     */
    public List<DueDilData> getData() {
        return data;
    }

    /**
     * @param data
     */
    public void setData(List<DueDilData> data) {
        this.data = data;
    }

    /**
     * Gets operate
     *
     * @return value of operate
     */
    public String getOperate() {
        return operate;
    }

    /**
     * @param operate
     */
    public void setOperate(String operate) {
        this.operate = operate;
    }
}
