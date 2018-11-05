package com.masspick.peak.model.credit.self;

import java.util.Date;

/**
 * self_house_fund
 * 住房公积金参缴记录
 */
public class SelfHouseFund {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 参缴地
     */
    private String city;

    /**
     * 参缴日期
     */
    private Date startDate;

    /**
     * 初缴月份
     */
    private Date firstPaymentMonth;

    /**
     * 缴至月份
     */
    private Date lastPaymentMonth;

    /**
     * 缴费状态
     */
    private String state;

    /**
     * 月缴存额
     */
    private Double monthPaymentFee;

    /**
     * 个人缴存比例
     */
    private Double selfRatio;

    /**
     * 单位缴存比例
     */
    private Double workUnitRatio;

    /**
     * 缴费单位
     */
    private String workUnit;

    /**
     * 更新时间
     */
    private Date updateTime;

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
     * Gets reportId
     *
     * @return value of reportId
     */
    public String getReportId() {
        return reportId;
    }

    /**
     * @param reportId
     */
    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    /**
     * Gets city
     *
     * @return value of city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets startDate
     *
     * @return value of startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets firstPaymentMonth
     *
     * @return value of firstPaymentMonth
     */
    public Date getFirstPaymentMonth() {
        return firstPaymentMonth;
    }

    /**
     * @param firstPaymentMonth
     */
    public void setFirstPaymentMonth(Date firstPaymentMonth) {
        this.firstPaymentMonth = firstPaymentMonth;
    }

    /**
     * Gets lastPaymentMonth
     *
     * @return value of lastPaymentMonth
     */
    public Date getLastPaymentMonth() {
        return lastPaymentMonth;
    }

    /**
     * @param lastPaymentMonth
     */
    public void setLastPaymentMonth(Date lastPaymentMonth) {
        this.lastPaymentMonth = lastPaymentMonth;
    }

    /**
     * Gets state
     *
     * @return value of state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets monthPaymentFee
     *
     * @return value of monthPaymentFee
     */
    public Double getMonthPaymentFee() {
        return monthPaymentFee;
    }

    /**
     * @param monthPaymentFee
     */
    public void setMonthPaymentFee(Double monthPaymentFee) {
        this.monthPaymentFee = monthPaymentFee;
    }

    /**
     * Gets selfRatio
     *
     * @return value of selfRatio
     */
    public Double getSelfRatio() {
        return selfRatio;
    }

    /**
     * @param selfRatio
     */
    public void setSelfRatio(Double selfRatio) {
        this.selfRatio = selfRatio;
    }

    /**
     * Gets workUnitRatio
     *
     * @return value of workUnitRatio
     */
    public Double getWorkUnitRatio() {
        return workUnitRatio;
    }

    /**
     * @param workUnitRatio
     */
    public void setWorkUnitRatio(Double workUnitRatio) {
        this.workUnitRatio = workUnitRatio;
    }

    /**
     * Gets workUnit
     *
     * @return value of workUnit
     */
    public String getWorkUnit() {
        return workUnit;
    }

    /**
     * @param workUnit
     */
    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    /**
     * Gets updateTime
     *
     * @return value of updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
