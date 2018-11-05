package com.masspick.peak.guest.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masspick.peak.common.util.DateUtils;
import com.masspick.peak.common.util.IdWorker;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.common.util.StringHelper;
import com.masspick.peak.guest.bo.LoanApplyShowVo;
import com.masspick.peak.guest.bo.LoanEtpVo;
import com.masspick.peak.guest.common.constant.CommonConstant;
import com.masspick.peak.guest.common.constant.MessageConstant;
import com.masspick.peak.guest.common.upload.FileConfig;
import com.masspick.peak.guest.common.util.GetDetailFromAddress;
import com.masspick.peak.guest.common.util.ZipUtil;
import com.masspick.peak.guest.controller.vo.EtpCerDetailVo;
import com.masspick.peak.guest.controller.vo.LoanApplyAddVo;
import com.masspick.peak.guest.controller.vo.LoanDetailShowVo;
import com.masspick.peak.guest.mapper.UserWeiXinMapper;
import com.masspick.peak.guest.model.UserWeiXin;
import com.masspick.peak.guest.vo.client.RepayDetail;
import com.masspick.peak.guest.vo.client.RepayPlan;
import com.masspick.peak.guest.mapper.ControllerCreditUrlMapper;
import com.masspick.peak.guest.mapper.CorporateCreditUrlMapper;
import com.masspick.peak.guest.mapper.EtpCerMapper;
import com.masspick.peak.guest.mapper.FlowProcessMapper;
import com.masspick.peak.guest.mapper.LoanApplyMapper;
import com.masspick.peak.guest.mapper.LoanContractInfoMapper;
import com.masspick.peak.guest.mapper.MessageMapper;
import com.masspick.peak.guest.mapper.ProductMapper;
import com.masspick.peak.guest.model.ControllerCreditUrl;
import com.masspick.peak.guest.model.CorporateCreditUrl;
import com.masspick.peak.guest.model.EtpCer;
import com.masspick.peak.guest.model.FlowProcess;
import com.masspick.peak.guest.model.LoanApply;
import com.masspick.peak.guest.model.LoanContractInfo;
import com.masspick.peak.guest.model.Message;
import com.masspick.peak.guest.model.Product;
import com.masspick.peak.guest.service.IEtpCerService;
import com.masspick.peak.guest.service.IHomeService;
import com.masspick.peak.guest.service.ILoanApplyService;
import com.masspick.peak.guest.vo.ApiResponse;
import com.masspick.peak.guest.vo.manage.CountMapVo;
import com.masspick.peak.guest.vo.manage.LoanInviteVo;
import com.masspick.peak.service.IFlowService;
import com.masspick.peak.service.PushProjectApi;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 申请贷款
 */
@Service
public class LoanApplyServiceImpl implements ILoanApplyService {

    /**
     * loanApplyMapper
     */
    @Autowired
    private LoanApplyMapper loanApplyMapper;

    /**
     * messageMapper
     */
    @Autowired
    private MessageMapper messageMapper;

    /**
     * etpCerService
     */
    @Autowired
    private IEtpCerService etpCerService;

    /**
     * iFlowService
     */
    @Autowired
    private IFlowService iFlowService;

    /**
     * flowProcessMapper
     */
    @Autowired
    private FlowProcessMapper flowProcessMapper;

    /**
     * loanContractInfoMapper
     */
    @Autowired
    private LoanContractInfoMapper loanContractInfoMapper;


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
     * etpCerMapper
     */
    @Autowired
    private EtpCerMapper etpCerMapper;

    /**
     *  productMapper
     */
    @Autowired
    private ProductMapper productMapper;

    /**
     * homeService
     */
    @Autowired
    private IHomeService homeService;

    /**
     * FileConfig
     */
    @Autowired
    private FileConfig fileConfig;

    /**
     *  pushProjectApi
     */
    @Autowired
    private PushProjectApi pushProjectApi;

    /**
     *  userWeiXinMapper
     */
    @Autowired
    private UserWeiXinMapper userWeiXinMapper;


