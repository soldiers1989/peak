package com.masspick.peak.resource.controller.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by admin on 2018/8/9 0009.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuVO {

    /**
     * name
     */
    private String name;

    /**
     * resourceName
     */
    private String state;

    /**
     * 类型
     */
    private String type;

    /**
     * 菜单样式字体
     */
    private String icon;

    /**
     * 菜单url
     */
    private String url;


    /**
     * 子集
     */
    private List<MenuVO> children;

    /**
     * Gets children
     *
     * @return value of children
     */
    public List<MenuVO> getChildren() {
        return children;
    }

    /**
     * @param children children
     */
    public void setChildren(List<MenuVO> children) {
        this.children = children;
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
     * Gets state
     *
     * @return value of state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state state
     */
    public void setState(String state) {
        this.state = state;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MenuVO menuVO = (MenuVO) o;

        return state.equals(menuVO.state);
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }
}
