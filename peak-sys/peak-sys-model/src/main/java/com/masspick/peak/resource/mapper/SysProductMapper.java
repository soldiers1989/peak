package com.masspick.peak.resource.mapper;

import com.masspick.peak.resource.vo.ProductDataGridFindVo;
import com.masspick.peak.resource.vo.ProductDataGridResultVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.masspick.peak.resource.entity.SysProduct;

/**
 * SysProductMapper
 */
@Mapper
public interface SysProductMapper {

    /**
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") SysProduct pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertSelective(@Param("pojo") SysProduct pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<SysProduct> pojo);

    /**
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") SysProduct pojo);

    /**
     * @param pojo pojo
     * @return  List<ProductDataGridResultVo>
     */
    List<ProductDataGridResultVo> findByPage(@Param("pojo") ProductDataGridFindVo pojo);

    /**
     * @param id id
     * @return SysProduct
     */
    SysProduct findSingleById(@Param("id") String id);

    /**
     *
     * @param number number
     * @return SysProduct
     */
    SysProduct findSingleByNum(@Param("number") String number);

    /**
     * 查询所有产品
     * @return List
     */
    List<SysProduct> find();

    /**
     * 根据id查询产品
     * @return List
     */
    List<SysProduct> findByIds(@Param("ids")List<String> ids);

    /**
     * @param applicationDate
     * @return String
     */
    String serialNum(@Param("applicationDate")String applicationDate);
}
