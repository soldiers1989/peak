package com.masspick.peak.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

/**
 * 腾讯返回JSON数据处理Util类
 */
public final class JsonHelper {

    private JsonHelper() {
    }

    /**
     * @param ret
     * @return JSONArray
     */
    public static JSONArray removeRepeatItem(String ret) {

        if (!StringUtils.isEmpty(ret)) {
            JSONArray array = JSONObject.parseObject(ret).getJSONArray("result_list");
            if (array == null) {
                return null;
            }
            JSONObject object = array.getJSONObject(0);
            if (object.getIntValue("code") == 0) {
                //遍历
                JSONArray data = object.getJSONArray("data");
                if (data.size() > 0) {
                    JSONArray tempArray = new JSONArray(new ArrayList<>());

                    int num = 0;

                    for (int i = 0; i < data.size(); i++) {
                        if (num == 0) {
                            tempArray.add(data.get(i));
                        } else {
                            int numJ = 0;
                            for (int j = 0; j < tempArray.size(); j++) {
                                JSONObject newJsonObjectI = (JSONObject) data.get(i);
                                JSONObject newJsonObjectJ = (JSONObject) tempArray.get(j);

                                String itemI = newJsonObjectI.getString("item");
                                String valueI = newJsonObjectI.getString("value");
                                double confidenceI = newJsonObjectI.getDoubleValue("confidence");

                                String itemJ = newJsonObjectJ.get("item").toString();
                                String valueJ = newJsonObjectJ.getString("value");
                                double confidenceJ = newJsonObjectJ.getDoubleValue("confidence");

                                JSONObject newObject = new JSONObject();
                                if (itemI.equals(itemJ)) {
                                    String value;
                                    double confidence;
                                    newObject.put("item", itemI);
                                    if (confidenceI >= confidenceJ) {
                                        value = valueI;
                                        confidence = confidenceI;
                                    } else {
                                        value = valueJ;
                                        confidence = confidenceJ;
                                    }
                                    tempArray.remove(j);
                                    newObject.put("value", value);
                                    newObject.put("confidence", confidence);
                                    tempArray.add(newObject);
                                    break;
                                }

                                numJ++;
                            }

                            if (numJ - 1 == tempArray.size() - 1) {
                                tempArray.add(data.get(i));
                            }
                        }
                        num++;
                    }
                    return tempArray;
                }

                return null;
            }
        }

        return null;
    }
}
