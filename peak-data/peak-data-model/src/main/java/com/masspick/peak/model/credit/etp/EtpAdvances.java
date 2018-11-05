package com.masspick.peak.model.credit.etp;

import java.util.Date;

/**
 * etp_advances
 * 垫款记录
 */
public class EtpAdvances {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 授信机构
     */
    private String institution;

    /**
     * 币种
     */
    private String curType;

    /**
     * 垫款金额
     */
    private Double advancesFee;

    /**
     * 垫款余额
     */
    private Double advancesOverFee;

    /**
     * 垫款日期
     */
    private Date advancesDate;

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
     * 授信机构
     *
     * @return institution 授信机构
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * 授信机构
     *
     * @param institution 授信机构
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
     * 垫款金额
     *
     * @return advances_fee 垫款金额
     */
    public Double getAdvancesFee() {
        return advancesFee;
    }

    /**
     * 垫款金额
     *
     * @param advancesFee 垫款金额
     */
    public void setAdvancesFee(Double advancesFee) {
        this.advancesFee = advancesFee;
    }

    /**
     * 垫款余额
     *
     * @return advances_over_fee 垫款余额
     */
    public Double getAdvancesOverFee() {
        return advancesOverFee;
    }

    /**
     * 垫款余额
     *
     * @param advancesOverFee 垫款余额
     */
    public void setAdvancesOverFee(Double advancesOverFee) {
        this.advancesOverFee = advancesOverFee;
    }

    /**
     * 垫款日期
     *
     * @return advances_date 垫款日期
     */
    public Date getAdvancesDate() {
        return advancesDate;
    }

    /**
     * 垫款日期
     *
     * @param advancesDate 垫款日期
     */
    public void setAdvancesDate(Date advancesDate) {
        this.advancesDate = advancesDate;
    }

    /**
     * 结清日期
     *
     * @return settled_date 结清日期
     */
    public Date getSettledDate() {
        return settledDate;
    }

    /**
     * 结清日期
     *
     * @param settledDate 结清日期
     */
    public void setSettledDate(Date settledDate) {
        this.settledDate = settledDate;
    }

    /**
     * 原业务
     *
     * @return original_buss 原业务
     */
    public String getOriginalBuss() {
        return originalBuss;
    }

    /**
     * 原业务
     *
     * @param originalBuss 原业务
     */
    public void setOriginalBuss(String originalBuss) {
        this.originalBuss = originalBuss == null ? null : originalBuss.trim();
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
