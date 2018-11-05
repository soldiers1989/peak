package com.masspick.peak.service.hystrix;

import com.masspick.peak.model.Property;
import com.masspick.peak.service.IFlowService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * IFlowServiceFeignHystrix
 */
@Component
public class IFlowServiceFeignHystrix implements FallbackFactory<IFlowService> {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IFlowServiceFeignHystrix.class);

    /**
     * @param throwable
     * @return IFlowService
     */
    @Override
    public IFlowService create(Throwable throwable) {
        IFlowServiceFeignHystrix.LOGGER.info("fallback reason was: {} ", throwable.getMessage());

        return new IFlowService() {
            @Override
            public String startProcess(Map<String, String> map) throws Exception {
                LOGGER.error("开启流程错误！");
                throw new Exception("开启流程错误!", throwable);
            }

            @Override
            public String completeTask(String taskId, Map<String, String> map) throws Exception {
                LOGGER.error("执行流程错误!");
                throw new Exception("执行流程错误", throwable);
            }

            @Override
            public Map<String, String> taskbyProInsId(String processInstanceId) throws Exception {
                LOGGER.error("查询错误！");
                throw new Exception("查询错误!", throwable);
            }

            @Override
            public Map<String, String> findFlowMapByTaskId(String processInstanceId, Property property) throws Exception {
                LOGGER.error("查询错误！");
                throw new Exception("查询错误!", throwable);
            }

            @Override
            public String findTaskIdByParam(String no, String actId) throws Exception {
                LOGGER.error("查询错误！");
                throw new Exception("查询错误!", throwable);
            }

            @Override
            public String findFormByKey(String key) throws Exception {
                LOGGER.error("获取表单数据失败！");
                throw new Exception("获取表单数据失败!", throwable);
            }
        };
    }
}
