package com.masspick.peak.mapper;

import com.masspick.peak.model.ActPushMsg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ActPushMsgMapper
 */
@Mapper
public interface ActPushMsgMapper {

    /**
     * insert
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") ActPushMsg pojo);
}
