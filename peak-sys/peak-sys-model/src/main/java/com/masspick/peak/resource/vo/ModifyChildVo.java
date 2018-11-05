package com.masspick.peak.resource.vo;

/**
 * Created by Administrator on 2018\8\1 0001.
 */
public class ModifyChildVo {

    /**
     * 查找子级的父级id
     */
    private String id;


    /**
     *  旧排序编码
     */
    private String oldCode;

    /**
     *  新排序编码
     */
    private String newCode;


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
     * Gets oldCode
     *
     * @return value of oldCode
     */
    public String getOldCode() {
        return oldCode;
    }

    /**
     * @param oldCode oldCode
     */
    public void setOldCode(String oldCode) {
        this.oldCode = oldCode;
    }

    /**
     * Gets newCode
     *
     * @return value of newCode
     */
    public String getNewCode() {
        return newCode;
    }

    /**
     * @param newCode newCode
     */
    public void setNewCode(String newCode) {
        this.newCode = newCode;
    }

    @Override
    public String toString() {
        return "ModifyDepartVo{"
                + "id='" + id + '\''
                + ", oldCode='" + oldCode + '\''
                + ", newCode='" + newCode + '\''
                + '}';
    }
}
