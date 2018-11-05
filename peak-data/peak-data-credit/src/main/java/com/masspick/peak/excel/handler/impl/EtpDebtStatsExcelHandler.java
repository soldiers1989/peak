package com.masspick.peak.excel.handler.impl;


import com.masspick.peak.common.util.ExcelUtils;
import com.masspick.peak.excel.ErrorLog;
import com.masspick.peak.excel.handler.ExcelHandler;
import com.masspick.peak.model.credit.etp.EtpDebtStats;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */
public class EtpDebtStatsExcelHandler implements ExcelHandler<EtpDebtStats> {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EtpDebtStatsExcelHandler.class);

    /**
     * @param sheet
     * @param startRowNum
     * @param startCellNum
     * @param errorLogList
     * @return EtpDebtStats
     */
    @Override
    public EtpDebtStats handle(Sheet sheet, int startRowNum, int startCellNum, List<ErrorLog> errorLogList) {
        EtpDebtStats etpDebtStats = new EtpDebtStats();

        //跳转到指定的输入内容行
        int rowNum = startRowNum + 3;
        int cellNum = startCellNum;
        try {
            Row row = sheet.getRow(rowNum);
            if (row != null) {
                etpDebtStats.setByAssetComHandleCount(ExcelUtils.getInt(row.getCell(cellNum++)));
                etpDebtStats.setByAssetComHandleFee(ExcelUtils.getDouble(row.getCell(cellNum++)));
                etpDebtStats.setByAssetComHandleDate(ExcelUtils.getDate(row.getCell(cellNum++)));
                etpDebtStats.setOweInterestCount(ExcelUtils.getInt(row.getCell(cellNum++)));
                etpDebtStats.setOweInterestFee(ExcelUtils.getDouble(row.getCell(cellNum++)));
                etpDebtStats.setState(1);
            }

            rowNum = rowNum + 3;
            cellNum = startCellNum;
            row = sheet.getRow(rowNum);
            if (row != null) {
                etpDebtStats.setAdvanceCount(ExcelUtils.getInt(row.getCell(cellNum++)));
                etpDebtStats.setAdvanceFee(ExcelUtils.getDouble(row.getCell(cellNum++)));
                etpDebtStats.setGuaranteeCount(ExcelUtils.getInt(row.getCell(cellNum++)));
                etpDebtStats.setGuaranteeFee(ExcelUtils.getDouble(row.getCell(cellNum++)));
                etpDebtStats.setGuaranteeClearDate(ExcelUtils.getDate(row.getCell(cellNum++)));
            }
        } catch (Exception ex) {
            String cellLocation = ExcelUtils.excelColIndexToStr(cellNum + 1) + rowNum;
            LOGGER.error("解析基本信息异常。sheet名称：{}，单元格：{}", sheet.getSheetName(), cellLocation);
            errorLogList.add(new ErrorLog(sheet.getSheetName(), cellLocation, "解析基本信息异常"));
        }
        return etpDebtStats;
    }
}
