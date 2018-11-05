package com.masspick.peak.model.credit.self.dto;


import com.masspick.peak.model.credit.self.Self;
import com.masspick.peak.model.credit.self.SelfAddress;
import com.masspick.peak.model.credit.self.SelfCouple;
import com.masspick.peak.model.credit.self.SelfCreditReport;
import com.masspick.peak.model.credit.self.SelfHouseFund;
import com.masspick.peak.model.credit.self.SelfLoanApprovalRecord;
import com.masspick.peak.model.credit.self.SelfProfession;
import com.masspick.peak.model.credit.self.SelfSearchRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */
public class SelfCreditReportDto extends SelfCreditReport {

    /**
     * 身份信息
     */
    private Self self;

    /**
     * 居住信息
     */
    private List<SelfAddress> addressList;

    /**
     * 职业信息
     */
    private List<SelfProfession> professionList;

    /**
     * 配偶信息
     */
    private SelfCouple couple;

    /**
     * 信息概要
     */
    private SelfCreditSummaryDto creditSummary = new SelfCreditSummaryDto();

    /**
     * 贷款
     */
    private List<SelfLoanDto> loanList = new ArrayList<>();

    /**
     * 贷记卡
     */
    private List<SelfDebitCardDto> debitCardList = new ArrayList<>();

    /**
     * 准贷记卡
     */
    private List<SelfSemiDebitCardDto> semiDebitCardList = new ArrayList<>();

    /**
     * 住房公积金参缴记录
     */
    private List<SelfHouseFund> houseFundList;

    /**
     * 查询记录汇总
     */
    private SelfSearchRecord searchRecord;

    /**
     * 信贷审批查询记录明细
     */
    private List<SelfLoanApprovalRecord> loanApprovalRecordList;

    /**
     * Gets self
     *
     * @return value of self
     */
    public Self getSelf() {
        return self;
    }

    /**
     * @param self
     */
    public void setSelf(Self self) {
        this.self = self;
    }

    /**
     * Gets addressList
     *
     * @return value of addressList
     */
    public List<SelfAddress> getAddressList() {
        return addressList;
    }

    /**
     * @param addressList
     */
    public void setAddressList(List<SelfAddress> addressList) {
        this.addressList = addressList;
    }

    /**
     * Gets professionList
     *
     * @return value of professionList
     */
    public List<SelfProfession> getProfessionList() {
        return professionList;
    }

    /**
     * @param professionList
     */
    public void setProfessionList(List<SelfProfession> professionList) {
        this.professionList = professionList;
    }

    /**
     * Gets couple
     *
     * @return value of couple
     */
    public SelfCouple getCouple() {
        return couple;
    }

    /**
     * @param couple
     */
    public void setCouple(SelfCouple couple) {
        this.couple = couple;
    }

    /**
     * Gets creditSummary
     *
     * @return value of creditSummary
     */
    public SelfCreditSummaryDto getCreditSummary() {
        return creditSummary;
    }

    /**
     * @param creditSummary
     */
    public void setCreditSummary(SelfCreditSummaryDto creditSummary) {
        this.creditSummary = creditSummary;
    }

    /**
     * Gets loanList
     *
     * @return value of loanList
     */
    public List<SelfLoanDto> getLoanList() {
        return loanList;
    }

    /**
     * @param loanList
     */
    public void setLoanList(List<SelfLoanDto> loanList) {
        this.loanList = loanList;
    }

    /**
     * Gets debitCardList
     *
     * @return value of debitCardList
     */
    public List<SelfDebitCardDto> getDebitCardList() {
        return debitCardList;
    }

    /**
     * @param debitCardList
     */
    public void setDebitCardList(List<SelfDebitCardDto> debitCardList) {
        this.debitCardList = debitCardList;
    }

    /**
     * Gets semiDebitCardList
     *
     * @return value of semiDebitCardList
     */
    public List<SelfSemiDebitCardDto> getSemiDebitCardList() {
        return semiDebitCardList;
    }

    /**
     * @param semiDebitCardList
     */
    public void setSemiDebitCardList(List<SelfSemiDebitCardDto> semiDebitCardList) {
        this.semiDebitCardList = semiDebitCardList;
    }

    /**
     * Gets houseFundList
     *
     * @return value of houseFundList
     */
    public List<SelfHouseFund> getHouseFundList() {
        return houseFundList;
    }

    /**
     * @param houseFundList
     */
    public void setHouseFundList(List<SelfHouseFund> houseFundList) {
        this.houseFundList = houseFundList;
    }

    /**
     * Gets searchRecord
     *
     * @return value of searchRecord
     */
    public SelfSearchRecord getSearchRecord() {
        return searchRecord;
    }

    /**
     * @param searchRecord
     */
    public void setSearchRecord(SelfSearchRecord searchRecord) {
        this.searchRecord = searchRecord;
    }

    /**
     * Gets loanApprovalRecordList
     *
     * @return value of loanApprovalRecordList
     */
    public List<SelfLoanApprovalRecord> getLoanApprovalRecordList() {
        return loanApprovalRecordList;
    }

    /**
     * @param loanApprovalRecordList
     */
    public void setLoanApprovalRecordList(List<SelfLoanApprovalRecord> loanApprovalRecordList) {
        this.loanApprovalRecordList = loanApprovalRecordList;
    }
}
