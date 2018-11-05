package com.masspick.peak.model.credit.self;

import java.util.Date;

/**
 * self_debit_card
 * 贷记卡
 */
public class SelfDebitCard {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 已用额度
     */
    private Double usedFee;

    /**
     * 最近6个月平均使用额度
     */
    private Double averageUsedFee;

    /**
     * 最大使用额度
     */
    private Double maxUsedFee;

    /**
     * 本月应还款
     */
    private Double monthRepaymentFee;

    /**
     * 账单日
     */
    private Date repaymentTime;

    /**
     * 本月实际还款
     */
    private Double realMonthRepaymentFee;

    /**
     * 最近一次还款日期
     */
    private Date lastRepaymentTime;

    /**
     * 当前逾期次数
     */
    private Integer overdueCount;

    /**
     * 当前逾期金额
     */
    private Double overdueFee;

    /**
     * 逾期记录开始时间
     */
    private Date overdueRecordStartDate;

    /**
     * 逾期记录结束时间
     */
    private Date overdueRecordEndDate;


    /**
     * 还款记录--开始时间
     */
    private Date replyRecordStartDate;

    /**
     * 还款记录--结束时间
     */
    private Date replyRecordEndDate;

    /**
     * 还款记录 / / / / / / / / / / / / / / / / / / * N N N N 1
     */
    private String replyRecord;

    /**
     * 放款时间
     */
    private Date loanTime;

    /**
     * 机构
     */
    private String institution;

    /**
     * 业务号
     */
    private String bussNo;

    /**
     * 授信额度
     */
    private Double creditLine;

    /**
     * 共享授信额度
     */
    private Double sharedCreditLine;

    /**
     * 担保
     */
    private String guarantee;

    /**
     * 截止时间
     */
    private Date recordDate;

    /**
     * 贷款描述
     */
    private String desc;

    /**
     * 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     */
    private String classify;

    /**
     * 正常；逾期：已还清；销户
     */
    private String state;

    /**
     * id
     * @return id id
     */
    public String getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 征信报告id
     * @return report_id 征信报告id
     */
    public String getReportId() {
        return reportId;
    }

    /**
     * 征信报告id
     * @param reportId 征信报告id
     */
    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    /**
     * 已用额度
     * @return used_fee 已用额度
     */
    public Double getUsedFee() {
        return usedFee;
    }

    /**
     * 已用额度
     * @param usedFee 已用额度
     */
    public void setUsedFee(Double usedFee) {
        this.usedFee = usedFee;
    }

    /**
     * 最近6个月平均使用额度
     * @return average_used_fee 最近6个月平均使用额度
     */
    public Double getAverageUsedFee() {
        return averageUsedFee;
    }

    /**
     * 最近6个月平均使用额度
     * @param averageUsedFee 最近6个月平均使用额度
     */
    public void setAverageUsedFee(Double averageUsedFee) {
        this.averageUsedFee = averageUsedFee;
    }

    /**
     * 最大使用额度
     * @return max_used_fee 最大使用额度
     */
    public Double getMaxUsedFee() {
        return maxUsedFee;
    }

    /**
     * 最大使用额度
     * @param maxUsedFee 最大使用额度
     */
    public void setMaxUsedFee(Double maxUsedFee) {
        this.maxUsedFee = maxUsedFee;
    }

    /**
     * 本月应还款
     * @return month_repayment_fee 本月应还款
     */
    public Double getMonthRepaymentFee() {
        return monthRepaymentFee;
    }

    /**
     * 本月应还款
     * @param monthRepaymentFee 本月应还款
     */
    public void setMonthRepaymentFee(Double monthRepaymentFee) {
        this.monthRepaymentFee = monthRepaymentFee;
    }

    /**
     * 账单日
     * @return repayment_time 账单日
     */
    public Date getRepaymentTime() {
        return repaymentTime;
    }

    /**
     * 账单日
     * @param repaymentTime 账单日
     */
    public void setRepaymentTime(Date repaymentTime) {
        this.repaymentTime = repaymentTime;
    }

    /**
     * 本月实际还款
     * @return real_month_repayment_fee 本月实际还款
     */
    public Double getRealMonthRepaymentFee() {
        return realMonthRepaymentFee;
    }

    /**
     * 本月实际还款
     * @param realMonthRepaymentFee 本月实际还款
     */
    public void setRealMonthRepaymentFee(Double realMonthRepaymentFee) {
        this.realMonthRepaymentFee = realMonthRepaymentFee;
    }

    /**
     * 最近一次还款日期
     * @return last_repayment_time 最近一次还款日期
     */
    public Date getLastRepaymentTime() {
        return lastRepaymentTime;
    }

    /**
     * 最近一次还款日期
     * @param lastRepaymentTime 最近一次还款日期
     */
    public void setLastRepaymentTime(Date lastRepaymentTime) {
        this.lastRepaymentTime = lastRepaymentTime;
    }

    /**
     * 当前逾期次数
     * @return overdue_count 当前逾期次数
     */
    public Integer getOverdueCount() {
        return overdueCount;
    }

