package com.masspick.peak.resource.model;

/**
 * SysRoleMenu
 */
public class SysRoleMenu {

    /**
     * 主键：uuid
     */
    private String id;

    /**
     * 角色主键
     */
    private String roleId;

    /**
     * 菜单主键
     */
    private String menuId;

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
     * Gets menuId
     *
     * @return value of menuId
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * @param menuId menuId
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
