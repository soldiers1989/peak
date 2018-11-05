package com.masspick.peak.guest.controller.vo;

import java.util.Date;

/**
 * 还款明细对象
 */
public class LoanInfo {

    /**
     *  订单号
     */
    private String no;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 公司名称
     */
    private String etpName;

    /**
     *  贷款金额
     */
    private String loanAmount;

    /**
     * 贷款期限
     */
    private String loanTerm;

    /**
     *  应还利息
     */
    private String repayCapitalTotal;

    /**
     *  应还本金
     */
    private String repayAccountTotal;

    /**
     *  申请日期
     */
    private Date applyDate;

    /**
     *  还款日期
     */
    private Date loanDate;

    /**
     * Gets no
     *
     * @return value of no
     */
    public String getNo() {
        return no;
    }

    /**
     * @param no no
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * Gets productName
     *
     * @return value of productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Gets etpName
     *
     * @return value of etpName
     */
    public String getEtpName() {
        return etpName;
    }

    /**
     * @param etpName etpName
     */
    public void setEtpName(String etpName) {
        this.etpName = etpName;
    }

    /**
     * Gets loanAmount
     *
     * @return value of loanAmount
     */
    public String getLoanAmount() {
        return loanAmount;
    }

    /**
     * @param loanAmount loanAmount
     */
    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * Gets loanTerm
     *
     * @return value of loanTerm
     */
    public String getLoanTerm() {
        return loanTerm;
    }

    /**
     * @param loanTerm loanTerm
     */
    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    /**
     * Gets repayCapitalTotal
     *
     * @return value of repayCapitalTotal
     */
    public String getRepayCapitalTotal() {
        return repayCapitalTotal;
    }

    /**
     * @param repayCapitalTotal repayCapitalTotal
     */
    public void setRepayCapitalTotal(String repayCapitalTotal) {
        this.repayCapitalTotal = repayCapitalTotal;
    }

    /**
     * Gets repayAccountTotal
     *
     * @return value of repayAccountTotal
     */
    public String getRepayAccountTotal() {
        return repayAccountTotal;
    }

    /**
     * @param repayAccountTotal repayAccountTotal
     */
    public void setRepayAccountTotal(String repayAccountTotal) {
        this.repayAccountTotal = repayAccountTotal;
    }

    /**
     * Gets applyDate
     *
     * @return value of applyDate
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * @param applyDate applyDate
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * Gets loanDate
     *
     * @return value of loanDate
     */
    public Date getLoanDate() {
        return loanDate;
    }

    /**
     * @param loanDate loanDate
     */
    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }
}
