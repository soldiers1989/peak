package com.masspick.peak.dd.model.bo;


import com.masspick.peak.dd.model.DueDilData;

/**
 * Created by admin on 2018/5/22 0022.
 */
public class DueDilDataBO extends DueDilData {

    /**
     * label
     */
    private String label;

    /**
     * type
     */
    private String type;

    /**
     * controlKey
     */
    private String controlKey;

    /**
     * @return String
     */
    @Override
    public String getControlKey() {
        return controlKey;
    }

    /**
     * @param controlKey
     */
    @Override
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
