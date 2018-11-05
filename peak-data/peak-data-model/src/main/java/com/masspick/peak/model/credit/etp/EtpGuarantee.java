package com.masspick.peak.model.credit.etp;

import java.util.Date;

/**
 * etp_guarantee
 * 担保及第三方代偿信息
 */
public class EtpGuarantee {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 偿还机构
     */
    private String institution;

    /**
     * 最近代偿日期
     */
    private Date lastCompensatoryDate;

    /**
     * 累计代偿金额
     */
    private Double totalCompensatoryFee;

    /**
     * 代偿余额
     */
    private Double overFee;

    /**
     * 最近还款日期
     */
    private Date lastReplyDate;

    /**
     * 结清日期
     */
    private Date settledDate;

    /**
     * 原业务
     */
    private String originalBuss;

    /**
     * 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     */
    private Integer classify;

    /**
     * 1: 当前债务；2：已还清债务
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
     * 偿还机构
     * @return institution 偿还机构
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * 偿还机构
     * @param institution 偿还机构
     */
    public void setInstitution(String institution) {
        this.institution = institution == null ? null : institution.trim();
    }

    /**
     * 最近代偿日期
     * @return last_compensatory_date 最近代偿日期
     */
    public Date getLastCompensatoryDate() {
        return lastCompensatoryDate;
    }

    /**
     * 最近代偿日期
     * @param lastCompensatoryDate 最近代偿日期
     */
    public void setLastCompensatoryDate(Date lastCompensatoryDate) {
        this.lastCompensatoryDate = lastCompensatoryDate;
    }

    /**
     * 累计代偿金额
     * @return total_compensatory_fee 累计代偿金额
     */
    public Double getTotalCompensatoryFee() {
        return totalCompensatoryFee;
    }

    /**
     * 累计代偿金额
     * @param totalCompensatoryFee 累计代偿金额
     */
    public void setTotalCompensatoryFee(Double totalCompensatoryFee) {
        this.totalCompensatoryFee = totalCompensatoryFee;
    }

    /**
     * 代偿余额
     * @return over_fee 代偿余额
     */
    public Double getOverFee() {
        return overFee;
    }

    /**
     * 代偿余额
     * @param overFee 代偿余额
     */
    public void setOverFee(Double overFee) {
        this.overFee = overFee;
    }

    /**
     * 最近还款日期
     * @return last_reply_date 最近还款日期
     */
    public Date getLastReplyDate() {
        return lastReplyDate;
    }

    /**
     * 最近还款日期
     * @param lastReplyDate 最近还款日期
     */
    public void setLastReplyDate(Date lastReplyDate) {
        this.lastReplyDate = lastReplyDate;
    }

    /**
     * 结清日期
     * @return settled_date 结清日期
     */
    public Date getSettledDate() {
        return settledDate;
    }

    /**
     * 结清日期
     * @param settledDate 结清日期
     */
    public void setSettledDate(Date settledDate) {
        this.settledDate = settledDate;
    }

    /**
     * 原业务
     * @return original_buss 原业务
     */
    public String getOriginalBuss() {
        return originalBuss;
    }

    /**
     * 原业务
     * @param originalBuss 原业务
     */
    public void setOriginalBuss(String originalBuss) {
        this.originalBuss = originalBuss == null ? null : originalBuss.trim();
    }

    /**
     * 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     * @return classify 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     */
    public Integer getClassify() {
        return classify;
    }

    /**
     * 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     * @param classify 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     */
    public void setClassify(Integer classify) {
        this.classify = classify;
    }

    /**
     * 1: 当前债务；2：已还清债务
     * @return state 1: 当前债务；2：已还清债务
     */
    public Integer getState() {
        return state;
    }

    /**
     * 1: 当前债务；2：已还清债务
     * @param state 1: 当前债务；2：已还清债务
     */
    public void setState(Integer state) {
        this.state = state;
    }
}
