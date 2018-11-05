package com.masspick.peak.guest.vo.manage;

import java.util.List;

/**
 * EtpCerInviteVo
 */
public class EtpCerInviteVo {

    /**
     * month
     */
    private String month;

    /**
     * totalInvite
     */
    private String totalInvite;

    /**
     * etpList
     */
    private List<EtpCerInvitePageVo> etpList;

    /**
     *
     * @return String
     */
    public String getMonth() {
        return month;
    }

    /**
     *
     * @param month month
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     *
     * @return String
     */
    public String getTotalInvite() {
        return totalInvite;
    }

    /**
     *
     * @param totalInvite totalInvite
     */
    public void setTotalInvite(String totalInvite) {
        this.totalInvite = totalInvite;
    }

    /**
     *
     * @return List
     */
    public List<EtpCerInvitePageVo> getEtpList() {
        return etpList;
    }

    /**
     *
     * @param etpList etpList
     */
    public void setEtpList(List<EtpCerInvitePageVo> etpList) {
        this.etpList = etpList;
    }
}
