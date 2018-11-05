/*
package com.masspick.peak.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

*/
/**
 * User
 *//*

public class User implements UserDetails {

    */
/**
     * 登录名
     *//*

    private String loginName;

    */
/**
     * password
     *//*

    private String password;


    */
/**
     * @return String
     *//*

    public String getLoginName() {
        return loginName;
    }

    */
/**
     * @param loginName
     *//*

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    */
/**
     * @param password
     *//*

    public void setPassword(String password) {
        this.password = password;
    }

    */
/**
     * @return Collection
     *//*

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    */
/**
     * @return String
     *//*

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    */
/**
     * @return String
     *//*

    @Override
    public String getUsername() {
        return loginName;
    }

    */
/**
     * @return boolean
     *//*

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    */
/**
     * @return boolean
     *//*

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    */
/**
     * @return boolean
     *//*

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    */
/**
     * @return boolean
     *//*

    @Override
    public boolean isEnabled() {
        return false;
    }
}
*/
