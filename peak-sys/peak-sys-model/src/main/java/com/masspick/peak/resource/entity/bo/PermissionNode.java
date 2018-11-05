package com.masspick.peak.resource.entity.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by admin on 2018/8/9 0009.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionNode {

    /**
     * permissionId
     */
    private String id;

    /**
     * 父Id
     */
    private String pId;
    /**
     * 父Id
     */
    @JsonIgnore
    private String parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    @JsonIgnore
    private Integer type;

    /**
     * 是否被选择
     */
    @JsonIgnore
    private Integer disable;

    /**
     * 状态
     */
    @JsonIgnore
    private Integer status;

    /**
     * 是否被选择
     */
    private Boolean checked;

    /**
     * 是否禁用与启用
     */
    private Boolean chkDisabled;

    /**
     * 孩子节点
     */
    @JsonIgnore
    private List<PermissionNode> children;


    /**
     * Gets chkDisabled
     *
     * @return value of chkDisabled
     */
    public Boolean getChkDisabled() {
        return chkDisabled;
    }

    /**
     * @param chkDisabled chkDisabled
     */
    public void setChkDisabled(Boolean chkDisabled) {
        this.chkDisabled = chkDisabled;
    }

    /**
     * Gets children
     *
     * @return value of children
     */
    public List<PermissionNode> getChildren() {
        return children;
    }

    /**
     * @param children children
     */
    public void setChildren(List<PermissionNode> children) {
        this.children = children;
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
     * Gets disable
     *
     * @return value of disable
     */
    public Integer getDisable() {
        return disable;
    }

    /**
     * @param disable disable
     */
    public void setDisable(Integer disable) {
        this.disable = disable;
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
     * Gets pId
     *
     * @return value of pId
     */
    public String getpId() {
        return pId;
    }

    /**
     * @param pId pId
     */
    public void setpId(String pId) {
        this.pId = pId;
    }

    /**
     * Gets checked
     *
     * @return value of checked
     */
    public Boolean getChecked() {
        return checked;
    }

    /**
     * @param checked checked
     */
    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
