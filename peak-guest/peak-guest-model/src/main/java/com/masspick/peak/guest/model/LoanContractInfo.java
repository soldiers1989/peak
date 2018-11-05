package com.masspick.peak.guest.model;

import java.util.Date;

/**
 *  贷款合同信息
 */
public class LoanContractInfo {

    /**
     *  主键id
     */
    private String id;

    /**
     *  loan_apply的id
     */
    private String loanId;

    /**
     *  批复金额
     */
    private Integer approvalAmount;

    /**
     *  批复期限
     */
    private Integer approvalTerm;

    /**
     * 贷款利率
     */
    private String loanRate;

    /**
     *  居间费率
     */
    private String serviceRate;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 偿还方式
     * @return
     */
    private String repayMethod;

    /**
     *  无参构造
     */
    public LoanContractInfo() {

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
     * Gets approvalAmount
     *
     * @return value of approvalAmount
     */
    public Integer getApprovalAmount() {
        return approvalAmount;
    }

    /**
     * @param approvalAmount approvalAmount
     */
    public void setApprovalAmount(Integer approvalAmount) {
        this.approvalAmount = approvalAmount;
    }

    /**
     * Gets approvalTerm
     *
     * @return value of approvalTerm
     */
    public Integer getApprovalTerm() {
        return approvalTerm;
    }

    /**
     * @param approvalTerm approvalTerm
     */
    public void setApprovalTerm(Integer approvalTerm) {
        this.approvalTerm = approvalTerm;
    }

    /**
     * Gets loanRate
     *
     * @return value of loanRate
     */
    public String getLoanRate() {
        return loanRate;
    }

    /**
     * @param loanRate loanRate
     */
    public void setLoanRate(String loanRate) {
        this.loanRate = loanRate;
    }

    /**
     * Gets serviceRate
     *
     * @return value of serviceRate
     */
    public String getServiceRate() {
        return serviceRate;
    }

    /**
     * @param serviceRate serviceRate
     */
    public void setServiceRate(String serviceRate) {
        this.serviceRate = serviceRate;
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
     * Gets repayMethod
     *
     * @return value of repayMethod
     */
    public String getRepayMethod() {
        return repayMethod;
    }

    /**
     * @param repayMethod repayMethod
     */
    public void setRepayMethod(String repayMethod) {
        this.repayMethod = repayMethod;
    }
}
