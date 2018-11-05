package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.entity.SysApp;
import com.masspick.peak.resource.vo.AppFindVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SysAppMapper
 */
@Mapper
public interface SysAppMapper {

    /**
     * insert
     *
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysApp pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysApp pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysApp> pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysApp pojo);

    /**
     * @param pojo pojo
     * @return List
     */
    List<SysApp> findList(@Param("pojo") AppFindVo pojo);

    /**
     * @param id id
     * @return SysApp
     */
    SysApp findOne(@Param("id") String id);

    /**
     * @return List
     */
    List<SysApp> findAll();

    /**
     * @param appId appId
     * @return SysApp
     */
    SysApp findByAppId(@Param("appId") String appId);

    /**
     *
     * @param appIdList appIdList
     * @return List
     */
    List<SysApp> findByAppIdin(@Param("appIdList")List<String> appIdList);

    /**
     *
     * @param appId appId
     * @return  List<SysApp>
     */
    List<SysApp> findAllExceptSelf(@Param("appId")String appId);
}
