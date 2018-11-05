package com.masspick.peak.resource.service;


import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.entity.SysApp;
import com.masspick.peak.resource.vo.AppFindVo;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * IAppService
 */
public interface IAppService {

    /**
     * @param appFindVo     appFindVo
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    ApiResponse findAppByPage(AppFindVo appFindVo, BindingResult bindingResult);

    /**
     * @return ApiResponse
     */
    ApiResponse findAllApp();

    /**
     * @param sysApp        sysApp
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    ApiResponse addApp(SysApp sysApp, BindingResult bindingResult);

    /**
     * @param id     id
     * @param status status
     * @return ApiResponse
     */
    ApiResponse modifyAppStatus(String id, Integer status);

    /**
     * @param id id
     * @return ApiResponse
     */
    ApiResponse findOneApp(String id);

    /**
     * @param id            id
     * @param formApp       formApp
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    ApiResponse modifyApp(String id, SysApp formApp, BindingResult bindingResult);

    /**
     * @param appId appId
     * @return SysApp
     */
    SysApp findByAppId(String appId);

    /**
     *
     * @param appIds appIds
     * @return List
     */
    List<SysApp> findByAppId(List<String> appIds);

    /**
     *
     * @param appId appid
     * @return List<SysApp>
     */
    List<SysApp> findAllExceptSelf(String appId);
}
