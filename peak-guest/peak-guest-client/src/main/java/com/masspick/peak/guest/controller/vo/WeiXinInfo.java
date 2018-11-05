package com.masspick.peak.guest.controller.vo;

/**
 * Created by Administrator on 2018\7\13 0013.
 */
public class WeiXinInfo {

    /**
     * sessionKey
     */
    private String sessionKey;

    /**
     * openId
     */
    private String openId;

    /**
     * iv
     */
    private String iv;

    /**
     * Gets sessionKey
     * @return value of sessionKey
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * @param sessionKey sessionKey
     */
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    /**
     * Gets openId
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
     * Gets iv
     * @return value of iv
     */
    public String getIv() {
        return iv;
    }

    /**
     * @param iv iv
     */
    public void setIv(String iv) {
        this.iv = iv;
    }
}
