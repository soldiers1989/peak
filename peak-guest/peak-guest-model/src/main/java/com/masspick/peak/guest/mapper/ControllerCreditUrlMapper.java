package com.masspick.peak.guest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.masspick.peak.guest.model.ControllerCreditUrl;

/**
 * ControllerCreditUrlMapper
 */
@Mapper
public interface ControllerCreditUrlMapper {
    /**
     * 单条插入
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") ControllerCreditUrl pojo);

    /**
     * 批量插入
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<ControllerCreditUrl> pojo);

    /**
     *  更新
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") ControllerCreditUrl pojo);


    /**
     *  根据订单id查找征信地址
     * @param loanId 申请单id
     * @return List<String>
     */
    List<String> findCreditUrls(@Param("loanId") String loanId);
}
