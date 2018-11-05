package com.masspick.peak.guest.controller.vo;

import com.masspick.peak.guest.model.BodyCer;
import com.masspick.peak.guest.model.BusLicenseCer;
import com.masspick.peak.guest.model.ControllerCer;
import com.masspick.peak.guest.model.IdMobileCer;

/**
 *  资质认证明细对象
 */
public class EtpCerDetailVo {
    /**
     *  营业执照信息
     */
    private BusLicenseCer busCer;

    /**
     *  身份证和电话信息
     */
    private IdMobileCer idMobileCer;

    /**
     *  活体信息
     */
    private BodyCer bodyCer;

    /**
     *  控制人信息
     */
    private ControllerCer controllerCer;

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
     * Gets bodyCer
     *
     * @return value of bodyCer
     */
    public BodyCer getBodyCer() {
        return bodyCer;
    }

    /**
     * @param bodyCer bodyCer
     */
    public void setBodyCer(BodyCer bodyCer) {
        this.bodyCer = bodyCer;
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
