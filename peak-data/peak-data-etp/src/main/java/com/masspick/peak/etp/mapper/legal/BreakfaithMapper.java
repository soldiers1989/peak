package com.masspick.peak.etp.mapper.legal;


import com.masspick.peak.model.legal.Breakfaith;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * BreakfaithMapper
 */
@Mapper
public interface BreakfaithMapper {

    /**
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(String id);


    /**
     * @param record
     * @return int
     */
    int insert(Breakfaith record);


    /**
     * @param record
     * @return int
     */
    int insertSelective(Breakfaith record);


    /**
     * @param id
     * @return Breakfaith
     */
    Breakfaith selectByPrimaryKey(String id);


    /**
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Breakfaith record);


    /**
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Breakfaith record);

    /**
     * @param company
     * @return List<Breakfaith>
     */
    List<Breakfaith> findByEtpId(@Param("company") String company);
}
