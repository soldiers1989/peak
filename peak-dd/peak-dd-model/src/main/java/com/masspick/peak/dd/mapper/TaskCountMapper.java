package com.masspick.peak.dd.mapper;

import com.masspick.peak.dd.model.TaskCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TaskCountMapper
 */
@Mapper
public interface TaskCountMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") TaskCount pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") TaskCount pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<TaskCount> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") TaskCount pojo);

    /**
     * @return TaskCount
     */
    TaskCount maxTaskCount();
}
