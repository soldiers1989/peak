package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * SysLogMapper
 */
@Mapper
public interface SysLogMapper {

    /**
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysLog pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysLog pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysLog> pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysLog pojo);

    /**
     * @param startDate startDate
     * @param endDate   endDate
     * @param title     title
     * @return List
     */
    List<SysLog> find(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("title") String title);
}
