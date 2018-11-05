package com.masspick.peak.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.model.dto.tax.TaxProfitNormal;

import java.io.IOException;

/**
 * Created by Administrator on 2018\6\12 0012.
 */
public class TaxProfitNormalDeserializer extends JsonDeserializer<TaxProfitNormal> {
    @Override
    public TaxProfitNormal deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
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
    private TaxProfitNormal deserializer(JsonNode json) {
        TaxProfitNormal obj = new TaxProfitNormal();
        obj.setId(SequenceUtils.getUUID());
        obj.setOutId(JacksonUtils.getString(json, "zlbscjuuid"));
        obj.setSeqNo(JacksonUtils.getString(json, "ewbhxh"));
        obj.setCategory(JacksonUtils.getString(json, "hmc"));
        obj.setLastTermFee(JacksonUtils.getDouble(json, "sqje1"));
        obj.setUpdateDate(JacksonUtils.getString(json, "xgrq"));
        obj.setTermFee(JacksonUtils.getDouble(json, "bqje"));
        return obj;
    }
}
