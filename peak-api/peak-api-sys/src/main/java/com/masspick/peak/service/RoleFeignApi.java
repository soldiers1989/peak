package com.masspick.peak.service;


import com.masspick.peak.service.dto.SysRoleDTO;
import com.masspick.peak.service.dto.SysUserDTO;
import com.masspick.peak.service.hystrix.RoleFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 *  资源平台角色feign接口
 */
@FeignClient(value = "peak-sys-admin", fallbackFactory = RoleFeignHystrix.class)
public interface RoleFeignApi {
    /**
     *
     * @param roleName 角色名称
     * @return List<SysUserDTO>
     * @throws Exception Exception
     */
    @RequestMapping(method = RequestMethod.GET, value = "/api/resource/userList/{roleName}")
    List<SysUserDTO> findUserListByRoleName(@PathVariable("roleName") String roleName) throws Exception;

    /**
     *
     * @param account 账号
     * @return List
     * @throws Exception Exception
     */
    @RequestMapping(method = RequestMethod.GET, value = "/api/resource/roleList/{account}")
    List<SysRoleDTO> findRoleListByAccount(@PathVariable("account") String account) throws Exception;
}
