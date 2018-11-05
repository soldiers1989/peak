package com.masspick.peak.deserializer;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.model.dto.tax.TaxInspectInfo;

import java.io.IOException;

/**
 * Created by Administrator on 2018\6\12 0012.
 */
public class TaxInspectInfoDeserializer extends JsonDeserializer<TaxInspectInfo> {
    @Override
    public TaxInspectInfo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
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
    private TaxInspectInfo deserializer(JsonNode json) {
        TaxInspectInfo obj = new TaxInspectInfo();
        obj.setId(SequenceUtils.getUUID());
        obj.setCaseNo(JacksonUtils.getString(json, "jcajxxuuid"));
        obj.setCaseCategory(JacksonUtils.getString(json, "aljxDm"));
        obj.setCloseDate(JacksonUtils.getString(json, "jarq"));
        obj.setInspectContent(JacksonUtils.getString(json, "jcfwhnr"));
        obj.setInspectConclusion(JacksonUtils.getString(json, "swjcjl"));
        return obj;
    }
}

