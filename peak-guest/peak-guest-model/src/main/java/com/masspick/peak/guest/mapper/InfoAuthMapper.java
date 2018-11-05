package com.masspick.peak.guest.mapper;

import com.masspick.peak.guest.bo.InfoAuthBo;
import com.masspick.peak.guest.vo.manage.InfoAuthVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.masspick.peak.guest.model.InfoAuth;

/**
 * InfoAuthMapper
 */
@Mapper
public interface InfoAuthMapper {
    /**
     *  单条插入
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") InfoAuth pojo);

    /**
     *  批量插入
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<InfoAuth> pojo);

    /**
     *  根据id更新
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") InfoAuth pojo);

    /**
     * 根据cerId更新
     * @param pojo pojo
     * @return int
     */
    int updateByCerId(@Param("pojo") InfoAuth pojo);

    /**
     *  根据企业资质id查询信息采集授权
     * @param etpCerId 企业资质认证id
     * @return  InfoAuth
     */
    InfoAuth findByEtpCerId(@Param("etpCerId") String etpCerId);

    /**
     *  根据d查询信息采集授权
     * @param id
     * @return InfoAuth
     */
    InfoAuth findById(@Param("id") String id);


    /**
     * 信息采集分页查询
     * @param pojo pojo
     * @return List<InfoAuthVo>
     */
    List<InfoAuthVo> findByPage(@Param("pojo") InfoAuthBo pojo);
}
