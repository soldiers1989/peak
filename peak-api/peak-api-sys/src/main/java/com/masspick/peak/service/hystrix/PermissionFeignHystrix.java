package com.masspick.peak.service.hystrix;

import com.masspick.peak.service.PermissionFeignApi;
import com.masspick.peak.service.dto.ApiResponseDTO;
import com.masspick.peak.service.dto.SysPermissionDTO;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 资源对外接口熔断器
 */
@Component
public class PermissionFeignHystrix implements FallbackFactory<PermissionFeignApi> {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionFeignHystrix.class);

    @Override
    public PermissionFeignApi create(Throwable throwable) {
        PermissionFeignHystrix.LOGGER.info("fallback reason was: {} ", throwable.getMessage());

        return new PermissionFeignApi() {
            @Override
            public ApiResponseDTO userPermission() throws Exception {
                LOGGER.error("获取用户权限信息失败!");
                throw new Exception("获取用户权限信息失败", throwable);
            }

            @Override
            public List<SysPermissionDTO> ddPermission(String account, String appId) throws Exception {
                LOGGER.error("尽调用户获取权限失败!");
                throw new Exception("尽调用户获取权限失败", throwable);
            }
        };
    }
}
