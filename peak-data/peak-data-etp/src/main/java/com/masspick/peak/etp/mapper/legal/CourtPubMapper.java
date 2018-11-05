package com.masspick.peak.etp.mapper.legal;

import com.masspick.peak.model.legal.CourtPub;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * CourtPubMapper
 */
@Mapper
public interface CourtPubMapper {

    /**
     * @param record
     * @return int
     */
    int insert(CourtPub record);

    /**
     * @param record
     * @return int
     */
    int insertSelective(CourtPub record);

    /**
     * @param etpId
     * @return List<CourtPub>
     */
    List<CourtPub> findByEtpId(@Param("etpId") String etpId);
}
