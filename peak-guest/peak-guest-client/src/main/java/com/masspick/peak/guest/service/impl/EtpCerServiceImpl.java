package com.masspick.peak.guest.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.common.util.StringHelper;
import com.masspick.peak.guest.common.constant.CommonConstant;
import com.masspick.peak.guest.common.util.CardUtils;
import com.masspick.peak.guest.common.util.CheckNameCodePhoneUtil;
import com.masspick.peak.guest.common.util.SpringContextHolder;
import com.masspick.peak.guest.controller.vo.EtpCerAddVo;
import com.masspick.peak.guest.controller.vo.EtpCerDetailVo;
import com.masspick.peak.guest.controller.vo.LiveDetectVo;
import com.masspick.peak.guest.mapper.BodyCerMapper;
import com.masspick.peak.guest.mapper.BusLicenseCerMapper;
import com.masspick.peak.guest.mapper.ControllerCerMapper;
import com.masspick.peak.guest.mapper.EtpCerMapper;
import com.masspick.peak.guest.mapper.IdMobileCerMapper;
import com.masspick.peak.guest.mapper.UserWeiXinMapper;
import com.masspick.peak.guest.model.BodyCer;
import com.masspick.peak.guest.model.BusLicenseCer;
import com.masspick.peak.guest.model.ControllerCer;
import com.masspick.peak.guest.model.EtpCer;
import com.masspick.peak.guest.model.IdMobileCer;
import com.masspick.peak.guest.model.UserWeiXin;
import com.masspick.peak.guest.service.IEtpCerService;
import com.masspick.peak.guest.service.IHomeService;
import com.masspick.peak.guest.vo.ApiResponse;
import com.masspick.peak.guest.vo.manage.CountMapVo;
import com.masspick.peak.guest.vo.manage.EtpCerInvitePageVo;
import com.masspick.peak.guest.vo.manage.EtpCerInviteVo;
import com.masspick.peak.service.EtpElementsFeignApi;
import com.masspick.peak.service.IRandomFeignApi;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.*;

/**
 * 企业资质认证
 */
