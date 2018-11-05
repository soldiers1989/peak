package com.masspick.peak.excel.handler.impl;


import com.masspick.peak.common.util.BeanUtils;
import com.masspick.peak.common.util.ExcelUtils;
import com.masspick.peak.excel.ErrorLog;
import com.masspick.peak.excel.config.EtpCreditExcelConfig;
import com.masspick.peak.excel.config.FieldConfig;
import com.masspick.peak.excel.config.FieldConfigUtils;
import com.masspick.peak.excel.config.SelfCreditExcelConfig;
import com.masspick.peak.excel.handler.BatchExcelHandler;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/15.
 *
 * @param <T>
 */
public class DefaultBatchExcelHandler<T> implements BatchExcelHandler<T> {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultBatchExcelHandler.class);

    /**
     * Class<T>
     */
    private Class<T> clazz;

    /**
     * 根据业务可以推断，最大不超过1000行。避免因为特殊原因导致服务器承受巨大的压力
     */
    private static final int MAX_COUNT = 1000;

    /**
     * fieldList
     */
    private List<FieldConfig> fieldList = new ArrayList<>();

    /**
     * rowOffset
     */
    private Integer rowOffset;

    /**
     * cellOffset
     */
    private Integer cellOffset;

    /**
     * @param clazz
     * @param rowOffset
     * @param cellOffset
     * @param fields
     */
    public DefaultBatchExcelHandler(Class<T> clazz, Integer rowOffset, Integer cellOffset, FieldConfig... fields) {
        this.clazz = clazz;
        this.rowOffset = rowOffset;
        this.cellOffset = cellOffset;
        for (FieldConfig fieldConfig : fields) {
            fieldList.add(fieldConfig);
        }
    }

    /**
     * @param sheet
     * @param startRowNum
     * @param startCellNum
     * @param errorLogList
     * @return List<T>
     */
    @Override
    public List<T> handle(Sheet sheet, int startRowNum, int startCellNum, List<ErrorLog> errorLogList) {
        List<T> list = new ArrayList<>();

        //跳转到指定的输入内容行
        int rowNum = startRowNum + rowOffset;
        int cellNum = startCellNum + cellOffset;
        try {
            for (int i = 0; i < MAX_COUNT; i++) {
                Row row = sheet.getRow(rowNum++);
                cellNum = startCellNum + cellOffset;
                if (row != null) {

                    //所有表格必须保证第一个单元格有内容。如果没内容不进行后续解析。
                    // 当前单元格为空，或者改内容属于标题。结束循环
                    String firstValue = ExcelUtils.getString(row.getCell(cellNum));
                    if (firstValue == null || EtpCreditExcelConfig.getTableConfig(sheet.getSheetName(), firstValue.trim()) != null
                            || SelfCreditExcelConfig.getTableConfig(sheet.getSheetName(), firstValue.trim()) != null) {
                        break;
                    }

                    //实例化类
                    T etp = clazz.newInstance();

                    //根据字段类型解析，获取value
                    for (FieldConfig config : fieldList) {
                        Object value = FieldConfigUtils.getValue(cellNum, row, config);
                        cellNum++;
                        //如果最终value为null，不进行反射处理
                        if (value != null) {
                            BeanUtils.setProperty(etp, config.getKey(), value);
                        }
                    }
                    list.add(etp);
                }
            }
        } catch (Exception ex) {
            String cellLocation = ExcelUtils.excelColIndexToStr(cellNum + 1) + rowNum;
            LOGGER.error("解析基本信息异常。sheet名称：{}，单元格：{}", sheet.getSheetName(), cellLocation);
            LOGGER.error("解析基本信息异常", ex);
            errorLogList.add(new ErrorLog(sheet.getSheetName(), cellLocation, "解析基本信息异常"));
        }
        return list;
    }

    /**
     * Gets fieldList
     *
     * @return value of fieldList
     */
    public List<FieldConfig> getFieldList() {
        return fieldList;
    }

    /**
     * @param fieldList
     */
    public void setFieldList(List<FieldConfig> fieldList) {
        this.fieldList = fieldList;
    }

    /**
     * Gets rowOffset
     *
     * @return value of rowOffset
     */
    public Integer getRowOffset() {
        return rowOffset;
    }

    /**
     * @param rowOffset
     */
    public void setRowOffset(Integer rowOffset) {
        this.rowOffset = rowOffset;
    }

    /**
     * Gets cellOffset
     *
     * @return value of cellOffset
     */
    public Integer getCellOffset() {
        return cellOffset;
    }

    /**
     * @param cellOffset
     */
    public void setCellOffset(Integer cellOffset) {
        this.cellOffset = cellOffset;
    }

    /**
     * @param cls
     * @param <T>
     * @return <T>
     */
    private static <T> T createInstance(Class<T> cls) {
        T obj = null;
        try {
            obj = cls.newInstance();
        } catch (Exception e) {
            obj = null;
        }
        return obj;
    }
}
