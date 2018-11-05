package com.masspick.peak.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.masspick.peak.common.util.DateUtils;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.model.dto.tax.TaxRegInfo;

import java.io.IOException;

/**
 * Created by Administrator on 2018\6\12 0012.
 */

public class TaxRegInfoDeserializer extends JsonDeserializer<TaxRegInfo> {
    @Override
    public TaxRegInfo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
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
    private TaxRegInfo deserializer(JsonNode json) {
        TaxRegInfo obj = new TaxRegInfo();
        obj.setId(SequenceUtils.getUUID());
        obj.setRegId(JacksonUtils.getString(json, "nsrsbh"));
        obj.setRegName(JacksonUtils.getString(json, "nsrmc"));
        obj.setOrgId(JacksonUtils.getString(json, "zzjglxDm"));
        obj.setAddress(JacksonUtils.getString(json, "zcdz"));
        obj.setProdAddress(JacksonUtils.getString(json, "scjydz"));
        obj.setBussScope(JacksonUtils.getString(json, "jyfw"));
        obj.setProdPhone(JacksonUtils.getString(json, "scjydlxdh"));
        obj.setRegCategory(JacksonUtils.getString(json, "nsrzglxMc"));
        obj.setOpenTime(JacksonUtils.getDate(json, "kyslrq", DateUtils.CLEAN_PATTERN_ARRAY));
        obj.setBusinessStart(JacksonUtils.getString(json, "scjyqxq"));
        obj.setBusinessFinish(JacksonUtils.getString(json, "scjyqxz"));
        obj.setRegCapital(JacksonUtils.getDouble(json, "zczb"));
        obj.setIndustryCode(JacksonUtils.getString(json, "hyDm"));
        obj.setIndustryName(JacksonUtils.getString(json, "hymc"));
        obj.setEmployerCount(JacksonUtils.getInt(json, "cyrs"));
        obj.setRegTypeCode(JacksonUtils.getString(json, "djzclxDm"));
        obj.setRegTypeName(JacksonUtils.getString(json, "djzclxmc"));
        obj.setRegState(JacksonUtils.getString(json, "nsrztmc"));
        obj.setAccountStandardName(JacksonUtils.getString(json, "kjzdzzmc"));
        obj.setProdPostcode(JacksonUtils.getString(json, "scjydyzbm"));
        obj.setTaxOffice(JacksonUtils.getString(json, "zgswjmc"));
        return obj;
    }
}
