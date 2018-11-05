package com.masspick.peak.resource.vo;


import javax.validation.constraints.NotEmpty;

/**
 *  权限分页查询对象
 */
public class PermissionFindListVo {

    /**
     *  id
     */
    private String id;

    /**
     *  应用id
     */
    @NotEmpty(message = "应用id不能为空")
    private String appId;

    /**
     * Gets id
     *
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets appId
     *
     * @return value of appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "PermissionFindListVo{"
                + "id='" + id + '\''
                + ", appId='" + appId + '\''
                + '}';
    }
}
