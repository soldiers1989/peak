package com.masspick.peak.model.credit.etp.dto;



import com.masspick.peak.model.credit.etp.EtpAdvances;
import com.masspick.peak.model.credit.etp.EtpAssetHandleDebt;
import com.masspick.peak.model.credit.etp.EtpGuarantee;
import com.masspick.peak.model.credit.etp.EtpInterest;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */
public class EtpCreditCurrentDebtDto {

    /**
     * 由资产管理公司处置的债务
     */
    private List<EtpAssetHandleDebt> assetHandleDebtList;

    /**
     * 担保及第三方代偿信息
     */
    private List<EtpGuarantee> guaranteeList;

    /**
     * 欠息记录
     */
    private List<EtpInterest> interestList;

    /**
     * 垫款记录
     */
    private List<EtpAdvances> advancesList;

    /**
     * 不良和违约类债务
     */
    private EtpCreditLoanDto abnormalLoan = new EtpCreditLoanDto();

    /**
     * 关注类
     */
    private EtpCreditLoanDto attentionLoan = new EtpCreditLoanDto();

    /**
     * 正常类
     */
    private EtpCreditLoanDto normalLoan = new EtpCreditLoanDto();

    /**
     * Gets assetHandleDebtList
     *
     * @return value of assetHandleDebtList
     */
    public List<EtpAssetHandleDebt> getAssetHandleDebtList() {
        return assetHandleDebtList;
    }

    /**
     * @param assetHandleDebtList
     */
    public void setAssetHandleDebtList(List<EtpAssetHandleDebt> assetHandleDebtList) {
        this.assetHandleDebtList = assetHandleDebtList;
    }

    /**
     * Gets guaranteeList
     *
     * @return value of guaranteeList
     */
    public List<EtpGuarantee> getGuaranteeList() {
        return guaranteeList;
    }

    /**
     * @param guaranteeList
     */
    public void setGuaranteeList(List<EtpGuarantee> guaranteeList) {
        this.guaranteeList = guaranteeList;
    }

    /**
     * Gets interestList
     *
     * @return value of interestList
     */
    public List<EtpInterest> getInterestList() {
        return interestList;
    }

    /**
     * @param interestList
     */
    public void setInterestList(List<EtpInterest> interestList) {
        this.interestList = interestList;
    }

    /**
     * Gets advancesList
     *
     * @return value of advancesList
     */
    public List<EtpAdvances> getAdvancesList() {
        return advancesList;
    }

    /**
     * @param advancesList
     */
    public void setAdvancesList(List<EtpAdvances> advancesList) {
        this.advancesList = advancesList;
    }

    /**
     * Gets abnormalLoan
     *
     * @return value of abnormalLoan
     */
    public EtpCreditLoanDto getAbnormalLoan() {
        return abnormalLoan;
    }

    /**
     * @param abnormalLoan
     */
    public void setAbnormalLoan(EtpCreditLoanDto abnormalLoan) {
        this.abnormalLoan = abnormalLoan;
    }

    /**
     * Gets attentionLoan
     *
     * @return value of attentionLoan
     */
    public EtpCreditLoanDto getAttentionLoan() {
        return attentionLoan;
    }

    /**
     * @param attentionLoan
     */
    public void setAttentionLoan(EtpCreditLoanDto attentionLoan) {
        this.attentionLoan = attentionLoan;
    }

    /**
     * Gets normalLoan
     *
     * @return value of normalLoan
     */
    public EtpCreditLoanDto getNormalLoan() {
        return normalLoan;
    }

    /**
     * @param normalLoan
     */
    public void setNormalLoan(EtpCreditLoanDto normalLoan) {
        this.normalLoan = normalLoan;
    }
}
