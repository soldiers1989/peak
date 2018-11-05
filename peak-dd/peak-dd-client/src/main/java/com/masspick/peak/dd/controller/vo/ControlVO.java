package com.masspick.peak.dd.controller.vo;

import com.masspick.peak.dd.model.bo.TemplateControlBO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/5/23 0023.
 */
public class ControlVO {

    /**
     * id
     */
    private String id;

    /**
     * name
     */
    private String name;

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
     * placeholder
     */
    private String placeholder;

    /**
     * require
     */
    private String require;

    /**
     * value
     */
    private String value;

    /**
     * dataType
     */
    private String dataType;

    /**
     * controlSeq
     */
    private Integer controlSeq;

    /**
     * option
     */
    private List<DicVO> option = new ArrayList<>();

    /**
     * @param controlVO
     * @param templateControlBO
     */
    public void transfer(ControlVO controlVO, TemplateControlBO templateControlBO) {
        String controlType = templateControlBO.getType();
        controlVO.setId(templateControlBO.getControlId());
        controlVO.setLabel(templateControlBO.getControlShowName());
        controlVO.setName(templateControlBO.getControlShowName());
        controlVO.setControlKey(templateControlBO.getControlKey());
        controlVO.setPlaceholder(templateControlBO.getPlaceInfo());
        controlVO.setRequire(templateControlBO.getRequire());
        controlVO.setValue(templateControlBO.getValue());
        controlVO.setControlSeq(templateControlBO.getControlSeq());
        if (controlType.equals("select") || controlType.equals("multSelect") || controlType.equals("date")
                || controlType.equals("textarea") || controlType.equals("image")) {
            controlVO.setDataType(templateControlBO.getType());
            controlVO.setType(templateControlBO.getType());
        } else {
            controlVO.setDataType(templateControlBO.getType());
            controlVO.setType("input");
        }
    }

    /**
     * Gets option
     *
     * @return value of option
     */
    public List<DicVO> getOption() {
        return option;
    }

    /**
     * @param option
     */
    public void setOption(List<DicVO> option) {
        this.option = option;
    }

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
     * Gets placeholder
     *
     * @return value of placeholder
     */
    public String getPlaceholder() {
        return placeholder;
    }

    /**
     * @param placeholder
     */
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    /**
     * Gets require
     *
     * @return value of require
     */
    public String getRequire() {
        return require;
    }

    /**
     * @param require
     */
    public void setRequire(String require) {
        this.require = require;
    }

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
     * Gets dataType
     *
     * @return value of dataType
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * @param dataType
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
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
     * Gets controlSeq
     *
     * @return value of controlSeq
     */
    public Integer getControlSeq() {
        return controlSeq;
    }

    /**
     * @param controlSeq
     */
    public void setControlSeq(Integer controlSeq) {
        this.controlSeq = controlSeq;
    }
}
