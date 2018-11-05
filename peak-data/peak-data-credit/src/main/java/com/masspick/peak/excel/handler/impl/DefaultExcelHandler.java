package com.masspick.peak.excel.handler.impl;


import com.masspick.peak.common.util.BeanUtils;
import com.masspick.peak.common.util.ExcelUtils;
import com.masspick.peak.excel.ErrorLog;
import com.masspick.peak.excel.config.FieldConfig;
import com.masspick.peak.excel.config.FieldConfigUtils;
import com.masspick.peak.excel.handler.ExcelHandler;
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
public class DefaultExcelHandler<T> implements ExcelHandler<T> {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultExcelHandler.class);

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
     * clazz
     */
    private Class<T> clazz;

    /**
     * @param clazz
     * @param rowOffset
     * @param cellOffset
     * @param fields
     */
    public DefaultExcelHandler(Class<T> clazz, Integer rowOffset, Integer cellOffset, FieldConfig... fields) {
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
     * @return <T>
     */
    @Override
    public T handle(Sheet sheet, int startRowNum, int startCellNum, List<ErrorLog> errorLogList) {

        //跳转到指定的输入内容行
        int rowNum = startRowNum + rowOffset;
        int cellNum = startCellNum + cellOffset;

        Row row = sheet.getRow(rowNum);
        if (row != null) {

            try {

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
                return etp;

            } catch (Exception ex) {
                String cellLocation = ExcelUtils.excelColIndexToStr(cellNum + 1) + rowNum;
                LOGGER.error("解析基本信息异常。sheet名称：{}，单元格：{}", sheet.getSheetName(), cellLocation);
                errorLogList.add(new ErrorLog(sheet.getSheetName(), cellLocation, "解析基本信息异常"));
            }
        }
        return null;
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
     * Gets clazz
     *
     * @return value of clazz
     */
    public Class<T> getClazz() {
        return clazz;
    }

    /**
     * @param clazz
     */
    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }
}
