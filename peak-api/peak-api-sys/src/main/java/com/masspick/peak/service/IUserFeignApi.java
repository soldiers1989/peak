package com.masspick.peak.service;

import com.masspick.peak.common.util.ApiResponse;
import com.masspick.peak.service.dto.ApiResponseDTO;
import com.masspick.peak.service.dto.SysUserDTO;
import com.masspick.peak.service.hystrix.IUserFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.List;

/**
 * Created by admin on 2018/9/5 0005.
 */
@FeignClient(value = "peak-sys-admin", fallbackFactory = IUserFeignHystrix.class)
public interface IUserFeignApi {

    /**
     * 根据用户名获取用户信息
     *
     * @param account account
     * @return SysUserDTO
     * @throws Exception Exception
     */
    @RequestMapping(value = "/v1/resource/users/{account}", method = RequestMethod.GET)
    SysUserDTO findByName(@PathVariable("account") String account) throws Exception;

    /**
     * 根据用户名修改密码
     *
     * @param account account
     * @return SysUserDTO
     * @throws Exception Exception
     */
    @RequestMapping(value = "/v1/resource/api/users/pass/{account}", method = RequestMethod.PATCH)
    ApiResponseDTO modifyUserPass(@PathVariable("account") String account, @RequestBody Map<String, String> userMap) throws Exception;

    /**
     * 根据用户名与密码获取用户信息
     *
     * @param map map
     * @return ApiResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/v1/resource/users", method = RequestMethod.POST)
    ApiResponse findByNameAndPassword(@RequestBody Map<String, String> map) throws Exception;

    /**
     * @param roleName
     * @param areaName
     * @return List
     * @throws Exception Exception
     */
    @RequestMapping(method = {RequestMethod.GET}, value = "/v1/resource/users/findUserByRoleAndAreaName")
    List<SysUserDTO> findUserByRoleAndAreaName(@RequestParam("roleName") String roleName,
                                               @RequestParam("areaName") String areaName) throws Exception;

    /**
     * @return ApiResponseDTO
     * @throws Exception  Exception
     */
    @RequestMapping(method = {RequestMethod.GET}, value = "/v1/resource/users/info")
    ApiResponseDTO userInfo() throws Exception;
}
