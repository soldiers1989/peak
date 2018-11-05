package com.masspick.peak.excel.translator.impl;


import com.masspick.peak.common.exception.PeakRuntimeException;
import com.masspick.peak.excel.translator.FieldTranslator;

/**
 * Created by Administrator on 2018/6/14.
 */
public class FiveClassifyTranslator implements FieldTranslator {

    @Override
    public String translate(String toBe) {
        if (toBe == null) {
            return null;
        }
        toBe = toBe.trim();
        String result = toBe;
        if ("正常".equals(toBe)) {
            result = "1";
        } else if ("关注".equals(toBe)) {
            result = "2";
        } else if ("次级".equals(toBe)) {
            result = "3";
        } else if ("可疑".equals(toBe)) {
            result = "4";
        } else if ("损失".equals(toBe)) {
            result = "5";
        } else if ("违约".equals(toBe)) {
            result = "6";
        } else {
            throw new PeakRuntimeException("无效的五级分类");
        }
        return result;
    }
}
