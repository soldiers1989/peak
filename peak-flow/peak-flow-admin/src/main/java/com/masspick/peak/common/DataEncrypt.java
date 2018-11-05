package com.masspick.peak.common;

import com.masspick.peak.common.util.StringUtils;

/**
 * DataEncrypt
 */
public class DataEncrypt {

    /**
     * MOBILE_LENGTH
     */
    private static final int MOBILE_LENGTH = 11;

    private static final int SIZE = 6;
    private static final String SYMBOL = "*";

    /**
     * TEMP_A
     */
    private static final int TEMP_A = 138977;

    /**
     * TEMP_B
     */
    private static final int TEMP_B = 176506;

    /**
     * TEMP_C
     */
    private static final int TEMP_C = 145390;

    /**
     * TEMP_D
     */
    private static final int TEMP_D = 150059;

    /**
     * TEMP_E
     */
    private static final int TEMP_E = 145402;

    /**
     * TEMP_F
     */
    private static final int TEMP_F = 150060;

    /**
     * TEMP_G
     */
    private static final int TEMP_G = 145406;

    /**
     * TEMP_H
     */
    private static final int TEMP_H = 150104;

    /**
     * TEMP_I
     */
    private static final int TEMP_I = 145405;

    /**
     * TEMP_J
     */
    private static final int TEMP_J = 164803;


    /**
     * Gets TEMP_B
     *
     * @return value of TEMP_B
     */
    public static int getTempB() {
        return TEMP_B;
    }

    /**
     * Gets TEMP_C
     *
     * @return value of TEMP_C
     */
    public static int getTempC() {
        return TEMP_C;
    }

    /**
     * Gets TEMP_D
     *
     * @return value of TEMP_D
     */
    public static int getTempD() {
        return TEMP_D;
    }

    /**
     * Gets TEMP_E
     *
     * @return value of TEMP_E
     */
    public static int getTempE() {
        return TEMP_E;
    }

    /**
     * Gets TEMP_F
     *
     * @return value of TEMP_F
     */
    public static int getTempF() {
        return TEMP_F;
    }

    /**
     * Gets TEMP_G
     *
     * @return value of TEMP_G
     */
    public static int getTempG() {
        return TEMP_G;
    }

    /**
     * Gets TEMP_H
     *
     * @return value of TEMP_H
     */
    public static int getTempH() {
        return TEMP_H;
    }

    /**
     * Gets TEMP_I
     *
     * @return value of TEMP_I
     */
    public static int getTempI() {
        return TEMP_I;
    }

    /**
     * Gets TEMP_J
     *
     * @return value of TEMP_J
     */
    public static int getTempJ() {
        return TEMP_J;
    }

    /**
     * Gets TEMP_A
     * @return value of TEMP_A
     */
    public static int getTempA() {
        return TEMP_A;
    }

    /**
     * 手机号脱敏处理
     * @param mobile
     * @return String
     */
    public static String mobileEncrypt(String mobile) {
        if (StringUtils.isEmpty(mobile) || (mobile.length() != MOBILE_LENGTH)) {
            return mobile;
        }
        return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }


    public static String nameEncrypt(String value) {
        if (null == value || "".equals(value)) {
            return value;
        }
        int len = value.length();
        int pamaone = len / 2;
        int pamatwo = pamaone - 1;
        int pamathree = len % 2;
        StringBuilder stringBuilder = new StringBuilder();
        if (len <= 2) {
            if (pamathree == 1) {
                return SYMBOL;
            }
            stringBuilder.append(SYMBOL);
            stringBuilder.append(value.charAt(len - 1));
        } else {
            if (pamatwo <= 0) {
                stringBuilder.append(value.substring(0, 1));
                stringBuilder.append(SYMBOL);
                stringBuilder.append(value.substring(len - 1, len));

            } else if (pamatwo >= SIZE / 2 && SIZE + 1 != len) {
                int pamafive = (len - SIZE) / 2;
                stringBuilder.append(value.substring(0, pamafive));
                for (int i = 0; i < SIZE; i++) {
                    stringBuilder.append(SYMBOL);
                }
                if ((pamathree == 0 && SIZE / 2 == 0) || (pamathree != 0 && SIZE % 2 != 0)) {
                    stringBuilder.append(value.substring(len - pamafive, len));
                } else {
                    stringBuilder.append(value.substring(len - (pamafive + 1), len));
                }
            } else {
                int pamafour = len - 2;
                stringBuilder.append(value.substring(0, 1));
                for (int i = 0; i < pamafour; i++) {
                    stringBuilder.append(SYMBOL);
                }
                stringBuilder.append(value.substring(len - 1, len));
            }
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(nameEncrypt("按键手"));
    }
}
