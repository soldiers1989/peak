package com.masspick.peak.jwt.service;


import com.masspick.peak.resource.model.SysUser;

/**
 * Created by admin on 2018/6/8 0008.
 */
public interface IUserService {

    /**
     * @param userName
     * @return SysUser
     */
    SysUser findByUserName(String userName);
}
