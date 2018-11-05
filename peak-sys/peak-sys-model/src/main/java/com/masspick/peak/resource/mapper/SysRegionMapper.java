package com.masspick.peak.resource.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.masspick.peak.resource.entity.SysRegion;

/**
 * sys
 */
@Mapper
public interface SysRegionMapper {

    /**
     *
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysRegion pojo);

    /**
     *
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysRegion pojo);

    /**
     *
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysRegion> pojo);

    /**
     *
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysRegion pojo);
}
