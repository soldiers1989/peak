package com.masspick.peak.dd.model;


import com.masspick.peak.dd.model.vo.BaseEntity;

/**
 * Created by admin on 2018/5/18 0018.
 */
public class Template extends BaseEntity {

    /**
     * 激活
     */
    public static final Integer ACTIVE = 1;

    /**
     * 删除
     */
    public static final Integer DELETE = 0;

    /**
     * id
     */
    private String id;

    /**
     * name
     */
    private String name;

    /**
     * roleId
     */
    private String roleId;

    /**
     * roleName
     */
    private String roleName;

    /**
     * state
     */
    private Integer state;

    /**
     * Template
     */
    public Template() {
    }

    /**
     * @param id
     * @param name
     * @param roleId
     * @param roleName
     * @param state
     */
    public Template(String id, String name, String roleId, String roleName, Integer state) {
        this.id = id;
        this.name = name;
        this.roleId = roleId;
        this.roleName = roleName;
        this.state = state;
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
     * @param id
     */
    public void setId(String id) {
        this.id = id;
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
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
     * @param roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets roleName
     *
     * @return value of roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Gets state
     *
     * @return value of state
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }
}
