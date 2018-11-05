package com.masspick.peak.guest.bo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * NameCardInfoBo
 */
public class NameCardInfoBo {

    /**
     * 微信昵称
     */
    private String nickName;

    /**
     * 法人手机号
     */
    private String mobile;

    /**
     * 公司名称
     */
    private String etpName;

    /**
     * 法人姓名
     */
    private String legalName;

    /**
     * 评估起始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createStartDate;

    /**
     * 评估结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createEndDate;

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 每页条数
     */
    private Integer pageSize;


    /**
     * Gets nickName
     *
     * @return value of nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Gets mobile
     *
     * @return value of mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
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
     * Gets legalName
     *
     * @return value of legalName
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * @param legalName legalName
     */
    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    /**
     * Gets createStartDate
     *
     * @return value of createStartDate
     */
    public Date getCreateStartDate() {
        return createStartDate;
    }

    /**
     * @param createStartDate createStartDate
     */
    public void setCreateStartDate(Date createStartDate) {
        this.createStartDate = createStartDate;
    }

    /**
     * Gets createEndDate
     *
     * @return value of createEndDate
     */
    public Date getCreateEndDate() {
        return createEndDate;
    }

    /**
     * @param createEndDate createEndDate
     */
    public void setCreateEndDate(Date createEndDate) {
        this.createEndDate = createEndDate;
    }

    /**
     * Gets pageNum
     *
     * @return value of pageNum
     */
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * @param pageNum pageNum
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * Gets pageSize
     *
     * @return value of pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
