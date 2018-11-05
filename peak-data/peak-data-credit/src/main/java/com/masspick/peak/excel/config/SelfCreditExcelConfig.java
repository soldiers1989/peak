package com.masspick.peak.excel.config;

import com.masspick.peak.excel.handler.impl.DefaultBatchExcelHandler;
import com.masspick.peak.excel.handler.impl.DefaultExcelHandler;
import com.masspick.peak.excel.handler.impl.SelfDebitCardExcelHandler;
import com.masspick.peak.excel.handler.impl.SelfLoanDtoExcelHandler;
import com.masspick.peak.excel.handler.impl.SelfOverdueStatsBatchHandler;
import com.masspick.peak.excel.handler.impl.SelfSemiCardDtoExcelHanlder;
import com.masspick.peak.model.credit.self.Self;
import com.masspick.peak.model.credit.self.SelfAddress;
import com.masspick.peak.model.credit.self.SelfCreditReport;
import com.masspick.peak.model.credit.self.SelfDebitCardStats;
import com.masspick.peak.model.credit.self.SelfHouseFund;
import com.masspick.peak.model.credit.self.SelfLoanApprovalRecord;
import com.masspick.peak.model.credit.self.SelfSearchRecord;
import com.masspick.peak.model.credit.self.SelfSemiCardStats;
import com.masspick.peak.model.credit.self.SelfUnclearedLoanStats;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/15.
 */
public final class SelfCreditExcelConfig {

    private SelfCreditExcelConfig() {
    }

    /**
     * config
     */
    private static Map<String, Map<String, TableConfig>> config = new HashMap<>();

    //基本信息
    static {
        Map<String, TableConfig> sheetMap = new HashMap<>();
        sheetMap.put("报告信息", new TableConfig(new DefaultExcelHandler<SelfCreditReport>(SelfCreditReport.class, 2, 0,
                new FieldConfig("name", FieldEnum.STRING),
                new FieldConfig("cardType", FieldEnum.STRING),
                new FieldConfig("cardNo", FieldEnum.STRING),
                new FieldConfig("reportTime", FieldEnum.DATE)
        )));

        sheetMap.put("身份信息", new TableConfig(new DefaultExcelHandler<Self>(Self.class, 2, 0,
                new FieldConfig("maritalStatus", FieldEnum.STRING),
                new FieldConfig("education", FieldEnum.STRING),
                new FieldConfig("degree", FieldEnum.STRING),
                new FieldConfig("address", FieldEnum.STRING),
                new FieldConfig("houseAddress", FieldEnum.STRING)
        )));

        sheetMap.put("居住信息", new TableConfig(new DefaultBatchExcelHandler<SelfAddress>(SelfAddress.class, 2, 0,
                new FieldConfig("address", FieldEnum.STRING),
                new FieldConfig("status", FieldEnum.STRING),
                new FieldConfig("updateTime", FieldEnum.DATE)
        )));

        sheetMap.put("逾期及违约信息概要", new TableConfig(new SelfOverdueStatsBatchHandler()));

        sheetMap.put("未结清贷款信息汇总", new TableConfig(new DefaultExcelHandler<SelfUnclearedLoanStats>(SelfUnclearedLoanStats.class, 2, 0,
                new FieldConfig("count", FieldEnum.INTEGER),
                new FieldConfig("totalFee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE)
        )));

        sheetMap.put("未销户贷记卡信息汇总", new TableConfig(new DefaultExcelHandler<SelfDebitCardStats>(SelfDebitCardStats.class, 2, 0,
                new FieldConfig("totalCreditFee", FieldEnum.DOUBLE),
                new FieldConfig("maxCreditFee", FieldEnum.DOUBLE),
                new FieldConfig("usedFee", FieldEnum.DOUBLE)
        )));

        sheetMap.put("未销户准贷记卡信息汇总", new TableConfig(new DefaultExcelHandler<SelfSemiCardStats>(SelfSemiCardStats.class, 2, 0,
                new FieldConfig("totalCreditFee", FieldEnum.DOUBLE),
                new FieldConfig("maxCreditFee", FieldEnum.DOUBLE),
                new FieldConfig("overDrawFee", FieldEnum.DOUBLE)
        )));

        config.put("基本信息", sheetMap);
    }

    //贷款
    static {
        Map<String, TableConfig> sheetMap = new HashMap<>();
        sheetMap.put("贷款", new TableConfig(new SelfLoanDtoExcelHandler()));
        config.put("贷款", sheetMap);
    }

    //贷记卡
    static {
        Map<String, TableConfig> sheetMap = new HashMap<>();
        sheetMap.put("贷记卡", new TableConfig(new SelfDebitCardExcelHandler()));
        config.put("贷记卡", sheetMap);
    }

    //准贷记卡
    static {
        Map<String, TableConfig> sheetMap = new HashMap<>();
        sheetMap.put("准贷记卡", new TableConfig(new SelfSemiCardDtoExcelHanlder()));
        config.put("准贷记卡", sheetMap);
    }

    //住房公积金参缴记录
    static {
        Map<String, TableConfig> sheetMap = new HashMap<>();
        sheetMap.put("住房公积金参缴记录", new TableConfig(new DefaultBatchExcelHandler<SelfHouseFund>(SelfHouseFund.class, 2, 0,
                new FieldConfig("state", FieldEnum.STRING),
                new FieldConfig("monthPaymentFee", FieldEnum.DOUBLE)
        )));
        config.put("住房公积金参缴记录", sheetMap);
    }

    //查询记录汇总
    static {
        Map<String, TableConfig> sheetMap = new HashMap<>();
        sheetMap.put("查询记录汇总", new TableConfig(new DefaultExcelHandler<SelfSearchRecord>(SelfSearchRecord.class, 3, 0,
                new FieldConfig("institutionSearchByLoan", FieldEnum.INTEGER),
                new FieldConfig("institutionSearchByCreditCard", FieldEnum.INTEGER),
                new FieldConfig("searchByLoan", FieldEnum.INTEGER),
                new FieldConfig("searchByCreditCard", FieldEnum.INTEGER),
                new FieldConfig("searchBySelf", FieldEnum.INTEGER),
                new FieldConfig("searchByPostLoan", FieldEnum.INTEGER),
                new FieldConfig("searchByGuarantee", FieldEnum.INTEGER),
                new FieldConfig("searchBySpecialMerchant", FieldEnum.INTEGER)
        )));

        sheetMap.put("信贷审批查询记录明细", new TableConfig(new DefaultBatchExcelHandler<SelfLoanApprovalRecord>(SelfLoanApprovalRecord.class, 2, 0,
                new FieldConfig("searchDate", FieldEnum.DATE),
                new FieldConfig("operator", FieldEnum.STRING),
                new FieldConfig("queryCause", FieldEnum.STRING)
        )));
        config.put("查询记录汇总", sheetMap);
    }

    /**
     * @param sheetName
     * @param tableName
     * @return TableConfig
     */
    public static TableConfig getTableConfig(String sheetName, String tableName) {
        Map<String, TableConfig> tableConfigMap = config.get(sheetName);
        if (tableConfigMap == null || tableConfigMap.isEmpty()) {
            return null;
        } else {
            return tableConfigMap.get(tableName);
        }
    }
}
