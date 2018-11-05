package com.masspick.peak.dd.service;


import com.masspick.peak.common.util.ApiResponse;
import com.masspick.peak.dd.controller.vo.DueDiligenceDataVO;

import java.io.IOException;

/**
 * Created by admin on 2018/5/23 0023.
 */
public interface DueDiligenceDataService {

    /**
     * @param dueDiligenceDataVO
     * @param account
     * @return ApiResponse
     * @throws Exception Exception
     */
    ApiResponse updateAndSave(DueDiligenceDataVO dueDiligenceDataVO, String account) throws Exception;


    /**
     * @param imgStr
     * @return ApiResponse
     * @throws IOException IOException
     */
    ApiResponse generateImageCos(String imgStr) throws IOException;

    /**
     * 查看模板数据
     *
     * @param taskId
     * @param templateId
     * @return ApiResponse
     */
    ApiResponse result(String taskId, String templateId);
}
