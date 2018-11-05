package com.masspick.peak.guest.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * LoanEtpVo
 */
public class LoanEtpVo {

    /**
     * statusName
     */
    private String statusName;

    /**
     * status
     */
    private String status;

    /**
     * etpName
     */
    private String etpName;

    /**
     * amount
     */
    private String amount;

    /**
     * term
     */
    private String term;

    /**
     * appointTime
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date appointTime;

    /**
     * createMonth
     */
    private String createMonth;

    /**
     * flowId
     */
    private String flowId;

    /**
     * 申请时间 需求上说 只要求显示年月日
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateMonth() {
        return createMonth;
    }

    public void setCreateMonth(String createMonth) {
        this.createMonth = createMonth;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getEtpName() {
        return etpName;
    }

    public void setEtpName(String etpName) {
        this.etpName = etpName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }
}
