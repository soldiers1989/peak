package com.masspick.peak.service.hystrix;

import com.masspick.peak.model.dto.COSDTO;
import com.masspick.peak.service.CosFeignApi;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by admin on 2018/7/10 0010.
 */
@Component
public class CosFeignHystrix implements CosFeignApi {

    /**
     * @param dto
     * @return Boolean
     */
    @Override
    public Boolean uploadImageToCos(@RequestBody COSDTO dto) {
        return null;
    }
}
