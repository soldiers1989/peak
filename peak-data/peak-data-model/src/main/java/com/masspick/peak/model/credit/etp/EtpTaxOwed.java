package com.masspick.peak.model.credit.etp;

import java.util.Date;

/**
 * etp_tax_owed
 */
public class EtpTaxOwed {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 主管税务机关
     */
    private String office;

    /**
     * 欠税总额（元）
     */
    private Double fee;

    /**
     * 欠税统计日期
     */
    private Date recordTime;

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
     * 主管税务机关
     *
     * @return office 主管税务机关
     */
    public String getOffice() {
        return office;
    }

    /**
     * 主管税务机关
     *
     * @param office 主管税务机关
     */
    public void setOffice(String office) {
        this.office = office == null ? null : office.trim();
    }

    /**
     * 欠税总额（元）
     *
     * @return fee 欠税总额（元）
     */
    public Double getFee() {
        return fee;
    }

    /**
     * 欠税总额（元）
     *
     * @param fee 欠税总额（元）
     */
    public void setFee(Double fee) {
        this.fee = fee;
    }

    /**
     * 欠税统计日期
     *
     * @return record_time 欠税统计日期
     */
    public Date getRecordTime() {
        return recordTime;
    }

    /**
     * 欠税统计日期
     *
     * @param recordTime 欠税统计日期
     */
    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}
