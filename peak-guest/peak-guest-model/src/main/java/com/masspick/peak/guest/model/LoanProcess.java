package com.masspick.peak.guest.model;

import java.util.Date;

/**
 * LoanProcess
 */
public class LoanProcess {


    /**
     * 实体编号（唯一标识）
     */
    private String id;

    /**
     * loan_apply的id
     */
    private String loanId;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 状态 0 已终止 1 申请成功 2 预约成功 3 签约放款中 4 已放款
     */
    private String status;


    /**
     * Gets id
     *
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id id
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
     * @param loanId loanId
     */
    public void setLoanId(String loanId) {
        this.loanId = loanId;
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
     * @param createDate createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
     * @param status status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoanProcess{"
                + "id='" + id + '\''
                + ", loanId='" + loanId + '\''
                + ", createDate=" + createDate
                + ", status='" + status + '\''
                + '}';
    }
}
