package com.masspick.peak.service.hystrix;

import com.masspick.peak.model.dto.ApiResponse;
import com.masspick.peak.model.dto.BaseDto;
import com.masspick.peak.service.SendsmsFeignApi;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;


/**
 * SendsmsFeignHystrix
 */
@Component
public class SendsmsFeignHystrix implements FallbackFactory<SendsmsFeignApi> {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SendsmsFeignHystrix.class);


    @Override
    public SendsmsFeignApi create(Throwable throwable) {

        return new SendsmsFeignApi() {
            @Override
            public ApiResponse sendSMS(BaseDto dto) throws Exception {
                LOGGER.error("发送短信失败！");
                throw new Exception("发送短信失败!", throwable);
            }

            @Override
            public ApiResponse sendSMS(String mobile, ArrayList<String> params, Integer tempId) throws Exception {
                LOGGER.error("发送短信失败！");
                throw new Exception("发送短信失败!", throwable);
            }

            @Override
            public ApiResponse sendSMSToDd(Map<String, Object> map) throws Exception {
                LOGGER.error("发送短信失败！");
                throw new Exception("发送短信失败!", throwable);
            }
        };

    }
}

