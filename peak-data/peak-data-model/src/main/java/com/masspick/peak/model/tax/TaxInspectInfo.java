package com.masspick.peak.model.tax;

/**
 * TaxInspectInfo
 */
public class TaxInspectInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tax_inspect_info.id
     *
     * @mbggenerated Mon Jun 11 12:20:29 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tax_inspect_info.case_no
     *
     * @mbggenerated Mon Jun 11 12:20:29 CST 2018
     */
    private String caseNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tax_inspect_info.case_category
     *
     * @mbggenerated Mon Jun 11 12:20:29 CST 2018
     */
    private String caseCategory;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tax_inspect_info.close_date
     *
     * @mbggenerated Mon Jun 11 12:20:29 CST 2018
     */

    private String inspectContent;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tax_inspect_info.close_date
     *
     * @mbggenerated Mon Jun 11 12:20:29 CST 2018
     */
    private String inspectConclusion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tax_inspect_info.close_date
     *
     * @mbggenerated Mon Jun 11 12:20:29 CST 2018
     */
    private String closeDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tax_inspect_info.id
     *
     * @return the value of tax_inspect_info.id
     * @mbggenerated Mon Jun 11 12:20:29 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tax_inspect_info.id
     *
     * @param id the value for tax_inspect_info.id
     * @mbggenerated Mon Jun 11 12:20:29 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tax_inspect_info.case_no
     *
     * @return the value of tax_inspect_info.case_no
     * @mbggenerated Mon Jun 11 12:20:29 CST 2018
     */
    public String getCaseNo() {
        return caseNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tax_inspect_info.case_no
     *
     * @param caseNo the value for tax_inspect_info.case_no
     * @mbggenerated Mon Jun 11 12:20:29 CST 2018
     */
    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo == null ? null : caseNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tax_inspect_info.case_category
     *
     * @return the value of tax_inspect_info.case_category
     * @mbggenerated Mon Jun 11 12:20:29 CST 2018
     */
    public String getCaseCategory() {
        return caseCategory;
    }

    /**
     * @param caseCategory
     */
    public void setCaseCategory(String caseCategory) {
        this.caseCategory = caseCategory;
    }

    /**
     * Gets inspectContent
     *
     * @return value of inspectContent
     */
    public String getInspectContent() {
        return inspectContent;
    }

    /**
     * @param inspectContent
     */
    public void setInspectContent(String inspectContent) {
        this.inspectContent = inspectContent;
    }

    /**
     * Gets inspectConclusion
     *
     * @return value of inspectConclusion
     */
    public String getInspectConclusion() {
        return inspectConclusion;
    }

    /**
     * @param inspectConclusion
     */
    public void setInspectConclusion(String inspectConclusion) {
        this.inspectConclusion = inspectConclusion;
    }

    /**
     * Gets closeDate
     *
     * @return value of closeDate
     */
    public String getCloseDate() {
        return closeDate;
    }

    /**
     * @param closeDate
     */
    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }
}
