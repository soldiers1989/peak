package com.masspick.peak.guest.common.util;

import com.masspick.peak.common.util.StringHelper;

import java.util.HashMap;
import java.util.Map;

/**
 *  拆分地址信息
 */
public class GetDetailFromAddress {

    /**
     *  省
     */
    private static final String PROVICE = "省";

    /**
     *  市
     */
    private static final String CITY = "市";

    /**
     *  区
     */
    private static final String AREA = "区";

    /**
     * 拆分地址
     * @param address 地址
     * @return Map<String, String>
     */
    public static Map<String, String> splitAddres(String address) {
        Map<String, String> detailMap = new HashMap<>();
        if (StringHelper.isEmpty(address)) {
            return detailMap;
        }
        int provinceIndex = address.indexOf(PROVICE);
        int areaIndex = address.indexOf(AREA);
        int cityIndex = address.indexOf(CITY);

        if (provinceIndex > 1) {
            detailMap.put("province", address.substring(0, address.indexOf(PROVICE) + 1));
        } else {
            detailMap.put("province", null);
        }

        if (cityIndex > 1) {
            detailMap.put("city", address.substring(address.indexOf(PROVICE) + 1, address.indexOf(CITY) + 1));
        } else {
            detailMap.put("city", null);
        }

        if (areaIndex > 1 && cityIndex > 1) {
            detailMap.put("area", address.substring(address.indexOf(CITY) + 1, address.indexOf(AREA) + 1));
        } else {
            detailMap.put("area", null);
        }
        return detailMap;
    }
}
