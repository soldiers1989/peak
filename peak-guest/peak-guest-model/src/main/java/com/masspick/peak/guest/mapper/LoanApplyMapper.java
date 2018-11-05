package com.masspick.peak.guest.mapper;

import com.masspick.peak.guest.bo.LoanApplyBo;
import com.masspick.peak.guest.bo.LoanApplyShowVo;
import com.masspick.peak.guest.bo.LoanEtpVo;
import com.masspick.peak.guest.vo.client.RepayDetail;
import com.masspick.peak.guest.vo.manage.CountMapVo;
import com.masspick.peak.guest.vo.manage.LoanApplyPageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.masspick.peak.guest.model.LoanApply;

import javax.validation.constraints.Past;

/**
 * LoanApplyMapper
 */
@Mapper
public interface LoanApplyMapper {
    /**
     * 单条插入
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") LoanApply pojo);


    /**
     * 批量插入
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<LoanApply> pojo);

    /**
     * 根据id更新
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") LoanApply pojo);

    /**
     *  通过公司名称和用户id查找订单
     * @param etpName 公司名称
     * @return List
     */
    List<LoanApply> findLoanByEtpName(@Param("etpName") String etpName);


    /**
     * 通过id查找订单
     * @param id id
     * @return LoanApply
     */
    LoanApply findLoanById(@Param("id") String id);

    /**
     * 通过id连接获取明细
     * @param id id
     * @return LoanApplyShowVo
     */
    LoanApplyShowVo findDetailById(@Param("id") String id);

    /**
     * 通过用户id查找订单
     * @param userId 用户id
     * @return List
     */
    List<LoanApply> findLoanByUserId(@Param("userId") String userId);

    /**
     * 查询还款汇总信息
     * @param id 订单id
     * @return RepayDetail
     */
    RepayDetail findRepayInfoById(@Param("id") String id);

    /**
     * 通过用户id获取订单
     * @param userId 用户id
     * @return List<LoanApply>
     */
    List<LoanApply> findByUserId(@Param("userId") String userId);

    /**
     * 分页查询订单
     * @param pojo pojo
     * @return List
     */
    List<LoanApplyPageVo> findByPage(@Param("pojo") LoanApplyBo pojo);

    /**
     *  汇总金额
     * @param status status
     * @return Integer
     */
    Integer findTotalAmountByStatus(@Param("status") String status);

    /**
     *  汇总订单总数
     * @param pojo pojo
     * @return Integer
     */
    Integer findCountByParam(@Param("pojo") LoanApply pojo);


    /**
     * 巅峰人员对应公司总金额
     * @param number number
     * @return Integer
     */
    Integer findSumFromNumber(@Param("number") String number);

    /**
     *
     * @param number number
     * @return Integer
     */
    Integer findCountByNumber(@Param("number") String number);

    /**
     * 巅峰人员对应公司总金额
     * @param etpName etpName
     * @return List
     */
    List<LoanEtpVo> findLoanOrderByEtpName(@Param("etpName") String etpName);

    /**
     * 分页
     * @param number
     * @return List<LoanEtpVo>
     */
    List<LoanEtpVo> findList(@Param("number") String number);

    /**
     * 巅峰对应月份 数量
     * @param number
     * @return List<CountMapVo>
     */
    List<CountMapVo> findCountByMonth(@Param("number") String number);

}
