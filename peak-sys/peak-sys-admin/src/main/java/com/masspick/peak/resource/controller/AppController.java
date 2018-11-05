package com.masspick.peak.resource.controller;

import com.masspick.peak.resource.anno.Log;
import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.entity.SysApp;
import com.masspick.peak.resource.service.IAppService;
import com.masspick.peak.resource.vo.AppFindVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 应用管理
 */

@RestController
@RequestMapping("/v1/resource")
public class AppController {



    /**
     * httpServletRequest
     */
    @Autowired
    private HttpServletRequest httpServletRequest;
    /**
     * appService
     */
    @Autowired
    private IAppService appService;

    /**
     * 分页查询app
     *
     * @param appFindVo     appFindVo
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @GetMapping("/appGrid")
    public ApiResponse findAppByPage(@Valid AppFindVo appFindVo, BindingResult bindingResult) {
        return appService.findAppByPage(appFindVo, bindingResult);
    }

    /**
     * 查询所有app
     *
     * @return ApiResponse
     */
    @GetMapping("/app")
    public ApiResponse findAllApp() {
        return appService.findAllApp();
    }


    /**
     * @param sysApp        sysApp
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @Log("创建应用")
    @PostMapping("/app")
    public ApiResponse addApp(@Valid @RequestBody SysApp sysApp, BindingResult bindingResult) {
        return appService.addApp(sysApp, bindingResult);
    }

    /**
     * @param id     id
     * @param sysApp sysApp
     * @return ApiResponse
     */
    @Log("修改应用状态")
    @PatchMapping("/app/{id}")
    public ApiResponse modifyAppStatus(@PathVariable("id") String id, @RequestBody SysApp sysApp) {
        return appService.modifyAppStatus(id, sysApp.getStatus());
    }

    /**
     * @param id id
     * @return ApiResponse
     */
    @GetMapping("/app/{id}")
    public ApiResponse findOneApp(@PathVariable("id") String id) {
        return appService.findOneApp(id);
    }

    /**
     * @param id            id
     * @param formApp       formApp
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @Log("更新应用")
    @PutMapping("/app/{id}")
    public ApiResponse modifyApp(@PathVariable("id") String id, @Valid @RequestBody SysApp formApp, BindingResult
            bindingResult) {
        return appService.modifyApp(id, formApp, bindingResult);
    }
}
