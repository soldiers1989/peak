package com.masspick.peak.dd.controller.vo;

import com.masspick.peak.common.util.DateUtils;
import com.masspick.peak.dd.model.DueTask;
import com.masspick.peak.dd.model.bo.DueTaskBO;
import org.apache.commons.lang3.StringUtils;
import java.util.Locale;

/**
 * Created by admin on 2018/5/18 0018.
 */
public class DueTaskVO extends DueTask {

    /**
     * templateName
     */
    private String templateName;
    /**
     * 接收时间 转换
     */
    private String receiveDateStr;

    /**
     * finishDateStr
     */
    private String finishDateStr;

    /**
     * appointmentDateStr
     */
    private String appointmentDateStr;


    /**
     * DueTaskVO
     */
    public DueTaskVO() {
    }

    /**
     * @param dueTaskVO
     * @param dueTaskBO
     */
    public void transfer(DueTaskVO dueTaskVO, DueTaskBO dueTaskBO) {

        //地区
        StringBuffer stringBuffer = new StringBuffer();
        if (!StringUtils.isEmpty(dueTaskBO.getProvince())) {
            stringBuffer.append(dueTaskBO.getProvince()).append("-");
        }

        if (!StringUtils.isEmpty(dueTaskBO.getCity())) {
            stringBuffer.append(dueTaskBO.getCity()).append("-");
        }

        if (!StringUtils.isEmpty(dueTaskBO.getArea())) {
            stringBuffer.append(dueTaskBO.getArea());
        }

        if (!StringUtils.isEmpty(stringBuffer)) {
            dueTaskVO.setArea(stringBuffer.toString());
        } else {
            dueTaskVO.setArea(dueTaskBO.getAddress());
        }

        dueTaskVO.setLegalRep(dueTaskBO.getLegalRep());
        dueTaskVO.setPhone(dueTaskBO.getPhone());
        dueTaskVO.setId(dueTaskBO.getId());
        dueTaskVO.setName(dueTaskBO.getName());
        dueTaskVO.setCompanyName(dueTaskBO.getCompanyName());
        dueTaskVO.setCompanyType((dueTaskBO.getCompanyType()));
        dueTaskVO.setCompanyId(dueTaskBO.getCompanyId());
        dueTaskVO.setTemplateId(dueTaskBO.getTemplateId());
        dueTaskVO.setState(dueTaskBO.getState());
        dueTaskVO.setTaskNum(dueTaskBO.getTaskNum());
        dueTaskVO.setOutId(dueTaskBO.getOutId());
        dueTaskVO.setProcessInstanceId(dueTaskBO.getProcessInstanceId());
        dueTaskVO.setManager(dueTaskBO.getManager());
        dueTaskVO.setExecutor(dueTaskBO.getExecutor());
        dueTaskVO.setExecutorId(dueTaskBO.getExecutorId());
        dueTaskVO.setReceiveDate(dueTaskBO.getReceiveDate());
        dueTaskVO.setFinishDate(dueTaskBO.getFinishDate());
        dueTaskVO.setAppointmentDate(dueTaskBO.getAppointmentDate());
        dueTaskVO.setReceiveDateStr(dueTaskBO.getReceiveDate() == null ? null : DateUtils.format(dueTaskBO
                .getReceiveDate(), "yyyy-MM-dd aa", Locale.ENGLISH));
        dueTaskVO.setFinishDateStr(dueTaskBO.getFinishDate() == null ? null : DateUtils.format(dueTaskBO
                .getFinishDate(), "yyyy-MM-dd aa", Locale.ENGLISH));
        dueTaskVO.setAppointmentDateStr(dueTaskBO.getAppointmentDate() == null ? null : DateUtils.format(dueTaskBO
                .getAppointmentDate(), "yyyy-MM-dd aa", Locale.ENGLISH));
        dueTaskVO.setCreateTime(dueTaskBO.getCreateTime());
        dueTaskVO.setUpdateTime(dueTaskBO.getUpdateTime());
        dueTaskVO.setCreator(dueTaskBO.getCreator());
        dueTaskVO.setUpdater(dueTaskBO.getUpdater());
        dueTaskVO.setTemplateName(dueTaskBO.getTemplateName());
        dueTaskVO.setProductId(dueTaskBO.getProductId());
        dueTaskVO.setProductName(dueTaskBO.getProductName());
    }

    /**
     * Gets appointmentDateStr
     *
     * @return value of appointmentDateStr
     */
    public String getAppointmentDateStr() {
        return appointmentDateStr;
    }

    /**
     * @param appointmentDateStr
     */
    public void setAppointmentDateStr(String appointmentDateStr) {
        this.appointmentDateStr = appointmentDateStr;
    }

    /**
     * Gets receiveDateStr
     *
     * @return value of receiveDateStr
     */
    public String getReceiveDateStr() {
        return receiveDateStr;
    }

    /**
     * @param receiveDateStr
     */
    public void setReceiveDateStr(String receiveDateStr) {
        this.receiveDateStr = receiveDateStr;
    }

    /**
     * Gets finishDateStr
     *
     * @return value of finishDateStr
     */
    public String getFinishDateStr() {
        return finishDateStr;
    }

    /**
     * @param finishDateStr
     */
    public void setFinishDateStr(String finishDateStr) {
        this.finishDateStr = finishDateStr;
    }

    /**
     * Gets templateName
     *
     * @return value of templateName
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * @param templateName
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
