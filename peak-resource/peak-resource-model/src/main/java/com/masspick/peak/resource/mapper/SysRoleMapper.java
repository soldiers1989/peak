package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.model.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * SysRoleMapper
 */
@Mapper
public interface SysRoleMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") SysRole pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysRole pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysRole> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") SysRole pojo);

    /**
     * @param queryParams
     * @return List
     */
    List<SysRole> selectByQueryParams(Map<String, Object> queryParams);

    /**
     * @param id
     * @return SysRole
     */
    SysRole findById(@Param("id") String id);

    /**
     * @param id
     * @return int
     */
    int deleteById(@Param("id") String id);

    /**
     * @param idList
     * @return int
     */
    int deleteByIdIn(@Param("idList") List<String> idList);

    /**
     * @return List
     */
    List<SysRole> find();

    /**
     * @param userId
     * @return List
     */
    List<SysRole> findListByUserId(@Param("userId") String userId);
}
