package com.masspick.peak.resource.entity;

/**
 *  员工区域关联对象
 */
public class SysUserArea {

    /**
     *   主键id
     */
    private String id;

    /**
     *  员工id
     */
    private String userId;

    /**
     * 区域id
     */
    private String areaId;


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
     * Gets userId
     *
     * @return value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets areaId
     *
     * @return value of areaId
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * @param areaId areaId
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
}
