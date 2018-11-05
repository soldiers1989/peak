package com.masspick.peak.model;

import com.masspick.peak.model.Todo;

/**
 * Todo扩展类
 */
public class TodoAdd extends Todo {

    /**
     * insName
     */
    private String insName;
    /**
     * insStaffName
     */
    private String insStaffName;
    /**
     * address
     */
    private  String address;
    /**
     * Gets address
     *
     * @return value of address
     */
    public String getAddress() {
        return address;
    }
    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets InsName
     *
     * @return value of InsName
     */
    public String getInsName() {
        return insName;
    }
    /**
     * @param insName
     */
    public void setInsName(String insName) {
        this.insName = insName;
    }

    /**
     * Gets InsStaffName
     *
     * @return value of InsStaffName
     */
    public String getInsStaffName() {
        return insStaffName;
    }

    /**
     * @param insStaffName
     */
    public void setInsStaffName(String insStaffName) {
        this.insStaffName = insStaffName;
    }
}
