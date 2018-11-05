package com.masspick.peak.guest.bo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * UserWeiXinFindBo
 */
public class UserWeiXinFindBo {

    /**
     *  微信昵称
     */
    private String nickName;

    /**
     *  手机号
     */
    private String mobile;

    /**
     *  openId
     */
    private String openId;

    /**
     *  性别
     */
    private String sex;

    /**
     *  注册来源
     */
    private String registSource;

    /**
     *  推广机构
     */
    private String insName;

    /**
     * 注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date regDate;

    /**
     * 注册开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date regStartDate;

    /**
     *  注册结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date regEndDate;

    /**
     * 页码
     */
    @NotNull(message = "页码不能为空")
   private Integer pageNum;

    /**
     *  每页条数
     */
    @NotNull(message = "每页条数不能为空")
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
     * Gets openId
     *
     * @return value of openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId openId
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * Gets sex
     *
     * @return value of sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Gets regDate
     *
     * @return value of regDate
     */
    public Date getRegDate() {
        return regDate;
    }

    /**
     * @param regDate regDate
     */
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    /**
     * Gets regStartDate
     *
     * @return value of regStartDate
     */
    public Date getRegStartDate() {
        return regStartDate;
    }

    /**
     * @param regStartDate regStartDate
     */
    public void setRegStartDate(Date regStartDate) {
        this.regStartDate = regStartDate;
    }

    /**
     * Gets regEndDate
     *
     * @return value of regEndDate
     */
    public Date getRegEndDate() {
        return regEndDate;
    }

    /**
     * @param regEndDate regEndDate
     */
    public void setRegEndDate(Date regEndDate) {
        this.regEndDate = regEndDate;
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

    /**
     * Gets registSource
     *
     * @return value of registSource
     */
    public String getRegistSource() {
        return registSource;
    }

    /**
     * @param registSource registSource
     */
    public void setRegistSource(String registSource) {
        this.registSource = registSource;
    }

    /**
     * Gets insName
     *
     * @return value of insName
     */
    public String getInsName() {
        return insName;
    }

    /**
     * @param insName insName
     */
    public void setInsName(String insName) {
        this.insName = insName;
    }
}
