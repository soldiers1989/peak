package com.masspick.peak.etp.mapper.etp;

import com.masspick.peak.model.etp.EtpIll;
import org.apache.ibatis.annotations.Mapper;

/**
 * EtpIllMapper
 */
@Mapper
public interface EtpIllMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_ill_all
     *
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     * @return int
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_ill_all
     *
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     * @return int
     */
    int insert(EtpIll record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_ill_all
     *
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     * @return int
     */
    int insertSelective(EtpIll record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_ill_all
     *
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     * @return int
     */
    EtpIll selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_ill_all
     *
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     * @return int
     */
    int updateByPrimaryKeySelective(EtpIll record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_ill_all
     *
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     * @return int
     */
    int updateByPrimaryKey(EtpIll record);
}