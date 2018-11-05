package com.masspick.peak.decision.model;

import java.math.BigDecimal;

/**
 * WhiteListEtp
 */
public class WhiteListEtp {

    /**
     * 企业名称
     */
    private String etpName;

    /**
     * 新老客户
     */
    private String customerType;

    /**
     * 我司已贷款总量（万元）
     */
    private BigDecimal totalLoans;

    /**
     * 营业执照号码
     */
    private String businessLicenseNo;

    /**
     * 企业经营年限（年）
     */
    private BigDecimal businessLife;

    /**
     * 注册资本/实收资本(万元）
     */
    private BigDecimal registeredPaidCapital;

    /**
     * 法定代表人姓名
     */
    private String legalName;

    /**
     * 企业经济类型
     */
    private String businessEconomyType;

    /**
     * 最大股东实际持股占比（%）
     */
    private BigDecimal largestShareholderProportion;

    /**
     * 营业执照所示经营地址
     */
    private String businessLicenseAddress;

    /**
     * 两年内重大股权变更
     */
    private String majorEquityChanges;

    /**
     * 一年内有无超过50%以上的重大股权变更或更换法人代表的情况
     */
    private String changesOrReplacement;

    /**
     * 企业或大股东有无跨行业投资，如有请写出行业，如无填写“0”
     */
    private String crossIndustryInvestment;

    /**
     * 跨省投资经营次数（次），如无填“0”
     */
    private BigDecimal interprovincialInvestmentTimes;

    /**
     * 正在大额项目投资（超过年营收的50%），投资金额为（万元），如无投资或无大项投资则填“0”
     */
    private BigDecimal largeAmountInvestment;

    /**
     * 涉诉次数（含裁、执、失、公告）（次），如无填“0”
     */
    private BigDecimal complaintsNumber;

    /**
     * 作为原告，未结案涉诉金额（万元），如无填“0”
     */
    private BigDecimal plaintiffCaseAmount;

    /**
     * 作为被告，未结案涉诉对应金额（万元），无涉诉情况填“0”
     */
    private BigDecimal defendantCaseAmount;

    /**
     * 作为被告的未结案涉诉金额且小于年营业收入5%，对应金额（万元），无涉诉情况填“0”
     */
    private BigDecimal defendantCasePercentAmount;

    /**
     * 涉诉中涉金融债或类金融债的金额（万元），无则填“0”
     */
    private BigDecimal financialCaseAmount;

    /**
     * 行政处罚记录次数（次），无则填“0”
     */
    private BigDecimal administrativePenaltyRecords;

    /**
     * 涉诉中涉金融债或类金融债的金额（万元），无则填“0”
     */
    private String administrativePunishmentAgency;

    /**
     * 行政处罚记录次数（次），无则填“0”
     */
    private BigDecimal relatedCompaniesNumber;

    /**
     * 关联公司数量（户），无则填“0'
     */
    private String relatedCompanies;

    /**
     * 关联公司涉地产或金融的，列出关联公司名，如无则填“0”
     */
    private String relatedCaseCompanies;

    /**
     * 行业分类
     */
    private String industryCategory;

    /**
     * 所在地所在行业最低税负率（%）
     */
    private BigDecimal lowestTaxRate;

    /**
     * 区域信用环境
     */
    private String regionalCreditEnvironment;

    /**
     * 当地房地产景气度
     */
    private String localEstateBoom;

    /**
     * 政府财政实力
     */
    private String governmentFinancialStrength;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 企业评分
     */
    private Double totalEtpScore;


    /**
     * Gets etpName
     *
     * @return value of etpName
     */
    public String getEtpName() {
        return etpName;
    }

    /**
     * @param etpName
     */
    public void setEtpName(String etpName) {
        this.etpName = etpName;
    }

    /**
     * Gets customerType
     *
     * @return value of customerType
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * @param customerType
     */
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    /**
     * Gets totalLoans
     *
     * @return value of totalLoans
     */
    public BigDecimal getTotalLoans() {
        return totalLoans;
    }

    /**
     * @param totalLoans
     */
    public void setTotalLoans(BigDecimal totalLoans) {
        this.totalLoans = totalLoans;
    }

    /**
     * Gets businessLicenseNo
     *
     * @return value of businessLicenseNo
     */
    public String getBusinessLicenseNo() {
        return businessLicenseNo;
    }

    /**
     * @param businessLicenseNo
     */
    public void setBusinessLicenseNo(String businessLicenseNo) {
        this.businessLicenseNo = businessLicenseNo;
    }

    /**
     * Gets businessLife
     *
     * @return value of businessLife
     */
    public BigDecimal getBusinessLife() {
        return businessLife;
    }

    /**
     * @param businessLife
     */
    public void setBusinessLife(BigDecimal businessLife) {
        this.businessLife = businessLife;
    }

    /**
     * Gets registeredPaidCapital
     *
     * @return value of registeredPaidCapital
     */
    public BigDecimal getRegisteredPaidCapital() {
        return registeredPaidCapital;
    }

