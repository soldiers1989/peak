package com.masspick.peak.resource.vo;

/**
 * 机构分页查询对象
 */
public class InsDataGridFindVo {

    /**
     * 机构名称
     */
    private String name;

    /**
     * 机构编码
     */
    private String code;

    /**
     * 机构类型取值
     */
    private String typeValue;

    /**
     * 页码
     */
    private Integer pageSize;

    /**
     * 条数
     */
    private Integer pageNum;

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
     * @return String
     */
    public String getTypeValue() {
        return typeValue;
    }

    /**
     * @param typeValue typeValue
     */
    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
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

    @Override
    public String toString() {
        return "InsDataGridFindVo{"
                + "name='" + name + '\''
                + ", code='" + code + '\''
                + ", typeValue='" + typeValue + '\''
                + ", pageSize=" + pageSize
                + ", pageNum=" + pageNum
                + '}';
    }
}
