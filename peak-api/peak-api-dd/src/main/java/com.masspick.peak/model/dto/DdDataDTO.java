package com.masspick.peak.model.dto;

import java.util.Date;

/**
 * Created by admin on 2018/7/26 0026.
 */
public class DdDataDTO {

    /**
     * UUID
     */
    private String id;

    /**
     * 外部id
     */
    private String outId;

    /**
     * 流程id
     */
    private String processInstanceId;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 企业类型
     */
    private String companyType;

    /**
     * 企业id
     */
    private String companyId;

    /**
     * 尽调模板id
     */
    private String templateId;

    /**
     * 状态：
     */
    private Integer state;

    /**
     * 任务编号
     */
    private String taskNum;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 地址 尽调公司地址
     */
    private String address;

    /**
     * 区域经理
     */
    private String manager;

    /**
     * 尽调员
     */
    private String executor;

    /**
     * 尽调员 id
     */
    private String executorId;

    /**
     * 公司法人
     */
    private String legalRep;

    /**
     * 法人电话
     */
    private String phone;

    /**
     * 接收时间
     */
    private Date receiveDate;

    /**
     * 完成时间
     */
    private Date finishDate;

    /**
     * 拒绝理由
     */
    private String reason;

    /**
     * 描述
     */
    private String desc;

    /**
     * 预约时间
     */
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private Date appointmentDate;

    /**
     * 拒绝日期
     */
    private Date refuseDate;

    /**
     * Gets id
     *
     * @return value of id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets outId
     *
     * @return value of outId
     */
    public String getOutId() {
        return outId;
    }

    /**
     * @param outId
     */
    public void setOutId(String outId) {
        this.outId = outId;
    }

    /**
     * Gets processInstanceId
     *
     * @return value of processInstanceId
     */
    public String getProcessInstanceId() {
        return processInstanceId;
    }

    /**
     * @param processInstanceId
     */
    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    /**
     * Gets name
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets companyName
     *
     * @return value of companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Gets companyType
     *
     * @return value of companyType
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * @param companyType
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    /**
     * Gets companyId
     *
     * @return value of companyId
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * Gets templateId
     *
     * @return value of templateId
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * @param templateId
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * Gets state
     *
     * @return value of state
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * Gets taskNum
     *
     * @return value of taskNum
     */
    public String getTaskNum() {
        return taskNum;
    }

    /**
     * @param taskNum
     */
    public void setTaskNum(String taskNum) {
        this.taskNum = taskNum;
    }

    /**
     * Gets province
     *
     * @return value of province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Gets city
     *
     * @return value of city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets area
     *
     * @return value of area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * Gets address
     *
     * @return value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets manager
     *
     * @return value of manager
     */
    public String getManager() {
        return manager;
    }

    /**
     * @param manager
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * Gets executor
     *
     * @return value of executor
     */
    public String getExecutor() {
        return executor;
    }

    /**
     * @param executor
     */
    public void setExecutor(String executor) {
        this.executor = executor;
    }

    /**
     * Gets executorId
     *
     * @return value of executorId
     */
    public String getExecutorId() {
        return executorId;
    }

    /**
     * @param executorId
     */
    public void setExecutorId(String executorId) {
        this.executorId = executorId;
    }

    /**
     * Gets legalRep
     *
     * @return value of legalRep
     */
    public String getLegalRep() {
        return legalRep;
    }

    /**
     * @param legalRep
     */
    public void setLegalRep(String legalRep) {
        this.legalRep = legalRep;
    }

    /**
     * Gets phone
     *
     * @return value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets receiveDate
     *
     * @return value of receiveDate
     */
    public Date getReceiveDate() {
        return receiveDate;
    }

    /**
     * @param receiveDate
     */
    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    /**
     * Gets finishDate
     *
     * @return value of finishDate
     */
    public Date getFinishDate() {
        return finishDate;
    }

    /**
     * @param finishDate
     */
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    /**
     * Gets reason
     *
     * @return value of reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Gets desc
     *
     * @return value of desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Gets appointmentDate
     *
     * @return value of appointmentDate
     */
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * @param appointmentDate
     */
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /**
     * Gets refuseDate
     *
     * @return value of refuseDate
     */
    public Date getRefuseDate() {
        return refuseDate;
    }

    /**
     * @param refuseDate
     */
    public void setRefuseDate(Date refuseDate) {
        this.refuseDate = refuseDate;
    }
}
