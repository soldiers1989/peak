package com.masspick.peak.utils;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间工具类
 */
public class DateUtils {


    /**
     * @param list
     * @param sumOrder
     * @return
     */
    public static JSONObject orderSumUtils(List<Map> list, int sumOrder) {
        JSONObject json = new JSONObject();
        Map<Object, JSONObject> timeMap = new HashMap<>();
        for (Map map : list) {
            //根据日期key获取已有数据
            Map tempList = timeMap.get(map.get("time"));
            //传入数据的金额
            if (tempList == null) {
                JSONObject map1 = new JSONObject();
                map1.put("time", map.get("time"));
                map1.put("count", 1);
                timeMap.put(map.get("time"), map1);
            } else {
                JSONObject map1 = new JSONObject();
                map1.put("time", map.get("time"));
                map1.put("count", ((int) tempList.get("count")) + 1);
                timeMap.put(map.get("time"), map1);
            }
        }
        json.put("sumOrder", sumOrder);
        List<JSONObject> jsonObject = com.masspick.peak.utils.DateUtils.orderSumWeekUtils(timeMap);
        json.put("chartsData", jsonObject);
        return json;
    }


    /**
     * @param timeMap map
     * @return 数组
     */
    public static List<JSONObject> orderSumWeekUtils(Map<Object, JSONObject> timeMap) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<JSONObject> list = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            date = calendar.getTime();
            String time = sdf.format(date);
            if (timeMap.keySet().contains(time)) {
                for (Object s:timeMap.keySet()) {
                    if (time.equals(s)) {
                        list.add(timeMap.get(s));
                    }
                }
            } else {
                JSONObject json = new JSONObject();
                json.put("time", time);
                json.put("count", 0);
                list.add(json);
            }
        }
        return list;
    }



    /**
     * @param list list<map>
     * @return json数据
     */
    public static JSONObject orderAmountUtils(List<Map> list, BigDecimal sumOrder) {
        JSONObject json = new JSONObject();
        //申请金额总数
        /*分组算法**/
        Map<Object, JSONObject> timeMap = new HashMap<>();
        for (Map map : list) {
            //根据日期key获取已有数据
            Map tempList = timeMap.get(map.get("time"));
            //传入数据的金额
            BigDecimal bigd = (BigDecimal) map.get("amount");
            if (tempList == null) {
                JSONObject map1 = new JSONObject();
                map1.put("time", map.get("time"));
                map1.put("amount", bigd);
                timeMap.put(map.get("time"), map1);
            } else {
                JSONObject map1 = new JSONObject();
                map1.put("time", map.get("time"));
                map1.put("amount", bigd.add((BigDecimal) tempList.get("amount")));
                timeMap.put(map.get("time"), map1);
            }
        }
        json.put("sumApplyAmount", sumOrder.toString());
        List<JSONObject> lists = orderAmountWeekUtils(timeMap);
        json.put("chartsData", lists);
        return json;
    }

    /**
     * @param timeMap map
     * @return 数组
     */
    public static List<JSONObject> orderAmountWeekUtils(Map<Object, JSONObject> timeMap) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<JSONObject> list = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            date = calendar.getTime();
            String time = sdf.format(date);
            if (timeMap.keySet().contains(time)) {
                for (Object s:timeMap.keySet()) {
                    if (time.equals(s)) {
                        list.add(timeMap.get(s));
                    }
                }
            } else {
                JSONObject json = new JSONObject();
                json.put("time", time);
                BigDecimal di = new BigDecimal(0);
                json.put("amount", di.toString());
                list.add(json);
            }
        }
        return list;
    }


    /**
     * @param list
     * @return ss
     */
    public static JSONObject orderConsumeAmountUtils(List<Map> list, BigDecimal consumeAmounts) {
        Map<Object, Map> timeMap = new HashMap<>();
        for (Map map : list) {
            BigDecimal consumeAmount = new BigDecimal(0);
            Map tempList = timeMap.get(map.get("time"));
            if (map.containsKey("consumeAmount")) {
                consumeAmount = (BigDecimal) map.get("consumeAmount");
                if (tempList == null) {
                    Map map1 = new HashMap();
                    map1.put("time", map.get("time"));
                    map1.put("consumeAmount", consumeAmount);
                    timeMap.put(map.get("time"), map1);
                } else {
                    Map map1 = new HashMap();
                    map1.put("time", map.get("time"));
                    map1.put("consumeAmount", consumeAmount.add((BigDecimal) tempList.get("consumeAmount")));
                    timeMap.put(map.get("time"), map1);
                }
            }
        }
        JSONObject json = new JSONObject();
        json.put("sumConsumeAmount", consumeAmounts.toString());
        List<Map> lists = orderConsumeAmountWeekUtils(timeMap);
        json.put("chartsData", lists);
        return json;
    }

    /**
     * @param timeMap
     * @return ss
     */
    public static List<Map> orderConsumeAmountWeekUtils(Map<Object, Map> timeMap) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Map> list = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            date = calendar.getTime();
            String time = sdf.format(date);
            if (timeMap.keySet().contains(time)) {
                for (Object s:timeMap.keySet()) {
                    if (time.equals(s)) {
                        list.add(timeMap.get(s));
                    }
                }
            } else {
                Map map = new HashMap();
                map.put("time", time);
                map.put("consumeAmount", 0);
                list.add(map);
            }
        }
        return list;
    }

}
