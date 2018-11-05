package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.entity.SysRole;
import com.masspick.peak.resource.entity.SysUser;
import com.masspick.peak.resource.vo.RoleFindListVo;
import com.masspick.peak.resource.vo.RolesFromUserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysRoleMapper
 */
@Mapper
public interface SysRoleMapper {

    /**
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysRole pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysRole pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysRole> pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysRole pojo);

    /**
     * @param pojo pojo
     * @return List
     */
    List<SysRole> findList(@Param("pojo") RoleFindListVo pojo);

    /**
     *
     * @param status status
     * @return List
     */
    List<SysRole> findAllRole(@Param("status") Integer status);

    /**
     * @param id id
     * @return SysRole
     */
    SysRole findById(@Param("id") String id);

    /**
     *
     * @param name name
     * @return SysRole
     */
    SysRole findByName(@Param("name") String name);

    /**
     * @param userId userId
     * @return List
     */
    List<RolesFromUserVo> findRolesByUserId(@Param("userId") String userId);

    /**
     *
     * @param roleId roleId
     * @return  List<SysUser>
     */
    List<SysUser> findUserListByRoleId(@Param("roleId") String roleId);

    /**
     *
     * @param userId 用户id
     * @return  List<SysRole>
     */
    List<SysRole> findRoleListByUserId(@Param("userId") String userId);
}
