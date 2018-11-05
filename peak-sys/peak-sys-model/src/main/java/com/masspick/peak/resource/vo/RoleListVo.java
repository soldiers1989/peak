package com.masspick.peak.resource.vo;


import java.util.List;

/**
 *  员工授权角色对象
 */
public class RoleListVo {

    /**
     *  角色id
     */
    private List<String> roleId;

    /**
     * Gets roleId
     *
     * @return value of roleId
     */
    public List<String> getRoleId() {
        return roleId;
    }

    /**
     * @param roleId roleId
     */
    public void setRoleId(List<String> roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "RoleListVo{"
                + "roleId=" + roleId
                + '}';
    }
}
