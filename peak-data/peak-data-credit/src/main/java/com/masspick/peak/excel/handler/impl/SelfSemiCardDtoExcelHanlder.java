package com.masspick.peak.excel.handler.impl;


import com.masspick.peak.common.util.ExcelUtils;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.excel.ErrorLog;
import com.masspick.peak.excel.handler.ExcelHandler;
import com.masspick.peak.model.credit.self.dto.SelfSemiDebitCardDto;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Administrator on 2018/6/16.
 */
public class SelfSemiCardDtoExcelHanlder implements ExcelHandler<SelfSemiDebitCardDto> {
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
     * @return SelfSemiDebitCardDto
     */
    @Override
    public SelfSemiDebitCardDto handle(Sheet sheet, int startRowNum, int startCellNum, List<ErrorLog> errorLogList) {

        //跳转到指定的输入内容行
        int rowNum = startRowNum + 2;
        int cellNum = startCellNum;
        SelfSemiDebitCardDto selfSemiDebitCard = null;
        try {
            Row row = sheet.getRow(rowNum);
            if (row == null) {
                return selfSemiDebitCard;
            }
            //首列为空校验，如果为空。不做后续解析
            String firstValue = ExcelUtils.getString(row.getCell(cellNum));
            if (StringUtils.isEmpty(firstValue)) {
                return selfSemiDebitCard;
            }
            selfSemiDebitCard = new SelfSemiDebitCardDto();
            selfSemiDebitCard.setSharedAmount(ExcelUtils.getDouble(row.getCell(cellNum++)));
            selfSemiDebitCard.setOverdrawAmount(ExcelUtils.getDouble(row.getCell(cellNum++)));
            selfSemiDebitCard.setAverageOverdrawFee(ExcelUtils.getDouble(row.getCell(cellNum++)));
            selfSemiDebitCard.setMaxOverdrawFee(ExcelUtils.getDouble(row.getCell(cellNum++)));
            selfSemiDebitCard.setRepaymentTime(ExcelUtils.getDate(row.getCell(cellNum++)));
            selfSemiDebitCard.setRealMonthRepaymentFee(ExcelUtils.getDouble(row.getCell(cellNum++)));
            selfSemiDebitCard.setLastRepaymentTime(ExcelUtils.getDate(row.getCell(cellNum++)));
            selfSemiDebitCard.setOverdrawUnpaidBalance(ExcelUtils.getDouble(row.getCell(cellNum++)));

            //获取第三行信息
            rowNum = rowNum + 1;
            row = sheet.getRow(rowNum++);
            cellNum = startCellNum;
            selfSemiDebitCard.setReplyRecordStartDate(ExcelUtils.getDate(row.getCell(cellNum + 1)));
            selfSemiDebitCard.setReplyRecordEndDate(ExcelUtils.getDate(row.getCell(cellNum + 4)));
            row = sheet.getRow(rowNum);
            cellNum = startCellNum;
            selfSemiDebitCard.setReplyRecord(ExcelUtils.getString(row.getCell(cellNum)));
        } catch (Exception ex) {
            String cellLocation = ExcelUtils.excelColIndexToStr(cellNum + 1) + (rowNum);
            LOGGER.error("解析基本信息异常。sheet名称：{}，单元格：{}", sheet.getSheetName(), cellLocation);
            LOGGER.error("解析基本信息异常", ex);
            errorLogList.add(new ErrorLog(sheet.getSheetName(), cellLocation, "解析基本信息异常"));
        }

        return selfSemiDebitCard;
    }
}
