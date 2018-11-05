package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.model.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * SysMenuMapper
 */
@Mapper
public interface SysMenuMapper {
    /**
     * @param pojo
     * @return  int
     */
    int insert(@Param("pojo") SysMenu pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysMenu pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysMenu> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") SysMenu pojo);

    /**
     * @param userId
     * @return List
     */
    List<String> selectMenuIdsByUserId(String userId);

    /**
     * @param userId
     * @return List
     */
    List<String> selectResourceByUserId(String userId);

    /**
     * @param pid
     * @param idList
     * @return List
     */
    List<SysMenu> findByPidAndIdInOrderBySort(@Param("pid") String pid, @Param("idList") List<String> idList);

    /**
     * @param pid
     * @return List
     */
    List<SysMenu> findByPidOrderBySort(@Param("pid") String pid);

    /**
     * @param queryParams
     * @return List
     */
    List<SysMenu> selectByQueryParams(Map<String, Object> queryParams);

    /**
     * @param pid
     * @return List
     */
    List<SysMenu> findByPidOrderByCode(@Param("pid") String pid);

    /**
     * @param id
     * @return SysMenu
     */
    SysMenu findById(@Param("id") String id);

    /**
     * @param id
     * @return int
     */
    int deleteById(@Param("id") String id);

    /**
     * @param resource
     * @return List
     */
    List<SysMenu> findByResource(@Param("resource") String resource);

    /**
     * @param queryParams
     * @return List
     */
    List<SysMenu> selectListByUserId(Map<String, Object> queryParams);
}
