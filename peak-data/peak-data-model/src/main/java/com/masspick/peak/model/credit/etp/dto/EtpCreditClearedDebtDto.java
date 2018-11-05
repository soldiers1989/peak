package com.masspick.peak.model.credit.etp.dto;



import com.masspick.peak.model.credit.etp.EtpAdvances;
import com.masspick.peak.model.credit.etp.EtpAssetHandleDebt;
import com.masspick.peak.model.credit.etp.EtpGuarantee;
import com.masspick.peak.model.credit.etp.EtpInterest;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */
public class EtpCreditClearedDebtDto {

    /**
     * 由资产管理公司处置的债务
     */
    private List<EtpAssetHandleDebt> assetHandleDebt;

    /**
     * 担保及第三方代偿信息
     */
    private List<EtpGuarantee> guarantee;

    /**
     * 欠息记录
     */
    private List<EtpInterest> interest;

    /**
     * 垫款记录
     */
    private List<EtpAdvances> advances;

    /**
     * 已还清
     */
    private EtpCreditLoanDto clearedLoan = new EtpCreditLoanDto();

    /**
     * Gets assetHandleDebt
     *
     * @return value of assetHandleDebt
     */
    public List<EtpAssetHandleDebt> getAssetHandleDebt() {
        return assetHandleDebt;
    }

    /**
     * @param assetHandleDebt
     */
    public void setAssetHandleDebt(List<EtpAssetHandleDebt> assetHandleDebt) {
        this.assetHandleDebt = assetHandleDebt;
    }

    /**
     * Gets guarantee
     *
     * @return value of guarantee
     */
    public List<EtpGuarantee> getGuarantee() {
        return guarantee;
    }

    /**
     * @param guarantee
     */
    public void setGuarantee(List<EtpGuarantee> guarantee) {
        this.guarantee = guarantee;
    }

    /**
     * Gets interest
     *
     * @return value of interest
     */
    public List<EtpInterest> getInterest() {
        return interest;
    }

    /**
     * @param interest
     */
    public void setInterest(List<EtpInterest> interest) {
        this.interest = interest;
    }

    /**
     * Gets advances
     *
     * @return value of advances
     */
    public List<EtpAdvances> getAdvances() {
        return advances;
    }

    /**
     * @param advances
     */
    public void setAdvances(List<EtpAdvances> advances) {
        this.advances = advances;
    }

    /**
     * Gets clearedLoan
     *
     * @return value of clearedLoan
     */
    public EtpCreditLoanDto getClearedLoan() {
        return clearedLoan;
    }

    /**
     * @param clearedLoan
     */
    public void setClearedLoan(EtpCreditLoanDto clearedLoan) {
        this.clearedLoan = clearedLoan;
    }
}
