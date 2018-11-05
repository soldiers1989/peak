package com.masspick.peak.guest.service.impl;


import com.masspick.peak.common.util.StringHelper;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.guest.common.constant.MessageConstant;
import com.masspick.peak.guest.mapper.EtpCerMapper;
import com.masspick.peak.guest.mapper.LoanApplyMapper;
import com.masspick.peak.guest.mapper.MessageMapper;
import com.masspick.peak.guest.mapper.UserWeiXinMapper;
import com.masspick.peak.guest.model.Message;
import com.masspick.peak.guest.model.UserWeiXin;
import com.masspick.peak.guest.service.IUserService;
import com.masspick.peak.guest.vo.ApiResponse;
import com.masspick.peak.service.ISysInsStaffFeignApi;
import com.masspick.peak.service.dto.SysInsStaffDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户
 */
@Service
public class UserServiceImpl implements IUserService {

    /**
     * userWeiXinMapper
     */
    @Autowired
    private UserWeiXinMapper userWeiXinMapper;

    /**
     * messageMapper
     */
    @Autowired
    private MessageMapper messageMapper;
    /**
     *  iSysInsStaffFeignApi
     */
    @Autowired
    private ISysInsStaffFeignApi iSysInsStaffFeignApi;

    /**
     * etpCerMapper
     */
    @Autowired
    private EtpCerMapper etpCerMapper;


    @Autowired
    private LoanApplyMapper loanApplyMapper;

    /**
     * 用户添加
     * @param userWeiXin 用户
     * @return ApiResponse
     */
    @Override
    @Transactional
    public ApiResponse saveUser(UserWeiXin userWeiXin, BindingResult bindingResult) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        //校验参数必填
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        //通过openid查询 有则更新无则新增
        if (userWeiXinMapper.findByMobile(userWeiXin.getMobile()) == null) {
            userWeiXin.preInsert();
            userWeiXin.setRegDate(new Date());
            userWeiXinMapper.insert(userWeiXin);

            Message message = new Message(MessageConstant.SYSTEM_TYPE,
                    MessageConstant.getWelcomeMessage(userWeiXin.getNickName()),
                    MessageConstant.UN_READ_STATUS, userWeiXin.getId());
            message.preInsert();
            messageMapper.insert(message);
        } else {
            userWeiXin.setUpdateDate(new Date());
            userWeiXinMapper.updateByOpenId(userWeiXin);
        }
        return apiResponse.success().setResult(userWeiXinMapper.findByOpenId(userWeiXin.getOpenId()));
    }

    /**
     * 查询用户
     * @param openId 用户微信唯一标识
     * @return ApiResponse
     */
    @Override
    @Transactional
    public ApiResponse findUserByOpenId(String openId) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (StringUtils.isEmpty(openId)) {
            return apiResponse.error("400").setReason("openId不能为空");
        }
        UserWeiXin userWeiXin = userWeiXinMapper.findByOpenId(openId);
        if (userWeiXin == null) {
            return apiResponse.error("401").setReason("openid对应用户不存在");
        }
        return apiResponse.success().setResult(userWeiXin);
    }

    /**
     * 巅峰人员相关统计数据
     * @param number 工号
     * @return ApiResponse
     */
    @Override
    public ApiResponse findUserCountByNumber(String number) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        Map<String,String> map = new HashMap<>();

        //累计邀请的企业
        Map<String,String> selectMap = new HashMap<>();
        selectMap.put("number",number);
        Integer inviteTotalIns = etpCerMapper.countForNumber(selectMap);
        map.put("inviteTotalIns",inviteTotalIns==null?"0":inviteTotalIns.toString());

        //本月邀请的企业
        selectMap.put("month","1");
        Integer inviteInsMonth = etpCerMapper.countForNumber(selectMap);
        map.put("inviteInsMonth",inviteInsMonth==null?"0":inviteInsMonth.toString());
        //企业贷款总金额

        Integer insTotalAmount = loanApplyMapper.findSumFromNumber(number);
        map.put("insTotalAmount",insTotalAmount==null?"0":insTotalAmount.toString());

        return apiResponse.success().setResult(map);
    }

    /**
     *  通过手机号查询用户
     * @param mobile moible
     * @return  UserWeiXin
     */
    @Override
    public UserWeiXin findUserByMobile(String mobile) {
        return userWeiXinMapper.findByMobile(mobile);
    }

    /**
     *   h5用户添加
     * @param userWeiXin 用户
     * @return UserWeiXin
     */
    @Override
    public UserWeiXin saveUser(UserWeiXin userWeiXin) {
        //通过mobile查询 有则更新无则新增
        UserWeiXin dbWeiXin = userWeiXinMapper.findByMobile(userWeiXin.getMobile());
        if (dbWeiXin == null) {
            userWeiXin = getInsInfo(userWeiXin);
            userWeiXin.preInsert();
            userWeiXin.setRegistSource("手机网页");
            userWeiXin.setHeadPort("https://masspick-1255853614.cos-website.ap-shanghai.myqcloud.com/masspick/develop/peak-guest/24370869-f02a-4157-95fe-7368ed017ed3.png");
            userWeiXin.setRegDate(new Date());
            userWeiXinMapper.insert(userWeiXin);

            Message message = new Message(MessageConstant.SYSTEM_TYPE,
                    MessageConstant.getWelcomeMessage(userWeiXin.getNickName() == null ? "" : userWeiXin.getNickName()),
                    MessageConstant.UN_READ_STATUS, userWeiXin.getId());
            message.preInsert();
            messageMapper.insert(message);
        } else {
            UserWeiXin updateWeixin = new UserWeiXin();
            updateWeixin.setId(dbWeiXin.getId());
            updateWeixin.setInsStaffNum(dbWeiXin.getInsStaffNum());
            updateWeixin = getInsInfo(dbWeiXin);
            updateWeixin.setUpdateDate(new Date());
            userWeiXinMapper.update(updateWeixin);
        }
        return userWeiXinMapper.findByMobile(userWeiXin.getMobile());
    }

    /**
     *  获取渠道信息
     * @param userWeiXin 微信
     * @return UserWeiXin
     */
    public UserWeiXin getInsInfo(UserWeiXin userWeiXin) {
        if (userWeiXin != null && StringHelper.isNotEmpty(userWeiXin.getInsStaffNum())) {
            try {
                SysInsStaffDTO sysInsStaffDTO = iSysInsStaffFeignApi.finByNumber(userWeiXin.getInsStaffNum());
                userWeiXin.setInsName(sysInsStaffDTO.getInstitutionName());
                userWeiXin.setInsStaffName(sysInsStaffDTO.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userWeiXin;
    }
}
