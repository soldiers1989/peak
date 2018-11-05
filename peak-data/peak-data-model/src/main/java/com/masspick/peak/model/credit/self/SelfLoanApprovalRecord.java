package com.masspick.peak.model.credit.self;

import java.util.Date;

/**
 * self_loan_approval_record
 * 贷款审批查询记录
 */
public class SelfLoanApprovalRecord {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 查询日期
     */
    private Date searchDate;

    /**
     * 查询操作员
     */
    private String operator;

    /**
     * 查询原因
     */
    private String queryCause;

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
     * 征信报告id
     *
     * @return report_id 征信报告id
     */
    public String getReportId() {
        return reportId;
    }

    /**
     * 征信报告id
     *
     * @param reportId 征信报告id
     */
    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    /**
     * 查询日期
     *
     * @return search_date 查询日期
     */
    public Date getSearchDate() {
        return searchDate;
    }

    /**
     * 查询日期
     *
     * @param searchDate 查询日期
     */
    public void setSearchDate(Date searchDate) {
        this.searchDate = searchDate;
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
}
