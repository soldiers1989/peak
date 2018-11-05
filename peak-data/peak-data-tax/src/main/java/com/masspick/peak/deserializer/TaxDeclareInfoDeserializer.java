package com.masspick.peak.deserializer;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.model.dto.tax.TaxDeclareInfo;

import java.io.IOException;

/**
 * Created by Administrator on 2018\6\12 0012.
 */
public class TaxDeclareInfoDeserializer extends JsonDeserializer<TaxDeclareInfo> {
    @Override
    public TaxDeclareInfo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
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
    private TaxDeclareInfo deserializer(JsonNode json) {
        TaxDeclareInfo obj = new TaxDeclareInfo();
        obj.setId(SequenceUtils.getUUID());
        obj.setDeclareDate(JacksonUtils.getString(json, "nssbrq"));
        obj.setDeclareTermDate(JacksonUtils.getString(json, "sbqx"));
        obj.setTaxStartDate(JacksonUtils.getString(json, "skssqq"));
        obj.setTaxEndDate(JacksonUtils.getString(json, "skssqz"));
        obj.setCollectItem(JacksonUtils.getString(json, "zsxmmc"));
        obj.setTotalIncome(JacksonUtils.getDouble(json, "ysx"));
        obj.setBaseTax(JacksonUtils.getDouble(json, "jsyj"));
        obj.setTaxRate(JacksonUtils.getDouble(json, "sl1"));
        obj.setPayableTax(JacksonUtils.getDouble(json, "ynse"));
        obj.setPaidTax(JacksonUtils.getDouble(json, "yjse"));
        obj.setOverpayTax(JacksonUtils.getDouble(json, "ybtse"));
        obj.setVoucherType(JacksonUtils.getString(json, "yzpzzlmc"));
        obj.setCancelSign(JacksonUtils.getString(json, "zfbz1"));
        obj.setCancelDate(JacksonUtils.getString(json, "zfrq1"));
        obj.setReduceTax(JacksonUtils.getDouble(json, "jmse"));
        return obj;
    }
}
