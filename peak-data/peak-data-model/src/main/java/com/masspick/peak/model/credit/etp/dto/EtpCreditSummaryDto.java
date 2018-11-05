package com.masspick.peak.model.credit.etp.dto;



import com.masspick.peak.model.credit.etp.EtpDebitHistory;
import com.masspick.peak.model.credit.etp.EtpDebtStats;
import com.masspick.peak.model.credit.etp.EtpGuaranteeStats;
import com.masspick.peak.model.credit.etp.EtpLoanDebtStats;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 * 信息概要
 */
public class EtpCreditSummaryDto {

    /**
     * 当前负债信息概要
     */
    private EtpDebtStats currentAssetDebt;

    /**
     * 当前债务统计信息
     */
    private List<EtpLoanDebtStats> currentLoanDebtList;

    /**
     * 已还清负债信息概要
     */
    private EtpDebtStats clearedAssetDebt;

    /**
     * 已还清债务信息
     */
    private List<EtpLoanDebtStats> clearedLoanDebtList;

    /**
     * 对外担保信息概要
     */
    private List<EtpGuaranteeStats> guaranteeStatsList;

    /**
     * 负债变化历史
     */
    private List<EtpDebitHistory> debitHistoryList;

    /**
     * Gets currentAssetDebt
     *
     * @return value of currentAssetDebt
     */
    public EtpDebtStats getCurrentAssetDebt() {
        return currentAssetDebt;
    }

    /**
     * @param currentAssetDebt
     */
    public void setCurrentAssetDebt(EtpDebtStats currentAssetDebt) {
        this.currentAssetDebt = currentAssetDebt;
    }

    /**
     * Gets currentLoanDebtList
     *
     * @return value of currentLoanDebtList
     */
    public List<EtpLoanDebtStats> getCurrentLoanDebtList() {
        return currentLoanDebtList;
    }

    /**
     * @param currentLoanDebtList
     */
    public void setCurrentLoanDebtList(List<EtpLoanDebtStats> currentLoanDebtList) {
        this.currentLoanDebtList = currentLoanDebtList;
    }

    /**
     * Gets clearedAssetDebt
     *
     * @return value of clearedAssetDebt
     */
    public EtpDebtStats getClearedAssetDebt() {
        return clearedAssetDebt;
    }

    /**
     * @param clearedAssetDebt
     */
    public void setClearedAssetDebt(EtpDebtStats clearedAssetDebt) {
        this.clearedAssetDebt = clearedAssetDebt;
    }

    /**
     * Gets clearedLoanDebtList
     *
     * @return value of clearedLoanDebtList
     */
    public List<EtpLoanDebtStats> getClearedLoanDebtList() {
        return clearedLoanDebtList;
    }

    /**
     * @param clearedLoanDebtList
     */
    public void setClearedLoanDebtList(List<EtpLoanDebtStats> clearedLoanDebtList) {
        this.clearedLoanDebtList = clearedLoanDebtList;
    }

    /**
     * Gets guaranteeStatsList
     *
     * @return value of guaranteeStatsList
     */
    public List<EtpGuaranteeStats> getGuaranteeStatsList() {
        return guaranteeStatsList;
    }

    /**
     * @param guaranteeStatsList
     */
    public void setGuaranteeStatsList(List<EtpGuaranteeStats> guaranteeStatsList) {
        this.guaranteeStatsList = guaranteeStatsList;
    }

    /**
     * Gets debitHistoryList
     *
     * @return value of debitHistoryList
     */
    public List<EtpDebitHistory> getDebitHistoryList() {
        return debitHistoryList;
    }

    /**
     * @param debitHistoryList
     */
    public void setDebitHistoryList(List<EtpDebitHistory> debitHistoryList) {
        this.debitHistoryList = debitHistoryList;
    }
}
