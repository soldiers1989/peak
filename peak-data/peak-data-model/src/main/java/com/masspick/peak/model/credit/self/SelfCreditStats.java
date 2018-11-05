package com.masspick.peak.model.credit.self;

import java.util.Date;

/**
 * self_credit_stats
 * 信用提示
 */
public class SelfCreditStats {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 住房贷款笔数
     */
    private Integer houseLoanCount;

    /**
     * 其他贷款笔数
     */
    private Integer otherLoanCount;

    /**
     * 首笔贷款发放月份
     */
    private Date firstLoanDate;

    /**
     * 贷记卡账户数
     */
    private Integer debitCardCount;

    /**
     * 首张贷记卡发卡月份
     */
    private Date firstDebitCardDate;

    /**
     * 准贷记卡账户数
     */
    private Integer semiDebitCardCount;

    /**
     * 首张准贷记卡发卡月份
     */
    private Date fistSemiDebitCardDate;

    /**
     * 本人声明数目
     */
    private Integer declareCount;

    /**
     * 异议标注数目
     */
    private Integer abnormalCount;

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
     * 住房贷款笔数
     *
     * @return house_loan_count 住房贷款笔数
     */
    public Integer getHouseLoanCount() {
        return houseLoanCount;
    }

    /**
     * 住房贷款笔数
     *
     * @param houseLoanCount 住房贷款笔数
     */
    public void setHouseLoanCount(Integer houseLoanCount) {
        this.houseLoanCount = houseLoanCount;
    }

    /**
     * 其他贷款笔数
     *
     * @return other_loan_count 其他贷款笔数
     */
    public Integer getOtherLoanCount() {
        return otherLoanCount;
    }

    /**
     * 其他贷款笔数
     *
     * @param otherLoanCount 其他贷款笔数
     */
    public void setOtherLoanCount(Integer otherLoanCount) {
        this.otherLoanCount = otherLoanCount;
    }

    /**
     * 首笔贷款发放月份
     *
     * @return first_loan_date 首笔贷款发放月份
     */
    public Date getFirstLoanDate() {
        return firstLoanDate;
    }

    /**
     * 首笔贷款发放月份
     *
     * @param firstLoanDate 首笔贷款发放月份
     */
    public void setFirstLoanDate(Date firstLoanDate) {
        this.firstLoanDate = firstLoanDate;
    }

    /**
     * 贷记卡账户数
     *
     * @return debit_card_count 贷记卡账户数
     */
    public Integer getDebitCardCount() {
        return debitCardCount;
    }

    /**
     * 贷记卡账户数
     *
     * @param debitCardCount 贷记卡账户数
     */
    public void setDebitCardCount(Integer debitCardCount) {
        this.debitCardCount = debitCardCount;
    }

    /**
     * 首张贷记卡发卡月份
     *
     * @return first_debit_card_date 首张贷记卡发卡月份
     */
    public Date getFirstDebitCardDate() {
        return firstDebitCardDate;
    }

    /**
     * 首张贷记卡发卡月份
     *
     * @param firstDebitCardDate 首张贷记卡发卡月份
     */
    public void setFirstDebitCardDate(Date firstDebitCardDate) {
        this.firstDebitCardDate = firstDebitCardDate;
    }

    /**
     * 准贷记卡账户数
     *
     * @return semi_debit_card_count 准贷记卡账户数
     */
    public Integer getSemiDebitCardCount() {
        return semiDebitCardCount;
    }

    /**
     * 准贷记卡账户数
     *
     * @param semiDebitCardCount 准贷记卡账户数
     */
    public void setSemiDebitCardCount(Integer semiDebitCardCount) {
        this.semiDebitCardCount = semiDebitCardCount;
    }

    /**
     * 首张准贷记卡发卡月份
     *
     * @return fist_semi_debit_card_date 首张准贷记卡发卡月份
     */
    public Date getFistSemiDebitCardDate() {
        return fistSemiDebitCardDate;
    }

    /**
     * 首张准贷记卡发卡月份
     *
     * @param fistSemiDebitCardDate 首张准贷记卡发卡月份
     */
    public void setFistSemiDebitCardDate(Date fistSemiDebitCardDate) {
        this.fistSemiDebitCardDate = fistSemiDebitCardDate;
    }

    /**
     * 本人声明数目
     *
     * @return declare_count 本人声明数目
     */
    public Integer getDeclareCount() {
        return declareCount;
    }

    /**
     * 本人声明数目
     *
     * @param declareCount 本人声明数目
     */
    public void setDeclareCount(Integer declareCount) {
        this.declareCount = declareCount;
    }

    /**
     * 异议标注数目
     *
     * @return abnormal_count 异议标注数目
     */
    public Integer getAbnormalCount() {
        return abnormalCount;
    }

    /**
     * 异议标注数目
     *
     * @param abnormalCount 异议标注数目
     */
    public void setAbnormalCount(Integer abnormalCount) {
        this.abnormalCount = abnormalCount;
    }
}
