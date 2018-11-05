package com.masspick.peak.model.credit.etp;

import java.util.Date;

/**
 * etp_credit_report
 * 征信报告基本信息
 */
public class EtpCreditReport {
    /**
     * 征信报告编号
     */
    private String id;

    /**
     * 报告时间
     */
    private Date reportDate;

    /**
     * 企业名称
     */
    private String entName;

    /**
     * 地址
     */
    private String address;

    /**
     * 登记注册类型
     */
    private String regType;

    /**
     * 登记注册号
     */
    private String regNo;

    /**
     * 登记注册日期
     */
    private String regDate;

    /**
     * 营业期限至
     */
    private Date businessFinish;

    /**
     * 组织机构代码
     */
    private String orgNo;

    /**
     * eigenCode
     */
    private String eigenCode;

    /**
     * 国税登记号
     */
    private String nationTaxRegMark;

    /**
     * 地税登记号
     */
    private String landTaxRegMark;

    /**
     * 注册资本（万）
     */
    private String regCapital;

    /**
     * 信贷信息概要
     */
    private String creditDesc;

    /**
     * 征信报告编号
     * @return id 征信报告编号
     */
    public String getId() {
        return id;
    }

    /**
     * 征信报告编号
     * @param id 征信报告编号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 报告时间
     * @return report_date 报告时间
     */
    public Date getReportDate() {
        return reportDate;
    }

    /**
     * 报告时间
     * @param reportDate 报告时间
     */
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    /**
     * 企业名称
     * @return ent_name 企业名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 企业名称
     * @param entName 企业名称
     */
    public void setEntName(String entName) {
        this.entName = entName == null ? null : entName.trim();
    }

    /**
     * 地址
     * @return address 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 登记注册类型
     * @return reg_type 登记注册类型
     */
    public String getRegType() {
        return regType;
    }

    /**
     * 登记注册类型
     * @param regType 登记注册类型
     */
    public void setRegType(String regType) {
        this.regType = regType == null ? null : regType.trim();
    }

    /**
     * 登记注册号
     * @return reg_no 登记注册号
     */
    public String getRegNo() {
        return regNo;
    }

    /**
     * 登记注册号
     * @param regNo 登记注册号
     */
    public void setRegNo(String regNo) {
        this.regNo = regNo == null ? null : regNo.trim();
    }

    /**
     * 登记注册日期
     * @return reg_date 登记注册日期
     */
    public String getRegDate() {
        return regDate;
    }

    /**
     * 登记注册日期
     * @param regDate 登记注册日期
     */
    public void setRegDate(String regDate) {
        this.regDate = regDate == null ? null : regDate.trim();
    }

    /**
     * 营业期限至
     * @return business_finish 营业期限至
     */
    public Date getBusinessFinish() {
        return businessFinish;
    }

    /**
     * 营业期限至
     * @param businessFinish 营业期限至
     */
    public void setBusinessFinish(Date businessFinish) {
        this.businessFinish = businessFinish;
    }

    /**
     * 组织机构代码
     * @return org_no 组织机构代码
     */
    public String getOrgNo() {
        return orgNo;
    }

    /**
     * 组织机构代码
     * @param orgNo 组织机构代码
     */
    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo == null ? null : orgNo.trim();
    }

    /**
     * eigenCode
     * @return eigen_code eigenCode
     */
    public String getEigenCode() {
        return eigenCode;
    }

    /**
     * eigenCode
     * @param eigenCode eigenCode
     */
    public void setEigenCode(String eigenCode) {
        this.eigenCode = eigenCode == null ? null : eigenCode.trim();
    }

    /**
     * 国税登记号
     * @return nation_tax_reg_mark 国税登记号
     */
    public String getNationTaxRegMark() {
        return nationTaxRegMark;
    }

    /**
     * 国税登记号
     * @param nationTaxRegMark 国税登记号
     */
    public void setNationTaxRegMark(String nationTaxRegMark) {
        this.nationTaxRegMark = nationTaxRegMark == null ? null : nationTaxRegMark.trim();
    }

    /**
     * 地税登记号
     * @return land_tax_reg_mark 地税登记号
     */
    public String getLandTaxRegMark() {
        return landTaxRegMark;
    }

    /**
     * 地税登记号
     * @param landTaxRegMark 地税登记号
     */
    public void setLandTaxRegMark(String landTaxRegMark) {
        this.landTaxRegMark = landTaxRegMark == null ? null : landTaxRegMark.trim();
    }

    /**
     * 注册资本（万）
     * @return reg_capital 注册资本（万）
     */
    public String getRegCapital() {
        return regCapital;
    }

    /**
     * 注册资本（万）
     * @param regCapital 注册资本（万）
     */
    public void setRegCapital(String regCapital) {
        this.regCapital = regCapital == null ? null : regCapital.trim();
    }

    /**
     * 信贷信息概要
     * @return credit_desc 信贷信息概要
     */
    public String getCreditDesc() {
        return creditDesc;
    }

    /**
     * 信贷信息概要
     * @param creditDesc 信贷信息概要
     */
    public void setCreditDesc(String creditDesc) {
        this.creditDesc = creditDesc == null ? null : creditDesc.trim();
    }
}
