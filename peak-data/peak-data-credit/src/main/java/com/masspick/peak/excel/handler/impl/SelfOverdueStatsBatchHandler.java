package com.masspick.peak.excel.handler.impl;


import com.masspick.peak.common.util.ExcelUtils;
import com.masspick.peak.excel.ErrorLog;
import com.masspick.peak.excel.handler.BatchExcelHandler;
import com.masspick.peak.model.credit.self.SelfOverdueStats;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/15.
 */
public class SelfOverdueStatsBatchHandler implements BatchExcelHandler<SelfOverdueStats> {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SelfOverdueStatsBatchHandler.class);

    @Override
    public List<SelfOverdueStats> handle(Sheet sheet, int startRowNum, int startCellNum, List<ErrorLog> errorLogList) {
        List<SelfOverdueStats> list = new ArrayList<>();

        //跳转到指定的输入内容行
        int rowNum = startRowNum + 3;
        int cellNum = startCellNum;

        try {
            //获取类型所在的row
            Row row = sheet.getRow(rowNum);
            SelfOverdueStats self = new SelfOverdueStats();
            self.setCount(ExcelUtils.getInt(row.getCell(cellNum++)));
            self.setMonthCount(ExcelUtils.getInt(row.getCell(cellNum++)));
            self.setMonthMaxFee(ExcelUtils.getDouble(row.getCell(cellNum++)));
            self.setMaxOverdueMonth(ExcelUtils.getInt(row.getCell(cellNum++)));
            self.setType(1);
            list.add(self);

            self = new SelfOverdueStats();
            self.setCount(ExcelUtils.getInt(row.getCell(cellNum++)));
            self.setMonthCount(ExcelUtils.getInt(row.getCell(cellNum++)));
            self.setMonthMaxFee(ExcelUtils.getDouble(row.getCell(cellNum++)));
            self.setMaxOverdueMonth(ExcelUtils.getInt(row.getCell(cellNum++)));
            self.setType(2);
            list.add(self);

            self = new SelfOverdueStats();
            self.setCount(ExcelUtils.getInt(row.getCell(cellNum++)));
            self.setMonthCount(ExcelUtils.getInt(row.getCell(cellNum++)));
            self.setMonthMaxFee(ExcelUtils.getDouble(row.getCell(cellNum++)));
            self.setMaxOverdueMonth(ExcelUtils.getInt(row.getCell(cellNum++)));
            self.setType(3);
            list.add(self);

        } catch (Exception ex) {
            String cellLocation = ExcelUtils.excelColIndexToStr(cellNum + 1) + rowNum;
            LOGGER.error("解析基本信息异常。sheet名称：{}，单元格：{}", sheet.getSheetName(), cellLocation);
            errorLogList.add(new ErrorLog(sheet.getSheetName(), cellLocation, "解析基本信息异常"));
        }
        return list;
    }
}
