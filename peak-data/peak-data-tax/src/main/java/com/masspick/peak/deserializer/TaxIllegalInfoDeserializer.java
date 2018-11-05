package com.masspick.peak.deserializer;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.model.dto.tax.TaxIllegalInfo;

import java.io.IOException;

/**
 * Created by Administrator on 2018\6\12 0012.
 */
public class TaxIllegalInfoDeserializer extends JsonDeserializer<TaxIllegalInfo> {
    @Override
    public TaxIllegalInfo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
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
    private TaxIllegalInfo deserializer(JsonNode json) {
        TaxIllegalInfo obj = new TaxIllegalInfo();
        obj.setId(SequenceUtils.getUUID());
        obj.setRegDate(JacksonUtils.getString(json, "djrq"));
        obj.setFact(JacksonUtils.getString(json, "wfss"));
        obj.setCategory(JacksonUtils.getString(json, "sswflxmc"));
        obj.setHandleStateCode(JacksonUtils.getString(json, "sswfxwclztdm"));
        obj.setHandleStateName(JacksonUtils.getString(json, "sswfxwclztmc"));
        obj.setStartDate(JacksonUtils.getString(json, "ssqjz1"));
        obj.setEndDate(JacksonUtils.getString(json, "ssqjq1"));
        obj.setIllegalName(JacksonUtils.getString(json, "wfxwmc"));
        obj.setCaseMark(JacksonUtils.getString(json, "jcajbz"));
        obj.setCancelSign(JacksonUtils.getString(json, "zfbz"));
        obj.setCancelDate(JacksonUtils.getString(json, "zfrq1"));
        return obj;
    }
}
