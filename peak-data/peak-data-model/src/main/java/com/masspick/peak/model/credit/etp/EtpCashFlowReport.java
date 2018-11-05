package com.masspick.peak.model.credit.etp;

/**
 * etp_cash_flow_report
 * 现金流量表
 */
public class EtpCashFlowReport {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 年报;半年报（上）;半年报（下）
     */
    private String type;

    /**
     * 年份
     */
    private String year;

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
     * 年报;半年报（上）;半年报（下）
     *
     * @return type 年报;半年报（上）;半年报（下）
     */
    public String getType() {
        return type;
    }

    /**
     * 年报;半年报（上）;半年报（下）
     *
     * @param type 年报;半年报（上）;半年报（下）
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 年份
     *
     * @return year 年份
     */
    public String getYear() {
        return year;
    }

    /**
     * 年份
     *
     * @param year 年份
     */
    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }
}
