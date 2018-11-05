/**
 * Copyright (c) 2005-2012 springside.org.cn
 */
package com.masspick.peak.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 封装各种格式的编码解码工具类.
 * 1.Commons-Codec的 hex/base64 编码
 * 2.自制的base62 编码
 * 3.Commons-Lang的xml/html escape
 * 4.JDK提供的URLEncoder
 *
 * @author calvin
 * @version 2013-01-15
 */
public final class Encodes extends DigestUtils {

    /**
     * 工具类应隐藏public构造器
     */
    private Encodes() {
    }

    /**
     * DEFAULT_URL_ENCODING
     */
    private static final String DEFAULT_URL_ENCODING = "UTF-8";


    /**
     * Html 转码.
     *
     * @param html
     * @return String
     */
    public static String escapeHtml(String html) {
        return StringEscapeUtils.escapeHtml4(html);
    }

    /**
     * Html 解码.
     *
     * @param htmlEscaped
     * @return String
     */
    public static String unescapeHtml(String htmlEscaped) {
        return StringEscapeUtils.unescapeHtml4(htmlEscaped);
    }


    /**
     * Xml 转码.
     *
     * @param xml
     * @return String
     */
    public static String escapeXml(String xml) {
        return StringEscapeUtils.escapeXml10(xml);
    }


    /**
     * Xml 解码.
     *
     * @param xmlEscaped
     * @return String
     */
    public static String unescapeXml(String xmlEscaped) {
        return StringEscapeUtils.unescapeXml(xmlEscaped);
    }


    /**
     * URL 编码, Encode默认为UTF-8.
     *
     * @param part
     * @return String
     */
    public static String urlEncode(String part) {
        try {
            return URLEncoder.encode(part, DEFAULT_URL_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw Exceptions.unchecked(e);
        }
    }


    /**
     * URL 解码, Encode默认为UTF-8.
     *
     * @param part
     * @return String
     */
    public static String urlDecode(String part) {

        try {
            return URLDecoder.decode(part, DEFAULT_URL_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw Exceptions.unchecked(e);
        }
    }
}
