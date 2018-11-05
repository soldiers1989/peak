package com.masspick.peak.model.credit.self;

import java.util.Date;

/**
 * self_credit_report
 * 个人信用报告
 */
public class SelfCreditReport {
    /**
     * id
     */
    private String id;

    /**
     * 被查询者姓名
     */
    private String name;

    /**
     * 被查询者证件类型
     */
    private String cardType;

    /**
     * 被查询者证件号码
     */
    private String cardNo;

    /**
     * 查询操作员
     */
    private String operator;

    /**
     * 查询原因
     */
    private String queryCause;

    /**
     * 查询请求时间
     */
    private Date queryTime;

    /**
     * 报告时间
     */
    private Date reportTime;

    /**
     * id
     *
     * @return id id
     */
    public String getId() {
        return id;
    }

    /**
     * id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 被查询者姓名
     *
     * @return name 被查询者姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 被查询者姓名
     *
     * @param name 被查询者姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 被查询者证件类型
     *
     * @return card_type 被查询者证件类型
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * 被查询者证件类型
     *
     * @param cardType 被查询者证件类型
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * 被查询者证件号码
     *
     * @return card_no 被查询者证件号码
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 被查询者证件号码
     *
     * @param cardNo 被查询者证件号码
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 查询操作员
     *
     * @return operator 查询操作员
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 查询操作员
     *
     * @param operator 查询操作员
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 查询原因
     *
     * @return query_cause 查询原因
     */
    public String getQueryCause() {
        return queryCause;
    }

    /**
     * 查询原因
     *
     * @param queryCause 查询原因
     */
    public void setQueryCause(String queryCause) {
        this.queryCause = queryCause == null ? null : queryCause.trim();
    }

    /**
     * 查询请求时间
     *
     * @return query_time 查询请求时间
     */
    public Date getQueryTime() {
        return queryTime;
    }

    /**
     * 查询请求时间
     *
     * @param queryTime 查询请求时间
     */
    public void setQueryTime(Date queryTime) {
        this.queryTime = queryTime;
    }

    /**
     * 报告时间
     *
     * @return report_time 报告时间
     */
    public Date getReportTime() {
        return reportTime;
    }

    /**
     * 报告时间
     *
     * @param reportTime 报告时间
     */
    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }
}
