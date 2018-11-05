package com.masspick.peak.resource.model;

import java.util.Date;

/**
 * SysMenu
 */
public class SysMenu {

    /**
     * 主键：UUID
     */
    private String id;

    /**
     * 产品key
     */
    private String appKey;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父级菜单ID
     */
    private String pid;

    /**
     * 连接地址
     */
    private String url;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 深度
     */
    private Integer deep;

    /**
     * 编码
     */
    private String code;

    /**
     * 资源名称
     */
    private String resource;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

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
     * Gets appKey
     *
     * @return value of appKey
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * @param appKey appKey
     */
    public void setAppKey(String appKey) {
        this.appKey = appKey;
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
     * Gets pid
     *
     * @return value of pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid pid
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * Gets url
     *
     * @return value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
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
     * Gets resource
     *
     * @return value of resource
     */
    public String getResource() {
        return resource;
    }

    /**
     * @param resource resource
     */
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * Gets createTime
     *
     * @return value of createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * Gets updateTime
     *
     * @return value of updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
