package com.masspick.peak.resource.rpc;

import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.dto.SysDictionaryDTO;
import com.masspick.peak.dto.SysRoleDTO;
import com.masspick.peak.dto.SysUserDTO;
import com.masspick.peak.resource.model.SysDictionary;
import com.masspick.peak.resource.model.SysRole;
import com.masspick.peak.resource.model.SysUser;
import com.masspick.peak.resource.service.DictService;
import com.masspick.peak.resource.service.UserService;
import com.masspick.peak.service.ProviderApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018\5\30 0030.
 */
@RestController
public class ProviderFeignClient implements ProviderApi {

    /**
     * userService
     */
    @Autowired
    private UserService userService;

    /**
     * dictService
     */
    @Autowired
    private DictService dictService;

    /**
     * @return String
     */
    @Override
    public String getFromApi() {
        return "from provider";
    }

    /**
     * @param userName
     * @return SysUserDTO
     */
    @Override
    public SysUserDTO findUserByName(@PathVariable("userName") String userName) {
        SysUserDTO dto = null;
        SysUser sysUser = userService.findByUserName(userName);
        if (sysUser != null) {
            dto = JacksonUtils.copyProperties(sysUser, SysUserDTO.class);
        }
        return dto;
    }

    /**
     * @param userName
     * @return List
     */
    @Override
    public List<SysRoleDTO> findRolesByUserName(@PathVariable("userName") String userName) {
        List<SysRoleDTO> dtoList = null;
        List<SysRole> list = userService.findRoleByUserName(userName);
        if (!CollectionUtils.isEmpty(list)) {
            dtoList = new ArrayList<>();
            for (SysRole role : list) {
                SysRoleDTO dto = JacksonUtils.copyProperties(role, SysRoleDTO.class);
                dtoList.add(dto);
            }
        }
        return dtoList;
    }

    /**
     * @param roleId
     * @return SysRoleDTO
     */
    @Override
    public SysRoleDTO findRoleByRoleId(String roleId) {
        SysRoleDTO dto = null;
        SysRole role = userService.findRoleById(roleId);
        if (role != null) {
            dto = JacksonUtils.copyProperties(role, SysRoleDTO.class);
        }
        return dto;
    }

    /**
     * @param type
     * @return List
     */
    @Override
    public List<SysDictionaryDTO> findDictByType(@PathVariable("type") String type) {
        List<SysDictionaryDTO> dtoList = null;
        List<SysDictionary> list = dictService.getByType(type);
        if (!CollectionUtils.isEmpty(list)) {
            dtoList = new ArrayList<>();
            for (SysDictionary dictionary : list) {
                SysDictionaryDTO dto = JacksonUtils.copyProperties(dictionary, SysDictionaryDTO.class);
                dtoList.add(dto);
            }
        }
        return dtoList;
    }

    /**
     * @param type
     * @param bussKey
     * @return String
     */
    @Override
    public String findDictNameByTypeAndKey(String type, String bussKey) {
        return dictService.findDictName(bussKey, type, "");
    }

    /**
     * @param roleId
     * @return List
     */
    @Override
    public List<SysUserDTO> findUserByRoleId(@PathVariable("roleId") String roleId) {
        List<SysUserDTO> dtoList = null;
        List<SysUser> list = userService.findUserByRoleId(roleId);
        if (!CollectionUtils.isEmpty(list)) {
            dtoList = new ArrayList<>();
            for (SysUser user : list) {
                SysUserDTO dto = JacksonUtils.copyProperties(user, SysUserDTO.class);
                dtoList.add(dto);
            }
        }
        return dtoList;
    }

}
