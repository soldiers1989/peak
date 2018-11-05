package com.masspick.peak.excel.handler.impl;


import com.masspick.peak.common.util.ExcelUtils;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.excel.ErrorLog;
import com.masspick.peak.excel.config.EtpCreditExcelConfig;
import com.masspick.peak.excel.config.SelfCreditExcelConfig;
import com.masspick.peak.excel.handler.ExcelHandler;
import com.masspick.peak.model.credit.self.SelfOverdue;
import com.masspick.peak.model.credit.self.dto.SelfDebitCardDto;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/15.
 */
public class SelfDebitCardExcelHandler implements ExcelHandler<SelfDebitCardDto> {
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SelfLoanDtoExcelHandler.class);

    /**
     * MAX_OVERDUE_RECORD
     */
    private static final int MAX_OVERDUE_RECORD = 100;

    /**
     * @param sheet
     * @param startRowNum
     * @param startCellNum
     * @param errorLogList
     * @return SelfDebitCardDto
     */
    @Override
    public SelfDebitCardDto handle(Sheet sheet, int startRowNum, int startCellNum, List<ErrorLog> errorLogList) {

        //跳转到指定的输入内容行
        int rowNum = startRowNum + 2;
        int cellNum = startCellNum;
        SelfDebitCardDto selfDebitCard = null;
        try {
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                return selfDebitCard;
            }

            //首列为空校验，如果为空。不做后续解析
            String firstValue = ExcelUtils.getString(row.getCell(cellNum));
            if (StringUtils.isEmpty(firstValue)) {
                return selfDebitCard;
            }
            selfDebitCard = new SelfDebitCardDto();
            selfDebitCard.setSharedCreditLine(ExcelUtils.getDouble(row.getCell(cellNum++)));
            selfDebitCard.setUsedFee(ExcelUtils.getDouble(row.getCell(cellNum++)));
            selfDebitCard.setAverageUsedFee(ExcelUtils.getDouble(row.getCell(cellNum++)));
            selfDebitCard.setMaxUsedFee(ExcelUtils.getDouble(row.getCell(cellNum++)));
            selfDebitCard.setMonthRepaymentFee(ExcelUtils.getDouble(row.getCell(cellNum++)));

            //获取第二行信息
            rowNum = rowNum + 2;
            row = sheet.getRow(rowNum);
            cellNum = startCellNum;
            if (row == null) {
                return selfDebitCard;
            }

            selfDebitCard.setRepaymentTime(ExcelUtils.getDate(row.getCell(cellNum++)));
            selfDebitCard.setRealMonthRepaymentFee(ExcelUtils.getDouble(row.getCell(cellNum++)));
            selfDebitCard.setLastRepaymentTime(ExcelUtils.getDate(row.getCell(cellNum++)));
            selfDebitCard.setOverdueCount(ExcelUtils.getInt(row.getCell(cellNum++)));
            selfDebitCard.setOverdueFee(ExcelUtils.getDouble(row.getCell(cellNum++)));

            //获取第三行信息
            rowNum = rowNum + 1;
            row = sheet.getRow(rowNum++);
            cellNum = startCellNum;
            selfDebitCard.setReplyRecordStartDate(ExcelUtils.getDate(row.getCell(cellNum + 1)));
            selfDebitCard.setReplyRecordEndDate(ExcelUtils.getDate(row.getCell(cellNum + 4)));
            row = sheet.getRow(rowNum);
            cellNum = startCellNum;
            selfDebitCard.setReplyRecord(ExcelUtils.getString(row.getCell(cellNum)));

            //获取第四行信息
            rowNum = rowNum + 1;
            row = sheet.getRow(rowNum);
            cellNum = startCellNum;
            selfDebitCard.setOverdueRecordStartDate(ExcelUtils.getDate(row.getCell(cellNum + 1)));
            selfDebitCard.setOverdueRecordEndDate(ExcelUtils.getDate(row.getCell(cellNum + 4)));
            rowNum = rowNum + 2;
            row = sheet.getRow(rowNum);
            cellNum = startCellNum;
            List<SelfOverdue> overdueList = new ArrayList<>();
            for (int i = 0; i < MAX_OVERDUE_RECORD; i++) {
                row = sheet.getRow(rowNum++);
                cellNum = startCellNum;
                if (row == null) {
                    break;
                }

                //所有表格必须保证第一个单元格有内容。如果没内容不进行后续解析。
                // 当前单元格为空，或者改内容属于标题。结束循环
                firstValue = ExcelUtils.getString(row.getCell(cellNum));
                if (firstValue == null || EtpCreditExcelConfig.getTableConfig(sheet.getSheetName(), firstValue.trim()) != null
                        || SelfCreditExcelConfig.getTableConfig(sheet.getSheetName(), firstValue.trim()) != null) {
                    break;
                }
                SelfOverdue overdue = new SelfOverdue();
                overdue.setOverdueDate(ExcelUtils.getDate(row.getCell(cellNum++)));
                overdue.setMonthCount(ExcelUtils.getInt(row.getCell(cellNum++)));
                overdue.setFee(ExcelUtils.getDouble(row.getCell(cellNum++)));
                overdue.setType(1);
                overdueList.add(overdue);

                Date overdueMonth = ExcelUtils.getDate(row.getCell(cellNum++));
                if (overdueMonth == null) {
                    continue;
                }
                overdue = new SelfOverdue();
                overdue.setOverdueDate(overdueMonth);
                overdue.setMonthCount(ExcelUtils.getInt(row.getCell(cellNum++)));
                overdue.setFee(ExcelUtils.getDouble(row.getCell(cellNum++)));
                overdue.setType(1);
                overdueList.add(overdue);
            }
            selfDebitCard.setOverdueList(overdueList);
        } catch (Exception ex) {
            String cellLocation = ExcelUtils.excelColIndexToStr(cellNum + 1) + (rowNum);
            LOGGER.error("解析基本信息异常。sheet名称：{}，单元格：{}", sheet.getSheetName(), cellLocation);
            LOGGER.error("解析基本信息异常", ex);
            errorLogList.add(new ErrorLog(sheet.getSheetName(), cellLocation, "解析基本信息异常"));
        }

        return selfDebitCard;
    }
}
