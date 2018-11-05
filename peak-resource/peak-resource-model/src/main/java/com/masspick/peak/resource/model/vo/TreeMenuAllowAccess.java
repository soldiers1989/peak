package com.masspick.peak.resource.model.vo;

import com.masspick.peak.resource.model.SysMenu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单树+是否有权限表示
 *
 * @author Gaojun.Zhou
 * 2016年12月26日 上午10:34:02
 */
public class TreeMenuAllowAccess implements Serializable {

    /**
     * @Fields serialVersionUID : TODO()
     */

    private static final long serialVersionUID = 1L;

    /**
     * 菜单
     */
    private SysMenu sysMenu;
    /**
     * 是否允许访问
     */
    private boolean allowAccess = false;
    /**
     * 子菜单
     */
    private List<TreeMenuAllowAccess> children = new ArrayList<TreeMenuAllowAccess>();

    /**
     * @return SysMenu
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
     * @return boolean
     */
    public boolean isAllowAccess() {
        return allowAccess;
    }

    /**
     * @param allowAccess
     */
    public void setAllowAccess(boolean allowAccess) {
        this.allowAccess = allowAccess;
    }

    /**
     * @return List
     */
    public List<TreeMenuAllowAccess> getChildren() {
        return children;
    }

    /**
     * @param children
     */
    public void setChildren(List<TreeMenuAllowAccess> children) {
        this.children = children;
    }
}
