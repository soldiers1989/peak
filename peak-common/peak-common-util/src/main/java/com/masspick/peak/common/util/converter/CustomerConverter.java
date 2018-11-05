package com.masspick.peak.common.util.converter;


import com.masspick.peak.common.util.DateUtils;
import org.apache.commons.beanutils.Converter;

import java.util.Date;

/**
 * Created by Administrator on 2018/1/25.
 */
public class CustomerConverter implements Converter {

    @Override
    public <T> T convert(Class<T> type, Object value) {
        if (value instanceof Date) {
            return (T) DateUtils.format((Date) value);
        } else if (value == null) {
            return null;
        } else {
            return (T) value.toString();
        }
    }
}
