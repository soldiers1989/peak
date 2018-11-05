package com.masspick.peak.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 三大报告工具类
 */
public class ThreeReportUtils {


    public static final String SAMPLE_XLSX_FILE_PATH = "e:\\three.xlsx";


    /**
     * 读取excel数据，生成建库脚本、数据库数据插入脚本
     *
     * @throws Exception FileNotFoundException、IOException
     */
    public static void read() throws Exception {

        Workbook workbook = new XSSFWorkbook(new FileInputStream(SAMPLE_XLSX_FILE_PATH));
        int num = workbook.getNumberOfSheets();
        for (int page = 0; page < num; page++) {
            Sheet sheet = workbook.getSheetAt(page);
            // 遍历全部非空行
            String fileName = "E:\\" + workbook.getSheetName(page) + ".sql";
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fot = new FileOutputStream(file);
            String tableName = "field_data"; //表名
            List<String> listFiled = new ArrayList<String>(); //列名
            List<String> listDescribe = new ArrayList<String>(); //注释
            StringBuilder sbSQL = new StringBuilder(); //拼接总sql
            StringBuilder sbKey = new StringBuilder(); //拼接sql的key值
            StringBuilder sbValue = new StringBuilder(); //拼接sql的value值
            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (row.getRowNum() == 1 && cell.getColumnIndex() >= 0) {
                        listFiled.add(cell.getStringCellValue());
                        sbKey.append(cell.getStringCellValue() + ",");
                    }
                    if (row.getRowNum() >= 2 && cell.getColumnIndex() == 0) {
                        sbValue.append("( '" + cell.getStringCellValue() + "','");
                    }
                    if (row.getRowNum() >= 2 && cell.getColumnIndex() == 1) {
                        sbValue.append(cell.getStringCellValue() + "','");
                    }
                    if (row.getRowNum() >= 2 && cell.getColumnIndex() == 2) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        sbValue.append(cell.getStringCellValue() + "'),");
                        sbValue.append("\n");
                    }
                }
            }
