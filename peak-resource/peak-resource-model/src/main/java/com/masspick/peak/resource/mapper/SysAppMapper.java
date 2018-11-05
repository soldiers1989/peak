package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.model.SysApp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * SysAppMapper
 */
@Mapper
public interface SysAppMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") SysApp pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysApp pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysApp> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") SysApp pojo);

    /**
     * @param id
     * @return SysApp
     */
    SysApp findById(@Param("id") String id);

    /**
     * @param queryParams
     * @return List
     */
    List<SysApp> selectByQueryParams(Map<String, Object> queryParams);

    /**
     * @param queryParams
     * @return List
     */
    List<SysApp> select(Map<String, Object> queryParams);
}
