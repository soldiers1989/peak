package com.masspick.peak.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.model.dto.tax.TaxProfitMirco;

import java.io.IOException;

/**
 * Created by Administrator on 2018\6\12 0012.
 */
public class TaxProfitMircoDeserializer extends JsonDeserializer<TaxProfitMirco> {
    @Override
    public TaxProfitMirco deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
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
    private TaxProfitMirco deserializer(JsonNode json) {
        TaxProfitMirco obj = new TaxProfitMirco();
        obj.setId(SequenceUtils.getUUID());
        obj.setYearFee(JacksonUtils.getDouble(json, "bnljje"));
        obj.setMonthFee(JacksonUtils.getDouble(json, "byje"));
        obj.setCategory(JacksonUtils.getString(json, "hmc"));
        obj.setUpdateDate(JacksonUtils.getString(json, "xgrq"));
        obj.setOutId(JacksonUtils.getString(json, "zlbscjuuid"));
        obj.setSeqNo(JacksonUtils.getString(json, "ewbhxh"));
        return obj;
    }
}
