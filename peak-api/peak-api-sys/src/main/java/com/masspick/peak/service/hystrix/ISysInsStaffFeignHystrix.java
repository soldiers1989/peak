package com.masspick.peak.service.hystrix;

import com.masspick.peak.service.ISysInsStaffFeignApi;
import com.masspick.peak.service.dto.SysInsStaffDTO;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/9/20 0020.
 */
@Component
public class ISysInsStaffFeignHystrix implements FallbackFactory<ISysInsStaffFeignApi> {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ISysInsStaffFeignHystrix.class);

    @Override
    public ISysInsStaffFeignApi create(Throwable throwable) {
        return new ISysInsStaffFeignApi() {
            @Override
            public SysInsStaffDTO finByNumber(String number) throws Exception {
                LOGGER.error("获取机构人员失败！");
                throw new Exception("获取机构人员失败", throwable);
            }
        };
    }
}
