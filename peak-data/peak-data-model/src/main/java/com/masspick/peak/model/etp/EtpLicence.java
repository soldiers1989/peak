package com.masspick.peak.model.etp;

import java.util.Date;

/**
 * EtpLicence
 */
public class EtpLicence {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.id
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.etp_id
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private String etpId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.license_number
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private String licenseNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.license_name
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private String licenseName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.license_office
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private String licenseOffice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.license_content
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private String licenseContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.start_date
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private Date startDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.finish_date
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private Date finishDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.public_date
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private Date publicDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.type
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.out_id
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private String outId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.crawl_time
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private Date crawlTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.cancel_date
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private Date cancelDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.cancel_reason
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private String cancelReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.invalid_reason
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private String invalidReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.status
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.is_public
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private String isPublic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.invalid_date
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private Date invalidDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.last_modified_person
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private String lastModifiedPerson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.etp_licence_all.last_modified_time
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    private Date lastModifiedTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.id
     *
     * @return the value of public.etp_licence_all.id
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.id
     *
     * @param id the value for public.etp_licence_all.id
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.etp_id
     *
     * @return the value of public.etp_licence_all.etp_id
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public String getEtpId() {
        return etpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.etp_id
     *
     * @param etpId the value for public.etp_licence_all.etp_id
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setEtpId(String etpId) {
        this.etpId = etpId == null ? null : etpId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.license_number
     *
     * @return the value of public.etp_licence_all.license_number
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.license_number
     *
     * @param licenseNumber the value for public.etp_licence_all.license_number
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber == null ? null : licenseNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.license_name
     *
     * @return the value of public.etp_licence_all.license_name
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public String getLicenseName() {
        return licenseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.license_name
     *
     * @param licenseName the value for public.etp_licence_all.license_name
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName == null ? null : licenseName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.license_office
     *
     * @return the value of public.etp_licence_all.license_office
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public String getLicenseOffice() {
        return licenseOffice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.license_office
     *
     * @param licenseOffice the value for public.etp_licence_all.license_office
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setLicenseOffice(String licenseOffice) {
        this.licenseOffice = licenseOffice == null ? null : licenseOffice.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.license_content
     *
     * @return the value of public.etp_licence_all.license_content
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public String getLicenseContent() {
        return licenseContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.license_content
     *
     * @param licenseContent the value for public.etp_licence_all.license_content
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setLicenseContent(String licenseContent) {
        this.licenseContent = licenseContent == null ? null : licenseContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.start_date
     *
     * @return the value of public.etp_licence_all.start_date
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.start_date
     *
     * @param startDate the value for public.etp_licence_all.start_date
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.finish_date
     *
     * @return the value of public.etp_licence_all.finish_date
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public Date getFinishDate() {
        return finishDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.finish_date
     *
     * @param finishDate the value for public.etp_licence_all.finish_date
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.public_date
     *
     * @return the value of public.etp_licence_all.public_date
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public Date getPublicDate() {
        return publicDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.public_date
     *
     * @param publicDate the value for public.etp_licence_all.public_date
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.type
     *
     * @return the value of public.etp_licence_all.type
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.type
     *
     * @param type the value for public.etp_licence_all.type
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.out_id
     *
     * @return the value of public.etp_licence_all.out_id
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public String getOutId() {
        return outId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.out_id
     *
     * @param outId the value for public.etp_licence_all.out_id
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setOutId(String outId) {
        this.outId = outId == null ? null : outId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.crawl_time
     *
     * @return the value of public.etp_licence_all.crawl_time
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public Date getCrawlTime() {
        return crawlTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.crawl_time
     *
     * @param crawlTime the value for public.etp_licence_all.crawl_time
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setCrawlTime(Date crawlTime) {
        this.crawlTime = crawlTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.cancel_date
     *
     * @return the value of public.etp_licence_all.cancel_date
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public Date getCancelDate() {
        return cancelDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.cancel_date
     *
     * @param cancelDate the value for public.etp_licence_all.cancel_date
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.cancel_reason
     *
     * @return the value of public.etp_licence_all.cancel_reason
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public String getCancelReason() {
        return cancelReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.cancel_reason
     *
     * @param cancelReason the value for public.etp_licence_all.cancel_reason
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason == null ? null : cancelReason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.invalid_reason
     *
     * @return the value of public.etp_licence_all.invalid_reason
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public String getInvalidReason() {
        return invalidReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.invalid_reason
     *
     * @param invalidReason the value for public.etp_licence_all.invalid_reason
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setInvalidReason(String invalidReason) {
        this.invalidReason = invalidReason == null ? null : invalidReason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.status
     *
     * @return the value of public.etp_licence_all.status
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.status
     *
     * @param status the value for public.etp_licence_all.status
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.is_public
     *
     * @return the value of public.etp_licence_all.is_public
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public String getIsPublic() {
        return isPublic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.is_public
     *
     * @param isPublic the value for public.etp_licence_all.is_public
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic == null ? null : isPublic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.invalid_date
     *
     * @return the value of public.etp_licence_all.invalid_date
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public Date getInvalidDate() {
        return invalidDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.invalid_date
     *
     * @param invalidDate the value for public.etp_licence_all.invalid_date
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setInvalidDate(Date invalidDate) {
        this.invalidDate = invalidDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.last_modified_person
     *
     * @return the value of public.etp_licence_all.last_modified_person
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public String getLastModifiedPerson() {
        return lastModifiedPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.last_modified_person
     *
     * @param lastModifiedPerson the value for public.etp_licence_all.last_modified_person
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setLastModifiedPerson(String lastModifiedPerson) {
        this.lastModifiedPerson = lastModifiedPerson == null ? null : lastModifiedPerson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.etp_licence_all.last_modified_time
     *
     * @return the value of public.etp_licence_all.last_modified_time
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.etp_licence_all.last_modified_time
     *
     * @param lastModifiedTime the value for public.etp_licence_all.last_modified_time
     *
     * @mbggenerated Mon Jun 11 16:05:10 CST 2018
     */
    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
}
