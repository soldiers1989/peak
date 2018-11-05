package com.masspick.peak.guest.rpc;

import com.masspick.peak.common.util.DateUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.common.util.StringHelper;
import com.masspick.peak.guest.common.constant.CommonConstant;
import com.masspick.peak.guest.common.constant.MessageConstant;
import com.masspick.peak.guest.mapper.FlowProcessMapper;
import com.masspick.peak.guest.mapper.LoanApplyMapper;
import com.masspick.peak.guest.mapper.LoanContractInfoMapper;
import com.masspick.peak.guest.mapper.MessageMapper;
import com.masspick.peak.guest.model.FlowProcess;
import com.masspick.peak.guest.model.LoanApply;
import com.masspick.peak.guest.model.LoanContractInfo;
import com.masspick.peak.guest.model.Message;
import com.masspick.peak.guest.service.IHomeService;
import com.masspick.peak.service.LoanFeignApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 对外接口实现
 */
@RestController
public class LoanFeignRpc implements LoanFeignApi {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoanFeignRpc.class);

    /**
     * flowProcessMapper
     */
    @Autowired
    private FlowProcessMapper flowProcessMapper;

    /**
     * loanApplyMapper
     */
    @Autowired
    private LoanApplyMapper loanApplyMapper;

    /**
     * homeService
     */
    @Autowired
    private IHomeService homeService;

    /**
     * messageMapper
     */
    @Autowired
    private MessageMapper messageMapper;

    /**
     * loanContractInfoMapper
     */
    @Autowired
    private LoanContractInfoMapper loanContractInfoMapper;

    /**
     * 根据流程处理结果更新内部订单状态
     *
     * @param flowId 流程id
     * @param data   数据
     * @throws Exception Exception
     */
    @Override
    public void notifyLoanHandResult(@PathVariable("flowId") String flowId, @RequestBody Map<String, String> data) throws Exception {
        FlowProcess flowProcess = flowProcessMapper.findByFlowId(flowId);
        LoanApply loanApply = loanApplyMapper.findLoanById(flowProcess.getLoanId());

        //更新预约确认时间
        String appointConfirmTime = data.get("appointTime");
        if (loanApply.getAppointConfirmTime() == null && !StringHelper.isEmpty(appointConfirmTime)) {
            LoanApply loan = new LoanApply();
            loan.setUpdateDate(new Date());
            loan.setAppointConfirmTime(DateUtils.parseDateByPattern(appointConfirmTime, DateUtils.CLEAN_PATTERN_ARRAY));
            loan.setId(flowProcess.getLoanId());
            loanApplyMapper.update(loan);
        }

        //更新合同核准信息
        String loanTerm = data.get("loanTerm");
        String loanAmount = data.get("loanAmount");
        if (!StringHelper.isEmpty(loanTerm) && !StringHelper.isEmpty(loanAmount)) {
            saveLoanContractInfo(loanAmount, loanTerm, flowProcess.getLoanId(), loanApply.getProductId());
        }

        //更新订单状态
        String messageContent = "";
        String flowStatus = "";
        String status = data.get("status");
        if (status.equals(CommonConstant.FINISH_PROCESS)) {
            if (!StringHelper.isEmpty(data.get("reverifyDate"))) {
                loanApply.setLoanDate(DateUtils.parseDateByPattern(data.get("reverifyDate"), DateUtils.CLEAN_PATTERN_ARRAY));
            }
            loanApply.setStatus(CommonConstant.FINISH_LOAN_STATUS);
            flowStatus = CommonConstant.FINISH_FLOW_STATUS;
            messageContent = MessageConstant.getFinishLoanMessage();
        }

        if (status.equals(CommonConstant.STOP_PROCESS)) {
            loanApply.setStatus(CommonConstant.STOP_LOAN_STATUS);
            loanApply.setReason(CommonConstant.STOP_REASON);
            messageContent = MessageConstant.getStopLoanMessage();
            flowStatus = CommonConstant.STOP_FLOW_STATUS;
        }

        if (status.equals(CommonConstant.FINISH_PROCESS) || status.equals(CommonConstant.STOP_PROCESS)) {
            //更新订单状态
            loanApply.setUpdateDate(new Date());
            loanApply.setId(flowProcess.getLoanId());
            loanApplyMapper.update(loanApply);
            LOGGER.info("update loanApply info  , loanApply: " + loanApply.toString());

            //发送消息
            Message message = new Message(MessageConstant.LOAN_TYPE, messageContent, MessageConstant.UN_READ_STATUS, flowProcess.getUserId());
            message.setEtpName(flowProcess.getEtpName());
            message.preInsert();
            messageMapper.insert(message);
            LOGGER.info("add message info  , message: " + message.toString());

            //更新流程状态
            flowProcess.setStatus(flowStatus);
            flowProcess.setUpdateDate(new Date());
            flowProcessMapper.update(flowProcess);
            LOGGER.info("update flowProcess info  , flowProcess: " + flowProcess.toString());
        }
    }

    /**
     *
     * @param loanAmount 批复金额
     * @param loanTerm 批复期限
     * @param applyId 申请单id
     * @param productId 产品id
     */
    public void saveLoanContractInfo(String loanAmount, String loanTerm, String applyId, String productId) {
        Map<String, Object> data = new HashMap<>();
        data.put("Month", loanTerm);
        data.put("Amount", loanAmount);
        Map<String, String> rateMap = homeService.getRateMap(productId, data);
        LoanContractInfo loanContractInfo = new LoanContractInfo();
        loanContractInfo.setApprovalAmount(Integer.valueOf(loanAmount));
        loanContractInfo.setApprovalTerm(Integer.valueOf(loanTerm));
        loanContractInfo.setId(SequenceUtils.getUUID());
        loanContractInfo.setRepayMethod(CommonConstant.REPAY_METHOD);
        loanContractInfo.setLoanId(applyId);
        loanContractInfo.setCreateDate(new Date());
        loanContractInfo.setLoanRate(String.valueOf(rateMap.get("interestRate")));
        loanContractInfo.setServiceRate(String.valueOf(rateMap.get("serviceRate")));
        loanContractInfoMapper.insert(loanContractInfo);
    }
}
