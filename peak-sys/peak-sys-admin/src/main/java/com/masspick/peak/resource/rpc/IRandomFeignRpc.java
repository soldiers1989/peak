package com.masspick.peak.resource.rpc;

import com.masspick.peak.resource.service.IRandomService;
import com.masspick.peak.service.IRandomFeignApi;
import org.apache.http.client.utils.DateUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by admin on 2018/9/11 0011.
 */
@RestController
public class IRandomFeignRpc implements IRandomFeignApi {

    /**
     * sysProductMapper
     */
    @Resource
    private IRandomService iRandomService;

    @Override
    public String getRandom() throws Exception {
        String year = DateUtils.formatDate(new Date(), "yyyy");
        return iRandomService.getRandom(year);
    }
}
