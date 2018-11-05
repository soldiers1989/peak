package com.masspick.peak.guest.common.util;

import java.math.BigDecimal;

/**
 * 企业评分数据模型
 */
public class EtpScoreModel {

    /**
     * B
     */
    private static final float B = 427.2f;
    /**
     * BB
     */
    private static final float BB = 458.4f;
    /**
     * BBB
     */
    private static final float BBB = 488.8f;
    /**
     * A
     */
    private static final float A = 520;
    /**
     * AA
     */
    private static final float AA = 550.4f;
    /**
     * AAA
     */
    private static final float AAA = 580.8f;

    /**
     * LEVEL_ONE
     */
    private static final int LEVEL_ONE = 20;

    /**
     * LEVEL_TWO
     */
    private static final int LEVEL_TWO = 30;

    /**
     * LEVEL_THREE
     */
    private static final int LEVEL_THREE = 45;

    /**
     * LEVEL_FOUR
     */
    private static final int LEVEL_FOUR = 65;

    /**
     * LEVEL_FIVE
     */
    private static final int LEVEL_FIVE = 80;

    /**
     * LEVEL_SIX
     */
    private static final int LEVEL_SIX = 100;


    /**
     * @param totalEtpScore
     * @return String
     */
    public static String getLevelByScore(Double totalEtpScore) {
        String level;

        if (totalEtpScore.doubleValue() >= B && totalEtpScore.doubleValue() < BB) {
            level = "B";
        } else if (totalEtpScore.doubleValue() >= BB && totalEtpScore.doubleValue() < BBB) {
            level = "BB";
        } else if (totalEtpScore.doubleValue() >= BBB && totalEtpScore.doubleValue() < A) {
            level = "BBB";
        } else if (totalEtpScore.doubleValue() >= A && totalEtpScore.doubleValue() < AA) {
            level = "A";
        } else if (totalEtpScore.doubleValue() >= AA && totalEtpScore.doubleValue() < AAA) {
            level = "AA";
        } else {
            level = "AAA";
        }
        return level;
    }

    /**
     * @param level
     * @return BigDecimal
     */
    public static BigDecimal getLoanLimit(String level) {
        BigDecimal loanLimit;
        if (level.equals("B")) {
            loanLimit = new BigDecimal(LEVEL_ONE);
        } else if (level.equals("BB")) {
            loanLimit = new BigDecimal(LEVEL_TWO);
        } else if (level.equals("BBB")) {
            loanLimit = new BigDecimal(LEVEL_THREE);
        } else if (level.equals("A")) {
            loanLimit = new BigDecimal(LEVEL_FOUR);
        } else if (level.equals("AA")) {
            loanLimit = new BigDecimal(LEVEL_FIVE);
        } else {
            loanLimit = new BigDecimal(LEVEL_SIX);
        }
        return loanLimit;
    }
}
