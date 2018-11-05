package com.masspick.peak.model.credit.self;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/14.
 * 个人贷款逾期
 */
public class SelfOverdue {

    /**
     * id
     */
    private  String id;

    /**
     * 贷款id
     */
    private String loanId;

    /**
     * 逾期日期（年/月）
     */
    private Date overdueDate;

    /**
     * 逾期月数
     */
    private Integer monthCount;

    /**
     * 逾期金额
     */
    private Double fee;

    /**
     * 逾期类型。1-贷款；2-贷记卡；3-准贷记卡
     */
    private Integer type;

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
     * Gets loanId
     *
     * @return value of loanId
     */
    public String getLoanId() {
        return loanId;
    }

    /**
     * @param loanId
     */
    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    /**
     * Gets overdueDate
     *
     * @return value of overdueDate
     */
    public Date getOverdueDate() {
        return overdueDate;
    }

    /**
     * @param overdueDate
     */
    public void setOverdueDate(Date overdueDate) {
        this.overdueDate = overdueDate;
    }

    /**
     * Gets monthCount
     *
     * @return value of monthCount
     */
    public Integer getMonthCount() {
        return monthCount;
    }

    /**
     * @param monthCount
     */
    public void setMonthCount(Integer monthCount) {
        this.monthCount = monthCount;
    }

    /**
     * Gets fee
     *
     * @return value of fee
     */
    public Double getFee() {
        return fee;
    }

    /**
     * @param fee
     */
    public void setFee(Double fee) {
        this.fee = fee;
    }

    /**
     * Gets type
     *
     * @return value of type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }
}
