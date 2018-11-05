package com.masspick.peak.resource.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.entity.SysApp;
import com.masspick.peak.resource.mapper.SysAppMapper;
import com.masspick.peak.resource.service.IAppService;
import com.masspick.peak.resource.utils.SpecialCharTrans;
import com.masspick.peak.resource.vo.AppFindVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * appServiceImpl
 */
@Service
public class AppServiceImpl implements IAppService {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AppServiceImpl.class);

    /**
     * sysAppMapper
     */
    @Autowired
    private SysAppMapper sysAppMapper;

    /**
     *
     * @param appFindVo appFindVo
     * @param bindingResult bindingResult
     * @return
     */
    @Override
    public ApiResponse findAppByPage(@Valid AppFindVo appFindVo, BindingResult bindingResult) {
        LOGGER.info("com in findAllApp , requestParams :" + appFindVo.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            LOGGER.info("params error :" + bindingResult.getFieldErrors().toString());
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        PageHelper.startPage(appFindVo.getPageNum(), appFindVo.getPageSize());
        appFindVo.setAppName(SpecialCharTrans.transSpecialChar(appFindVo.getAppName()));
        List<SysApp> sysAppList = sysAppMapper.findList(appFindVo);
        apiResponse.success().setResult(new PageInfo<>(sysAppList));
        LOGGER.info("end in findAllApp");
        return apiResponse;
    }

    /**
     *
     * @return
     */
    @Override
    public ApiResponse findAllApp() {
        LOGGER.info("come in findAllApp");
        ApiResponse apiResponse = ApiResponse.getInstances();
        List<SysApp> sysAppList = sysAppMapper.findAll();
        apiResponse.success().setResult(sysAppList);
        LOGGER.info("end in findAllApp, result = " + sysAppList.toString());
        return apiResponse;
    }

    /**
     *
     * @param sysApp sysApp
     * @param bindingResult bindingResult
     * @return
     */
    @Override
    public ApiResponse addApp(@Valid SysApp sysApp, BindingResult bindingResult) {
        LOGGER.info("com in addApp , requestParams :" + sysApp.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            LOGGER.info("params error :" + bindingResult.getFieldErrors().toString());
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        sysApp.preInsert();
        LOGGER.info("insert app, params :" + bindingResult.getFieldErrors().toString());
        sysAppMapper.insert(sysApp);
        apiResponse.success().setResult(sysApp);
        LOGGER.info("end in addApp");
        return apiResponse;
    }

    /**
     *
     * @param id id
     * @param status  status
     * @return
     */
    @Override
    public ApiResponse modifyAppStatus(String id, Integer status) {
        LOGGER.info("com in modifyAppStatus , requestParams : id = " + id + ", status = " + status);
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (status == null) {
            return apiResponse.error("400").setReason("应用状态不能为空");
        }
        SysApp sysApp = sysAppMapper.findOne(id);
        if (sysApp == null) {
            apiResponse.error("401").setReason("应用不存在");
        } else {
            sysApp.setStatus(status);
            sysApp.setUpdateDate(new Date());
            LOGGER.info("modifyAppStatus app, params :" + sysApp.toString());
            sysAppMapper.update(sysApp);
            apiResponse.success().setResult(sysApp);
        }
        LOGGER.info("end in modifyAppStatus");
        return apiResponse;
    }

    /**
     *
     * @param id id
     * @return
     */
    @Override
    public ApiResponse findOneApp(String id) {
        LOGGER.info("com in findOneApp , requestParams : id = " + id);
        ApiResponse apiResponse = ApiResponse.getInstances();
        SysApp sysApp = sysAppMapper.findOne(id);
        LOGGER.info("findOneApp, result :" + sysApp.toString());
        LOGGER.info("end in modifyAppStatus");
        return apiResponse.success().setResult(sysApp);
    }

    /**
     *
     * @param id id
     * @param formApp formApp
     * @param bindingResult bindingResult
     * @return
     */
    @Override
    public ApiResponse modifyApp(String id, @Valid SysApp formApp, BindingResult bindingResult) {
        LOGGER.info("com in findOneApp , requestParams : " + formApp.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        SysApp sysApp = sysAppMapper.findOne(id);
        if (sysApp == null) {
            LOGGER.info("app is not exist");
            return apiResponse.error("401").setReason("应用不存在");
        } else {
            formApp.setId(id);
            formApp.setUpdateDate(new Date());
            LOGGER.info("update app, request params = " + formApp.toString());
            sysAppMapper.update(formApp);
        }
        LOGGER.info("end in modifyAppStatus");
        return apiResponse.success().setResult(sysAppMapper.findOne(formApp.getId()));
    }

    @Override
    public SysApp findByAppId(String appId) {
        return sysAppMapper.findByAppId(appId);
    }

    @Override
    public List<SysApp> findByAppId(List<String> appIds) {
        return sysAppMapper.findByAppIdin(appIds);
    }

    @Override
    public List<SysApp> findAllExceptSelf(String appId) {
        return sysAppMapper.findAllExceptSelf(appId);
    }
}
