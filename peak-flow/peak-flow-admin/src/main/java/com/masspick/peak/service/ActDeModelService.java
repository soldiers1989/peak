package com.masspick.peak.service;

import com.masspick.peak.model.ActDeModel;

/**
 * ActDeModelService
 */
public interface ActDeModelService {
    /**
     * @param key
     * @return ActDeModel
     */
    ActDeModel getByKey(String key);
}
