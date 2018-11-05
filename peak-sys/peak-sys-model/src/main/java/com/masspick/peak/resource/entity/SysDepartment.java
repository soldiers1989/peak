package com.masspick.peak.resource.entity;

import com.masspick.peak.common.util.SequenceUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 部门
 */
public class SysDepartment {

    /**
     * 主键id
     */
    private String id;

    /**
     * 父级部门
     */
    private String parentId;

    /**
     * 部门全称
     */
    @NotEmpty(message = "部门全称不能为空")
    private String fullName;

    /**
     * 部门简称
     */
    private String shortName;

    /**
     * 排序编码
     */
    private String code;

    /**
     * 排序
     */
    @NotNull(message = "排序不能为空")
    private Integer sort;

    /**
     * 状态（0-禁用 1-启用）
     */
    @NotNull(message = "应用状态不能为空")
    private Integer status;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 描述
     */
    private String remark;

    /**
     * preInsert
     */
    public void preInsert() {
        this.id = SequenceUtils.getUUID();
        this.createDate = new Date();
        this.updateDate = new Date();
    }

    @Override
    public String toString() {
        return "SysDepartment{"
                + "id='" + id + '\''
                + ", parentId='" + parentId + '\''
                + ", fullName='" + fullName + '\''
                + ", shortName='" + shortName + '\''
                + ", code='" + code + '\''
                + ", sort=" + sort
                + ", status=" + status
                + ", level=" + level
                + ", createDate=" + createDate
                + ", updateDate=" + updateDate
                + ", remark='" + remark + '\''
                + '}';
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
     * Gets fullName
     *
     * @return value of fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
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
}
