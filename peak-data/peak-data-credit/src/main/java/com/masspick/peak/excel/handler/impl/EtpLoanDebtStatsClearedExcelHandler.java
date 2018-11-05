package com.masspick.peak.excel.handler.impl;


import com.masspick.peak.common.util.ExcelUtils;
import com.masspick.peak.excel.ErrorLog;
import com.masspick.peak.excel.handler.BatchExcelHandler;
import com.masspick.peak.model.credit.etp.EtpLoanDebtStats;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */
public class EtpLoanDebtStatsClearedExcelHandler implements BatchExcelHandler<EtpLoanDebtStats> {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EtpLoanDebtStatsClearedExcelHandler.class);

    /**
     * LOAN_TYPE_COUNT
     */
    private static final int LOAN_TYPE_COUNT = 8;

    /**
     * @param sheet
     * @param startRowNum
     * @param startCellNum
     * @param errorLogList
     * @return List<EtpLoanDebtStats>
     */
    @Override
    public List<EtpLoanDebtStats> handle(Sheet sheet, int startRowNum, int startCellNum, List<ErrorLog> errorLogList) {
        List<EtpLoanDebtStats> list = new ArrayList<>(8);

        //跳转到指定的输入内容行
        int rowNum = startRowNum + 1;
        int cellNum = startCellNum + 1;

        try {

            //获取类型所在的row
            Row row = sheet.getRow(rowNum++);
            for (int i = 0; i < LOAN_TYPE_COUNT; i++) {
                EtpLoanDebtStats etp = new EtpLoanDebtStats();
                etp.setCategory(ExcelUtils.getString(row.getCell(cellNum++)));
                etp.setState(2);
                list.add(etp);
            }

            //获取不良/违约类笔数所在row
            row = sheet.getRow(rowNum++);
            cellNum = startCellNum + 1;
            for (int i = 0; i < LOAN_TYPE_COUNT; i++) {
                list.get(i).setProblemCount(ExcelUtils.getInt(row.getCell(cellNum++)));
            }

            //获取关注类笔数所在row
            row = sheet.getRow(rowNum++);
            cellNum = startCellNum + 1;
            for (int i = 0; i < LOAN_TYPE_COUNT; i++) {
                list.get(i).setAttentionCount(ExcelUtils.getInt(row.getCell(cellNum++)));
            }

            //获取关正常类笔数所在row
            row = sheet.getRow(rowNum++);
            cellNum = startCellNum + 1;
            for (int i = 0; i < LOAN_TYPE_COUNT; i++) {
                list.get(i).setNormalCount(ExcelUtils.getInt(row.getCell(cellNum++)));
            }
        } catch (Exception ex) {
            String cellLocation = ExcelUtils.excelColIndexToStr(cellNum + 1) + rowNum;
            LOGGER.error("解析基本信息异常。sheet名称：{}，单元格：{}", sheet.getSheetName(), cellLocation);
            errorLogList.add(new ErrorLog(sheet.getSheetName(), cellLocation, "解析基本信息异常"));
        }
        return list;
    }
}
