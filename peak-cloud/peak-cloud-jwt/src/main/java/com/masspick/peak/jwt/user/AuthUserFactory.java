package com.masspick.peak.jwt.user;


import com.masspick.peak.resource.model.SysUser;

/**
 * The type Auth user factory.
 *
 * @author huqilang
 */
public final class AuthUserFactory {

    private AuthUserFactory() {
    }

    /**
     * Create auth user.
     *
     * @param user the user
     * @return the auth user
     */
    public static AuthUser create(SysUser user) {
        AuthUser authUser = new AuthUser(user.getId());
        authUser.setLoginName(user.getUserName());
        authUser.setName(user.getUserName());
        authUser.setEmail(user.getEmail());
        authUser.setPhone(user.getPhone());
        authUser.setPassword(user.getPassword());
        authUser.setEnabled(true);
        return authUser;
    }
}
