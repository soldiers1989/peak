package com.masspick.peak.guest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.masspick.peak.guest.model.FlowProcess;

/**
 * FlowProcessMapper
 */
@Mapper
public interface FlowProcessMapper {
    /**
     * 单条插入
     * @param pojo pojo
     * @return pojo
     */
    int insert(@Param("pojo") FlowProcess pojo);

    /**
     * 批量插入
     * @param pojo pojo
     * @return pojo
     */
    int insertList(@Param("pojos") List<FlowProcess> pojo);

    /**
     * 更新
     * @param pojo
     * @return pojo
     */
    int update(@Param("pojo") FlowProcess pojo);

    /**
     * 通过流程id查找流程
     * @param flowId 流程id
     * @return FlowProcess
     */
    FlowProcess findByFlowId(@Param("flowId") String flowId);

    /**
     *  通过贷款id查找流程
     * @param loanId 贷款id
     * @return FlowProcess
     */
    FlowProcess findByLoanId(@Param("loanId") String loanId);

    /**
     * 通过用户id查找流程
     * @param userId 用户id
     * @return List
     */
    List<FlowProcess> findByUserId(@Param("userId") String userId);

    /**
     *  查找处理完成的流程
     * @param userId 用户id
     * @return   List<FlowProcess>
     */
    List<FlowProcess> findFinishByUserId(@Param("userId") String userId);

}
