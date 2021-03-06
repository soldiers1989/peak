package com.masspick.peak.etp.mapper.etp;

import com.masspick.peak.model.etp.EtpBrand;
import org.apache.ibatis.annotations.Mapper;

/**
 * EtpBrandMapper
 */
@Mapper
public interface EtpBrandMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_brand_all
     *
     * @return int
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_brand_all
     *
     * @return int
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     */
    int insert(EtpBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_brand_all
     *
     * @return int
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     */
    int insertSelective(EtpBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_brand_all
     *
     * @return int
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     */
    EtpBrand selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_brand_all
     *
     * @return int
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     */
    int updateByPrimaryKeySelective(EtpBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.etp_brand_all
     *
     * @return int
     * @mbggenerated Mon Jun 11 10:53:45 CST 2018
     */
    int updateByPrimaryKey(EtpBrand record);
}
