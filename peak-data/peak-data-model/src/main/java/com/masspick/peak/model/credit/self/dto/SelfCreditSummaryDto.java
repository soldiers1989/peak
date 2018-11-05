package com.masspick.peak.model.credit.self.dto;


import com.masspick.peak.model.credit.self.SelfCreditStats;
import com.masspick.peak.model.credit.self.SelfDebitCardStats;
import com.masspick.peak.model.credit.self.SelfOverdueStats;
import com.masspick.peak.model.credit.self.SelfSemiCardStats;
import com.masspick.peak.model.credit.self.SelfUnclearedLoanStats;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */
public class SelfCreditSummaryDto {

    /**
     * 信用提示
     */
    private SelfCreditStats creditStats;

    /**
     * 逾期（透支）信息汇总
     */
    private List<SelfOverdueStats> overdueStats;

    /**
     * 未结清贷款信息汇总
     */
    private SelfUnclearedLoanStats unclearedLoanStats;

    /**
     * 未销户贷记卡信息汇总
     */
    private SelfDebitCardStats debitCardStats;

    /**
     * 未销户准贷记卡信息汇总
     */
    private SelfSemiCardStats semiCardStats;

    /**
     * Gets creditStats
     *
     * @return value of creditStats
     */
    public SelfCreditStats getCreditStats() {
        return creditStats;
    }

    /**
     * @param creditStats
     */
    public void setCreditStats(SelfCreditStats creditStats) {
        this.creditStats = creditStats;
    }

    /**
     * Gets overdueStats
     *
     * @return value of overdueStats
     */
    public List<SelfOverdueStats> getOverdueStats() {
        return overdueStats;
    }

    /**
     * @param overdueStats
     */
    public void setOverdueStats(List<SelfOverdueStats> overdueStats) {
        this.overdueStats = overdueStats;
    }

    /**
     * Gets unclearedLoanStats
     *
     * @return value of unclearedLoanStats
     */
    public SelfUnclearedLoanStats getUnclearedLoanStats() {
        return unclearedLoanStats;
    }

    /**
     * @param unclearedLoanStats
     */
    public void setUnclearedLoanStats(SelfUnclearedLoanStats unclearedLoanStats) {
        this.unclearedLoanStats = unclearedLoanStats;
    }

    /**
     * Gets debitCardStats
     *
     * @return value of debitCardStats
     */
    public SelfDebitCardStats getDebitCardStats() {
        return debitCardStats;
    }

    /**
     * @param debitCardStats
     */
    public void setDebitCardStats(SelfDebitCardStats debitCardStats) {
        this.debitCardStats = debitCardStats;
    }

    /**
     * Gets semiCardStats
     *
     * @return value of semiCardStats
     */
    public SelfSemiCardStats getSemiCardStats() {
        return semiCardStats;
    }

    /**
     * @param semiCardStats
     */
    public void setSemiCardStats(SelfSemiCardStats semiCardStats) {
        this.semiCardStats = semiCardStats;
    }
}
