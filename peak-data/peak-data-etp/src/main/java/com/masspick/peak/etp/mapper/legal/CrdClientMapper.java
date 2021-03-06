package com.masspick.peak.etp.mapper.legal;

import com.masspick.peak.model.legal.CrdClient;
import org.apache.ibatis.annotations.Mapper;

/**
 * CrdClientMapper
 */
@Mapper
public interface CrdClientMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.crd_client
     *
     * @mbggenerated Mon Jun 11 19:05:06 CST 2018
     * @return int
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.crd_client
     *
     * @mbggenerated Mon Jun 11 19:05:06 CST 2018
     * @return int
     */
    int insert(CrdClient record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.crd_client
     *
     * @mbggenerated Mon Jun 11 19:05:06 CST 2018
     * @return int
     */
    int insertSelective(CrdClient record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.crd_client
     *
     * @mbggenerated Mon Jun 11 19:05:06 CST 2018
     * @return int
     */
    CrdClient selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.crd_client
     *
     * @mbggenerated Mon Jun 11 19:05:06 CST 2018
     * @return int
     */
    int updateByPrimaryKeySelective(CrdClient record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.crd_client
     *
     * @mbggenerated Mon Jun 11 19:05:06 CST 2018
     * @return int
     */
    int updateByPrimaryKey(CrdClient record);
}
