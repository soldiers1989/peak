package com.masspick.peak.guest.controller.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.masspick.peak.guest.model.BodyCer;
import com.masspick.peak.guest.model.BusLicenseCer;
import com.masspick.peak.guest.model.ControllerCer;
import com.masspick.peak.guest.model.IdMobileCer;
import com.masspick.peak.guest.model.EtpCer;

/**
 * EtpCerVo
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EtpCerVo {
    /**
     * etpCer
     */
    private EtpCer etpCer;

    /**
     * busCer
     */
    private BusLicenseCer busCer;

    /**
     * idMobileCer
     */
    private IdMobileCer idMobileCer;

    /**
     * bodyCer
     */
    private BodyCer bodyCer;

    /**
     * controllerCer
     */
    private ControllerCer controllerCer;

    /**
     * Gets etpCer
     *
     * @return value of etpCer
     */
    public EtpCer getEtpCer() {
        return etpCer;
    }

    /**
     * @param etpCer etpCer
     */
    public void setEtpCer(EtpCer etpCer) {
        this.etpCer = etpCer;
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
