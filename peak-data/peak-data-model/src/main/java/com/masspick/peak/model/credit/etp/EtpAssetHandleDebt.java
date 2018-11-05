package com.masspick.peak.model.credit.etp;

import java.util.Date;

/**
 * etp_asset_handle_debt
 * 由资产管理公司处置的债务
 */
public class EtpAssetHandleDebt {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 处置机构
     */
    private String institution;

    /**
     * 币种
     */
    private String curType;

    /**
     * 原始金额
     */
    private Double fee;

    /**
     * 余额
     */
    private Double overFee;

    /**
     * 最近一次处置日期
     */
    private Date lastHandleDate;

    /**
     * 接收日期
     */
    private Date receiveDate;

    /**
     * 完成日期
     */
    private Date finishDate;

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
     * 处置机构
     *
     * @return institution 处置机构
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * 处置机构
     *
     * @param institution 处置机构
     */
    public void setInstitution(String institution) {
        this.institution = institution == null ? null : institution.trim();
    }

    /**
     * 币种
     *
     * @return cur_type 币种
     */
    public String getCurType() {
        return curType;
    }

    /**
     * 币种
     *
     * @param curType 币种
     */
    public void setCurType(String curType) {
        this.curType = curType == null ? null : curType.trim();
    }

    /**
     * 原始金额
     *
     * @return fee 原始金额
     */
    public Double getFee() {
        return fee;
    }

    /**
     * 原始金额
     *
     * @param fee 原始金额
     */
    public void setFee(Double fee) {
        this.fee = fee;
    }

    /**
     * 余额
     *
     * @return over_fee 余额
     */
    public Double getOverFee() {
        return overFee;
    }

    /**
     * 余额
     *
     * @param overFee 余额
     */
    public void setOverFee(Double overFee) {
        this.overFee = overFee;
    }

    /**
     * 最近一次处置日期
     *
     * @return last_handle_date 最近一次处置日期
     */
    public Date getLastHandleDate() {
        return lastHandleDate;
    }

    /**
     * 最近一次处置日期
     *
     * @param lastHandleDate 最近一次处置日期
     */
    public void setLastHandleDate(Date lastHandleDate) {
        this.lastHandleDate = lastHandleDate;
    }

    /**
     * 接收日期
     *
     * @return receive_date 接收日期
     */
    public Date getReceiveDate() {
        return receiveDate;
    }

    /**
     * 接收日期
     *
     * @param receiveDate 接收日期
     */
    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    /**
     * 完成日期
     *
     * @return finish_date 完成日期
     */
    public Date getFinishDate() {
        return finishDate;
    }

    /**
     * 完成日期
     *
     * @param finishDate 完成日期
     */
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    /**
     * 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     *
     * @return classify 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     */
    public Integer getClassify() {
        return classify;
    }

    /**
     * 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     *
     * @param classify 五级分类： 1: 正常类; 2: 关注类; 3: 次级; 4: 可疑；5： 损失。其中3、4、5 都属于不良
     */
    public void setClassify(Integer classify) {
        this.classify = classify;
    }

    /**
     * 1: 当前债务；2：已还清债务
     *
     * @return state 1: 当前债务；2：已还清债务
     */
    public Integer getState() {
        return state;
    }

    /**
     * 1: 当前债务；2：已还清债务
     *
     * @param state 1: 当前债务；2：已还清债务
     */
    public void setState(Integer state) {
        this.state = state;
    }
}
