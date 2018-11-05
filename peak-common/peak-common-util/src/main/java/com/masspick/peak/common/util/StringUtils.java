package com.masspick.peak.common.util;

import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/4/19.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * PATTERN_CARD_ID
     */
    private static final Pattern PATTERN_CARD_ID = Pattern.compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");

    /**
     * UNIT_10
     */
    private static final int UNIT_10 = 10;

    /**
     * UNIT_100
     */
    private static final int UNIT_100 = 100;

    /**
     * UNIT_1000
     */
    private static final int UNIT_1000 = 1000;

    /**
     * UNIT_10000
     */
    private static final int UNIT_10000 = 10000;

    /**
     * 如果对象为空，则使用defaultVal值
     * see: ObjectUtils.toString(obj, defaultVal)
     *
     * @param obj
     * @param defaultVal
     * @return String
     */
    public static String toString(final Object obj, final String defaultVal) {
        return obj == null ? defaultVal : obj.toString();
    }

    /**
     * 保留两位小数
     *
     * @param value
     * @return String
     */
    public static String format(double value) {

        // %.2f % 表示 小数点前任意位数 2 表示两位小数 格式后的结果为 f 表示浮点型
        return new Formatter().format("%.2f", value).toString();
    }

    /**
     * 判断字符串是否能转换成double
     *
     * @param str
     * @return boolean
     */
    public static boolean canBeDouble(String str) {
        boolean ret = true;
        try {
            double d = Double.parseDouble(str);
            ret = true;
        } catch (Exception ex) {
            ret = false;
        }
        return ret;
    }

    /**
     *
     * @param str str
     * @return Boolean
     */
    public static Boolean isNotNull(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param str str
     * @return Boolean
     */
    public static Boolean isNull(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    /**
     * 去空格等
     *
     * @param str
     * @return String
     * @author liuming
     * @date 2016年10月25日 上午10:01:45
     */
    public static String removeSpace(String str) {
        if (null == str || "".equals(str)) {
            return null;
        }
        str = str.replaceAll("[\\n,\\t,\\r,\\s,&nbsp;]", "").replaceAll("[ |　|]", " ").replace(" ", "").replace(" ",
                "");
        if ("".equals(str)) {
            return null;
        }
        return str;
    }

    /**
     * 判断是否包含英文字母  正则
     *
     * @param str
     * @return Boolean
     * @author liuming
     * @date 2016年11月7日  上午10:23:41
     */
    public static Boolean isIncludeLetterZZ(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        String regex = ".*[a-zA-Z]+.*";
        Matcher m = Pattern.compile(regex).matcher(str);
        return m.matches();
    }

    /**
     * 将字符串中的阿拉伯数字替换为中文的数字                《中华人民共和国道路交通安全法实施条例》第1000条第30款（10）项                 ====>
     * 《中华人民共和国道路交通安全法实施条例》第一千条第三十款（十）项
     *
     * @param str
     * @return String
     * @author liuming
     * @date 2016年11月7日  下午5:13:42
     */
    public static String replaceSZ(String str) {
        Pattern p = Pattern.compile("[0-9\\.]+");
        Matcher m = p.matcher(str);
        if (m.find()) {
            String mt = m.group();
            String m1 = str.substring(0, str.indexOf(mt));
            String m2 = str.substring(str.indexOf(mt) + mt.length());
            Integer ta = Integer.valueOf(mt);
            String sMax = StringUtils.getChinseSZ(ta);
            String res = m1 + sMax + m2;
            return replaceSZ(res);
        } else {
            return str;
        }
    }

    /**
     * 将数字转化为大写  五位数
     *
     * @param intInput
     * @return String
     * @author liuming
     * @date 2016年11月7日  下午5:01:56
     */
    public static String getChinseSZ(int intInput) {
        if (intInput == 0) {
            return "零";
        }
        String re = toCH(intInput);
        //去最后一个零
        if (!StringUtils.isNull(re)) {
            if ("零".equals(re.substring(re.length() - 1))) {
                re = re.substring(0, re.length() - 1);
            }
        } else {
            return "";
        }
        return re;
    }

    /**
     * @param intInput
     * @return String
     */
    public static String toCH(int intInput) {
        String si = String.valueOf(intInput);
        String sd = "";
        if (si.length() == 1) {
            // 個
            sd += getCH(intInput);
            return sd;
        } else if (si.length() == 2) {
            // 十
            if (si.substring(0, 1).equals("1")) {
                sd += "十";
            } else {
                sd += (getCH(intInput / UNIT_10) + "十");
            }
            sd += toCH(intInput % UNIT_10);
        } else if (si.length() == 3) {
            // 百
            sd += (getCH(intInput / UNIT_100) + "百");
            if (String.valueOf(intInput % UNIT_100).length() < 2) {
                sd += "零";
            }
            sd += toCH(intInput % UNIT_100);
        } else if (si.length() == 4) {
            // 千
            sd += (getCH(intInput / UNIT_1000) + "千");
            if (String.valueOf(intInput % UNIT_1000).length() < 3) {
                sd += "零";
            }
            sd += toCH(intInput % UNIT_1000);
        } else if (si.length() == 5) {
            // 萬
            sd += (getCH(intInput / UNIT_10000) + "万");
            if (String.valueOf(intInput % UNIT_10000).length() < 4) {
                sd += "零";
            }
            sd += toCH(intInput % UNIT_10000);
        }
        return sd;
    }

    /**
     * @param input
     * @return String
     */
    private static String getCH(int input) {
        String sd = "";
        switch (input) {
            case 1:
                sd = "一";
                break;
            case 2:
                sd = "二";
                break;
            case 3:
                sd = "三";
                break;
            case 4:
                sd = "四";
                break;
            case 5:
                sd = "五";
                break;
            case 6:
                sd = "六";
                break;
            case 7:
                sd = "七";
                break;
            case 8:
                sd = "八";
                break;
            case 9:
                sd = "九";
                break;
            default:
                break;
        }
        return sd;
    }

    /**
     * 将字符串中特殊的字符转化为空格 " "
     *
     * @param str
     * @return String
     */
    public static String subSpeCharBlank(String str) {
        str = str.replace("-", " ").replace("-", " ").replace("，", " ").replace(",", " ");
        return str;
    }

    /**
     * 去字符串中3 个到3 个以上的数字字组
     *
     * @param str
     * @return String
     */
    public static String removeNum3(String str) {
        return str.replaceAll("\\d{3,}", "");
    }
}
