package com.masspick.peak.common.util;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/3.
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    /**
     * 默认时间格式
     */
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";


    /**
     * 年月日时间格斯
     */
    public static final String YEARHOURDAY_FORMAT = "yyyy-MM-dd";


    /**
     * ISO8601 formatter for date-time without time zone.
     * The format used is <tt>yyyy-MM-dd'T'HH:mm:ss</tt>.
     */
    public static final FastDateFormat DEFAULT_DATETIME_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    /**
     * FastDateFormat
     */
    public static final FastDateFormat CLEAN_FORMAT = FastDateFormat.getInstance("yyyy年MM月");

    /**
     * The UTC time zone (often referred to as GMT).
     * This is private as it is mutable.
     */
    private static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("GMT");
    /**
     * ISO8601 formatter for date-time without time zone.
     * The format used is <tt>yyyy-MM-dd'T'HH:mm:ss</tt>.
     */
    public static final FastDateFormat ISO_DATETIME_FORMAT
            = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss");

    /**
     * ISO8601 formatter for date-time with time zone.
     * The format used is <tt>yyyy-MM-dd'T'HH:mm:ssZZ</tt>.
     */
    public static final FastDateFormat ISO_DATETIME_TIME_ZONE_FORMAT
            = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ssZZ");

    /**
     * ISO8601 formatter for date without time zone.
     * The format used is <tt>yyyy-MM-dd</tt>.
     */
    public static final FastDateFormat DATE_FORMAT_DAY
            = FastDateFormat.getInstance("yyyy-MM-dd");

    /**
     * ISO8601-like formatter for date with time zone.
     * The format used is <tt>yyyy-MM-ddZZ</tt>.
     * This pattern does not comply with the formal ISO8601 specification
     * as the standard does not allow a time zone  without a time.
     */
    public static final FastDateFormat ISO_DATE_TIME_ZONE_FORMAT
            = FastDateFormat.getInstance("yyyy-MM-ddZZ");

    /**
     * ISO8601 formatter for time without time zone.
     * The format used is <tt>'T'HH:mm:ss</tt>.
     */
    public static final FastDateFormat ISO_TIME_FORMAT
            = FastDateFormat.getInstance("'T'HH:mm:ss");

    /**
     * ISO8601 formatter for time with time zone.
     * The format used is <tt>'T'HH:mm:ssZZ</tt>.
     */
    public static final FastDateFormat ISO_TIME_TIME_ZONE_FORMAT
            = FastDateFormat.getInstance("'T'HH:mm:ssZZ");

    /**
     * ISO8601-like formatter for time without time zone.
     * The format used is <tt>HH:mm:ss</tt>.
     * This pattern does not comply with the formal ISO8601 specification
     * as the standard requires the 'T' prefix for times.
     */
    public static final FastDateFormat ISO_TIME_NO_T_FORMAT
            = FastDateFormat.getInstance("HH:mm:ss");

    /**
     * ISO8601-like formatter for time with time zone.
     * The format used is <tt>HH:mm:ssZZ</tt>.
     * This pattern does not comply with the formal ISO8601 specification
     * as the standard requires the 'T' prefix for times.
     */
    public static final FastDateFormat ISO_TIME_NO_T_TIME_ZONE_FORMAT
            = FastDateFormat.getInstance("HH:mm:ssZZ");

    /**
     * SMTP (and probably other) date headers.
     * The format used is <tt>EEE, dd MMM yyyy HH:mm:ss Z</tt> in US locale.
     */
    public static final FastDateFormat SMTP_DATETIME_FORMAT
            = FastDateFormat.getInstance("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);


    /**
     * 默认支持时间字符串格式类型
     */
    private static final String[] PATTERN_ARRAY = {
            DEFAULT_DATETIME_FORMAT.getPattern(),
            DATE_FORMAT_DAY.getPattern()
    };

    /**
     * 数据清洗存在的时间字符串格式类型
     */
    public static final String[] CLEAN_PATTERN_ARRAY = {
            "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd",
            "yyyy.MM.dd",
            "yyyy/MM/dd",
            "yyyMMdd",
            "yyyy、MM、dd",
            "yyyy．MM．dd",
            "yyyy－MM－dd",
            "yyyy-MM-ddHH:mm:ss",
            "yyyy.MM.dd",
            "yyyy.MM.dd.",
            "yyyy年MM月dd日",
            "yyyy年MM月",
            "yyyy-MM-dd HH:mm"

    };

    /**
     * 默认时间解析
     *
     * @param str 时间字符串
     * @return Date
     * @throws ParseException ParseException
     */
    public static Date parseDate(final String str) throws ParseException {
        return DateUtils.parseDate(str, DEFAULT_DATETIME_FORMAT.getPattern());
    }


    /**
     * @param str
     * @return Date
     * @throws ParseException ParseException
     */
    public static Date parseDateWithDefaultPattern(final String str) throws ParseException {
        return DateUtils.parseDate(str, DateUtils.DEFAULT_FORMAT, DateUtils.DATE_FORMAT_DAY.getPattern(), "yyyy/MM/dd"
                + " HH:mm:ss", "yyyy年MM月dd日", "yyyy/MM/dd", "yyyy.MM.dd", "yyyyMMdd");
    }

    /**
     * 默认Format
     *
     * @param date
     * @return String
     */
    public static String format(final Date date) {
        return DEFAULT_DATETIME_FORMAT.format(date);
    }

    /**
     * <p>Formats a date/time into a specific pattern using the UTC time zone.</p>
     *
     * @param millis  the date to format expressed in milliseconds
     * @param pattern the pattern to use to format the date, not null
     * @return the formatted date
     */
    public static String formatUTC(final long millis, final String pattern) {
        return format(new Date(millis), pattern, UTC_TIME_ZONE, null);
    }

    /**
     * <p>Formats a date/time into a specific pattern using the UTC time zone.</p>
     *
     * @param date    the date to format, not null
     * @param pattern the pattern to use to format the date, not null
     * @return the formatted date
     */
    public static String formatUTC(final Date date, final String pattern) {
        return format(date, pattern, UTC_TIME_ZONE, null);
    }

    /**
     * <p>Formats a date/time into a specific pattern using the UTC time zone.</p>
     *
     * @param millis  the date to format expressed in milliseconds
     * @param pattern the pattern to use to format the date, not null
     * @param locale  the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String formatUTC(final long millis, final String pattern, final Locale locale) {
        return format(new Date(millis), pattern, UTC_TIME_ZONE, locale);
    }

    /**
     * <p>Formats a date/time into a specific pattern using the UTC time zone.</p>
     *
     * @param date    the date to format, not null
     * @param pattern the pattern to use to format the date, not null
     * @param locale  the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String formatUTC(final Date date, final String pattern, final Locale locale) {
        return format(date, pattern, UTC_TIME_ZONE, locale);
    }

    /**
     * <p>Formats a date/time into a specific pattern.</p>
     *
     * @param millis  the date to format expressed in milliseconds
     * @param pattern the pattern to use to format the date, not null
     * @return the formatted date
     */
    public static String format(final long millis, final String pattern) {
        return format(new Date(millis), pattern, null, null);
    }

    /**
     * <p>Formats a date/time into a specific pattern.</p>
     *
     * @param date    the date to format, not null
     * @param pattern the pattern to use to format the date, not null
     * @return the formatted date
     */
    public static String format(final Date date, final String pattern) {
        return format(date, pattern, null, null);
    }

    /**
     * <p>Formats a calendar into a specific pattern.</p>
     *
     * @param calendar the calendar to format, not null
     * @param pattern  the pattern to use to format the calendar, not null
     * @return the formatted calendar
     * @see FastDateFormat#format(Calendar)
     * @since 2.4
     */
    public static String format(final Calendar calendar, final String pattern) {
        return format(calendar, pattern, null, null);
    }

    /**
     * <p>Formats a date/time into a specific pattern in a time zone.</p>
     *
     * @param millis   the time expressed in milliseconds
     * @param pattern  the pattern to use to format the date, not null
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(final long millis, final String pattern, final TimeZone timeZone) {
        return format(new Date(millis), pattern, timeZone, null);
    }

    /**
     * <p>Formats a date/time into a specific pattern in a time zone.</p>
     *
     * @param date     the date to format, not null
     * @param pattern  the pattern to use to format the date, not null
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(final Date date, final String pattern, final TimeZone timeZone) {
        return format(date, pattern, timeZone, null);
    }

    /**
     * <p>Formats a calendar into a specific pattern in a time zone.</p>
     *
     * @param calendar the calendar to format, not null
     * @param pattern  the pattern to use to format the calendar, not null
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @return the formatted calendar
     * @see FastDateFormat#format(Calendar)
     * @since 2.4
     */
    public static String format(final Calendar calendar, final String pattern, final TimeZone timeZone) {
        return format(calendar, pattern, timeZone, null);
    }

    /**
     * <p>Formats a date/time into a specific pattern in a locale.</p>
     *
     * @param millis  the date to format expressed in milliseconds
     * @param pattern the pattern to use to format the date, not null
     * @param locale  the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(final long millis, final String pattern, final Locale locale) {
        return format(new Date(millis), pattern, null, locale);
    }

    /**
     * <p>Formats a date/time into a specific pattern in a locale.</p>
     *
     * @param date    the date to format, not null
     * @param pattern the pattern to use to format the date, not null
     * @param locale  the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(final Date date, final String pattern, final Locale locale) {
        return format(date, pattern, null, locale);
    }

    /**
     * <p>Formats a calendar into a specific pattern in a locale.</p>
     *
     * @param calendar the calendar to format, not null
     * @param pattern  the pattern to use to format the calendar, not null
     * @param locale   the locale to use, may be <code>null</code>
     * @return the formatted calendar
     * @see FastDateFormat#format(Calendar)
     * @since 2.4
     */
    public static String format(final Calendar calendar, final String pattern, final Locale locale) {
        return format(calendar, pattern, null, locale);
    }

    /**
     * <p>Formats a date/time into a specific pattern in a time zone  and locale.</p>
     *
     * @param millis   the date to format expressed in milliseconds
     * @param pattern  the pattern to use to format the date, not null
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @param locale   the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(final long millis, final String pattern, final TimeZone timeZone, final Locale locale) {
        return format(new Date(millis), pattern, timeZone, locale);
    }

    /**
     * <p>Formats a date/time into a specific pattern in a time zone  and locale.</p>
     *
     * @param date     the date to format, not null
     * @param pattern  the pattern to use to format the date, not null, not null
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @param locale   the locale to use, may be <code>null</code>
     * @return the formatted date
     */
    public static String format(final Date date, final String pattern, final TimeZone timeZone, final Locale locale) {
        final FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone, locale);
        return df.format(date);
    }

    /**
     * <p>Formats a calendar into a specific pattern in a time zone  and locale.</p>
     *
     * @param calendar the calendar to format, not null
     * @param pattern  the pattern to use to format the calendar, not null
     * @param timeZone the time zone  to use, may be <code>null</code>
     * @param locale   the locale to use, may be <code>null</code>
     * @return the formatted calendar
     * @see FastDateFormat#format(Calendar)
     * @since 2.4
     */
    public static String format(final Calendar calendar, final String pattern, final TimeZone timeZone, final Locale
            locale) {
        final FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone, locale);
        return df.format(calendar);
    }

    /**
     * @param paramString
     * @return s
     */
    public static String getSystemDateByformart(String paramString) {
        Date now = new Date();
        FastDateFormat format = FastDateFormat.getInstance(paramString);
        return format.format(now);
    }

    /**
     * 按照pattern 格式解析 date字符串
     *
     * @param date    日期
     * @param pattern 格式
     * @return s
     * @throws ParseException
     */
    public static Date parseDateByPattern(String date, String pattern) {
        try {
            return DateUtils.parseDate(date, pattern);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 按照pattern 格式解析 date字符串
     *
     * @param date          日期
     * @param parsePatterns 格式
     * @return s
     * @throws ParseException
     */
    public static Date parseDateByPattern(String date, final String... parsePatterns) {
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(date, parsePatterns);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * @param date
     * @param locale
     * @param parsePatterns parsePatterns
     * @return Date
     */
    public static Date parseDateByPatternAndLocale(String date, final Locale locale, final String... parsePatterns) {
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(date, locale, parsePatterns);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将日期转化成需求的格式字符串
     *
     * @param date    日期
     * @param pattern 格式
     * @return s
     */
    public static String getStringByDate(Date date, String pattern) {
        return DateUtils.format(date, pattern);
    }


    /**
     * @return s
     */
    public static String getSystemYYYYMMDD() {
        return DATE_FORMAT_DAY.format(new Date());
    }

    /**
     * @param time
     * @return s
     */
    public static Date parseTimeToDate(String time) {
        try {
            return DateUtils.parseDate(time, PATTERN_ARRAY);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return Date
     */
    public static Date getMidnight() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * 获取若干后月的时间
     *
     * @param month
     * @return String
     */
    public static String getMontTime(Integer month) {
        GregorianCalendar now = new GregorianCalendar();
        SimpleDateFormat fmtrq = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat df = DateFormat.getDateInstance();
        now.add(GregorianCalendar.MONTH, month);   //可以是天数或月数  数字自定 -6前6个月
        String str = fmtrq.format(now.getTime());
        return str;
    }

    /**
     * @return Date
     */
    public static Date yesterdayMin() {
        Calendar cal = Calendar.getInstance();
        cal.add(cal.DATE, -1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }


    /**
     * @param str
     * @return String
     */
    public static String getDateFromStringYYYMMDD(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        String reslut = null;
        String reg = "\\d{4}-(1[0-2]|0?[1-9])-([1-2][0-9]|3[0-1]|0?[1-9])";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            reslut = matcher.group(0);
        }
        return reslut;
    }

    /**
     * 统一日期格式
     *
     * @param value
     * @return String
     */
    public static String getReplaceAllDate(String value) {
        StringBuffer sb = null;
        if (value != null && !"".equals(value)) {
            value = value.replaceAll("[（,）,(,),【,】,{,},<,>]", "");
            value = value.replaceAll("[:,：]", ":");
            value = value.replace("]", "");
            value = value.replace("[", "");
            value = value.trim();
            sb = new StringBuffer();
            sb.append(value);
        }
        return sb == null ? null : sb.toString();
    }

    /**
     * string 转 yyyy-MM-dd'T'HH:mm:ssZZ
     *
     * @param str
     * @return String
     * @author liuming
     * @date 2016年1月27日 下午9:29:43
     */
    public static String toYMDOfChaStrESZZ2(String str) {

        String openTimeTempNew = null;
        String openTimeTemp = null;
        if (StringUtils.isNull(str)) {
            return null;
        }

        // 处理 2015-09-02T04:07:01.658587+08:00
        if (str.contains(".") && str.contains("+") && str.contains("T")) {

            String str1 = str.replace("T", " ");
            SimpleDateFormat sdftime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                Date dd1 = sdftime1.parse(str1);
                SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ");
                String strTemp = sdftime.format(dd1);
                return strTemp;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        // 处理 2016-02-20 02:38:59
        String regex3 = "^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$";
        Matcher matcher3 = Pattern.compile(regex3).matcher(str);
        if (matcher3.matches()) {
            SimpleDateFormat sdftime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date dd1 = sdftime1.parse(str);
                SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ");
                String strTemp = sdftime.format(dd1);
                return strTemp;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        String regex = "^[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}[+][0][8][0][0]$";
        Matcher matcher2 = Pattern.compile(regex).matcher(str);
        if (matcher2.matches()) {
            return str;
        }
        openTimeTemp = DateUtils.formatDate(str);

        if (StringUtils.isNull(openTimeTemp)) {
            openTimeTemp = DateUtils.toChiDateYMD(str); // ------------------------------《》问题，
        }

        if (!StringUtils.isNull(openTimeTemp)) {
            openTimeTempNew = DateUtils.toYMDOfChaStrESZZ(openTimeTemp);
        }
        return openTimeTempNew;
    }

    /**
     * 格式化日期 各种格式转为
     * <p>
     * yyyyMMdd yyyy-MM-dd yyyy/MM/dd yyyy.MM.dd CST
     * <p>
     * yyyy年MM月dd日
     *
     * @param date
     * @return String
     * @throws ParseException
     */
    public static String formatDate(String date) {
        String result = null;
        SimpleDateFormat sf = null;
        try {

            if (null != date) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
                try {
                    format.parse(date);
                    return date;
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // yyyyMMdd
                String yyymmdd = "^[12]\\d{3}(0\\d|1[0-2])([0-2]\\d|3[01])$";

                // yyyy-MM-dd
                String yyyymmdd = "^[0-9]{4}-[0-9]{1,}-[0-9]{1,}$";

                // yyyy/MM/dd
                String yyyy = "^\\d{4}\\/\\d{1,}\\/\\d{1,}$";

                // yyyy.MM.dd
                String yyyyD = "^\\d{4}\\.\\d{1,}\\.\\d{1,}$";

                // yyyy
                String yyyYD = "^\\d{4}$";

                // yyyyMMdd 情况
                Pattern pattern = Pattern.compile(yyymmdd);
                Matcher matcher = pattern.matcher(date);
                if (matcher.matches()) {
                    sf = new SimpleDateFormat("yyyyMMdd");
                    Date d = sf.parse(date);
                    sf = null;
                    sf = new SimpleDateFormat("yyyy年MM月dd日");
                    result = sf.format(d);
                    sf = null;
                } else {
                    // yyyy-MM-dd 情况
                    pattern = Pattern.compile(yyyymmdd);
                    matcher = pattern.matcher(date);
                    if (matcher.matches()) {
                        sf = new SimpleDateFormat("yyyy-MM-dd");
                        Date d = sf.parse(date);
                        sf = null;
                        sf = new SimpleDateFormat("yyyy年MM月dd日");
                        result = sf.format(d);
                        sf = null;
                    } else {
                        // yyyy/MM/dd 情况
                        pattern = Pattern.compile(yyyy);
                        matcher = pattern.matcher(date);
                        if (matcher.matches()) {
                            sf = new SimpleDateFormat("yyyy/MM/dd");
                            Date d = sf.parse(date);
                            sf = null;
                            sf = new SimpleDateFormat("yyyy年MM月dd日");
                            result = sf.format(d);
                            sf = null;
                        } else {
                            // yyyy.MM.dd 情况
                            pattern = Pattern.compile(yyyyD);
                            matcher = pattern.matcher(date);
                            if (matcher.matches()) {
                                sf = new SimpleDateFormat("yyyy.MM.dd");
                                Date d = sf.parse(date);
                                sf = null;
                                sf = new SimpleDateFormat("yyyy年MM月dd日");
                                result = sf.format(d);
                                sf = null;
                            } else {
                                int indexXie = date.indexOf("/");
                                int indexMao = date.indexOf(":");
                                if (4 == indexXie && -1 != indexMao) {
                                    String newDate = date.substring(0, date.indexOf(" "));
                                    // yyyy/MM/dd hh:mm:ss 情况
                                    pattern = Pattern.compile(yyyy);
                                    matcher = pattern.matcher(newDate);
                                    if (matcher.matches()) {
                                        sf = new SimpleDateFormat("yyyy/MM/dd");
                                        Date d = sf.parse(newDate);
                                        sf = null;
                                        sf = new SimpleDateFormat("yyyy年MM月dd日");
                                        result = sf.format(d);
                                        sf = null;
                                    }
                                } else {
                                    int indexXie2 = date.indexOf("-");
                                    int indexMao2 = date.indexOf(":");
                                    if (4 == indexXie2 && -1 != indexMao2) {
                                        String newDate = "";
                                        if (-1 != date.indexOf(" ")) {
                                            newDate = date.substring(0, date.indexOf(" "));
                                        } else {
                                            newDate = date.replace(" ", "").substring(0, date.indexOf(":") - 2);
                                        }
                                        pattern = Pattern.compile(yyyymmdd);
                                        matcher = pattern.matcher(newDate);
                                        if (matcher.matches()) {
                                            sf = new SimpleDateFormat("yyyy-MM-dd");
                                            Date d = sf.parse(newDate);
                                            sf = null;
                                            sf = new SimpleDateFormat("yyyy年MM月dd日");
                                            result = sf.format(d);
                                            sf = null;
                                        } else {
                                            newDate = date.replace(" ", "").substring(0, date.indexOf(":") - 1);
                                            // yyyy-MM-dd hh:mm:ss 情况
                                            pattern = Pattern.compile(yyyymmdd);
                                            matcher = pattern.matcher(newDate);
                                            if (matcher.matches()) {
                                                sf = new SimpleDateFormat("yyyy-MM-dd");
                                                Date d = sf.parse(newDate);
                                                sf = null;
                                                sf = new SimpleDateFormat("yyyy年MM月dd日");
                                                result = sf.format(d);
                                                sf = null;
                                            } else {
                                                // 处理：Mon Apr 22 00:00:00 CST
                                                // 2013格式
                                                if (date.contains("CST")) {
                                                    sf = new SimpleDateFormat("yyyy年MM月dd日");
                                                    @SuppressWarnings("deprecation")
                                                    Date dt = new Date(date);
                                                    result = sf.format(dt);
                                                    sf = null;
                                                    dt = null;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;

    }

    /**
     * 将 二Ｏ一Ｏ年十月三十一日 转为了 2010年10月31日
     *
     * @param str
     * @return String
     * @Description: TODO
     * @author liuming
     * @date 2016年1月23日 上午11:57:49
     */
    public static String toChiDateYMD(String str) {

        if (StringUtils.isNull(str)) {
            return null;
        }
        String result = null;

        result = str.replaceAll("[（,）,(,),【,】,{,},<,>]", "");
        result = result.replace("三十一", "31");
        result = result.replace("三十", "30");
        result = result.replace("二十九", "29");
        result = result.replace("二十八", "28");
        result = result.replace("二十七", "27");
        result = result.replace("二十六", "26");
        result = result.replace("二十五", "25");
        result = result.replace("二十四", "24");
        result = result.replace("二十三", "23");
        result = result.replace("二十二", "22");
        result = result.replace("二十一", "21");
        result = result.replace("二十", "20");
        result = result.replace("十九", "19");
        result = result.replace("十八", "18");
        result = result.replace("十七", "17");
        result = result.replace("十六", "16");
        result = result.replace("十五", "15");
        result = result.replace("十四", "14");
        result = result.replace("十三", "13");
        result = result.replace("十二", "12");
        result = result.replace("十一", "11");
        result = result.replace("十", "10");
        result = result.replace("九", "9");
        result = result.replace("八", "8");
        result = result.replace("七", "7");
        result = result.replace("六", "6");
        result = result.replace("五", "5");
        result = result.replace("四", "4");
        result = result.replace("三", "3");
        result = result.replace("二", "2");
        result = result.replace("一", "1");
        result = result.replace("元", "1");

        result = result.replaceAll("[Ｏ,〇,0,o,O,０,○]", "0");
        return result;
    }

    /**
     * 将日期STRING转化为 年-日-日
     * <p>
     * yyyy-MM-dd'T'HH:mm:ssZZ -----------> 2013-09-30T00:00:00+0800
     *
     * @param str
     * @return String
     * @author liuming
     * @date 2016年1月19日 下午4:10:43
     */
    public static String toYMDOfChaStrESZZ(String str) {

        if (StringUtils.isNull(str)) {
            return null;
        }
        try {
            String regex = "^[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}[+][0][8][0][0]$";
            Matcher matcher2 = Pattern.compile(regex).matcher(str);
            if (matcher2.matches()) {
                return str;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        SimpleDateFormat sdf = null;
        Date dd = null;
        String strTemp = null;
        if (str.contains("年") && str.contains("月") && str.contains("日")) {
            sdf = new SimpleDateFormat("yyyy年MM月dd日");
            try {
                dd = sdf.parse(str);
                SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ");
                strTemp = sdftime.format(dd);
                sdf = null;
                sdftime = null;
                return strTemp;
            } catch (ParseException e) {
                return null;
            }
        } else if (str.indexOf("+0800") != -1) {
            sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ");
            try {
                dd = sdf.parse(str);
                SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ");
                strTemp = sdftime.format(dd);
                sdf = null;
                sdftime = null;
                return strTemp;
            } catch (ParseException e) {
                return null;
            }
        } else if (str.indexOf("CST") != -1) {
            // sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                // dd = sdf.parse(str);
                dd = new Date(str);
                SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ");
                strTemp = sdftime.format(dd);
                sdf = null;
                sdftime = null;
                return strTemp;
            } catch (Exception e) {
                return null;
            }
        } else if (str.indexOf("-") != -1 && str.indexOf(":") != -1) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                dd = sdf.parse(str);
                SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ");
                strTemp = sdftime.format(dd);
                sdf = null;
                sdftime = null;
                return strTemp;
            } catch (ParseException e) {
                return null;
            }
        } else if (str.indexOf("-") != -1) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dd = sdf.parse(str);
                SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ");
                strTemp = sdftime.format(dd);
                sdf = null;
                sdftime = null;
                return strTemp;
            } catch (ParseException e) {
                return null;
            }
        }
        return strTemp;
    }
}
