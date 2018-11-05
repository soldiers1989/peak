package com.masspick.peak.model.credit.etp;

/**
 * etp_related
 * 关联企业
 */
public class EtpRelated {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 关联企业
     */
    private String entName;

    /**
     * 中征码
     */
    private String eigenCode;

    /**
     * 关系
     */
    private String relateType;

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
     * 关联企业
     *
     * @return ent_name 关联企业
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 关联企业
     *
     * @param entName 关联企业
     */
    public void setEntName(String entName) {
        this.entName = entName == null ? null : entName.trim();
    }

    /**
     * 中征码
     *
     * @return eigen_code 中征码
     */
    public String getEigenCode() {
        return eigenCode;
    }

    /**
     * 中征码
     *
     * @param eigenCode 中征码
     */
    public void setEigenCode(String eigenCode) {
        this.eigenCode = eigenCode == null ? null : eigenCode.trim();
    }

    /**
     * 关系
     *
     * @return relate_type 关系
     */
    public String getRelateType() {
        return relateType;
    }

    /**
     * 关系
     *
     * @param relateType 关系
     */
    public void setRelateType(String relateType) {
        this.relateType = relateType == null ? null : relateType.trim();
    }
}
