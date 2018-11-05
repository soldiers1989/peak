package com.masspick.peak.resource.service.impl;

import com.masspick.peak.resource.mapper.SysMenuMapper;
import com.masspick.peak.resource.mapper.SysRoleMapper;
import com.masspick.peak.resource.mapper.SysRoleMenuMapper;
import com.masspick.peak.resource.mapper.SysUserMapper;
import com.masspick.peak.resource.mapper.SysUserRoleMapper;
import com.masspick.peak.resource.model.SysMenu;
import com.masspick.peak.resource.model.SysRole;
import com.masspick.peak.resource.model.SysUser;
import com.masspick.peak.resource.model.SysUserRole;
import com.masspick.peak.resource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * sysUserMapper
     */
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * sysUserRoleMapper
     */
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * sysRoleMapper
     */
    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * sysRoleMenuMapper
     */
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * sysMenuMapper
     */
    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * @param userName
     * @return SysUser
     */
    @Override
    public SysUser findByUserName(String userName) {
        return sysUserMapper.findByUserName(userName);
    }

    /**
     * @param userName
     * @return List
     */
    @Override
    public List<SysRole> findRoleByUserName(String userName) {
        SysUser user = sysUserMapper.findByUserName(userName);
        if (user != null) {
            String userId = user.getId();
            List<SysRole> sysRoles = sysRoleMapper.findListByUserId(userId);
            return sysRoles;

        }
        return new ArrayList<>();
    }

    /**
     * @param userName
     * @return List
     */
    @Override
    public List<SysMenu> findMenuByUserName(String userName) {
        SysUser user = sysUserMapper.findByUserName(userName);
        if (user != null) {
            String userId = user.getId();
            Map<String, Object> queryParams = new HashMap<>();
            queryParams.put("userId", userId);
            List<SysMenu> sysMenus = sysMenuMapper.selectListByUserId(queryParams);
            return sysMenus;
        }

        return new ArrayList<>();
    }

    /**
     * @param userName
     * @param appKey
     * @return List
     */
    @Override
    public List<SysMenu> findMenuByUserNameAndKey(String userName, String appKey) {
        SysUser user = sysUserMapper.findByUserName(userName);
        if (user != null) {
            String userId = user.getId();
            Map<String, Object> queryParams = new HashMap<>();
            queryParams.put("userId", userId);
            queryParams.put("appKey", appKey);
            List<SysMenu> sysMenus = sysMenuMapper.selectListByUserId(queryParams);
            return sysMenus;
        }

        return new ArrayList<>();
    }

    /**
     * @param roleId
     * @return List
     */
    @Override
    public List<SysUser> findUserByRoleId(String roleId) {
        List<SysUser> list = new ArrayList<>();
        List<SysUserRole> userRoles = sysUserRoleMapper.findByRoleId(roleId);
        if (!CollectionUtils.isEmpty(userRoles)) {
            for (SysUserRole userRole : userRoles) {
                String userId = userRole.getUserId();
                SysUser user = sysUserMapper.findById(userId);
                if (user != null) {
                    list.add(user);
                }
            }
        }
        return list;
    }

    /**
     * @param roleId
     * @return SysRole
     */
    @Override
    public SysRole findRoleById(String roleId) {
        return sysRoleMapper.findById(roleId);
    }
}
