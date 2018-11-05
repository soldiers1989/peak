package com.masspick.peak.service.impl;

import com.masspick.peak.mapper.ActDeModelMapper;
import com.masspick.peak.model.ActDeModel;
import com.masspick.peak.service.ActDeModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ActDeModelServiceImpl
 */
@Service
public class ActDeModelServiceImpl implements ActDeModelService {

    /**
     * modelMapper
     */
    @Autowired
    private ActDeModelMapper modelMapper;

    /**
     * @param key
     * @return ActDeModel
     */
    @Override
    public ActDeModel getByKey(String key) {
        return modelMapper.getByKey(key);
    }
}
