package com.masspick.peak.model.dto.tax;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * Created by Administrator on 2018\6\12 0012.
 */
public class TaxDTO {

    /**
     * 登记信息
     */
    @JsonProperty(value = "djxx", access = JsonProperty.Access.READ_ONLY)
    private List<TaxRegInfo> taxRegInfoList;

    /**
     * 纳税信用等级信息
     */
    @JsonProperty(value = "nsxydjxx", access = JsonProperty.Access.READ_ONLY)
    private List<TaxGradeInfo> taxGradeInfoList;

    /**
     * 申报信息
     */
    @JsonProperty(value = "sbxx", access = JsonProperty.Access.READ_ONLY)
    private List<TaxDeclareInfo> taxDeclareInfoList;

    /**
     * 征收信息
     */
    @JsonProperty(value = "zsxx", access = JsonProperty.Access.READ_ONLY)
    private List<TaxLevyInfo> taxLevyInfoList;

    /**
     * 违法信息
     */
    @JsonProperty(value = "wfxx", access = JsonProperty.Access.READ_ONLY)
    private List<TaxIllegalInfo> taxIllegalInfoList;

    /**
     * 稽查信息
     */
    @JsonProperty(value = "jcxx", access = JsonProperty.Access.READ_ONLY)
    private List<TaxInspectInfo> taxInspectInfoList;

    /**
     * 利润表（适用于会计制度的企业）
     */
    @JsonProperty(value = "cwbbxqykjzzlrb", access = JsonProperty.Access.READ_ONLY)
    private List<TaxProfitMirco> taxProfitMircoList;

    /**
     * 利润表（适用执行小企业会计制度的企业）_年报
     */
    @JsonProperty(value = "cwbbxqykjzzlrbnb", access = JsonProperty.Access.READ_ONLY)
    private List<TaxProfitMircoReport> taxProfitMircoReportList;

    /**
     * 资产负债表（适用执行小企业会计制度的企业
     */
    @JsonProperty(value = "cwbbxqykjzzzcfzb", access = JsonProperty.Access.READ_ONLY)
    private List<TaxBalanceMicro> taxBalanceMicroList;

    /**
     * 利润表（适用执行一般企业会计制度的企业）
     */
    @JsonProperty(value = "cwbbxqykjzzybqylrb", access = JsonProperty.Access.READ_ONLY)
    private List<TaxProfitNormal> taxProfitNormalList;

    /**
     * 所有者权益（或股东权益）增减变动表（适用执行一般企业会计制度的企业）
     */
    @JsonProperty(value = "cwbbqykjzzybqysyzqy", access = JsonProperty.Access.READ_ONLY)
    private List<TaxEquityChangeNormal> taxEquityChangeNormalList;

    /**
     * 资产负债表（适用执行一般企业会计制度的企业）
     */
    @JsonProperty(value = "cwbbqykjzzybqyzcfzb", access = JsonProperty.Access.READ_ONLY)
    private List<TaxBalanceNormal> taxBalanceNormalList;

    /**
     * Gets taxRegInfoList
     *
     * @return value of taxRegInfoList
     */
    public List<TaxRegInfo> getTaxRegInfoList() {
        return taxRegInfoList;
    }

    /**
     * @param taxRegInfoList
     */
    public void setTaxRegInfoList(List<TaxRegInfo> taxRegInfoList) {
        this.taxRegInfoList = taxRegInfoList;
    }

    /**
     * Gets taxGradeInfoList
     *
     * @return value of taxGradeInfoList
     */
    public List<TaxGradeInfo> getTaxGradeInfoList() {
        return taxGradeInfoList;
    }

    /**
     * @param taxGradeInfoList
     */
    public void setTaxGradeInfoList(List<TaxGradeInfo> taxGradeInfoList) {
        this.taxGradeInfoList = taxGradeInfoList;
    }

    /**
     * Gets taxDeclareInfoList
     *
     * @return value of taxDeclareInfoList
     */
    public List<TaxDeclareInfo> getTaxDeclareInfoList() {
        return taxDeclareInfoList;
    }

    /**
     * @param taxDeclareInfoList
     */
    public void setTaxDeclareInfoList(List<TaxDeclareInfo> taxDeclareInfoList) {
        this.taxDeclareInfoList = taxDeclareInfoList;
    }

