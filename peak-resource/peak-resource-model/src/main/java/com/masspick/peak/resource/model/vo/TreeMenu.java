package com.masspick.peak.resource.model.vo;


import com.masspick.peak.resource.model.SysMenu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单树
 *
 * @author Gaojun.Zhou
 * 2016年12月26日 上午10:34:31
 */
public class TreeMenu implements Serializable {

    /**
     * @Fields serialVersionUID : TODO()
     */

    private static final long serialVersionUID = 1L;
    /**
     * 菜单
     */
    private SysMenu sysMenu;
    /**
     * 子菜单
     */
    private List<TreeMenu> children = new ArrayList<TreeMenu>();

    /**
     * @return  SysMenu
     */
    public SysMenu getSysMenu() {
        return sysMenu;
    }

    /**
     * @param sysMenu
     */
    public void setSysMenu(SysMenu sysMenu) {
        this.sysMenu = sysMenu;
    }

    /**
     * @return List
     */
    public List<TreeMenu> getChildren() {
        return children;
    }

    /**
     * @param children
     */
    public void setChildren(List<TreeMenu> children) {
        this.children = children;
    }


}
