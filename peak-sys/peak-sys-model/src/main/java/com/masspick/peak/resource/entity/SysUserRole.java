package com.masspick.peak.resource.entity;

/**
 *  员工角色关联对象
 */
public class SysUserRole {

    /**
     *  主键id
     */
    private String id;

    /**
     *  员工id
     */
    private String userId;

    /**
     *  角色id
     */
    private String roleId;


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
     * Gets userId
     *
     * @return value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    @Override
    public String toString() {
        return "SysUserRole{"
                + "id='" + id + '\''
                + ", userId='" + userId + '\''
                + ", roleId='" + roleId + '\''
                + '}';
    }
}
