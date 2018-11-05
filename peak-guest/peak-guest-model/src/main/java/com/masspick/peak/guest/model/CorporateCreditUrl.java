package com.masspick.peak.guest.model;


/**
 * CorporateCreditUrl
 */
public class CorporateCreditUrl {

    /**
     * 主键id
     */
    private String id;

    /**
     * 申请订单id
     */
    private String loanId;


    /**
     * 企业征信上传地址
     */
    private String creditUrl;

    /**
     * Gets id
     *
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets loanId
     *
     * @return value of loanId
     */
    public String getLoanId() {
        return loanId;
    }

    /**
     * @param loanId loanId
     */
    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    /**
     * Gets creditUrl
     *
     * @return value of creditUrl
     */
    public String getCreditUrl() {
        return creditUrl;
    }

    /**
     * @param creditUrl creditUrl
     */
    public void setCreditUrl(String creditUrl) {
        this.creditUrl = creditUrl;
    }
}
