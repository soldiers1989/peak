package com.masspick.peak.guest.controller.edit;

import org.apache.commons.lang3.StringEscapeUtils;

import java.beans.PropertyEditorSupport;


/**
 * StringEditor
 */
public class StringEditor extends PropertyEditorSupport {

    /**
     * @param text
     */
    @Override
    public void setAsText(String text) {
        setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
    }

    /**
     * @return String
     */
    @Override
    public String getAsText() {
        Object value = getValue();
        return value != null ? value.toString() : "";
    }
}
