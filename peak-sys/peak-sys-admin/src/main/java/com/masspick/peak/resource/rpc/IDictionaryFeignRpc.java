package com.masspick.peak.resource.rpc;

import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.resource.entity.SysDictionary;
import com.masspick.peak.resource.service.IDictionaryService;
import com.masspick.peak.service.IDictionaryFeignApi;
import com.masspick.peak.service.dto.SysDictionaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/9/5 0005.
 */
@RestController
public class IDictionaryFeignRpc implements IDictionaryFeignApi {

    /**
     * iDictionaryService
     */
    @Autowired
    private IDictionaryService iDictionaryService;

    /**
     * 获取所有的字典
     *
     * @return List
     * @throws Exception Exception
     */
    @Override
    public List<SysDictionaryDTO> getDictionAries() throws Exception {
        List<SysDictionary> sysDictionaryList = iDictionaryService.findDictionaries();
        List<SysDictionaryDTO> list = new ArrayList<>();
        for (SysDictionary sysDictionary : sysDictionaryList) {
            SysDictionaryDTO sysDictionaryDTO = JacksonUtils.copyProperties(sysDictionary, SysDictionaryDTO.class);
            list.add(sysDictionaryDTO);
        }

        return list;
    }

    /**
     * 获取当前字典的字典项
     *
     * @param dictionaryKey dictionaryKey
     * @return
     * @throws Exception
     */
    @Override
    public List<SysDictionaryDTO> getDictionaryItem(@PathVariable("dictionaryKey") String dictionaryKey) throws Exception {
        List<SysDictionaryDTO> sysDictionaryDTOS = new ArrayList<>();
        SysDictionary parentSysDictionary = iDictionaryService.findByCode(dictionaryKey);
        if (parentSysDictionary != null) {
            List<SysDictionary> sysDictionaryList = iDictionaryService.findByParentId(parentSysDictionary.getId());
            for (SysDictionary sysDictionary : sysDictionaryList) {
                SysDictionaryDTO sysDictionaryDTO = JacksonUtils.copyProperties(sysDictionary, SysDictionaryDTO.class);
                sysDictionaryDTO.setParentCode(parentSysDictionary.getCode());
                sysDictionaryDTOS.add(sysDictionaryDTO);
            }
        }
        return sysDictionaryDTOS;
    }

    /**
     * @param type
     * @param bussKey
     * @return String
     * @throws Exception
     */
    @Override
    public String findDictNameByTypeAndKey(String type, String bussKey) throws Exception {
        return iDictionaryService.findDictNameByTypeAndKey(type, bussKey);
    }


}
