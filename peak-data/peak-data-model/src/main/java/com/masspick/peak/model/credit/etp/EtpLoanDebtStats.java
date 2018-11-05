package com.masspick.peak.model.credit.etp;

/**
 * etp_loan_debt_stats
 * 债务统计信息
 */
public class EtpLoanDebtStats {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 正常类笔数
     */
    private Integer normalCount;

    /**
     * 正常类余额
     */
    private Double normalBalance;

    /**
     * 关注类笔数
     */
    private Integer attentionCount;

    /**
     * 关注类余额
     */
    private Double attentionBalance;

    /**
     * 不良类笔数
     */
    private Integer problemCount;

    /**
     * 不良类余额
     */
    private Double problemBalance;

    /**
     * 贷款类别
     */
    private String category;

    /**
     * 1 : 当前负债；2：已还清
     */
    private Integer state;

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
     * 正常类笔数
     * @return normal_count 正常类笔数
     */
    public Integer getNormalCount() {
        return normalCount;
    }

    /**
     * 正常类笔数
     * @param normalCount 正常类笔数
     */
    public void setNormalCount(Integer normalCount) {
        this.normalCount = normalCount;
    }

    /**
     * 正常类余额
     * @return normal_balance 正常类余额
     */
    public Double getNormalBalance() {
        return normalBalance;
    }

    /**
     * 正常类余额
     * @param normalBalance 正常类余额
     */
    public void setNormalBalance(Double normalBalance) {
        this.normalBalance = normalBalance;
    }

    /**
     * 关注类笔数
     * @return attention_count 关注类笔数
     */
    public Integer getAttentionCount() {
        return attentionCount;
    }

    /**
     * 关注类笔数
     * @param attentionCount 关注类笔数
     */
    public void setAttentionCount(Integer attentionCount) {
        this.attentionCount = attentionCount;
    }

    /**
     * 关注类余额
     * @return attention_balance 关注类余额
     */
    public Double getAttentionBalance() {
        return attentionBalance;
    }

    /**
     * 关注类余额
     * @param attentionBalance 关注类余额
     */
    public void setAttentionBalance(Double attentionBalance) {
        this.attentionBalance = attentionBalance;
    }

    /**
     * 不良类笔数
     * @return problem_count 不良类笔数
     */
    public Integer getProblemCount() {
        return problemCount;
    }

    /**
     * 不良类笔数
     * @param problemCount 不良类笔数
     */
    public void setProblemCount(Integer problemCount) {
        this.problemCount = problemCount;
    }

    /**
     * 不良类余额
     * @return problem_balance 不良类余额
     */
    public Double getProblemBalance() {
        return problemBalance;
    }

    /**
     * 不良类余额
     * @param problemBalance 不良类余额
     */
    public void setProblemBalance(Double problemBalance) {
        this.problemBalance = problemBalance;
    }

    /**
     * 贷款类别
     * @return category 贷款类别
     */
    public String getCategory() {
        return category;
    }

    /**
     * 贷款类别
     * @param category 贷款类别
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * Gets state
     *
     * @return value of state
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }
}
