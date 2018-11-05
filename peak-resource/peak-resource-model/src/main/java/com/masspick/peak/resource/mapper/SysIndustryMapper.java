package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.model.SysIndustry;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * SysIndustryMapper
 */
public interface SysIndustryMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") SysIndustry pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysIndustry pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysIndustry> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") SysIndustry pojo);

    /**
     * @param id
     * @return int
     */
    int deleteById(@Param("id") String id);

    /**
     * @param id
     * @return SysIndustry
     */
    SysIndustry findById(@Param("id") String id);

    /**
     * @param queryParams
     * @return List
     */
    List<SysIndustry> selectByQueryParams(Map<String, Object> queryParams);

    /**
     * @param queryParams
     * @return List
     */
    List<SysIndustry> select(Map<String, Object> queryParams);
}
