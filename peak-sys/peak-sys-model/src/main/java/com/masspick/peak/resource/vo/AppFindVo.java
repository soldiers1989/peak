package com.masspick.peak.resource.vo;

import javax.validation.constraints.NotNull;

/**
 *  应用查询对象
 */
public class AppFindVo {

    /**
     *  应用名称
     */
    private String appName;

    /**
     *  应用id
     */
    private String appId;

    /**
     *  应用状态
     */
    private Integer status;

    /**
     * 页码
     */
    @NotNull(message = "页码不能为空")
    private Integer pageNum;

    /**
     *  条数
     */
    @NotNull(message = "条数不能为空")
    private Integer pageSize;

    /**
     * Gets appName
     *
     * @return value of appName
     */
    public String getAppName() {
        return appName;
    }

    /**
     * @param appName appName
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * Gets appId
     *
     * @return value of appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * Gets status
     *
     * @return value of status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Gets pageNum
     *
     * @return value of pageNum
     */
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * @param pageNum pageNum
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * Gets pageSize
     *
     * @return value of pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "AppFindVo{"
                + "appName='" + appName + '\''
                + ", appId='" + appId + '\''
                + ", status=" + status
                + ", pageNum=" + pageNum
                + ", pageSize=" + pageSize
                + '}';
    }
}
