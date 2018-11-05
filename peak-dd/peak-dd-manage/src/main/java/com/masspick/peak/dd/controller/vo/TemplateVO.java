package com.masspick.peak.dd.controller.vo;

import com.masspick.peak.dd.model.Template;

/**
 * Created by admin on 2018/5/18 0018.
 */
public class TemplateVO extends Template {
    /**
     * createDate
     */
    private String createDate;

    /**
     * updateDate
     */
    private String updateDate;

    /**
     * Gets createDate
     *
     * @return value of createDate
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * Gets updateDate
     *
     * @return value of updateDate
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
