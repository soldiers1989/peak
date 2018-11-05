package com.masspick.peak.excel.config;


import com.masspick.peak.excel.handler.BatchExcelHandler;
import com.masspick.peak.excel.handler.ExcelHandler;

/**
 * Created by Administrator on 2018/6/14.
 * @param <T>
 */
public class TableConfig<T> {

    /**
     * batchExcelHandler
     */
    private BatchExcelHandler<T> batchExcelHandler;

    /**
     * excelHandler
     */
    private ExcelHandler<T> excelHandler;

    /**
     * batch
     */
    private boolean batch;

    /**
     * 构造函数
     */
    public TableConfig() {
    }

    /**
     * @param batchExcelHandler
     */
    public TableConfig(BatchExcelHandler<T> batchExcelHandler) {
        this.batchExcelHandler = batchExcelHandler;
        this.batch = true;
    }

    /**
     * @param excelHandler
     */
    public TableConfig(ExcelHandler<T> excelHandler) {
        this.excelHandler = excelHandler;
        this.batch = false;
    }

    /**
     * Gets batchExcelHandler
     *
     * @return value of batchExcelHandler
     */
    public BatchExcelHandler<T> getBatchExcelHandler() {
        return batchExcelHandler;
    }

    /**
     * @param batchExcelHandler
     */
    public void setBatchExcelHandler(BatchExcelHandler<T> batchExcelHandler) {
        this.batchExcelHandler = batchExcelHandler;
    }

    /**
     * Gets excelHandler
     *
     * @return value of excelHandler
     */
    public ExcelHandler<T> getExcelHandler() {
        return excelHandler;
    }

    /**
     * @param excelHandler
     */
    public void setExcelHandler(ExcelHandler<T> excelHandler) {
        this.excelHandler = excelHandler;
    }

    /**
     * Gets batch
     *
     * @return value of batch
     */
    public boolean isBatch() {
        return batch;
    }

    /**
     * @param batch
     */
    public void setBatch(boolean batch) {
        this.batch = batch;
    }
}
