package com.masspick.peak.guest.controller.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 *  申请贷款信息
 */
public class LoanApplyAddVo {

    /**
     * 产品id
     */
    @NotEmpty(message = "产品id不能为空")
    private String productId;

    /**
     *  企业认证id
     */
    @NotEmpty(message = "企业认证id不能为空")
    private String etpCerId;

    /**
     *  贷款金额
     */
    @NotNull(message = "贷款金额不能为空")
    private Integer amount;

    /**
     *  期限
     */
    @NotNull(message = "贷款期限不能为空")
    private Integer term;

    /**
     *  信息采集授权id
     */
    @NotEmpty(message = "信息采集授权id不能为空")
    private String infoAuthId;

    /**
     *  授权书编号
     */
    @NotEmpty(message = "授权书编号不能为空")
    private String infoAuthNum;

    /**
     * 企业授权上传地址
     */
    @NotEmpty(message = "企业授权上传地址不能为空")
    private String authUrl;

    /**
     *  合同和本人合照授权上传地址
     */
    @NotEmpty(message = "合同和本人合照授权上传地址不能为空")
    private String bodyUrl;

    /**
     *  控制人授权上传地址
     */
    @NotEmpty(message = "控制人授权上传地址上传地址不能为空")
    private String controllerUrl;

    /**
     *  法人征信上传地址
     */
    @NotNull(message = "法人征信上传地址不能为空")
    private List<String> controllerCreditUrls;

    /**
     *  企业征信上传地址
     */
    @NotNull(message = "企业征信上传地址不能为空")
    private List<String> corporateCreditUrls;

    /**
     * 预约时间
     */
    @NotNull(message = "预约时间不能为空")
    private Date appointTime;

    /**
     * 财务联系人
     */
    private String financialContact;

    /**
     *  联系人电话
     */
    private String contactMobile;

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
     * Gets controllerCreditUrls
     *
     * @return value of controllerCreditUrls
     */
    public List<String> getControllerCreditUrls() {
        return controllerCreditUrls;
    }

    /**
     * @param controllerCreditUrls controllerCreditUrls
     */
    public void setControllerCreditUrls(List<String> controllerCreditUrls) {
        this.controllerCreditUrls = controllerCreditUrls;
    }

    /**
     * Gets corporateCreditUrls
     *
     * @return value of corporateCreditUrls
     */
    public List<String> getCorporateCreditUrls() {
        return corporateCreditUrls;
    }

    /**
     * @param corporateCreditUrls corporateCreditUrls
     */
    public void setCorporateCreditUrls(List<String> corporateCreditUrls) {
        this.corporateCreditUrls = corporateCreditUrls;
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
}
