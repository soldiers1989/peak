package com.masspick.peak.model.dto;

/**
 * 推标实体类
 */
public class BorrowProjectBean {


    /**
     * 项目编号
     */
    private String projectNumber;

    /**
     * 借款标类型 1信用标 2担保标  4抵押标
     */
    private String borrowType;

    /**
     * 借款金额
     */
    private String borrowAccount;

    /**
     * 年利率%
     */
    private String borrowRate;

    /**
     * 借款期限
     */
    private String borrowPeriod;

    /**
     * 标类型：(1代表月标)
     */
    private String periodType;

    /**
     * 筹标期限默认5天
     */
    private String borrowValidDay;

    /**
     * 合同模板
     *  联合放贷：
     *  8520180103210721128963802311
     *  借款担保：
     * 64420160301091903871481972973
     */
    private String contractTempleId;

    /**
     * 合同编号
     */
    private String contractCode;

    /**
     * 还款方式
     */
    private String borrowStyle;

    /**
     * 0：非天标；1;天标
     */
    private String ckDayBrrow;

    /**
     * 合同签订时间
     */
    private String contractAddTime;

    /**
     * 应收居间费
     */
    private String commissionFree;

    /**
     * 居间费率
     */
    private String commissionRate;

    /**
     * 保证金
     */
    private String assureFee;

    /**
     * 保证金费率
     */
    private String assureRate;

    /**
     * 借款人类型
     */
    private String borrowerType;

    /**
     * 审核借款类型
     */
    private String loanType;

    /**
     * 审核信息
     */
    private String checkIds;

    /**
     * 增信借款类型
     */
    private String creditType;

    /**
     * 居间服务费收取方式,1线上,2线下
     */
    private String commissionStyle;

    /**
     * 总资产
     * 0
     * 1-100万
     * 100万-300万
     * 300万-1500万
     * 1500万-3000万
     * 3000万-5000万
     * 5000万-8000万
     * 8000万以上
     */
    private String qyAssetsTotal;

    /**
     * 总负债
     *0
     *1-100万
     *100万-300万
     *300万-1500万
     *1500万-3000万
     *3000万-5000万
     *5000万-8000万
     *8000万以上
     */
    private String qyCreditTotal;

    /**
     * 在平台逾期次数
     */
    private String qyOverdueTimes;

    /**
     * 在平台逾期金额（元）
     */
    private String qyOverdueAccount;

    /**
     *
     */
    private String borrowFlag;


    /**
     * isDay
     */
    private String isDay;


    /**
     * 任务Id
     */
    private String taskId;


    /**
     * Gets isDay
     *
     * @return value of isDay
     */
    public String getIsDay() {
        return isDay;
    }

    /**
     * @param isDay isDay
     */
    public void setIsDay(String isDay) {
        this.isDay = isDay;
    }

    /**
     * Gets borrowFlag
     *
     * @return value of borrowFlag
     */
    public String getBorrowFlag() {
        return borrowFlag;
    }

    /**
     * @param borrowFlag borrowFlag
     */
    public void setBorrowFlag(String borrowFlag) {
        this.borrowFlag = borrowFlag;
    }

    /**
     * Gets taskId
     *
     * @return value of taskId
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * @param taskId taskId
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     * Gets projectNumber
     *
     * @return value of projectNumber
     */
    public String getProjectNumber() {
        return projectNumber;
    }

    /**
     * @param projectNumber projectNumber
     */
    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    /**
     * Gets borrowType
     *
     * @return value of borrowType
     */
    public String getBorrowType() {
        return borrowType;
    }

    /**
     * @param borrowType borrowType
     */
    public void setBorrowType(String borrowType) {
        this.borrowType = borrowType;
    }

    /**
     * Gets borrowAccount
     *
     * @return value of borrowAccount
     */
    public String getBorrowAccount() {
        return borrowAccount;
    }

    /**
     * @param borrowAccount borrowAccount
     */
    public void setBorrowAccount(String borrowAccount) {
        this.borrowAccount = borrowAccount;
    }

    /**
     * Gets borrowRate
     *
     * @return value of borrowRate
     */
    public String getBorrowRate() {
        return borrowRate;
    }

    /**
     * @param borrowRate borrowRate
     */
    public void setBorrowRate(String borrowRate) {
        this.borrowRate = borrowRate;
    }

    /**
     * Gets borrowPeriod
     *
     * @return value of borrowPeriod
     */
    public String getBorrowPeriod() {
        return borrowPeriod;
    }

    /**
     * @param borrowPeriod borrowPeriod
     */
    public void setBorrowPeriod(String borrowPeriod) {
        this.borrowPeriod = borrowPeriod;
    }

    /**
     * Gets periodType
     *
     * @return value of periodType
     */
    public String getPeriodType() {
        return periodType;
    }

    /**
     * @param periodType periodType
     */
    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    /**
     * Gets borrowValidDay
     *
     * @return value of borrowValidDay
     */
    public String getBorrowValidDay() {
        return borrowValidDay;
    }

    /**
     * @param borrowValidDay borrowValidDay
     */
    public void setBorrowValidDay(String borrowValidDay) {
        this.borrowValidDay = borrowValidDay;
    }

    /**
     * Gets contractTempleId
     *
     * @return value of contractTempleId
     */
    public String getContractTempleId() {
        return contractTempleId;
    }

