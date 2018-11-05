package com.masspick.peak.resource.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * Created by admin on 2018/8/1 0001.
 */
public class SysIndustry {

    /**
     * code
     */
    private String code;

    /**
     * name
     */
    private String name;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 父code
     */
    private String parentCode;

    /**
     * 父name
     */
    private String parentName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 类别
     */
    private String category;

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
     * Gets code
     *
     * @return value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
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
     * Gets status
     *
     * @return value of status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Gets parentCode
     *
     * @return value of parentCode
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * @param parentCode parentCode
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    /**
     * Gets parentName
     *
     * @return value of parentName
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * @param parentName parentName
     */
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    /**
     * Gets sort
     *
     * @return value of sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * Gets level
     *
     * @return value of level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param level level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * Gets category
     *
     * @return value of category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category category
     */
    public void setCategory(String category) {
        this.category = category;
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
