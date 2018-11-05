package com.masspick.peak.guest.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.masspick.peak.guest.model.base.BaseEntity;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * UserWeiXin
 */
public class UserWeiXin extends BaseEntity {

    /**
     * 微信昵称
     */
    private String nickName;

    /**
     * 微信openid
     */
    @NotEmpty(message = "openId不能为空")
    private String openId;

    /**
     * 性别 1 男 2女
     */
    private String sex;

    /**
     * 国家
     */
    private String country;

    /**
     * 省
     */
    private String province;

    /**
     * 头像
     */
    private String headPort;

    /**
     * 城市
     */
    private String city;

    /**
     * 注册日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date regDate;

    /**
     * 移动电话
     */
    @NotEmpty(message = "手机号不能为空")
    private String mobile;

    /**
     *  推荐人员编号
     */
    private String insStaffNum;

    /**
     *  注册来源
     */
    private String registSource;

    /**
     *  推广人员名称
     */
    private String insStaffName;

    /**
     *  推广机构
     */
    private String insName;

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
     * Gets country
     *
     * @return value of country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country country
     */
    public void setCountry(String country) {
        this.country = country;
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
     * @param province province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Gets headPort
     *
     * @return value of headPort
     */
    public String getHeadPort() {
        return headPort;
    }

    /**
     * @param headPort headPort
     */
    public void setHeadPort(String headPort) {
        this.headPort = headPort;
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
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
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
     * Gets insStaffNum
     *
     * @return value of insStaffNum
     */
    public String getInsStaffNum() {
        return insStaffNum;
    }

    /**
     * @param insStaffNum insStaffNum
     */
    public void setInsStaffNum(String insStaffNum) {
        this.insStaffNum = insStaffNum;
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
     * Gets insStaffName
     *
     * @return value of insStaffName
     */
    public String getInsStaffName() {
        return insStaffName;
    }

    /**
     * @param insStaffName insStaffName
     */
    public void setInsStaffName(String insStaffName) {
        this.insStaffName = insStaffName;
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
