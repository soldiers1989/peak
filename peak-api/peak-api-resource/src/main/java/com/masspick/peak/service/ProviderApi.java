package com.masspick.peak.service;

import com.masspick.peak.dto.SysDictionaryDTO;
import com.masspick.peak.dto.SysRoleDTO;
import com.masspick.peak.dto.SysUserDTO;
import com.masspick.peak.service.hystrix.ProviderApiFeignHystix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * ProviderApi
 */
@FeignClient(value = "peak-resource-provider", fallbackFactory = ProviderApiFeignHystix.class)
public interface ProviderApi {

    /**
     * @return String
     */
    @RequestMapping(method = RequestMethod.GET, value = "/api/provider/getFromApi")
    String getFromApi();

    /**
     * @param userName
     * @return SysUserDTO
     * @throws Exception Exception
     */
    @RequestMapping(method = {RequestMethod.GET}, value = "/api/provider/{userName}")
    SysUserDTO findUserByName(@PathVariable("userName") String userName) throws Exception;

    /**
     * @param userName
     * @return  List<SysRoleDTO>
     * @throws Exception Exception
     */
    @RequestMapping(method = {RequestMethod.GET}, value = "/api/provider/getRolesByName/{userName}")
    List<SysRoleDTO> findRolesByUserName(@PathVariable("userName") String userName) throws Exception;

    /**
     * @param roleId
     * @return SysRoleDTO
     * @throws Exception Exception
     */
    @RequestMapping(method = {RequestMethod.GET}, value = "/api/provider/getRoleById")
    SysRoleDTO findRoleByRoleId(@RequestParam("roleId") String roleId) throws Exception;

    /**
     * @param type
     * @return List<SysDictionaryDTO>
     * @throws Exception Exception
     */
    @RequestMapping(method = {RequestMethod.GET}, value = "/api/provider/getDictByType/{type}")
    List<SysDictionaryDTO> findDictByType(@PathVariable("type") String type) throws Exception;

    /**
     * @param type
     * @param bussKey
     * @return String
     * @throws Exception Exception
     */
    @RequestMapping(method = {RequestMethod.GET}, value = "/api/provider/getDictByTypeAndkey")
    String findDictNameByTypeAndKey(@RequestParam("type") String type, @RequestParam("bussKey") String bussKey) throws Exception;

    /**
     * @param roleId
     * @return List<SysUserDTO>
     * @throws Exception Exception
     */
    @RequestMapping(method = {RequestMethod.GET}, value = "/api/provider/{roleId}/roleId")
    List<SysUserDTO> findUserByRoleId(@PathVariable("roleId") String roleId) throws Exception;

}
