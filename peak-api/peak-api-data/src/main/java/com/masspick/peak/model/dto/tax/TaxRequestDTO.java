package com.masspick.peak.model.dto.tax;

import java.io.Serializable;

/**
 * 税务请求参数
 */
public class TaxRequestDTO implements Serializable {
    private static final long serialVersionUID = 4223554481088098411L;

    /**
     * 纳税人名称
     */
    private String cname;

    /**
     * 纳税人识别号
     */
    private String taxNo;

    /**
     * 纳税人所属行政区划
     */
    private String areaCode;

    /**
     * 企业法定代表人姓名
     */
    private String legalName;

    /**
     * 企业法定代表人证件号码
     */
    private String legalIdCard;

    /**
     * 企业法定代表人手机号码
     */
    private String mobile;

    /**
     * 查询时间起期
     */
    private String startDate;

    /**
     * 查询时间止期
     */
    private String endDate;

    /**
     * 授权书
     */
    private String file;

    /**
     * 渠道
     */
    private String channel;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 签名
     */
    private String sign;

    /**
     * Gets cname
     *
     * @return value of cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * @param cname
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    /**
     * Gets taxNo
     *
     * @return value of taxNo
     */
    public String getTaxNo() {
        return taxNo;
    }

    /**
     * @param taxNo
     */
    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    /**
     * Gets areaCode
     *
     * @return value of areaCode
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * @param areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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
     * @param legalName
     */
    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    /**
     * Gets legalIdCard
     *
     * @return value of legalIdCard
     */
    public String getLegalIdCard() {
        return legalIdCard;
    }

    /**
     * @param legalIdCard
     */
    public void setLegalIdCard(String legalIdCard) {
        this.legalIdCard = legalIdCard;
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
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets startDate
     *
     * @return value of startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets endDate
     *
     * @return value of endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets file
     *
     * @return value of file
     */
    public String getFile() {
        return file;
    }

    /**
     * @param file
     */
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * Gets channel
     *
     * @return value of channel
     */
    public String getChannel() {
        return channel;
    }

    /**
     * @param channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * Gets userName
     *
     * @return value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets sign
     *
     * @return value of sign
     */
    public String getSign() {
        return sign;
    }

    /**
     * @param sign
     */
    public void setSign(String sign) {
        this.sign = sign;
    }
}
