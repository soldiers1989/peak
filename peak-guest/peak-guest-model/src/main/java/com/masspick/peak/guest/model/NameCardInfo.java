package com.masspick.peak.guest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.masspick.peak.guest.model.base.BaseEntity;

import java.math.BigDecimal;

/**
 * NameCardInfo
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NameCardInfo extends BaseEntity {

    /**
     * 公司名称
     */
    private String etpName;

    /**
     * 法人
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
     * 名片上传地址
     */
    private String nameUrl;

    /**
     * 职位
     */
    private String position;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 网站
     */
    private String website;

    /**
     * 固定电话
     */
    private String phone;

    /**
     *  微信的openid
     */
    private String openId;

    /**
     * 删除标记 0 未删除 1 已删除
     */
    private String delFlag;

    /**
     *  企业评分
     */
    private String score;

    /**
     * qq
     */
    private String qq;

    /**
     *   信用等级
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
     * Gets nameUrl
     *
     * @return value of nameUrl
     */
    public String getNameUrl() {
        return nameUrl;
    }

    /**
     * @param nameUrl nameUrl
     */
    public void setNameUrl(String nameUrl) {
        this.nameUrl = nameUrl;
    }

    /**
     * Gets position
     *
     * @return value of position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position position
     */
    public void setPosition(String position) {
        this.position = position;
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
     * Gets email
     *
     * @return value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets website
     *
     * @return value of website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Gets phone
     *
     * @return value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
     * Gets qq
     *
     * @return value of qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq qq
     */
    public void setQq(String qq) {
        this.qq = qq;
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
