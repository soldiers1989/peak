package com.masspick.peak.resource.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masspick.peak.common.util.SequenceUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 员工
 */
public class SysUser {


    /**
     * 员工姓名
     */
    /**
     * 主键id
     */
    private String id;

    /**
     * 员工账号
     */
    @NotEmpty(message = "员工账号不能为空")
    private String account;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * name
     */
    @NotEmpty(message = "员工姓名不能为空")
    private String name;

    /**
     * 手机号码
     */
    @NotEmpty(message = "员工手机号不能为空")
    private String mobile;

    /**
     * 所属部门id
     */
    @NotEmpty(message = "所属部门id不能为空")
    private String departmentId;

    /**
     * 所属部门名称
     */
    @NotEmpty(message = "所属部门名称不能为空")
    private String departmentName;

    /**
     * 岗位名称
     */
    @NotEmpty(message = "岗位名称不能为空")
    private String jobName;

    /**
     * 职级
     */
    @NotEmpty(message = "职级不能为空")
    private String occupationClass;

    /**
     * 状态（0-禁用 1-启用）
     */
    @NotNull(message = "应用状态不能为空")
    private Integer status;

    /**
     * 创建时间
     */
    @JsonIgnore
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * preInsert
     */
    public void preInsert() {
        this.id = SequenceUtils.getUUID();
        this.createDate = new Date();
        this.updateDate = new Date();
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
     * Gets password
     *
     * @return value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
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
