package com.masspick.peak.model.credit.etp.dto;



import com.masspick.peak.model.credit.etp.EtpRelated;
import com.masspick.peak.model.credit.etp.EtpSeniorManager;
import com.masspick.peak.model.credit.etp.EtpShareholder;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 * 基本信息
 */
public class EtpCreditBasicDto {

    /**
     * 主要出资人信息
     */
    private List<EtpShareholder> shareholderList;

    /**
     * 高管人员信息
     */
    private List<EtpSeniorManager> seniorManagerList;

    /**
     * 有直接关联关系的其他企业
     */
    private List<EtpRelated> relatedList;

    /**
     * Gets shareholderList
     *
     * @return value of shareholderList
     */
    public List<EtpShareholder> getShareholderList() {
        return shareholderList;
    }

    /**
     * @param shareholderList
     */
    public void setShareholderList(List<EtpShareholder> shareholderList) {
        this.shareholderList = shareholderList;
    }

    /**
     * Gets seniorManagerList
     *
     * @return value of seniorManagerList
     */
    public List<EtpSeniorManager> getSeniorManagerList() {
        return seniorManagerList;
    }

    /**
     * @param seniorManagerList
     */
    public void setSeniorManagerList(List<EtpSeniorManager> seniorManagerList) {
        this.seniorManagerList = seniorManagerList;
    }

    /**
     * Gets relatedList
     *
     * @return value of relatedList
     */
    public List<EtpRelated> getRelatedList() {
        return relatedList;
    }

    /**
     * @param relatedList
     */
    public void setRelatedList(List<EtpRelated> relatedList) {
        this.relatedList = relatedList;
    }
}
