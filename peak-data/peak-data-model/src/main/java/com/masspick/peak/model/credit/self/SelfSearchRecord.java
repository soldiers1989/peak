package com.masspick.peak.model.credit.self;

/**
 * self_search_record
 * 查询记录汇总
 */
public class SelfSearchRecord {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 最近1个月内的查询机构数: 贷款审批
     */
    private Integer institutionSearchByLoan;

    /**
     * 最近1个月内的查询机构数: 信用卡审批
     */
    private Integer institutionSearchByCreditCard;

    /**
     * 最近1个月内的查询次数: 贷款审批
     */
    private Integer searchByLoan;

    /**
     * 最近1个月内的查询次数: 信用卡审批
     */
    private Integer searchByCreditCard;

    /**
     * 最近1个月内的查询次数: 本人查询
     */
    private Integer searchBySelf;

    /**
     * 最近2年内的查询次数: 贷后管理
     */
    private Integer searchByPostLoan;

    /**
     * 最近2年内的查询次数: 担保资格审查
     */
    private Integer searchByGuarantee;

    /**
     * 最近2年内的查询次数: 特约商户实名审查
     */
    private Integer searchBySpecialMerchant;

    /**
     * id
     *
     * @return id id
     */
    public String getId() {
        return id;
    }

    /**
     * id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 征信报告id
     *
     * @return report_id 征信报告id
     */
    public String getReportId() {
        return reportId;
    }

    /**
     * 征信报告id
     *
     * @param reportId 征信报告id
     */
    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    /**
     * 最近1个月内的查询机构数: 贷款审批
     *
     * @return institution_search_by_loan 最近1个月内的查询机构数: 贷款审批
     */
    public Integer getInstitutionSearchByLoan() {
        return institutionSearchByLoan;
    }

    /**
     * 最近1个月内的查询机构数: 贷款审批
     *
     * @param institutionSearchByLoan 最近1个月内的查询机构数: 贷款审批
     */
    public void setInstitutionSearchByLoan(Integer institutionSearchByLoan) {
        this.institutionSearchByLoan = institutionSearchByLoan;
    }

    /**
     * 最近1个月内的查询机构数: 信用卡审批
     *
     * @return institution_search_by_credit_card 最近1个月内的查询机构数: 信用卡审批
     */
    public Integer getInstitutionSearchByCreditCard() {
        return institutionSearchByCreditCard;
    }

    /**
     * 最近1个月内的查询机构数: 信用卡审批
     *
     * @param institutionSearchByCreditCard 最近1个月内的查询机构数: 信用卡审批
     */
    public void setInstitutionSearchByCreditCard(Integer institutionSearchByCreditCard) {
        this.institutionSearchByCreditCard = institutionSearchByCreditCard;
    }

    /**
     * 最近1个月内的查询次数: 贷款审批
     *
     * @return search_by_loan 最近1个月内的查询次数: 贷款审批
     */
    public Integer getSearchByLoan() {
        return searchByLoan;
    }

    /**
     * 最近1个月内的查询次数: 贷款审批
     *
     * @param searchByLoan 最近1个月内的查询次数: 贷款审批
     */
    public void setSearchByLoan(Integer searchByLoan) {
        this.searchByLoan = searchByLoan;
    }

    /**
     * 最近1个月内的查询次数: 信用卡审批
     *
     * @return search_by_credit_card 最近1个月内的查询次数: 信用卡审批
     */
    public Integer getSearchByCreditCard() {
        return searchByCreditCard;
    }

    /**
     * 最近1个月内的查询次数: 信用卡审批
     *
     * @param searchByCreditCard 最近1个月内的查询次数: 信用卡审批
     */
    public void setSearchByCreditCard(Integer searchByCreditCard) {
        this.searchByCreditCard = searchByCreditCard;
    }

    /**
     * 最近1个月内的查询次数: 本人查询
     *
     * @return search_by_self 最近1个月内的查询次数: 本人查询
     */
    public Integer getSearchBySelf() {
        return searchBySelf;
    }

    /**
     * 最近1个月内的查询次数: 本人查询
     *
     * @param searchBySelf 最近1个月内的查询次数: 本人查询
     */
    public void setSearchBySelf(Integer searchBySelf) {
        this.searchBySelf = searchBySelf;
    }

    /**
     * 最近2年内的查询次数: 贷后管理
     *
     * @return search_by_post_loan 最近2年内的查询次数: 贷后管理
     */
    public Integer getSearchByPostLoan() {
        return searchByPostLoan;
    }

    /**
     * 最近2年内的查询次数: 贷后管理
     *
     * @param searchByPostLoan 最近2年内的查询次数: 贷后管理
     */
    public void setSearchByPostLoan(Integer searchByPostLoan) {
        this.searchByPostLoan = searchByPostLoan;
    }

    /**
     * 最近2年内的查询次数: 担保资格审查
     *
     * @return search_by_guarantee 最近2年内的查询次数: 担保资格审查
     */
    public Integer getSearchByGuarantee() {
        return searchByGuarantee;
    }

    /**
     * 最近2年内的查询次数: 担保资格审查
     *
     * @param searchByGuarantee 最近2年内的查询次数: 担保资格审查
     */
    public void setSearchByGuarantee(Integer searchByGuarantee) {
        this.searchByGuarantee = searchByGuarantee;
    }

    /**
     * 最近2年内的查询次数: 特约商户实名审查
     *
     * @return search_by_special_merchant 最近2年内的查询次数: 特约商户实名审查
     */
    public Integer getSearchBySpecialMerchant() {
        return searchBySpecialMerchant;
    }

    /**
     * 最近2年内的查询次数: 特约商户实名审查
     *
     * @param searchBySpecialMerchant 最近2年内的查询次数: 特约商户实名审查
     */
    public void setSearchBySpecialMerchant(Integer searchBySpecialMerchant) {
        this.searchBySpecialMerchant = searchBySpecialMerchant;
    }
}
