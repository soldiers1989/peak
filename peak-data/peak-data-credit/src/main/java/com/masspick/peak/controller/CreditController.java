package com.masspick.peak.controller;


import com.masspick.peak.common.model.ErrorCode;
import com.masspick.peak.common.model.JsonResult;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.excel.ExcelImportResult;
import com.masspick.peak.model.credit.etp.dto.EtpCreditReportDto;
import com.masspick.peak.model.credit.self.dto.SelfCreditReportDto;
import com.masspick.peak.repository.EtpCreditReportRepository;
import com.masspick.peak.repository.SelfCreditReportRepository;
import com.masspick.peak.service.EtpCreditReportParseService;
import com.masspick.peak.service.SelfCreditReportParseService;
import com.mongodb.Mongo;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static com.masspick.peak.common.model.ErrorCode.ERROR_404;


/**
 * Created by Administrator on 2018/6/14.
 */
@RestController
public class CreditController {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CreditController.class);

    /**
     * mongo
     */
    @Autowired
    private Mongo mongo;

    /**
     * etpCreditReportParseService
     */
    @Autowired
    private EtpCreditReportParseService etpCreditReportParseService;

    /**
     * selfCreditReportParseService
     */
    @Autowired
    private SelfCreditReportParseService selfCreditReportParseService;

    /**
     * etpCreditReportRepository
     */
    @Autowired
    private EtpCreditReportRepository etpCreditReportRepository;

    /**
     * selfCreditReportRepository
     */
    @Autowired
    private SelfCreditReportRepository selfCreditReportRepository;

    /**
     * @param world
     * @return Object
     */
    @GetMapping("/credit/hello")
    public Object hello(String world) {
        return "world";
    }

    /**
     * @return Object
     * @throws IllegalAccessException    IllegalAccessException
     * @throws IOException               IOException
     * @throws InvocationTargetException InvocationTargetException
     */
    @GetMapping("/credit/etp")
    public Object etp() throws IllegalAccessException, IOException, InvocationTargetException {
        ExcelImportResult<EtpCreditReportDto> importResult = etpCreditReportParseService.parse();
        EtpCreditReportDto data = importResult.getData();
        if (data != null) {
            data.setId(SequenceUtils.getUUID());
            etpCreditReportRepository.insert(data);
            return JsonResult.renderSuccess(data.getId());
        }

        if (CollectionUtils.isNotEmpty(importResult.getErrorLogList())) {
            return JsonResult.renderError(ErrorCode.ERROR_500.getCode(), ErrorCode.ERROR_500.getMsg(), importResult.getErrorLogList());
        } else {
            return JsonResult.renderError(ErrorCode.ERROR_500);
        }
    }

    /**
     * @return Object
     * @throws IllegalAccessException    IllegalAccessException
     * @throws IOException               IOException
     * @throws InvocationTargetException InvocationTargetException
     */
    @GetMapping("/credit/self")
    public Object self() throws IllegalAccessException, IOException, InvocationTargetException {
        ExcelImportResult<SelfCreditReportDto> importResult = selfCreditReportParseService.parse();
        SelfCreditReportDto data = importResult.getData();
        if (data != null) {
            data.setId(SequenceUtils.getUUID());
            selfCreditReportRepository.insert(data);
            return JsonResult.renderSuccess(data.getId());
        }

        if (CollectionUtils.isNotEmpty(importResult.getErrorLogList())) {
            return JsonResult.renderError(ErrorCode.ERROR_500.getCode(), ErrorCode.ERROR_500.getMsg(), importResult.getErrorLogList());
        } else {
            return JsonResult.renderError(ErrorCode.ERROR_500);
        }
    }

    /**
     * @param etpFile
     * @param selfFile
     * @return Object
     */
    @RequestMapping(value = "/credit/import", method = RequestMethod.POST)
    public Object importCredit(@RequestParam("etp") MultipartFile etpFile, @RequestParam("self") MultipartFile selfFile) {
        try {

            ExcelImportResult<EtpCreditReportDto> etpImportResult = etpCreditReportParseService.parse(etpFile.getInputStream());
            ExcelImportResult<SelfCreditReportDto> selfImportResult = selfCreditReportParseService.parse(selfFile.getInputStream());
            EtpCreditReportDto etpData = etpImportResult.getData();
            SelfCreditReportDto selfData = selfImportResult.getData();
            if (etpData != null && selfData != null) {
                etpData.setId(SequenceUtils.getUUID());
                selfData.setId(SequenceUtils.getUUID());
                etpCreditReportRepository.insert(etpData);
                selfCreditReportRepository.insert(selfData);
                Map<String, String> result = new HashMap<>();
                result.put("etpCreditReportId", etpData.getId());
                result.put("selfCreditReportId", selfData.getId());
                return JsonResult.renderSuccess(result);
            }

            if (CollectionUtils.isNotEmpty(etpImportResult.getErrorLogList()) || CollectionUtils.isNotEmpty(selfImportResult.getErrorLogList())) {
                Map<String, Object> result = new HashMap<>();
                result.put("etpCreditReportError", etpImportResult.getErrorLogList());
                result.put("selfCreditReportError", selfImportResult.getErrorLogList());
                return JsonResult.renderError(ErrorCode.ERROR_500.getCode(), ErrorCode.ERROR_500.getMsg(), result);
            } else {
                return JsonResult.renderError(ErrorCode.ERROR_500);
            }
        } catch (Exception ex) {
            LOGGER.error("系统异常", ex);
            return JsonResult.renderError(ErrorCode.ERROR_500.getCode(), ex.getMessage());
        }
    }

    /**
     * @param id
     * @return Object
     */
    @GetMapping("/credit/self/{id}")
    public Object selfCreditReport(@PathVariable String id) {
        SelfCreditReportDto dto = selfCreditReportRepository.findById(id) == null ? null : selfCreditReportRepository.findById(id).get();
        if (dto != null) {
            return JsonResult.renderSuccess(dto);
        } else {
            return JsonResult.renderError(ERROR_404.getCode(), ERROR_404.getMsg());
        }
    }

    /**
     * @param id
     * @return Object
     */
    @GetMapping("/credit/etp/{id}")
    public Object etpCreditReport(@PathVariable String id) {
        EtpCreditReportDto dto = etpCreditReportRepository.findById(id) == null ? null : etpCreditReportRepository.findById(id).get();
        if (dto != null) {
            return JsonResult.renderSuccess(dto);
        } else {
            return JsonResult.renderError(ERROR_404.getCode(), ERROR_404.getMsg());
        }
    }
}
