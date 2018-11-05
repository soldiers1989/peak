package com.masspick.peak.model;

import java.io.Serializable;
import java.util.Date;

/**
 * ActVo
 */
public class ActVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * actName
     */
    private String actName;

    /**
     * startTime
     */
    private Date startTime;

    /**
     * endTime
     */
    private Date endTime;

    /**
     * actType
     */
    private String actType;

    /**
     * Gets actName
     *
     * @return value of actName
     */
    public String getActName() {
        return actName;
    }

    /**
     * @param actName
     */
    public void setActName(String actName) {
        this.actName = actName;
    }

    /**
     * Gets startTime
     *
     * @return value of startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets endTime
     *
     * @return value of endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets actType
     *
     * @return value of actType
     */
    public String getActType() {
        return actType;
    }

    /**
     * @param actType
     */
    public void setActType(String actType) {
        this.actType = actType;
    }
}
