package com.masspick.peak.guest.vo.manage;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * EtpCerInvitePageVo
 */
public class EtpCerInvitePageVo {

    /**
     * etpName
     */
    private String etpName;

    /**
     * legalName
     */
    private String legalName;

    /**
     * mobile
     */
    private String mobile;

    /**
     * createDate
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;

    /**
     * createMonth
     */
    private String createMonth;

    /**
     * regCap
     */
    private String regCap;


    /**
     * regDate
     */
    private String regDate;

    /**
     *
     * @return String
     */
    public String getRegCap() {
        return regCap;
    }

    /**
     *
     * @param regCap regCap
     */
    public void setRegCap(String regCap) {
        this.regCap = regCap;
    }

    /**
     *
     * @return String
     */
    public String getRegDate() {
        return regDate;
    }

    /**
     *
     * @param regDate regDate
     */
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    /**
     *
     * @return String
     */
    public String getEtpName() {
        return etpName;
    }

    /**
     *
     * @param etpName etpName
     */
    public void setEtpName(String etpName) {
        this.etpName = etpName;
    }

    /**
     *
     * @return String
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     *
     * @param legalName legalName
     */
    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    /**
     *
     * @return String
     */
    public String getMobile() {
        return mobile;
    }

    /**
     *
     * @param mobile mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     *
     * @return Date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *
     * @param createDate createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     *
     * @return String
     */
    public String getCreateMonth() {
        return createMonth;
    }

    /**
     *
     * @param createMonth createMonth
     */
    public void setCreateMonth(String createMonth) {
        this.createMonth = createMonth;
    }
}
