package com.masspick.peak.resource.vo;


/**
 *  角色列表关联用户对象
 */
public class RolesFromUserVo {

    /**
     *  角色id
     */
    private String roleId;

    /**
     *  角色名称
     */
    private String name;

    /**
     *  角色描述
     */
    private String remark;

    /**
     *  用户拥有角色标识 0: 否 1:是
     */
    private String disable;

    /**
     *  禁用启用
     */
    private Integer status;

    /**
     * Gets roleId
     *
     * @return value of roleId
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
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
     * Gets disable
     *
     * @return value of disable
     */
    public String getDisable() {
        return disable;
    }

    /**
     * @param disable disable
     */
    public void setDisable(String disable) {
        this.disable = disable;
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

    @Override
    public String toString() {
        return "RolesFromUserVo{"
                + "roleId='" + roleId + '\''
                + ", name='" + name + '\''
                + ", remark='" + remark + '\''
                + ", disable='" + disable + '\''
                + ", status='" + status + '\''
                + '}';
    }
}
