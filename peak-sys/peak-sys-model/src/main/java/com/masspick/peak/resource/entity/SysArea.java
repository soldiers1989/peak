package com.masspick.peak.resource.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * Created by admin on 2018/7/30 0030.
 * 区域表
 */
public class SysArea {

    /**
     * id
     */
    private String id;

    /**
     * 父id
     */
    private String parentId;

    /**
     * name
     */
    private String name;

    /**
     * 组合名称
     */
    @JsonIgnore
    private String mangerName;

    /**
     * 简短名称
     */
    private String shortName;

    /**
     * 组合简短名称
     */
    @JsonIgnore
    private String mangerShortName;

    /**
     * 等级
     */
    @JsonIgnore
    private Integer levelType;

    /**
     * 区域代码
     */
    private String cityCode;

    /**
     * 邮政代码
     */
    private String zipCode;

    /**
     * 拼音
     */
    private String pinYin;

    /**
     * 简拼
     */
    private String jianPin;

    /**
     * 首字母
     */
    private String firstChar;

    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 描述
     */
    private String remark;

    /**
     * 更新时间
     */
    private Date updateDate;


    /**
     * 创建时间
     */
    @JsonIgnore
    private Date createDate;

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
     * Gets parentId
     *
     * @return value of parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * Gets name
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets mangerName
     *
     * @return value of mangerName
     */
    public String getMangerName() {
        return mangerName;
    }

    /**
     * @param mangerName mangerName
     */
    public void setMangerName(String mangerName) {
        this.mangerName = mangerName;
    }

    /**
     * Gets shortName
     *
     * @return value of shortName
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * @param shortName shortName
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Gets mangerShortName
     *
     * @return value of mangerShortName
     */
    public String getMangerShortName() {
        return mangerShortName;
    }

    /**
     * @param mangerShortName mangerShortName
     */
    public void setMangerShortName(String mangerShortName) {
        this.mangerShortName = mangerShortName;
    }

    /**
     * Gets levelType
     *
     * @return value of levelType
     */
    public Integer getLevelType() {
        return levelType;
    }

    /**
     * @param levelType levelType
     */
    public void setLevelType(Integer levelType) {
        this.levelType = levelType;
    }

    /**
     * Gets cityCode
     *
     * @return value of cityCode
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode cityCode
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * Gets zipCode
     *
     * @return value of zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets pinYin
     *
     * @return value of pinYin
     */
    public String getPinYin() {
        return pinYin;
    }

    /**
     * @param pinYin pinYin
     */
    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }

    /**
     * Gets jianPin
     *
     * @return value of jianPin
     */
    public String getJianPin() {
        return jianPin;
    }

    /**
     * @param jianPin jianPin
     */
    public void setJianPin(String jianPin) {
        this.jianPin = jianPin;
    }

    /**
     * Gets firstChar
     *
     * @return value of firstChar
     */
    public String getFirstChar() {
        return firstChar;
    }

    /**
     * @param firstChar firstChar
     */
    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }

    /**
     * Gets lng
     *
     * @return value of lng
     */
    public String getLng() {
        return lng;
    }

    /**
     * @param lng lng
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * Gets lat
     *
     * @return value of lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * @param lat lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * Gets remark
     *
     * @return value of remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Gets updateDate
     *
     * @return value of updateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
}
