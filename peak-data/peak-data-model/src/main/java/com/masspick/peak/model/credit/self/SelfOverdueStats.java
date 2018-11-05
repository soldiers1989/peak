package com.masspick.peak.model.credit.self;

/**
 * self_overdue_stats
 * 逾期（透支）信息汇总
 */
public class SelfOverdueStats {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 笔数
     */
    private Integer count;

    /**
     * 月份数
     */
    private Integer monthCount;

    /**
     * 单月最高逾期数
     */
    private Double monthMaxFee;

    /**
     * 最长逾期月数
     */
    private Integer maxOverdueMonth;

    /**
     * 1: 贷款逾期;2: 贷记卡逾期;3: 准贷记卡60天以上透支
     */
    private Integer type;

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
     * 月份数
     *
     * @return month_count 月份数
     */
    public Integer getMonthCount() {
        return monthCount;
    }

    /**
     * 月份数
     *
     * @param monthCount 月份数
     */
    public void setMonthCount(Integer monthCount) {
        this.monthCount = monthCount;
    }

    /**
     * 单月最高逾期数
     *
     * @return month_max_fee 单月最高逾期数
     */
    public Double getMonthMaxFee() {
        return monthMaxFee;
    }

    /**
     * 单月最高逾期数
     *
     * @param monthMaxFee 单月最高逾期数
     */
    public void setMonthMaxFee(Double monthMaxFee) {
        this.monthMaxFee = monthMaxFee;
    }

    /**
     * 最长逾期月数
     *
     * @return max_overdue_month 最长逾期月数
     */
    public Integer getMaxOverdueMonth() {
        return maxOverdueMonth;
    }

    /**
     * 最长逾期月数
     *
     * @param maxOverdueMonth 最长逾期月数
     */
    public void setMaxOverdueMonth(Integer maxOverdueMonth) {
        this.maxOverdueMonth = maxOverdueMonth;
    }

    /**
     * 1: 贷款逾期;2: 贷记卡逾期;3: 准贷记卡60天以上透支
     *
     * @return type 1: 贷款逾期;2: 贷记卡逾期;3: 准贷记卡60天以上透支
     */
    public Integer getType() {
        return type;
    }

    /**
     * 1: 贷款逾期;2: 贷记卡逾期;3: 准贷记卡60天以上透支
     *
     * @param type 1: 贷款逾期;2: 贷记卡逾期;3: 准贷记卡60天以上透支
     */
    public void setType(Integer type) {
        this.type = type;
    }
}
