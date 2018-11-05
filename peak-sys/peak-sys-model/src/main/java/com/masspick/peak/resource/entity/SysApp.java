package com.masspick.peak.resource.entity;

import com.masspick.peak.common.util.SequenceUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 应用
 */
public class SysApp {

    /**
     * 主键id
     */
    private String id;

    /**
     * appid
     */
    private String appId;


    /**
     * appKey
     */
    private String appKey;


    /**
     * 应用名称
     */
    @NotEmpty(message = "应用名称不能为空")
    private String appName;


    /**
     * 域名或IP地址
     */
    @NotEmpty(message = "域名地址不能为空")
    private String appAddress;


    /**
     * 应用状态 0-禁用 1-启用
     */
    @NotNull(message = "应用状态不能为空")
    private Integer status;


    /**
     * 创建日期
     */
    private Date createDate;


    /**
     * 更细日期
     */
    private Date updateDate;


    /**
     * 应用描述
     */
    private String remark;


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
     * Gets appAddress
     *
     * @return value of appAddress
     */
    public String getAppAddress() {
        return appAddress;
    }

    /**
     * @param appAddress appAddress
     */
    public void setAppAddress(String appAddress) {
        this.appAddress = appAddress;
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
     * Gets createDate
     *
     * @return value of createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Gets updateDate
     *
     * @return value of updateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * Gets remark
     *
     * @return value of remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * asd
     */
    public void preInsert() {
        this.id = SequenceUtils.getUUID();
        this.appId = SequenceUtils.getUUID();
        this.appKey = SequenceUtils.getUUID();
        this.createDate = new Date();
        this.updateDate = new Date();
    }


    @Override
    public String toString() {
        return "SysApp{"
                + "id='" + id + '\''
                + ", appId='" + appId + '\''
                + ", appKey='" + appKey + '\''
                + ", appName='" + appName + '\''
                + ", appAddress='" + appAddress + '\''
                + ", status=" + status
                + ", createDate=" + createDate
                + ", updateDate=" + updateDate
                + ", remark='" + remark + '\''
                + '}';
    }
}