    /**
     * Gets taxLevyInfoList
     *
     * @return value of taxLevyInfoList
     */
    public List<TaxLevyInfo> getTaxLevyInfoList() {
        return taxLevyInfoList;
    }

    /**
     * @param taxLevyInfoList
     */
    public void setTaxLevyInfoList(List<TaxLevyInfo> taxLevyInfoList) {
        this.taxLevyInfoList = taxLevyInfoList;
    }

    /**
     * Gets taxIllegalInfoList
     *
     * @return value of taxIllegalInfoList
     */
    public List<TaxIllegalInfo> getTaxIllegalInfoList() {
        return taxIllegalInfoList;
    }

    /**
     * @param taxIllegalInfoList
     */
    public void setTaxIllegalInfoList(List<TaxIllegalInfo> taxIllegalInfoList) {
        this.taxIllegalInfoList = taxIllegalInfoList;
    }

    /**
     * Gets taxInspectInfoList
     *
     * @return value of taxInspectInfoList
     */
    public List<TaxInspectInfo> getTaxInspectInfoList() {
        return taxInspectInfoList;
    }

    /**
     * @param taxInspectInfoList
     */
    public void setTaxInspectInfoList(List<TaxInspectInfo> taxInspectInfoList) {
        this.taxInspectInfoList = taxInspectInfoList;
    }

    /**
     * Gets taxProfitMircoList
     *
     * @return value of taxProfitMircoList
     */
    public List<TaxProfitMirco> getTaxProfitMircoList() {
        return taxProfitMircoList;
    }

    /**
     * @param taxProfitMircoList
     */
    public void setTaxProfitMircoList(List<TaxProfitMirco> taxProfitMircoList) {
        this.taxProfitMircoList = taxProfitMircoList;
    }

    /**
     * Gets taxProfitMircoReportList
     *
     * @return value of taxProfitMircoReportList
     */
    public List<TaxProfitMircoReport> getTaxProfitMircoReportList() {
        return taxProfitMircoReportList;
    }

    /**
     * @param taxProfitMircoReportList
     */
    public void setTaxProfitMircoReportList(List<TaxProfitMircoReport> taxProfitMircoReportList) {
        this.taxProfitMircoReportList = taxProfitMircoReportList;
    }

    /**
     * Gets taxBalanceMicroList
     *
     * @return value of taxBalanceMicroList
     */
    public List<TaxBalanceMicro> getTaxBalanceMicroList() {
        return taxBalanceMicroList;
    }

    /**
     * @param taxBalanceMicroList
     */
    public void setTaxBalanceMicroList(List<TaxBalanceMicro> taxBalanceMicroList) {
        this.taxBalanceMicroList = taxBalanceMicroList;
    }

    /**
     * Gets taxProfitNormalList
     *
     * @return value of taxProfitNormalList
     */
    public List<TaxProfitNormal> getTaxProfitNormalList() {
        return taxProfitNormalList;
    }

    /**
     * @param taxProfitNormalList
     */
    public void setTaxProfitNormalList(List<TaxProfitNormal> taxProfitNormalList) {
        this.taxProfitNormalList = taxProfitNormalList;
    }

    /**
     * Gets taxEquityChangeNormalList
     *
     * @return value of taxEquityChangeNormalList
     */
    public List<TaxEquityChangeNormal> getTaxEquityChangeNormalList() {
        return taxEquityChangeNormalList;
    }

    /**
     * @param taxEquityChangeNormalList
     */
    public void setTaxEquityChangeNormalList(List<TaxEquityChangeNormal> taxEquityChangeNormalList) {
        this.taxEquityChangeNormalList = taxEquityChangeNormalList;
    }

    /**
     * Gets taxBalanceNormalList
     *
     * @return value of taxBalanceNormalList
     */
    public List<TaxBalanceNormal> getTaxBalanceNormalList() {
        return taxBalanceNormalList;
    }

    /**
     * @param taxBalanceNormalList
     */
    public void setTaxBalanceNormalList(List<TaxBalanceNormal> taxBalanceNormalList) {
        this.taxBalanceNormalList = taxBalanceNormalList;
    }
}
