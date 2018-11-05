package com.masspick.peak.excel.config;



import com.masspick.peak.excel.handler.impl.DefaultBatchExcelHandler;
import com.masspick.peak.excel.handler.impl.DefaultExcelHandler;
import com.masspick.peak.excel.handler.impl.EtpDebtStatsExcelHandler;
import com.masspick.peak.excel.handler.impl.EtpLoanDebtStatsClearedExcelHandler;
import com.masspick.peak.excel.translator.impl.DefaultValueTranslator;
import com.masspick.peak.excel.translator.impl.FiveClassifyTranslator;
import com.masspick.peak.model.credit.etp.EtpAdvances;
import com.masspick.peak.model.credit.etp.EtpBA;
import com.masspick.peak.model.credit.etp.EtpBD;
import com.masspick.peak.model.credit.etp.EtpCreditReport;
import com.masspick.peak.model.credit.etp.EtpDebitHistory;
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

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/14.
 */
public final class EtpCreditExcelConfig {

    private EtpCreditExcelConfig() {
    }

    /**
     * config
     */
    private static Map<String, Map<String, TableConfig>> config = new HashMap<>();

    //信息概要
    static {
        Map<String, TableConfig> sheetMap = new HashMap<>();
        sheetMap.put("基本信息", new TableConfig(new DefaultExcelHandler<EtpCreditReport>(EtpCreditReport.class, 2, 0,
                new FieldConfig("entName", FieldEnum.STRING),
                new FieldConfig("reportDate", FieldEnum.DATE),
                new FieldConfig("eigenCode", FieldEnum.STRING)
        )));
        sheetMap.put("当前负债信息概要", new TableConfig(new EtpDebtStatsExcelHandler()));
        sheetMap.put("当前债务统计信息", new TableConfig(new DefaultBatchExcelHandler<EtpLoanDebtStats>(EtpLoanDebtStats.class, 3, 0,
                new FieldConfig("category", FieldEnum.STRING),
                new FieldConfig("normalCount", FieldEnum.INTEGER),
                new FieldConfig("normalBalance", FieldEnum.DOUBLE),
                new FieldConfig("attentionCount", FieldEnum.INTEGER),
                new FieldConfig("attentionBalance", FieldEnum.DOUBLE),
                new FieldConfig("problemCount", FieldEnum.INTEGER),
                new FieldConfig("problemBalance", FieldEnum.DOUBLE),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));
        sheetMap.put("已还清债务信息概要", new TableConfig(new EtpLoanDebtStatsClearedExcelHandler()));
        sheetMap.put("对外担保信息概要", new TableConfig(new DefaultBatchExcelHandler<EtpGuaranteeStats>(EtpGuaranteeStats.class, 3, 0,
                new FieldConfig("category", FieldEnum.STRING),
                new FieldConfig("count", FieldEnum.INTEGER),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("normalFee", FieldEnum.DOUBLE),
                new FieldConfig("attentionFee", FieldEnum.DOUBLE),
                new FieldConfig("problemFee", FieldEnum.DOUBLE)
        )));
        sheetMap.put("负债变化历史", new TableConfig(new DefaultBatchExcelHandler<EtpDebitHistory>(EtpDebitHistory.class, 2, 0,
                new FieldConfig("reportDate", FieldEnum.DATE),
                new FieldConfig("totalDebitFee", FieldEnum.DOUBLE),
                new FieldConfig("abnormalDebitFee", FieldEnum.DOUBLE)
        )));
        config.put("信息概要", sheetMap);
    }

    //不良和违约类债务
    static {
        Map<String, TableConfig> sheetMap = new HashMap<>();
        sheetMap.put("贷款", new TableConfig(new DefaultBatchExcelHandler<EtpLoan>(EtpLoan.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("classify", FieldEnum.INTEGER, new FiveClassifyTranslator()),
                new FieldConfig("curType", FieldEnum.STRING),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        sheetMap.put("类贷款", new TableConfig(new DefaultBatchExcelHandler<EtpOtherLoan>(EtpOtherLoan.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("classify", FieldEnum.INTEGER, new FiveClassifyTranslator()),
                new FieldConfig("bussType", FieldEnum.STRING),
                new FieldConfig("curType", FieldEnum.STRING),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));
        sheetMap.put("贸易融资", new TableConfig(new DefaultBatchExcelHandler<EtpTradeFinancing>(EtpTradeFinancing.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("classify", FieldEnum.INTEGER, new FiveClassifyTranslator()),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("startDate", FieldEnum.DATE),
                new FieldConfig("expiredDate", FieldEnum.DATE),
                new FieldConfig("guarantee", FieldEnum.STRING),
                new FieldConfig("extension", FieldEnum.STRING),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        sheetMap.put("保理", new TableConfig(new DefaultBatchExcelHandler<EtpFactoring>(EtpFactoring.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("classify", FieldEnum.INTEGER, new FiveClassifyTranslator()),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("guarantee", FieldEnum.STRING),
                new FieldConfig("advances", FieldEnum.STRING),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        sheetMap.put("银行承兑汇票", new TableConfig(new DefaultBatchExcelHandler<EtpBA>(EtpBA.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("classify", FieldEnum.INTEGER, new FiveClassifyTranslator()),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("bailRate", FieldEnum.DOUBLE),
                new FieldConfig("guarantee", FieldEnum.STRING),
                new FieldConfig("advances", FieldEnum.STRING),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        sheetMap.put("信用证", new TableConfig(new DefaultBatchExcelHandler<EtpLC>(EtpLC.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("classify", FieldEnum.INTEGER, new FiveClassifyTranslator()),
                new FieldConfig("bailRate", FieldEnum.DOUBLE),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("guarantee", FieldEnum.STRING),
                new FieldConfig("advances", FieldEnum.STRING),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        sheetMap.put("保函", new TableConfig(new DefaultBatchExcelHandler<EtpGuaranteeLetter>(EtpGuaranteeLetter.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("classify", FieldEnum.INTEGER, new FiveClassifyTranslator()),
                new FieldConfig("bailRate", FieldEnum.DOUBLE),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("guarantee", FieldEnum.STRING),
                new FieldConfig("extension", FieldEnum.STRING),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        config.put("不良和违约类债务", sheetMap);
    }

    //关注类债务
    static {
        Map<String, TableConfig> sheetMap = new HashMap<>();
        sheetMap.put("贷款", new TableConfig(new DefaultBatchExcelHandler<EtpLoan>(EtpLoan.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("bussType", FieldEnum.STRING),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("expiredDate", FieldEnum.DATE),
                new FieldConfig("classify", FieldEnum.INTEGER, new DefaultValueTranslator("2")),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        sheetMap.put("贸易融资", new TableConfig(new DefaultBatchExcelHandler<EtpTradeFinancing>(EtpTradeFinancing.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("classify", FieldEnum.INTEGER, new FiveClassifyTranslator()),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("expiredDate", FieldEnum.DATE),
                new FieldConfig("extension", FieldEnum.STRING),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        sheetMap.put("保理", new TableConfig(new DefaultBatchExcelHandler<EtpFactoring>(EtpFactoring.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("classify", FieldEnum.INTEGER, new FiveClassifyTranslator()),
                new FieldConfig("advances", FieldEnum.STRING),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        sheetMap.put("票据贴现", new TableConfig(new DefaultBatchExcelHandler<EtpBD>(EtpBD.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("expiredDate", FieldEnum.DATE),
                new FieldConfig("classify", FieldEnum.INTEGER, new FiveClassifyTranslator()),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        sheetMap.put("银行承兑汇票", new TableConfig(new DefaultBatchExcelHandler<EtpBA>(EtpBA.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("expiredDate", FieldEnum.DATE),
                new FieldConfig("bailRate", FieldEnum.DOUBLE),
                new FieldConfig("classify", FieldEnum.INTEGER, new FiveClassifyTranslator()),
                new FieldConfig("advances", FieldEnum.STRING),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));


        sheetMap.put("信用证", new TableConfig(new DefaultBatchExcelHandler<EtpLC>(EtpLC.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("bailRate", FieldEnum.DOUBLE),
                new FieldConfig("classify", FieldEnum.INTEGER, new FiveClassifyTranslator()),
                new FieldConfig("advances", FieldEnum.STRING),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        sheetMap.put("保函", new TableConfig(new DefaultBatchExcelHandler<EtpGuaranteeLetter>(EtpGuaranteeLetter.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("bailRate", FieldEnum.DOUBLE),
                new FieldConfig("classify", FieldEnum.INTEGER, new FiveClassifyTranslator()),
                new FieldConfig("extension", FieldEnum.STRING),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        config.put("关注类债务", sheetMap);
    }

    //正常类债务
    static {
        Map<String, TableConfig> sheetMap = new HashMap<>();
        sheetMap.put("贷款", new TableConfig(new DefaultBatchExcelHandler<EtpLoan>(EtpLoan.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("startDate", FieldEnum.DATE),
                new FieldConfig("expiredDate", FieldEnum.DATE),
                new FieldConfig("guarantee", FieldEnum.STRING),
                new FieldConfig("extension", FieldEnum.STRING),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1")),
                new FieldConfig("classify", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        sheetMap.put("类贷款", new TableConfig(new DefaultBatchExcelHandler<EtpOtherLoan>(EtpOtherLoan.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("startDate", FieldEnum.DATE),
                new FieldConfig("settledDate", FieldEnum.DATE),
                new FieldConfig("guarantee", FieldEnum.STRING),
                new FieldConfig("extension", FieldEnum.STRING),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1")),
                new FieldConfig("classify", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        sheetMap.put("贸易融资", new TableConfig(new DefaultBatchExcelHandler<EtpTradeFinancing>(EtpTradeFinancing.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("startDate", FieldEnum.DATE),
                new FieldConfig("expiredDate", FieldEnum.DATE),
                new FieldConfig("guarantee", FieldEnum.STRING),
                new FieldConfig("extension", FieldEnum.STRING),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1")),
                new FieldConfig("classify", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        sheetMap.put("保理", new TableConfig(new DefaultBatchExcelHandler<EtpFactoring>(EtpFactoring.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("financeDate", FieldEnum.DATE),
                new FieldConfig("guarantee", FieldEnum.STRING),
                new FieldConfig("advances", FieldEnum.STRING),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1")),
                new FieldConfig("classify", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        sheetMap.put("票据贴现", new TableConfig(new DefaultBatchExcelHandler<EtpBD>(EtpBD.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("count", FieldEnum.INTEGER),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1")),
                new FieldConfig("classify", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        sheetMap.put("银行承兑", new TableConfig(new DefaultBatchExcelHandler<EtpBA>(EtpBA.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("count", FieldEnum.INTEGER),
                new FieldConfig("thirtyOverFee", FieldEnum.DOUBLE),
                new FieldConfig("sixtyOverFee", FieldEnum.DOUBLE),
                new FieldConfig("ninetyOverFee", FieldEnum.DOUBLE),
                new FieldConfig("greaterNinetyOverFee", FieldEnum.DOUBLE),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1")),
                new FieldConfig("classify", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));


        sheetMap.put("信用证", new TableConfig(new DefaultBatchExcelHandler<EtpLC>(EtpLC.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("count", FieldEnum.INTEGER),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1")),
                new FieldConfig("classify", FieldEnum.INTEGER, new DefaultValueTranslator("1"))
        )));

        sheetMap.put("保函", new TableConfig(new DefaultBatchExcelHandler<EtpGuaranteeLetter>(EtpGuaranteeLetter.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("count", FieldEnum.INTEGER),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("overFee", FieldEnum.DOUBLE),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("1")),
                new FieldConfig("classify", FieldEnum.INTEGER, new DefaultValueTranslator("1"))

        )));

        config.put("正常类债务", sheetMap);
    }

    //已还清债务
    static {
        Map<String, TableConfig> sheetMap = new HashMap<>();
        sheetMap.put("担保及第三方代偿信息", new TableConfig(new DefaultBatchExcelHandler<EtpGuarantee>(EtpGuarantee.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("lastCompensatoryDate", FieldEnum.DATE),
                new FieldConfig("totalCompensatoryFee", FieldEnum.DOUBLE),
                new FieldConfig("settledDate", FieldEnum.DATE),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("2"))
        )));

        sheetMap.put("欠息", new TableConfig(new DefaultBatchExcelHandler<EtpInterest>(EtpInterest.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("maxFee", FieldEnum.DOUBLE),
                new FieldConfig("financeDate", FieldEnum.DATE),
                new FieldConfig("settledDate", FieldEnum.DATE),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("2"))
        )));

        sheetMap.put("垫款", new TableConfig(new DefaultBatchExcelHandler<EtpAdvances>(EtpAdvances.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("advancesOverFee", FieldEnum.DOUBLE),
                new FieldConfig("advancesDate", FieldEnum.DATE),
                new FieldConfig("settledDate", FieldEnum.DATE),
                new FieldConfig("classify", FieldEnum.INTEGER, new FiveClassifyTranslator()),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("2"))
        )));

        sheetMap.put("贷款", new TableConfig(new DefaultBatchExcelHandler<EtpLoan>(EtpLoan.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("expiredDate", FieldEnum.DATE),
                new FieldConfig("settledDate", FieldEnum.DATE),
                new FieldConfig("settledMethod", FieldEnum.STRING),
                new FieldConfig("classify", FieldEnum.INTEGER, new FiveClassifyTranslator()),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("2"))
        )));

        sheetMap.put("类贷款", new TableConfig(new DefaultBatchExcelHandler<EtpOtherLoan>(EtpOtherLoan.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("bussType", FieldEnum.STRING),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("expiredDate", FieldEnum.DATE),
                new FieldConfig("settledDate", FieldEnum.DATE),
                new FieldConfig("classify", FieldEnum.INTEGER, new FiveClassifyTranslator()),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("2"))
        )));

        sheetMap.put("贸易融资", new TableConfig(new DefaultBatchExcelHandler<EtpTradeFinancing>(EtpTradeFinancing.class, 2, 0,
                new FieldConfig("institution", FieldEnum.STRING),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("expiredDate", FieldEnum.DATE),
                new FieldConfig("settledDate", FieldEnum.DATE),
                new FieldConfig("settledMethod", FieldEnum.STRING),
                new FieldConfig("classify", FieldEnum.INTEGER, new FiveClassifyTranslator()),
                new FieldConfig("state", FieldEnum.INTEGER, new DefaultValueTranslator("2"))
        )));

        config.put("已还清债务", sheetMap);
    }

    static {
        Map<String, TableConfig> sheetMap = new HashMap<>();
        sheetMap.put("对外担保记录", new TableConfig(new DefaultBatchExcelHandler<EtpGuaranteeRecord>(EtpGuaranteeRecord.class, 2, 0,
                new FieldConfig("bussType", FieldEnum.STRING),
                new FieldConfig("guarantor", FieldEnum.STRING),
                new FieldConfig("cardType", FieldEnum.STRING),
                new FieldConfig("guaranteeFee", FieldEnum.DOUBLE),
                new FieldConfig("guaranteeMethod", FieldEnum.STRING)
        )));

        sheetMap.put("欠税记录", new TableConfig(new DefaultBatchExcelHandler<EtpTaxOwed>(EtpTaxOwed.class, 2, 0,
                new FieldConfig("office", FieldEnum.STRING),
                new FieldConfig("fee", FieldEnum.DOUBLE),
                new FieldConfig("recordTime", FieldEnum.DATE)
        )));

        config.put("对外担保记录以及公共信息", sheetMap);
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
