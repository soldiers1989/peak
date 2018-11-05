package com.masspick.peak.guest.controller.vo;

import com.masspick.peak.guest.model.BusLicenseCer;
import com.masspick.peak.guest.model.ControllerCer;
import com.masspick.peak.guest.model.IdMobileCer;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *  企业资质认证添加对象
 */
public class EtpCerAddVo {
    /**
     *  认证id
     */
    @NotEmpty(message = "认证id不能为空")
    private String cerId;

    /**
     *  用户id
     */
    private String userId;

    /**
     *  营业执照信息
     */
    @Valid
    @NotNull(message = "营业执照信息不能为空")
    private BusLicenseCer busCer;

    /**
     *  身份证电话信息
     */
    @Valid
    @NotNull(message = "法人身份证电话信息不能为空")
    private IdMobileCer idMobileCer;

    /**
     * 大股东信息
     */
    @Valid
    @NotNull(message = "大股东信息信息不能为空")
    private ControllerCer controllerCer;

    /**
     * Gets cerId
     *
     * @return value of cerId
     */
    public String getCerId() {
        return cerId;
    }

    /**
     * @param cerId cerId
     */
    public void setCerId(String cerId) {
        this.cerId = cerId;
    }

    /**
     * Gets userId
     *
     * @return value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets busCer
     *
     * @return value of busCer
     */
    public BusLicenseCer getBusCer() {
        return busCer;
    }

    /**
     * @param busCer busCer
     */
    public void setBusCer(BusLicenseCer busCer) {
        this.busCer = busCer;
    }

    /**
     * Gets idMobileCer
     *
     * @return value of idMobileCer
     */
    public IdMobileCer getIdMobileCer() {
        return idMobileCer;
    }

    /**
     * @param idMobileCer idMobileCer
     */
    public void setIdMobileCer(IdMobileCer idMobileCer) {
        this.idMobileCer = idMobileCer;
    }

    /**
     * Gets controllerCer
     *
     * @return value of controllerCer
     */
    public ControllerCer getControllerCer() {
        return controllerCer;
    }

    /**
     * @param controllerCer controllerCer
     */
    public void setControllerCer(ControllerCer controllerCer) {
        this.controllerCer = controllerCer;
    }

}
