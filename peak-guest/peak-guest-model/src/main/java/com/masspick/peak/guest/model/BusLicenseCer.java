package com.masspick.peak.guest.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.masspick.peak.guest.model.base.BaseEntity;

import javax.validation.constraints.NotEmpty;

/**
 * BusLicenseCer
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusLicenseCer extends BaseEntity {

    /**
     * 认证id
     */
    private String cerId;

    /**
     * 公司名称
     */
    @NotEmpty(message = "公司名称不能为空")
    private String etpName;

    /**
     * 信用代码
     */
    @NotEmpty(message = "统一信用代码不能为空")
    private String creditCode;

    /**
     * 法人姓名
     */
    @NotEmpty(message = "营业执照法人姓名不能为空")
    private String legalName;

    /**
     * 营业执照上传地址
     */
    private String busUrl;

    /**
     * 状态  0.未认证  1.认证通过  2.认证失败
     */
    private String status;

    /**
     * 类型
     */
    private String type;

    /**
     * 地址
     */
    private String address;

    /**
     * 注册资本
     */
    private String regCap;

    /**
     * 注册日期
     */
    private String regDate;

    /**
     * 营业期限
     */
    private String busTerm;

    /**
     * 营业范围
     */
    private String busScope;

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
     * Gets busUrl
     *
     * @return value of busUrl
     */
    public String getBusUrl() {
        return busUrl;
    }

    /**
     * @param busUrl busUrl
     */
    public void setBusUrl(String busUrl) {
        this.busUrl = busUrl;
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
     * Gets type
     *
     * @return value of type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
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
     * Gets regCap
     *
     * @return value of regCap
     */
    public String getRegCap() {
        return regCap;
    }

    /**
     * @param regCap regCap
     */
    public void setRegCap(String regCap) {
        this.regCap = regCap;
    }

    /**
     * Gets regDate
     *
     * @return value of regDate
     */
    public String getRegDate() {
        return regDate;
    }

    /**
     * @param regDate regDate
     */
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    /**
     * Gets busTerm
     *
     * @return value of busTerm
     */
    public String getBusTerm() {
        return busTerm;
    }

    /**
     * @param busTerm busTerm
     */
    public void setBusTerm(String busTerm) {
        this.busTerm = busTerm;
    }

    /**
     * Gets busScope
     *
     * @return value of busScope
     */
    public String getBusScope() {
        return busScope;
    }

    /**
     * @param busScope busScope
     */
    public void setBusScope(String busScope) {
        this.busScope = busScope;
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

}
