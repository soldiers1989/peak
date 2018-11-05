package com.masspick.peak.guest.controller.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.masspick.peak.common.util.DateHelper;
import com.masspick.peak.common.util.NumberHelper;
import com.masspick.peak.common.util.StringHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * HashMap对象的一个扩展.
 *
 * @author huqilang
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseVo extends HashMap<String, Object> implements GeneralVo {

    private static final long serialVersionUID = 1L;

    /**
     * BaseVo
     */
    public BaseVo() {
        super();
    }

    /**
     * @param initialCapacity
     * @param loadFactor
     */
    public BaseVo(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    /**
     * @param initialCapacity
     */
    public BaseVo(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * @param m
     */
    public BaseVo(Map<String, Object> m) {
        super(m);
    }

    /**
     * @param key the key
     * @return
     */
    @Override
    public String getString(String key) {
        return Objects.toString(this.get(key));
    }

    /**
     * @param key the key
     * @param <E>
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public <E> List<E> getList(String key) {
        Object o = this.get(key);
        if (o instanceof List) {
            return (List<E>) o;
        }
        return new ArrayList<>();
    }

    /**
     * @param key the key
     * @return
     */
    @Override
    public int getInt(String key) {
        Object value = this.get(key);
        if (value instanceof Integer) {
            return (Integer) value;
        }
        return NumberHelper.toInt(Objects.toString(value));
    }

    /**
     * @param key the key
     * @return
     */
    @Override
    public long getLong(String key) {
        Object value = this.get(key);
        if (value instanceof Long) {
            return (Long) value;
        }
        return NumberHelper.toLong(Objects.toString(value));
    }

    /**
     * @param key the key
     * @return
     */
    @Override
    public double getDouble(String key) {
        Object value = this.get(key);
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }
        return NumberHelper.toDouble(Objects.toString(value));
    }

    /**
     * @param key the key
     * @return
     */
    @Override
    public BigDecimal getDecimal(String key) {
        String str = this.getString(key);
        if (StringHelper.isEmpty(str)) {
            return BigDecimal.ZERO;
        }
        return NumberHelper.createBigDecimal(str);
    }

    /**
     * @param key the key
     * @return
     */
    @Override
    public Date getDate(String key) {
        Object value = this.get(key);
        if (value instanceof Date) {
            return (Date) value;
        }
        return DateHelper.parseDate(value);
    }
}
