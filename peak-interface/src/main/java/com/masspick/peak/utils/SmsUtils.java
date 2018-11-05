package com.masspick.peak.utils;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.springframework.util.CollectionUtils;

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
     * @param mobile  手机号
     * @param message 手机信息
     * @return SmsSingleSenderResult
     * @throws HTTPException HTTPException
     * @throws JSONException JSONException
     * @throws IOException IOException
     */
    public static SmsSingleSenderResult sendSms(String mobile, String message) throws HTTPException, JSONException, IOException {
        SmsSingleSender singleSender = new SmsSingleSender(APPID, APPKEY);
        SmsSingleSenderResult sendResult = singleSender.send(0, "86", mobile, message, "", "");
        return sendResult;
    }

    /**
     * @param mobile    手机号
     * @param paramList 参数列表
     * @param tmplId    模板id
     * @return SmsSingleSenderResult
     * @throws HTTPException HTTPException
     * @throws IOException IOException
     */
    public static SmsSingleSenderResult sendSms(String mobile, ArrayList<String> paramList, Integer tmplId) throws HTTPException,
            IOException {
        SmsSingleSender singleSender = new SmsSingleSender(APPID, APPKEY);
        if (CollectionUtils.isEmpty(paramList)) {
            paramList.add("");
        }
        SmsSingleSenderResult sendResult = singleSender.sendWithParam("86", mobile, tmplId, paramList, "", "", "");
        return sendResult;
    }


}
