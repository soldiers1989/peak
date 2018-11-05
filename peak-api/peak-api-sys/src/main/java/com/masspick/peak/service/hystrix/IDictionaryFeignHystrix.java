package com.masspick.peak.service.hystrix;

import com.masspick.peak.service.IDictionaryFeignApi;
import com.masspick.peak.service.dto.SysDictionaryDTO;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by admin on 2018/9/5 0005.
 */
@Component
public class IDictionaryFeignHystrix implements FallbackFactory<IDictionaryFeignApi> {
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IDictionaryFeignApi.class);

    @Override
    public IDictionaryFeignApi create(Throwable throwable) {
        IDictionaryFeignHystrix.LOGGER.info("fallback reason was: {} ", throwable.getMessage());
        return new IDictionaryFeignApi() {
            @Override
            public List<SysDictionaryDTO> getDictionAries() throws Exception {
                LOGGER.error("查询字典信息失败!");
                throw new Exception("查询字典信息失败", throwable);
            }

            @Override
            public List<SysDictionaryDTO> getDictionaryItem(String dictionaryKey) throws Exception {
                LOGGER.error("查询字典项信息失败!");
                throw new Exception("查询字典项信息失败", throwable);
            }

            @Override
            public String findDictNameByTypeAndKey(String type, String bussKey) throws Exception {
                LOGGER.error("查询字典项信息失败!");
                throw new Exception("查询字典项信息失败", throwable);
            }

        };
    }
}
