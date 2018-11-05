package com.masspick.peak.excel.config;


import com.masspick.peak.excel.translator.FieldTranslator;

/**
 * Created by Administrator on 2018/6/14.
 */
public class FieldConfig {

    /**
     * key
     */
    private String key;

    /**
     * type
     */
    private FieldEnum type;

    /**
     * translator
     */
    private FieldTranslator translator;

    /**
     * 构造函数
     */
    public FieldConfig() {
    }

    /**
     * @param key
     * @param type
     */
    public FieldConfig(String key, FieldEnum type) {
        this.key = key;
        this.type = type;
    }

    /**
     * @param key
     * @param type
     * @param translator
     */
    public FieldConfig(String key, FieldEnum type, FieldTranslator translator) {
        this.key = key;
        this.type = type;
        this.translator = translator;
    }

    /**
     * Gets key
     *
     * @return value of key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Gets type
     *
     * @return value of type
     */
    public FieldEnum getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(FieldEnum type) {
        this.type = type;
    }

    /**
     * Gets translator
     *
     * @return value of translator
     */
    public FieldTranslator getTranslator() {
        return translator;
    }

    /**
     * @param translator
     */
    public void setTranslator(FieldTranslator translator) {
        this.translator = translator;
    }
}
