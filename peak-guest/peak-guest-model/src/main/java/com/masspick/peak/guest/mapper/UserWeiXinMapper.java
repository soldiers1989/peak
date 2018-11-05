package com.masspick.peak.guest.mapper;

import com.masspick.peak.guest.bo.UserWeiXinFindBo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.masspick.peak.guest.model.UserWeiXin;

/**
 * UserWeiXinMapper
 */
@Mapper
public interface UserWeiXinMapper {
    /**
     * 单条插入
     * @param pojo pojo
     * @return int
     */
    int insert(@Param("pojo") UserWeiXin pojo);

    /**
     * 批量插入
     * @param pojo pojo
     * @return int
     */
    int insertList(@Param("pojos") List<UserWeiXin> pojo);

    /**
     * 通过id更新
     * @param pojo pojo
     * @return int
     */
    int update(@Param("pojo") UserWeiXin pojo);

    /**
     * 通过openId更新
     * @param pojo pojo
     * @return int
     */
    int updateByOpenId(@Param("pojo") UserWeiXin pojo);

    /**
     * 通过openId查询
     * @param openId 微信唯一标识
     * @return UserWeiXin
     */
    UserWeiXin findByOpenId(@Param("openId") String openId);

    /**
     * 通过id查询
     * @param userId  用户id
     * @return UserWeiXin
     */
    UserWeiXin findById(@Param("userId") String userId);

    /**
     *  通过用户账号查找用户
     * @param mobile
     * @return UserWeiXin
     */
    UserWeiXin findByMobile(@Param("mobile") String mobile);

    /**
     *  分页查询
     * @param pojo pojo
     * @return List
     */
    List<UserWeiXin> findByPage(@Param("pojo") UserWeiXinFindBo pojo);

    /**
     *  获取渠道列表
     * @return List<String>
     */
    List<String> findInsList();

    /**
     * 查询用户总数
     * @param pojo  pojo
     * @return Integer
     */
    Integer findCountByParam(@Param("pojo") UserWeiXinFindBo pojo);
}
