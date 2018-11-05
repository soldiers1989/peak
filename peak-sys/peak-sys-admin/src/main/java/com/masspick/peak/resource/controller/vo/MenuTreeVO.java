package com.masspick.peak.resource.controller.vo;

import com.masspick.peak.resource.entity.SysApp;
import com.masspick.peak.resource.entity.bo.SysPermissionBO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/8/9 0009.
 */
public class MenuTreeVO {

    /**
     * permissions
     */
    private List<SysPermissionBO> permissions;

    /**
     * appIds
     */
    private List<SysApp> sysApps;

    /**
     * resource
     */
    private List<MenuVO> resource = new ArrayList<>();

    /**
     * @param id id
     * @return List<MenuVO>
     */
    public List<MenuVO> menuTree(String id) {
        List<MenuVO> menuVOS = new ArrayList<>();
        for (SysPermissionBO sysPermission : permissions) {
            if (sysPermission.getParentId().equals(id) && sysPermission.getStatus() == 1) {
                MenuVO menuVO = new MenuVO();
                menuVO.setName(sysPermission.getName());
                menuVO.setState(sysPermission.getResourceName());
                menuVO.setIcon(sysPermission.getIcon());
                menuVO.setUrl(sysPermission.getMenuUrl());
                menuVO.setType(sysPermission.getType());
                if (!sysPermission.getType().equals("button")) {
                    menuVO.setChildren(CollectionUtils.isEmpty(menuTree(sysPermission.getId())) ? null : menuTree(
                            sysPermission.getId()));
                    menuVOS.add(menuVO);
                } else {
                    if (!resource.contains(menuVO)) {
                        resource.add(menuVO);
                    }
                }
            }
        }
        return menuVOS;
    }

    /**
     * 多个
     *
     * @return List<MenuVO>
     */
    public List<MenuVO> menuTree() {
        List<MenuVO> menuVOS = new ArrayList<>();
        for (SysApp sysApp : sysApps) {
            MenuVO menuVO = new MenuVO();
            menuVO.setName(sysApp.getAppName());
            menuVO.setState(sysApp.getAppName());
            menuVO.setType("sub");
            menuVO.setIcon("icon iconfont icon-home");
            menuVO.setChildren(menuAppTree(sysApp.getAppId()));
            menuVOS.add(menuVO);
        }
        return menuVOS;
    }


    /**
     * @param id id
     * @return List<MenuVO>
     */
    public List<MenuVO> menuAppTree(String id) {
        List<MenuVO> menuVOS = new ArrayList<>();
        for (SysPermissionBO sysPermission : permissions) {
            if (sysPermission.getParentId().equals(id) && sysPermission.getStatus() == 1) {
                MenuVO menuVO = new MenuVO();
                menuVO.setName(sysPermission.getName());
                menuVO.setState(sysPermission.getResourceName());
                menuVO.setIcon(sysPermission.getIcon());
                menuVO.setUrl(sysPermission.getMenuUrl());
                menuVO.setType(sysPermission.getType());
                if (!sysPermission.getType().equals("button")) {
                    menuVO.setChildren(CollectionUtils.isEmpty(menuTree(sysPermission.getId())) ? null : menuAppTree(
                            sysPermission.getId()));
                    menuVOS.add(menuVO);
                } else {
                    if (!resource.contains(menuVO)) {
                        resource.add(menuVO);
                    }
                }
            }
        }
        return menuVOS;
    }

    /**
     * Gets sysApps
     *
     * @return value of sysApps
     */
    public List<SysApp> getSysApps() {
        return sysApps;
    }

    /**
     * @param sysApps sysApps
     */
    public void setSysApps(List<SysApp> sysApps) {
        this.sysApps = sysApps;
    }

    /**
     * Gets permissions
     *
     * @return value of permissions
     */
    public List<SysPermissionBO> getPermissions() {
        return permissions;
    }

    /**
     * @param permissions permissions
     */
    public void setPermissions(List<SysPermissionBO> permissions) {
        this.permissions = permissions;
    }

    /**
     * Gets resource
     *
     * @return value of resource
     */
    public List<MenuVO> getResource() {
        return resource;
    }

    /**
     * @param resource resource
     */
    public void setResource(List<MenuVO> resource) {
        this.resource = resource;
    }
}
