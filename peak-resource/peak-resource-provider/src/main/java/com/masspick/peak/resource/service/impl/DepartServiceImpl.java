package com.masspick.peak.resource.service.impl;

import com.masspick.peak.resource.mapper.SysDepartmentMapper;
import com.masspick.peak.resource.mapper.SysUserMapper;
import com.masspick.peak.resource.model.SysDepartment;
import com.masspick.peak.resource.model.SysUser;
import com.masspick.peak.resource.service.DepartService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DepartServiceImpl
 */
@Service
public class DepartServiceImpl implements DepartService {

    /**
     * sysDepartmentMapper
     */
    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    /**
     * sysUserMapper
     */
    @Autowired
    private SysUserMapper sysUserMapper;


    /**
     * @param userId
     * @return SysDepartment
     */
    @Override
    public SysDepartment findByUserId(String userId) {
        SysUser user = sysUserMapper.findById(userId);
        String departId = user.getDepartmentId();
        if (StringUtils.isNotEmpty(departId)) {
            SysDepartment department = sysDepartmentMapper.findById(departId);
            return department;
        }
        return null;
    }

    /**
     * @param userName
     * @return SysDepartment
     */
    @Override
    public SysDepartment findByUserName(String userName) {
        SysUser user = sysUserMapper.findByUserName(userName);
        String departId = user.getDepartmentId();
        if (StringUtils.isNotEmpty(departId)) {
            SysDepartment department = sysDepartmentMapper.findById(departId);
            return department;
        }
        return null;
    }
}
