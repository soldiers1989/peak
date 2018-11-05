package com.masspick.peak.model.credit.etp.dto;


import com.masspick.peak.model.credit.etp.EtpBA;
import com.masspick.peak.model.credit.etp.EtpBD;
import com.masspick.peak.model.credit.etp.EtpFactoring;
import com.masspick.peak.model.credit.etp.EtpGuaranteeLetter;
import com.masspick.peak.model.credit.etp.EtpLC;
import com.masspick.peak.model.credit.etp.EtpLoan;
import com.masspick.peak.model.credit.etp.EtpOtherLoan;
import com.masspick.peak.model.credit.etp.EtpTradeFinancing;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */
public class EtpCreditLoanDto {

    /**
     * 贷款
     */
    private List<EtpLoan> loanList;

    /**
     * 类贷款
     */
    private List<EtpOtherLoan> otherLoanList;

    /**
     * 贸易融资
     */
    private List<EtpTradeFinancing> tradeFinancingList;

    /**
     * 保理
     */
    private List<EtpFactoring> factoringList;

    /**
     * 票据贴现
     */
    private List<EtpBD> billDiscountedList;

    /**
     * 银行承兑汇票
     */
    private List<EtpBA> bankAcceptanceList;

    /**
     * 信用证
     */
    private List<EtpLC> letterCredit;

    /**
     * 保函
     */
    private List<EtpGuaranteeLetter> guaranteeLetter;

    /**
     * Gets loanList
     *
     * @return value of loanList
     */
    public List<EtpLoan> getLoanList() {
        return loanList;
    }

    /**
     * @param loanList
     */
    public void setLoanList(List<EtpLoan> loanList) {
        this.loanList = loanList;
    }

    /**
     * Gets otherLoanList
     *
     * @return value of otherLoanList
     */
    public List<EtpOtherLoan> getOtherLoanList() {
        return otherLoanList;
    }

    /**
     * @param otherLoanList
     */
    public void setOtherLoanList(List<EtpOtherLoan> otherLoanList) {
        this.otherLoanList = otherLoanList;
    }

    /**
     * Gets tradeFinancingList
     *
     * @return value of tradeFinancingList
     */
    public List<EtpTradeFinancing> getTradeFinancingList() {
        return tradeFinancingList;
    }

    /**
     * @param tradeFinancingList
     */
    public void setTradeFinancingList(List<EtpTradeFinancing> tradeFinancingList) {
        this.tradeFinancingList = tradeFinancingList;
    }

    /**
     * Gets factoringList
     *
     * @return value of factoringList
     */
    public List<EtpFactoring> getFactoringList() {
        return factoringList;
    }

    /**
     * @param factoringList
     */
    public void setFactoringList(List<EtpFactoring> factoringList) {
        this.factoringList = factoringList;
    }

    /**
     * Gets billDiscountedList
     *
     * @return value of billDiscountedList
     */
    public List<EtpBD> getBillDiscountedList() {
        return billDiscountedList;
    }

    /**
     * @param billDiscountedList
     */
    public void setBillDiscountedList(List<EtpBD> billDiscountedList) {
        this.billDiscountedList = billDiscountedList;
    }

    /**
     * Gets bankAcceptanceList
     *
     * @return value of bankAcceptanceList
     */
    public List<EtpBA> getBankAcceptanceList() {
        return bankAcceptanceList;
    }

    /**
     * @param bankAcceptanceList
     */
    public void setBankAcceptanceList(List<EtpBA> bankAcceptanceList) {
        this.bankAcceptanceList = bankAcceptanceList;
    }

    /**
     * Gets letterCredit
     *
     * @return value of letterCredit
     */
    public List<EtpLC> getLetterCredit() {
        return letterCredit;
    }

    /**
     * @param letterCredit
     */
    public void setLetterCredit(List<EtpLC> letterCredit) {
        this.letterCredit = letterCredit;
    }

    /**
     * Gets guaranteeLetter
     *
     * @return value of guaranteeLetter
     */
    public List<EtpGuaranteeLetter> getGuaranteeLetter() {
        return guaranteeLetter;
    }

    /**
     * @param guaranteeLetter
     */
    public void setGuaranteeLetter(List<EtpGuaranteeLetter> guaranteeLetter) {
        this.guaranteeLetter = guaranteeLetter;
    }
}
