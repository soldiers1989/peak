package com.masspick.peak.resource.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.util.StringHelper;
import com.masspick.peak.resource.config.constant.CommonConstant;
import com.masspick.peak.resource.config.constant.UserConstant;
import com.masspick.peak.resource.controller.vo.ApiResponse;
import com.masspick.peak.resource.controller.vo.SysUserVo;
import com.masspick.peak.resource.entity.SysDepartment;
import com.masspick.peak.resource.entity.SysUser;
import com.masspick.peak.resource.entity.SysUserArea;
import com.masspick.peak.resource.entity.SysUserRole;
import com.masspick.peak.resource.mapper.SysDepartmentMapper;
import com.masspick.peak.resource.mapper.SysRoleMapper;
import com.masspick.peak.resource.mapper.SysUserAreaMapper;
import com.masspick.peak.resource.mapper.SysUserMapper;
import com.masspick.peak.resource.mapper.SysUserRoleMapper;
import com.masspick.peak.resource.service.IUserService;
import com.masspick.peak.resource.utils.MD5Util;
import com.masspick.peak.resource.utils.SpecialCharTrans;
import com.masspick.peak.resource.vo.AreaListVo;
import com.masspick.peak.resource.vo.RolesFromUserVo;
import com.masspick.peak.resource.vo.UserFindVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserServiceImpl
 */
@Service
public class UserServiceImpl implements IUserService {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * sysUserMapper
     */
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * sysUserAreaMapper
     */
    @Autowired
    private SysUserAreaMapper sysUserAreaMapper;

