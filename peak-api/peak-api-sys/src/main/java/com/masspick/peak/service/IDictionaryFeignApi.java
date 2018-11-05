package com.masspick.peak.service;

import com.masspick.peak.service.dto.SysDictionaryDTO;
import com.masspick.peak.service.hystrix.IDictionaryFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by admin on 2018/7/30 0030.
 */
@FeignClient(value = "peak-sys-admin", fallbackFactory = IDictionaryFeignHystrix.class)
public interface IDictionaryFeignApi {

    /**
     * 获取所有字典
     *
     * @return List
     * @throws Exception Exception
     */
    @RequestMapping(value = "/v1/resource/dictionaries", method = RequestMethod.GET)
    List<SysDictionaryDTO> getDictionAries() throws Exception;

    /**
     * 获取当前字典的字典项
     *
     * @param dictionaryKey
     * @return List
     * @throws Exception Exception
     */
    @RequestMapping(value = "/v1/resource/dictionaryItem/{dictionaryKey}", method = RequestMethod.GET)
    List<SysDictionaryDTO> getDictionaryItem(@PathVariable("dictionaryKey") String dictionaryKey) throws Exception;

    /**
     * @param type
     * @param bussKey
     * @return String
     * @throws Exception Exception
     */
    @RequestMapping(method = {RequestMethod.GET}, value = "/v1/resource/dictionaries/getDictByTypeAndkey")
    String findDictNameByTypeAndKey(@RequestParam("type") String type,
                                    @RequestParam("bussKey") String bussKey) throws Exception;
}
