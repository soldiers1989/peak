package com.masspick.peak.deserializer;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.model.dto.tax.TaxBalanceNormal;

import java.io.IOException;

/**
 * 资产负债表（适用执行一般企业会计制度的企业）
 */
public class TaxBalanceNormalDeserializer extends JsonDeserializer<TaxBalanceNormal> {
    @Override
    public TaxBalanceNormal deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
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
    private TaxBalanceNormal deserializer(JsonNode json) {
        TaxBalanceNormal obj = new TaxBalanceNormal();
        obj.setId(SequenceUtils.getUUID());
        obj.setYearBeginEquity(JacksonUtils.getDouble(json, "ncyeQy"));
        obj.setTermEndEquity(JacksonUtils.getDouble(json, "qmyeQy"));
        obj.setDebtEquityItem(JacksonUtils.getString(json, "qyxmmc"));
        obj.setYearBeginAsset(JacksonUtils.getDouble(json, "ncyeZc"));
        obj.setYearEndAsset(JacksonUtils.getDouble(json, "qmyeZc"));
        obj.setUpdateDate(JacksonUtils.getString(json, "xgrq"));
        obj.setAssetItem(JacksonUtils.getString(json, "zcxmmc"));
        obj.setSeqNo(JacksonUtils.getString(json, "ewbhxh"));
        obj.setOutId(JacksonUtils.getString(json, "zlbscjuuid"));
        return obj;
    }
}
