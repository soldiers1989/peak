package com.masspick.peak.dd.mapper;

import com.masspick.peak.dd.model.DdSequence;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * DdSequenceMapper
 */
@Mapper
public interface DdSequenceMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") DdSequence pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") DdSequence pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<DdSequence> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") DdSequence pojo);
}
