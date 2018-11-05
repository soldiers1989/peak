package com.masspick.peak.service.hystrix;

import com.masspick.peak.model.dto.DdTaskDTO;
import com.masspick.peak.service.DdTaskFeignApi;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by admin on 2018/6/20 0020.
 */
@Component
public class DdTaskFeignHystrix implements FallbackFactory<DdTaskFeignApi> {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DdTaskFeignHystrix.class);


    @Override
    public DdTaskFeignApi create(Throwable throwable) {
        DdTaskFeignHystrix.LOGGER.info("fallback reason was: {} ", throwable.getMessage());

        return new DdTaskFeignApi() {
            @Override
            public Integer createDueTask(DdTaskDTO ddTaskDTO) throws Exception {
                LOGGER.error("执行添加尽调信息失败!");
                throw new Exception("执行添加尽调信息失败", throwable);
            }

            @Override
            public Map<String, Object> ddData(String processId) throws Exception {
                LOGGER.error("执行添加尽调信息失败!");
                throw new Exception("执行添加尽调信息失败", throwable);
            }
        };
    }
}
