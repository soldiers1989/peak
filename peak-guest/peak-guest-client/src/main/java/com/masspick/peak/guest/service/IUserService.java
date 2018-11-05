package com.masspick.peak.guest.service;

import com.masspick.peak.guest.model.UserWeiXin;
import com.masspick.peak.guest.vo.ApiResponse;
import org.springframework.validation.BindingResult;

/**
 * IUserService
 */
public interface IUserService {
     /**
      * @param userWeiXin 用户信息
      * @return ApiResponse
      */
     ApiResponse saveUser(UserWeiXin userWeiXin, BindingResult bindingResult);

     /**
      * @param openId 用户微信唯一标识
      * @return ApiResponse
      */
     ApiResponse findUserByOpenId(String openId);

     /**
      * 巅峰人员相关统计数据
      * @param number 工号
      * @return ApiResponse
      */
     ApiResponse findUserCountByNumber(String number);

     /**
      *  通过手机号查找用户
      * @param mobile moible
      * @return UserWeiXin
      */
     UserWeiXin findUserByMobile(String mobile);

     /**
      *  h5端添加用户
      * @param userWeiXin 用户
      * @return UserWeiXin
      */
     UserWeiXin saveUser(UserWeiXin userWeiXin);
}
