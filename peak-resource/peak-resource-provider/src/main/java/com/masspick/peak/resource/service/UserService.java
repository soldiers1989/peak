package com.masspick.peak.resource.service;


import com.masspick.peak.resource.model.SysMenu;
import com.masspick.peak.resource.model.SysRole;
import com.masspick.peak.resource.model.SysUser;

import java.util.List;

/**
 * UserService
 */
public interface UserService {
    /**
     * @param userName
     * @return SysUser
     */
    SysUser findByUserName(String userName);

    /**
     * @param userName
     * @return List
     */
    List<SysRole> findRoleByUserName(String userName);

    /**
     * @param userName
     * @return List
     */
    List<SysMenu> findMenuByUserName(String userName);

    /**
     * @param userName
     * @param appKey
     * @return List
     */
    List<SysMenu> findMenuByUserNameAndKey(String userName, String appKey);

    /**
     * @param roleId
     * @return List
     */
    List<SysUser> findUserByRoleId(String roleId);

    /**
     * @param roleId
     * @return SysRole
     */
    SysRole findRoleById(String roleId);
}
