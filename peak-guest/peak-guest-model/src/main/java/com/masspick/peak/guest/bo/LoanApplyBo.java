package com.masspick.peak.guest.bo;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * LoanApplyBo
 */
public class LoanApplyBo {

    /**
     *  注册手机号
     */
    private String regMobile;

    /**
     *  订单号
     */
    private String no;


    /**
     *  公司名称
     */
    private String etpName;

    /**
     *  提交日期起
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createStartDate;

    /**
     *  提交日期止
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createEndDate;

    /**
     *  最小贷款期限
     */
    private Integer minTerm;


    /**
     *  最大贷款期限
     */
    private Integer maxTerm;

    /**
     *  订单状态
     */
    private String status;

    /**
     *  页数
     */
    @NotNull(message = "页数不能为空")
    private Integer pageNum;

    /**
     *  页码
     */
    @NotNull(message = "每页条目数不能为空")
    private Integer pageSize;

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
     * Gets minTerm
     *
     * @return value of minTerm
     */
    public Integer getMinTerm() {
        return minTerm;
    }

    /**
     * @param minTerm minTerm
     */
    public void setMinTerm(Integer minTerm) {
        this.minTerm = minTerm;
    }

    /**
     * Gets maxTerm
     *
     * @return value of maxTerm
     */
    public Integer getMaxTerm() {
        return maxTerm;
    }

    /**
     * @param maxTerm maxTerm
     */
    public void setMaxTerm(Integer maxTerm) {
        this.maxTerm = maxTerm;
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
     * Gets createStartDate
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
