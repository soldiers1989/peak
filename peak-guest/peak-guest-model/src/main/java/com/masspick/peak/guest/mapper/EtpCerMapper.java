package com.masspick.peak.guest.mapper;

import com.masspick.peak.guest.bo.EtpCerBo;
import com.masspick.peak.guest.vo.manage.CountMapVo;
import com.masspick.peak.guest.vo.manage.EtpCerInvitePageVo;
import com.masspick.peak.guest.vo.manage.EtpCerPageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import com.masspick.peak.guest.model.EtpCer;

/**
 * EtpCerMapper
 */
@Mapper
public interface EtpCerMapper {
    /**
     * 单条插入
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") EtpCer pojo);

    /**
     * 批量插入
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<EtpCer> pojo);

    /**
     *  更新
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") EtpCer pojo);

    /**
     *  通过手机号和用户id查找
     * @param mobile 用户手机号
     * @param etpName 公司名称
     * @return EtpCer
     */
    List<EtpCer> findByMobileAndEtpName(@Param("mobile") String mobile, @Param("etpName") String etpName);

    /**
     * 通过id查找
     * @param id id
     * @return EtpCer
     */
    EtpCer findById(@Param("id") String id);

    /**
     * 多条资质认证查询
     * @param userId 用户id
     * @param status 状态
     * @return  List<EtpCer>
     */
    List<EtpCer> findEtpCerList(@Param("userId") String userId, @Param("status") String status);

    /**
     * 分页查询
     * @param etpCerBo 分页查找对象
     * @return List
     */
    List<EtpCerPageVo> findByPage(@Param("pojo") EtpCerBo etpCerBo);

    /**
     * 员工工号统计
     * @param map map
     * @return Integer
     */
    Integer countForNumber(Map<String,String> map);

    /**
     * 分页查询拉取的公司
     * @param number
     * @return List
     */
    List<EtpCerInvitePageVo> findList(@Param("number") String number);


    List<CountMapVo> findCountByMonth(@Param("number") String number);
}
