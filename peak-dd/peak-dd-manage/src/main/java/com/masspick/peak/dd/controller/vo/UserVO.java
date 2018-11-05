package com.masspick.peak.dd.controller.vo;

import java.util.Map;

/**
 * Created by admin on 2018/6/5 0005.
 */
public class UserVO {

    /**
     * id
     */
    private String id;

    /**
     * userName
     */
    private String userName;

    /**
     * @param userVO
     * @param map
     */
    public void transfer(UserVO userVO, Map<String, Object> map) {
        userVO.setId((String) map.get("id"));
        userVO.setUserName((String) map.get("account"));
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
     * Gets userName
     *
     * @return value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