@Service
public class EtpCerServiceImpl implements IEtpCerService {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EtpCerServiceImpl.class);

    /**
     * EtpCerMapper
     */
    @Autowired
    private EtpCerMapper etpCerMapper;

    /**
     * busLicenseCerMapper
     */
    @Autowired
    private BusLicenseCerMapper busLicenseCerMapper;

    /**
     * bodyCerMapper
     */
    @Autowired
    private BodyCerMapper bodyCerMapper;

    /**
     * controllerCerMapper
     */
    @Autowired
    private ControllerCerMapper controllerCerMapper;

    /**
     * idMobileCerMapper
     */
    @Autowired
    private IdMobileCerMapper idMobileCerMapper;

    /**
     * homeService
     */
    @Autowired
    private IHomeService homeService;

    /**
     *  etpElementsFeignApi
     */
    @Autowired
    private EtpElementsFeignApi etpElementsFeignApi;

    /**
     * iRandomFeignApi
     */
    @Autowired
    private IRandomFeignApi iRandomFeignApi;

    /**
     * userWeiXinMapper
     */
    @Autowired
    private UserWeiXinMapper userWeiXinMapper;

    /**
     * 获取唇语码
     * @return ApiResponse
     */
    @Override
    public ApiResponse validateData() {
        ApiResponse apiResponse = ApiResponse.getInstances();
        try {
            String data = CardUtils.faceLiveGetFour();
            return apiResponse.success().setResult(data);
        } catch (Exception e) {
            return apiResponse.error("400").setReason("获取验证码失败，从重新申请!");
        }
    }

    /**
     *  活体检测
     * @param liveDetectVo 活体检测对象
     * @param bindingResult 校验结果
     * @return ApiResponse
     */
    @Override
    public ApiResponse liveDetect(LiveDetectVo liveDetectVo, BindingResult bindingResult) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        //校验参数必填
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        try {
            String ret = CardUtils.faceLiveDetectFour(homeService.downloadImage(liveDetectVo.getVideoUrl()), liveDetectVo.getIdCardNumber(),
                    liveDetectVo.getIdCardName(), liveDetectVo.getValidate());
            String res = CardUtils.faceIdResult(ret);
            if ("success".equals(res)) {
                return apiResponse.success().setResult(addBodyCer(liveDetectVo));
            } else {
                return apiResponse.error("401").setReason("活体检测失败");
            }
        } catch (Exception e) {
            return apiResponse.error("401").setReason("活体检测失败!");
        }
    }

    /**
     * 保存活体信息
     * @param liveDetectVo 活体检测信息
     * @return Integer
     */
    @Override
    public String addBodyCer(LiveDetectVo liveDetectVo) {
        BodyCer bodyCer = new BodyCer();
        bodyCer.preInsert();
        bodyCer.setCerId(SequenceUtils.getUUID());
        bodyCer.setMediaUrl(liveDetectVo.getVideoUrl());
        bodyCer.setValidate(liveDetectVo.getValidate());
        bodyCer.setStatus(CommonConstant.PASSED_CER_STATUS);
        bodyCerMapper.insert(bodyCer);
        return bodyCer.getCerId();
    }

    /**
     *  企业资质认证
     * @param etpCerAddVo 资质认证信息
     * @param bindingResult 校验结果
     * @return ApiResponse
     */
    @Override
    @Transactional
    public ApiResponse enterpriseCer(EtpCerAddVo etpCerAddVo, BindingResult bindingResult) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        //1.校验参数必填
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        //2.业务校验
        //2.1 活体检测校验判断
        BodyCer bodyCer = bodyCerMapper.findByCerId(etpCerAddVo.getCerId());
        if (bodyCer == null) {
            return apiResponse.error("401").setReason("此次认证未进行活体检测！");
        }
        //2.2 重复性申请校验
        UserWeiXin userWeiXin = userWeiXinMapper.findById(etpCerAddVo.getUserId());
        List<EtpCer> dbCerList = etpCerMapper.findByMobileAndEtpName(userWeiXin.getMobile(), etpCerAddVo.getBusCer().getEtpName());
        for (EtpCer etpCer : dbCerList) {
            if (etpCer != null && etpCer.getStatus().equals(CommonConstant.PASSED_CER_STATUS)) {
                return apiResponse.error("402").setReason("该企业已经进行过资质认证!");
            }
        }

        //3.保存认证信息
        //3.1 保存营业执照信息
        etpCerAddVo.getBusCer().setCerId(etpCerAddVo.getCerId());
        BusLicenseCer busLicenseCer = addBusLicense(etpCerAddVo.getBusCer());
        //3.2 保存身份证和电话信息
        etpCerAddVo.getIdMobileCer().setCerId(etpCerAddVo.getCerId());
        IdMobileCer idMobileCer = addIdMobileCer(etpCerAddVo.getIdMobileCer());
        //3.3 保存控制人信息
        etpCerAddVo.getControllerCer().setCerId(etpCerAddVo.getCerId());
        ControllerCer controllerCer = addControllerCer(etpCerAddVo.getControllerCer());


        //4.开始认证
        String result = "认证通过";
        boolean flag = true;
        //4.1 营业执照三要素校验
        String etpElementCheck = etpElementsCheck(busLicenseCer);
        if (!"success".equals(etpElementCheck)) {
            flag = false;
            result = etpElementCheck;
        }

        //4.2 营业执照和身份证信息匹配
        if (!busIdMatchCheck(busLicenseCer, idMobileCer)) {
            flag = false;
            result = "身份证信息和营业执照信息不匹配";
        }

        //4.3 企业法人三要素校验
        if (flag) {
            if (!idMobileCer.getStatus().equals(CommonConstant.PASSED_CER_STATUS)) {
                String legalMobileCheckResult = legalMobileCheck(idMobileCer);
                if (!legalMobileCheckResult.equals("success")) {
                    flag = false;
                    result = legalMobileCheckResult;
                }
            }
        }

        //4.4 控制人三要素校验
        if (flag) {
            String controllerMobileCheckResult = controllerMobileCheck(controllerCer, idMobileCer);
            if (!controllerMobileCheckResult.equals("success")) {
                flag = false;
                result = controllerMobileCheckResult;
            }
        }

        //5 保存认证结果
        saveEtpCer(etpCerAddVo, result);

        if (flag) {
            return apiResponse.success().setResult(result);
        } else {
            return apiResponse.error("403").setReason(result);
        }
    }

    /**
     * 添加营业执照信息
     * @param busLicenseCer 营业执照信息
     * @return BusLicenseCer
     */
    @Override
    public BusLicenseCer addBusLicense(BusLicenseCer busLicenseCer) {
        if (!StringHelper.isEmpty(busLicenseCer.getCerId()) && (busLicenseCerMapper.findByCerId(busLicenseCer.getCerId())) != null) {
            busLicenseCer.setUpdateDate(new Date());
            busLicenseCer.setId(busLicenseCerMapper.findByCerId(busLicenseCer.getCerId()).getId());
            busLicenseCer.setStatus(CommonConstant.UN_CER_STATUS);
            busLicenseCerMapper.updateByCerId(busLicenseCer);
        } else {
            busLicenseCer.preInsert();
            busLicenseCer.setStatus(CommonConstant.UN_CER_STATUS);
            busLicenseCerMapper.insert(busLicenseCer);
        }
        return busLicenseCerMapper.findByCerId(busLicenseCer.getCerId());
    }

    /**
     *  添加身份证和电话信息
     * @param idMobileCer 身份证电话信息
     * @return IdMobileCer
     */
    @Override
    public IdMobileCer addIdMobileCer(IdMobileCer idMobileCer) {
        IdMobileCer dbIdMobileCer = idMobileCerMapper.findByCerId(idMobileCer.getCerId());
        if (dbIdMobileCer != null) {
            if (dbIdMobileCer.getStatus().equals(CommonConstant.PASSED_CER_STATUS) &&
                    dbIdMobileCer.equals(idMobileCer)) {
                idMobileCer.setStatus(CommonConstant.PASSED_CER_STATUS);
            } else {
                idMobileCer.setStatus(CommonConstant.UN_CER_STATUS);
            }
            idMobileCer.setUpdateDate(new Date());
            idMobileCerMapper.updateByCerId(idMobileCer);
        } else {
            idMobileCer.setStatus(CommonConstant.UN_CER_STATUS);
            idMobileCer.preInsert();
            idMobileCerMapper.insert(idMobileCer);
        }
        return idMobileCerMapper.findByCerId(idMobileCer.getCerId());
    }

    /**
     * 添加控制人
     * @param controllerCer 控制人信息
     * @return ControllerCer
     */
    @Override
    public ControllerCer addControllerCer(ControllerCer controllerCer) {
        if (controllerCerMapper.findByCerId(controllerCer.getCerId()) != null) {
            controllerCer.setStatus(CommonConstant.UN_CER_STATUS);
            controllerCer.setUpdateDate(new Date());
            controllerCerMapper.updateByCerId(controllerCer);
        } else {
            controllerCer.preInsert();
            controllerCer.setStatus(CommonConstant.UN_CER_STATUS);
            controllerCerMapper.insert(controllerCer);
        }
        return controllerCerMapper.findByCerId(controllerCer.getCerId());
    }

    /**
     *  企业三要素校验
     * @param busLicenseCer 营业执照信息
     * @return String
     */
    public String etpElementsCheck(BusLicenseCer busLicenseCer) {
        String busLicenseCerStatus = CommonConstant.FAILED_CER_STATUS;
        String result = "营业执照中的信息匹配不一致!";
        try {
            Map<String, String> resultMap = etpElementsFeignApi.etpElementsCheck(busLicenseCer.getCreditCode(),
                    busLicenseCer.getEtpName(), busLicenseCer.getLegalName());
            LOGGER.info("企查查校验结果 : " + resultMap.toString());
            if (!SpringContextHolder.getActiveProfile().equals("dev") || ("一致").equals(resultMap.get("Result"))) {
                result = "success";
                busLicenseCerStatus = CommonConstant.PASSED_CER_STATUS;
            }
        } catch (Exception e) {
            result = "success";
            busLicenseCerStatus = CommonConstant.PASSED_CER_STATUS;
            LOGGER.info("企查查营业执照匹配异常 ： " + e.getMessage());
        }
        //更新检测状态
        busLicenseCer.setStatus(busLicenseCerStatus);
        busLicenseCer.setUpdateDate(new Date());
        busLicenseCerMapper.update(busLicenseCer);
        return result;
    }

    /**
     *  营业执照和身份证匹配
     * @param busLicenseCer 营业执照信息
     * @param idMobileCer 身份证和电话信息
     * @return  Boolean
     */
    public Boolean busIdMatchCheck(BusLicenseCer busLicenseCer, IdMobileCer idMobileCer) {
        if (!busLicenseCer.getLegalName().equals(idMobileCer.getName())) {
            //更新检测状态
            idMobileCer.setStatus(CommonConstant.FAILED_CER_STATUS);
            idMobileCer.setUpdateDate(new Date());
            idMobileCerMapper.update(idMobileCer);
            return false;
        }
        return true;
    }

    /**
     *  企业法人手机三要素校验
     * @param idMobileCer 企业法人身份证和电话信息
     * @return String
     */
    public String legalMobileCheck(IdMobileCer idMobileCer) {
        String idMobileCerStatus = CommonConstant.FAILED_CER_STATUS;
        String legalPhoneResult = CheckNameCodePhoneUtil.checkNameCodePhone(idMobileCer.getName(),
                idMobileCer.getMobile(), idMobileCer.getIdCode(), "法人 ");
        if (legalPhoneResult.equals("success")) {
            idMobileCerStatus = CommonConstant.PASSED_CER_STATUS;
        }
        //更新检测状态
        idMobileCer.setStatus(idMobileCerStatus);
        idMobileCer.setUpdateDate(new Date());
        idMobileCerMapper.update(idMobileCer);
        return legalPhoneResult;
    }

    /**
     *  企业实际控制人三要素校验
     * @param controllerCer 企业法人信息
     * @return String
     */
    public String controllerMobileCheck(ControllerCer controllerCer, IdMobileCer idMobileCer) {

        String legalPhoneResult;
        String idMobileCerStatus = CommonConstant.FAILED_CER_STATUS;
        String compareResult = compareLegalAndControllerMobile(controllerCer, idMobileCer);
        if (compareResult.equals("other")) {
            legalPhoneResult = CheckNameCodePhoneUtil.checkNameCodePhone(controllerCer.getName(),
                    controllerCer.getMobile(), controllerCer.getIdCode(), "大股东/实际控制人 ");
        } else {
            legalPhoneResult = compareResult;
        }
        if (legalPhoneResult.equals("success")) {
            idMobileCerStatus = CommonConstant.PASSED_CER_STATUS;
        }
        //更新检测状态
        controllerCer.setStatus(idMobileCerStatus);
        controllerCer.setUpdateDate(new Date());
        controllerCerMapper.update(controllerCer);
        return legalPhoneResult;
    }

    /**
     * 法人控制人信息比较
     * @param controllerCer 控制人信息
     * @param idMobileCer 法人信息
     * @return String
     */
    public String compareLegalAndControllerMobile(ControllerCer controllerCer, IdMobileCer idMobileCer) {
        if (controllerCer.getName().equals(idMobileCer.getName()) && controllerCer.getMobile().equals(idMobileCer.getMobile())
                && controllerCer.getIdCode().equals(idMobileCer.getIdCode())) {
                return "success";
        }
        if (controllerCer.getName().equals(idMobileCer.getName()) && controllerCer.getMobile().equals(idMobileCer.getMobile())
                && !controllerCer.getIdCode().equals(idMobileCer.getIdCode())) {
                return "大股东/实际控制人 手机号绑定信息与身份证信息不一致";
        }
        if (controllerCer.getName().equals(idMobileCer.getName()) && !controllerCer.getMobile().equals(idMobileCer.getMobile())
                && controllerCer.getIdCode().equals(idMobileCer.getIdCode())) {
            return "大股东/实际控制人 手机号绑定信息与身份证信息不一致";
        }
        if (!controllerCer.getName().equals(idMobileCer.getName()) && controllerCer.getMobile().equals(idMobileCer.getMobile())
                && controllerCer.getIdCode().equals(idMobileCer.getIdCode())) {
            return "大股东/实际控制人 手机号绑定信息与身份证信息不一致";
        }
        return "other";
    }

    /**
     *  保存认证结果
     * @param etpCerAddVo 认证信息
     * @param result 认证结果
     */
    public void saveEtpCer(EtpCerAddVo etpCerAddVo, String result) {
        EtpCer etpCer = new EtpCer();
        etpCer.setId(etpCerAddVo.getCerId());
        etpCer.setUserId(etpCerAddVo.getUserId());
        UserWeiXin userWeiXin = userWeiXinMapper.findById(etpCerAddVo.getUserId());
        etpCer.setEtpName(etpCerAddVo.getBusCer().getEtpName());
        etpCer.setLegalName(etpCerAddVo.getIdMobileCer().getName());
        etpCer.setMobile(userWeiXin.getMobile());
        etpCer.setReason(result);
        etpCer.setUpdateDate(new Date());
        if (result.equals("认证通过")) {
            etpCer.setStatus(CommonConstant.SUCCESS_ETP_CER);
            etpCer.setInfoAuthNum(getInfoAuthNum());
        } else {
            etpCer.setStatus(CommonConstant.FAILURE_ETP_CER);
        }

        if (etpCerMapper.findById(etpCerAddVo.getCerId()) != null) {
            etpCerMapper.update(etpCer);
        } else {
            etpCer.setCreateDate(new Date());
            etpCerMapper.insert(etpCer);
        }
    }

    /**
     *  获取授权编号
     * @return String
     */
    public String getInfoAuthNum() {
        String infoAuthNum = "";
        try {
            infoAuthNum = iRandomFeignApi.getRandom();
        } catch (Exception e) {
            infoAuthNum = SequenceUtils.getUUID();
        }
        return infoAuthNum;
    }

    /**
     * 单条企业资质认证查询
     * @param id id
     * @return ApiResponse
     */
    @Override
    public ApiResponse findOneEtpCer(String id) {
        ApiResponse apiResponse = ApiResponse.getInstances();

        return apiResponse.success().setResult(findCerDetail(id));
    }

    /**
     *  获取认证明细
     * @param id 认证id
     * @return EtpCerDetailVo
     */
    public EtpCerDetailVo findCerDetail(String id) {
        EtpCer etpCer = etpCerMapper.findById(id);
        EtpCerDetailVo etpCerDetailVo = new EtpCerDetailVo();
        if (etpCer != null) {
            etpCerDetailVo.setBusCer(busLicenseCerMapper.findByCerId(id));
            etpCerDetailVo.setIdMobileCer(idMobileCerMapper.findByCerId(id));
            etpCerDetailVo.setBodyCer(bodyCerMapper.findByCerId(id));
            etpCerDetailVo.setControllerCer(controllerCerMapper.findByCerId(id));
        }
        return etpCerDetailVo;
    }

    /**
     * 多条企业资质认证查询
     * @param userId 用户id
     * @param status 状态
     * @return ApiResponse
     */
    @Override
    public ApiResponse findEtpCerList(String userId, String status) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        return apiResponse.success().setResult(etpCerMapper.findEtpCerList(userId, status));
    }

    /**
     *  资质认证明细
     * @param id 企业资质认证id
     * @return EtpCerDetailVo
     */
    @Override
    public EtpCerDetailVo findEtpCerDetail(String id) {
        return findCerDetail(id);
    }

    /**
     * 分页显示巅峰人员拉取的公司
     * @param number numberfindList
     * @return PageInfo
     */
    @Override
    public ApiResponse findEtpByPage(Integer pageNum, Integer pageSize,String number) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        PageHelper.startPage(pageNum, pageSize);
        List<EtpCerInvitePageVo> list = etpCerMapper.findList(number);
        PageInfo<EtpCerInvitePageVo> page = new PageInfo<>(list);
        List<CountMapVo> mapList = etpCerMapper.findCountByMonth(number);
        List<EtpCerInvitePageVo> voPageList = page.getList();
        List<EtpCerInviteVo> voList = new ArrayList<>();
        EtpCerInviteVo etpCerInviteVo = null;
        List<EtpCerInvitePageVo> pageVos = null;

        for(CountMapVo countMapVo : mapList) {
            String value = countMapVo.getValue(); //条数
            String createMonth = countMapVo.getCreateMonth(); //月份

            for(EtpCerInvitePageVo etpCerInvitePageVo : voPageList){
                String month = etpCerInvitePageVo.getCreateMonth();
                if(createMonth.equals(month)) { //相等 则返回
                    etpCerInviteVo = new EtpCerInviteVo();
                    etpCerInviteVo.setMonth(createMonth);
                    etpCerInviteVo.setTotalInvite(value);
                    break;
                }
            }
            pageVos = new ArrayList<>();

            for(EtpCerInvitePageVo etpCerInvitePageVo : voPageList){
                String month = etpCerInvitePageVo.getCreateMonth();
                if(createMonth.equals(month)) { //相等 则返回
                    pageVos.add(etpCerInvitePageVo);
                }
            }

            if(!CollectionUtils.isEmpty(pageVos)){
                etpCerInviteVo.setEtpList(pageVos);
                voList.add(etpCerInviteVo);
            }


        }

        return apiResponse.success().setResult(voList);
    }

}
