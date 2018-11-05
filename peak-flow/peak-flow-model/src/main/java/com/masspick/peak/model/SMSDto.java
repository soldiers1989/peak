package com.masspick.peak.model;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * SMSDto
 */
public class SMSDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * mobile
     */
    private String mobile;

    /**
     * tempId
     */
    private Integer tempId;

    /**
     * params
     */
    private ArrayList<String> params;

    /**
     * Gets mobile
     *
     * @return value of mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets tempId
     *
     * @return value of tempId
     */
    public Integer getTempId() {
        return tempId;
    }

    /**
     * @param tempId
     */
    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    /**
     * Gets params
     *
     * @return value of params
     */
    public ArrayList<String> getParams() {
        return params;
    }

    /**
     * @param params
     */
    public void setParams(ArrayList<String> params) {
        this.params = params;
    }
}
