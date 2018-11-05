package com.masspick.peak.guest.vo.manage;

import com.masspick.peak.guest.bo.LoanEtpVo;

import java.util.List;

/**
 * LoanInviteVo
 */
public class LoanInviteVo {

    /**
     * month
     */
    private String month;

    /**
     * totalInvite
     */
    private String totalInvite;

    /**
     * etpDetails
     */
    private List<LoanEtpVo> etpDetails;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTotalInvite() {
        return totalInvite;
    }

    public void setTotalInvite(String totalInvite) {
        this.totalInvite = totalInvite;
    }

    public List<LoanEtpVo> getEtpDetails() {
        return etpDetails;
    }

    public void setEtpDetails(List<LoanEtpVo> etpDetails) {
        this.etpDetails = etpDetails;
    }
}
