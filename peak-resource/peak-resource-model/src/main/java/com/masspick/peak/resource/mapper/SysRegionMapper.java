package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.model.SysRegion;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * SysRegionMapper
 */
public interface SysRegionMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") SysRegion pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysRegion pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysRegion> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") SysRegion pojo);

    /**
     * @param id
     * @return SysRegion
     */
    SysRegion findById(@Param("id") String id);

    /**
     * @param queryParams
     * @return List
     */
    List<SysRegion> selectByQueryParams(Map<String, Object> queryParams);

    /**
     * @param queryParams
     * @return List
     */
    List<SysRegion> select(Map<String, Object> queryParams);
}
