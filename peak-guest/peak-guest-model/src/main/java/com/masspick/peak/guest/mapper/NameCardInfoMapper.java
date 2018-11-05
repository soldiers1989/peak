package com.masspick.peak.guest.mapper;

import com.masspick.peak.guest.bo.NameCardInfoBo;
import com.masspick.peak.guest.vo.manage.NameCardInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.masspick.peak.guest.model.NameCardInfo;

/**
 * NameCardInfoMapper
 */
@Mapper
public interface NameCardInfoMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") NameCardInfo pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") NameCardInfo pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<NameCardInfo> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") NameCardInfo pojo);

    /**
     * @param etpName
     * @param openId
     * @return NameCardInfo
     */
    NameCardInfo findByEtpNameAndOpenId(@Param("etpName") String etpName, @Param("openId") String openId);

    /**
     * @param openId
     * @return List
     */
    List<NameCardInfo> findByOpenId(@Param("openId") String openId);

    /**
     * @param pojo
     * @return List
     */
    List<NameCardInfoVo> findList(@Param("pojo") NameCardInfoBo pojo);

    /**
     * @param id
     * @return int
     */
    int deleteById(@Param("id") String id);

    /**
     * @param id
     * @return NameCardInfo
     */
    NameCardInfo findById(@Param("id") String id);
}
