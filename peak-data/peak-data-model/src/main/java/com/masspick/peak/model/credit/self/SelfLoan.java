package com.masspick.peak.model.credit.self;

import java.util.Date;

/**
 * self_loan
 * 信贷交易信息明细-贷款
 */
public class SelfLoan {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 本金余额
     */
    private Double principalBalance;

    /**
     * 剩余还款期数
     */
    private Integer remainRepaymentPeriod;

    /**
     * 本月应还款
     */
    private Double monthRepaymentFee;

    /**
     * 应还款日
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
     * 逾期31-60天未还本金
     */
    private Double unpaidPrincipalFeeOne;

    /**
     * 逾期61-90天未还本金
     */
    private Double unpaidPrincipalFeeTwo;

    /**
     * 逾期91-180天未还本金
     */
    private Double unpaidPrincipalFeeThree;

    /**
     * 逾期180天以上未还本金
     */
    private Double unpaidPrincipalFeeFour;

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
     * 贷款金额
     */
    private Double loanAmount;

    /**
     * 贷款类型
     */
    private String loanType;

    /**
     * 担保
     */
    private String guarantee;

    /**
     * 贷款期数
     */
    private Integer loanPeriod;

    /**
     * 还款方式
     */
    private String replyMethod;

    /**
     * 到期时间
     */
    private Date expirationTime;

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
    private Integer classify;

    /**
     * 正常；逾期：已还清；销户
     */
    private String state;

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
     * 本金余额
     *
     * @return principal_balance 本金余额
     */
    public Double getPrincipalBalance() {
        return principalBalance;
    }

    /**
     * 本金余额
     *
     * @param principalBalance 本金余额
     */
    public void setPrincipalBalance(Double principalBalance) {
        this.principalBalance = principalBalance;
    }

    /**
     * 剩余还款期数
     *
     * @return remain_repayment_period 剩余还款期数
     */
    public Integer getRemainRepaymentPeriod() {
        return remainRepaymentPeriod;
    }

    /**
     * 剩余还款期数
     *
     * @param remainRepaymentPeriod 剩余还款期数
     */
    public void setRemainRepaymentPeriod(Integer remainRepaymentPeriod) {
        this.remainRepaymentPeriod = remainRepaymentPeriod;
    }

    /**
     * 本月应还款
     *
     * @return month_repayment_fee 本月应还款
     */
    public Double getMonthRepaymentFee() {
        return monthRepaymentFee;
    }

    /**
     * 本月应还款
     *
     * @param monthRepaymentFee 本月应还款
     */
    public void setMonthRepaymentFee(Double monthRepaymentFee) {
        this.monthRepaymentFee = monthRepaymentFee;
    }

    /**
     * 应还款日
     *
     * @return repayment_time 应还款日
     */
    public Date getRepaymentTime() {
        return repaymentTime;
    }

    /**
     * 应还款日
     *
     * @param repaymentTime 应还款日
     */
    public void setRepaymentTime(Date repaymentTime) {
        this.repaymentTime = repaymentTime;
    }

    /**
     * 本月实际还款
     *
     * @return real_month_repayment_fee 本月实际还款
     */
    public Double getRealMonthRepaymentFee() {
        return realMonthRepaymentFee;
    }

    /**
     * 本月实际还款
     *
     * @param realMonthRepaymentFee 本月实际还款
     */
    public void setRealMonthRepaymentFee(Double realMonthRepaymentFee) {
        this.realMonthRepaymentFee = realMonthRepaymentFee;
    }

    /**
     * 最近一次还款日期
     *
     * @return last_repayment_time 最近一次还款日期
     */
    public Date getLastRepaymentTime() {
        return lastRepaymentTime;
    }

    /**
     * 最近一次还款日期
     *
     * @param lastRepaymentTime 最近一次还款日期
     */
    public void setLastRepaymentTime(Date lastRepaymentTime) {
        this.lastRepaymentTime = lastRepaymentTime;
    }

    /**
     * 当前逾期次数
     *
     * @return overdue_count 当前逾期次数
     */
    public Integer getOverdueCount() {
        return overdueCount;
    }

    /**
     * 当前逾期次数
     *
     * @param overdueCount 当前逾期次数
     */
    public void setOverdueCount(Integer overdueCount) {
        this.overdueCount = overdueCount;
    }

    /**
     * 当前逾期金额
     *
     * @return overdue_fee 当前逾期金额
     */
    public Double getOverdueFee() {
        return overdueFee;
    }

    /**
     * 当前逾期金额
     *
     * @param overdueFee 当前逾期金额
     */
    public void setOverdueFee(Double overdueFee) {
        this.overdueFee = overdueFee;
    }

    /**
     * 逾期31-60天未还本金
     *
     * @return unpaid_principal_fee_one 逾期31-60天未还本金
     */
    public Double getUnpaidPrincipalFeeOne() {
        return unpaidPrincipalFeeOne;
    }

    /**
     * 逾期31-60天未还本金
     *
     * @param unpaidPrincipalFeeOne 逾期31-60天未还本金
     */
    public void setUnpaidPrincipalFeeOne(Double unpaidPrincipalFeeOne) {
        this.unpaidPrincipalFeeOne = unpaidPrincipalFeeOne;
    }

