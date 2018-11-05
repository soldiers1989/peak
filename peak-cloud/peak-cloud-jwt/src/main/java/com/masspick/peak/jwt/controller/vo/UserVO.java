package com.masspick.peak.jwt.controller.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by admin on 2018/5/25 0025.
 */
public class UserVO {

    /**
     * id
     */
    private String id;

    /**
     * name
     */
    private String name;

    /**
     * phone
     */
    private String phone;

    /**
     * loginName
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String loginName;

    /**
     * password
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    /**
     * rememberMe
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean rememberMe;

    /**
     * Gets loginName
     *
     * @return value of loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * Gets password
     *
     * @return value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets rememberMe
     *
     * @return value of rememberMe
     */
    public Boolean getRememberMe() {
        return rememberMe;
    }

    /**
     * @param rememberMe
     */
    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }


    /**
     * Gets id
     *
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets name
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets phone
     *
     * @return value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
