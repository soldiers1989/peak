package com.masspick.peak.model.credit.etp;

import java.util.Date;

/**
 * etp_interest
 * 欠息记录
 */
public class EtpInterest {
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
     * 币种
     */
    private String curType;

    /**
     * 历史最高欠息金额（元）
     */
    private Double maxFee;

    /**
     * 欠息余额（元）
     */
    private Double overFee;

    /**
     * 余额改变日期
     */
    private Date overFeeChangeDate;

    /**
     * 欠息日期
     */
    private Date financeDate;

    /**
     * 结清日期
     */
    private Date settledDate;

    /**
     * 欠息类型
     */
    private String type;

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
     * 偿还机构
     *
     * @return institution 偿还机构
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * 偿还机构
     *
     * @param institution 偿还机构
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
     * 历史最高欠息金额（元）
     *
     * @return max_fee 历史最高欠息金额（元）
     */
    public Double getMaxFee() {
        return maxFee;
    }

    /**
     * 历史最高欠息金额（元）
     *
     * @param maxFee 历史最高欠息金额（元）
     */
    public void setMaxFee(Double maxFee) {
        this.maxFee = maxFee;
    }

    /**
     * 欠息余额（元）
     *
     * @return over_fee 欠息余额（元）
     */
    public Double getOverFee() {
        return overFee;
    }

    /**
     * 欠息余额（元）
     *
     * @param overFee 欠息余额（元）
     */
    public void setOverFee(Double overFee) {
        this.overFee = overFee;
    }

    /**
     * 余额改变日期
     *
     * @return over_fee_change_date 余额改变日期
     */
    public Date getOverFeeChangeDate() {
        return overFeeChangeDate;
    }

    /**
     * 余额改变日期
     *
     * @param overFeeChangeDate 余额改变日期
     */
    public void setOverFeeChangeDate(Date overFeeChangeDate) {
        this.overFeeChangeDate = overFeeChangeDate;
    }

    /**
     * 欠息日期
     *
     * @return finance_date 欠息日期
     */
    public Date getFinanceDate() {
        return financeDate;
    }

    /**
     * 欠息日期
     *
     * @param financeDate 欠息日期
     */
    public void setFinanceDate(Date financeDate) {
        this.financeDate = financeDate;
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
     * 欠息类型
     *
     * @return type 欠息类型
     */
    public String getType() {
        return type;
    }

    /**
     * 欠息类型
     *
     * @param type 欠息类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