//            //创建数据库表
//            String dropInfo = "DROP TABLE IF EXISTS " + tableName + " ;\n";
//            StringBuilder createSQL = new StringBuilder();
//            createSQL.append(dropInfo);
//            createSQL.append("CREATE TABLE `" + tableName + "` (`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',\n");
//            for (int i = 0; i < listFiled.size(); i++) {
//                createSQL.append("`" + listFiled.get(i) + "` varchar(100) DEFAULT NULL COMMENT '" + listDescribe.get(i) + "',\n");
//            }
//            createSQL.append("\t PRIMARY KEY (`id`))");
//            fot.write("------数据库表创建语句------\n".getBytes());
//            fot.write(createSQL.toString().getBytes());
            //插入数据
            String keys = sbKey.toString().replaceAll(",$", "");
            String values = sbValue.toString().replaceAll(",$", "");
            String insertSQL = "insert into " + tableName + " (" + keys + ") \n values ";
            sbSQL.append("\n");
            sbSQL.append(insertSQL);
            sbSQL.append(values);
            fot.write("\n------数据库表插入数据语句------\n".getBytes());
            fot.write(sbSQL.toString().getBytes());
        }
    }


    /**
     * 处理进件数据信息
     *
     * @param json json
     * @return
     * @throws Exception ex
     */
    public static void intoUtil(JSONObject json) throws Exception {

    }


    /**
     * 处理企业征信信息
     *
     * @param json
     * @return map
     * @throws Exception
     */
    public static Map etpUtils(JSONObject json) {
        Map map = new HashMap();
        map.put("reportDate", json.get("reportDate"));
        JSONObject summaryJson = JSONObject.parseObject(json.getString("summary"));
        List<Map> debits = JSONObject.parseArray(summaryJson.getString("debitHistoryList"), Map.class);
        //银行贷款额度三年变化
        if (debits != null && debits.size() >= 2) {
            BigDecimal now = BigDecimal.valueOf(Double.parseDouble(debits.get(debits.size() - 1).get("totalDebitFee").toString()));
            BigDecimal inpast = BigDecimal.valueOf(Double.parseDouble(debits.get(0).get("totalDebitFee").toString()));
            map.put("changeOfLoanIn3Y", now.subtract(inpast).toString());
        } else {
            map.put("changeOfLoanIn3Y", debits.get(0).get("totalDebitFee").toString());
        }
        //银行存续贷款的合计余额
        List<Map> currentLoanDebts = JSONObject.parseArray(summaryJson.getString("currentLoanDebtList"), Map.class);
        if (currentLoanDebts != null && currentLoanDebts.size() > 0) {
            BigDecimal sum = new BigDecimal(0);
            for (Map map1 : currentLoanDebts) {
                BigDecimal normal = new BigDecimal(0);
                BigDecimal attention = new BigDecimal(0);
                BigDecimal problem = new BigDecimal(0);
                if (map1.containsKey("normalBalance")) {
                    normal = BigDecimal.valueOf(Double.parseDouble(map1.get("normalBalance").toString()));
                }
                if (map1.containsKey("attentionBalance")) {
                    attention = BigDecimal.valueOf(Double.parseDouble(map1.get("attentionBalance").toString()));
                }
                if (map1.containsKey("problemBalance")) {
                    problem = BigDecimal.valueOf(Double.parseDouble(map1.get("problemBalance").toString()));
                }
                sum = sum.add(normal.add(attention.add(problem)));
            }
            map.put("totLoanBalance", sum.toString());
        } else {
            map.put("totLoanBalance", "0");
        }
        //关注类贷款笔数、关注类贷款单笔最大金额
        JSONObject currentDebtJson = JSONObject.parseObject(json.getString("currentDebt"));
        JSONObject attentionLoanJson = JSONObject.parseObject(currentDebtJson.getString("attentionLoan"));
        List<Map> loanList = JSONObject.parseArray(attentionLoanJson.getString("loanList"), Map.class);
        if (loanList != null && loanList.size() > 0) {
            BigDecimal fee = new BigDecimal(0);
            for (Map map1 : loanList) {
                if (map1.containsKey("fee")) {
                    BigDecimal fee1 = BigDecimal.valueOf(Double.parseDouble(map1.get("fee").toString()));
                    fee = fee.max(fee1);
                }
            }
            map.put("entSpecialLoanNum", String.valueOf(loanList.size()));
            map.put("entMaxSpecialLoan", fee.toString());
        } else {
            map.put("entSpecialLoanNum", "0");
            map.put("entMaxSpecialLoan", "0");
        }
        //对外担保总额、对外担保次数(次)
        List<Map> guaranteeStatsList = JSONObject.parseArray(summaryJson.getString("guaranteeStatsList"), Map.class);
        if (guaranteeStatsList != null && guaranteeStatsList.size() > 0) {
            BigDecimal fee = new BigDecimal(0);
            for (Map map1 : guaranteeStatsList) {
                if (map1.containsKey("fee")) {
                    BigDecimal fee1 = BigDecimal.valueOf(Double.parseDouble(map1.get("fee").toString()));
                    fee = fee.add(fee1);
                }
            }
            map.put("entExternalGuarantNum", String.valueOf(guaranteeStatsList.size()));
            map.put("entExternalGuarantFinance", fee.toString());
        } else {
            map.put("entExternalGuarantNum", "0");
            map.put("entExternalGuarantFinance", "0");
        }
        return map;
    }

    /**
     * 处理实际控制人征信情况
     *
     * @param json
     * @return map
     * @throws Exception
     */
    public static Map selfUtils(JSONObject json) {
        Map map = new HashMap();
        List<Map> loanList = JSONObject.parseArray(json.getString("loanList"), Map.class);
        //当前负债总余额其中房贷余额(万)houseMortgageAmount、关注类贷款笔数（笔）perSpecialLoanNum、关注类贷款单笔最大金额(万)perMaxSpecialLoan
        if (loanList != null && loanList.size() > 0) {
            int perSpecialLoanNum = 0;
            BigDecimal houseMortgageAmount = new BigDecimal(0);
            BigDecimal perMaxSpecialLoan = new BigDecimal(0);
            for (Map map1 : loanList) {
                if (map1.get("loanType").equals("个人住房贷款")) {
                    BigDecimal overdueFee1 = BigDecimal.valueOf(Double.parseDouble(map1.get("overdueFee").toString()));
                    houseMortgageAmount = houseMortgageAmount.add(overdueFee1);
                }
                if (map1.get("classify").equals("关注")) {
                    perSpecialLoanNum++;
                    BigDecimal overdueFee1 = new BigDecimal(0);
                    overdueFee1 = BigDecimal.valueOf(Double.parseDouble(map1.get("overdueFee").toString()));
                    if (perMaxSpecialLoan.compareTo(overdueFee1) < 0) {
                        perMaxSpecialLoan = overdueFee1;
                    }
                }
            }
            map.put("houseMortgageAmount", houseMortgageAmount.toString());
            map.put("perSpecialLoanNum", String.valueOf(perSpecialLoanNum));
            map.put("perMaxSpecialLoan", perMaxSpecialLoan.toString());
        } else {
            map.put("houseMortgageAmount", "0");
            map.put("perSpecialLoanNum", "0");
            map.put("perMaxSpecialLoan", "0");
        }
        //信用卡单卡最高授信额度(万)maximumOfSingleCreditCard,信用卡已用额度(万)usedCreditCardAmount
        JSONObject creditSummaryJson = JSONObject.parseObject(json.getString("creditSummary"));
        if (creditSummaryJson.containsKey("debitCardStats")) {
            JSONObject debitCardStatsJson = JSONObject.parseObject(creditSummaryJson.getString("debitCardStats"));
            map.put("maximumOfSingleCreditCard", debitCardStatsJson.get("maxCreditFee").toString());
            map.put("usedCreditCardAmount", debitCardStatsJson.get("usedFee").toString());
        } else {
            map.put("maximumOfSingleCreditCard", "0");
            map.put("usedCreditCardAmount", "0");
        }
        //对外担保次数(次)externalGuarantNum 对外担保金额(万)perExternalGuarantFinance
        List<Map> guaranteeLoanList = JSONObject.parseArray(json.getString("guaranteeLoan"), Map.class);
        if (guaranteeLoanList != null && guaranteeLoanList.size() > 0) {
            BigDecimal amount = new BigDecimal(0);
            for (Map map1 : guaranteeLoanList) {
                BigDecimal amount1 = BigDecimal.valueOf(Double.parseDouble(map1.get("amount").toString()));
                amount = amount.add(amount1);
            }
            map.put("externalGuarantNum", String.valueOf(guaranteeLoanList.size()));
            map.put("perExternalGuarantFinance", amount.toString());
        } else {
            map.put("externalGuarantNum", 0);
            map.put("pererternalGuarantFinance", "0");
        }
        return map;
    }


}