package com.masspick.peak.resource.service;


import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.entity.SysUser;
import com.masspick.peak.resource.vo.AreaListVo;
import com.masspick.peak.resource.vo.UserFindVo;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

/**
 * IUserService
 */
public interface IUserService {

    /**
     * @param userFindVo    userFindVo
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    ApiResponse findAllUser(UserFindVo userFindVo, BindingResult bindingResult);

    /**
     * @param sysUser       sysUser
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    ApiResponse addUser(SysUser sysUser, BindingResult bindingResult);

    /**
     * @param id     id
     * @param status status
     * @return ApiResponse
     */
    ApiResponse modifyUserStatus(String id, Integer status);

    /**
     * @param id id
     * @return ApiResponse
     */
    ApiResponse findOneUser(String id);

    /**
     * @param id            id
     * @param formUser      formUser
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    ApiResponse modifyUser(String id, SysUser formUser, BindingResult bindingResult);

    /**
     * @param userId        userId
     * @param areaListVo    areaListVo
     * @param bindingResult bindingResult
     * @return ApiResponse
     */
    ApiResponse addUserArea(String userId, AreaListVo areaListVo, BindingResult bindingResult);

    /**
     * @param id id
     * @return ApiResponse
     */
    ApiResponse resetUserPass(String id);

    /**
     * @param userId userId
     * @return ApiResponse
     */
    ApiResponse findRolesByUserId(String userId);

    /**
     * @param userId   userId
     * @param roleList roleList
     * @return ApiResponse
     */
    ApiResponse addUserRole(String userId, List<String> roleList);

    /**
     * @param account account
     * @return SysUser
     */
    SysUser findByAccount(String account);

    /**
     * @param account
     * @param password
     * @return SysUser
     */
    SysUser findByAccountAndPassword(String account, String password);

    /**
     * @param roleName
     * @param areaName
     * @return List
     */
    List<SysUser> findUserByRoleAndAreaName(String roleName, String areaName);

    /**
     *  用户密码修改
     * @param account account
     * @param userMap 数据
     * @return ApiResponse
     */
    ApiResponse modifyUserPass(String account, Map<String, String> userMap);
}