    /**
     * 注:1.0.4 branch 把征信报告移到申请贷款中去 故此方法需要保存征信URL去库中
     *
     * @return ApiResponse
     */
    @Override
    @Transactional
    public ApiResponse addLoanApply(LoanApplyAddVo loanApplyAddVo, BindingResult bindingResult) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        //1.参数校验
        if (bindingResult.hasErrors()) {
            return apiResponse.error("400").setReason(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }

        //2.业务校验
        EtpCer dbCer = etpCerMapper.findById(loanApplyAddVo.getEtpCerId());
        if (dbCer == null) {
            return apiResponse.error("401").setReason("该公司未进行企业资质认证，无法申请贷款！");
        }
        if (!CommonConstant.PASSED_CER_STATUS.equals(dbCer.getStatus())) {
            return apiResponse.error("401").setReason("该公司未企业资质认证未通过，无法申请贷款！");
        }

        //3.申请贷款校验
        EtpCer etpCer = etpCerMapper.findById(loanApplyAddVo.getEtpCerId());
        List<LoanApply> applyList = loanApplyMapper.findLoanByEtpName(etpCer.getEtpName());
        //3.1 存在进行中的订单无法继续申请
        Boolean firstApply = true;
        if (CollectionUtils.isNotEmpty(applyList)) {
            for (LoanApply apply : applyList) {
                if (apply.getStatus().equals(CommonConstant.HANDING_LOAN_STATUS)) {
                    return apiResponse.error("402").setReason("该公司申请的贷款正在处理中，请勿重复申请");
                }
                if (apply.getStatus().equals(CommonConstant.FINISH_LOAN_STATUS)) {
                    try {
                        // 调用公共接口获取还款详情
                        FlowProcess flowProcess = flowProcessMapper.findByLoanId(apply.getId());
                        com.masspick.peak.model.dto.ApiResponse feignResponse = pushProjectApi.borrowRepayDetailByflowId(flowProcess.getFlowId());
                        String result = String.valueOf(feignResponse.getResult());
                        if (feignResponse.getCode().equals("200") && StringHelper.isNotEmpty(String.valueOf(feignResponse.getResult()))) {
                            // 解析还款数据
                            List<Map<String, String>> repayMapList = JacksonUtils.readValue(result, List.class);
                            if (!CollectionUtils.isEmpty(repayMapList)) {
                                Map<String, String> repayMap = repayMapList.get(repayMapList.size() - 1);
                                if (Integer.valueOf(repayMap.get("repayFlg")) == 1) {
                                    firstApply = false;
                                }
                            }
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    } finally {
                        if (firstApply) {
                            return apiResponse.error("402").setReason("该公司申请的贷款未还款完成，请待还款完成后再申请!");
                        }
                    }
                }
            }
        }
        //3.2 没有已完成的订单 首次申请不能超过6个月
        if (loanApplyAddVo.getTerm() > 6 && firstApply) {
            return apiResponse.error("402").setReason("首次申请贷款，期限不能超过6个月");
        }

        //4.保存申请单信息
        LoanApply loanApply = new LoanApply();
        //4.1 保存征信地址
        String loanId = SequenceUtils.getUUID();
        saveControllerCreditUrls(loanApplyAddVo.getControllerCreditUrls(), loanId);
        saveCorporateCreditUrls(loanApplyAddVo.getCorporateCreditUrls(), loanId);
        //4.2 保存订单信息
        loanApply = JacksonUtils.copyProperties(loanApplyAddVo, LoanApply.class);
        loanApply.setId(loanId);
        loanApply.setCreateDate(new Date());
        loanApply.setUpdateDate(new Date());
        loanApply.setStatus(CommonConstant.HANDING_LOAN_STATUS);
        loanApply.setNo(IdWorker.getNo());
        loanApply.setEtpName(etpCer.getEtpName());
        loanApply.setUserId(etpCer.getUserId());
        loanApplyMapper.insert(loanApply);

        //5.发送消息
        Message message = new Message(MessageConstant.LOAN_TYPE, MessageConstant.getCreateApplyMessage(),
                MessageConstant.UN_READ_STATUS, etpCer.getUserId());
        message.setEtpName(etpCer.getEtpName());
        message.preInsert();
        messageMapper.insert(message);

        //5.发起流程
        String result = sendProcess(loanApply, loanApplyAddVo);
        if ("".equals(result)) {
            return apiResponse.error("403").setReason("系统故障，发起流程失败");
        }
        return apiResponse.success().setResult(loanApply);
    }

    /**
     * 保存控制人征信地址和压缩文件
     * @param controllerCreditUrls 控制人征信地址
     * @param loanId               申请单id
     */
    public void saveControllerCreditUrls(List<String> controllerCreditUrls, String loanId) {
        //1.保存控制人征信地址
        List<ControllerCreditUrl> urlList = new ArrayList<>();
        for (String url : controllerCreditUrls) {
            ControllerCreditUrl controllerUrl = new ControllerCreditUrl();
            controllerUrl.setId(SequenceUtils.getUUID());
            controllerUrl.setCreditUrl(url);
            controllerUrl.setLoanId(loanId);
            urlList.add(controllerUrl);
        }
        controllerCreditUrlMapper.insertList(urlList);
    }

    /**
     * 保存企业征信地址和压缩文件
     * @param corporateCreditUrls 企业征信地址
     * @param loanId              申请单id 临时目录地址
     */
    public void saveCorporateCreditUrls(List<String> corporateCreditUrls, String loanId) {
        //1.保存控制人征信地址
        List<CorporateCreditUrl> urlList = new ArrayList<>();
        for (String url : corporateCreditUrls) {
            CorporateCreditUrl corporateCreditUrl = new CorporateCreditUrl();
            corporateCreditUrl.setId(SequenceUtils.getUUID());
            corporateCreditUrl.setCreditUrl(url);
            corporateCreditUrl.setLoanId(loanId);
            urlList.add(corporateCreditUrl);
        }
        corporateCreditUrlMapper.insertList(urlList);
    }


    /**
     *  发起流程
     * @param loanApply  数据库对象
     * @param loanApplyAddVo 页面对象
     * @return String
     */
    @Transactional
    public String sendProcess(LoanApply loanApply, LoanApplyAddVo loanApplyAddVo) {

        //发起流程
        String flowId = "";
        try {
            flowId = iFlowService.startProcess(buildFlowInfo(loanApply, loanApplyAddVo));
            if (flowId != null) {
                FlowProcess flowProcess = new FlowProcess();
                flowProcess.setFlowId(flowId);
                flowProcess.setCreateDate(new Date());
                flowProcess.setUpdateDate(new Date());
                flowProcess.setEtpName(loanApply.getEtpName());
                flowProcess.setUserId(loanApply.getUserId());
                flowProcess.setLoanId(loanApply.getId());
                flowProcess.setStatus(CommonConstant.HANDING_FLOW_STATUS);
                flowProcessMapper.insert(flowProcess);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flowId;
    }

    /**
     * 组装流程所需数据
     * @param loanApply  数据库对象
     * @param loanApplyAddVo 页面对象
     * @return Map<String, String>
     */
    public Map<String, String> buildFlowInfo(LoanApply loanApply, LoanApplyAddVo loanApplyAddVo) {
        Map<String, String> map = new HashMap<>();
        //资质认证明细
        EtpCerDetailVo etpCerDetailVo = etpCerService.findEtpCerDetail(loanApply.getEtpCerId());
        Product product = productMapper.findByProductId(loanApply.getProductId());
        UserWeiXin userWeiXin = userWeiXinMapper.findById(loanApply.getUserId());

        map.put("projectNumber", loanApply.getNo());
        map.put("entName", loanApply.getEtpName());
        map.put("amount", String.valueOf(loanApply.getAmount()));
        map.put("term", String.valueOf(loanApply.getTerm()));
        map.put("appointTime", DateUtils.format(loanApply.getAppointTime(), "yyyy-MM-dd HH:mm:ss"));
        map.put("guestAppointTime", DateUtils.format(loanApply.getAppointTime(), "yyyy-MM-dd HH:mm:ss"));
        map.put("authUrl", loanApply.getAuthUrl());
        map.put("bodyUrl", loanApply.getBodyUrl());
        map.put("controllerUrl", loanApply.getControllerUrl());
        map.put("controllerCreditUrls", zipCreditUrls(loanApplyAddVo.getControllerCreditUrls(), "个人征信"));
        map.put("corporateCreditUrls", zipCreditUrls(loanApplyAddVo.getCorporateCreditUrls(), "企业征信"));
        map.put("infoAuthNum", loanApply.getInfoAuthNum());
        map.put("replyMethod", CommonConstant.REPAY_METHOD);
        map.put("legalRep", etpCerDetailVo.getBusCer().getLegalName());
        map.put("regCap", etpCerDetailVo.getBusCer().getRegCap());
        map.put("creditCode", etpCerDetailVo.getBusCer().getCreditCode());
        map.put("address", etpCerDetailVo.getBusCer().getAddress());
        Map<String, String> addressMap = GetDetailFromAddress.splitAddres(etpCerDetailVo.getBusCer().getAddress());
        map.put("province", addressMap.get("province"));
        map.put("city", addressMap.get("city"));
        map.put("area", addressMap.get("area"));
        map.put("busScope", etpCerDetailVo.getBusCer().getBusScope());
        map.put("busUrl", etpCerDetailVo.getBusCer().getBusUrl());
        map.put("legalPhone", etpCerDetailVo.getIdMobileCer().getMobile());
        map.put("legalSex", etpCerDetailVo.getIdMobileCer().getSex());
        map.put("legalBirth", etpCerDetailVo.getIdMobileCer().getBirth());
        map.put("legalAddress", etpCerDetailVo.getIdMobileCer().getAddress());
        map.put("legalCardNo", etpCerDetailVo.getIdMobileCer().getIdCode());
        map.put("legalNation", etpCerDetailVo.getIdMobileCer().getNation());
        map.put("legalName", etpCerDetailVo.getIdMobileCer().getName());
        map.put("controllerName", etpCerDetailVo.getControllerCer().getName());
        map.put("controllerIdCode", etpCerDetailVo.getControllerCer().getIdCode());
        map.put("controllerPhone", etpCerDetailVo.getControllerCer().getMobile());
        map.put("productId", product.getProductId());
        map.put("productName", product.getProductName());
        map.put("financialContact", loanApply.getFinancialContact());
        map.put("contactMobile", loanApply.getContactMobile());
        map.put("insStaffName", userWeiXin.getInsStaffName());
        map.put("insName", userWeiXin.getInsName());
        Map<String, Object> data = new HashMap<>();
        data.put("Amount", String.valueOf(loanApply.getAmount()));
        data.put("Month", String.valueOf(loanApply.getTerm()));
        Map<String, String> rateMap = homeService.getRateMap(product.getProductId(), data);
        if (!rateMap.isEmpty()) {
            map.put("productRate", rateMap.get("interestRate") + "%");
            map.put("serviceFee", String.valueOf(new BigDecimal(rateMap.get("serviceRate")).multiply(new BigDecimal(loanApply.getAmount())).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP)));
        }
            return map;
    }

    /**
     *  打包征信地址
     * @param creditUlrs 腾讯云征信地址
     * @return String
     */
    public String zipCreditUrls(List<String> creditUlrs, String type) {
        String zipFileName = type + SequenceUtils.getUUID() + ".zip";
        List<String> fileNameList = new ArrayList<>();
        String tempPath = fileConfig.getTempFilePath();
        for (String url : creditUlrs) {
            String fileName = url.substring(url.lastIndexOf("/") + 1);
            fileNameList.add(fileConfig.getTempFilePath() + fileName);
        }
        ZipUtil.fileToZip(fileNameList, tempPath, zipFileName);
        return homeService.uploadFile(new File(tempPath + zipFileName));
    }

    /**
     * 查询申请订单
     * @param userId 用户id
     * @return ApiResponse
     */
    @Override
    public ApiResponse findLoanApplyList(String userId) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        List<LoanApply> loanApplyList = loanApplyMapper.findByUserId(userId);
        return apiResponse.success().setResult(loanApplyList);
    }

    /**
     * 查询申请单明细
     * @param id 申请单id
     * @return ApiResponse
     */
    @Override
    public ApiResponse findLoanDetail(String id) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        LoanDetailShowVo loanDetailShowVo = new LoanDetailShowVo();
        LoanApplyShowVo loanApplyShowVo = loanApplyMapper.findDetailById(id);
        LoanContractInfo loanContractInfo = loanContractInfoMapper.findByLoanId(id);
        List<String> corporateCreditUrls = corporateCreditUrlMapper.findCreditUrls(id);
        List<String> controllerCreditUrls = controllerCreditUrlMapper.findCreditUrls(id);

        loanDetailShowVo.setLoanApply(loanApplyShowVo);
        loanDetailShowVo.setCorporateCreditUrls(corporateCreditUrls);
        loanDetailShowVo.setControllerCreditUrls(controllerCreditUrls);
        loanDetailShowVo.setLoanContractInfo(loanContractInfo);
        return apiResponse.success().setResult(loanDetailShowVo);
    }

