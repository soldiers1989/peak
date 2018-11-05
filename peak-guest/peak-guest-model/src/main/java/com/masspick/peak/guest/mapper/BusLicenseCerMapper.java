package com.masspick.peak.guest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.masspick.peak.guest.model.BusLicenseCer;

/**
 * BusLicenseCerMapper
 */
@Mapper
public interface BusLicenseCerMapper {
    /**
     * 单条更新
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") BusLicenseCer pojo);


    /**
     * 批量更新
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<BusLicenseCer> pojo);

    /**
     * 根据id更新
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") BusLicenseCer pojo);

    /**
     * 根据认证id更新
     * @param pojo pojo
     * @return  int
     */
    int updateByCerId(@Param("pojo") BusLicenseCer pojo);

    /**
     * @param cerId 认证id
     * @return BusLicenseCer
     */
    BusLicenseCer findByCerId(@Param("cerId") String cerId);
}
