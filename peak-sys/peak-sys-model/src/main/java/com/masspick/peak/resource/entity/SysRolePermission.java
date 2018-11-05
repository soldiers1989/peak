package com.masspick.peak.resource.entity;

/**
 * 角色权限关联对象
 */
public class SysRolePermission {

    /**
     * 主键id
     */
    private String id;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 权限id
     */
    private String permissionId;

    /**
     * appId
     */
    private String appId;


    /**
     * Gets appId
     *
     * @return value of appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
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
     * Gets permissionId
     *
     * @return value of permissionId
     */
    public String getPermissionId() {
        return permissionId;
    }

    /**
     * @param permissionId permissionId
     */
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "SysRolePermission{"
                + "id='" + id + '\''
                + ", roleId='" + roleId + '\''
                + ", permissionId='" + permissionId + '\''
                + '}';
    }
}
