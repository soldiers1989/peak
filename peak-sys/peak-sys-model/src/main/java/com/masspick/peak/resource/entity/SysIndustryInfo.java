package com.masspick.peak.resource.entity;

import java.util.Date;

/**
 *  行业信息
 */
public class SysIndustryInfo {

    /**
     *  主键id
     */
    private String id;

    /**
     *  行业名称
     */
    private String name;

    /**
     *  行业代码
     */
    private String code;

    /**
     *  父级行业
     */
    private String parentId;

    /**
     *  深度
     */
    private String deep;

    /**
     *  描述
     */
    private String remark;

    /**
     *  创建时间
     */
    private Date createDate;

    /**
     *  更新时间
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
     * Gets deep
     *
     * @return value of deep
     */
    public String getDeep() {
        return deep;
    }

    /**
     * @param deep deep
     */
    public void setDeep(String deep) {
        this.deep = deep;
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
