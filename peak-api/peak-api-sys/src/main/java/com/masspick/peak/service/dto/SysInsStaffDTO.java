package com.masspick.peak.service.dto;

import java.util.Date;

/**
 * Created by admin on 2018/9/20 0020.
 */
public class SysInsStaffDTO {

    /**
     * id
     */
    private String id;

    /**
     * 人员姓名
     */
    private String name;

    /**
     * 人员编号
     */
    private String number;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 所属机构
     */
    private String institutionId;

    /**
     *  所属机构名称
     */
    private String institutionName;

    /**
     * 状态（0-禁用 1-启用）
     */
    private Integer status;

    /**
     * 二维码url
     */
    private String url;

    /**
     * 下载url
     */
    private String downloadUrl;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date updateDate;

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
     * Gets name
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets number
     *
     * @return value of number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Gets mobile
     *
     * @return value of mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets institutionId
     *
     * @return value of institutionId
     */
    public String getInstitutionId() {
        return institutionId;
    }

    /**
     * @param institutionId institutionId
     */
    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
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
     * Gets downloadUrl
     *
     * @return value of downloadUrl
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * @param downloadUrl downloadUrl
     */
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
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
     * Gets institutionName
     *
     * @return value of institutionName
     */
    public String getInstitutionName() {
        return institutionName;
    }

    /**
     * @param institutionName institutionName
     */
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
}
