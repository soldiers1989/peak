package com.masspick.peak.resource.vo;


import javax.validation.constraints.NotNull;

/**
 *  机构人员分页查询对象
 */
public class StaffDataGridFindVo {

    /**
     *  机构人员名称
     */
    private String name;

    /**
     *  机构人员编号
     */
    private String mobile;

    /**
     *  状态
     */
    private Integer status;

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
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return Integer
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
     * @return Integer
     */
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     *
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
        return "StaffDataGridFindVo{"
                + "name='" + name + '\''
                + ", moible='" + mobile + '\''
                + ", status=" + status
                + ", pageNum=" + pageNum
                + ", pageSize=" + pageSize
                + '}';
    }
}
