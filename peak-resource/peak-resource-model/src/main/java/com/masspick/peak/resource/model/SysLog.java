package com.masspick.peak.resource.model;

import java.util.Date;

/**
 * SysLog
 */
public class SysLog {

    /**
     * 主键
     */
    private String id;

    /**
     * 用户
     */
    private String userName;

    /**
     * 应用Key
     */
    private String appKey;

    /**
     * 日志
     */
    private String title;

    /**
     * 地址
     */
    private String url;

    /**
     * 参数
     */
    private String params;

    /**
     * 日志时间
     */
    private Date createTime;

    /**
     * Gets id
     *
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets userName
     *
     * @return value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets appKey
     *
     * @return value of appKey
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * @param appKey appKey
     */
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    /**
     * Gets title
     *
     * @return value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets url
     *
     * @return value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets params
     *
     * @return value of params
     */
    public String getParams() {
        return params;
    }

    /**
     * @param params params
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * Gets createTime
     *
     * @return value of createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
