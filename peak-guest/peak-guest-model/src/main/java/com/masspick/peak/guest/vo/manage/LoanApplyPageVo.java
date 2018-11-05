package com.masspick.peak.guest.vo.manage;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 *  订单分页查询展示对象
 */
public class LoanApplyPageVo {

    /**
     * 主键id
     */
    private String id;

    /**
     * 订单号
     */
    private String no;

    /**
     * 公司名称
     */
    private String etpName;

    /**
     * 申请金额
     */
    private Integer amount;

    /**
     * 申请期限
     */
    private Integer term;

    /**
     * 订单提交时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;

    /**
     *  订单状态
     */
    private String status;

    /**
     *  手机账号
     */
    private String regMobile;

    /**
     *  产品名称
     */
    private String productName;

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

    /**
     * Gets regMobile
     *
     * @return value of regMobile
     */
    public String getRegMobile() {
        return regMobile;
    }

    /**
     * @param regMobile regMobile
     */
    public void setRegMobile(String regMobile) {
        this.regMobile = regMobile;
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
}
