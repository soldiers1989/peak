package com.masspick.peak.model.credit.etp;

/**
 * etp_shareholder
 * 股东出资信息
 */
public class EtpShareholder {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 股东
     */
    private String shareholder;

    /**
     * 证件号
     */
    private String cardNo;

    /**
     * 证件类型
     */
    private String cardType;

    /**
     * 证件类型名称
     */
    private String cardTypeName;

    /**
     * 认缴额(万元)
     */
    private Double confusingAmount;

    /**
     * 认缴额占比
     */
    private String confusingAmountRatio;

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
     * 股东
     *
     * @return shareholder 股东
     */
    public String getShareholder() {
        return shareholder;
    }

    /**
     * 股东
     *
     * @param shareholder 股东
     */
    public void setShareholder(String shareholder) {
        this.shareholder = shareholder == null ? null : shareholder.trim();
    }

    /**
     * 证件号
     *
     * @return card_no 证件号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 证件号
     *
     * @param cardNo 证件号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 证件类型
     *
     * @return card_type 证件类型
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * 证件类型
     *
     * @param cardType 证件类型
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * 证件类型名称
     *
     * @return card_type_name 证件类型名称
     */
    public String getCardTypeName() {
        return cardTypeName;
    }

    /**
     * 证件类型名称
     *
     * @param cardTypeName 证件类型名称
     */
    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName == null ? null : cardTypeName.trim();
    }

    /**
     * 认缴额(万元)
     *
     * @return confusing_amount 认缴额(万元)
     */
    public Double getConfusingAmount() {
        return confusingAmount;
    }

    /**
     * 认缴额(万元)
     *
     * @param confusingAmount 认缴额(万元)
     */
    public void setConfusingAmount(Double confusingAmount) {
        this.confusingAmount = confusingAmount;
    }

    /**
     * 认缴额占比
     *
     * @return confusing_amount_ratio 认缴额占比
     */
    public String getConfusingAmountRatio() {
        return confusingAmountRatio;
    }

    /**
     * 认缴额占比
     *
     * @param confusingAmountRatio 认缴额占比
     */
    public void setConfusingAmountRatio(String confusingAmountRatio) {
        this.confusingAmountRatio = confusingAmountRatio == null ? null : confusingAmountRatio.trim();
    }
}
