package com.masspick.peak.guest.model;

import com.masspick.peak.guest.model.base.BaseEntity;

/**
 * UserAuth
 */
public class EtpCer extends BaseEntity {

    /**
     *   认证最后状态  0 认证失败 1 认证成功
     */
    private String status;

    /**
     *   失败原因
     */
    private String reason;

    /**
     *  公司名称
     */
    private String etpName;

    /**
     *  用户id
     */
    private String userId;

    /**
     *  法人姓名
     */
    private String legalName;

    /**
     *  手机号
     */
    private String mobile;

    /**
     *  授权编号
     */
    private String infoAuthNum;

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
     * Gets userId
     *
     * @return value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * Gets infoAuthNum
     *
     * @return value of infoAuthNum
     */
    public String getInfoAuthNum() {
        return infoAuthNum;
    }

    /**
     * @param infoAuthNum infoAuthNum
     */
    public void setInfoAuthNum(String infoAuthNum) {
        this.infoAuthNum = infoAuthNum;
    }
}
