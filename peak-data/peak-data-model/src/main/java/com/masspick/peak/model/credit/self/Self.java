package com.masspick.peak.model.credit.self;

/**
 * self
 * 身份信息
 */
public class Self {
    /**
     * id
     */
    private String id;

    /**
     * 征信报告id
     */
    private String reportId;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生日期
     */
    private String birth;

    /**
     * 婚姻状况
     */
    private String maritalStatus;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 单位电话
     */
    private String workUnitPhone;

    /**
     * 住宅电话
     */
    private String homePhone;

    /**
     * 学历
     */
    private String education;

    /**
     * 学位
     */
    private String degree;

    /**
     * 通讯地址
     */
    private String address;

    /**
     * 户籍地址
     */
    private String houseAddress;

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
     * 性别
     *
     * @return sex 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 出生日期
     *
     * @return birth 出生日期
     */
    public String getBirth() {
        return birth;
    }

    /**
     * 出生日期
     *
     * @param birth 出生日期
     */
    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
    }

    /**
     * 婚姻状况
     *
     * @return marital_status 婚姻状况
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * 婚姻状况
     *
     * @param maritalStatus 婚姻状况
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus == null ? null : maritalStatus.trim();
    }

    /**
     * 手机号码
     *
     * @return phone 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 单位电话
     *
     * @return work_unit_phone 单位电话
     */
    public String getWorkUnitPhone() {
        return workUnitPhone;
    }

    /**
     * 单位电话
     *
     * @param workUnitPhone 单位电话
     */
    public void setWorkUnitPhone(String workUnitPhone) {
        this.workUnitPhone = workUnitPhone == null ? null : workUnitPhone.trim();
    }

    /**
     * 住宅电话
     *
     * @return home_phone 住宅电话
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * 住宅电话
     *
     * @param homePhone 住宅电话
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone == null ? null : homePhone.trim();
    }

    /**
     * 学历
     *
     * @return education 学历
     */
    public String getEducation() {
        return education;
    }

    /**
     * 学历
     *
     * @param education 学历
     */
    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    /**
     * 学位
     *
     * @return degree 学位
     */
    public String getDegree() {
        return degree;
    }

    /**
     * 学位
     *
     * @param degree 学位
     */
    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

    /**
     * 通讯地址
     *
     * @return address 通讯地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 通讯地址
     *
     * @param address 通讯地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 户籍地址
     *
     * @return house_address 户籍地址
     */
    public String getHouseAddress() {
        return houseAddress;
    }

    /**
     * 户籍地址
     *
     * @param houseAddress 户籍地址
     */
    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress == null ? null : houseAddress.trim();
    }
}
