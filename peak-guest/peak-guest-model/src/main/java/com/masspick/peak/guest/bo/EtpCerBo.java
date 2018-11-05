package com.masspick.peak.guest.bo;


import javax.validation.constraints.NotNull;

/**
 * EtpCerBo
 */
public class EtpCerBo {

    /**
     *  注册手机号
     */
    private String regMobile;

    /**
     *  法人手机号
     */
    private String mobile;

    /**
     * 公司名称
     */
    private String etpName;

    /**
     * 法人姓名
     */
    private String legalName;

    /**
     * 统一社会信息代码
     */
    private String creditCode;

    /**
     * 认证状态
     */
    private String status;

    /**
     *  页码
     */
    @NotNull(message = "页码不能为空")
    private Integer pageNum;

    /**
     * 每页条数
     */
    @NotNull(message = "每页条数不能为空")
    private Integer pageSize;

    /**
     * Gets regMobile
     *
     * @return value of regMobile
     */
    public String getRegMobile() {
        return regMobile;
    }

    /**
     * @param regMobile regMobile
     */
    public void setRegMobile(String regMobile) {
        this.regMobile = regMobile;
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
     * Gets etpName
     *
     * @return value of etpName
     */
    public String getEtpName() {
        return etpName;
    }

    /**
     * @param etpName etpName
     */
    public void setEtpName(String etpName) {
        this.etpName = etpName;
    }

    /**
     * Gets legalName
     *
     * @return value of legalName
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * @param legalName legalName
     */
    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    /**
     * Gets creditCode
     *
     * @return value of creditCode
     */
    public String getCreditCode() {
        return creditCode;
    }

    /**
     * @param creditCode creditCode
     */
    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    /**
     * Gets status
     *
     * @return value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status status
     */
    public void setStatus(String status) {
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
}
