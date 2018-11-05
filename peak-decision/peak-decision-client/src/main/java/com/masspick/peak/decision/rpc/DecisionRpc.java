package com.masspick.peak.decision.rpc;


import com.masspick.peak.decision.service.IDecisionRpcService;
import com.masspick.peak.model.dto.WhiteListEtpDto;
import com.masspick.peak.model.dto.WhiteListEtpFindBo;
import com.masspick.peak.service.DecisionFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * DecisionRpc
 */
@RestController
public class DecisionRpc implements DecisionFeignApi {

    /**
     * decisionRpcService
     */
    @Autowired
    private IDecisionRpcService decisionRpcService;

    /**
     * @param whiteListEtpFindBo
     * @return WhiteListEtpDto
     */
    @Override
    public WhiteListEtpDto findWhiteList(@RequestBody WhiteListEtpFindBo whiteListEtpFindBo) {
        return decisionRpcService.findWhiteList(whiteListEtpFindBo);
    }
}
