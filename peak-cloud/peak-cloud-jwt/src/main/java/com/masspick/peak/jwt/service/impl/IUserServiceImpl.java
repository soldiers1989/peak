package com.masspick.peak.jwt.service.impl;

import com.masspick.peak.jwt.service.IUserService;
import com.masspick.peak.resource.mapper.SysUserMapper;
import com.masspick.peak.resource.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/6/8 0008.
 */
@Service
public class IUserServiceImpl implements IUserService {

    /**
     * SysUserMapper
     */
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * @param userName
     * @return SysUser
     */
    @Override
    public SysUser findByUserName(String userName) {
        return sysUserMapper.findByUserName(userName);
    }
}
