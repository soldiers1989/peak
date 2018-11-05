package com.masspick.peak.model;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * TaskJson
 */
public class TaskJson implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * jsonObject
     */
    private JSONObject jsonObject;

    /**
     * isClaim
     */
    private Boolean isClaim;

    /**
     * Gets jsonObject
     *
     * @return value of jsonObject
     */
    public JSONObject getJsonObject() {
        return jsonObject;
    }

    /**
     * @param jsonObject
     */
    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    /**
     * Gets isClaim
     *
     * @return value of isClaim
     */
    public Boolean getClaim() {
        return isClaim;
    }

    /**
     * @param isClaim
     */
    public void setClaim(Boolean claim) {
        isClaim = claim;
    }
}
