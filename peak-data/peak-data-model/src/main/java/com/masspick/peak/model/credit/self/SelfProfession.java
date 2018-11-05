package com.masspick.peak.model.credit.self;

/**
 * self_profession
 * 职业信息
 */
public class SelfProfession {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 工作单位
     */
    private String workUnit;

    /**
     * 单位地址
     */
    private String workUnitAddress;

    /**
     * profession
     */
    private String profession;

    /**
     * industry
     */
    private String industry;

    /**
     * post
     */
    private String post;

    /**
     * title
     */
    private String title;

    /**
     * entryYear
     */
    private String entryYear;

    /**
     * updateTime
     */
    private String updateTime;

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
     * 工作单位
     *
     * @return work_unit 工作单位
     */
    public String getWorkUnit() {
        return workUnit;
    }

    /**
     * 工作单位
     *
     * @param workUnit 工作单位
     */
    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit == null ? null : workUnit.trim();
    }

    /**
     * 单位地址
     *
     * @return work_unit_address 单位地址
     */
    public String getWorkUnitAddress() {
        return workUnitAddress;
    }

    /**
     * 单位地址
     *
     * @param workUnitAddress 单位地址
     */
    public void setWorkUnitAddress(String workUnitAddress) {
        this.workUnitAddress = workUnitAddress == null ? null : workUnitAddress.trim();
    }

    /**
     * profession
     *
     * @return profession profession
     */
    public String getProfession() {
        return profession;
    }

    /**
     * profession
     *
     * @param profession profession
     */
    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    /**
     * industry
     *
     * @return industry industry
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * industry
     *
     * @param industry industry
     */
    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    /**
     * post
     *
     * @return post post
     */
    public String getPost() {
        return post;
    }

    /**
     * post
     *
     * @param post post
     */
    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }

    /**
     * title
     *
     * @return title title
     */
    public String getTitle() {
        return title;
    }

    /**
     * title
     *
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * entryYear
     *
     * @return entry_year entryYear
     */
    public String getEntryYear() {
        return entryYear;
    }

    /**
     * entryYear
     *
     * @param entryYear entryYear
     */
    public void setEntryYear(String entryYear) {
        this.entryYear = entryYear == null ? null : entryYear.trim();
    }

    /**
     * updateTime
     *
     * @return update_time updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * updateTime
     *
     * @param updateTime updateTime
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}