    /**
     *  获取还款详情
     * @param userId 用户id
     * @return ApiResponse
     */
    @Override
    public ApiResponse findRepayList(String userId) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        List<RepayDetail> repayDetailList = new ArrayList<>();
        //1.根据用户id获取流程处理完结的数据
        List<FlowProcess> flowProcessesList = flowProcessMapper.findFinishByUserId(userId);
        if (CollectionUtils.isEmpty(flowProcessesList)) {
            return apiResponse.success().setResult(repayDetailList);
        }

        //2.根据完结的流程id，获取还款信息
        for (FlowProcess flowProcess : flowProcessesList) {
            try {
                // 调用公共接口获取还款详情
                com.masspick.peak.model.dto.ApiResponse feignResponse = pushProjectApi.borrowRepayDetailByflowId(flowProcess.getFlowId());
                String result = String.valueOf(feignResponse.getResult());
                if (feignResponse.getCode().equals("200") && StringHelper.isNotEmpty(String.valueOf(feignResponse.getResult()))) {
                    // 解析还款数据
                    List<Map<String, String>> repayMapList = JacksonUtils.readValue(result, List.class);
                    RepayDetail repayDetail = buildRepayDetail(repayMapList, flowProcess.getLoanId());
                    repayDetailList.add(repayDetail);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return apiResponse.success().setResult(repayDetailList);
    }

    /**
     * 公司对应贷款信息
     * @param etpName etpName
     * @return ApiResponse
     */
    @Override
    public ApiResponse findLoanOrderByEtpName(String etpName) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        return apiResponse.success().setResult(loanApplyMapper.findLoanOrderByEtpName(etpName));
    }

    /**
     * 巅峰对应企业订单
     * @param pageNum
     * @param pageSize
     * @param number
     * @return
     */
    @Override
    public ApiResponse findLoanOrderByPage(Integer pageNum, Integer pageSize, String number) {

        ApiResponse apiResponse = ApiResponse.getInstances();
        PageHelper.startPage(pageNum, pageSize);
        List<LoanEtpVo> loanEtpVos = loanApplyMapper.findList(number);
        PageInfo<LoanEtpVo> page = new PageInfo<>(loanEtpVos);
        List<CountMapVo> mapList = loanApplyMapper.findCountByMonth(number);
        List<LoanEtpVo> voPageList = page.getList();
        List<LoanInviteVo> voList = new ArrayList<>();

        LoanInviteVo loanInviteVo = null;
        List<LoanEtpVo> etpVos = null;
        for (CountMapVo countMapVo : mapList) {
            String value = countMapVo.getValue(); //条数
            String createMonth = countMapVo.getCreateMonth(); //月份

            for (LoanEtpVo loanEtpVo : voPageList) {
                String month = loanEtpVo.getCreateMonth();
                if (createMonth.equals(month)) { //相等 则返回
                    loanInviteVo = new LoanInviteVo();
                    loanInviteVo.setMonth(createMonth);
                    loanInviteVo.setTotalInvite(value);
                    break;
                }
            }

            etpVos = new ArrayList<>();
            for (LoanEtpVo loanEtpVo : voPageList) {
                String month = loanEtpVo.getCreateMonth();
                if (createMonth.equals(month)) { //相等 则返回
                    etpVos.add(loanEtpVo);
                }
            }

            if (!CollectionUtils.isEmpty(etpVos)) {
                loanInviteVo.setEtpDetails(etpVos);
                voList.add(loanInviteVo);
            }

        }

        return apiResponse.success().setResult(voList);
    }

    /**
     * 编号统计订单数
     * @param number number
     * @return ApiResponse
     */
    @Override
    public ApiResponse findLoanCountByNumber(String number) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        Map<String,String> map = new HashMap<>();

        Integer countLoans = loanApplyMapper.findCountByNumber(number);
        Integer insTotalAmount = loanApplyMapper.findSumFromNumber(number);

        map.put("countLoans",countLoans==null?"0":countLoans.toString());
        map.put("insTotalAmount",insTotalAmount==null?"0":insTotalAmount.toString());
        return apiResponse.success().setResult(map);
    }

