package com.masspick.peak.resource.controller;

import com.masspick.peak.resource.anno.Log;
import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.entity.SysUser;
import com.masspick.peak.resource.service.IUserService;
import com.masspick.peak.resource.utils.HeaderUtil;
import com.masspick.peak.resource.utils.SpringContextHolder;
import com.masspick.peak.resource.vo.AreaListVo;
import com.masspick.peak.resource.vo.UserFindVo;
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
import java.util.List;
import java.util.Map;

/**
 * 部门管理
 */
@RestController
@RequestMapping("/v1/resource")
public class UserController {

    /**
     * userService
     */
    @Autowired
    private IUserService userService;

    /**
     * httpServletRequest
     */
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * 获取所有用户
     *
     * @param userFindVo    userFindVo
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @GetMapping("/user")
    public ApiResponse findAllUser(@Valid UserFindVo userFindVo, BindingResult bindingResult) {
        return userService.findAllUser(userFindVo, bindingResult);
    }

    /**
     * 添加用户
     *
     * @param sysUser       sysUser
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @Log("添加用户")
    @PostMapping("/user")
    public ApiResponse addUser(@Valid @RequestBody SysUser sysUser, BindingResult bindingResult) {
        return userService.addUser(sysUser, bindingResult);
    }

    /**
     * 禁用或者启用用户
     *
     * @param id      id
     * @param sysUser sysUser
     * @return ApiResponse
     */
    @Log("更新用户")
    @PatchMapping("/user/{id}")
    public ApiResponse modifyUserStatus(@PathVariable("id") String id, @RequestBody SysUser sysUser) {
        return userService.modifyUserStatus(id, sysUser.getStatus());
    }

    /**
     * 查看员工
     *
     * @param id id
     * @return ApiResponse
     */
    @GetMapping("/user/{id}")
    public ApiResponse findOneUser(@PathVariable("id") String id) {
        return userService.findOneUser(id);
    }

    /**
     * 修改员工
     *
     * @param id            id
     * @param formUser      formUser
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @Log("修改用户")
    @PutMapping("/user/{id}")
    public ApiResponse modifyUser(@PathVariable("id") String id, @Valid @RequestBody SysUser formUser, BindingResult
            bindingResult) {
        return userService.modifyUser(id, formUser, bindingResult);
    }


    /**
     * 用户区域权限指派
     *
     * @param userId        userId
     * @param areaListVo    areaListVo
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    @Log("用户区域权限指派")
    @PostMapping("/user/{userId}/area")
    public ApiResponse addUserArea(@PathVariable("userId") String userId, @Valid @RequestBody AreaListVo areaListVo,
                                   BindingResult bindingResult) {
        return userService.addUserArea(userId, areaListVo, bindingResult);
    }


    /**
     * 角色和用户关联列表
     *
     * @param userId userId
     * @return ApiResponse
     */
    @GetMapping("/role/user/{userId}")
    public ApiResponse findRoles(@PathVariable("userId") String userId) {
        return userService.findRolesByUserId(userId);
    }

    /**
     * 用户角色指派
     *
     * @param userId     userId
     * @param roleListVo roleListVo
     * @return ApiResponse
     */
    @Log("用户角色授权")
    @PostMapping("/user/{userId}/role")
    public ApiResponse addUserRole(@PathVariable("userId") String userId, @RequestBody List<String> roleListVo) {
        return userService.addUserRole(userId, roleListVo);
    }


    /**
     * 密码重置
     *
     * @param id id
     * @return ApiResponse
     */
    @Log("用户密码重置")
    @PatchMapping("/user/resetpass/{id}")
    public ApiResponse resetUserPass(@PathVariable("id") String id) {
        return userService.resetUserPass(id);
    }

    /**
     *  修改密码
     * @param account account
     * @return ApiResponse
     */
    @Log("用户修改密码")
    @PatchMapping("/user/pass/{account}")
    public ApiResponse modifyUserPass(@PathVariable("account") String account, @RequestBody Map<String, String> userMap) {
        return userService.modifyUserPass(account, userMap);
    }

    /**
     * @return ApiResponse ApiResponse
     * @throws Exception Exception
     */
    @GetMapping("/user/info")
    public ApiResponse userInfo() throws Exception {
        ApiResponse apiResponse = ApiResponse.getInstances();
        String account = "";
        if (SpringContextHolder.getActiveProfile().equals("dev")) {
            account = "admin";
        } else {
            account = URLDecoder.decode(httpServletRequest.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
        }
        SysUser sysUser = userService.findByAccount(account);
        return apiResponse.success().setResult(sysUser);
    }

}
