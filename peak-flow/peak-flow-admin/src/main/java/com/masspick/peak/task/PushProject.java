package com.masspick.peak.task;

import com.alibaba.fastjson.JSONObject;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.model.ActPushMsg;
import com.masspick.peak.model.dto.ApiResponse;
import com.masspick.peak.model.dto.BorrowProjectBean;
import com.masspick.peak.service.ActPushMsgService;
import com.masspick.peak.service.FlowService;
import com.masspick.peak.service.IProductFeignApi;
import com.masspick.peak.service.PushProjectApi;
import com.masspick.peak.utils.SpringContextHolder;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;


/**
 * 推标
 */
public class PushProject implements TaskListener {


    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PushProject.class);

    /**
     * productFeignApi
     */
    @Resource
    private IProductFeignApi productFeignApi;

    /**
     * FlowService
     */
    @Autowired
    private FlowService flowService;

    /**
     * pushProjectApi
     */
    @Resource
    private PushProjectApi pushProjectApi;

    /**
     * ActPushMsgService
     */
    @Autowired
    private ActPushMsgService actPushMsgService;

    /**
     * PERCENT
     */
    private static final int PERCENT = 100;


    /**
     * ASSURERATE
     */
    private static final double ASSURERATE = 0.1;


    /**
     * @param delegateTask 0
     *                     1-100万
     *                     100万-300万
     *                     300万-1500万
     *                     1500万-3000万
     *                     3000万-5000万
     *                     5000万-8000万
     *                     8000万以上
     */
    @Override
    public void notify(DelegateTask delegateTask) {
        if (productFeignApi == null) {
            productFeignApi = (IProductFeignApi) SpringContextHolder.getBean(IProductFeignApi.class);
        }
        if (flowService == null) {
            flowService = (FlowService) SpringContextHolder.getBean(FlowService.class);
        }
        if (pushProjectApi == null) {
            pushProjectApi = (PushProjectApi) SpringContextHolder.getBean(PushProjectApi.class);
        }
        BorrowProjectBean bean = null;
        try {
            bean = new BorrowProjectBean();
            //不能使用no来查询
            String projectNumber = delegateTask.getVariable("projectNumber") == null ? "" : delegateTask.getVariable("projectNumber").toString();
            bean.setProjectNumber(projectNumber);
            String borrowType = "1"; //信用标
            bean.setBorrowType(borrowType);
            String loanAmount = delegateTask.getVariable("loanAmount") == null ? "" : delegateTask.getVariable("loanAmount").toString();
            BigDecimal amountDecimal = new BigDecimal(loanAmount);
            BigDecimal decimal = amountDecimal.multiply(new BigDecimal("10000")); //乘以10000
            DecimalFormat formater = new DecimalFormat("0.00");
            bean.setBorrowAccount(formater.format(decimal)); //这里是万元 需要转成元
            String loanTerm = delegateTask.getVariable("loanTerm") == null ? "" : delegateTask.getVariable("loanTerm").toString();
            //borrowRate
            String productId = delegateTask.getVariable("productId") == null ? "" : delegateTask.getVariable("productId").toString();
            String contractCode = delegateTask.getVariable("contractCode") == null ? "" : delegateTask.getVariable("contractCode").toString();
            String contractAddTime = delegateTask.getVariable("completeTime") == null ? "" : delegateTask.getVariable("completeTime").toString();
            String qyAssetsTotal = delegateTask.getVariable("qyAssetsTotal") == null ? "" : delegateTask.getVariable("qyAssetsTotal").toString();
            String qyCreditTotal = delegateTask.getVariable("qyCreditTotal") == null ? "" : delegateTask.getVariable("qyCreditTotal").toString();
            Object thirdEntGuarant = delegateTask.getVariable("thirdEntGuarant");
            Object thirdPartyPerGuarant = delegateTask.getVariable("thirdPartyPerGuarant");
            Map<String, Object> borrowRateMap = new HashMap<>();
            borrowRateMap.put("Month", loanTerm);
            borrowRateMap.put("Amount", loanAmount);
            Map<String, String> rateMap = flowService.findBorrowRate(productId, borrowRateMap);
            Double amount = Double.valueOf(loanAmount);
            if (rateMap != null && !rateMap.isEmpty()) {
                String borrowRate = rateMap.get("interestRate");
                String commissionRate = rateMap.get("serviceRate");
                bean.setBorrowRate(borrowRate);
                bean.setCommissionRate(commissionRate);
                //应收居间费
                Double commRate = Double.valueOf(commissionRate);
                Double result = amount * commRate / PERCENT;
                bean.setCommissionFree(formater.format(result));
            }
            bean.setBorrowPeriod(loanTerm); //借款期限
            bean.setPeriodType("1");
            bean.setBorrowValidDay("5"); //默认5天
            bean.setContractTempleId("8520180103210721128963802311");
            bean.setContractCode(contractCode);
            bean.setBorrowStyle("4"); //目前都是  按月还息 到期还本
            bean.setIsDay("0");
            bean.setBorrowFlag("25");
            bean.setContractAddTime(contractAddTime);
            bean.setAssureRate("10");
            Double assureFee = amount * ASSURERATE;
            bean.setAssureFee(formater.format(assureFee));
            bean.setBorrowerType("2");
            bean.setLoanType("1");
            bean.setCheckIds("1;4;6;8;9;10");
            bean.setQyAssetsTotal(qyAssetsTotal);
            bean.setQyCreditTotal(qyCreditTotal);
            if (thirdEntGuarant != null && thirdPartyPerGuarant != null) {
                bean.setCreditType("1");
            } else if (thirdEntGuarant == null && thirdPartyPerGuarant != null) {
                bean.setCreditType("1");
            } else if (thirdEntGuarant != null && thirdPartyPerGuarant == null) {
                bean.setCreditType("2");
            } else {
                bean.setCreditType("1");
            }
            Double qyAssetsTotalD = Double.parseDouble(qyAssetsTotal.equals("") ? "0" : qyAssetsTotal); // 总资产
            Double qyCreditTotalD = Double.parseDouble(qyCreditTotal.equals("") ? "0" : qyCreditTotal); // 总负债
            if (qyAssetsTotalD.compareTo(0D) == 0) {
                bean.setQyAssetsTotal("0");
            } else if (qyAssetsTotalD.compareTo(Double.parseDouble("1")) >= 0
                    && qyAssetsTotalD.compareTo(Double.parseDouble("100")) < 0) {
                bean.setQyAssetsTotal("1-100万");
            } else if (qyAssetsTotalD.compareTo(Double.parseDouble("100")) >= 0
                    && qyAssetsTotalD.compareTo(Double.parseDouble("300")) < 0) {
                bean.setQyAssetsTotal("100万-300万");
            } else if (qyAssetsTotalD.compareTo(Double.parseDouble("300")) >= 0
                    && qyAssetsTotalD.compareTo(Double.parseDouble("1500")) < 0) {
                bean.setQyAssetsTotal("300万-1500万");
            } else if (qyAssetsTotalD.compareTo(Double.parseDouble("1500")) >= 0
                    && qyAssetsTotalD.compareTo(Double.parseDouble("3000")) < 0) {
                bean.setQyAssetsTotal("1500万-3000万");
            } else if (qyAssetsTotalD.compareTo(Double.parseDouble("3000")) >= 0
                    && qyAssetsTotalD.compareTo(Double.parseDouble("5000")) < 0) {
                bean.setQyAssetsTotal("3000万-5000万");
            } else if (qyAssetsTotalD.compareTo(Double.parseDouble("5000")) >= 0
                    && qyAssetsTotalD.compareTo(Double.parseDouble("8000")) < 0) {
                bean.setQyAssetsTotal("5000万-8000万");
            } else if (qyAssetsTotalD.compareTo(Double.parseDouble("8000")) >= 0) {
                bean.setQyAssetsTotal("8000万以上");
            }
            if (qyCreditTotalD.compareTo(0D) == 0) {
                bean.setQyCreditTotal("0");
            } else if (qyCreditTotalD.compareTo(Double.parseDouble("1")) >= 0
                    && qyCreditTotalD.compareTo(Double.parseDouble("100")) < 0) {
                bean.setQyCreditTotal("1-100万");
            } else if (qyCreditTotalD.compareTo(Double.parseDouble("100")) >= 0
                    && qyCreditTotalD.compareTo(Double.parseDouble("300")) < 0) {
                bean.setQyCreditTotal("100万-300万");
            } else if (qyCreditTotalD.compareTo(Double.parseDouble("300")) >= 0
                    && qyCreditTotalD.compareTo(Double.parseDouble("1500")) < 0) {
                bean.setQyCreditTotal("300万-1500万");
            } else if (qyCreditTotalD.compareTo(Double.parseDouble("1500")) >= 0
                    && qyCreditTotalD.compareTo(Double.parseDouble("3000")) < 0) {
                bean.setQyCreditTotal("1500万-3000万");
            } else if (qyCreditTotalD.compareTo(Double.parseDouble("3000")) >= 0
                    && qyCreditTotalD.compareTo(Double.parseDouble("5000")) < 0) {
                bean.setQyCreditTotal("3000万-5000万");
            } else if (qyCreditTotalD.compareTo(Double.parseDouble("5000")) >= 0
                    && qyCreditTotalD.compareTo(Double.parseDouble("8000")) < 0) {
                bean.setQyCreditTotal("5000万-8000万");
            } else if (qyCreditTotalD.compareTo(Double.parseDouble("8000")) >= 0) {
                bean.setQyCreditTotal("8000万以上");
            }
            bean.setCommissionStyle("1");
            ApiResponse response = pushProjectApi.pushProject(bean);
            if (response != null && response.getCode().equals("200")) {
                String o = response.getReason();
                LOGGER.info("返回结果:" + o);
                JSONObject jsonObject = JSONObject.parseObject(o);
                String code = jsonObject.getString("code");
                if (code.equals("000000")) {
                    LOGGER.error("推送成功!");
                } else {
                    pushErrorMsg(bean, jsonObject.getString("msg"));
                    LOGGER.error("推送失败---->" + jsonObject.getString("msg"));
                }
            } else {
                pushErrorMsg(bean, response.getErrmsg());
                LOGGER.error("推送失败---->" + response.getErrmsg());
            }
        } catch (Exception e) {
            LOGGER.error("推标发生错误!");
            //推标发生错误后  把错误信息保存起来  以方便后期自动去发起推标
            pushErrorMsg(bean, e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * @param bean
     * @return String
     */
    public int pushErrorMsg(BorrowProjectBean bean, String msg) {
        if (actPushMsgService == null) {
            actPushMsgService = (ActPushMsgService) SpringContextHolder.getBean(ActPushMsgService.class);
        }

        ActPushMsg actPushMsg = null;
        if (bean != null) {
            actPushMsg = JacksonUtils.copyProperties(bean, ActPushMsg.class);
            actPushMsg.setStatus("0");
            actPushMsg.setMsg(msg);
            return actPushMsgService.insert(actPushMsg);
        }

        return 0;
    }
}