    /**
     *  拼接还款信息
     * @param repayMapList 还款信息
     * @param loanId 申请单id
     * @return RepayDetail
     */
    public RepayDetail buildRepayDetail(List<Map<String, String>> repayMapList, String loanId) {
        RepayDetail repayDetail = loanApplyMapper.findRepayInfoById(loanId);
        List<RepayPlan> repayPlanList = new ArrayList<>();
        Double repayInterestTotal = 0.00;
        Double repayAccountTotal = 0.00;
        for (Map<String, String> repayMap : repayMapList) {
            RepayPlan repayPlan = new RepayPlan();
            repayPlan.setBorrowTimes(Integer.valueOf(repayMap.get("borrowTimes")));
            repayPlan.setRepayTime(DateUtils.parseDateByPattern(repayMap.get("repayTime"), DateUtils.YEARHOURDAY_FORMAT));
            repayPlan.setRepayTimeYes(DateUtils.parseDateByPattern(repayMap.get("repayTimeYes"), DateUtils.YEARHOURDAY_FORMAT));
            repayPlan.setRepayAccountAll(Double.valueOf(repayMap.get("repayAccountAll")));
            repayPlan.setRepayAccountAll(Double.valueOf(repayMap.get("repayAccountAllYes")));
            repayPlan.setRepayAccountInterest(Double.valueOf(repayMap.get("repayAccountInterest")));
            repayPlan.setRepayAccountInterestYes(Double.valueOf(repayMap.get("repayAccountInterestYes")));
            repayPlan.setRepayAccountCapital(Double.valueOf(repayMap.get("repayAccountCapital")));
            repayPlan.setRepayAccountCapitalYes(Double.valueOf(repayMap.get("repayAccountCapitalYes")));
            // 统计还款总额和利息总额
            repayInterestTotal += repayPlan.getRepayAccountInterest();
            repayAccountTotal += repayPlan.getRepayAccountAll();
            repayPlanList.add(repayPlan);
        }
        repayDetail.setRepayAccountTotal(repayAccountTotal);
        repayDetail.setRepayInterestTotal(repayInterestTotal);
        repayDetail.setRepayPlan(repayPlanList);
        return repayDetail;
    }
}
