package com.masspick.peak.resource.vo;

/**
 * Created by Administrator on 2018\8\1 0001.
 */
public class DepartmentShowVo {

    /**
     * num
     */
    private final Integer num = 31;

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
    private String fullName;

    /**
     * 应用状态
     */
    private Integer status;

    /**
     * 排序编码
     */
    private String code;

    /**
     * 等级
     */
    private String level;

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
     * Gets level
     *
     * @return value of level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "DepartmentShowVo{"
                + "id='" + id + '\''
                + ", parentId='" + parentId + '\''
                + ", fullName='" + fullName + '\''
                + ", status=" + status
                + ", code='" + code + '\''
                + ", level='" + level + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DepartmentShowVo that = (DepartmentShowVo) o;

        if (num != null ? !num.equals(that.num) : that.num != null) {
            return false;
        }
        if (!id.equals(that.id)) {
            return false;
        }
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) {
            return false;
        }
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) {
            return false;
        }
        if (status != null ? !status.equals(that.status) : that.status != null) {
            return false;
        }
        if (code != null ? !code.equals(that.code) : that.code != null) {
            return false;
        }
        return level != null ? level.equals(that.level) : that.level == null;
    }

    @Override
    public int hashCode() {
        int result = num != null ? num.hashCode() : 0;
        result = num * result + id.hashCode();
        result = num * result + (parentId != null ? parentId.hashCode() : 0);
        result = num * result + (fullName != null ? fullName.hashCode() : 0);
        result = num * result + (status != null ? status.hashCode() : 0);
        result = num * result + (code != null ? code.hashCode() : 0);
        result = num * result + (level != null ? level.hashCode() : 0);
        return result;
    }
}
