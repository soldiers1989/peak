package com.masspick.peak.service.dto;

import java.util.Date;

/**
 * Created by admin on 2018/9/5 0005.
 */
public class SysDictionaryDTO {
    /**
     * 主键id
     */
    private String id;

    /**
     * 业务主键code
     */
    private String code;

    /**
     * 父code
     */
    private String parentCode;
    /**
     * 名称
     */
    private String name;

    /**
     *  父级id
     */
    private String parentId;

    /**
     * 状态 0：禁用 1：启用
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 描述
     */
    private String remark;

    /**
     * 更新日期
     */
    private Date updateDate;

    /**
     *  创建日期
     */
    private Date createDate;

    /**
     * Gets parentCode
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
