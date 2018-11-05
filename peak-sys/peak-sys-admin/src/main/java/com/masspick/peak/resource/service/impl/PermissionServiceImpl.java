package com.masspick.peak.resource.service.impl;


import com.masspick.peak.resource.config.constant.CommonConstant;
import com.masspick.peak.resource.config.constant.TreeConstant;
import com.masspick.peak.resource.entity.SysPermission;
import com.masspick.peak.resource.entity.bo.PermissionNode;
import com.masspick.peak.resource.entity.bo.SysPermissionBO;
import com.masspick.peak.resource.mapper.SysPermissionMapper;
import com.masspick.peak.resource.service.IPermissionService;
import com.masspick.peak.resource.utils.RmDisablePerm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * PermissionServiceImpl
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionServiceImpl.class);

    /**
     * sysPermissionMapper
     */
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    /**
     * @param sysPermission sysPermission
     * @return SysPermission
     */
    @Override
    public SysPermission addPermission(SysPermission sysPermission) {
        sysPermission.preInsert();
        sysPermissionMapper.insert(sysPermission);
        return sysPermission;
    }


    /**
     * @param code code
     * @return Integer
     */
    public Integer getDeep(String code) {
        return (code.length() / TreeConstant.CHILD_CODE_LENGTH);
    }

    /**
     * @param parentCode parentCode
     * @param sort       sort
     * @return String
     */
    public String getCode(String parentCode, Integer sort) {
        return parentCode + String.format(TreeConstant.SUB_FORMAT_PATTERN, sort);
    }

    @Override
    public Boolean checkCode(SysPermission sysPermission, String parentCode) {
        String code = getCode(parentCode, sysPermission.getSort());
        SysPermission permission = sysPermissionMapper.findByCodeAndAppId(code, sysPermission.getAppId());
        if (permission != null && !permission.getId().equals(sysPermission.getId())) {
            return false;
        } else {
            sysPermission.setCode(code);
            sysPermission.setDeep(getDeep(sysPermission.getCode()));
        }
        return true;
    }


    @Override
    public List<SysPermission> findPermissionList(String appId) {
        return sysPermissionMapper.findListByAppId(appId);
    }

    @Override
    public List<SysPermission> findAblePermissionList(String appId) {
        List<SysPermission> sysPermissionList = sysPermissionMapper.findListByAppId(appId);
        List<SysPermission> handList = new RmDisablePerm().handPermissionList(sysPermissionList, CommonConstant
                .ABLE_STATUS);
        return handList;
    }

    @Override
    public List<SysPermission> findAllPermExceptSelf(String appId, String id) {
        return sysPermissionMapper.editPermission(appId, id);
    }

    @Override
    public SysPermission modifyPermissionStatus(SysPermission sysPermission) {
        sysPermissionMapper.updateStatus(sysPermission);
        sysPermission = sysPermissionMapper.findOne(sysPermission.getId());
        return sysPermission;
    }

    @Override
    public SysPermission findOne(String id) {
        return sysPermissionMapper.findOne(id);
    }

    @Override
    @Transactional
    public SysPermission modifyPermission(SysPermission sysPermission) {
        SysPermission permission = sysPermissionMapper.findOne(sysPermission.getId());
        //修改子集以及以下所有的数据
        sysPermissionMapper.updateChildrenPermission(sysPermission.getCode(), permission.getDeep(), sysPermission
                .getId(), sysPermission.getAppId());
        SysPermission dbPermission = sysPermissionMapper.findOne(sysPermission.getId());
        sysPermission.setCode(dbPermission.getCode());
        sysPermission.setDeep(dbPermission.getDeep());
        sysPermission.setUpdateDate(new Date());
        sysPermissionMapper.update(sysPermission);
        return sysPermission;
    }

    /**
     * 获取资源
     *
     * @param userId 账号
     * @param appId  应用id
     * @return List<SysPermissionBO>
     */
    @Override
    public List<SysPermissionBO> findByAccountAndAppId(String userId, String appId) {
        return sysPermissionMapper.findByAccountNameAndAppId(userId, appId);
    }


    /**
     * 获取权限树
     *
     * @param roleId 角色id
     * @param appId  应用id
     * @return
     */
    @Override
    public List<PermissionNode> findByPermissionByAppIdAndRoleId(String roleId, String appId) {
        return sysPermissionMapper.findByRoleIdAndAppId(roleId, appId);
    }

    /**
     *  获取禁用父类总数
     * @param id id
     * @return int
     */
    @Override
    public int findUnableParentCount(String id) {
        return sysPermissionMapper.findUnableParentCount(id);
    }

    /**
     *  获取权限总数
     * @param account 账号
     * @param appId appid
     * @return int
     */
    @Override
    public int findPermCountByAccoutAndAppId(String account, String appId) {
        return sysPermissionMapper.findPermCountByAccoutAndAppId(account, appId);
    }
}
