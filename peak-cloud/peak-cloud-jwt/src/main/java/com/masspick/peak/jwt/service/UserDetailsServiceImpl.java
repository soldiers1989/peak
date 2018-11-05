package com.masspick.peak.jwt.service;

import com.masspick.peak.jwt.user.AuthUserFactory;
import com.masspick.peak.resource.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/6/8 0008.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * iUserService
     */
    @Autowired
    private IUserService iUserService;

    /**
     * sysUser
     */
    private SysUser sysUser = new SysUser();

    /**
     * @param userName
     * @return UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String userName) {

        SysUser user = iUserService.findByUserName(userName);
        if (user == null) {
            throw new InternalAuthenticationServiceException(String.format("No user found with username '%s'.", userName));
        } else {
            sysUser = user;
            return AuthUserFactory.create(user);
        }
    }

    /**
     * Gets iUserService
     *
     * @return value of iUserService
     */
    public IUserService getiUserService() {
        return iUserService;
    }

    /**
     * @param iUserService
     */
    public void setiUserService(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    /**
     * Gets sysUser
     *
     * @return value of sysUser
     */
    public SysUser getSysUser() {
        return sysUser;
    }

    /**
     * @param sysUser
     */
    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }
}
