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
     * UserAuth
     */
    private EtpCer etpCer;

    /**
     * BusLicenseCer
     */
    private BusLicenseCer bus;

    /**
     * IdMobileCer
     */
    private IdMobileCer idMobileCer;

    /**
     * BodyCer
     */
    private BodyCer bodyCer;

    /**
     * ControllerCer
     */
    private ControllerCer controllerCer;

    /**
     * @return UserAuth
     */
    public EtpCer getEtpCer() {
        return etpCer;
    }

    /**
     * @param etpCer
     */
    public void setEtpCer(EtpCer etpCer) {
        this.etpCer = etpCer;
    }

    /**
     * @return BusLicenseCer
     */
    public BusLicenseCer getBus() {
        return bus;
    }

    /**
     * @param bus
     */
    public void setBus(BusLicenseCer bus) {
        this.bus = bus;
    }

    /**
     * @return BodyCer
     */
    public BodyCer getBodyCer() {
        return bodyCer;
    }

    /**
     * @param bodyCer
     */
    public void setBodyCer(BodyCer bodyCer) {
        this.bodyCer = bodyCer;
    }

    /**
     * @return ControllerCer
     */
    public ControllerCer getControllerCer() {
        return controllerCer;
    }

    /**
     * @param controllerCer
     */
    public void setControllerCer(ControllerCer controllerCer) {
        this.controllerCer = controllerCer;
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
}
