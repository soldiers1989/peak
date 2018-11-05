package com.masspick.peak.resource.service.impl;


import com.masspick.peak.resource.entity.SysRole;
import com.masspick.peak.resource.entity.SysRolePermission;
import com.masspick.peak.resource.entity.SysUser;
import com.masspick.peak.resource.mapper.SysRoleMapper;
import com.masspick.peak.resource.mapper.SysRolePermissionMapper;
import com.masspick.peak.resource.mapper.SysUserMapper;
import com.masspick.peak.resource.service.IRoleService;
import com.masspick.peak.resource.vo.PermissionListVo;
import com.masspick.peak.resource.vo.RoleFindListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * RoleServiceImpl
 */
@Service
public class RoleServiceImpl implements IRoleService {


    /**
     * sysRoleMapper
     */
    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     *  sysUserMapper
     */
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * sysRoleMapper
     */
    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public List<SysRole> findRoleList(RoleFindListVo roleFindListVo) {
        return sysRoleMapper.findList(roleFindListVo);
    }

    @Override
    public List<SysRole> findAllRole(Integer status) {
        return sysRoleMapper.findAllRole(status);
    }

    @Override
    public Boolean checkRoleName(SysRole sysRole) {
        SysRole dbRole = sysRoleMapper.findByName(sysRole.getName());
        if (dbRole != null && sysRole.getId() == null) {
            return false;
        }

        if (dbRole != null && !dbRole.getId().equals(sysRole.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public Integer addRole(SysRole sysRole) {
        return sysRoleMapper.insert(sysRole);
    }

    @Override
    public SysRole modifyRoleStatus(String id, Integer status) {
        SysRole sysRole = new SysRole();
        sysRole.setUpdateDate(new Date());
        sysRole.setId(id);
        sysRole.setStatus(status);
        sysRoleMapper.update(sysRole);
        sysRole = sysRoleMapper.findById(id);
        return sysRole;
    }

    @Override
    public SysRole findOneRole(String id) {
        return sysRoleMapper.findById(id);
    }

    @Override
    public SysRole modifyRole(SysRole sysRole) {
        sysRole.setUpdateDate(new Date());
        sysRoleMapper.update(sysRole);
        return sysRoleMapper.findById(sysRole.getId());
    }

    @Transactional
    @Override
    public Integer addRolePermission(String roleId, String appId, PermissionListVo permissionListVo, StringBuffer message) {

        //删除老数据
        int deleteRole = sysRolePermissionMapper.deleteByRoleId(roleId, appId);


        List<String> permissionList = permissionListVo.getPermissionId();
        if (deleteRole <= 0 && permissionList.size() == 0) {
            message.append("请选择权限管理");
            return 0;
        }
        List<SysRolePermission> sysRolePermissionList = new ArrayList<>();
        for (String permissionId : permissionList) {
            SysRolePermission sysRolePermission = new SysRolePermission();
            sysRolePermission.setRoleId(roleId);
            sysRolePermission.setPermissionId(permissionId);
            sysRolePermission.setAppId(appId);
            sysRolePermissionList.add(sysRolePermission);
        }
        if (!CollectionUtils.isEmpty(sysRolePermissionList)) {
            sysRolePermissionMapper.insertList(sysRolePermissionList);
            return sysRolePermissionList.size();
        }

        return 0;
    }

    @Override
    public SysRole findByRoleName(String roleName) {
        return sysRoleMapper.findByName(roleName);
    }

    @Override
    public List<SysUser> findUserListByRoleId(String roleId) {
        return sysRoleMapper.findUserListByRoleId(roleId);
    }

    @Override
    public List<SysRole> findRoleListByAccount(String account) {
        SysUser  sysUser = sysUserMapper.findOneByAccount(account);
        if (sysUser == null) {
            return null;
        }
        return sysRoleMapper.findRoleListByUserId(sysUser.getId());
    }
}
