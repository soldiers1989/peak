package com.masspick.peak.excel;

/**
 * Created by Administrator on 2018/6/14.
 */
public class ErrorLog {

    /**
     * sheetName
     */
    private String sheetName;

    /**
     * location
     */
    private String location;

    /**
     * errorMsg
     */
    private String errorMsg;

    /**
     * 构造函数
     */
    public ErrorLog() {
    }

    /**
     * @param sheetName
     * @param location
     * @param errorMsg
     */
    public ErrorLog(String sheetName, String location, String errorMsg) {
        this.sheetName = sheetName;
        this.location = location;
        this.errorMsg = errorMsg;
    }


    /**
     * Gets sheetName
     *
     * @return value of sheetName
     */
    public String getSheetName() {
        return sheetName;
    }

    /**
     * @param sheetName
     */
    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    /**
     * Gets location
     *
     * @return value of location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets errorMsg
     *
     * @return value of errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @param errorMsg
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