    /**
     * 逾期61-90天未还本金
     *
     * @return unpaid_principal_fee_two 逾期61-90天未还本金
     */
    public Double getUnpaidPrincipalFeeTwo() {
        return unpaidPrincipalFeeTwo;
    }

    /**
     * 逾期61-90天未还本金
     *
     * @param unpaidPrincipalFeeTwo 逾期61-90天未还本金
     */
    public void setUnpaidPrincipalFeeTwo(Double unpaidPrincipalFeeTwo) {
        this.unpaidPrincipalFeeTwo = unpaidPrincipalFeeTwo;
    }

    /**
     * 逾期91-180天未还本金
     *
     * @return unpaid_principal_fee_three 逾期91-180天未还本金
     */
    public Double getUnpaidPrincipalFeeThree() {
        return unpaidPrincipalFeeThree;
    }

    /**
     * 逾期91-180天未还本金
     *
     * @param unpaidPrincipalFeeThree 逾期91-180天未还本金
     */
    public void setUnpaidPrincipalFeeThree(Double unpaidPrincipalFeeThree) {
        this.unpaidPrincipalFeeThree = unpaidPrincipalFeeThree;
    }

    /**
     * 逾期180天以上未还本金
     *
     * @return unpaid_principal_fee_four 逾期180天以上未还本金
     */
    public Double getUnpaidPrincipalFeeFour() {
        return unpaidPrincipalFeeFour;
    }

    /**
     * 逾期180天以上未还本金
     *
     * @param unpaidPrincipalFeeFour 逾期180天以上未还本金
     */
    public void setUnpaidPrincipalFeeFour(Double unpaidPrincipalFeeFour) {
        this.unpaidPrincipalFeeFour = unpaidPrincipalFeeFour;
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
     *
     * @return reply_record 还款记录 / / / / / / / / / / / / / / / / / / * N N N N 1
     */
    public String getReplyRecord() {
        return replyRecord;
    }

    /**
     * 还款记录 / / / / / / / / / / / / / / / / / / * N N N N 1
     *
     * @param replyRecord 还款记录 / / / / / / / / / / / / / / / / / / * N N N N 1
     */
    public void setReplyRecord(String replyRecord) {
        this.replyRecord = replyRecord == null ? null : replyRecord.trim();
    }

    /**
     * 放款时间
     *
     * @return loan_time 放款时间
     */
    public Date getLoanTime() {
        return loanTime;
    }

    /**
     * 放款时间
     *
     * @param loanTime 放款时间
     */
    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    /**
     * 机构
     *
     * @return institution 机构
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * 机构
     *
     * @param institution 机构
     */
    public void setInstitution(String institution) {
        this.institution = institution == null ? null : institution.trim();
    }

    /**
     * 贷款金额
     *
     * @return loan_amount 贷款金额
     */
    public Double getLoanAmount() {
        return loanAmount;
    }

    /**
     * 贷款金额
     *
     * @param loanAmount 贷款金额
     */
    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * 贷款类型
     *
     * @return loan_type 贷款类型
     */
    public String getLoanType() {
        return loanType;
    }

    /**
     * 贷款类型
     *
     * @param loanType 贷款类型
     */
    public void setLoanType(String loanType) {
        this.loanType = loanType == null ? null : loanType.trim();
    }

    /**
     * 担保
     *
     * @return guarantee 担保
     */
    public String getGuarantee() {
        return guarantee;
    }

    /**
     * 担保
     *
     * @param guarantee 担保
     */
    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee == null ? null : guarantee.trim();
    }

    /**
     * 贷款期数
     *
     * @return loan_period 贷款期数
     */
    public Integer getLoanPeriod() {
        return loanPeriod;
    }

    /**
     * 贷款期数
     *
     * @param loanPeriod 贷款期数
     */
    public void setLoanPeriod(Integer loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    /**
     * 还款方式
     *
     * @return reply_method 还款方式
     */
    public String getReplyMethod() {
        return replyMethod;
    }

    /**
     * 还款方式
     *
     * @param replyMethod 还款方式
     */
    public void setReplyMethod(String replyMethod) {
        this.replyMethod = replyMethod == null ? null : replyMethod.trim();
    }

    /**
     * 到期时间
     *
     * @return expiration_time 到期时间
     */
    public Date getExpirationTime() {
        return expirationTime;
    }

    /**
     * 到期时间
     *
     * @param expirationTime 到期时间
     */
    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    /**
     * 截止时间
     *
     * @return record_date 截止时间
     */
    public Date getRecordDate() {
        return recordDate;
    }

    /**
     * 截止时间
     *
     * @param recordDate 截止时间
     */
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    /**
     * 贷款描述
     *
     * @return desc 贷款描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 贷款描述
     *
     * @param desc 贷款描述
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     *
     * @return classify 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     */
    public Integer getClassify() {
        return classify;
    }

    /**
     * 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     *
     * @param classify 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     */
    public void setClassify(Integer classify) {
        this.classify = classify;
    }

    /**
     * 正常；逾期：已还清；销户
     *
     * @return state 正常；逾期：已还清；销户
     */
    public String getState() {
        return state;
    }

    /**
     * 正常；逾期：已还清；销户
     *
     * @param state 正常；逾期：已还清；销户
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}
