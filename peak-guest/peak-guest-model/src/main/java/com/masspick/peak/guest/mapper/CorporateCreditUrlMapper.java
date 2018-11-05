package com.masspick.peak.guest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.masspick.peak.guest.model.CorporateCreditUrl;

/**
 * CorporateCreditUrlMapper
 */
@Mapper
public interface CorporateCreditUrlMapper {
    /**
     * 单条插入
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") CorporateCreditUrl pojo);


    /**
     * 批量插入
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<CorporateCreditUrl> pojo);

    /**
     * 更新
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") CorporateCreditUrl pojo);

    /**
     *  根据申请单id查找征信地址
     * @param loanId 申请单id
     * @return  List<String>
     */
    List<String> findCreditUrls(@Param("loanId")  String loanId);
}
