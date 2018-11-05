package com.masspick.peak.resource.controller;

import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.resource.anno.Log;
import com.masspick.peak.resource.config.constant.CommonConstant;
import com.masspick.peak.resource.config.constant.PermissionConstant;
import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.controller.vo.MenuTreeVO;
import com.masspick.peak.resource.controller.vo.MenuVO;
import com.masspick.peak.resource.entity.SysApp;
import com.masspick.peak.resource.entity.SysPermission;
import com.masspick.peak.resource.entity.SysUser;
import com.masspick.peak.resource.entity.bo.SysPermissionBO;
import com.masspick.peak.resource.service.IAppService;
import com.masspick.peak.resource.service.IPermissionService;
import com.masspick.peak.resource.service.IUserService;
import com.masspick.peak.resource.utils.HeaderUtil;
import com.masspick.peak.resource.utils.SpringContextHolder;
import com.masspick.peak.resource.vo.PermissionFindListVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限管理
 */

@RestController
@RequestMapping("/v1/resource")
public class PermissionController {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);

    /**
     * permissionService
     */
    @Autowired
    private IPermissionService permissionService;

    /**
     * httpServletRequest
     */
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * iUserService
     */
    @Autowired
    private IUserService iUserService;

    /**
     * iAppService
     */
    @Autowired
    private IAppService iAppService;

    /**
     * 权限分页查询
     *
     * @param permissionFindListVo permissionFindListVo
     * @param bindingResult        bindingResult
     * @return ApiResponse
     */
    @GetMapping("/permission")
    ApiResponse findPermissionList(PermissionFindListVo permissionFindListVo, BindingResult bindingResult) {
        LOGGER.info("come in findPermissionList, request params = " + permissionFindListVo.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            LOGGER.error("params error , params = " + bindingResult.toString());
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        List<SysPermission> sysPermissionList = permissionService.findPermissionList(permissionFindListVo.getAppId());
        apiResponse.success().setResult(sysPermissionList);
        return apiResponse;
    }


    /**
     * 添加获取权限列表
     *
     * @param permissionFindListVo permissionFindListVo
     * @param bindingResult        bindingResult
     * @return ApiResponse
     */
    @GetMapping("/permission/status")
    ApiResponse findAblePermissionList(PermissionFindListVo permissionFindListVo, BindingResult bindingResult) {
        LOGGER.info("come in findAblePermissionList, request params = " + permissionFindListVo.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            LOGGER.error("params error , params = " + bindingResult.toString());
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        List<SysPermission> sysPermissionList = permissionService.findAblePermissionList(permissionFindListVo
                .getAppId());
        apiResponse.success().setResult(sysPermissionList);
        LOGGER.info("end in findAblePermissionList,findAblePermissionList result =" + permissionFindListVo.toString());
        return apiResponse;
    }

    /**
     * 编辑获取权限列表
     *
     * @param permissionFindListVo permissionFindListVo
     * @param bindingResult        bindingResult
     * @return ApiResponse
     */
    @GetMapping("/permission/edit")
    ApiResponse findAllPermExceptSelf(PermissionFindListVo permissionFindListVo, BindingResult bindingResult) {
        LOGGER.info("come in findAllPermExceptSelf, request params = " + permissionFindListVo.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            LOGGER.error("params error , params = " + bindingResult.toString());
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        List<SysPermission> sysPermissionList = permissionService.findAllPermExceptSelf(permissionFindListVo
                .getAppId(), permissionFindListVo.getId());
        apiResponse.success().setResult(sysPermissionList);
        LOGGER.info("end in findAblePermissionList,findAblePermissionList result =" + permissionFindListVo.toString());
        return apiResponse;
    }

    /**
     * 添加权限
     *
     * @param sysPermission sysPermission
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @Log("添加权限")
    @PostMapping("/permission")
    ApiResponse addPermission(@Valid @RequestBody SysPermission sysPermission, BindingResult bindingResult) {
        LOGGER.info("come in addPermission, requestParams :" + sysPermission.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();

        //判断必填校验
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        //检验type
        if (PermissionConstant.MENU_TYPE == sysPermission.getType() && StringUtils.isEmpty(sysPermission.getMenuUrl()
        )) {
            return apiResponse.error("401").setReason(PermissionConstant.URL_EMPTY_ERROR);
        }

        //校验父级是否被禁用
        String parentCode = "";
        if (StringUtils.isEmpty(sysPermission.getParentId().trim())) {
            sysPermission.setParentId(null);
        } else {
            SysPermission parentPermission = permissionService.findOne(sysPermission.getParentId());
            if (parentPermission == null) {
                return apiResponse.error("401").setReason("所选父级不存在,请重新选择");
            }
            parentCode = parentPermission.getCode();
        }

        //校验code是否唯一
        if (!permissionService.checkCode(sysPermission, parentCode)) {
            return apiResponse.error("401").setReason(PermissionConstant.REPEAT_CODE);
        }

        sysPermission = permissionService.addPermission(sysPermission);
        LOGGER.info("end in addPermission, result");
        return apiResponse.success().setResult(sysPermission);
    }


    /**
     * 禁用或启用权限
     *
     * @param id            id
     * @param sysPermission sysPermission
     * @return ApiResponse
     */
    @Log("禁用或启用权限")
    @PatchMapping("/permission/{id}")
    ApiResponse modifyPermissionStatus(@PathVariable("id") String id, @RequestBody SysPermission sysPermission) {
        LOGGER.info("come in modifyPermissionStatus");
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (sysPermission == null || sysPermission.getStatus() == null) {
            return apiResponse.error("400").setReason("状态不能为空");
        }
        sysPermission.setId(id);
        LOGGER.info("request params : " + sysPermission.toString());
        sysPermission = permissionService.modifyPermissionStatus(sysPermission);
        LOGGER.info("modifyPermissionStatus result : " + sysPermission.toString());
        apiResponse.success().setResult(sysPermission);
        LOGGER.info("end in modifyPermissionStatus");
        return apiResponse;
    }

    /**
     * 权限查看
     *
     * @param id id
     * @return ApiResponse
     */
    @GetMapping("/permission/{id}")
    ApiResponse findOne(@PathVariable("id") String id) {
        LOGGER.info("come in findOne");
        ApiResponse apiResponse = ApiResponse.getInstances();
        SysPermission sysPermission = permissionService.findOne(id);
        LOGGER.info("findOne result : " + sysPermission.toString());
        LOGGER.info("end in findOne");
        return apiResponse.success().setResult(sysPermission);
    }

    /**
     * 权限修改
     *
     * @param id            id
     * @param sysPermission sysPermission
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @Log("修改权限")
    @PutMapping("/permission/{id}")
    ApiResponse modifyPermission(@PathVariable("id") String id, @Valid @RequestBody SysPermission sysPermission,
                                 BindingResult bindingResult) {
        LOGGER.info("come in modifyPermission");
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        //赋值id
        sysPermission.setId(id);

        //查看权限是否存在
        SysPermission permission = permissionService.findOne(id);
        if (permission == null) {
            return apiResponse.error("401").setReason(PermissionConstant.MODIFY_NOT_EXIST);
        }

        //校验父级是否被禁用
        String parentCode = "";
        if (StringUtils.isEmpty(sysPermission.getParentId().trim())) {
            sysPermission.setParentId(null);
        } else {
            SysPermission parentPermission = permissionService.findOne(sysPermission.getParentId());
            if (parentPermission == null) {
                return apiResponse.error("401").setReason("所选父级不存在,请重新选择");
            }
            if (sysPermission.getParentId() != null) {
                if (!sysPermission.getParentId().equals(permission.getParentId()) && parentPermission.getStatus()
                        == CommonConstant.DISABLE_STATUS) {
                    return apiResponse.error("401").setReason(PermissionConstant.PARENT_DISABLE);
                }
                if (!sysPermission.getParentId().equals(permission.getParentId())
                        && permissionService.findUnableParentCount(parentPermission.getParentId()) > 0) {
                    return apiResponse.error("401").setReason(PermissionConstant.SUPERIOR_DISABLE);
                }
            }
            parentCode = parentPermission.getCode();
        }

        //检查同级排序是否唯一
        if (!permissionService.checkCode(sysPermission, parentCode)) {
            return apiResponse.error("401").setReason(PermissionConstant.REPEAT_CODE);
        }

        //修改权限
        sysPermission = permissionService.modifyPermission(sysPermission);
        LOGGER.info("end in modifyPermission");
        return apiResponse.success().setResult(sysPermission);
    }

    /**
     *
     * @return ApiResponse
     * @throws Exception Exception
     */
    @GetMapping("/permission/name")
    public ApiResponse userPermission() throws Exception {
        ApiResponse apiResponse = ApiResponse.getInstances();
        String appId;
        String account;
        if (SpringContextHolder.getActiveProfile().equals("dev")) {
            account = "admin";
            appId = "97a78cc5-2e92-42b8-9a7a-de4a6ad5a3b8";
        } else {
            appId = httpServletRequest.getHeader(HeaderUtil.AUTH_ID);
            account = URLDecoder.decode(httpServletRequest.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
        }
        LOGGER.info("---->userPermission params AUTH_ID={}, AUTH_USER={}<----", appId, account);

        //判断应用
        SysApp sysApp = iAppService.findByAppId(appId);
        if (sysApp == null) {
            return apiResponse.error("ERR-404", "未找到应用！！！");
        } else if (sysApp != null && sysApp.getStatus() == 0) {
            return apiResponse.error("ERR-404", "该应用已被禁用!!!");
        }

        //判断用户
        SysUser sysUser = iUserService.findByAccount(account);
        if (sysUser == null) {
            return apiResponse.error("ERR-404", "未找到该用户!!!");
        } else if (sysUser != null && sysUser.getStatus() == 0) {
            return apiResponse.error("ERR-403", "该用户已被禁用!!!");
        }

        List<SysPermissionBO> list = permissionService.findByAccountAndAppId(sysUser.getId(), appId);
        MenuTreeVO menuTreeVO = new MenuTreeVO();
        menuTreeVO.setPermissions(list);
        List<MenuVO> menuVOS = menuTreeVO.menuTree(appId);
        Map<String, Object> map = new HashMap<>();
        map.put("menu", menuVOS);
        map.put("resource", menuTreeVO.getResource());
        return apiResponse.success().setResult(map);
    }

    /**
     *
     * @return ApiResponse
     * @throws Exception Exception
     */
    @GetMapping("/apps/permission")
    public ApiResponse userPermissionAppInfo() throws Exception {
        ApiResponse apiResponse = ApiResponse.getInstances();
        String  userAccount = URLDecoder.decode(httpServletRequest.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
        String  appId = httpServletRequest.getHeader(HeaderUtil.AUTH_ID);
        LOGGER.info("---->userPermission params AUTH_ID={}, AUTH_USER={}<----", appId, userAccount);

        //判断用户
        SysUser sysUser = iUserService.findByAccount(userAccount);
        if (sysUser == null) {
            return apiResponse.error("ERR-404", "未找到该用户!!!");
        } else if (sysUser != null && sysUser.getStatus() == 0) {
            return apiResponse.error("ERR-403", "该用户已被禁用!!!");
        }

        //获取所有app信息
        List<SysApp> sysAppList = iAppService.findAllExceptSelf(appId);
        List<SysApp> appList = new ArrayList<>();
        for (SysApp sysApp : sysAppList) {
            int permTotal = permissionService.findPermCountByAccoutAndAppId(userAccount, sysApp.getAppId());
            if (permTotal > 0) {
                appList.add(sysApp);
            }
        }
        return apiResponse.success().setResult(appList);
    }
}
