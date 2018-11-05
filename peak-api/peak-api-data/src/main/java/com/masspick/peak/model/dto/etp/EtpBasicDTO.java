package com.masspick.peak.model.dto.etp;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * EtpBasicDTO
 */
public class EtpBasicDTO implements Serializable {

    /**
     * creditCode
     */
    private String creditCode;

    /**
     * regState
     */
    private String regState;

    /**
     * industry
     */
    private String industry;


    /**
     * regDate
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date regDate;

    /**
     * type
     */
    private String type;

    /**
     * businessStart
     */
    private Date businessStart;

    /**
     * businessFinish
     */
    private Date businessFinish;

    /**
     * businessStartFinish
     */
    private String businessStartFinish;

    /**
     * legalRep
     */
    private String legalRep;

    /**
     * checkDate
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date checkDate;

    /**
     * regCapital
     */
    private String regCapital;

    /**
     * regOffice
     */
    private String regOffice;

    /**
     * businessScope
     */
    private String businessScope;

    /**
     * address
     */
    private String address;


    /**
     * city
     */
    private String city;

    /**
     * etpShareholder
     */
    private List<EtpShareholderDTO> etpShareholder = new ArrayList<>();

    /**
     * etpSeniorManager
     */
    private List<EtpSeniorManagerDTO> etpSeniorManager = new ArrayList<>();

    /**
     * etpBranch
     */
    private List<EtpBranchDTO> etpBranch = new ArrayList<>();


    /**
     * Gets city
     *
     * @return value of city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return List
     */
    public List<EtpBranchDTO> getEtpBranch() {
        return etpBranch;
    }


    /**
     * @param etpBranch
     */
    public void setEtpBranch(List<EtpBranchDTO> etpBranch) {
        this.etpBranch = etpBranch;
    }


    /**
     * Gets creditCode
     *
     * @return value of creditCode
     */
    public String getCreditCode() {
        return creditCode;
    }

    /**
     * @param creditCode
     */
    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    /**
     * Gets regState
     *
     * @return value of regState
     */
    public String getRegState() {
        return regState;
    }

    /**
     * @param regState
     */
    public void setRegState(String regState) {
        this.regState = regState;
    }

    /**
     * Gets industry
     *
     * @return value of industry
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * @param industry
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * Gets regDate
     *
     * @return value of regDate
     */
    public Date getRegDate() {
        return regDate;
    }

    /**
     * @param regDate
     */
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    /**
     * Gets type
     *
     * @return value of type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets businessStart
     *
     * @return value of businessStart
     */
    public Date getBusinessStart() {
        return businessStart;
    }

    /**
     * @param businessStart
     */
    public void setBusinessStart(Date businessStart) {
        this.businessStart = businessStart;
    }

    /**
     * Gets businessFinish
     *
     * @return value of businessFinish
     */
    public Date getBusinessFinish() {
        return businessFinish;
    }

    /**
     * @param businessFinish
     */
    public void setBusinessFinish(Date businessFinish) {
        this.businessFinish = businessFinish;
    }

    /**
     * Gets businessStartFinish
     *
     * @return value of businessStartFinish
     */
    public String getBusinessStartFinish() {
        return businessStartFinish;
    }

    /**
     * @param businessStartFinish
     */
    public void setBusinessStartFinish(String businessStartFinish) {
        this.businessStartFinish = businessStartFinish;
    }

    /**
     * Gets legalRep
     *
     * @return value of legalRep
     */
    public String getLegalRep() {
        return legalRep;
    }

    /**
     * @param legalRep
     */
    public void setLegalRep(String legalRep) {
        this.legalRep = legalRep;
    }

    /**
     * Gets checkDate
     *
     * @return value of checkDate
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * @param checkDate
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * Gets regCapital
     *
     * @return value of regCapital
     */
    public String getRegCapital() {
        return regCapital;
    }

    /**
     * @param regCapital
     */
    public void setRegCapital(String regCapital) {
        this.regCapital = regCapital;
    }

    /**
     * Gets regOffice
     *
     * @return value of regOffice
     */
    public String getRegOffice() {
        return regOffice;
    }

    /**
     * @param regOffice
     */
    public void setRegOffice(String regOffice) {
        this.regOffice = regOffice;
    }

    /**
     * Gets businessScope
     *
     * @return value of businessScope
     */
    public String getBusinessScope() {
        return businessScope;
    }

    /**
     * @param businessScope
     */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    /**
     * Gets address
     *
     * @return value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets etpShareholder
     *
     * @return value of etpShareholder
     */
    public List<EtpShareholderDTO> getEtpShareholder() {
        return etpShareholder;
    }

    /**
     * @param etpShareholder
     */
    public void setEtpShareholder(List<EtpShareholderDTO> etpShareholder) {
        this.etpShareholder = etpShareholder;
    }

    /**
     * Gets etpSeniorManager
     *
     * @return value of etpSeniorManager
     */
    public List<EtpSeniorManagerDTO> getEtpSeniorManager() {
        return etpSeniorManager;
    }

    /**
     * @param etpSeniorManager
     */
    public void setEtpSeniorManager(List<EtpSeniorManagerDTO> etpSeniorManager) {
        this.etpSeniorManager = etpSeniorManager;
    }
}
