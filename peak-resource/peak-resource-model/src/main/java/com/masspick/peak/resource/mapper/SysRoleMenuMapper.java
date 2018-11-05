package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.model.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysRoleMenuMapper
 */
@Mapper
public interface SysRoleMenuMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") SysRoleMenu pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysRoleMenu pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysRoleMenu> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") SysRoleMenu pojo);

    /**
     * @param roleId
     * @return int
     */
    int deleteByRoleId(@Param("roleId") String roleId);


    /**
     * @param roleId
     * @return List
     */
    List<SysRoleMenu> findByRoleId(@Param("roleId") String roleId);


    /**
     * 根据用户Id获取用户所在角色的权限
     *
     * @param uid
     * @return List
     */
    List<String> selectRoleMenuIdsByUserId(String uid);

}
