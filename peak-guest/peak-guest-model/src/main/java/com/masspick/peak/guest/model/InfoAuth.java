package com.masspick.peak.guest.model;


import com.masspick.peak.guest.model.base.BaseEntity;

import javax.validation.constraints.NotEmpty;

/**
 * InfoAuth
 */
public class InfoAuth extends BaseEntity {


    /**
     *  企业资质认证id
     */
    @NotEmpty(message = "企业资质认证id不能为空")
    private String etpCerId;

    /**
     *   用户id
     */
    private String userId;

    /**
     *   公司名称
     */
    @NotEmpty(message = "公司名称不能为空")
    private String etpName;

    /**
     *   授权书编号
     */
    @NotEmpty(message = "授权书编号不能为空")
    private String infoAuthNum;

    /**
     *   法人授权地址
     */
    @NotEmpty(message = "法人授权地址不能为空")
    private String authUrl;

    /**
     *  合同与本人合照上传地址
     */
    @NotEmpty(message = "合同与本人合照上传地址不能为空")
    private String bodyUrl;

    /**
     * 大股东授权上传地址
     */
    @NotEmpty(message = "大股东授权上传地址不能为空")
    private String controllerUrl;

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
}
