package com.masspick.peak.dd.controller;

import com.masspick.peak.dd.controller.vo.DicVO;
import com.masspick.peak.dd.model.vo.ApiResponse;
import com.masspick.peak.service.IDictionaryFeignApi;
import com.masspick.peak.service.dto.SysDictionaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/6/13 0013.
 */
@RestController
@RequestMapping("/dic")
public class DicController {

    /**
     * providerApi
     */
    @Autowired
    private IDictionaryFeignApi iDictionaryFeignApi;

    /**
     * @return ApiResponse
     * @throws Exception Exception
     */
    @GetMapping
    public ApiResponse endReason() throws Exception {
        List<SysDictionaryDTO> sysDictionaryList = iDictionaryFeignApi.getDictionaryItem("refusalReason");
        ApiResponse response = ApiResponse.getInstances();
        List<DicVO> list = new ArrayList<>();
        DicVO.transfer(list, sysDictionaryList);
        return response.setCode("200").setResult(list);
    }

}
