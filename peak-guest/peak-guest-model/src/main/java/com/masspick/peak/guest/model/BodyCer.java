package com.masspick.peak.guest.model;

import com.masspick.peak.guest.model.base.BaseEntity;

/**
 * BodyCer
 */
public class BodyCer extends BaseEntity {

    /**
     *   认证id
     */
    private String cerId;

    /**
     *  唇语视频上传地址
     */
    private String mediaUrl;

    /**
     *  唇语码
     */
    private String validate;

    /**
     *  状态 : 0 未认证  1 认证通过 2.认证失败
     */
    private String status;

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
     * Gets mediaUrl
     *
     * @return value of mediaUrl
     */
    public String getMediaUrl() {
        return mediaUrl;
    }

    /**
     * @param mediaUrl mediaUrl
     */
    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    /**
     * Gets validate
     *
     * @return value of validate
     */
    public String getValidate() {
        return validate;
    }

    /**
     * @param validate validate
     */
    public void setValidate(String validate) {
        this.validate = validate;
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
}
