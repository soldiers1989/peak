package com.masspick.peak.etp.mapper.etp;

import com.masspick.peak.model.etp.EtpDoubleSampling;
import org.apache.ibatis.annotations.Mapper;

/**
 * EtpDoubleSamplingMapper
 */
@Mapper
public interface EtpDoubleSamplingMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_double_sampling_all
     *
     * @return int
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     */
    int insert(EtpDoubleSampling record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_double_sampling_all
     *
     * @return int
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     */
    int insertSelective(EtpDoubleSampling record);
}
