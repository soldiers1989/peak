package com.masspick.peak.resource.vo;

import javax.validation.constraints.NotNull;

/**
 * 员工管理查询对象
 */
public class UserFindVo {

    /**
     * 员工账号
     */
    private String account;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 应用状态
     */
    private Integer status;

    /**
     * 所在部门
     */
    private String departmentId;

    /**
     * 页码
     */
    @NotNull(message = "页码不能为空")
    private Integer pageNum;

    /**
     * 条数
     */
    @NotNull(message = "条数不能为空")
    private Integer pageSize;

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
        return "UserFindVo{"
                + "account='" + account + '\''
                + ", name='" + name + '\''
                + ", mobile='" + mobile + '\''
                + ", status=" + status
                + ", departmentId='" + departmentId + '\''
                + ", pageNum=" + pageNum
                + ", pageSize=" + pageSize
                + '}';
    }
}
