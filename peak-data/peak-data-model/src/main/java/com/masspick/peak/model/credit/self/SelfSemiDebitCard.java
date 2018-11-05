package com.masspick.peak.model.credit.self;

import java.util.Date;

/**
 * self_semi_debit_card
 * 准贷记卡
 */
public class SelfSemiDebitCard {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 共享额度
     */
    private Double sharedAmount;

    /**
     * 透支额度
     */
    private Double overdrawAmount;

    /**
     * 最近6个月平均透支余额
     */
    private Double averageOverdrawFee;

    /**
     * 最大透支额度
     */
    private Double maxOverdrawFee;

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
     * 透支180天以上未付余额
     */
    private Double overdrawUnpaidBalance;

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
     * 共享额度
     *
     * @return shared_amount 共享额度
     */
    public Double getSharedAmount() {
        return sharedAmount;
    }

    /**
     * 共享额度
     *
     * @param sharedAmount 共享额度
     */
    public void setSharedAmount(Double sharedAmount) {
        this.sharedAmount = sharedAmount;
    }

    /**
     * 透支额度
     *
     * @return overdraw_amount 透支额度
     */
    public Double getOverdrawAmount() {
        return overdrawAmount;
    }

    /**
     * 透支额度
     *
     * @param overdrawAmount 透支额度
     */
    public void setOverdrawAmount(Double overdrawAmount) {
        this.overdrawAmount = overdrawAmount;
    }

    /**
     * 最近6个月平均透支余额
     *
     * @return average_overdraw_fee 最近6个月平均透支余额
     */
    public Double getAverageOverdrawFee() {
        return averageOverdrawFee;
    }

    /**
     * 最近6个月平均透支余额
     *
     * @param averageOverdrawFee 最近6个月平均透支余额
     */
    public void setAverageOverdrawFee(Double averageOverdrawFee) {
        this.averageOverdrawFee = averageOverdrawFee;
    }

    /**
     * 最大透支额度
     *
     * @return max_overdraw_fee 最大透支额度
     */
    public Double getMaxOverdrawFee() {
        return maxOverdrawFee;
    }

    /**
     * 最大透支额度
     *
     * @param maxOverdrawFee 最大透支额度
     */
    public void setMaxOverdrawFee(Double maxOverdrawFee) {
        this.maxOverdrawFee = maxOverdrawFee;
    }

    /**
     * 账单日
     *
     * @return repayment_time 账单日
     */
    public Date getRepaymentTime() {
        return repaymentTime;
    }

    /**
     * 账单日
     *
     * @param repaymentTime 账单日
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
     * Gets overdrawUnpaidBalance
     *
     * @return value of overdrawUnpaidBalance
     */
    public Double getOverdrawUnpaidBalance() {
        return overdrawUnpaidBalance;
    }

    /**
     * @param overdrawUnpaidBalance
     */
    public void setOverdrawUnpaidBalance(Double overdrawUnpaidBalance) {
        this.overdrawUnpaidBalance = overdrawUnpaidBalance;
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
     * 业务号
     *
     * @return buss_no 业务号
     */
    public String getBussNo() {
        return bussNo;
    }

    /**
     * 业务号
     *
     * @param bussNo 业务号
     */
    public void setBussNo(String bussNo) {
        this.bussNo = bussNo == null ? null : bussNo.trim();
    }

    /**
     * 授信额度
     *
     * @return credit_line 授信额度
     */
    public Double getCreditLine() {
        return creditLine;
    }

    /**
     * 授信额度
     *
     * @param creditLine 授信额度
     */
    public void setCreditLine(Double creditLine) {
        this.creditLine = creditLine;
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
    public String getClassify() {
        return classify;
    }

    /**
     * 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     *
     * @param classify 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     */
    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
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
