package com.masspick.peak.guest.model;


import com.masspick.peak.guest.model.base.BaseEntity;

import java.math.BigDecimal;

/**
 * PreCredit
 */
public class PreCredit extends BaseEntity {


    /**
     *  公司名称
     */
    private String etpName;

    /**
     * 信用码
     */
    private String creditCode;

    /**
     * 法人名称
     */
    private String legalName;

    /**
     * 移动电话
     */
    private String mobile;

    /**
     * 贷款额度
     */
    private BigDecimal loanLimit;

    /**
     *  状态标记 0：未通过认证 1:已通过认证
     */
    private String status;

    /**
     * 地址
     */
    private String address;

    /**
     *  微信对应的open_id
     */
    private String openId;

    /**
     *  原因
     */
    private String reason;

    /**
     *  删除标记 0 未删除 1 已删除
     */
    private String delFlag;

    /**
     *  企业评分
     */
    private String score;

    /**
     *  信用等级
     */
    private String creditLevel;

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
     * Gets loanLimit
     *
     * @return value of loanLimit
     */
    public BigDecimal getLoanLimit() {
        return loanLimit;
    }

    /**
     * @param loanLimit loanLimit
     */
    public void setLoanLimit(BigDecimal loanLimit) {
        this.loanLimit = loanLimit;
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
     * Gets address
     *
     * @return value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets openId
     *
     * @return value of openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId openId
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * Gets reason
     *
     * @return value of reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Gets delFlag
     *
     * @return value of delFlag
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * @param delFlag delFlag
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * Gets score
     *
     * @return value of score
     */
    public String getScore() {
        return score;
    }

    /**
     * @param score score
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * Gets creditLevel
     *
     * @return value of creditLevel
     */
    public String getCreditLevel() {
        return creditLevel;
    }

    /**
     * @param creditLevel creditLevel
     */
    public void setCreditLevel(String creditLevel) {
        this.creditLevel = creditLevel;
    }
}
