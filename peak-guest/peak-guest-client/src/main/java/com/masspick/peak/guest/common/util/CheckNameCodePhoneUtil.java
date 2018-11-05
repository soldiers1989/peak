package com.masspick.peak.guest.common.util;


import com.alibaba.fastjson.JSONObject;
import com.masspick.peak.common.util.SignAndSend;

import java.net.URLEncoder;

/**
 * CheckNameCodePhoneUtil
 */
public class CheckNameCodePhoneUtil {

    /**
     * @param name
     * @param mobile
     * @param idCode
     * @param message
     * @return String
     */
    public static String checkNameCodePhone(String name, String mobile, String idCode, String message) {
        String result;
        try {
            String params = "?idCard=" + idCode + "&name=" + URLEncoder.encode(name, "UTF-8") + "&phone=" + mobile;
            result = SignAndSend.sendGet(params);
            JSONObject resultJson = JSONObject.parseObject(result);
            String code = resultJson.getJSONObject("showapi_res_body").getString("code");
            System.out.println("nameCheckPhone params = " + params);
            System.out.println("nameChecjPhone result = " + result);
            if (code.equals("0")) {
                result = "success";
            } else {
                result = message + "手机号绑定信息与身份证信息不一致";
            }
        } catch (Exception e) {
            result = message + "手机号绑定信息与身份证信息不一致";
        }
        return result;
    }
}
