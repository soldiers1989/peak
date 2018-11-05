package com.masspick.peak.resource.entity;

import com.masspick.peak.common.util.SequenceUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 权限表
 */
public class SysPermission {

    /**
     * num
     */
    private final Integer num = 31;

    /**
     * 主键id
     */
    private String id;

    /**
     * 父级权限
     */
    //@NotNull(message = "父级权限不能为空")
    private String parentId;

    /**
     * 权限名称
     */
    @NotEmpty(message = "权限名称不能为空")
    private String name;

    /**
     * 权限类型
     */
    @NotNull(message = "权限类型不能为空")
    private Integer type;

    /**
     * 应用id
     */
    @NotEmpty(message = "应用id不能为空")
    private String appId;

    /**
     * 应用名称
     */
    @NotEmpty(message = "应用名称不能为空")
    private String appName;

    /**
     * 排序编码
     */
    private String code;

    /**
     * 权限名称
     */
    @NotNull(message = "排序不能为空")
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
    @NotEmpty(message = "资源名称不能为空")
    private String resourceName;

    /**
     * 状态
     */
    @NotNull(message = "状态不能为空")
    private Integer status;

    /**
     * 图标
     */
    private String icon;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date updateDate;

    /**
     * preInsert
     */
    public void preInsert() {
        this.id = SequenceUtils.getUUID();
        this.createDate = new Date();
        this.updateDate = new Date();
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
    public Integer getType() {
        return type;
    }

    /**
     * @param type type
     */
    public void setType(Integer type) {
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

    /**
     * Gets createDate
     *
     * @return value of createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Gets updateDate
     *
     * @return value of updateDate
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "SysPermission{"
                + "id='" + id + '\''
                + ", parentId='" + parentId + '\''
                + ", name='" + name + '\''
                + ", type=" + type
                + ", appId='" + appId + '\''
                + ", appName='" + appName + '\''
                + ", code='" + code + '\''
                + ", sort=" + sort
                + ", deep=" + deep
                + ", menuUrl='" + menuUrl + '\''
                + ", resourceName='" + resourceName + '\''
                + ", status=" + status
                + ", createDate=" + createDate
                + ", updateDate=" + updateDate
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

        SysPermission that = (SysPermission) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) {
            return false;
        }
        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        if (type != null ? !type.equals(that.type) : that.type != null) {
            return false;
        }
        if (appId != null ? !appId.equals(that.appId) : that.appId != null) {
            return false;
        }
        if (appName != null ? !appName.equals(that.appName) : that.appName != null) {
            return false;
        }
        if (code != null ? !code.equals(that.code) : that.code != null) {
            return false;
        }
        if (sort != null ? !sort.equals(that.sort) : that.sort != null) {
            return false;
        }
        if (deep != null ? !deep.equals(that.deep) : that.deep != null) {
            return false;
        }
        if (menuUrl != null ? !menuUrl.equals(that.menuUrl) : that.menuUrl != null) {
            return false;
        }
        if (resourceName != null ? !resourceName.equals(that.resourceName) : that.resourceName != null) {
            return false;
        }
        if (status != null ? !status.equals(that.status) : that.status != null) {
            return false;
        }
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) {
            return false;
        }
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) {
            return false;
        }

        return updateDate != null ? updateDate.equals(that.updateDate) : that.updateDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = num * result + (parentId != null ? parentId.hashCode() : 0);
        result = num * result + (name != null ? name.hashCode() : 0);
        result = num * result + (type != null ? type.hashCode() : 0);
        result = num * result + (appId != null ? appId.hashCode() : 0);
        result = num * result + (appName != null ? appName.hashCode() : 0);
        result = num * result + (code != null ? code.hashCode() : 0);
        result = num * result + (sort != null ? sort.hashCode() : 0);
        result = num * result + (deep != null ? deep.hashCode() : 0);
        result = num * result + (menuUrl != null ? menuUrl.hashCode() : 0);
        result = num * result + (resourceName != null ? resourceName.hashCode() : 0);
        result = num * result + (status != null ? status.hashCode() : 0);
        result = num * result + (icon != null ? icon.hashCode() : 0);
        result = num * result + (createDate != null ? createDate.hashCode() : 0);
        result = num * result + (updateDate != null ? updateDate.hashCode() : 0);
        return result;
    }
}
