package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.model.SysUser;
import com.masspick.peak.resource.model.bo.SysUserBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * SysUserMapper
 */
@Mapper
public interface SysUserMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") SysUser pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysUser pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysUser> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") SysUser pojo);

    /**
     * @param id
     * @return int
     */
    int deleteById(@Param("id") String id);

    /**
     * @param userName
     * @return SysUser
     */
    SysUser findByUserName(@Param("userName") String userName);

    /**
     * @param id
     * @return SysUser
     */
    SysUser findById(@Param("id") String id);

    /**
     * @param queryParams
     * @return List
     */
    List<SysUserBO> selectSysUserBoByQueryParams(Map<String, Object> queryParams);

    /**
     * @param idList
     * @return List
     */
    List<SysUser> findByIdIn(@Param("idList") List<String> idList);
}
