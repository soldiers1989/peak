package com.masspick.peak.dd.model;

import java.util.Date;

/**
 * Created by admin on 2018/5/29 0029.
 * 任务统计表
 */
public class TaskCount {
    /**
     * id
     */
    private String id;

    /**
     * 当天新增订单数
     */
    private Integer dayAddTask;

    /**
     * 当天完成订单数
     */
    private Integer dayFinishTask;

    /**
     * 累积完成订单数
     */
    private Integer accTask;

    /**
     * 总订单数
     */
    private Integer accFinishTask;

    /**
     * createDate
     */
    private Date createDate;

    /**
     * updateDate
     */
    private Date updateDate;

    /**
     * TaskCount
     */
    public TaskCount() {
    }

    /**
     * @param id
     * @param dayAddTask
     * @param dayFinishTask
     * @param accTask
     * @param accFinishTask
     * @param createDate
     * @param updateDate
     */
    public TaskCount(String id, Integer dayAddTask, Integer dayFinishTask, Integer accTask, Integer accFinishTask,
                     Date createDate, Date updateDate) {
        this.id = id;
        this.dayAddTask = dayAddTask;
        this.dayFinishTask = dayFinishTask;
        this.accTask = accTask;
        this.accFinishTask = accFinishTask;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    /**
     * Gets id
     *
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets dayFinishTask
     *
     * @return value of dayFinishTask
     */
    public Integer getDayFinishTask() {
        return dayFinishTask;
    }

    /**
     * @param dayFinishTask
     */
    public void setDayFinishTask(Integer dayFinishTask) {
        this.dayFinishTask = dayFinishTask;
    }

    /**
     * Gets dayAddTask
     *
     * @return value of dayAddTask
     */
    public Integer getDayAddTask() {
        return dayAddTask;
    }

    /**
     * @param dayAddTask
     */
    public void setDayAddTask(Integer dayAddTask) {
        this.dayAddTask = dayAddTask;
    }

    /**
     * Gets accTask
     *
     * @return value of accTask
     */
    public Integer getAccTask() {
        return accTask;
    }

    /**
     * @param accTask
     */
    public void setAccTask(Integer accTask) {
        this.accTask = accTask;
    }

    /**
     * Gets accFinishTask
     *
     * @return value of accFinishTask
     */
    public Integer getAccFinishTask() {
        return accFinishTask;
    }

    /**
     * @param accFinishTask
     */
    public void setAccFinishTask(Integer accFinishTask) {
        this.accFinishTask = accFinishTask;
    }

    /**
     * Gets createDate
     *
     * @return value of createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
