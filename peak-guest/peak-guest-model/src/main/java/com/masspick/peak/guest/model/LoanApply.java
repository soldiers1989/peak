package com.masspick.peak.guest.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.masspick.peak.guest.model.base.BaseEntity;

import java.util.Date;

/**
 * LoanApply
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanApply extends BaseEntity {

    /**
     * 产品id
     */
    private String productId;

    /**
     *  用户id
     */
    private String userId;

    /**
     * 公司名称
     */
    private String etpName;

    /**
     * 合同号
     */
    private String no;

    /**
     *  申请金额
     */
    private Integer amount;

    /**
     * 贷款期限
     */
    private Integer term;

    /**
     * 财务联系人
     */
    private String financialContact;


    /**
     * 财务联系人电话
     */
    private String contactMobile;

    /**
     *  企业资质认证id
     */
    private String etpCerId;

    /**
     * 信息采集授权id
     */
    private String infoAuthId;

    /**
     * 授权书编号
     */
    private String infoAuthNum;

    /**
     * 企业授权地址
     */
    private String authUrl;

    /**
     *  本人拍照授权地址
     */
    private String bodyUrl;

    /**
     *  控制人授权地址
     */
    private String controllerUrl;

    /**
     *  预约时间
     */
    private Date appointTime;

    /**
     *  预约确认时间
     */
    private Date appointConfirmTime;

    /**
     *  终止原因
     */
    private String reason;

    /**
     *  放款时间
     */
    private Date loanDate;

    /**
     *  申请单状态 0-处理中  1-终止 2-完成
     */
    private String status;

    /**
     * Gets productId
     *
     * @return value of productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
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
     * Gets no
     *
     * @return value of no
     */
    public String getNo() {
        return no;
    }

    /**
     * @param no no
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * Gets amount
     *
     * @return value of amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @param amount amount
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * Gets term
     *
     * @return value of term
     */
    public Integer getTerm() {
        return term;
    }

    /**
     * @param term term
     */
    public void setTerm(Integer term) {
        this.term = term;
    }

    /**
     * Gets financialContact
     *
     * @return value of financialContact
     */
    public String getFinancialContact() {
        return financialContact;
    }

    /**
     * @param financialContact financialContact
     */
    public void setFinancialContact(String financialContact) {
        this.financialContact = financialContact;
    }

    /**
     * Gets contactMobile
     *
     * @return value of contactMobile
     */
    public String getContactMobile() {
        return contactMobile;
    }

    /**
     * @param contactMobile contactMobile
     */
    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    /**
     * Gets etpCerId
     *
     * @return value of etpCerId
     */
    public String getEtpCerId() {
        return etpCerId;
    }

    /**
     * @param etpCerId etpCerId
     */
    public void setEtpCerId(String etpCerId) {
        this.etpCerId = etpCerId;
    }

    /**
     * Gets infoAuthId
     *
     * @return value of infoAuthId
     */
    public String getInfoAuthId() {
        return infoAuthId;
    }

    /**
     * @param infoAuthId infoAuthId
     */
    public void setInfoAuthId(String infoAuthId) {
        this.infoAuthId = infoAuthId;
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

    /**
     * Gets authUrl
     *
     * @return value of authUrl
     */
    public String getAuthUrl() {
        return authUrl;
    }

    /**
     * @param authUrl authUrl
     */
    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    /**
     * Gets bodyUrl
     *
     * @return value of bodyUrl
     */
    public String getBodyUrl() {
        return bodyUrl;
    }

    /**
     * @param bodyUrl bodyUrl
     */
    public void setBodyUrl(String bodyUrl) {
        this.bodyUrl = bodyUrl;
    }

    /**
     * Gets controllerUrl
     *
     * @return value of controllerUrl
     */
    public String getControllerUrl() {
        return controllerUrl;
    }

    /**
     * @param controllerUrl controllerUrl
     */
    public void setControllerUrl(String controllerUrl) {
        this.controllerUrl = controllerUrl;
    }

    /**
     * Gets appointTime
     *
     * @return value of appointTime
     */
    public Date getAppointTime() {
        return appointTime;
    }

    /**
     * @param appointTime appointTime
     */
    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    /**
     * Gets appointConfirmTime
     *
     * @return value of appointConfirmTime
     */
    public Date getAppointConfirmTime() {
        return appointConfirmTime;
    }

    /**
     * @param appointConfirmTime appointConfirmTime
     */
    public void setAppointConfirmTime(Date appointConfirmTime) {
        this.appointConfirmTime = appointConfirmTime;
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
     * Gets loanDate
     *
     * @return value of loanDate
     */
    public Date getLoanDate() {
        return loanDate;
    }

    /**
     * @param loanDate loanDate
     */
    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }
}
