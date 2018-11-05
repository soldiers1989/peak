package com.masspick.peak.model;

import java.io.Serializable;
import java.util.List;


/**
 * Property
 */
public class Property implements Serializable {

    /**
     * isAll
     */
    private String isAll;

    /**
     * attribute
     */
    private List<String> attribute;

    /**
     * Gets isAll
     *
     * @return value of isAll
     */
    public String getIsAll() {
        return isAll;
    }

    /**
     * @param isAll isAll
     */
    public void setIsAll(String isAll) {
        this.isAll = isAll;
    }

    /**
     * Gets attribute
     *
     * @return value of attribute
     */
    public List<String> getAttribute() {
        return attribute;
    }

    /**
     * @param attribute attribute
     */
    public void setAttribute(List<String> attribute) {
        this.attribute = attribute;
    }
}
