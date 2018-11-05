package com.masspick.peak.resource.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.resource.anno.Log;
import com.masspick.peak.resource.config.constant.CommonConstant;
import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.entity.SysRole;
import com.masspick.peak.resource.entity.bo.PermissionNode;
import com.masspick.peak.resource.service.IPermissionService;
import com.masspick.peak.resource.service.IRoleService;
import com.masspick.peak.resource.vo.PermissionListVo;
import com.masspick.peak.resource.vo.RoleFindListVo;
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

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 角色管理
 */
@RestController
@RequestMapping("/v1/resource")
public class RoleController {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    /**
     * roleService
     */
    @Autowired
    private IRoleService roleService;

    /**
     * iPermissionService
     */
    @Autowired
    private IPermissionService iPermissionService;

    /**
     * 角色分页查询
     *
     * @param roleFindListVo roleFindListVo
     * @param bindingResult  bindingResult
     * @return ApiResponse
     */
    @GetMapping("/rolesGrid")
    ApiResponse findRoleList(@Valid RoleFindListVo roleFindListVo, BindingResult bindingResult) {
        LOGGER.info("come in  findRoleList, requestParams = " + roleFindListVo.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        PageHelper.startPage(roleFindListVo.getPageNum(), roleFindListVo.getPageSize());
        List<SysRole> sysRoleList = roleService.findRoleList(roleFindListVo);
        LOGGER.info("result roleList :" + sysRoleList.toString());
        apiResponse.success().setResult(new PageInfo<>(sysRoleList));
        LOGGER.info("end in findRoleList");
        return apiResponse;
    }

    /**
     * @return ApiResponse
     */
    @GetMapping("/roles")
    ApiResponse findAllRole() {
        LOGGER.info("come in  findAllRole");
        ApiResponse apiResponse = ApiResponse.getInstances();
        List<SysRole> sysRoleList = roleService.findAllRole(CommonConstant.ABLE_STATUS);
        LOGGER.info("result sysRoleList :" + sysRoleList.toString());
        apiResponse.success().setResult(sysRoleList);
        LOGGER.info("end in findAllRole");
        return apiResponse;
    }

    /**
     * 角色添加
     *
     * @param sysRole       sysRole
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @Log("角色添加")
    @PostMapping("/role")
    ApiResponse addRole(@Valid @RequestBody SysRole sysRole, BindingResult bindingResult) {
        LOGGER.info("come in addRole, request Params : " + sysRole.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            LOGGER.error("params not null error , detail : " + bindingResult.toString());
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        if (!roleService.checkRoleName(sysRole)) {
            LOGGER.error("name exist already");
            return apiResponse.error("401").setReason("角色名称已存在，请重新输入");
        }
        sysRole.preInsert();
        roleService.addRole(sysRole);
        LOGGER.info("end in addRole");
        return apiResponse.success().setResult(sysRole);
    }

    /**
     * 禁用或启用状态
     *
     * @param id     id
     * @param params params
     * @return ApiResponse
     */
    @Log("禁用或启用角色状态")
    @PatchMapping("/role/{id}")
    ApiResponse modifyRoleStatus(@PathVariable("id") String id, @RequestBody Map<String, Integer> params) {
        LOGGER.info("come in modifyRoleStatus, requestParams : id = " + id + ", params" + params.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (params == null || params.get("status") == null) {
            return apiResponse.error("400").setReason("应用状态不能为空");
        }
        SysRole sysRole = roleService.modifyRoleStatus(id, params.get("status"));
        LOGGER.info("modifyRoleStatus result : sysRole =" + sysRole.toString());
        apiResponse.success().setResult(sysRole);
        LOGGER.info("end in modifyRoleStatus");
        return apiResponse;
    }

    /**
     * 查找单个角色
     *
     * @param id id
     * @return ApiResponse
     */
    @GetMapping("/role/{id}")
    ApiResponse findOneRole(@PathVariable("id") String id) {
        LOGGER.info("come in findOneRole");
        ApiResponse apiResponse = ApiResponse.getInstances();
        apiResponse.success().setResult(roleService.findOneRole(id));
        LOGGER.info("end in findOneRole");
        return apiResponse;
    }

    /**
     * 角色修改
     *
     * @param id            id
     * @param sysRole       sysRole
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @Log("修改角色")
    @PutMapping("/role/{id}")
    ApiResponse modifyRole(@PathVariable("id") String id, @Valid @RequestBody SysRole sysRole, BindingResult
            bindingResult) {
        LOGGER.info("come in modifyRole");
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        sysRole.setId(id);

        if (!roleService.checkRoleName(sysRole)) {
            return apiResponse.error("401").setReason("角色名称已存在，请重新输入");
        }
        sysRole = roleService.modifyRole(sysRole);
        apiResponse.success().setResult(sysRole);
        return apiResponse;
    }


    /**
     * 获取权限树
     *
     * @param roleId roleId
     * @param appId  appId
     * @return ApiResponse
     */
    /*@GetMapping("/role/{roleId}/{appId}/permission")
    public ApiResponse rolePermission(@PathVariable("roleId") String roleId, @PathVariable("appId") String appId) {
        LOGGER.info("---->rolePermission params roleId={}, appId={}<----", roleId, appId);
        ApiResponse apiResponse = ApiResponse.getInstances();
        List<PermissionNode> permissionNodes = iPermissionService.findByPermissionByAppIdAndRoleId(roleId, appId);
        PermissionNodeTreeVO permissionNodeTreeVO = new PermissionNodeTreeVO();
        permissionNodeTreeVO.setPermissionNodeList(permissionNodes);
        List<PermissionNode> permissionNodes1 = permissionNodeTreeVO.permissionNodes(appId);
        return apiResponse.success().setResult(permissionNodes1);
    }*/

    /**
     * 获取权限树
     *
     * @param roleId roleId
     * @param appId  appId
     * @return ApiResponse
     */
    @GetMapping("/role/{roleId}/{appId}/permission")
    public ApiResponse rolePermission(@PathVariable("roleId") String roleId, @PathVariable("appId") String appId) {
        LOGGER.info("---->rolePermission params roleId={}, appId={}<----", roleId, appId);
        ApiResponse apiResponse = ApiResponse.getInstances();
        List<PermissionNode> permissionNodes = iPermissionService.findByPermissionByAppIdAndRoleId(roleId, appId);
        return apiResponse.success().setResult(permissionNodes);
    }

    /**
     * 角色授权
     *
     * @param roleId           roleId
     * @param appId            appId
     * @param permissionListVo permissionListVo
     * @param bindingResult    bindingResult
     * @return ApiResponse
     */
    @Log("角色权限授权")
    @PostMapping("/role/{roleId}/{appId}/permission")
    ApiResponse addRolePermission(@PathVariable("roleId") String roleId, @PathVariable("appId") String appId, @Valid
    @RequestBody PermissionListVo
            permissionListVo, BindingResult
                                          bindingResult) {
        LOGGER.info("come in addRolePermission, requestParam = roleId " + roleId + " PermissionListVo = "
                + permissionListVo.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        StringBuffer message = new StringBuffer();
        Integer addCount = roleService.addRolePermission(roleId, appId, permissionListVo, message);
        if (!StringUtils.isEmpty(message)) {
            return apiResponse.error("400").setReason(message.toString());
        }
        LOGGER.info("end in addRolePermission ");
        return apiResponse.success().setResult(addCount);
    }
}
