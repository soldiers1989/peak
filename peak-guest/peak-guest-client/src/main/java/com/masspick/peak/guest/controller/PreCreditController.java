package com.masspick.peak.guest.controller;


import com.masspick.peak.guest.model.NameCardInfo;
import com.masspick.peak.guest.service.IPreCreditService;
import com.masspick.peak.guest.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 预授信评估
 */
@RestController
@RequestMapping("/v1/app/pre")
public class PreCreditController {


    /**
     * iPreCreditService
     */
    @Autowired
    private IPreCreditService iPreCreditService;

    /**
     * 添加信用额度评估信息
     * @param nameCardInfo
     * @return ApiResponse
     */
    @PostMapping(value = "/nameCard/add")
    public ApiResponse addPreCard(@RequestBody NameCardInfo nameCardInfo) {
        return iPreCreditService.addPreCard(nameCardInfo);
    }

    /**
     * 通过openId查询用户最新的信用额度评估公司
     * @param openId
     * @return ApiResponse
     */
    @GetMapping(value = "/{openId}/etp")
    public ApiResponse getNameCardByOpenId(@PathVariable("openId") String openId) {
        return iPreCreditService.findNameCardByOpenId(openId);
    }

    /**
     * 通过openId查询用户信用额度评估的所有公司
     * @param openId
     * @return ApiResponse
     */
    @GetMapping(value = "/{openId}/etpList")
    public ApiResponse getNameCardListByOpenId(@PathVariable("openId") String openId) {
        return iPreCreditService.findNameCardListByOpenId(openId);
    }
}