    /**
     * @param contractTempleId contractTempleId
     */
    public void setContractTempleId(String contractTempleId) {
        this.contractTempleId = contractTempleId;
    }

    /**
     * Gets contractCode
     *
     * @return value of contractCode
     */
    public String getContractCode() {
        return contractCode;
    }

    /**
     * @param contractCode contractCode
     */
    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    /**
     * Gets borrowStyle
     *
     * @return value of borrowStyle
     */
    public String getBorrowStyle() {
        return borrowStyle;
    }

    /**
     * @param borrowStyle borrowStyle
     */
    public void setBorrowStyle(String borrowStyle) {
        this.borrowStyle = borrowStyle;
    }

    /**
     * Gets ckDayBrrow
     *
     * @return value of ckDayBrrow
     */
    public String getCkDayBrrow() {
        return ckDayBrrow;
    }

    /**
     * @param ckDayBrrow ckDayBrrow
     */
    public void setCkDayBrrow(String ckDayBrrow) {
        this.ckDayBrrow = ckDayBrrow;
    }

    /**
     * Gets contractAddTime
     *
     * @return value of contractAddTime
     */
    public String getContractAddTime() {
        return contractAddTime;
    }

    /**
     * @param contractAddTime contractAddTime
     */
    public void setContractAddTime(String contractAddTime) {
        this.contractAddTime = contractAddTime;
    }

    /**
     * Gets commissionFree
     *
     * @return value of commissionFree
     */
    public String getCommissionFree() {
        return commissionFree;
    }

    /**
     * @param commissionFree commissionFree
     */
    public void setCommissionFree(String commissionFree) {
        this.commissionFree = commissionFree;
    }

    /**
     * Gets commissionRate
     *
     * @return value of commissionRate
     */
    public String getCommissionRate() {
        return commissionRate;
    }

    /**
     * @param commissionRate commissionRate
     */
    public void setCommissionRate(String commissionRate) {
        this.commissionRate = commissionRate;
    }

    /**
     * Gets assureFee
     *
     * @return value of assureFee
     */
    public String getAssureFee() {
        return assureFee;
    }

    /**
     * @param assureFee assureFee
     */
    public void setAssureFee(String assureFee) {
        this.assureFee = assureFee;
    }

    /**
     * Gets assureRate
     *
     * @return value of assureRate
     */
    public String getAssureRate() {
        return assureRate;
    }

    /**
     * @param assureRate assureRate
     */
    public void setAssureRate(String assureRate) {
        this.assureRate = assureRate;
    }

    /**
     * Gets borrowerType
     *
     * @return value of borrowerType
     */
    public String getBorrowerType() {
        return borrowerType;
    }

    /**
     * @param borrowerType borrowerType
     */
    public void setBorrowerType(String borrowerType) {
        this.borrowerType = borrowerType;
    }

    /**
     * Gets loanType
     *
     * @return value of loanType
     */
    public String getLoanType() {
        return loanType;
    }

    /**
     * @param loanType loanType
     */
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    /**
     * Gets checkIds
     *
     * @return value of checkIds
     */
    public String getCheckIds() {
        return checkIds;
    }

    /**
     * @param checkIds checkIds
     */
    public void setCheckIds(String checkIds) {
        this.checkIds = checkIds;
    }

    /**
     * Gets creditType
     *
     * @return value of creditType
     */
    public String getCreditType() {
        return creditType;
    }

    /**
     * @param creditType creditType
     */
    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    /**
     * Gets commissionStyle
     *
     * @return value of commissionStyle
     */
    public String getCommissionStyle() {
        return commissionStyle;
    }

    /**
     * @param commissionStyle commissionStyle
     */
    public void setCommissionStyle(String commissionStyle) {
        this.commissionStyle = commissionStyle;
    }

    /**
     * Gets qyAssetsTotal
     *
     * @return value of qyAssetsTotal
     */
    public String getQyAssetsTotal() {
        return qyAssetsTotal;
    }

    /**
     * @param qyAssetsTotal qyAssetsTotal
     */
    public void setQyAssetsTotal(String qyAssetsTotal) {
        this.qyAssetsTotal = qyAssetsTotal;
    }

    /**
     * Gets qyCreditTotal
     *
     * @return value of qyCreditTotal
     */
    public String getQyCreditTotal() {
        return qyCreditTotal;
    }

    /**
     * @param qyCreditTotal qyCreditTotal
     */
    public void setQyCreditTotal(String qyCreditTotal) {
        this.qyCreditTotal = qyCreditTotal;
    }

    /**
     * Gets qyOverdueTimes
     *
     * @return value of qyOverdueTimes
     */
    public String getQyOverdueTimes() {
        return qyOverdueTimes;
    }

    /**
     * @param qyOverdueTimes qyOverdueTimes
     */
    public void setQyOverdueTimes(String qyOverdueTimes) {
        this.qyOverdueTimes = qyOverdueTimes;
    }

    /**
     * Gets qyOverdueAccount
     *
     * @return value of qyOverdueAccount
     */
    public String getQyOverdueAccount() {
        return qyOverdueAccount;
    }

    /**
     * @param qyOverdueAccount qyOverdueAccount
     */
    public void setQyOverdueAccount(String qyOverdueAccount) {
        this.qyOverdueAccount = qyOverdueAccount;
    }
}
