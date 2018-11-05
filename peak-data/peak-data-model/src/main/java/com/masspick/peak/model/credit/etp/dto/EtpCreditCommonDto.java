package com.masspick.peak.model.credit.etp.dto;


import com.masspick.peak.model.credit.etp.EtpTaxOwed;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */
public class EtpCreditCommonDto {

    /**
     * 欠税记录
     */
    private List<EtpTaxOwed> taxOwedList;

    /**
     * Gets taxOwedList
     *
     * @return value of taxOwedList
     */
    public List<EtpTaxOwed> getTaxOwedList() {
        return taxOwedList;
    }

    /**
     * @param taxOwedList
     */
    public void setTaxOwedList(List<EtpTaxOwed> taxOwedList) {
        this.taxOwedList = taxOwedList;
    }
}
