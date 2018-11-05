package com.masspick.peak.resource.vo;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 *  角色分页查询对象
 */
@Valid
public class RoleFindListVo {

    /**
     * 名称
     */
    private String name;

    /**
     *  应用状态
     */
    private Integer status;

    /**
     *  页码
     */
    @NotNull(message = "页码不能为空")
    private Integer pageNum;

    /**
     * 条数
     */
    @NotNull(message = "条数不能为空")
    private Integer pageSize;


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

    @Override
    public String toString() {
        return "RoleFindListVo{"
                + "name='" + name + '\''
                + ", status=" + status
                + ", pageNum=" + pageNum
                + ", pageSize=" + pageSize
                + '}';
    }
}
