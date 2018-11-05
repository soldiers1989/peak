package com.masspick.peak.guest.common.util;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 短信操作类
 */
public class SmsUtils {

    /**
     * appId
     */
    private static final int APPID = 1400078153;
    /**
     * appkey
     */
    private static final String APPKEY = "89c614081b6988ab2323265c077eded4";
    /**
     * tmplId
     */
    private static final int TMPLID = 98334;


    /**
     * 发送短信
     *
     * @param mobile
     * @param code
     * @return SmsSingleSenderResult
     * @throws HTTPException 异常
     * @throws JSONException 异常
     * @throws IOException   异常
     */
    public static SmsSingleSenderResult sendSms(String mobile, String code) throws HTTPException, JSONException, IOException {
        SmsSingleSender singleSender = new SmsSingleSender(APPID, APPKEY);
        SmsSingleSenderResult singleSenderResult = null;
        ArrayList<String> params = new ArrayList<String>();
        params.add(code);
        singleSenderResult = singleSender.sendWithParam("86", mobile, TMPLID, params, "", "", "");
        return singleSenderResult;
    }
}
