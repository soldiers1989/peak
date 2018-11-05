package com.masspick.peak.etp.mapper.etp;

import com.masspick.peak.model.etp.EtpLicence;
import org.apache.ibatis.annotations.Mapper;

/**
 * EtpLicenceMapper
 */
@Mapper
public interface EtpLicenceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_licence_all
     *
     * @return int
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_licence_all
     *
     * @return int
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     */
    int insert(EtpLicence record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_licence_all
     *
     * @return int
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     */
    int insertSelective(EtpLicence record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_licence_all
     *
     * @return int
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     */
    EtpLicence selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_licence_all
     *
     * @return int
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     */
    int updateByPrimaryKeySelective(EtpLicence record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_licence_all
     *
     * @return int
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     */
    int updateByPrimaryKey(EtpLicence record);
}