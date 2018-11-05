package com.masspick.peak.service.hystrix;

import com.masspick.peak.model.dto.ApiResponse;
import com.masspick.peak.model.dto.BorrowProjectBean;
import com.masspick.peak.service.PushProjectApi;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * PushProjectHystrix
 */
@Component
public class PushProjectHystrix implements FallbackFactory<PushProjectApi> {
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PushProjectHystrix.class);

    @Override
    public PushProjectApi create(Throwable throwable) {
        return new PushProjectApi() {

            @Override
            public ApiResponse pushProject(BorrowProjectBean borrowProjectBean) throws Exception {
                LOGGER.error("推送失败！");
                throw new Exception("推送失败!", throwable);
            }

            @Override
            public ApiResponse borrowRepayDetail(String borrowProjectId, String borrowId) throws Exception {
                LOGGER.error("查询失败！");
                throw new Exception("查询失败!", throwable);
            }

            @Override
            public ApiResponse completeTask(Map<String, String> map) throws Exception {
                LOGGER.error("执行失败！");
                throw new Exception("执行失败!", throwable);
            }

            @Override
            public ApiResponse borrowRepayDetailByflowId(String flowId) throws Exception {
                LOGGER.error("查询失败！");
                throw new Exception("查询失败!", throwable);
            }


        };
    }
}
