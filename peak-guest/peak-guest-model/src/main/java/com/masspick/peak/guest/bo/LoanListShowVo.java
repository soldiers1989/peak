package com.masspick.peak.guest.bo;

import java.util.Date;

/**
 *  贷款展示对象
 */
public class LoanListShowVo {

    /**
     *  id
     */
    private String id;

    /**
     *  订单号
     */
    private String no;

    /**
     *  申请企业
       */
    private String etpName;

    /**
     *  申请金额
     */
    private Integer amount;

    /**
     * 申请期限
     */
    private Integer term;

    /**
     *  提交时间
     */
    private Date createDate;

    /**
     *  产品名称
     */
    private String productName;

    /**
     *  状态
     */
    private String status;

    /**
     * Gets no
     *
     * @return value of no
     */
    public String getNo() {
        return no;
    }

    /**
     * @param no no
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * Gets etpName
     *
     * @return value of etpName
     */
    public String getEtpName() {
        return etpName;
    }

    /**
     * @param etpName etpName
     */
    public void setEtpName(String etpName) {
        this.etpName = etpName;
    }

    /**
     * Gets amount
     *
     * @return value of amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @param amount amount
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * Gets term
     *
     * @return value of term
     */
    public Integer getTerm() {
        return term;
    }

    /**
     * @param term term
     */
    public void setTerm(Integer term) {
        this.term = term;
    }

    /**
     * Gets createDate
     *
     * @return value of createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Gets productName
     *
     * @return value of productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

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
     * Gets status
     *
     * @return value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
