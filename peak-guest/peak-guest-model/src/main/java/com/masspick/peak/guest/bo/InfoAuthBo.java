package com.masspick.peak.guest.bo;


import javax.validation.constraints.NotNull;

/**
 * InfoAuthBo
 */
public class InfoAuthBo {

    /**
     * 微信昵称
     */
    private String regMobile;

    /**
     * 公司名称
     */
    private String etpName;

    /**
     * 页码
     */
    @NotNull(message = "页码不能为空")
    private Integer pageSize;

    /**
     * 页数
     */
    @NotNull(message = "每页条数不能为空")
    private Integer pageNum;

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
}
