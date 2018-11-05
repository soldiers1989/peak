package com.masspick.peak.resource.service;


import com.masspick.peak.resource.entity.SysRole;
import com.masspick.peak.resource.entity.SysUser;
import com.masspick.peak.resource.vo.PermissionListVo;
import com.masspick.peak.resource.vo.RoleFindListVo;

import java.util.List;

/**
 * IRoleService
 */
public interface IRoleService {

    /**
     * @param sysRole sysRole
     * @return List
     */
    List<SysRole> findRoleList(RoleFindListVo sysRole);

    /**
     * @param status status
     * @return List<SysRole>
     */
    List<SysRole> findAllRole(Integer status);

    /**
     * @param sysRole sysRole
     * @return Boolean
     */
    Boolean checkRoleName(SysRole sysRole);

    /**
     * @param sysRole sysRole
     * @return Integer
     */
    Integer addRole(SysRole sysRole);

    /**
     * @param id     id
     * @param status status
     * @return SysRole
     */
    SysRole modifyRoleStatus(String id, Integer status);

    /**
     * @param id id
     * @return SysRole
     */
    SysRole findOneRole(String id);

    /**
     * @param sysRole sysRole
     * @return SysRole
     */
    SysRole modifyRole(SysRole sysRole);

    /**
     * @param roleId           roleId
     * @param appId            appId
     * @param permissionListVo permissionListVo
     * @param message          message
     * @return Integer
     */
    Integer addRolePermission(String roleId, String appId, PermissionListVo permissionListVo, StringBuffer message);

    /**
     *
     * @param roleName 角色名称
     * @return SysRole
     */
    SysRole findByRoleName(String roleName);

    /**
     *
     * @param roleId 角色id
     * @return  List<SysUser>
     */
    List<SysUser> findUserListByRoleId(String roleId);

    /**
     *
     * @param account account
     * @return List<SysRole>
     */
    List<SysRole> findRoleListByAccount(String account);
}
