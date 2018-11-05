package com.masspick.peak.excel.config;


import com.masspick.peak.common.util.DateUtils;
import com.masspick.peak.common.util.ExcelUtils;
import org.apache.poi.ss.usermodel.Row;

import java.text.ParseException;

/**
 * Created by Administrator on 2018/6/15.
 */
public class FieldConfigUtils {

    /**
     * @param cellNum
     * @param row
     * @param config
     * @return Object
     * @throws ParseException ParseException
     */
    public static Object getValue(int cellNum, Row row, FieldConfig config) throws ParseException {
        Object value = null;
        String strVal = null;
        switch (config.getType()) {
            case STRING:
                strVal = ExcelUtils.getString(row.getCell(cellNum));
                if (config.getTranslator() != null) {
                    value = config.getTranslator().translate(strVal);
                } else if (strVal == null) {
                    break;
                } else {
                    value = strVal;
                }
                break;
            case DATE:
                strVal = ExcelUtils.getString(row.getCell(cellNum));
                if (config.getTranslator() != null) {
                    value = DateUtils.parseDateByPattern(config.getTranslator().translate(strVal), DateUtils.YEARHOURDAY_FORMAT);
                } else if (strVal == null) {
                    break;
                } else {
                    value = ExcelUtils.getDate(row.getCell(cellNum));
                }
                break;
            case DOUBLE:
                strVal = ExcelUtils.getString(row.getCell(cellNum));
                if (config.getTranslator() != null) {
                    value = Double.valueOf(config.getTranslator().translate(strVal));
                } else if (strVal == null) {
                    break;
                } else {
                    value = ExcelUtils.getDouble(row.getCell(cellNum));
                }
                break;
            case INTEGER:
                strVal = ExcelUtils.getString(row.getCell(cellNum));
                if (config.getTranslator() != null) {
                    value = Integer.valueOf(config.getTranslator().translate(strVal));
                } else if (strVal == null) {
                    break;
                } else {
                    value = ExcelUtils.getInt(row.getCell(cellNum));
                }
                break;
            default:
                break;
        }
        return value;
    }
}
