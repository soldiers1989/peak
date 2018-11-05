package com.masspick.peak.model.credit.etp;

/**
 * etp_guarantee_stats
 * 担保及第三方代偿信息
 */
public class EtpGuaranteeStats {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 总的笔数
     */
    private Integer count;

    /**
     * 总的担保金额
     */
    private Double fee;

    /**
     * 正常类金额
     */
    private Double normalFee;

    /**
     * 关注类金额
     */
    private Double attentionFee;

    /**
     * 不良类
     */
    private Double problemFee;

    /**
     * 担保种类： 保证汇总，抵押汇总，质押汇总
     */
    private String category;

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
     * 总的笔数
     *
     * @return count 总的笔数
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 总的笔数
     *
     * @param count 总的笔数
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 总的担保金额
     *
     * @return fee 总的担保金额
     */
    public Double getFee() {
        return fee;
    }

    /**
     * 总的担保金额
     *
     * @param fee 总的担保金额
     */
    public void setFee(Double fee) {
        this.fee = fee;
    }

    /**
     * Gets normalFee
     *
     * @return value of normalFee
     */
    public Double getNormalFee() {
        return normalFee;
    }

    /**
     * @param normalFee
     */
    public void setNormalFee(Double normalFee) {
        this.normalFee = normalFee;
    }

    /**
     * Gets attentionFee
     *
     * @return value of attentionFee
     */
    public Double getAttentionFee() {
        return attentionFee;
    }

    /**
     * @param attentionFee
     */
    public void setAttentionFee(Double attentionFee) {
        this.attentionFee = attentionFee;
    }

    /**
     * Gets problemFee
     *
     * @return value of problemFee
     */
    public Double getProblemFee() {
        return problemFee;
    }

    /**
     * @param problemFee
     */
    public void setProblemFee(Double problemFee) {
        this.problemFee = problemFee;
    }

    /**
     * 担保种类： 保证汇总，抵押汇总，质押汇总
     *
     * @return category 担保种类： 保证汇总，抵押汇总，质押汇总
     */
    public String getCategory() {
        return category;
    }

    /**
     * 担保种类： 保证汇总，抵押汇总，质押汇总
     *
     * @param category 担保种类： 保证汇总，抵押汇总，质押汇总
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }
}
