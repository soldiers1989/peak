package com.masspick.peak.deserializer;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.model.dto.tax.TaxLevyInfo;

import java.io.IOException;

/**
 * Created by Administrator on 2018\6\12 0012.
 */
public class TaxLevyInfoDeserializer extends JsonDeserializer<TaxLevyInfo> {
    @Override
    public TaxLevyInfo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
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
    private TaxLevyInfo deserializer(JsonNode json) {
        TaxLevyInfo obj = new TaxLevyInfo();
        obj.setId(SequenceUtils.getUUID());
        obj.setOpenDate(JacksonUtils.getString(json, "kjrq"));
        obj.setPaymentDate(JacksonUtils.getString(json, "jkqx"));
        obj.setTaxStartDate(JacksonUtils.getString(json, "skssqq"));
        obj.setTaxEndDate(JacksonUtils.getString(json, "skssqz"));
        obj.setCollectItem(JacksonUtils.getString(json, "zsxmmc"));
        obj.setTaxType(JacksonUtils.getString(json, "skzlmc"));
        obj.setTaxState(JacksonUtils.getString(json, "skzt"));
        obj.setBaseTax(JacksonUtils.getDouble(json, "jsyj"));
        obj.setTaxRate(JacksonUtils.getDouble(json, "sl1"));
        obj.setPaidTax(JacksonUtils.getDouble(json, "yjse"));
        obj.setPayableTax(JacksonUtils.getDouble(json, "sjje"));
        return obj;
    }
}
