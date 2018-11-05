package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.entity.SysPermission;
import com.masspick.peak.resource.entity.bo.PermissionNode;
import com.masspick.peak.resource.entity.bo.SysPermissionBO;
import com.masspick.peak.resource.vo.ModifyChildVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysPermissionMapper
 */
@Mapper
public interface SysPermissionMapper {

    /**
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysPermission pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysPermission pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojo") List<SysPermission> pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysPermission pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int updateStatus(@Param("pojo") SysPermission pojo);

    /**
     * @param code  code
     * @param appId appId
     * @return SysPermission
     */
    SysPermission findByCodeAndAppId(@Param("code") String code, @Param("appId") String appId);

    /**
     * @param appId appId
     * @return List
     */
    List<SysPermission> findListByAppId(@Param("appId") String appId);

    /**
     * @param appId appId
     * @param id    id
     * @return List
     */
    List<SysPermission> editPermission(@Param("appId") String appId, @Param("id") String id);

    /**
     * @param id id
     * @return List
     */
    List<SysPermission> findChildrenById(@Param("id") String id);

    /**
     * @param id id
     * @return SysPermission
     */
    SysPermission findOne(@Param("id") String id);

    /**
     * @param pojo pojo
     * @return int
     */
    int updateChildrenCode(@Param("pojo") ModifyChildVo pojo);

    /**
     * 编辑时更新所有子集的
     *
     * @param parentCode  parentCode
     * @param formerLevel formerLevel
     * @param id          id
     * @param appId       appId
     * @return int
     */
    int updateChildrenPermission(@Param("parentCode") String parentCode, @Param("formerLevel") Integer formerLevel,
                                 @Param("id") String id, @Param("appId") String appId);

    /**
     * @return int
     */
    int updateChildrenDeep();

    /**
     * @param account account
     * @param appId   appId
     * @return List
     */
    List<SysPermissionBO> findByAccountNameAndAppId(@Param("userId") String account, @Param("appId") String appId);

    /**
     * @param roleId roleId
     * @param appId  appId
     * @return List
     */
    List<PermissionNode> findByRoleIdAndAppId(@Param("roleId") String roleId, @Param("appId") String appId);

    /**
     * @param id id
     * @return int
     */
    int findUnableParentCount(@Param("id") String id);

    /**
     *
     * @param account 账号
     * @param appId 应用id
     * @return int
     */
    int findPermCountByAccoutAndAppId(@Param("account") String account, @Param("appId") String appId);
}
