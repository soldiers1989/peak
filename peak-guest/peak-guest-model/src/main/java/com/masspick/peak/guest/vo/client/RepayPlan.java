package com.masspick.peak.guest.vo.client;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.masspick.peak.guest.model.base.BaseEntity;

import java.util.Date;

/**
 *  还款计划
 */
public class RepayPlan {

    /**
     * 期数
     */
    private Integer borrowTimes;

    /**
     * 应还款时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date repayTime;

    /**
     * 实还款时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date repayTimeYes;

    /**
     *  应还款总额
     */
    private Double repayAccountAll;

    /**
     * 实还款总额
     */
    private Double repayAccountAllYes;

    /**
     *  应还款利息
     */
    private Double repayAccountInterest;

    /**
     *  实还款利息
     */
    private Double repayAccountInterestYes;

    /**
     *  应还款本金
     */
    private Double repayAccountCapital;

    /**
     *  实还款本金
     */
    private Double repayAccountCapitalYes;

    /**
     * Gets borrowTimes
     *
     * @return value of borrowTimes
     */
    public Integer getBorrowTimes() {
        return borrowTimes;
    }

    /**
     * @param borrowTimes borrowTimes
     */
    public void setBorrowTimes(Integer borrowTimes) {
        this.borrowTimes = borrowTimes;
    }

    /**
     * Gets repayTime
     *
     * @return value of repayTime
     */
    public Date getRepayTime() {
        return repayTime;
    }

    /**
     * @param repayTime repayTime
     */
    public void setRepayTime(Date repayTime) {
        this.repayTime = repayTime;
    }

    /**
     * Gets repayTimeYes
     *
     * @return value of repayTimeYes
     */
    public Date getRepayTimeYes() {
        return repayTimeYes;
    }

    /**
     * @param repayTimeYes repayTimeYes
     */
    public void setRepayTimeYes(Date repayTimeYes) {
        this.repayTimeYes = repayTimeYes;
    }

    /**
     * Gets repayAccountAll
     *
     * @return value of repayAccountAll
     */
    public Double getRepayAccountAll() {
        return repayAccountAll;
    }

    /**
     * @param repayAccountAll repayAccountAll
     */
    public void setRepayAccountAll(Double repayAccountAll) {
        this.repayAccountAll = repayAccountAll;
    }

    /**
     * Gets repayAccountAllYes
     *
     * @return value of repayAccountAllYes
     */
    public Double getRepayAccountAllYes() {
        return repayAccountAllYes;
    }

    /**
     * @param repayAccountAllYes repayAccountAllYes
     */
    public void setRepayAccountAllYes(Double repayAccountAllYes) {
        this.repayAccountAllYes = repayAccountAllYes;
    }

    /**
     * Gets repayAccountInterest
     *
     * @return value of repayAccountInterest
     */
    public Double getRepayAccountInterest() {
        return repayAccountInterest;
    }

    /**
     * @param repayAccountInterest repayAccountInterest
     */
    public void setRepayAccountInterest(Double repayAccountInterest) {
        this.repayAccountInterest = repayAccountInterest;
    }

    /**
     * Gets repayAccountInterestYes
     *
     * @return value of repayAccountInterestYes
     */
    public Double getRepayAccountInterestYes() {
        return repayAccountInterestYes;
    }

    /**
     * @param repayAccountInterestYes repayAccountInterestYes
     */
    public void setRepayAccountInterestYes(Double repayAccountInterestYes) {
        this.repayAccountInterestYes = repayAccountInterestYes;
    }

    /**
     * Gets repayAccountCapital
     *
     * @return value of repayAccountCapital
     */
    public Double getRepayAccountCapital() {
        return repayAccountCapital;
    }

    /**
     * @param repayAccountCapital repayAccountCapital
     */
    public void setRepayAccountCapital(Double repayAccountCapital) {
        this.repayAccountCapital = repayAccountCapital;
    }

    /**
     * Gets repayAccountCapitalYes
     *
     * @return value of repayAccountCapitalYes
     */
    public Double getRepayAccountCapitalYes() {
        return repayAccountCapitalYes;
    }

    /**
     * @param repayAccountCapitalYes repayAccountCapitalYes
     */
    public void setRepayAccountCapitalYes(Double repayAccountCapitalYes) {
        this.repayAccountCapitalYes = repayAccountCapitalYes;
    }
}
