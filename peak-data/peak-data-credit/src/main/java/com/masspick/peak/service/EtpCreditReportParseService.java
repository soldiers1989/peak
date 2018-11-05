package com.masspick.peak.service;


import com.masspick.peak.common.exception.PeakRuntimeException;
import com.masspick.peak.common.util.BeanUtils;
import com.masspick.peak.common.util.ExcelUtils;
import com.masspick.peak.excel.ErrorLog;
import com.masspick.peak.excel.ExcelImportResult;
import com.masspick.peak.excel.config.EtpCreditExcelConfig;
import com.masspick.peak.excel.config.TableConfig;
import com.masspick.peak.model.credit.etp.EtpAdvances;
import com.masspick.peak.model.credit.etp.EtpBA;
import com.masspick.peak.model.credit.etp.EtpBD;
import com.masspick.peak.model.credit.etp.EtpCreditReport;
import com.masspick.peak.model.credit.etp.EtpDebitHistory;
import com.masspick.peak.model.credit.etp.EtpDebtStats;
import com.masspick.peak.model.credit.etp.EtpFactoring;
import com.masspick.peak.model.credit.etp.EtpGuarantee;
import com.masspick.peak.model.credit.etp.EtpGuaranteeLetter;
import com.masspick.peak.model.credit.etp.EtpGuaranteeRecord;
import com.masspick.peak.model.credit.etp.EtpGuaranteeStats;
import com.masspick.peak.model.credit.etp.EtpInterest;
import com.masspick.peak.model.credit.etp.EtpLC;
import com.masspick.peak.model.credit.etp.EtpLoan;
import com.masspick.peak.model.credit.etp.EtpLoanDebtStats;
import com.masspick.peak.model.credit.etp.EtpOtherLoan;
import com.masspick.peak.model.credit.etp.EtpTaxOwed;
import com.masspick.peak.model.credit.etp.EtpTradeFinancing;
import com.masspick.peak.model.credit.etp.dto.EtpCreditReportDto;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/15.
 */
@Service
public class EtpCreditReportParseService {

    /**
     * @return ExcelImportResult<EtpCreditReportDto>
     * @throws IOException               IOException
     * @throws InvocationTargetException InvocationTargetException
     * @throws IllegalAccessException    IllegalAccessException
     */
    public ExcelImportResult<EtpCreditReportDto> parse() throws IOException, InvocationTargetException, IllegalAccessException {
        InputStream stream = this.getClass().getResourceAsStream("/excelTemplate/企业征信表格-报告样本公司.xlsx");
        return parse(stream);
    }

    /**
     * @param stream
     * @return ExcelImportResult<EtpCreditReportDto>
     * @throws IOException               IOException
     * @throws InvocationTargetException InvocationTargetException
     * @throws IllegalAccessException    IllegalAccessException
     */
    public ExcelImportResult<EtpCreditReportDto> parse(InputStream stream) throws IOException, InvocationTargetException, IllegalAccessException {
        XSSFWorkbook wb = new XSSFWorkbook(stream);

        //定义返回结果
        EtpCreditReportDto creditReportDto = new EtpCreditReportDto();
        List<ErrorLog> errorLogList = new ArrayList<>();
        int sheetNum = wb.getNumberOfSheets();

        for (int sheetIndex = 0; sheetIndex < sheetNum; sheetIndex++) {
            //处理信息概要sheet页
            Sheet sheet = wb.getSheetAt(sheetIndex);
            int lastRowNum = sheet.getLastRowNum();
            for (int i = 0; i < lastRowNum; i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                Cell cell = row.getCell(0);
                if (cell == null) {
                    continue;
                }
                String tableName = ExcelUtils.getString(cell);
                //获取table配置
                TableConfig tableConfig = EtpCreditExcelConfig.getTableConfig(sheet.getSheetName(), tableName);
                if (tableConfig == null) {
                    continue;
                }

                Object obj = null;
                if (tableConfig.isBatch()) {
                    obj = tableConfig.getBatchExcelHandler().handle(sheet, row.getRowNum(), cell.getColumnIndex(), errorLogList);
                } else {
                    obj = tableConfig.getExcelHandler().handle(sheet, row.getRowNum(), cell.getColumnIndex(), errorLogList);
                }
                if (obj == null) {
                    continue;
                }
                handleTable(creditReportDto, sheet.getSheetName(), tableName, obj);
            }
        }
        return new ExcelImportResult(creditReportDto, errorLogList);
    }

