package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.entity.SysIndustry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysIndustryMapper
 */
@Mapper
public interface SysIndustryMapper {

    /**
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysIndustry pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysIndustry pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysIndustry> pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysIndustry pojo);

    /**
     * @param name name
     * @param code code
     * @return List
     */
    List<SysIndustry> findByNameAndCode(@Param("name") String name, @Param("code") String code);

}