    /**
     * 当前逾期次数
     * @param overdueCount 当前逾期次数
     */
    public void setOverdueCount(Integer overdueCount) {
        this.overdueCount = overdueCount;
    }

    /**
     * 当前逾期金额
     * @return overdue_fee 当前逾期金额
     */
    public Double getOverdueFee() {
        return overdueFee;
    }

    /**
     * 当前逾期金额
     * @param overdueFee 当前逾期金额
     */
    public void setOverdueFee(Double overdueFee) {
        this.overdueFee = overdueFee;
    }

    /**
     * Gets overdueRecordStartDate
     *
     * @return value of overdueRecordStartDate
     */
    public Date getOverdueRecordStartDate() {
        return overdueRecordStartDate;
    }

    /**
     * @param overdueRecordStartDate
     */
    public void setOverdueRecordStartDate(Date overdueRecordStartDate) {
        this.overdueRecordStartDate = overdueRecordStartDate;
    }

    /**
     * Gets overdueRecordEndDate
     *
     * @return value of overdueRecordEndDate
     */
    public Date getOverdueRecordEndDate() {
        return overdueRecordEndDate;
    }

    /**
     * @param overdueRecordEndDate
     */
    public void setOverdueRecordEndDate(Date overdueRecordEndDate) {
        this.overdueRecordEndDate = overdueRecordEndDate;
    }

    /**
     * Gets replyRecordStartDate
     *
     * @return value of replyRecordStartDate
     */
    public Date getReplyRecordStartDate() {
        return replyRecordStartDate;
    }

    /**
     * @param replyRecordStartDate
     */
    public void setReplyRecordStartDate(Date replyRecordStartDate) {
        this.replyRecordStartDate = replyRecordStartDate;
    }

    /**
     * Gets replyRecordEndDate
     *
     * @return value of replyRecordEndDate
     */
    public Date getReplyRecordEndDate() {
        return replyRecordEndDate;
    }

    /**
     * @param replyRecordEndDate
     */
    public void setReplyRecordEndDate(Date replyRecordEndDate) {
        this.replyRecordEndDate = replyRecordEndDate;
    }

    /**
     * 还款记录 / / / / / / / / / / / / / / / / / / * N N N N 1
     * @return reply_record 还款记录 / / / / / / / / / / / / / / / / / / * N N N N 1
     */
    public String getReplyRecord() {
        return replyRecord;
    }

    /**
     * 还款记录 / / / / / / / / / / / / / / / / / / * N N N N 1
     * @param replyRecord 还款记录 / / / / / / / / / / / / / / / / / / * N N N N 1
     */
    public void setReplyRecord(String replyRecord) {
        this.replyRecord = replyRecord == null ? null : replyRecord.trim();
    }

    /**
     * 放款时间
     * @return loan_time 放款时间
     */
    public Date getLoanTime() {
        return loanTime;
    }

    /**
     * 放款时间
     * @param loanTime 放款时间
     */
    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    /**
     * 机构
     * @return institution 机构
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * 机构
     * @param institution 机构
     */
    public void setInstitution(String institution) {
        this.institution = institution == null ? null : institution.trim();
    }

    /**
     * 业务号
     * @return buss_no 业务号
     */
    public String getBussNo() {
        return bussNo;
    }

    /**
     * 业务号
     * @param bussNo 业务号
     */
    public void setBussNo(String bussNo) {
        this.bussNo = bussNo == null ? null : bussNo.trim();
    }

    /**
     * 授信额度
     * @return credit_line 授信额度
     */
    public Double getCreditLine() {
        return creditLine;
    }

    /**
     * 授信额度
     * @param creditLine 授信额度
     */
    public void setCreditLine(Double creditLine) {
        this.creditLine = creditLine;
    }

    /**
     * 共享授信额度
     * @return shared_credit_line 共享授信额度
     */
    public Double getSharedCreditLine() {
        return sharedCreditLine;
    }

    /**
     * 共享授信额度
     * @param sharedCreditLine 共享授信额度
     */
    public void setSharedCreditLine(Double sharedCreditLine) {
        this.sharedCreditLine = sharedCreditLine;
    }

    /**
     * 担保
     * @return guarantee 担保
     */
    public String getGuarantee() {
        return guarantee;
    }

    /**
     * 担保
     * @param guarantee 担保
     */
    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee == null ? null : guarantee.trim();
    }

    /**
     * 截止时间
     * @return record_date 截止时间
     */
    public Date getRecordDate() {
        return recordDate;
    }

    /**
     * 截止时间
     * @param recordDate 截止时间
     */
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * 贷款描述
     * @return desc 贷款描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 贷款描述
     * @param desc 贷款描述
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     * @return classify 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     */
    public String getClassify() {
        return classify;
    }

    /**
     * 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     * @param classify 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     */
    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    /**
     * 正常；逾期：已还清；销户
     * @return state 正常；逾期：已还清；销户
     */
    public String getState() {
        return state;
    }

    /**
     * 正常；逾期：已还清；销户
     * @param state 正常；逾期：已还清；销户
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}
