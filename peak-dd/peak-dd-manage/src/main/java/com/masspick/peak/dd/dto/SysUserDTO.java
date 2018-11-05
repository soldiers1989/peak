package com.masspick.peak.dd.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * SysUserDTO
 */
public class SysUserDTO {

    /**
     * 主键id
     */
    private String id;

    /**
     * 员工账号
     */
    private String account;

    /**
     * name
     */
    private String name;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 所属部门id
     */
    private String departmentId;

    /**
     * 所属部门名称
     */
    private String departmentName;

    /**
     * 岗位名称
     */
    private String jobName;

    /**
     * 职级
     */
    private String occupationClass;

    /**
     * 状态（0-禁用 1-启用）
     */
    private Integer status;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
     * Gets account
     *
     * @return value of account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account account
     */
    public void setAccount(String account) {
        this.account = account;
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
     * Gets departmentId
     *
     * @return value of departmentId
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId departmentId
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * Gets departmentName
     *
     * @return value of departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName departmentName
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Gets jobName
     *
     * @return value of jobName
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * @param jobName jobName
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * Gets occupationClass
     *
     * @return value of occupationClass
     */
    public String getOccupationClass() {
        return occupationClass;
    }

    /**
     * @param occupationClass occupationClass
     */
    public void setOccupationClass(String occupationClass) {
        this.occupationClass = occupationClass;
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
}
