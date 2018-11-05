package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysUserRoleMapper
 */
@Mapper
public interface SysUserRoleMapper {

    /**
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysUserRole pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysUserRole pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysUserRole> pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysUserRole pojo);

    /**
     * @param userId userId
     * @return List
     */
    List<SysUserRole> findByUserId(@Param("userId") String userId);

    /**
     * @param userId userId
     * @return Integer
     */
    Integer deleteByUserId(@Param("userId") String userId);
}
