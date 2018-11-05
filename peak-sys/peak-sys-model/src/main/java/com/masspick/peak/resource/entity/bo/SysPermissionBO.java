package com.masspick.peak.resource.entity.bo;

/**
 * Created by admin on 2018/8/9 0009.
 */
public class SysPermissionBO {
    /**
     * 主键id
     */
    private String id;

    /**
     * 父级权限
     */
    private String parentId;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限类型
     */
    private String type;

    /**
     * 应用id
     */
    private String appId;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 排序编码
     */
    private String code;

    /**
     * 权限名称
     */
    private Integer sort;

    /**
     * 深度
     */
    private Integer deep;

    /**
     * 菜单uri
     */
    private String menuUrl;

    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 图标
     */
    private String icon;


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
     * Gets type
     *
     * @return value of type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }

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
     * Gets appName
     *
     * @return value of appName
     */
    public String getAppName() {
        return appName;
    }

    /**
     * @param appName appName
     */
    public void setAppName(String appName) {
        this.appName = appName;
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
     * Gets sort
     *
     * @return value of sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * Gets deep
     *
     * @return value of deep
     */
    public Integer getDeep() {
        return deep;
    }

    /**
     * @param deep deep
     */
    public void setDeep(Integer deep) {
        this.deep = deep;
    }

    /**
     * Gets menuUrl
     *
     * @return value of menuUrl
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * @param menuUrl menuUrl
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    /**
     * Gets resourceName
     *
     * @return value of resourceName
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * @param resourceName resourceName
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
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
     * Gets icon
     *
     * @return value of icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

}
