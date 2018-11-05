package com.masspick.peak.service;

import com.github.qcloudsms.SmsSingleSenderResult;
import com.masspick.peak.model.dto.ApiResponse;
import com.masspick.peak.model.dto.BaseDto;
import com.masspick.peak.utils.SmsUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Administrator on 2018\7\4 0004.
 */
@RestController
public class SendsmsFeignClient implements SendsmsFeignApi {

    /**
     * @param dto
     * @return ApiResponse
     */
    @Override
    public ApiResponse sendSMS(@RequestBody BaseDto dto) {
        String mobile = dto.getString("mobile");
        String message = dto.getString("message");
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (StringUtils.isBlank(mobile)) {
            return apiResponse.error("201").setReason("手机号不能为空！");
        }
        if (StringUtils.isBlank(message)) {
            return apiResponse.error("201").setReason("短信内容不能为空！");
        }
        try {
            SmsSingleSenderResult res = SmsUtils.sendSms(mobile, message);
            return apiResponse.success().setResult(res);
        } catch (Exception e) {
            return apiResponse.error("202").setReason("发送信息失败！");
        }
    }

    /**
     * @param mobile 手机号码
     * @param params 模板参数
     * @param tempId 腾讯云秘钥
     * @return ApiResponse
     */
    @Override
    public ApiResponse sendSMS(String mobile, @RequestBody ArrayList<String> params, Integer tempId) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (StringUtils.isBlank(mobile)) {
            return apiResponse.error("201").setReason("手机号不能为空！");
        }
        try {
            SmsSingleSenderResult res = SmsUtils.sendSms(mobile, params, tempId);
            return apiResponse.success().setResult(res);
        } catch (Exception e) {
            return apiResponse.error("202").setReason("发送信息失败！");
        }
    }

    /**
     * @param map
     * @return ApiResponse
     */
    @Override
    public ApiResponse sendSMSToDd(@RequestBody Map<String, Object> map) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (StringUtils.isBlank((String) map.get("mobile"))) {
            return apiResponse.error("201").setReason("手机号不能为空！");
        }
        try {
            SmsSingleSenderResult res;
            if (StringUtils.isEmpty((String) map.get("param"))) {
                res = SmsUtils.sendSms((String) map.get("mobile"), "【方舟】很遗憾，您申请的企卡未能通过审批，祝您生活愉快！");
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add((String) map.get("param"));
                res = SmsUtils.sendSms((String) map.get("mobile"), list, (Integer) map.get("appId"));
            }
            return apiResponse.success().setResult(res);

        } catch (Exception e) {
            return apiResponse.error("202").setReason("发送信息失败！");
        }
    }
}
