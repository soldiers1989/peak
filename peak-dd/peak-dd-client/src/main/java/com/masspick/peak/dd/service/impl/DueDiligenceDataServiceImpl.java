package com.masspick.peak.dd.service.impl;

import com.masspick.peak.common.util.ApiResponse;
import com.masspick.peak.common.util.DateUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.dd.config.SystemConfig;
import com.masspick.peak.dd.controller.vo.ControlVO;
import com.masspick.peak.dd.controller.vo.DueDiligenceDataVO;
import com.masspick.peak.dd.controller.vo.GroupVO;
import com.masspick.peak.dd.controller.vo.TemplateVO;
import com.masspick.peak.dd.mapper.DueDilDataMapper;
import com.masspick.peak.dd.mapper.DueTaskMapper;
import com.masspick.peak.dd.mapper.TemplateMapper;
import com.masspick.peak.dd.model.DueDilData;
import com.masspick.peak.dd.model.DueTask;
import com.masspick.peak.dd.model.Template;
import com.masspick.peak.dd.model.bo.TemplateControlBO;
import com.masspick.peak.dd.service.DueDiligenceDataService;
import com.masspick.peak.dd.util.ResultEnum;
import com.masspick.peak.service.IFlowService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 2018/5/23 0023.
 */
@Service
public class DueDiligenceDataServiceImpl implements DueDiligenceDataService {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DueDiligenceDataServiceImpl.class);

    /**
     * dueTaskMapper
     */
    @Autowired
    private DueTaskMapper dueTaskMapper;

    /**
     * dueDilDataMapper
     */
    @Autowired
    private DueDilDataMapper dueDilDataMapper;

    /**
     * systemConfig
     */
    @Autowired
    private SystemConfig systemConfig;

    /**
     * templateMapper
     */
    @Autowired
    private TemplateMapper templateMapper;

    /**
     * iFlowService
     */
    @Resource
    private IFlowService iFlowService;

    /**
     * cosClient
     */
    @Autowired
    private COSClient cosClient;

    /**
     * BASE_SIZE
     */
    private static final Integer BASE_SIZE = 256;

    /**
     * LEN_11
     */
    private static final int LEN_11 = 11;

    /**
     * LEN_256
     */
    private static final int LEN_256 = 256;

    /**
     * 尽调完成
     *
     * @param dueDiligenceDataVO
     * @return ApiResponse
     */
    @Transactional
    @Override
    public ApiResponse updateAndSave(DueDiligenceDataVO dueDiligenceDataVO, String account) throws Exception {
        ApiResponse apiResponse = ApiResponse.getInstances();
        String operate = dueDiligenceDataVO.getOperate();
//        DueTask dueTask = dueTaskMapper.findById(dueDiligenceDataVO.getTaskId());

        List<DueDilData> list = dueDiligenceDataVO.getData();

        //先删除 再添加
        dueDilDataMapper.delete(dueDiligenceDataVO.getTaskId(), dueDiligenceDataVO.getTemplateId());
        for (DueDilData dueDilData : list) {
            dueDilData.setTemplateId(dueDiligenceDataVO.getTemplateId());
            dueDilData.setTaskId(dueDiligenceDataVO.getTaskId());
            dueDilData.setId(SequenceUtils.getUUID());
        }
        dueDilDataMapper.insertList(list);

//        if ("save".equals(operate)) {
//            dueTask.setFinishDate(new Date());
//            dueTask.setState(DueTask.FINISH);
//            Template template = templateMapper.findById(dueTask.getTemplateId());
//            DueDilData thirdEntGuarant = dueDilDataMapper.findByTaskIdAndControlKey(dueTask.getId(), "thirdEntGuarant");
//            DueDilData thirdPartyPerGuarant = dueDilDataMapper.findByTaskIdAndControlKey(dueTask.getId(),
//                    "thirdPartyPerGuarant");
//            DueDilData contractCode = dueDilDataMapper.findByTaskIdAndControlKey(dueTask.getId(),
//                    "contractCode");
//
//            DueDilData totalCapital = dueDilDataMapper.findByTaskIdAndControlKey(dueTask.getId(),
//                    "totalCapital");
//            DueDilData totalDebt = dueDilDataMapper.findByTaskIdAndControlKey(dueTask.getId(),
//                    "totalDebt");
//            DueDilData loanTerm = dueDilDataMapper.findByTaskIdAndControlKey(dueTask.getId(),
//                    "loanTerm");
//            DueDilData loanAmount = dueDilDataMapper.findByTaskIdAndControlKey(dueTask.getId(),
//                    "loanAmount ");
//            Map<String, String> map = new HashMap<>();
//            map.put("action", "complete");
//            map.put("userId", account);
//            map.put("completeTime", DateUtils.format(dueTask.getFinishDate(), "yyyy-MM-dd HH:mm:ss"));
//            map.put("state", "pass");
//            map.put("ddOperator", "pass");
//            map.put("templateName", template.getName());
//            map.put("thirdEntGuarant", thirdEntGuarant != null ? thirdEntGuarant.getValue() : "");
//            map.put("thirdPartyPerGuarant", thirdPartyPerGuarant != null ? thirdPartyPerGuarant.getValue() : "");
//            map.put("contractCode", contractCode != null ? contractCode.getValue() : "");
//            map.put("qyAssetsTotal", totalCapital != null ? totalCapital.getValue() : "");
//            map.put("qyCreditTotal", totalDebt != null ? totalDebt.getValue() : "");
//            map.put("loanTerm", loanTerm != null ? loanTerm.getValue() : "");
//            map.put("loanAmount", loanAmount != null ? loanAmount.getValue() : "");
//            try {
//                String code = iFlowService.completeTask(dueTask.getOutId(), map);
//                dueTaskMapper.update(dueTask);
//                if (StringUtils.isEmpty(code) && code.equals("error")) {
//                    return apiResponse.error("ERROR-500", "调用流程失败!!!");
//                }
//            } catch (Exception e) {
//                LOGGER.error(e.toString());
//                return apiResponse.error("ERROR-500", "调用流程失败!!!");
//            }
//        } else {
//    }
        if ("save".equals(operate)) {
            DueTask dueTask = new DueTask();
            dueTask.setFinishDate(new Date());
            dueTask.setId(dueDiligenceDataVO.getTaskId());
            dueTaskMapper.update(dueTask);
            dueTaskMapper.updateState(dueDiligenceDataVO.getTaskId(), DueTask.FINISH);
        } else {
            dueTaskMapper.updateState(dueDiligenceDataVO.getTaskId(), DueTask.UNDER_WAY);
        }
        return apiResponse.success().setResult("success");
    }

    /**
     * 重写上传 至sso
     *
     * @param imgStr base64
     * @return
     * @throws IOException
     */
    @Override
    public ApiResponse generateImageCos(String imgStr) throws IOException {
        ApiResponse apiResponse = ApiResponse.getInstances();
        ResultEnum resultEnum;
        String destinationDir = DateUtils.format(new Date(), "yyyy-MM-dd");
        String uuid = SequenceUtils.getUUID();
        // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) {
            // 图像数据为空
            return null;
        }
        String suffix = "jpg";
        Pattern p = Pattern.compile("\t|\r|\n");
        if (imgStr.contains(";base64,")) {
            String[] images = imgStr.split(";base64,");
            imgStr = images[1];
            String temp = images[0].substring(LEN_11).toString();
            if ("jpeg".equals(temp)) {
                suffix = "jpg";
            } else {
                suffix = temp;
            }
        }
        Matcher m = p.matcher(imgStr);
        String imgStrReplace = m.replaceAll("").replaceAll(" ", "");
        Base64 decoder = new Base64();
        byte[] b = decoder.decodeBase64(imgStrReplace);
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {

                //调整异常数据
                b[i] += LEN_256;
            }
        }
        String key = systemConfig.getCosDir() + destinationDir + "/" + uuid + "." + suffix;
        InputStream inputStream = new ByteArrayInputStream(b);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(b.length);
        PutObjectRequest putObjectRequest = new PutObjectRequest(systemConfig.getCosBucketName(),
                key, inputStream, objectMetadata);
        try {
            cosClient.putObject(putObjectRequest);
            return apiResponse.success(systemConfig.getCosUrl() + "/" + key);
        } catch (Exception e) {
            LOGGER.error("error message", e);
            LOGGER.error("error", "本地文件不存在，请重新操作!");
            resultEnum = ResultEnum.SYSTEM_ERROR;
            return apiResponse.error(resultEnum.getCode(), resultEnum.getReason());
        } finally {
            cosClient.shutdown();
        }
    }


    @Override
    public ApiResponse result(String taskId, String templateId) {
        ApiResponse apiResponse = ApiResponse.getInstances();
        ResultEnum resultEnum;
        TemplateVO templateVO = new TemplateVO();
        Template template = templateMapper.findById(templateId);


        //template为null 即退出
        if (null == template) {
            resultEnum = ResultEnum.UNKNOWN_TEMPLATE;
            return apiResponse.error(resultEnum.getCode(), resultEnum.getReason());
        }

        //转换模板
        templateVO.transfer(templateVO, template);
        //获取组
        List<Map<String, Object>> groupList = dueDilDataMapper.groupByGroupSeq(taskId, templateId);


        List<TemplateControlBO> templateControlBOS = dueDilDataMapper.taskData(taskId, templateId);
        //获取控件

        //循环搞数据
        for (Map<String, Object> group : groupList) {
            GroupVO groupVO = new GroupVO();
            groupVO.transfer(groupVO, group);
            for (TemplateControlBO templateControlBO : templateControlBOS) {
                //分组key相同 就进行数据增加
                if (groupVO.getGroupKey().equals(templateControlBO.getGroupKey())) {
                    ControlVO controlVO = new ControlVO();
                    controlVO.transfer(controlVO, templateControlBO);
                    controlVO.setName(groupVO.getGroupKey() + controlVO.getId());

                    //添加组件
                    groupVO.getControlList().add(controlVO);
                }
            }
            //添加分组数据
            templateVO.getBlockList().add(groupVO);
        }
        return apiResponse.success(templateVO);
    }
}
