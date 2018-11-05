package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.entity.SysUserArea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysUserAreaMapper
 */
@Mapper
public interface SysUserAreaMapper {

    /**
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysUserArea pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysUserArea pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysUserArea> pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysUserArea pojo);

    /**
     * @param userId userId
     * @return int
     */
    int deleteByUserId(@Param("userId") String userId);

    /**
     *
     * @param userId userId
     * @return List
     */
    List<SysUserArea> findByUserId(@Param("userId") String userId);
}