    /**
     * sysUserRoleMapper
     */
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * sysRoleMapper
     */
    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * sysDepartmentMapper
     */
    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    @Override
    public ApiResponse findAllUser(UserFindVo userFindVo, BindingResult bindingResult) {
        LOGGER.info("com in findAllUser , requestParams :" + userFindVo.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        userFindVo.setAccount(SpecialCharTrans.transSpecialChar(userFindVo.getAccount()));
        userFindVo.setName(SpecialCharTrans.transSpecialChar(userFindVo.getName()));
        PageHelper.startPage(userFindVo.getPageNum(), userFindVo.getPageSize());
        List<SysUser> sysUserList = sysUserMapper.findList(userFindVo);
        apiResponse.success().setResult(new PageInfo<>(sysUserList));
        LOGGER.info("end in findAllUser");
        return apiResponse;
    }

    @Override
    public ApiResponse addUser(SysUser sysUser, BindingResult bindingResult) {
        LOGGER.info("com in addUser , requestParams :" + sysUser.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();

        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        SysUser dbSysUser = sysUserMapper.findOneByAccount(sysUser.getAccount());
        if (dbSysUser != null) {
            return apiResponse.error("401").setReason("账号已经存在，请重新输入");
        }

        SysDepartment sysDepartment = sysDepartmentMapper.findOne(sysUser.getDepartmentId());
        if (sysDepartment.getStatus() == CommonConstant.DISABLE_STATUS) {
            return apiResponse.error("402").setReason("部门已被禁用，请重新选择");
        }

        sysUser.preInsert();
        sysUser.setPassword(MD5Util.md5Pwd(UserConstant.INITIAL_SECRET));
        LOGGER.info("insert  params : " + sysUser.toString());
        sysUserMapper.insert(sysUser);
        apiResponse.success().setResult(sysUser);
        LOGGER.info("end in addUser");
        return apiResponse;
    }

    @Override
    public ApiResponse modifyUserStatus(String id, Integer status) {
        LOGGER.info("com in modifyUserStatus , requestParams : id = " + id + ", status = " + status);
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (status == null) {
            return apiResponse.error("400").setReason("状态不能为空");
        }
        SysUser sysUser = sysUserMapper.findOneById(id);
        if (sysUser == null) {
            apiResponse.error("401").setReason("用户不存在");
        } else {
            sysUser.setStatus(status);
            sysUser.setUpdateDate(new Date());
            LOGGER.info("update params : " + sysUser.toString());
            sysUserMapper.update(sysUser);
            apiResponse.success().setResult(sysUser);
        }
        LOGGER.info("end in modifyUserStatus");
        return apiResponse;
    }

    @Override
    public ApiResponse findOneUser(String id) {
        LOGGER.info("com in findOneUser , requestParams : id = " + id);
        ApiResponse apiResponse = ApiResponse.getInstances();
        SysUser sysUser = sysUserMapper.findOneById(id);
        SysUserVo sysUserVo = new SysUserVo();
        if (sysUser != null) {
            BeanUtils.copyProperties(sysUser, sysUserVo);
            List<String> roleNameList = sysUserMapper.findRoleListById(id);
            sysUserVo.setRoleNames(roleNameList);
        }
        LOGGER.info("findOneUser result : " + sysUser);
        LOGGER.info("end in modifyAppStatus");
        return apiResponse.success().setResult(sysUserVo);
    }

    @Override
    public ApiResponse modifyUser(String id, SysUser formUser, BindingResult bindingResult) {
        LOGGER.info("com in modifyUser , requestParams : " + formUser.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        SysUser dbsysUser = sysUserMapper.findOneById(id);
        if (dbsysUser == null) {
            return apiResponse.error("401").setReason("用户不存在");
        }

        SysUser dbSysUser = sysUserMapper.findOneByAccount(formUser.getAccount());
        if (dbSysUser != null && !dbSysUser.getId().equals(id)) {
            return apiResponse.error("402").setReason("账号已经存在，请重新输入");
        }

        String departmentId = sysUserMapper.findOneById(id).getDepartmentId();
        SysDepartment sysDepartment = sysDepartmentMapper.findOne(formUser.getDepartmentId());
        if (!formUser.getDepartmentId().equals(departmentId) && sysDepartment.getStatus() == CommonConstant
                .DISABLE_STATUS) {
            return apiResponse.error("403").setReason("所选部门已被禁用，请重新选择");
        }

        if (!formUser.getDepartmentId().equals(departmentId) && sysDepartmentMapper.findUnableParentCount(formUser
                .getDepartmentId()) > 0) {
            return apiResponse.error("401").setReason("所选部门的上级部门已被禁用，请重新选择");
        }

        formUser.setId(id);
        formUser.setUpdateDate(new Date());
        sysUserMapper.update(formUser);
        LOGGER.info("end in modifyUser");
        return apiResponse.success().setResult(sysUserMapper.findOneById(formUser.getId()));
    }

    @Transactional
    @Override
    public ApiResponse addUserArea(String userId, AreaListVo areaListVo, BindingResult bindingResult) {
        LOGGER.info("com in addUserArea ,requestParams : userId =" + userId + "areaListVo = " + areaListVo.toString());
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        //删除老数据
        int deleteRow = sysUserAreaMapper.deleteByUserId(userId);
        List<String> areaIdList = areaListVo.getAreaId();
        List<SysUserArea> sysUserAreas = new ArrayList<>();

        if (deleteRow <= 0 && areaIdList.size() == 0) {
            return apiResponse.error("404").setReason("请选择数据权限");
        }
        Integer count = 0;

        for (String areaId : areaIdList) {
            SysUserArea sysUserArea = new SysUserArea();
            sysUserArea.setUserId(userId);
            sysUserArea.setAreaId(areaId);
            sysUserAreas.add(sysUserArea);
            count++;
        }
        if (!CollectionUtils.isEmpty(sysUserAreas)) {
            sysUserAreaMapper.insertList(sysUserAreas);
        }
        apiResponse.success().setResult(count);
        SysUser sysUser = sysUserMapper.findOneById(userId);
        sysUser.setUpdateDate(new Date());
        sysUserMapper.update(sysUser);
        return apiResponse;
    }

    @Override
    public ApiResponse resetUserPass(String id) {
        LOGGER.info("com in resetUserPass , requestParams : id = " + id);
        ApiResponse apiResponse = ApiResponse.getInstances();
        SysUser sysUser = sysUserMapper.findOneById(id);
        if (sysUser == null) {
            LOGGER.info("user is not exist ");
            apiResponse.error("401").setReason("用户不存在");
        } else {
            sysUser.setPassword(MD5Util.md5Pwd(UserConstant.INITIAL_SECRET));
            sysUser.setUpdateDate(new Date());
            LOGGER.info("update params : " + sysUser.toString());
            sysUserMapper.update(sysUser);
            apiResponse.success().setResult(sysUser);
        }
        LOGGER.info("end in resetUserPass");
        return apiResponse;
    }

    @Override
    public ApiResponse findRolesByUserId(String userId) {
        LOGGER.info("come in findRolesByUserId, request params, userId = " + userId);
        ApiResponse apiResponse = ApiResponse.getInstances();
        List<RolesFromUserVo> rolesFromUserVos = sysRoleMapper.findRolesByUserId(userId);
        LOGGER.info("findRolesByUserId , result = " + rolesFromUserVos.toString());
        apiResponse.success().setResult(rolesFromUserVos);
        return apiResponse;
    }

    @Override
    public ApiResponse addUserRole(String userId, List<String> roleList) {
        LOGGER.info("com in addUserRole , requestParams : userId = " + userId);
        ApiResponse apiResponse = ApiResponse.getInstances();
        //删除老数据
        sysUserRoleMapper.deleteByUserId(userId);
        List<SysUserRole> sysUserRoles = new ArrayList<>();
        Integer count = 0;
        for (String roleId : roleList) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(roleId);
            sysUserRole.setUserId(userId);
            sysUserRoles.add(sysUserRole);
            count++;
        }
        if (!CollectionUtils.isEmpty(sysUserRoles)) {
            sysUserRoleMapper.insertList(sysUserRoles);
        }

        SysUser sysUser = sysUserMapper.findOneById(userId);
        sysUser.setUpdateDate(new Date());
        sysUserMapper.update(sysUser);
        apiResponse.success().setResult(count);
        LOGGER.info("update result : " + count);
        LOGGER.info("end in addUserRole");
        return apiResponse;
    }

    @Override
    public SysUser findByAccount(String account) {
        return sysUserMapper.findOneByAccount(account);
    }

    @Override
    public SysUser findByAccountAndPassword(String account, String password) {
        return sysUserMapper.findByAccountAndPassword(account, password);
    }

    /**
     * @param roleName
     * @param areaName
     * @return List
     */
    @Override
    public List<SysUser> findUserByRoleAndAreaName(String roleName, String areaName) {
        Map<String, String> map = new HashMap<>();
        map.put("roleName", roleName);
        map.put("areaName", areaName);
        return sysUserMapper.findUserByRoleAndAreaName(map);
    }

    /**
     *  修改用户密码
     * @param account 账号
     * @param userMap 数据
     * @return ApiResponse
     */
    @Override
    public ApiResponse modifyUserPass(String account, Map<String, String> userMap) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        SysUser sysUser = sysUserMapper.findOneByAccount(account);
        if (sysUser == null) {
            return apiResponse.error("401").setReason("该用户不存在");
        }
        if (userMap == null || StringHelper.isEmpty(userMap.get("oldPassword"))) {
            return apiResponse.error("402").setReason("原始密码不能为空！");
        }
        if (StringHelper.isEmpty(userMap.get("newPassword"))) {
            return apiResponse.error("403").setReason("新密码不能为空！");
        }

        if (!sysUser.getPassword().equals(MD5Util.md5Pwd(String.valueOf(userMap.get("oldPassword"))))) {
            return apiResponse.error("404").setReason("原始密码错误！");
        }
        String passWord = MD5Util.md5Pwd(String.valueOf(userMap.get("newPassword")));
        SysUser user = new SysUser();
        user.setId(sysUser.getId());
        sysUser.setPassword(passWord);
        sysUser.setUpdateDate(new Date());
        sysUserMapper.update(sysUser);
        return apiResponse.success().setResult(sysUserMapper.findOneByAccount(account));
    }
}
