package com.masspick.peak.model.credit.etp;

/**
 * etp_guarantee_record
 * 对外担保记录
 */
public class EtpGuaranteeRecord {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 业务类型
     */
    private String bussType;

    /**
     * 被担保人
     */
    private String guarantor;

    /**
     * 证件类型
     */
    private String cardType;

    /**
     * 证件号码
     */
    private String cardNo;

    /**
     * 担保币种
     */
    private String curType;

    /**
     * 担保金额
     */
    private Double guaranteeFee;

    /**
     * 担保形式
     */
    private String guaranteeMethod;

    /**
     * id
     * @return id id
     */
    public String getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 征信报告id
     * @return report_id 征信报告id
     */
    public String getReportId() {
        return reportId;
    }

    /**
     * 征信报告id
     * @param reportId 征信报告id
     */
    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    /**
     * 业务类型
     * @return buss_type 业务类型
     */
    public String getBussType() {
        return bussType;
    }

    /**
     * 业务类型
     * @param bussType 业务类型
     */
    public void setBussType(String bussType) {
        this.bussType = bussType == null ? null : bussType.trim();
    }

    /**
     * 被担保人
     * @return guarantor 被担保人
     */
    public String getGuarantor() {
        return guarantor;
    }

    /**
     * 被担保人
     * @param guarantor 被担保人
     */
    public void setGuarantor(String guarantor) {
        this.guarantor = guarantor == null ? null : guarantor.trim();
    }

    /**
     * 证件类型
     * @return card_type 证件类型
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * 证件类型
     * @param cardType 证件类型
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * 证件号码
     * @return card_no 证件号码
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 证件号码
     * @param cardNo 证件号码
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 担保币种
     * @return cur_type 担保币种
     */
    public String getCurType() {
        return curType;
    }

    /**
     * 担保币种
     * @param curType 担保币种
     */
    public void setCurType(String curType) {
        this.curType = curType == null ? null : curType.trim();
    }

    /**
     * 担保金额
     * @return guarantee_fee 担保金额
     */
    public Double getGuaranteeFee() {
        return guaranteeFee;
    }

    /**
     * 担保金额
     * @param guaranteeFee 担保金额
     */
    public void setGuaranteeFee(Double guaranteeFee) {
        this.guaranteeFee = guaranteeFee;
    }

    /**
     * 担保形式
     * @return guarantee_method 担保形式
     */
    public String getGuaranteeMethod() {
        return guaranteeMethod;
    }

    /**
     * 担保形式
     * @param guaranteeMethod 担保形式
     */
    public void setGuaranteeMethod(String guaranteeMethod) {
        this.guaranteeMethod = guaranteeMethod == null ? null : guaranteeMethod.trim();
    }
}
