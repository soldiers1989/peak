package com.masspick.peak.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * TaskDetail
 */
public class TaskDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * taskId
     */
    private String taskId;

    /**
     * actName
     */
    private String actName;

    /**
     * assignee
     */
    private String assignee;

    /**
     * createTime
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * endTime
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 一天HOUR_24小时
     */
    private static final int HOUR_24 = 24;

    /**
     * SECOND_60
     */
    private static final int SECOND_60 = 60;

    /**
     * MINUTE_60
     */
    private static final int MINUTE_60 = 60;

    /**
     * MILLISECOND_1000
     */
    private static final int MILLISECOND_1000 = 1000;


    /**
     * hour
     */
    private String hour;

    /**
     * status
     */
    private String status;

    /**
     * processInsId
     */
    private String processInsId;

    /**
     * Gets taskId
     *
     * @return value of taskId
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * @param taskId
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

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
     * Gets assignee
     *
     * @return value of assignee
     */
    public String getAssignee() {
        return assignee;
    }

    /**
     * @param assignee
     */
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    /**
     * Gets createTime
     *
     * @return value of createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
     * Gets processInsId
     *
     * @return value of processInsId
     */
    public String getProcessInsId() {
        return processInsId;
    }

    /**
     * @param processInsId
     */
    public void setProcessInsId(String processInsId) {
        this.processInsId = processInsId;
    }

    /**
     * @return String
     */
    public String getHour() {

        if (endTime != null && createTime != null) {

            //计算时间
            long diff;

            // 一天的毫秒数
            long nd = MILLISECOND_1000 * HOUR_24 * MINUTE_60 * SECOND_60;

            // 一小时的毫秒数
            long nh = MILLISECOND_1000 * SECOND_60 * MINUTE_60;

            // 一分钟的毫秒数
            long nm = MILLISECOND_1000 * SECOND_60;
            long day = 0;
            long hourInner = 0;
            long min = 0;
            diff = endTime.getTime() - createTime.getTime();

            // 计算差多少天
            day = diff / nd;

            // 计算差多少小时
            hourInner = diff % nd / nh + day * HOUR_24;

            // 计算差多少分钟
            min = diff % nd % nh / nm + day * HOUR_24 * MINUTE_60;

            return day + "天" + (hourInner - day * HOUR_24) + "小时"
                    + (min - day * HOUR_24 * MINUTE_60) + "分钟";
        }
        return hour;
    }

    /**
     * @param hour
     */
    public void setHour(String hour) {
        this.hour = hour;
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
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
