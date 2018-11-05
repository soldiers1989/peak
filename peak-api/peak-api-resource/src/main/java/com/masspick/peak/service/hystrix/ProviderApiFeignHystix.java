package com.masspick.peak.service.hystrix;

import com.masspick.peak.dto.SysDictionaryDTO;
import com.masspick.peak.dto.SysRoleDTO;
import com.masspick.peak.dto.SysUserDTO;
import com.masspick.peak.service.ProviderApi;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ProviderApiFeignHystix
 */
@Component
public class ProviderApiFeignHystix implements FallbackFactory<ProviderApi> {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProviderApiFeignHystix.class);

    @Override
    public ProviderApi create(Throwable throwable) {

        ProviderApiFeignHystix.LOGGER.info("fallback reason was: {} ", throwable.getMessage());

        return new ProviderApi() {
            @Override
            public String getFromApi() {
                return null;
            }

            @Override
            public SysUserDTO findUserByName(String userName) throws Exception {
                LOGGER.error("查询失败！");
                throw new Exception("查询失败!", throwable);
            }

            @Override
            public List<SysRoleDTO> findRolesByUserName(String userName) throws Exception {
                LOGGER.error("查询失败！");
                throw new Exception("查询失败!", throwable);
            }

            @Override
            public SysRoleDTO findRoleByRoleId(String roleId) throws Exception {
                LOGGER.error("查询失败！");
                throw new Exception("查询失败!", throwable);
            }

            @Override
            public List<SysDictionaryDTO> findDictByType(String type) throws Exception {
                LOGGER.error("查询失败！");
                throw new Exception("查询失败!", throwable);
            }

            @Override
            public String findDictNameByTypeAndKey(String type, String bussKey) throws Exception {
                LOGGER.error("查询失败！");
                throw new Exception("查询失败!", throwable);
            }

            @Override
            public List<SysUserDTO> findUserByRoleId(String roleId) throws Exception {
                LOGGER.error("查询失败！");
                throw new Exception("查询失败!", throwable);
            }
        };


    }
}
