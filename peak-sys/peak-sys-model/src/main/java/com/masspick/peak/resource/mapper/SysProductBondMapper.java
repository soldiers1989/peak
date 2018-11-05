package com.masspick.peak.resource.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.masspick.peak.resource.entity.SysProductBond;

@Mapper
public interface SysProductBondMapper {
    /**
     *
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") SysProductBond pojo);

    /**
     *
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysProductBond pojo);

    /**
     *
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysProductBond> pojo);

    /**
     *
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") SysProductBond pojo);

    /**
     *
     * @param productId
     * @return  List<SysProductBond>
     */
    List<SysProductBond> findByProductId(@Param("productId") String productId);

    /**
     * @param productId productId
     * @return int
     */
    int deleteByProductId(@Param("productId") String productId);
}
