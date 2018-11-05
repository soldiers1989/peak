package com.masspick.peak.common.util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/4/24 0024.
 */
public final class GaoDeLocationUtils {

    /**
     * 隐藏构造函数
     */
    private GaoDeLocationUtils() {
    }

    /**
     * FAIL
     */
    private static final int FAIL = 0;

    /**
     * KEYS
     */
    private static final String[] KEYS = new String[]{"6fa4c245ea68923673e4912266989d10"};

    /**
     * @param address
     * @return Map<String, Object>
     * @throws IOException IOException
     */
    public static Map<String, Object> getLocation(String address) throws IOException {
        //请求的url
        String url = "http://restapi.amap.com/v3/geocode/geo";

        //获取key
        int index = (int) (Math.random() * KEYS.length);

        //构建参数
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("key", KEYS[index]);
        paramMap.put("address", address);
        String buildUrl = HttpRequestUtils.buildUrl(url, paramMap);
        HttpEntity httpEntity = HttpRequestUtils.requestGet(buildUrl);
        String response = EntityUtils.toString(httpEntity, "UTF-8");
        Map<String, Object> map = JacksonUtils.readValue(response, Map.class);
        if (FAIL == Integer.parseInt((String) map.get("status"))) {
            return null;
        } else {
            List<Map<String, Object>> result = (List<Map<String, Object>>) map.get("geocodes");
            if (CollectionUtils.isEmpty(result)) {
                return null;
            } else {
                return result.get(0);
            }
        }
    }

}
