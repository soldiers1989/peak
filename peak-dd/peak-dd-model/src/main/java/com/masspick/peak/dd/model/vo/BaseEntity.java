package com.masspick.peak.dd.model.vo;


import java.util.Date;

/**
 * Created by Administrator on 2017/7/24 0024.
 * 基础属性
 */
public class BaseEntity {
    /**
     * 创建时间
     */
    //@JsonIgnore
    private Date createTime;

    /**
     * 更新时间
     */
    //@JsonIgnore
    private Date updateTime;

    /**
     * 创建者
     */
    //@JsonIgnore
    private String creator;

    /**
     * 更新者
     */
    //@JsonIgnore
    private String updater;

    /**
     * Gets createTime
     *
     * @return value of createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * Gets updateTime
     *
     * @return value of updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * Gets creator
     *
     * @return value of creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * Gets updater
     *
     * @return value of updater
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * @param updater
     */
    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
