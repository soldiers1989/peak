package com.masspick.peak.dd.mapper;

import com.masspick.peak.dd.model.DueTask;
import com.masspick.peak.dd.model.bo.DueTaskBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * DueTaskMapper
 */
@Mapper
public interface DueTaskMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") DueTask pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") DueTask pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<DueTask> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") DueTask pojo);

    /**
     * @param state
     * @param taskNum
     * @return List<DueTaskBO>
     */
    List<DueTaskBO> dataGrid(@Param("state") Integer state, @Param("taskNum") String taskNum);

    /**
     * @param id
     * @return DueTask
     */
    DueTask findById(@Param("id") String id);

    /**
     * @param id
     * @return DueTaskBO
     */
    DueTaskBO findByTaskBO(@Param("id") String id);

    /**
     * @param id
     * @param state
     * @return int
     */
    int updateState(@Param("id") String id, @Param("state") Integer state);

    /**
     * @param executorId
     * @param flag
     * @return List<DueTask>
     */
    List<DueTask> findByExecutorId(@Param("executorId") String executorId, @Param("flag") Boolean flag);

    /**
     * 统计任务数
     *
     * @return Integer
     */
    Integer count();

    /**
     * @return Integer
     */
    Integer countByState();

    /**
     * @param createTime
     * @return Integer
     */
    Integer countByCreateTime(@Param("createTime") Date createTime);

    /**
     * @param createTime
     * @return Integer
     */
    Integer countByCreateTimeAndState(@Param("createTime") Date createTime);

    /**
     * @param processId
     * @return DueTask
     */
    DueTask findByProcessId(@Param("processId") String processId);

}
