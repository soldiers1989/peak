package com.masspick.peak.resource.controller.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by admin on 2018/7/30 0030.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysDictionaryVO {

    /**
     * 主键：UUID
     */
    private String id;

    /**
     * code
     */
    @NotNull(message = "编码不能为空")
    private String code;

    /**
     * 名称
     */
    @NotNull(message = "名称不能为空")
    @Size(max = 50, message = "名称不能超过50个字符")
    private String name;

    /**
     * 父code
     */
    private String parentId;

    /**
     * 状态
     */
    @NotNull(message = "状态不能为空")
    private Integer status;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 描述
     */
    @Size(max = 200, message = "描述字段不能超过200个字符")
    private String remark;

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 条数
     */
    private Integer pageSize;

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
     * Gets pageSize pageSize
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
}
