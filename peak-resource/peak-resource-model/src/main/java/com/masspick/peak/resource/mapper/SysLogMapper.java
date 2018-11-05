package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.model.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * SysLogMapper
 */
@Mapper
public interface SysLogMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") SysLog pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysLog pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysLog> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") SysLog pojo);

    /**
     * @param id
     * @return SysLog
     */
    SysLog findById(@Param("id") String id);

    /**
     * @param minCreateTime
     * @param maxCreateTime
     * @return List
     */
    List<SysLog> findByCreateTimeBetween(@Param("minCreateTime") Date minCreateTime, @Param("maxCreateTime") Date
            maxCreateTime);

    /**
     * @param queryParams
     * @return List
     */
    List<SysLog> selectByQueryParams(Map<String, Object> queryParams);
}