    /**
     * @param creditReportDto
     * @param sheetName
     * @param tableName
     * @param obj
     * @throws InvocationTargetException InvocationTargetException
     * @throws IllegalAccessException    IllegalAccessException
     */
    private void handleTable(EtpCreditReportDto creditReportDto, String sheetName, String tableName, Object obj)
            throws InvocationTargetException, IllegalAccessException {
        if ("信息概要".equals(sheetName)) {
            if ("基本信息".equals(tableName)) {
                EtpCreditReport result = (EtpCreditReport) obj;
                BeanUtils.copyProperties(creditReportDto, result);
            } else if ("当前负债信息概要".equals(tableName)) {
                EtpDebtStats result = (EtpDebtStats) obj;
                creditReportDto.getSummary().setCurrentAssetDebt(result);
            } else if ("当前债务统计信息".equals(tableName)) {
                List<EtpLoanDebtStats> result = (List<EtpLoanDebtStats>) obj;
                creditReportDto.getSummary().setCurrentLoanDebtList(result);
            } else if ("已还清债务信息概要".equals(tableName)) {
                List<EtpLoanDebtStats> result = (List<EtpLoanDebtStats>) obj;
                creditReportDto.getSummary().setClearedLoanDebtList(result);
            } else if ("对外担保信息概要".equals(tableName)) {
                List<EtpGuaranteeStats> result = (List<EtpGuaranteeStats>) obj;
                creditReportDto.getSummary().setGuaranteeStatsList(result);
            } else if ("负债变化历史".equals(tableName)) {
                List<EtpDebitHistory> result = (List<EtpDebitHistory>) obj;
                creditReportDto.getSummary().setDebitHistoryList(result);
            } else {
                throw new PeakRuntimeException("无效的标题。sheet：" + sheetName + ";标题： " + tableName);
            }
        }

        if ("不良和违约类债务".equals(sheetName)) {
            if ("贷款".equals(tableName)) {
                List<EtpLoan> result = (List<EtpLoan>) obj;
                creditReportDto.getCurrentDebt().getAbnormalLoan().setLoanList(result);
            } else if ("类贷款".equals(tableName)) {
                List<EtpOtherLoan> result = (List<EtpOtherLoan>) obj;
                creditReportDto.getCurrentDebt().getAbnormalLoan().setOtherLoanList(result);
            } else if ("贸易融资".equals(tableName)) {
                List<EtpTradeFinancing> result = (List<EtpTradeFinancing>) obj;
                creditReportDto.getCurrentDebt().getAbnormalLoan().setTradeFinancingList(result);
            } else if ("保理".equals(tableName)) {
                List<EtpFactoring> result = (List<EtpFactoring>) obj;
                creditReportDto.getCurrentDebt().getAbnormalLoan().setFactoringList(result);
            } else if ("银行承兑汇票".equals(tableName)) {
                List<EtpBA> result = (List<EtpBA>) obj;
                creditReportDto.getCurrentDebt().getAbnormalLoan().setBankAcceptanceList(result);
            } else if ("信用证".equals(tableName)) {
                List<EtpLC> result = (List<EtpLC>) obj;
                creditReportDto.getCurrentDebt().getAbnormalLoan().setLetterCredit(result);
            } else if ("保函".equals(tableName)) {
                List<EtpGuaranteeLetter> result = (List<EtpGuaranteeLetter>) obj;
                creditReportDto.getCurrentDebt().getAbnormalLoan().setGuaranteeLetter(result);
            } else {
                throw new PeakRuntimeException("无效的标题。sheet：" + sheetName + ";标题： " + tableName);
            }
        }

        if ("关注类债务".equals(sheetName)) {
            if ("贷款".equals(tableName)) {
                List<EtpLoan> result = (List<EtpLoan>) obj;
                creditReportDto.getCurrentDebt().getAttentionLoan().setLoanList(result);
            } else if ("贸易融资".equals(tableName)) {
                List<EtpTradeFinancing> result = (List<EtpTradeFinancing>) obj;
                creditReportDto.getCurrentDebt().getAttentionLoan().setTradeFinancingList(result);
            } else if ("保理".equals(tableName)) {
                List<EtpFactoring> result = (List<EtpFactoring>) obj;
                creditReportDto.getCurrentDebt().getAttentionLoan().setFactoringList(result);
            } else if ("票据贴现".equals(tableName)) {
                List<EtpBD> result = (List<EtpBD>) obj;
                creditReportDto.getCurrentDebt().getAttentionLoan().setBillDiscountedList(result);
            } else if ("银行承兑汇票".equals(tableName)) {
                List<EtpBA> result = (List<EtpBA>) obj;
                creditReportDto.getCurrentDebt().getAttentionLoan().setBankAcceptanceList(result);
            } else if ("信用证".equals(tableName)) {
                List<EtpLC> result = (List<EtpLC>) obj;
                creditReportDto.getCurrentDebt().getAttentionLoan().setLetterCredit(result);
            } else if ("保函".equals(tableName)) {
                List<EtpGuaranteeLetter> result = (List<EtpGuaranteeLetter>) obj;
                creditReportDto.getCurrentDebt().getAttentionLoan().setGuaranteeLetter(result);
            } else {
                throw new PeakRuntimeException("无效的标题。sheet：" + sheetName + ";标题： " + tableName);
            }
        }

        if ("正常类债务".equals(sheetName)) {
            if ("贷款".equals(tableName)) {
                List<EtpLoan> result = (List<EtpLoan>) obj;
                creditReportDto.getCurrentDebt().getNormalLoan().setLoanList(result);
            } else if ("类贷款".equals(tableName)) {
                List<EtpOtherLoan> result = (List<EtpOtherLoan>) obj;
                creditReportDto.getCurrentDebt().getNormalLoan().setOtherLoanList(result);
            } else if ("贸易融资".equals(tableName)) {
                List<EtpTradeFinancing> result = (List<EtpTradeFinancing>) obj;
                creditReportDto.getCurrentDebt().getNormalLoan().setTradeFinancingList(result);
            } else if ("保理".equals(tableName)) {
                List<EtpFactoring> result = (List<EtpFactoring>) obj;
                creditReportDto.getCurrentDebt().getNormalLoan().setFactoringList(result);
            } else if ("票据贴现".equals(tableName)) {
                List<EtpBD> result = (List<EtpBD>) obj;
                creditReportDto.getCurrentDebt().getNormalLoan().setBillDiscountedList(result);
            } else if ("银行承兑".equals(tableName)) {
                List<EtpBA> result = (List<EtpBA>) obj;
                creditReportDto.getCurrentDebt().getNormalLoan().setBankAcceptanceList(result);
            } else if ("信用证".equals(tableName)) {
                List<EtpLC> result = (List<EtpLC>) obj;
                creditReportDto.getCurrentDebt().getNormalLoan().setLetterCredit(result);
            } else if ("保函".equals(tableName)) {
                List<EtpGuaranteeLetter> result = (List<EtpGuaranteeLetter>) obj;
                creditReportDto.getCurrentDebt().getNormalLoan().setGuaranteeLetter(result);
            } else {
                throw new PeakRuntimeException("无效的标题。sheet：" + sheetName + ";标题： " + tableName);
            }
        }

        if ("已还清债务".equals(sheetName)) {
            if ("担保及第三方代偿信息".equals(tableName)) {
                List<EtpGuarantee> result = (List<EtpGuarantee>) obj;
                creditReportDto.getClearDebt().setGuarantee(result);
            } else if ("欠息".equals(tableName)) {
                List<EtpInterest> result = (List<EtpInterest>) obj;
                creditReportDto.getClearDebt().setInterest(result);
            } else if ("垫款".equals(tableName)) {
                List<EtpAdvances> result = (List<EtpAdvances>) obj;
                creditReportDto.getClearDebt().setAdvances(result);
            } else if ("贷款".equals(tableName)) {
                List<EtpLoan> result = (List<EtpLoan>) obj;
                creditReportDto.getClearDebt().getClearedLoan().setLoanList(result);
            } else if ("类贷款".equals(tableName)) {
                List<EtpOtherLoan> result = (List<EtpOtherLoan>) obj;
                creditReportDto.getClearDebt().getClearedLoan().setOtherLoanList(result);
            } else if ("贸易融资".equals(tableName)) {
                List<EtpTradeFinancing> result = (List<EtpTradeFinancing>) obj;
                creditReportDto.getClearDebt().getClearedLoan().setTradeFinancingList(result);
            } else {
                throw new PeakRuntimeException("无效的标题。sheet：" + sheetName + ";标题： " + tableName);
            }
        }

        if ("对外担保记录以及公共信息".equals(sheetName)) {
            if ("对外担保记录".equals(tableName)) {
                List<EtpGuaranteeRecord> result = (List<EtpGuaranteeRecord>) obj;
                creditReportDto.setGuaranteeRecordList(result);
            } else if ("欠税记录".equals(tableName)) {
                List<EtpTaxOwed> result = (List<EtpTaxOwed>) obj;
                creditReportDto.getCommon().setTaxOwedList(result);
            } else {
                throw new PeakRuntimeException("无效的标题。sheet：" + sheetName + ";标题： " + tableName);
            }
        }
    }
}
