package com.masspick.peak.resource.service;

import com.masspick.peak.resource.entity.SysPermission;
import com.masspick.peak.resource.entity.bo.PermissionNode;
import com.masspick.peak.resource.entity.bo.SysPermissionBO;

import java.util.List;

/**
 * 权限service接口
 */
public interface IPermissionService {
    /**
     * @param sysPermission 权限实体对象
     * @return SysPermission 权限实体对象
     */
    SysPermission addPermission(SysPermission sysPermission);


    /**
     * 校验code是否唯一
     *
     * @param sysPermission sysPermission
     * @param parentCode    parentCode
     * @return Boolean
     */
    Boolean checkCode(SysPermission sysPermission, String parentCode);

    /**
     * @param appId 应用id
     * @return List<SysPermission>
     */
    List<SysPermission> findPermissionList(String appId);

    /**
     * @param appId 应用id
     * @return List<SysPermission>
     */
    List<SysPermission> findAblePermissionList(String appId);

    /**
     * @param appId 应用id
     * @param id    编辑对象的id
     * @return List<SysPermission>
     */
    List<SysPermission> findAllPermExceptSelf(String appId, String id);

    /**
     * @param sysPermission sysPermission
     * @return SysPermission
     */
    SysPermission modifyPermissionStatus(SysPermission sysPermission);

    /**
     * @param id id
     * @return SysPermission
     */
    SysPermission findOne(String id);

    /**
     * @param sysPermission sysPermission
     * @return SysPermission
     */
    SysPermission modifyPermission(SysPermission sysPermission);

    /**
     * @param userId 账号
     * @param appId  应用id
     * @return List<SysPermissionBO>
     */
    List<SysPermissionBO> findByAccountAndAppId(String userId, String appId);

    /**
     * @param roleId 角色id
     * @param appId  应用id
     * @return List<PermissionNode>
     */
    List<PermissionNode> findByPermissionByAppIdAndRoleId(String roleId, String appId);

    /**
     * @param id id
     * @return int
     */
    int findUnableParentCount(String id);

    /**
     *
     * @param account 账号
     * @param appId appid
     * @return int
     */
    int findPermCountByAccoutAndAppId(String account, String appId);
}
