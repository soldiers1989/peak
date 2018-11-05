package com.masspick.peak.guest.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.util.DateUtils;
import com.masspick.peak.guest.bo.EtpCerBo;
import com.masspick.peak.guest.bo.InfoAuthBo;
import com.masspick.peak.guest.bo.LoanApplyBo;
import com.masspick.peak.guest.bo.LoanApplyShowVo;
import com.masspick.peak.guest.bo.NameCardInfoBo;
import com.masspick.peak.guest.bo.UserWeiXinFindBo;
import com.masspick.peak.guest.controller.vo.EtpCerVo;
import com.masspick.peak.guest.controller.vo.LoanDetailVo;
import com.masspick.peak.guest.mapper.BodyCerMapper;
import com.masspick.peak.guest.mapper.BusLicenseCerMapper;
import com.masspick.peak.guest.mapper.ControllerCerMapper;
import com.masspick.peak.guest.mapper.ControllerCreditUrlMapper;
import com.masspick.peak.guest.mapper.CorporateCreditUrlMapper;
import com.masspick.peak.guest.mapper.EtpCerMapper;
import com.masspick.peak.guest.mapper.IdMobileCerMapper;
import com.masspick.peak.guest.mapper.InfoAuthMapper;
import com.masspick.peak.guest.mapper.LoanApplyMapper;
import com.masspick.peak.guest.mapper.LoanContractInfoMapper;
import com.masspick.peak.guest.mapper.NameCardInfoMapper;
import com.masspick.peak.guest.mapper.UserWeiXinMapper;
import com.masspick.peak.guest.model.BodyCer;
import com.masspick.peak.guest.model.BusLicenseCer;
import com.masspick.peak.guest.model.ControllerCer;
import com.masspick.peak.guest.model.EtpCer;
import com.masspick.peak.guest.model.IdMobileCer;
import com.masspick.peak.guest.model.LoanApply;
import com.masspick.peak.guest.model.LoanContractInfo;
import com.masspick.peak.guest.model.UserWeiXin;
import com.masspick.peak.guest.service.IManageService;
import com.masspick.peak.guest.util.Constant;
import com.masspick.peak.guest.vo.ApiResponse;
import com.masspick.peak.guest.vo.manage.EtpCerPageVo;
import com.masspick.peak.guest.vo.manage.InfoAuthVo;
import com.masspick.peak.guest.vo.manage.LoanApplyPageVo;
import com.masspick.peak.guest.vo.manage.NameCardInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * ManageServiceImpl
 */
@Service
public class ManageServiceImpl implements IManageService {


    /**
     * userWeiXinMapper
     */
    @Autowired
    private UserWeiXinMapper userWeiXinMapper;

    /**
     * nameCardInfoMapper
     */
    @Autowired
    private NameCardInfoMapper nameCardInfoMapper;

    /**
     * userAuthMapper
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
     * infoAuthMapper
     */
    @Autowired
    private InfoAuthMapper infoAuthMapper;

    /**
     * controllerCreditUrlMapper
     */
    @Autowired
    private ControllerCreditUrlMapper controllerCreditUrlMapper;

    /**
     * corporateCreditUrlMapper
     */
    @Autowired
    private CorporateCreditUrlMapper corporateCreditUrlMapper;

    /**
     * loanApplyMapper
     */
    @Autowired
    private LoanApplyMapper loanApplyMapper;

    /**
     * loanContractInfoMapper
     */
    @Autowired
    private LoanContractInfoMapper loanContractInfoMapper;

