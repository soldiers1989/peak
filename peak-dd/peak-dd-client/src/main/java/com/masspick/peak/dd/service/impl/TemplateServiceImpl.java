package com.masspick.peak.dd.service.impl;

import com.masspick.peak.common.util.ApiResponse;
import com.masspick.peak.common.util.StringUtils;
import com.masspick.peak.dd.config.SystemConfig;
import com.masspick.peak.dd.controller.vo.ControlVO;
import com.masspick.peak.dd.controller.vo.DicVO;
import com.masspick.peak.dd.controller.vo.GroupVO;
import com.masspick.peak.dd.controller.vo.TemplateVO;
import com.masspick.peak.dd.mapper.DueTaskMapper;
import com.masspick.peak.dd.mapper.TemplateControlMapper;
import com.masspick.peak.dd.mapper.TemplateMapper;
import com.masspick.peak.dd.model.DueTask;
import com.masspick.peak.dd.model.Template;
import com.masspick.peak.dd.model.bo.TemplateControlBO;
import com.masspick.peak.dd.service.TemplateService;
import com.masspick.peak.dd.util.ResultEnum;
import com.masspick.peak.service.IDictionaryFeignApi;
import com.masspick.peak.service.dto.SysDictionaryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/5/23 0023.
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    /**
     * Logger
     */
    protected static final Logger LOGGER = LoggerFactory.getLogger(TemplateServiceImpl.class);

    /**
     * templateMapper
     */
    @Autowired
    private TemplateMapper templateMapper;

    /**
     * dueTaskMapper
     */
    @Autowired
    private DueTaskMapper dueTaskMapper;

    /**
     * templateControlMapper
     */
    @Autowired
    private TemplateControlMapper templateControlMapper;

    /**
     *
     */
    @Autowired
    private IDictionaryFeignApi iDictionaryFeignApi;

    /**
     * systemConfig
     */
    @Autowired
    private SystemConfig systemConfig;

    /**
     * 尽调模板生成
     *
     * @param templateId
     * @return ApiResponse
     */
    @Override
    public ApiResponse template(String templateId, String taskId) throws Exception {
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
        List<Map<String, Object>> groupList = templateControlMapper.findGroupKey(templateId);

        //查找当前任务是否是进行中，还是未开始
        DueTask dueTask = dueTaskMapper.findById(taskId);
        List<TemplateControlBO> templateControlBOS = null;
        if (DueTask.TO_START == dueTask.getState()) {
            templateControlBOS = templateControlMapper.template(templateId, null);
        } else {
            templateControlBOS = templateControlMapper.templateRelate(templateId, taskId);
        }
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

                    //不为空表示下拉选择框 或者复选框
                    if (!StringUtils.isEmpty(templateControlBO.getDataSourceCode())) {
                        List<DicVO> dicVOS = new ArrayList<>();
                        List<SysDictionaryDTO> sysDictionaryList =
                                iDictionaryFeignApi.getDictionaryItem(templateControlBO.getDataSourceCode());
                        DicVO.transfer(dicVOS, sysDictionaryList);
                        controlVO.setOption(dicVOS);
                    }
                    //添加组件
                    groupVO.getControlList().add(controlVO);
                }
            }
            //添加分组数据
            templateVO.getBlockList().add(groupVO);
        }
        return apiResponse.success(templateVO);
    }

    @Override
    public Template findById(String templateId) {
        return templateMapper.findById(templateId);
    }
}
