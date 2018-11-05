package com.masspick.peak.resource.vo;

import javax.validation.constraints.NotNull;

/**
 *  产品分页查询对象
 */
public class ProductDataGridFindVo {

    /**
     *  产品名称
     */
    private String name;

    /**
     *  产品编号
     */
    private String number;

    /**
     *  页码
     */
    @NotNull(message = "页码不能为空")
    private Integer pageNum;

    /**
     *  条数
     */
    @NotNull(message = "条数不能为空")
    private Integer pageSize;

    /**
     * @return String
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
     * @return String
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return Integer
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
     * @return Integer
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

    @Override
    public String toString() {
        return "ProductDataGridFindVo{"
                + "name='" + name + '\''
                + ", number='" + number + '\''
                + ", pageNum=" + pageNum
                + ", pageSize=" + pageSize
                + '}';
    }
}
