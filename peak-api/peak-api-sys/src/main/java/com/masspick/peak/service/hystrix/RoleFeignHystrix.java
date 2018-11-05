package com.masspick.peak.service.hystrix;

import com.masspick.peak.service.RoleFeignApi;
import com.masspick.peak.service.dto.SysRoleDTO;
import com.masspick.peak.service.dto.SysUserDTO;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


/**
 *  角色feign接口熔断器
 */
@Component
public class RoleFeignHystrix implements FallbackFactory<RoleFeignApi> {

    /**
     *  Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleFeignHystrix.class);

    /**
     *
     * @param throwable throwable
     * @return RoleFeignApi
     */
    @Override
    public RoleFeignApi create(Throwable throwable) {
        RoleFeignHystrix.LOGGER.info("fallback reason was: {} ", throwable.getMessage());
        return new RoleFeignApi() {
            @Override
            public List<SysUserDTO> findUserListByRoleName(String roleName) throws Exception {
                LOGGER.error("通过角色名称获取用户列表失败!");
                throw new Exception("通过角色名称获取用户列表失败!", throwable);
            }

            @Override
           public List<SysRoleDTO> findRoleListByAccount(@PathVariable("account") String account) throws Exception {
                LOGGER.error("通过用户账号获取角色信息失败!");
                throw new Exception("通过用户账号获取角色信息失败!", throwable);
            }
        };
    }
}
