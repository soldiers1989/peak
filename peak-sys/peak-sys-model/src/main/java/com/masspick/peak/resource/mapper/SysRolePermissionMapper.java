package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.entity.SysRolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysRolePermissionMapper
 */
@Mapper
public interface SysRolePermissionMapper {

    /**
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysRolePermission pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysRolePermission pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysRolePermission> pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysRolePermission pojo);

    /**
     * @param roleId roleId
     * @param appId  appId
     * @return int
     */
    int deleteByRoleId(@Param("roleId") String roleId, @Param("appId") String appId);
}
