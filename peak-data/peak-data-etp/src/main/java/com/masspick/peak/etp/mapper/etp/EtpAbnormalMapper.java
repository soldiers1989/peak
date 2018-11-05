package com.masspick.peak.etp.mapper.etp;

import com.masspick.peak.model.etp.EtpAbnormal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * EtpAbnormalMapper
 */
@Mapper
public interface EtpAbnormalMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_abnormal_all
     *
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     * @return int
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_abnormal_all
     *
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     * @return int
     */
    int insert(EtpAbnormal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_abnormal_all
     *
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     * @return int
     */
    int insertSelective(EtpAbnormal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_abnormal_all
     *
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     * @return int
     */
    EtpAbnormal selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_abnormal_all
     *
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     * @return int
     */
    int updateByPrimaryKeySelective(EtpAbnormal record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_abnormal_all
     *
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     * @return int
     */
    int updateByPrimaryKey(EtpAbnormal record);

    /**
     * @param etpId
     * @return List<EtpAbnormal>
     */
    List<EtpAbnormal> findByEtpId(@Param("etpId") String etpId);
}
