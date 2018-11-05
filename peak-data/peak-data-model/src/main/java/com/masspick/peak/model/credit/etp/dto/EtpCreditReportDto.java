package com.masspick.peak.model.credit.etp.dto;



import com.masspick.peak.model.credit.etp.EtpCreditReport;
import com.masspick.peak.model.credit.etp.EtpGuaranteeRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */
public class EtpCreditReportDto extends EtpCreditReport {

    /**
     * 基本信息
     */
    private EtpCreditBasicDto basic = new EtpCreditBasicDto();

    /**
     * 信息概要
     */
    private EtpCreditSummaryDto summary = new EtpCreditSummaryDto();

    /**
     * 当前负债
     */
    private EtpCreditCurrentDebtDto currentDebt = new EtpCreditCurrentDebtDto();

    /**
     * 已还清债务
     */
    private EtpCreditClearedDebtDto clearDebt = new EtpCreditClearedDebtDto();

    /**
     * 对外担保记录
     */
    private List<EtpGuaranteeRecord> guaranteeRecordList = new ArrayList<>();

    /**
     * 公共信息明细
     */
    private EtpCreditCommonDto common = new EtpCreditCommonDto();

    /**
     * Gets basic
     *
     * @return value of basic
     */
    public EtpCreditBasicDto getBasic() {
        return basic;
    }

    /**
     * @param basic
     */
    public void setBasic(EtpCreditBasicDto basic) {
        this.basic = basic;
    }

    /**
     * Gets summary
     *
     * @return value of summary
     */
    public EtpCreditSummaryDto getSummary() {
        return summary;
    }

    /**
     * @param summary
     */
    public void setSummary(EtpCreditSummaryDto summary) {
        this.summary = summary;
    }

    /**
     * Gets currentDebt
     *
     * @return value of currentDebt
     */
    public EtpCreditCurrentDebtDto getCurrentDebt() {
        return currentDebt;
    }

    /**
     * @param currentDebt
     */
    public void setCurrentDebt(EtpCreditCurrentDebtDto currentDebt) {
        this.currentDebt = currentDebt;
    }

    /**
     * Gets clearDebt
     *
     * @return value of clearDebt
     */
    public EtpCreditClearedDebtDto getClearDebt() {
        return clearDebt;
    }

    /**
     * @param clearDebt
     */
    public void setClearDebt(EtpCreditClearedDebtDto clearDebt) {
        this.clearDebt = clearDebt;
    }

    /**
     * Gets guaranteeRecordList
     *
     * @return value of guaranteeRecordList
     */
    public List<EtpGuaranteeRecord> getGuaranteeRecordList() {
        return guaranteeRecordList;
    }

    /**
     * @param guaranteeRecordList
     */
    public void setGuaranteeRecordList(List<EtpGuaranteeRecord> guaranteeRecordList) {
        this.guaranteeRecordList = guaranteeRecordList;
    }

    /**
     * Gets common
     *
     * @return value of common
     */
    public EtpCreditCommonDto getCommon() {
        return common;
    }

    /**
     * @param common
     */
    public void setCommon(EtpCreditCommonDto common) {
        this.common = common;
    }
}
