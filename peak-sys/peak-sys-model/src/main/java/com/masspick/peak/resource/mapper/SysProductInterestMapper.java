package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.entity.SysProductInterest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品利率配置
 */
@Mapper
public interface SysProductInterestMapper {

    /**
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysProductInterest pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysProductInterest pojo);

    /**
     * @param pojos pojos
     * @return int
     */
    int insertList(@Param("pojos") List<SysProductInterest> pojos);

    /**
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysProductInterest pojo);

    /**
     * @param productId productId
     * @return List<SysProductInterest>
     */
    List<SysProductInterest> findByProductId(@Param("productId") String productId);

    /**
     * @param productId productId
     * @return int
     */
    int deleteByProductId(@Param("productId") String productId);
}