    /**
     * @param registeredPaidCapital
     */
    public void setRegisteredPaidCapital(BigDecimal registeredPaidCapital) {
        this.registeredPaidCapital = registeredPaidCapital;
    }

    /**
     * Gets legalName
     *
     * @return value of legalName
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * @param legalName
     */
    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    /**
     * Gets businessEconomyType
     *
     * @return value of businessEconomyType
     */
    public String getBusinessEconomyType() {
        return businessEconomyType;
    }

    /**
     * @param businessEconomyType
     */
    public void setBusinessEconomyType(String businessEconomyType) {
        this.businessEconomyType = businessEconomyType;
    }

    /**
     * Gets largestShareholderProportion
     *
     * @return value of largestShareholderProportion
     */
    public BigDecimal getLargestShareholderProportion() {
        return largestShareholderProportion;
    }

    /**
     * @param largestShareholderProportion
     */
    public void setLargestShareholderProportion(BigDecimal largestShareholderProportion) {
        this.largestShareholderProportion = largestShareholderProportion;
    }

    /**
     * Gets businessLicenseAddress
     *
     * @return value of businessLicenseAddress
     */
    public String getBusinessLicenseAddress() {
        return businessLicenseAddress;
    }

    /**
     * @param businessLicenseAddress
     */
    public void setBusinessLicenseAddress(String businessLicenseAddress) {
        this.businessLicenseAddress = businessLicenseAddress;
    }

    /**
     * Gets majorEquityChanges
     *
     * @return value of majorEquityChanges
     */
    public String getMajorEquityChanges() {
        return majorEquityChanges;
    }

    /**
     * @param majorEquityChanges
     */
    public void setMajorEquityChanges(String majorEquityChanges) {
        this.majorEquityChanges = majorEquityChanges;
    }

    /**
     * Gets changesOrReplacement
     *
     * @return value of changesOrReplacement
     */
    public String getChangesOrReplacement() {
        return changesOrReplacement;
    }

    /**
     * @param changesOrReplacement
     */
    public void setChangesOrReplacement(String changesOrReplacement) {
        this.changesOrReplacement = changesOrReplacement;
    }

    /**
     * Gets crossIndustryInvestment
     *
     * @return value of crossIndustryInvestment
     */
    public String getCrossIndustryInvestment() {
        return crossIndustryInvestment;
    }

    /**
     * @param crossIndustryInvestment
     */
    public void setCrossIndustryInvestment(String crossIndustryInvestment) {
        this.crossIndustryInvestment = crossIndustryInvestment;
    }

    /**
     * Gets interprovincialInvestmentTimes
     *
     * @return value of interprovincialInvestmentTimes
     */
    public BigDecimal getInterprovincialInvestmentTimes() {
        return interprovincialInvestmentTimes;
    }

    /**
     * @param interprovincialInvestmentTimes
     */
    public void setInterprovincialInvestmentTimes(BigDecimal interprovincialInvestmentTimes) {
        this.interprovincialInvestmentTimes = interprovincialInvestmentTimes;
    }

    /**
     * Gets largeAmountInvestment
     *
     * @return value of largeAmountInvestment
     */
    public BigDecimal getLargeAmountInvestment() {
        return largeAmountInvestment;
    }

    /**
     * @param largeAmountInvestment
     */
    public void setLargeAmountInvestment(BigDecimal largeAmountInvestment) {
        this.largeAmountInvestment = largeAmountInvestment;
    }

    /**
     * Gets complaintsNumber
     *
     * @return value of complaintsNumber
     */
    public BigDecimal getComplaintsNumber() {
        return complaintsNumber;
    }

    /**
     * @param complaintsNumber
     */
    public void setComplaintsNumber(BigDecimal complaintsNumber) {
        this.complaintsNumber = complaintsNumber;
    }

    /**
     * Gets plaintiffCaseAmount
     *
     * @return value of plaintiffCaseAmount
     */
    public BigDecimal getPlaintiffCaseAmount() {
        return plaintiffCaseAmount;
    }

    /**
     * @param plaintiffCaseAmount
     */
    public void setPlaintiffCaseAmount(BigDecimal plaintiffCaseAmount) {
        this.plaintiffCaseAmount = plaintiffCaseAmount;
    }

    /**
     * Gets defendantCaseAmount
     *
     * @return value of defendantCaseAmount
     */
    public BigDecimal getDefendantCaseAmount() {
        return defendantCaseAmount;
    }

    /**
     * @param defendantCaseAmount
     */
    public void setDefendantCaseAmount(BigDecimal defendantCaseAmount) {
        this.defendantCaseAmount = defendantCaseAmount;
    }

    /**
     * Gets defendantCasePercentAmount
     *
     * @return value of defendantCasePercentAmount
     */
    public BigDecimal getDefendantCasePercentAmount() {
        return defendantCasePercentAmount;
    }

