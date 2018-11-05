package com.masspick.peak.guest.model;


import com.masspick.peak.guest.model.base.BaseEntity;

import javax.validation.constraints.NotEmpty;

/**
 * ControllerCer
 */
public class ControllerCer extends BaseEntity {

    /**
     *   姓名
     */
    @NotEmpty(message = "控制人身份证姓名不能为空")
    private String name;

    /**
     *  性别 1男 2女
     */
    @NotEmpty(message = "控制人身份证性别不能为空")
    private String sex;

    /**
     *  民族
     */
    @NotEmpty(message = "控制人身份证民族不能为空")
    private String nation;

    /**
     *  出生日期
     */
    @NotEmpty(message = "控制人身份证出生日期不能为空")
    private String birth;

    /**
     *  地址
     */
    @NotEmpty(message = "控制人身份证地址不能为空")
    private String address;

    /**
     *  身份证号码
     */
    @NotEmpty(message = "控制人身份证号码不能为空")
    private String idCode;

    /**
     *  颁发机构
     */
    @NotEmpty(message = "法人身份证颁发机构不能为空")
    private String issuingAgency;

    /**
     *  有效期限
     */
    @NotEmpty(message = "法人身份证有效期限不能为空")
    private String validityPeriod;

    /**
     *  认证id
     */
    private String cerId;

    /**
     *  身份证正面上传地址
     */
    @NotEmpty(message = "控制人身份证正面上传地址不能为空")
    private String idUrl;

    /**
     * 身份证反面上传地址
     */
    @NotEmpty(message = "控制人身份证正面上传地址不能为空")
    private String idBackUrl;

    /**
     *   手机号码
     */
    @NotEmpty(message = "控制人手机号码不能为空")
    private String mobile;

    /**
     * 状态
     */
    private String status;

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
     * Gets sex
     *
     * @return value of sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Gets nation
     *
     * @return value of nation
     */
    public String getNation() {
        return nation;
    }

    /**
     * @param nation nation
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * Gets birth
     *
     * @return value of birth
     */
    public String getBirth() {
        return birth;
    }

    /**
     * @param birth birth
     */
    public void setBirth(String birth) {
        this.birth = birth;
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
     * Gets idCode
     *
     * @return value of idCode
     */
    public String getIdCode() {
        return idCode;
    }

    /**
     * @param idCode idCode
     */
    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    /**
     * Gets idUrl
     *
     * @return value of idUrl
     */
    public String getIdUrl() {
        return idUrl;
    }

    /**
     * @param idUrl idUrl
     */
    public void setIdUrl(String idUrl) {
        this.idUrl = idUrl;
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
     * Gets cerId
     *
     * @return value of cerId
     */
    public String getCerId() {
        return cerId;
    }

    /**
     * @param cerId cerId
     */
    public void setCerId(String cerId) {
        this.cerId = cerId;
    }

    /**
     * Gets issuingAgency
     *
     * @return value of issuingAgency
     */
    public String getIssuingAgency() {
        return issuingAgency;
    }

    /**
     * @param issuingAgency issuingAgency
     */
    public void setIssuingAgency(String issuingAgency) {
        this.issuingAgency = issuingAgency;
    }

    /**
     * Gets validityPeriod
     *
     * @return value of validityPeriod
     */
    public String getValidityPeriod() {
        return validityPeriod;
    }

    /**
     * @param validityPeriod validityPeriod
     */
    public void setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    /**
     * Gets idBackUrl
     *
     * @return value of idBackUrl
     */
    public String getIdBackUrl() {
        return idBackUrl;
    }

    /**
     * @param idBackUrl idBackUrl
     */
    public void setIdBackUrl(String idBackUrl) {
        this.idBackUrl = idBackUrl;
    }
}
