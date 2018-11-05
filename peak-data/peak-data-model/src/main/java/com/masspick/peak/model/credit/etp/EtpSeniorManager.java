package com.masspick.peak.model.credit.etp;

/**
 * etp_senior_manager
 * 企业高管:主要人员信息
 */
public class EtpSeniorManager {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 名字
     */
    private String name;

    /**
     * 职位
     */
    private String position;

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
     * 名字
     *
     * @return name 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 名字
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 职位
     *
     * @return position 职位
     */
    public String getPosition() {
        return position;
    }

    /**
     * 职位
     *
     * @param position 职位
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
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
}
