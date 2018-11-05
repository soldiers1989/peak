package com.masspick.peak.guest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.masspick.peak.guest.model.WhiteListEtp;

/**
 * WhiteListEtpMapper
 */
@Mapper
public interface WhiteListEtpMapper {
    /**
     * @param pojo
     * @return int
     */
    int insert(@Param("pojo") WhiteListEtp pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertSelective(@Param("pojo") WhiteListEtp pojo);

    /**
     * @param pojo
     * @return int
     */
    int insertList(@Param("pojos") List<WhiteListEtp> pojo);

    /**
     * @param pojo
     * @return int
     */
    int update(@Param("pojo") WhiteListEtp pojo);

    /**
     * @param etpName
     * @return WhiteListEtp
     */
    WhiteListEtp findByEtpName(@Param("etpName") String etpName);
}
