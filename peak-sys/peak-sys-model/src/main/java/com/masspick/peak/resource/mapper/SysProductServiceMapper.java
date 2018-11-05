package com.masspick.peak.resource.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.masspick.peak.resource.entity.SysProductService;

/**
 *  产品服务费配置
 */
@Mapper
public interface SysProductServiceMapper {
    /**
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysProductService pojo);


    /**
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysProductService pojo);


    /**
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysProductService> pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysProductService pojo);

    /**
     * @param productId productId
     * @return List<SysProductService>
     */
    List<SysProductService> findByProductId(@Param("productId") String productId);

    /**
     * @param productId productId
     * @return int
     */
    int deleteByProductId(@Param("productId") String productId);
}
