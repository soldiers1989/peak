package com.masspick.peak.model.dto.legal;


import com.masspick.peak.model.dto.etp.EtpAbnormalDTO;
import com.masspick.peak.model.dto.etp.EtpChattelDTO;
import com.masspick.peak.model.dto.etp.EtpPunishDTO;
import com.masspick.peak.model.dto.etp.EtpStockDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/6/11 0011.
 */
public class RiskDTO implements Serializable {

    /**
     * court
     */
    private List<CourtDTO> court = new ArrayList<>();

    /**
     * courtPub
     */
    private List<CourtPubDTO> courtPub = new ArrayList<>();

    /**
     * executed
     */
    private List<ExecutedDTO> executed = new ArrayList<>();

    /**
     * breakfaith
     */
    private List<BreakfaithDTO> breakfaith = new ArrayList<>();

    /**
     * etpAbnormal
     */
    private List<EtpAbnormalDTO> etpAbnormal = new ArrayList<>();

    /**
     * etpPunish
     */
    private List<EtpPunishDTO> etpPunish = new ArrayList<>();

    /**
     * etpStock
     */
    private List<EtpStockDTO> etpStock = new ArrayList<>();

    /**
     * etpChattel
     */
    private List<EtpChattelDTO> etpChattel = new ArrayList<>();

    /**
     * relateCrdCourt
     */
    private List<CourtDTO> relateCrdCourt = new ArrayList<>();

    /**
     * Gets court
     *
     * @return value of court
     */
    public List<CourtDTO> getCourt() {
        return court;
    }

    /**
     * @param court
     */
    public void setCourt(List<CourtDTO> court) {
        this.court = court;
    }

    /**
     * Gets courtPub
     *
     * @return value of courtPub
     */
    public List<CourtPubDTO> getCourtPub() {
        return courtPub;
    }

    /**
     * @param courtPub
     */
    public void setCourtPub(List<CourtPubDTO> courtPub) {
        this.courtPub = courtPub;
    }

    /**
     * Gets executed
     *
     * @return value of executed
     */
    public List<ExecutedDTO> getExecuted() {
        return executed;
    }

    /**
     * @param executed
     */
    public void setExecuted(List<ExecutedDTO> executed) {
        this.executed = executed;
    }

    /**
     * Gets breakfaith
     *
     * @return value of breakfaith
     */
    public List<BreakfaithDTO> getBreakfaith() {
        return breakfaith;
    }

    /**
     * @param breakfaith
     */
    public void setBreakfaith(List<BreakfaithDTO> breakfaith) {
        this.breakfaith = breakfaith;
    }

    /**
     * Gets etpAbnormal
     *
     * @return value of etpAbnormal
     */
    public List<EtpAbnormalDTO> getEtpAbnormal() {
        return etpAbnormal;
    }

    /**
     * @param etpAbnormal
     */
    public void setEtpAbnormal(List<EtpAbnormalDTO> etpAbnormal) {
        this.etpAbnormal = etpAbnormal;
    }

    /**
     * Gets etpPunish
     *
     * @return value of etpPunish
     */
    public List<EtpPunishDTO> getEtpPunish() {
        return etpPunish;
    }

    /**
     * @param etpPunish
     */
    public void setEtpPunish(List<EtpPunishDTO> etpPunish) {
        this.etpPunish = etpPunish;
    }

    /**
     * Gets etpStock
     *
     * @return value of etpStock
     */
    public List<EtpStockDTO> getEtpStock() {
        return etpStock;
    }

    /**
     * @param etpStock
     */
    public void setEtpStock(List<EtpStockDTO> etpStock) {
        this.etpStock = etpStock;
    }

    /**
     * Gets etpChattel
     *
     * @return value of etpChattel
     */
    public List<EtpChattelDTO> getEtpChattel() {
        return etpChattel;
    }

    /**
     * @param etpChattel
     */
    public void setEtpChattel(List<EtpChattelDTO> etpChattel) {
        this.etpChattel = etpChattel;
    }

    /**
     * Gets relateCrdCourt
     *
     * @return value of relateCrdCourt
     */
    public List<CourtDTO> getRelateCrdCourt() {
        return relateCrdCourt;
    }

    /**
     * @param relateCrdCourt
     */
    public void setRelateCrdCourt(List<CourtDTO> relateCrdCourt) {
        this.relateCrdCourt = relateCrdCourt;
    }
}
