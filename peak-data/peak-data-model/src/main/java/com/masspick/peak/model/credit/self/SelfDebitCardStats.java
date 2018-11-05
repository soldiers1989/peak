package com.masspick.peak.model.credit.self;

/**
 * self_debit_card_stats
 * 未销户贷记卡信息汇总
 */
public class SelfDebitCardStats {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 发卡法人机构数
     */
    private Integer hairpinCorporationCount;

    /**
     * 发卡机构数
     */
    private Integer hairpinInstitutionCount;

    /**
     * 账户数
     */
    private Integer count;

    /**
     * 授信总额
     */
    private Double totalCreditFee;

    /**
     * 单家行最高授信额
     */
    private Double maxCreditFee;

    /**
     * 单家行最低授信额
     */
    private Double minCreditFee;

    /**
     * 已用额度
     */
    private Double usedFee;

    /**
     * 最近6个月平均使用额度
     */
    private Double averageUsedFee;

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
     * 发卡法人机构数
     * @return hairpin_corporation_count 发卡法人机构数
     */
    public Integer getHairpinCorporationCount() {
        return hairpinCorporationCount;
    }

    /**
     * 发卡法人机构数
     * @param hairpinCorporationCount 发卡法人机构数
     */
    public void setHairpinCorporationCount(Integer hairpinCorporationCount) {
        this.hairpinCorporationCount = hairpinCorporationCount;
    }

    /**
     * 发卡机构数
     * @return hairpin_institution_count 发卡机构数
     */
    public Integer getHairpinInstitutionCount() {
        return hairpinInstitutionCount;
    }

    /**
     * 发卡机构数
     * @param hairpinInstitutionCount 发卡机构数
     */
    public void setHairpinInstitutionCount(Integer hairpinInstitutionCount) {
        this.hairpinInstitutionCount = hairpinInstitutionCount;
    }

    /**
     * 账户数
     * @return count 账户数
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 账户数
     * @param count 账户数
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 授信总额
     * @return total_credit_fee 授信总额
     */
    public Double getTotalCreditFee() {
        return totalCreditFee;
    }

    /**
     * 授信总额
     * @param totalCreditFee 授信总额
     */
    public void setTotalCreditFee(Double totalCreditFee) {
        this.totalCreditFee = totalCreditFee;
    }

    /**
     * 单家行最高授信额
     * @return max_credit_fee 单家行最高授信额
     */
    public Double getMaxCreditFee() {
        return maxCreditFee;
    }

    /**
     * 单家行最高授信额
     * @param maxCreditFee 单家行最高授信额
     */
    public void setMaxCreditFee(Double maxCreditFee) {
        this.maxCreditFee = maxCreditFee;
    }

    /**
     * 单家行最低授信额
     * @return min_credit_fee 单家行最低授信额
     */
    public Double getMinCreditFee() {
        return minCreditFee;
    }

    /**
     * 单家行最低授信额
     * @param minCreditFee 单家行最低授信额
     */
    public void setMinCreditFee(Double minCreditFee) {
        this.minCreditFee = minCreditFee;
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
}
