package com.masspick.peak.guest.mapper;

import com.masspick.peak.guest.model.BodyCer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * BodyCerMapper
 */
@Mapper
public interface BodyCerMapper {
    /**
     * 单条插入
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") BodyCer pojo);

    /**
     * 批量插入
     * @param  pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<BodyCer> pojo);

    /**
     * 更新
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") BodyCer pojo);

    /**
     * 通过认证id查找活体信息
     * @param cerId 认证id
     * @return BodyCer
     */
    BodyCer findByCerId(@Param("cerId") String cerId);
}
