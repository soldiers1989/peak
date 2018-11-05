package com.masspick.peak.model.credit.self;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * self_address
 * 居住信息
 */
public class SelfAddress {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 居住地址
     */
    private String address;

    /**
     * 居住状况
     */
    private String status;

    /**
     * 信息更新日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;

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
     * 居住地址
     *
     * @return address 居住地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 居住地址
     *
     * @param address 居住地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 居住状况
     *
     * @return status 居住状况
     */
    public String getStatus() {
        return status;
    }

    /**
     * 居住状况
     *
     * @param status 居住状况
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 信息更新日期
     *
     * @return update_time 信息更新日期
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 信息更新日期
     *
     * @param updateTime 信息更新日期
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
