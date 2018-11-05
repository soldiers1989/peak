package com.masspick.peak.service;

import com.masspick.peak.service.dto.ApiResponseDTO;
import com.masspick.peak.service.dto.SysPermissionDTO;
import com.masspick.peak.service.hystrix.PermissionFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 资源平台对外接口暴露
 */
@FeignClient(value = "peak-sys-admin", fallbackFactory = PermissionFeignHystrix.class)
public interface PermissionFeignApi {

    /**
     * @return ApiResponse
     * @throws Exception Exception
     */
    @RequestMapping(method = RequestMethod.GET, value = "/api/resource/user/permission")
    ApiResponseDTO userPermission() throws Exception;

    /**
     * @param account
     * @param appId
     * @return List
     * @throws Exception Exception
     */
    @RequestMapping(method = RequestMethod.GET, value = "/api/resource/user/dd/permission")
    List<SysPermissionDTO> ddPermission(@RequestParam("account") String account, @RequestParam("appId") String appId)
            throws Exception;

}
