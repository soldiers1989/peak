package com.masspick.peak.excel;

import java.util.List;

/**
 * Created by Administrator on 2018/6/16.
 *
 * @param <T>
 */
public class ExcelImportResult<T> {
    /**
     * data
     */
    private T data;

    /**
     * errorLogList
     */
    private List<ErrorLog> errorLogList;


    /**
     * @param data
     * @param errorLogList
     */
    public ExcelImportResult(T data, List<ErrorLog> errorLogList) {
        this.data = data;
        this.errorLogList = errorLogList;
    }

    /**
     * Gets data
     *
     * @return value of data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Gets errorLogList
     *
     * @return value of errorLogList
     */
    public List<ErrorLog> getErrorLogList() {
        return errorLogList;
    }

    /**
     * @param errorLogList
     */
    public void setErrorLogList(List<ErrorLog> errorLogList) {
        this.errorLogList = errorLogList;
    }
}
