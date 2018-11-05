package com.masspick.peak.guest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.masspick.peak.guest.model.LoanContractInfo;

/**
 * LoanContractInfoMapper
 */
@Mapper
public interface LoanContractInfoMapper {
    /**
     *  单条插入
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") LoanContractInfo pojo);

    /**
     * 批量插入
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<LoanContractInfo> pojo);

    /**
     * 根据id更新
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") LoanContractInfo pojo);

    /**
     * 根据订单id查找合同信息
     * @param loanId 订单id
     * @return LoanContractInfo
     */
    LoanContractInfo findByLoanId(@Param("loanId") String loanId);
}
