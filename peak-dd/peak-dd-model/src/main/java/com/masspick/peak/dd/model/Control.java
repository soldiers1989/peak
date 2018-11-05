package com.masspick.peak.dd.model;


import com.masspick.peak.dd.model.vo.BaseEntity;

/**
 * Created by admin on 2018/5/16 0016.
 * <p>
 * 组件
 */
public class Control extends BaseEntity {

    /**
     * id
     */
    private String id;

    /**
     * label
     */
    private String label;

    /**
     * 控件类型：text，number，select，checkbox，time，textarea
     */
    private String type;

    /**
     * 业务主键
     */
    private String controlKey;

    /**
     * 提示信息
     */
    private String placeholder;

    /**
     * 数据类型 手机/电话号码，邮箱，身份证，网址
     */
    private String dataType;

    /**
     * 数据字典的code
     */
    private String dataSourceCode;

    /**
     * 数据字典的code
     */
    private String dataSourceName;

    /**
     * 是否校验 0校验 1不校验
     */
    private String verification;


    /**
     * 1:激活；0：去激活。
     */
    private Integer state;

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
     * Gets dataSourceCode
     *
     * @return value of dataSourceCode
     */
    public String getDataSourceCode() {
        return dataSourceCode;
    }

    /**
     * @param dataSourceCode
     */
    public void setDataSourceCode(String dataSourceCode) {
        this.dataSourceCode = dataSourceCode;
    }

    /**
     * Gets check
     *
     * @return value of check
     */
    /**
     * Gets verification
     *
     * @return value of verification
     */
    public String getVerification() {
        return verification;
    }

    /**
     * @param verification
     */
    public void setVerification(String verification) {
        this.verification = verification;
    }

    /**
     * Gets state
     *
     * @return value of state
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * Gets dataSourceName
     *
     * @return value of dataSourceName
     */
    public String getDataSourceName() {
        return dataSourceName;
    }

    /**
     * @param dataSourceName
     */
    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }
}
