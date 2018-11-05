package com.masspick.peak.service;

import com.masspick.peak.common.exception.PeakRuntimeException;
import com.masspick.peak.common.util.BeanUtils;
import com.masspick.peak.common.util.ExcelUtils;
import com.masspick.peak.excel.ErrorLog;
import com.masspick.peak.excel.ExcelImportResult;
import com.masspick.peak.excel.config.SelfCreditExcelConfig;
import com.masspick.peak.excel.config.TableConfig;
import com.masspick.peak.model.credit.self.Self;
import com.masspick.peak.model.credit.self.SelfAddress;
import com.masspick.peak.model.credit.self.SelfCreditReport;
import com.masspick.peak.model.credit.self.SelfDebitCardStats;
import com.masspick.peak.model.credit.self.SelfHouseFund;
import com.masspick.peak.model.credit.self.SelfLoanApprovalRecord;
import com.masspick.peak.model.credit.self.SelfOverdueStats;
import com.masspick.peak.model.credit.self.SelfSearchRecord;
import com.masspick.peak.model.credit.self.SelfSemiCardStats;
import com.masspick.peak.model.credit.self.SelfUnclearedLoanStats;
import com.masspick.peak.model.credit.self.dto.SelfCreditReportDto;
import com.masspick.peak.model.credit.self.dto.SelfDebitCardDto;
import com.masspick.peak.model.credit.self.dto.SelfLoanDto;
import com.masspick.peak.model.credit.self.dto.SelfSemiDebitCardDto;
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
public class SelfCreditReportParseService {

    /**
     * @return ExcelImportResult<SelfCreditReportDto>
     * @throws IOException               IOException
     * @throws InvocationTargetException InvocationTargetException
     * @throws IllegalAccessException    IllegalAccessException
     */
    public ExcelImportResult<SelfCreditReportDto> parse() throws IOException, InvocationTargetException, IllegalAccessException {
        InputStream stream = this.getClass().getResourceAsStream("/excelTemplate/个人版征信表格-样本.xlsx");
        return parse(stream);
    }

    /**
     * @param stream
     * @return ExcelImportResult<SelfCreditReportDto>
     * @throws IOException               IOException
     * @throws InvocationTargetException InvocationTargetException
     * @throws IllegalAccessException    IllegalAccessException
     */
    public ExcelImportResult<SelfCreditReportDto> parse(InputStream stream) throws IOException, InvocationTargetException, IllegalAccessException {
        XSSFWorkbook wb = new XSSFWorkbook(stream);

        //定义返回结果
        SelfCreditReportDto creditReportDto = new SelfCreditReportDto();
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
                TableConfig tableConfig = SelfCreditExcelConfig.getTableConfig(sheet.getSheetName(), tableName);
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
    private void handleTable(SelfCreditReportDto creditReportDto, String sheetName, String tableName, Object obj)
            throws InvocationTargetException, IllegalAccessException {
        if ("基本信息".equals(sheetName)) {
            if ("报告信息".equals(tableName)) {
                SelfCreditReport result = (SelfCreditReport) obj;
                BeanUtils.copyProperties(creditReportDto, result);
            } else if ("身份信息".equals(tableName)) {
                Self result = (Self) obj;
                creditReportDto.setSelf(result);
            } else if ("居住信息".equals(tableName)) {
                List<SelfAddress> result = (List<SelfAddress>) obj;
                creditReportDto.setAddressList(result);
            } else if ("逾期及违约信息概要".equals(tableName)) {
                List<SelfOverdueStats> result = (List<SelfOverdueStats>) obj;
                creditReportDto.getCreditSummary().setOverdueStats(result);
            } else if ("未结清贷款信息汇总".equals(tableName)) {
                SelfUnclearedLoanStats result = (SelfUnclearedLoanStats) obj;
                creditReportDto.getCreditSummary().setUnclearedLoanStats(result);
            } else if ("未销户贷记卡信息汇总".equals(tableName)) {
                SelfDebitCardStats result = (SelfDebitCardStats) obj;
                creditReportDto.getCreditSummary().setDebitCardStats(result);
            } else if ("未销户准贷记卡信息汇总".equals(tableName)) {
                SelfSemiCardStats result = (SelfSemiCardStats) obj;
                creditReportDto.getCreditSummary().setSemiCardStats(result);
            } else {
                throw new PeakRuntimeException("无效的标题。sheet：" + sheetName + ";标题： " + tableName);
            }
        }

        if ("贷款".equals(sheetName)) {
            if ("贷款".equals(tableName)) {
                SelfLoanDto result = (SelfLoanDto) obj;
                creditReportDto.getLoanList().add(result);
            } else {
                throw new PeakRuntimeException("无效的标题。sheet：" + sheetName + ";标题： " + tableName);
            }
        }

        if ("贷记卡".equals(sheetName)) {
            if ("贷记卡".equals(tableName)) {
                SelfDebitCardDto result = (SelfDebitCardDto) obj;
                creditReportDto.getDebitCardList().add(result);
            } else {
                throw new PeakRuntimeException("无效的标题。sheet：" + sheetName + ";标题： " + tableName);
            }
        }

        if ("准贷记卡".equals(sheetName)) {
            if ("准贷记卡".equals(tableName)) {
                SelfSemiDebitCardDto result = (SelfSemiDebitCardDto) obj;
                creditReportDto.getSemiDebitCardList().add(result);
            } else {
                throw new PeakRuntimeException("无效的标题。sheet：" + sheetName + ";标题： " + tableName);
            }
        }

        if ("住房公积金参缴记录".equals(sheetName)) {
            if ("住房公积金参缴记录".equals(tableName)) {
                List<SelfHouseFund> result = (List<SelfHouseFund>) obj;
                creditReportDto.setHouseFundList(result);
            } else {
                throw new PeakRuntimeException("无效的标题。sheet：" + sheetName + ";标题： " + tableName);
            }
        }

        if ("查询记录汇总".equals(sheetName)) {
            if ("查询记录汇总".equals(tableName)) {
                SelfSearchRecord result = (SelfSearchRecord) obj;
                creditReportDto.setSearchRecord(result);
            } else if ("信贷审批查询记录明细".equals(tableName)) {
                List<SelfLoanApprovalRecord> result = (List<SelfLoanApprovalRecord>) obj;
                creditReportDto.setLoanApprovalRecordList(result);
            } else {
                throw new PeakRuntimeException("无效的标题。sheet：" + sheetName + ";标题： " + tableName);
            }
        }
    }
}