    /**
     * @param defendantCasePercentAmount
     */
    public void setDefendantCasePercentAmount(BigDecimal defendantCasePercentAmount) {
        this.defendantCasePercentAmount = defendantCasePercentAmount;
    }

    /**
     * Gets financialCaseAmount
     *
     * @return value of financialCaseAmount
     */
    public BigDecimal getFinancialCaseAmount() {
        return financialCaseAmount;
    }

    /**
     * @param financialCaseAmount
     */
    public void setFinancialCaseAmount(BigDecimal financialCaseAmount) {
        this.financialCaseAmount = financialCaseAmount;
    }

    /**
     * Gets administrativePenaltyRecords
     *
     * @return value of administrativePenaltyRecords
     */
    public BigDecimal getAdministrativePenaltyRecords() {
        return administrativePenaltyRecords;
    }

    /**
     * @param administrativePenaltyRecords
     */
    public void setAdministrativePenaltyRecords(BigDecimal administrativePenaltyRecords) {
        this.administrativePenaltyRecords = administrativePenaltyRecords;
    }

    /**
     * Gets administrativePunishmentAgency
     *
     * @return value of administrativePunishmentAgency
     */
    public String getAdministrativePunishmentAgency() {
        return administrativePunishmentAgency;
    }

    /**
     * @param administrativePunishmentAgency
     */
    public void setAdministrativePunishmentAgency(String administrativePunishmentAgency) {
        this.administrativePunishmentAgency = administrativePunishmentAgency;
    }

    /**
     * Gets relatedCompaniesNumber
     *
     * @return value of relatedCompaniesNumber
     */
    public BigDecimal getRelatedCompaniesNumber() {
        return relatedCompaniesNumber;
    }

    /**
     * @param relatedCompaniesNumber
     */
    public void setRelatedCompaniesNumber(BigDecimal relatedCompaniesNumber) {
        this.relatedCompaniesNumber = relatedCompaniesNumber;
    }

    /**
     * Gets relatedCompanies
     *
     * @return value of relatedCompanies
     */
    public String getRelatedCompanies() {
        return relatedCompanies;
    }

    /**
     * @param relatedCompanies
     */
    public void setRelatedCompanies(String relatedCompanies) {
        this.relatedCompanies = relatedCompanies;
    }

    /**
     * Gets relatedCaseCompanies
     *
     * @return value of relatedCaseCompanies
     */
    public String getRelatedCaseCompanies() {
        return relatedCaseCompanies;
    }

    /**
     * @param relatedCaseCompanies
     */
    public void setRelatedCaseCompanies(String relatedCaseCompanies) {
        this.relatedCaseCompanies = relatedCaseCompanies;
    }

    /**
     * Gets industryCategory
     *
     * @return value of industryCategory
     */
    public String getIndustryCategory() {
        return industryCategory;
    }

    /**
     * @param industryCategory
     */
    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory;
    }

    /**
     * Gets lowestTaxRate
     *
     * @return value of lowestTaxRate
     */
    public BigDecimal getLowestTaxRate() {
        return lowestTaxRate;
    }

    /**
     * @param lowestTaxRate
     */
    public void setLowestTaxRate(BigDecimal lowestTaxRate) {
        this.lowestTaxRate = lowestTaxRate;
    }

    /**
     * Gets regionalCreditEnvironment
     *
     * @return value of regionalCreditEnvironment
     */
    public String getRegionalCreditEnvironment() {
        return regionalCreditEnvironment;
    }

    /**
     * @param regionalCreditEnvironment
     */
    public void setRegionalCreditEnvironment(String regionalCreditEnvironment) {
        this.regionalCreditEnvironment = regionalCreditEnvironment;
    }

    /**
     * Gets localEstateBoom
     *
     * @return value of localEstateBoom
     */
    public String getLocalEstateBoom() {
        return localEstateBoom;
    }

    /**
     * @param localEstateBoom
     */
    public void setLocalEstateBoom(String localEstateBoom) {
        this.localEstateBoom = localEstateBoom;
    }

    /**
     * Gets governmentFinancialStrength
     *
     * @return value of governmentFinancialStrength
     */
    public String getGovernmentFinancialStrength() {
        return governmentFinancialStrength;
    }

    /**
     * @param governmentFinancialStrength
     */
    public void setGovernmentFinancialStrength(String governmentFinancialStrength) {
        this.governmentFinancialStrength = governmentFinancialStrength;
    }

    /**
     * Gets province
     *
     * @return value of province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Gets city
     *
     * @return value of city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets area
     *
     * @return value of area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * Gets totalEtpScore
     *
     * @return value of totalEtpScore
     */
    public Double getTotalEtpScore() {
        return totalEtpScore;
    }

    /**
     * @param totalEtpScore
     */
    public void setTotalEtpScore(Double totalEtpScore) {
        this.totalEtpScore = totalEtpScore;
    }
}
