package com.masspick.peak.guest.vo.client;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 还款明细
 */
public class RepayDetail {

    /**
     *  id
     */
    private String id;

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
    private Double repayInterestTotal;

    /**
     *  应还总额
     */
    private Double repayAccountTotal;

    /**
     *  申请日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date applyDate;

    /**
     *  放款日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date loanDate;

    /**
     *  还款计划
     */
    private List<RepayPlan> repayPlan;

    /**
     * Gets no
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
     * Gets repayInterestTotal
     *
     * @return value of repayInterestTotal
     */
    public Double getRepayInterestTotal() {
        return repayInterestTotal;
    }

    /**
     * @param repayInterestTotal repayInterestTotal
     */
    public void setRepayInterestTotal(Double repayInterestTotal) {
        this.repayInterestTotal = repayInterestTotal;
    }

    /**
     * Gets repayAccountTotal
     *
     * @return value of repayAccountTotal
     */
    public Double getRepayAccountTotal() {
        return repayAccountTotal;
    }

    /**
     * @param repayAccountTotal repayAccountTotal
     */
    public void setRepayAccountTotal(Double repayAccountTotal) {
        this.repayAccountTotal = repayAccountTotal;
    }

    /**
     * Gets repayPlan
     *
     * @return value of repayPlan
     */
    public List<RepayPlan> getRepayPlan() {
        return repayPlan;
    }

    /**
     * @param repayPlan repayPlan
     */
    public void setRepayPlan(List<RepayPlan> repayPlan) {
        this.repayPlan = repayPlan;
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
}
