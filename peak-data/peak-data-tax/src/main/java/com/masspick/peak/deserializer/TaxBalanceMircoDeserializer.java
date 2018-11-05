package com.masspick.peak.deserializer;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.model.dto.tax.TaxBalanceMirco;

import java.io.IOException;

/**
 * Created by Administrator on 2018\6\12 0012.
 */
public class TaxBalanceMircoDeserializer extends JsonDeserializer<TaxBalanceMirco> {
    /**
     * @param jsonParser
     * @param deserializationContext
     * @return
     * @throws IOException             IOException
     * @throws JsonProcessingException JsonProcessingException
     */
    @Override
    public TaxBalanceMirco deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        return deserializer(node);
    }

    /**
     * 反序列 抽查检查结果信息
     *
     * @param json
     * @return
     */
    private TaxBalanceMirco deserializer(JsonNode json) {
        TaxBalanceMirco obj = new TaxBalanceMirco();
        obj.setId(SequenceUtils.getUUID());
        obj.setProjectItem(JacksonUtils.getString(json, "qyxmmc"));
        obj.setSeqNo(JacksonUtils.getString(json, "ewbhxh"));
        obj.setOutId(JacksonUtils.getString(json, "zlbscjuuid"));
        obj.setAssetItem(JacksonUtils.getString(json, "zcxmmc"));
        obj.setAssetEndTermFee(JacksonUtils.getDouble(json, "qmyeZc"));
        obj.setAssetBeginYearFee(JacksonUtils.getDouble(json, "ncyeZc"));
        obj.setUpdateDate(JacksonUtils.getString(json, "xgrq"));
        obj.setEquityBeginYearFee(JacksonUtils.getDouble(json, "ncyeQy"));
        obj.setEquityEndTermFee(JacksonUtils.getDouble(json, "qmyeQy"));
        return obj;
    }
}
