package com.masspick.peak.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.model.dto.tax.TaxEquityChangeNormal;

import java.io.IOException;

/**
 * Created by Administrator on 2018\6\12 0012.
 */
public class TaxEquityChangeNormalDeserializer extends JsonDeserializer<TaxEquityChangeNormal> {
    @Override
    public TaxEquityChangeNormal deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
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
    private TaxEquityChangeNormal deserializer(JsonNode json) {
        TaxEquityChangeNormal obj = new TaxEquityChangeNormal();
        obj.setId(SequenceUtils.getUUID());
        obj.setLastYearSurplus(JacksonUtils.getDouble(json, "snyygj"));
        obj.setLastYearUndisProfit(JacksonUtils.getDouble(json, "snwfply"));
        obj.setLastYearTotalEquity(JacksonUtils.getDouble(json, "snsyzqyhj"));
        obj.setYearReserve(JacksonUtils.getDouble(json, "bnzbgj"));
        obj.setYearStock(JacksonUtils.getDouble(json, "bnjkcg"));
        obj.setYearSurplus(JacksonUtils.getDouble(json, "bnyygj"));
        obj.setYearUndisProfit(JacksonUtils.getDouble(json, "bnwfply"));
        obj.setYearTotalEquity(JacksonUtils.getDouble(json, "bnsyzqyhj"));
        obj.setLastYearRealCap(JacksonUtils.getDouble(json, "snsszbhgb"));
        obj.setLastYearCapReserve(JacksonUtils.getDouble(json, "snzbgj"));
        obj.setLastYearStock(JacksonUtils.getDouble(json, "snjkcg"));
        obj.setUpdateDate(JacksonUtils.getString(json, "xgrq"));
        obj.setOutId(JacksonUtils.getString(json, "zlbscjuuid"));
        obj.setSeqNo(JacksonUtils.getString(json, "ewbhxh"));
        obj.setCategory(JacksonUtils.getString(json, "hmc"));
        obj.setYearRealCap(JacksonUtils.getDouble(json, "bnsszbhgb"));
        return obj;
    }
}
