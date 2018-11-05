package com.masspick.peak.resource.utils;

/**
 * SpecialCharTrans
 */
public class SpecialCharTrans {

    protected SpecialCharTrans() {
    }

    /**
     * @param searchStr searchStr
     * @return String
     */
    public static String transSpecialChar(String searchStr) {
        if (searchStr == null || searchStr.equals("")) {
            return "";
        }
        searchStr = searchStr.replace("_", "\\_");
        searchStr = searchStr.replace("%", "\\%");
        return searchStr;
    }

}

