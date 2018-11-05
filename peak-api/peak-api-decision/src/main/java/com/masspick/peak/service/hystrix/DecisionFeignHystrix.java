package com.masspick.peak.service.hystrix;


import com.masspick.peak.model.dto.WhiteListEtpDto;
import com.masspick.peak.model.dto.WhiteListEtpFindBo;
import com.masspick.peak.service.DecisionFeignApi;
import org.springframework.stereotype.Component;

/**
 * DecisionFeignHystrix
 */
@Component
public class DecisionFeignHystrix implements DecisionFeignApi {

    /**
     * @param ddTaskDTO
     * @return WhiteListEtpDto
     */
    @Override
    public WhiteListEtpDto findWhiteList(WhiteListEtpFindBo ddTaskDTO) {
        return null;
    }
}
