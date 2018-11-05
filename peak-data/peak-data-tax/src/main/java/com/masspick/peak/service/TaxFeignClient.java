package com.masspick.peak.service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.masspick.peak.common.util.DateUtils;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.common.util.ObjectUtils;
import com.masspick.peak.common.util.SendHttpPost;
import com.masspick.peak.config.ParamsCheck;
import com.masspick.peak.config.TaxConstants;
import com.masspick.peak.config.TaxRequestParams;
import com.masspick.peak.deserializer.TaxBalanceMircoDeserializer;
import com.masspick.peak.deserializer.TaxBalanceNormalDeserializer;
import com.masspick.peak.deserializer.TaxDeclareInfoDeserializer;
import com.masspick.peak.deserializer.TaxEquityChangeNormalDeserializer;
import com.masspick.peak.deserializer.TaxGradeInfoDeserializer;
import com.masspick.peak.deserializer.TaxIllegalInfoDeserializer;
import com.masspick.peak.deserializer.TaxInspectInfoDeserializer;
import com.masspick.peak.deserializer.TaxLevyInfoDeserializer;
import com.masspick.peak.deserializer.TaxProfitMircoDeserializer;
import com.masspick.peak.deserializer.TaxProfitMircoReportDeserializer;
import com.masspick.peak.deserializer.TaxProfitNormalDeserializer;
import com.masspick.peak.deserializer.TaxRegInfoDeserializer;
import com.masspick.peak.model.dto.tax.TaxBalanceMirco;
import com.masspick.peak.model.dto.tax.TaxBalanceNormal;
import com.masspick.peak.model.dto.tax.TaxDTO;
import com.masspick.peak.model.dto.tax.TaxDeclareInfo;
import com.masspick.peak.model.dto.tax.TaxEquityChangeNormal;
import com.masspick.peak.model.dto.tax.TaxGradeInfo;
import com.masspick.peak.model.dto.tax.TaxIllegalInfo;
import com.masspick.peak.model.dto.tax.TaxInspectInfo;
import com.masspick.peak.model.dto.tax.TaxLevyInfo;
import com.masspick.peak.model.dto.tax.TaxProfitMirco;
import com.masspick.peak.model.dto.tax.TaxProfitMircoReport;
import com.masspick.peak.model.dto.tax.TaxProfitNormal;
import com.masspick.peak.model.dto.tax.TaxRegInfo;
import com.masspick.peak.model.dto.tax.TaxRequestDTO;
import com.masspick.peak.model.dto.tax.TaxResponseDTO;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * TaxFeignClient
 */
@RestController
public class TaxFeignClient implements ITaxFeignApi {

    /**
     * requestParams
     */
    @Autowired
    private TaxRequestParams requestParams;

    /**
     * mongoClient
     */
    @Autowired
    private MongoClient mongoClient;

    /**
     * MONTH_SIX
     */
    private static final int MONTH_SIX = -6;


    /**
     * 企业税务查询接口
     *
     * @param request
     * @return TaxResponseDTO
     */
    @Override
    @PostMapping("/tax")
    public TaxResponseDTO getEtpTaxData(@RequestBody TaxRequestDTO request) {
        ObjectMapper mapper = buildRegistMapper();
        TaxResponseDTO<TaxDTO> response = new TaxResponseDTO();

        //检查参数
        String result = ParamsCheck.checkTaxParams(request);
        if (!result.equals("success")) {
            response.setResCode("201");
            response.setResDesc(result);
            return response;
        }

        //查看mango数据库中是否已有该数据
        response = findByMango(request);
        if (response != null && response.getData() != null) {
            response.setResCode(TaxConstants.SUCCESS_CODE);
            response.setResDesc(TaxConstants.SUCCESS_DESC);
            return response;
        }

        try {
            //请求博汇九州的税务查询接口
            File file = ResourceUtils.getFile("classpath:auth/taxAuth.txt");
            request.setChannel(requestParams.getChannel());
            request.setUserName(requestParams.getUserName());
            request.setSign(requestParams.getSign());
            Map<String, String> params = ObjectUtils.objectToMap(request);
            String resp = SendHttpPost.post(requestParams.getAccessAddress(), "file", file, params);
            response = JacksonUtils.readValue(resp, TaxResponseDTO.class);
            TaxDTO dto = mapper.readValue(JacksonUtils.toJSon(response.getData()), TaxDTO.class);
            if (null != response && response.getResCode().equals(TaxConstants.SUCCESS_CODE)) {
                saveResponseToMango(request, response);
                response = saveTaxToMango(request, dto);
                response.setResCode(TaxConstants.SUCCESS_CODE);
                response.setResDesc(TaxConstants.SUCCESS_DESC);
            }
        } catch (Exception e) {
            response.setResCode("202");
            response.setResDesc("系统错误");
            e.printStackTrace();
        }
        return response;
    }

    /**
     * @param taxRequestDTO
     * @param responseDTO
     */
    public void saveResponseToMango(TaxRequestDTO taxRequestDTO, TaxResponseDTO responseDTO) {
        MongoDatabase database = mongoClient.getDatabase("tax");
        MongoCollection<Document> collection = database.getCollection("etptax");

        Document document = buildDocument(taxRequestDTO);
        document.append("createDate", DateUtils.format(new Date(), DateUtils.YEARHOURDAY_FORMAT));
        document.append("data", Document.parse(JSON.toJSONString(responseDTO.getData())));
        document.append("type", "outer");
        collection.insertOne(document);
    }


