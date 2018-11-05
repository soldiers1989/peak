package com.masspick.peak.guest.controller.edit;


import com.masspick.peak.common.util.DateHelper;
import java.beans.PropertyEditorSupport;


/**
 * DateEditor
 */
public class DateEditor extends PropertyEditorSupport {

    /**
     * @param text
     */
    @Override
    public void setAsText(String text) {
        setValue(DateHelper.parseDate(text));
    }

}
