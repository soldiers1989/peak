package com.masspick.peak.mapper;

import com.masspick.peak.model.ActDeModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ActDeModelMapper
 */
@Mapper
public interface ActDeModelMapper {
    /**
     * @param key
     * @return ActDeModel
     */
    ActDeModel getByKey(@Param("modelKey") String key);
}
