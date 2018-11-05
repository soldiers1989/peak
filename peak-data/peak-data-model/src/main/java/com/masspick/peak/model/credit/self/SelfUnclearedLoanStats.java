package com.masspick.peak.model.credit.self;

/**
 * self_uncleared_loan_stats
 * 未结清贷款信息汇总
 */
public class SelfUnclearedLoanStats {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 贷款法人机构数
     */
    private Integer loanCorporationCount;

    /**
     * 贷款机构数
     */
    private Integer loanInstitutionCount;

    /**
     * 笔数
     */
    private Integer count;

    /**
     * 合同总额
     */
    private Double totalFee;

    /**
     * 余额
     */
    private Double overFee;

    /**
     * 最近6个月平均应还款
     */
    private Double averageRepayment;

    /**
     * id
     *
     * @return id id
     */
    public String getId() {
        return id;
    }

    /**
     * id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 征信报告id
     *
     * @return report_id 征信报告id
     */
    public String getReportId() {
        return reportId;
    }

    /**
     * 征信报告id
     *
     * @param reportId 征信报告id
     */
    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    /**
     * 贷款法人机构数
     *
     * @return loan_corporation_count 贷款法人机构数
     */
    public Integer getLoanCorporationCount() {
        return loanCorporationCount;
    }

    /**
     * 贷款法人机构数
     *
     * @param loanCorporationCount 贷款法人机构数
     */
    public void setLoanCorporationCount(Integer loanCorporationCount) {
        this.loanCorporationCount = loanCorporationCount;
    }

    /**
     * 贷款机构数
     *
     * @return loan_institution_count 贷款机构数
     */
    public Integer getLoanInstitutionCount() {
        return loanInstitutionCount;
    }

    /**
     * 贷款机构数
     *
     * @param loanInstitutionCount 贷款机构数
     */
    public void setLoanInstitutionCount(Integer loanInstitutionCount) {
        this.loanInstitutionCount = loanInstitutionCount;
    }

    /**
     * 笔数
     *
     * @return count 笔数
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 笔数
     *
     * @param count 笔数
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 合同总额
     *
     * @return total_fee 合同总额
     */
    public Double getTotalFee() {
        return totalFee;
    }

    /**
     * 合同总额
     *
     * @param totalFee 合同总额
     */
    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * 余额
     *
     * @return over_fee 余额
     */
    public Double getOverFee() {
        return overFee;
    }

    /**
     * 余额
     *
     * @param overFee 余额
     */
    public void setOverFee(Double overFee) {
        this.overFee = overFee;
    }

    /**
     * 最近6个月平均应还款
     *
     * @return average_repayment 最近6个月平均应还款
     */
    public Double getAverageRepayment() {
        return averageRepayment;
    }

    /**
     * 最近6个月平均应还款
     *
     * @param averageRepayment 最近6个月平均应还款
     */
    public void setAverageRepayment(Double averageRepayment) {
        this.averageRepayment = averageRepayment;
    }
}
