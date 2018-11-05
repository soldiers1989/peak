package com.masspick.peak.guest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.masspick.peak.guest.model.Product;

/**
 *  ProductMapper
 */
@Mapper
public interface ProductMapper {
    /**
     *  添加产品
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") Product pojo);

    /**
     *  批量插入
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<Product> pojo);

    /**
     * 更新产品
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") Product pojo);

    /**
     *  查找所有启用的产品的id
     * @return List<String>
     */
    List<String> findAllAbleProducts();

    /**
     *  通过id查询产品
     * @param productId 产品id
     * @return Product
     */
    Product findByProductId(@Param("productId") String productId);
}
