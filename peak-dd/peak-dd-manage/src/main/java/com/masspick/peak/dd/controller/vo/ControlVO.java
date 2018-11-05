package com.masspick.peak.dd.controller.vo;


import com.masspick.peak.dd.model.Control;

/**
 * Created by admin on 2018/5/22 0022.
 */
public class ControlVO extends Control {
    /**
     * controlId
     */
    private String controlId;

    /**
     * @param control
     * @param controlVO
     */
    public void transfer(Control control, ControlVO controlVO) {
        controlVO.setLabel(control.getLabel());
        controlVO.setType(control.getType());
        controlVO.setControlKey(control.getControlKey());
        controlVO.setPlaceholder(control.getPlaceholder());
        controlVO.setDataType(control.getDataType());
        controlVO.setDataSourceCode(control.getDataSourceCode());
        controlVO.setDataSourceName(control.getDataSourceName());
        controlVO.setVerification(control.getVerification());
        controlVO.setControlId(control.getId());
    }

    /**
     * Gets controlId
     *
     * @return value of controlId
     */
    public String getControlId() {
        return controlId;
    }

    /**
     * @param controlId
     */
    public void setControlId(String controlId) {
        this.controlId = controlId;
    }
}
