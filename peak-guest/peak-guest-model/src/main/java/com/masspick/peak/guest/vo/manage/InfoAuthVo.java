package com.masspick.peak.guest.vo.manage;

import java.util.Date;

/**
 *  信息采集授权分页查询展示对象
 */
public class InfoAuthVo {

    /**
     *  id
     */
    private String id;

    /**
     *  公司名称
     */
    private String etpName;

    /**
     *  授权书编号
     */
    private String infoAuthNum;

    /**
     *  更新日期
     */
    private Date updateDate;

    /**
     *  企业授权上传地址
     */
    private String authUrl;

    /**
     *  人证合照上传地址
     */
    private String bodyUrl;

    /**
     *  控制人授权上传地址
     */
    private String controllerUrl;

    /**
     *  注册手机号
     */
    private String regMobile;

    /**
     * Gets id
     *
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
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
     * Gets updateDate
     *
     * @return value of updateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
     * Gets regMobile
     *
     * @return value of regMobile
     */
    public String getRegMobile() {
        return regMobile;
    }

    /**
     * @param regMobile regMobile
     */
    public void setRegMobile(String regMobile) {
        this.regMobile = regMobile;
    }
}
