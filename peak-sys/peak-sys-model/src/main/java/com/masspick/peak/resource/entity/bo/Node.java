package com.masspick.peak.resource.entity.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by admin on 2018/7/31 0031.
 */
public class Node {

    /**
     * id
     */
    private String id;

    /**
     * 父id
     */
    @JsonIgnore
    private String parentId;

    /**
     * 父id
     */
    private String pId;

    /**
     * 名称
     */
    private String name;

    /**
     * 选择关系
     */
    @JsonIgnore
    private Integer disable;

    /**
     * 选择关系
     */
    private Boolean checked;


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
