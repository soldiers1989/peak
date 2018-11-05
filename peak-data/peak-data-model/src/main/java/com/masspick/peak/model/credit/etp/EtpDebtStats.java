package com.masspick.peak.model.credit.etp;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * etp_debt_stats
 * 当前负债概要信息
 */
public class EtpDebtStats {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 由资产管理公司处置的债务
     */
    private Integer byAssetComHandleCount;

    /**
     * 由资产管理公司处置的金额
     */
    private Double byAssetComHandleFee;

    /**
     * 由资产管理公司处置日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date byAssetComHandleDate;

    /**
     * 被剥离负债笔数
     */
    private Integer offBalanceCount;

    /**
     * 被剥离负债金额
     */
    private Double offBalanceFee;

    /**
     * 最近一次被剥离日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date offBalanceDate;

    /**
     * 欠息笔数
     */
    private Integer oweInterestCount;

    /**
     * 欠息金额
     */
    private Double oweInterestFee;

    /**
     * 最近一次结清日期
     */
    private Date oweInterestClearDate;

    /**
     * 垫款笔数
     */
    private Integer advanceCount;

    /**
     * 垫款金额
     */
    private Double advanceFee;

    /**
     * 垫款结清日期
     */
    private Date advanceClearDate;

    /**
     * 担保代偿或第三方代偿的债务--笔数
     */
    private Integer guaranteeCount;

    /**
     * 担保代偿或第三方代偿的债务--金额
     */
    private Double guaranteeFee;

    /**
     * 担保代偿或第三方代偿的债务--还清日期
     */
    private Date guaranteeClearDate;

    /**
     * 1 : 当前负债；2：已还清
     */
    private Integer state;

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
     * Gets byAssetComHandleCount
     *
     * @return value of byAssetComHandleCount
     */
    public Integer getByAssetComHandleCount() {
        return byAssetComHandleCount;
    }

    /**
     * @param byAssetComHandleCount
     */
    public void setByAssetComHandleCount(Integer byAssetComHandleCount) {
        this.byAssetComHandleCount = byAssetComHandleCount;
    }

    /**
     * Gets byAssetComHandleFee
     *
     * @return value of byAssetComHandleFee
     */
    public Double getByAssetComHandleFee() {
        return byAssetComHandleFee;
    }

    /**
     * @param byAssetComHandleFee
     */
    public void setByAssetComHandleFee(Double byAssetComHandleFee) {
        this.byAssetComHandleFee = byAssetComHandleFee;
    }

    /**
     * Gets byAssetComHandleDate
     *
     * @return value of byAssetComHandleDate
     */
    public Date getByAssetComHandleDate() {
        return byAssetComHandleDate;
    }

    /**
     * @param byAssetComHandleDate
     */
    public void setByAssetComHandleDate(Date byAssetComHandleDate) {
        this.byAssetComHandleDate = byAssetComHandleDate;
    }

    /**
     * Gets offBalanceCount
     *
     * @return value of offBalanceCount
     */
    public Integer getOffBalanceCount() {
        return offBalanceCount;
    }

    /**
     * @param offBalanceCount
     */
    public void setOffBalanceCount(Integer offBalanceCount) {
        this.offBalanceCount = offBalanceCount;
    }

    /**
     * Gets offBalanceFee
     *
     * @return value of offBalanceFee
     */
    public Double getOffBalanceFee() {
        return offBalanceFee;
    }

    /**
     * @param offBalanceFee
     */
    public void setOffBalanceFee(Double offBalanceFee) {
        this.offBalanceFee = offBalanceFee;
    }

    /**
     * Gets offBalanceDate
     *
     * @return value of offBalanceDate
     */
    public Date getOffBalanceDate() {
        return offBalanceDate;
    }

    /**
     * @param offBalanceDate
     */
    public void setOffBalanceDate(Date offBalanceDate) {
        this.offBalanceDate = offBalanceDate;
    }

    /**
     * Gets oweInterestCount
     *
     * @return value of oweInterestCount
     */
    public Integer getOweInterestCount() {
        return oweInterestCount;
    }

    /**
     * @param oweInterestCount
     */
    public void setOweInterestCount(Integer oweInterestCount) {
        this.oweInterestCount = oweInterestCount;
    }

    /**
     * Gets oweInterestFee
     *
     * @return value of oweInterestFee
     */
    public Double getOweInterestFee() {
        return oweInterestFee;
    }

    /**
     * @param oweInterestFee
     */
    public void setOweInterestFee(Double oweInterestFee) {
        this.oweInterestFee = oweInterestFee;
    }

    /**
     * Gets oweInterestClearDate
     *
     * @return value of oweInterestClearDate
     */
    public Date getOweInterestClearDate() {
        return oweInterestClearDate;
    }

    /**
     * @param oweInterestClearDate
     */
    public void setOweInterestClearDate(Date oweInterestClearDate) {
        this.oweInterestClearDate = oweInterestClearDate;
    }

    /**
     * Gets advanceCount
     *
     * @return value of advanceCount
     */
    public Integer getAdvanceCount() {
        return advanceCount;
    }

    /**
     * @param advanceCount
     */
    public void setAdvanceCount(Integer advanceCount) {
        this.advanceCount = advanceCount;
    }

    /**
     * Gets advanceFee
     *
     * @return value of advanceFee
     */
    public Double getAdvanceFee() {
        return advanceFee;
    }

    /**
     * @param advanceFee
     */
    public void setAdvanceFee(Double advanceFee) {
        this.advanceFee = advanceFee;
    }

    /**
     * Gets advanceClearDate
     *
     * @return value of advanceClearDate
     */
    public Date getAdvanceClearDate() {
        return advanceClearDate;
    }

    /**
     * @param advanceClearDate
     */
    public void setAdvanceClearDate(Date advanceClearDate) {
        this.advanceClearDate = advanceClearDate;
    }

    /**
     * Gets guaranteeCount
     *
     * @return value of guaranteeCount
     */
    public Integer getGuaranteeCount() {
        return guaranteeCount;
    }

    /**
     * @param guaranteeCount
     */
    public void setGuaranteeCount(Integer guaranteeCount) {
        this.guaranteeCount = guaranteeCount;
    }

    /**
     * Gets guaranteeFee
     *
     * @return value of guaranteeFee
     */
    public Double getGuaranteeFee() {
        return guaranteeFee;
    }

    /**
     * @param guaranteeFee
     */
    public void setGuaranteeFee(Double guaranteeFee) {
        this.guaranteeFee = guaranteeFee;
    }

    /**
     * Gets guaranteeClearDate
     *
     * @return value of guaranteeClearDate
     */
    public Date getGuaranteeClearDate() {
        return guaranteeClearDate;
    }

    /**
     * @param guaranteeClearDate
     */
    public void setGuaranteeClearDate(Date guaranteeClearDate) {
        this.guaranteeClearDate = guaranteeClearDate;
    }

    /**
     * 1 : 当前负债；2：已还清
     *
     * @return state 1 : 当前负债；2：已还清
     */
    public Integer getState() {
        return state;
    }

    /**
     * 1 : 当前负债；2：已还清
     *
     * @param state 1 : 当前负债；2：已还清
     */
    public void setState(Integer state) {
        this.state = state;
    }
}