    /**
     * @param taxRequestDTO
     * @param dto
     * @return TaxResponseDTO<TaxDTO>
     */
    public TaxResponseDTO<TaxDTO> saveTaxToMango(TaxRequestDTO taxRequestDTO, TaxDTO dto) {
        TaxResponseDTO<TaxDTO> responseDTO = new TaxResponseDTO<>();
        MongoDatabase database = mongoClient.getDatabase("tax");
        MongoCollection<Document> collection = database.getCollection("etptax");

        Document document = buildDocument(taxRequestDTO);
        document.append("createDate", DateUtils.format(new Date(), DateUtils.YEARHOURDAY_FORMAT));
        document.append("type", "inner");
        document.append("data", Document.parse(JSON.toJSONString(dto)));
        collection.insertOne(document);

        try {
            ObjectMapper mapper = buildRegistMapper();
            String resp = document.toJson();
            responseDTO = mapper.readValue(resp, TaxResponseDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseDTO;
    }

    /**
     * @param taxRequestDTO
     * @return TaxResponseDTO<TaxDTO>
     */
    public TaxResponseDTO<TaxDTO> findByMango(TaxRequestDTO taxRequestDTO) {
        try {
            MongoDatabase database = mongoClient.getDatabase("tax");
            MongoCollection<Document> collection = database.getCollection("etptax");
            Bson bson = buildFilter(taxRequestDTO);
            FindIterable<Document> results = collection.find(bson);
            MongoCursor<Document> cursor = results.iterator();
            while (cursor.hasNext()) {
                ObjectMapper mapper = buildRegistMapper();
                Document document = cursor.next();
                String resp = document.toJson();
                TaxResponseDTO<TaxDTO> dto = mapper.readValue(resp, TaxResponseDTO.class);
                return dto;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return ObjectMapper
     */
    private ObjectMapper buildRegistMapper() {
        List<Module> moduleList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        moduleList.add(new SimpleModule("TaxBalanceMirco",
                Version.unknownVersion()).addDeserializer(TaxBalanceMirco.class, new TaxBalanceMircoDeserializer()));
        moduleList.add(new SimpleModule("TaxBalanceNormal",
                Version.unknownVersion()).addDeserializer(TaxBalanceNormal.class, new TaxBalanceNormalDeserializer()));
        moduleList.add(new SimpleModule("TaxDeclareInfo",
                Version.unknownVersion()).addDeserializer(TaxDeclareInfo.class, new TaxDeclareInfoDeserializer()));
        moduleList.add(new SimpleModule("TaxEquityChangeNormal",
                Version.unknownVersion()).addDeserializer(TaxEquityChangeNormal.class, new TaxEquityChangeNormalDeserializer()));
        moduleList.add(new SimpleModule("TaxGradeInfo",
                Version.unknownVersion()).addDeserializer(TaxGradeInfo.class, new TaxGradeInfoDeserializer()));
        moduleList.add(new SimpleModule("TaxIllegalInfo",
                Version.unknownVersion()).addDeserializer(TaxIllegalInfo.class, new TaxIllegalInfoDeserializer()));
        moduleList.add(new SimpleModule("TaxInspectInfo",
                Version.unknownVersion()).addDeserializer(TaxInspectInfo.class, new TaxInspectInfoDeserializer()));
        moduleList.add(new SimpleModule("TaxLevyInfo",
                Version.unknownVersion()).addDeserializer(TaxLevyInfo.class, new TaxLevyInfoDeserializer()));
        moduleList.add(new SimpleModule("TaxProfitMirco",
                Version.unknownVersion()).addDeserializer(TaxProfitMirco.class, new TaxProfitMircoDeserializer()));
        moduleList.add(new SimpleModule("TaxProfitMircoReport",
                Version.unknownVersion()).addDeserializer(TaxProfitMircoReport.class, new TaxProfitMircoReportDeserializer()));
        moduleList.add(new SimpleModule("TaxProfitNormal",
                Version.unknownVersion()).addDeserializer(TaxProfitNormal.class, new TaxProfitNormalDeserializer()));
        moduleList.add(new SimpleModule("TaxRegInfo",
                Version.unknownVersion()).addDeserializer(TaxRegInfo.class, new TaxRegInfoDeserializer()));
        mapper.registerModules(moduleList);
        return mapper;
    }

    /**
     * @param taxRequestDTO
     * @return Document
     */
    private Document buildDocument(TaxRequestDTO taxRequestDTO) {
        Document document = new Document();
        document.append("cname", taxRequestDTO.getCname());
        document.append("taxNo", taxRequestDTO.getTaxNo());
        document.append("areaCode", taxRequestDTO.getAreaCode());
        document.append("legalName", taxRequestDTO.getLegalName());
        document.append("legalIdCard", taxRequestDTO.getLegalIdCard());
        document.append("mobile", taxRequestDTO.getMobile());
        document.append("startDate", taxRequestDTO.getStartDate());
        document.append("endDate", taxRequestDTO.getEndDate());
        return document;
    }

    /**
     * @param taxRequestDTO
     * @return Bson
     */
    private Bson buildFilter(TaxRequestDTO taxRequestDTO) {
        Document document = new Document();
        document.put("cname", taxRequestDTO.getCname());
        document.put("taxNo", taxRequestDTO.getTaxNo());
        document.put("areaCode", taxRequestDTO.getAreaCode());
        document.put("legalName", taxRequestDTO.getLegalName());
        document.put("legalIdCard", taxRequestDTO.getLegalIdCard());
        document.put("mobile", taxRequestDTO.getMobile());
        document.put("startDate", taxRequestDTO.getStartDate());
        document.put("endDate", taxRequestDTO.getEndDate());
        document.put("type", "inner");
        document.put("createDate", new Document("$gt", DateUtils.getMontTime(MONTH_SIX)));
        return document;
    }
}
