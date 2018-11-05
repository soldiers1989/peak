package com.masspick.peak.excel.translator.impl;


import com.masspick.peak.excel.translator.FieldTranslator;

/**
 * Created by Administrator on 2018/6/14.
 */
public class DefaultValueTranslator implements FieldTranslator {

    /**
     * value
     */
    private String value;

    /**
     * @param value
     */
    public DefaultValueTranslator(String value) {
        this.value = value;
    }

    @Override
    public String translate(String toBe) {
        return this.value;
    }
}
