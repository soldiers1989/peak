package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.entity.SysUser;
import com.masspick.peak.resource.vo.UserFindVo;
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
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysUser pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysUser pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysUser> pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysUser pojo);

    /**
     * @param userFindVo userFindVo
     * @return List
     */
    List<SysUser> findList(@Param("pojo") UserFindVo userFindVo);

    /**
     * @param id id
     * @return SysUser
     */
    SysUser findOneById(@Param("id") String id);

    /**
     * @param account account
     * @return SysUser
     */
    SysUser findOneByAccount(@Param("account") String account);

    /**
     * @param userId userId
     * @return SysUser
     */
    List<String> findRoleListById(@Param("userId") String userId);


    /**
     * @param account  account
     * @param password password
     * @return SysUser
     */
    SysUser findByAccountAndPassword(@Param("account") String account, @Param("password") String password);

    /**
     * @param map
     * @return List
     */
    List<SysUser> findUserByRoleAndAreaName(Map<String, String> map);
}
