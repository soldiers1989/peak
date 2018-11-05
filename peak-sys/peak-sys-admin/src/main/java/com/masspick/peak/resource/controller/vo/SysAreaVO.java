package com.masspick.peak.resource.controller.vo;

import javax.validation.constraints.NotNull;

/**
 * Created by admin on 2018/7/31 0031.
 */
public class SysAreaVO {

    /**
     * code
     */
    private String code;

    /**
     * name
     */
    private String name;

    /**
     * 区域代码
     */
    private String cityCode;

    /**
     * 邮政代码
     */
    private String zipCode;

    /**
     * 页码
     */
    @NotNull(message = "页码不能为空")
    private Integer pageNum;

    /**
     * 条数
     */
    @NotNull(message = "页数不能为空")
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
}
