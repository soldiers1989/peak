package com.masspick.peak.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.common.util.SequenceUtils;
import com.masspick.peak.model.dto.tax.TaxGradeInfo;

import java.io.IOException;

/**
 * Created by Administrator on 2018\6\12 0012.
 */
public class TaxGradeInfoDeserializer extends JsonDeserializer<TaxGradeInfo> {
    @Override
    public TaxGradeInfo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
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
    private TaxGradeInfo deserializer(JsonNode json) {
        TaxGradeInfo obj = new TaxGradeInfo();
        obj.setId(SequenceUtils.getUUID());
        obj.setYear(JacksonUtils.getString(json, "scnd"));
        obj.setGrade(JacksonUtils.getString(json, "xyglXyjbDm"));
        obj.setTaxOffice(JacksonUtils.getString(json, "swjgMc"));
        return obj;
    }
}