    /**
     * 分页查询用户
     * @param findBo  查询对象
     * @param bindingResult 校验结果
     * @return
     */
    @Override
    public ApiResponse findUserPage(UserWeiXinFindBo findBo, BindingResult bindingResult) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        PageHelper.startPage(findBo.getPageNum(), findBo.getPageSize());
        List<UserWeiXin> userWeiXinList = userWeiXinMapper.findByPage(findBo);
        return apiResponse.success().setResult(new PageInfo<>(userWeiXinList));
    }

    /**
     *  获取渠道列表
     * @return ApiResponse
     */
    @Override
    public ApiResponse findInsList() {
        return ApiResponse.getInstances().success().setResult(userWeiXinMapper.findInsList());
    }

    /**
     *  分页查询预授信
     * @param nameCardInfoBo 预授信查询对象
     * @return  ApiResponse
     */
    @Override
    public ApiResponse findPrePage(NameCardInfoBo nameCardInfoBo) {
        ApiResponse apiResponse = ApiResponse.getInstances();

        if (nameCardInfoBo.getPageNum() == null || nameCardInfoBo.getPageSize() == null) {
            return apiResponse.error("400").setReason("页码和每页条数为空");
        }

        PageHelper.startPage(nameCardInfoBo.getPageNum(), nameCardInfoBo.getPageSize());
        List<NameCardInfoVo> nameCardInfoVoList = nameCardInfoMapper.findList(nameCardInfoBo);

        return apiResponse.success().setResult(new PageInfo<>(nameCardInfoVoList));
    }

    /**
     *  查询预授信详情
     * @param id 预授信id
     * @return  ApiResponse
     */
    @Override
    public ApiResponse findPreDetail(String id) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        return apiResponse.success().setResult(nameCardInfoMapper.findById(id));
    }

    /**
     *  分页查询企业资质认证
     * @param etpCerBo 查询对象
     * @param bindingResult 校验结果
     * @return ApiResponse
     */
    @Override
    public ApiResponse findEtpCerPage(EtpCerBo etpCerBo, BindingResult bindingResult) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        PageHelper.startPage(etpCerBo.getPageNum(), etpCerBo.getPageSize());
        List<EtpCerPageVo> etpCerPageVoList = etpCerMapper.findByPage(etpCerBo);
        return apiResponse.success().setResult(new PageInfo<>(etpCerPageVoList));
    }

    /**
     *  企业资质认证明细查询
     * @param id 认证id
     * @return ApiResponse
     */
    @Override
    public ApiResponse findEtpCerDetail(String id) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        EtpCerVo etpCerVo = new EtpCerVo();
        EtpCer etpCer = etpCerMapper.findById(id);
        BusLicenseCer busLicenseCer = busLicenseCerMapper.findByCerId(id);
        IdMobileCer idMobileCer = idMobileCerMapper.findByCerId(id);
        BodyCer bodyCer = bodyCerMapper.findByCerId(id);
        ControllerCer controllerCer = controllerCerMapper.findByCerId(id);
        etpCerVo.setEtpCer(etpCer);
        etpCerVo.setBusCer(busLicenseCer);
        etpCerVo.setIdMobileCer(idMobileCer);
        etpCerVo.setBodyCer(bodyCer);
        etpCerVo.setControllerCer(controllerCer);
        return apiResponse.success().setResult(etpCerVo);
    }

    /**
     *  分页查询信息采集授权
     * @param infoAuthBo 查询对象
     * @param bindingResult 校验结果
     * @return ApiResponse
     */
    @Override
    public ApiResponse findInfoAuthPage(InfoAuthBo infoAuthBo, BindingResult bindingResult) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        PageHelper.startPage(infoAuthBo.getPageNum(), infoAuthBo.getPageSize());
        List<InfoAuthVo> infoAuthVoList = infoAuthMapper.findByPage(infoAuthBo);
        return apiResponse.success().setResult(new PageInfo<>(infoAuthVoList));
    }


    /**
     *  分页查询订单
     * @param loanApplyBo 查询对象
     * @param bindingResult 校验结果
     * @return ApiResponse
     */
    @Override
    public ApiResponse loanPageQuery(LoanApplyBo loanApplyBo, BindingResult bindingResult) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
        PageHelper.startPage(loanApplyBo.getPageNum(), loanApplyBo.getPageSize());
        List<LoanApplyPageVo> loanApplyPageVos = loanApplyMapper.findByPage(loanApplyBo);
        return apiResponse.success().setResult(new PageInfo<>(loanApplyPageVos));
    }

    /**
     *   查询申请单明细
     * @param id 申请单id
     * @return ApiResponse
     */
    @Override
    public ApiResponse findLoanDetail(String id) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        LoanDetailVo loanDetailShowVo = new LoanDetailVo();
        LoanApplyShowVo loanApply = loanApplyMapper.findDetailById(id);
        LoanContractInfo loanContractInfo = loanContractInfoMapper.findByLoanId(id);
        List<String> corporateCreditUrls = corporateCreditUrlMapper.findCreditUrls(id);
        List<String> controllerCreditUrls = controllerCreditUrlMapper.findCreditUrls(id);

        loanDetailShowVo.setLoanApply(loanApply);
        loanDetailShowVo.setCorporateCreditUrls(corporateCreditUrls);
        loanDetailShowVo.setControllerCreditUrls(controllerCreditUrls);
        loanDetailShowVo.setLoanContractInfo(loanContractInfo);
        return apiResponse.success().setResult(loanDetailShowVo);
    }

    /**
     *  查询首页汇总信息
     * @return ApiResponse
     */
    @Override
    public ApiResponse findHomePageStatistics() {
        ApiResponse apiResponse = ApiResponse.getInstances();
        Map<String, Object> map = new HashMap<>();

        //累计撮合交易(万元)
        String status = Constant.FINISH_LOAN_STATUS;
        Integer totalAmount = loanApplyMapper.findTotalAmountByStatus(status);
        map.put("totalAmount", totalAmount);

        //今日新增用户数
        UserWeiXinFindBo user = new UserWeiXinFindBo();
        user.setRegDate(DateUtils.parseDateByPattern(DateUtils.format(new Date(), DateUtils.YEARHOURDAY_FORMAT), DateUtils.YEARHOURDAY_FORMAT));
        Integer todayAddUser = userWeiXinMapper.findCountByParam(user);
        map.put("todayAddUser", todayAddUser);

        //今日新增订单数
        LoanApply loanApply = new LoanApply();
        loanApply.setCreateDate(DateUtils.parseDateByPattern(DateUtils.format(new Date(),
                DateUtils.YEARHOURDAY_FORMAT), DateUtils.YEARHOURDAY_FORMAT));
        Integer todayAddLoan = loanApplyMapper.findCountByParam(loanApply);
        map.put("todayAddLoan", todayAddLoan);

        //当前用户总数量
        user = new UserWeiXinFindBo();
        Integer totalUser = userWeiXinMapper.findCountByParam(user);
        map.put("totalUser", totalUser);

        //当前有效订单总数--需求确认 系统中订单都是有效的
        loanApply = new LoanApply();
        Integer totalLoan = loanApplyMapper.findCountByParam(loanApply);
        map.put("totalLoan", totalLoan);

        return apiResponse.success().setResult(map);
    }

    @Override
    public ApiResponse findUserById(String id) {
        return ApiResponse.getInstances().success().setResult(userWeiXinMapper.findById(id));
    }
}
