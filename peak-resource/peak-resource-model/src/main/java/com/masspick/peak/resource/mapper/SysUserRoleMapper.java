package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.model.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysUserRoleMapper
 */
@Mapper
public interface SysUserRoleMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") SysUserRole pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysUserRole pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysUserRole> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") SysUserRole pojo);

    /**
     * @param userId
     * @return int
     */
    int deleteByUserId(@Param("userId") String userId);

    /**
     * @param userId
     * @return List
     */
    List<SysUserRole> findByUserId(@Param("userId") String userId);

    /**
     * @param roleId
     * @return List
     */
    List<SysUserRole> findByRoleId(@Param("roleId") String roleId);

    /**
     * @param roleId
     * @return Long
     */
    Long countByRoleId(@Param("roleId") String roleId);
}
