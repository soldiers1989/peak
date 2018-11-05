package com.masspick.peak.service.hystrix;

import com.masspick.peak.common.util.ApiResponse;
import com.masspick.peak.service.IUserFeignApi;
import com.masspick.peak.service.dto.ApiResponseDTO;
import com.masspick.peak.service.dto.SysUserDTO;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/9/5 0005.
 */
@Component
public class IUserFeignHystrix implements FallbackFactory<IUserFeignApi> {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IUserFeignApi.class);

    @Override
    public IUserFeignApi create(Throwable throwable) {
        return new IUserFeignApi() {
            @Override
            public SysUserDTO findByName(String account) throws Exception {
                LOGGER.error("用户名查询用户信息失败!");
                throw new Exception("用户名查询用户信息失败", throwable);
            }

            @Override
            public ApiResponseDTO modifyUserPass(String account, Map<String, String> userMap) throws Exception {
                LOGGER.error("根据用户名修改密码失败!");
                throw new Exception("根据用户名修改密码失败", throwable);
            }

            @Override
            public ApiResponse findByNameAndPassword(Map<String, String> map) throws Exception {
                LOGGER.error("用户名与密码查询用户信息失败!");
                throw new Exception("用户名与密码查询用户信息失败", throwable);
            }

            @Override
            public List<SysUserDTO> findUserByRoleAndAreaName(String roleName, String areaName) throws Exception {
                LOGGER.error("用户名查询用户信息失败!");
                throw new Exception("用户名查询用户信息失败", throwable);
            }

            @Override
            public ApiResponseDTO userInfo() throws Exception {
                LOGGER.error("通过头部AuthId获取用户信息失败!");
                throw new Exception("通过头部AuthId获取用户信息失败", throwable);
            }
        };
    }
}
