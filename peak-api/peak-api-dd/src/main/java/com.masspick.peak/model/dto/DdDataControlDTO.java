package com.masspick.peak.model.dto;

import java.io.Serializable;

/**
 * Created by admin on 2018/7/26 0026.
 */
public class DdDataControlDTO implements Serializable {

    /**
     * label
     */
    private String label;

    /**
     * type
     */
    private String type;

    /**
     * value
     */
    private String value;

    /**
     * controlKey
     */
    private String controlKey;

    /**
     * Gets value
     *
     * @return value of value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets controlKey
     *
     * @return value of controlKey
     */
    public String getControlKey() {
        return controlKey;
    }

    /**
     * @param controlKey
     */
    public void setControlKey(String controlKey) {
        this.controlKey = controlKey;
    }

    /**
     * Gets label
     *
     * @return value of label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Gets type
     *
     * @return value of type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
}
