package com.masspick.peak.resource.rpc;

import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.resource.config.constant.CommonConstant;
import com.masspick.peak.resource.entity.SysRole;
import com.masspick.peak.resource.entity.SysUser;
import com.masspick.peak.resource.service.IRoleService;
import com.masspick.peak.service.RoleFeignApi;
import com.masspick.peak.service.dto.SysRoleDTO;
import com.masspick.peak.service.dto.SysUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *  角色对外暴露接口实现类
 */
@RestController
public class RoleFeignRpc implements RoleFeignApi {
    /**
     * roleService
     */
    @Autowired
    private IRoleService roleService;

    /**
     *
     * @param roleName 角色名称
     * @return
     * @throws Exception
     */
    @Override
    public List<SysUserDTO> findUserListByRoleName(@PathVariable("roleName") String roleName) throws Exception {
        List<SysUserDTO> sysUserDtos = new ArrayList<>();
        SysRole sysRole = roleService.findByRoleName(roleName);
        if (sysRole == null || sysRole.getStatus() == CommonConstant.DISABLE_STATUS) {
            return sysUserDtos;
        }

        List<SysUser> sysUserList = roleService.findUserListByRoleId(sysRole.getId());
        for (SysUser sysUser : sysUserList) {
            sysUserDtos.add(JacksonUtils.copyProperties(sysUser, SysUserDTO.class));
        }
        return sysUserDtos;
    }

    /**
     *
     * @param account 账号
     * @return
     * @throws Exception
     */
    @Override
    public List<SysRoleDTO> findRoleListByAccount(@PathVariable("account") String account) throws Exception {
        List<SysRoleDTO> sysRoleDTOList = new ArrayList<>();
        List<SysRole> sysRoleList = roleService.findRoleListByAccount(account);
        if (!CollectionUtils.isEmpty(sysRoleList)) {
            for (SysRole sysRole : sysRoleList) {
                sysRoleDTOList.add(JacksonUtils.copyProperties(sysRole, SysRoleDTO.class));
            }
        }
        return sysRoleDTOList;
    }
}
