package com.masspick.peak.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/16.
 */
public final class MoneyUtils {

    private MoneyUtils() {
    }

    /**
     * 金钱正则表达式
     * 不考虑分隔符的正确性
     */
    private static final Pattern AMOUNT_PATTERN =
            Pattern.compile("^(0|[1-9]\\d{0,11})\\.(\\d\\d)$");

    /**
     * RMB 数字
     */
    private static final char[] RMB_NUMS = "零壹贰叁肆伍陆柒捌玖".toCharArray();

    /**
     * 单位
     */
    private static final String[] UNITS = {"元", "角", "分", "整"};
    /**
     * 单位1
     */
    private static final String[] U1 = {"", "拾", "佰", "仟"};

    /**
     * 单位2
     */
    private static final String[] U2 = {"", "万", "亿"};

    /**
     * 将金额（整数部分等于或少于12位，小数部分2位）转换为中文大写形式.
     *
     * @param numberAmount 金额数字
     * @return 中文大写
     * @throws IllegalArgumentException
     */
    public static String convert(String numberAmount) {

        //如果为空，直接返回
        if (StringUtils.isEmpty(numberAmount)) {
            return numberAmount;
        }


        if (numberAmount.equals("0.00")) {
            return "零元";
        }

        // 去掉分隔符
        // 验证金额正确性
        String replaceAmount = numberAmount.replace(",", "");
        String amount = moneyFormat(replaceAmount);
        Matcher matcher = AMOUNT_PATTERN.matcher(amount);
        if (!matcher.find()) {

            //如果是非金钱，直接返回，不做处理
            return numberAmount;
        }

        // 整数部分
        String integer = matcher.group(1);

        // 小数部分
        String fraction = matcher.group(2);

        String result = "";
        if (!integer.equals("0")) {

            // 整数部分
            result += integer2rmb(integer) + UNITS[0];
        }
        if (fraction.equals("00")) {

            // 添加[整]
            result += UNITS[3];
        } else if (fraction.startsWith("0") && integer.equals("0")) {

            // 去掉分前面的[零]
            result += fraction2rmb(fraction).substring(1);
        } else {

            // 小数部分
            result += fraction2rmb(fraction);
        }

        return result;
    }


    /**
     * 将金额小数部分转换为中文大写
     *
     * @param fraction
     * @return String
     */
    private static String fraction2rmb(String fraction) {
        // 角
        char jiao = fraction.charAt(0);

        // 分
        char fen = fraction.charAt(1);
        return (RMB_NUMS[jiao - '0'] + (jiao > '0' ? UNITS[1] : ""))
                + (fen > '0' ? RMB_NUMS[fen - '0'] + UNITS[2] : "");
    }


    /**
     * 将金额整数部分转换为中文大写
     *
     * @param integer
     * @return String
     */
    private static String integer2rmb(String integer) {
        StringBuilder buffer = new StringBuilder();
        // 从个位数开始转换
        int i, j;
        for (i = integer.length() - 1, j = 0; i >= 0; i--, j++) {
            char n = integer.charAt(i);
            if (n == '0') {
                // 当n是0且n的右边一位不是0时，插入[零]
                if (i < integer.length() - 1 && integer.charAt(i + 1) != '0') {
                    buffer.append(RMB_NUMS[0]);
                }
                // 插入[万]或者[亿]
                if (j % 4 == 0) {
                    if (i > 0 && integer.charAt(i - 1) != '0'
                            || i > 1 && integer.charAt(i - 2) != '0'
                            || i > 2 && integer.charAt(i - 3) != '0') {
                        buffer.append(U2[j / 4]);
                    }
                }
            } else {
                if (j % 4 == 0) {

                    // 插入[万]或者[亿]
                    buffer.append(U2[j / 4]);
                }

                // 插入[拾]、[佰]或[仟]
                buffer.append(U1[j % 4]);

                // 插入数字
                buffer.append(RMB_NUMS[n - '0']);
            }
        }
        return buffer.reverse().toString();
    }

    /**
     * 对金额的格式调整到分
     *
     * @param money
     * @return String
     */
    public static String moneyFormat(String money) {
        StringBuffer sb = new StringBuffer();
        if (money == null) {
            return "0.00";
        }
        int index = money.indexOf(".");
        if (index == -1) {
            return money + ".00";
        } else {
            //整数部分
            String s0 = money.substring(0, index);

            //小数部分
            String s1 = money.substring(index + 1);

            //小数点后一位
            if (s1.length() == 1) {
                s1 = s1 + "0";
            } else if (s1.length() > 2) {

                //如果超过3位小数，截取2位就可以了
                s1 = s1.substring(0, 2);
            }
            sb.append(s0);
            sb.append(".");
            sb.append(s1);
        }
        return sb.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(MoneyUtils.moneyFormat("xxx"));
        System.out.println(MoneyUtils.convert("1000"));
        System.out.println(MoneyUtils.convert("1001.00"));
        System.out.println(MoneyUtils.convert("1011.00"));
        System.out.println(MoneyUtils.convert("1111.00"));
        System.out.println(MoneyUtils.convert("1000.10"));
        System.out.println(MoneyUtils.convert("11111111000.11"));
        System.out.println(MoneyUtils.convert("11110000.00"));
    }
}
