package com.masspick.peak.dd.model.bo;


import com.masspick.peak.dd.model.DueTask;

/**
 * Created by admin on 2018/5/25 0025.
 */
public class DueTaskBO extends DueTask {

    /**
     * templateName
     */
    private String templateName;

    /**
     * Gets templateName
     *
     * @return value of templateName
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * @param templateName
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
