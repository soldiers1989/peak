package com.masspick.peak.model.credit.etp;

import java.util.Date;

/**
 * etp_debit_history
 * 负债变化历史
 */
public class EtpDebitHistory {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 全部负债余额
     */
    private Double totalDebitFee;

    /**
     * 不良负债余额
     */
    private Double abnormalDebitFee;

    /**
     * 统计日期
     */
    private Date reportDate;

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
     * 全部负债余额
     *
     * @return total_debit_fee 全部负债余额
     */
    public Double getTotalDebitFee() {
        return totalDebitFee;
    }

    /**
     * 全部负债余额
     *
     * @param totalDebitFee 全部负债余额
     */
    public void setTotalDebitFee(Double totalDebitFee) {
        this.totalDebitFee = totalDebitFee;
    }

    /**
     * 不良负债余额
     *
     * @return abnormal_debit_fee 不良负债余额
     */
    public Double getAbnormalDebitFee() {
        return abnormalDebitFee;
    }

    /**
     * 不良负债余额
     *
     * @param abnormalDebitFee 不良负债余额
     */
    public void setAbnormalDebitFee(Double abnormalDebitFee) {
        this.abnormalDebitFee = abnormalDebitFee;
    }

    /**
     * 统计日期
     *
     * @return report_date 统计日期
     */
    public Date getReportDate() {
        return reportDate;
    }

    /**
     * 统计日期
     *
     * @param reportDate 统计日期
     */
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }
}
