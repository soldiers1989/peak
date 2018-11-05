package com.masspick.peak.resource.entity;

import java.util.Date;

/**
 *  区域信息
 */
public class SysRegion {

    /**
     *  主键id
     */
    private String id;

    /**
     *  区域名称
     */
    private String name;

    /**
     *  简称
     */
    private String shortName;

    /**
     *  区划代码
     */
    private String zoingCode;

    /**
     *  父级代码
     */
    private String parentZoingCode;

    /**
     *  行政区号
     */
    private String areaCode;

    /**
     *  邮政编码
     */
    private String postalCode;

    /**
     *  拼音全称
     */
    private String pinyinFullName;

    /**
     *  拼音简称
     */
    private String pinyinShortName;

    /**
     *  首字母
     */
    private String firstCharacter;

    /**
     *  创建日期
     */
    private Date createDate;

    /**
     *  更新日期
     */
    private Date updateDate;

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
     * Gets zoingCode
     *
     * @return value of zoingCode
     */
    public String getZoingCode() {
        return zoingCode;
    }

    /**
     * @param zoingCode zoingCode
     */
    public void setZoingCode(String zoingCode) {
        this.zoingCode = zoingCode;
    }

    /**
     * Gets parentZoingCode
     *
     * @return value of parentZoingCode
     */
    public String getParentZoingCode() {
        return parentZoingCode;
    }

    /**
     * @param parentZoingCode parentZoingCode
     */
    public void setParentZoingCode(String parentZoingCode) {
        this.parentZoingCode = parentZoingCode;
    }

    /**
     * Gets areaCode
     *
     * @return value of areaCode
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * @param areaCode areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * Gets postalCode
     *
     * @return value of postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Gets pinyinFullName
     *
     * @return value of pinyinFullName
     */
    public String getPinyinFullName() {
        return pinyinFullName;
    }

    /**
     * @param pinyinFullName pinyinFullName
     */
    public void setPinyinFullName(String pinyinFullName) {
        this.pinyinFullName = pinyinFullName;
    }

    /**
     * Gets pinyinShortName
     *
     * @return value of pinyinShortName
     */
    public String getPinyinShortName() {
        return pinyinShortName;
    }

    /**
     * @param pinyinShortName pinyinShortName
     */
    public void setPinyinShortName(String pinyinShortName) {
        this.pinyinShortName = pinyinShortName;
    }

    /**
     * Gets firstCharacter
     *
     * @return value of firstCharacter
     */
    public String getFirstCharacter() {
        return firstCharacter;
    }

    /**
     * @param firstCharacter firstCharacter
     */
    public void setFirstCharacter(String firstCharacter) {
        this.firstCharacter = firstCharacter;
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
}
