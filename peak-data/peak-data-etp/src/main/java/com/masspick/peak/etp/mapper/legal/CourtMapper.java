package com.masspick.peak.etp.mapper.legal;

import com.masspick.peak.model.legal.Court;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * CourtMapper
 */
@Mapper
public interface CourtMapper {

    /**
     * @param record
     * @return int
     */
    int insert(Court record);


    /**
     * @param record
     * @return int
     */
    int insertSelective(Court record);

    /**
     * @param etpId
     * @param type
     * @return List<Court>
     */
    List<Court> findByEtpId(@Param("etpId") String etpId, @Param("type") String type);
}
