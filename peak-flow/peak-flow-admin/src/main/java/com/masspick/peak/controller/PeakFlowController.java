package com.masspick.peak.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.masspick.peak.common.ExcelUtils;
import com.masspick.peak.common.Page;
import com.masspick.peak.common.model.Result;
import com.masspick.peak.common.util.HeaderUtil;
import com.masspick.peak.model.dto.ApiResponse;
import com.masspick.peak.model.dto.DdDataControlDTO;
import com.masspick.peak.service.FlowService;
import com.masspick.peak.service.PushProjectApi;
import com.masspick.peak.utils.ThreeReportUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * PeakFlowController
 */
@CrossOrigin
@RestController
@RequestMapping("v1/flow")
public class PeakFlowController {
    /**
     * flowService
     */
    @Autowired
    private FlowService flowService;

    /**
     * request
     */
    @Autowired
    private HttpServletRequest request;

    /**
     * response
     */
    @Autowired
    private HttpServletResponse response;

    /**
     * pushProjectApi
     */
    @Resource
    private PushProjectApi pushProjectApi;

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PeakFlowController.class);

    /**
     * BYTE_SIZE
     */
    private static final int BYTE_SIZE = 512;


    /**
     * 开启流程
     *
     * @param map
     * @return Result
     * @throws Exception Exception
     */
    @RequestMapping("process")
    public Result start(@RequestBody Map<String, String> map) throws Exception {
        try {
            String userName = URLDecoder.decode(request.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
            map.put("userId", userName);
        } catch (Exception e) {
            return new Result("200", "success", "开启流程失败,尴尬了!");
        }

        return new Result("200", "success", flowService.startProcess(map));
    }


    /**
     * 执行待办任务
     *
     * @return Result
     */
    @PostMapping("task/{taskId}")
    public Result complete(@PathVariable("taskId") String taskId, @RequestBody Map<String, Object> map) {
        try {
            if (map.isEmpty()) {
                return new Result("500", "success", "所传参数为空");
            }

            if (map.get("userId") == null || StringUtils.isEmpty(map.get("userId").toString())) {
                String userName = URLDecoder.decode(request.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
                map.put("userId", userName);
            }

            return new Result("200", "success", flowService.completeTaskAdmin(taskId, map));
        } catch (Exception e) {
            return new Result("500", "success", e.getMessage());
        }
    }


    /**
     * 待办任务
     *
     * @param productName
     * @return Result
     */
    @GetMapping("task/{productName}")
    public Result todo(@PathVariable("productName") String productName) {
        try {
            String userName = URLDecoder.decode(request.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
            return new Result("200", "success", flowService.findTaskTodoListByUserName(userName, productName));
        } catch (Exception e) {
            return new Result("200", "success", e.getMessage());
        }

    }


    /**
     * 动态生成流程图
     *
     * @param processInstanceId
     * @return Result
     */
    @RequestMapping("process/{processInstanceId}/map")
    public Result proMap(@PathVariable("processInstanceId") String processInstanceId) {
        try {
            return new Result("200", "success", flowService.proMap(processInstanceId));
        } catch (Exception e) {
            return new Result("500", "error", "导出图片异常");
        }
    }

    /**
     * 获取基本信息
     *
     * @param processInstanceId
     * @return Result
     */
    @RequestMapping("process/{processInstanceId}/variables")
    public Result basic(@PathVariable("processInstanceId") String processInstanceId) {
        return new Result("200", "success", flowService.basic(processInstanceId));
    }


    /**
     * 查询表单
     *
     * @param taskId
     * @return Result
     * @throws Exception Exception
     */
    @RequestMapping("task/{taskId}/variables")
    public Result formProperties(@PathVariable("taskId") String taskId) throws Exception {
        return new Result("200", "success", flowService.findFormPropertiesByTaskId(taskId));
    }


    /**
     * 已办任务列表
     *
     * @param assignee
     * @return Result
     */
    @RequestMapping("historic-task")
    public Result historicTask(@RequestParam(value = "assignee", required = false) String assignee,
                               @RequestParam(value = "etpName", required = false) String etpName,
                               @RequestParam(value = "createStartDate", required = false) String createStartDate,
                               @RequestParam(value = "createEndDate", required = false) String createEndDate,
                               @RequestParam(value = "productName", required = false) String productName
    ) {
        try {
            if (StringUtils.isEmpty(assignee)) {
                String userName = URLDecoder.decode(request.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
                assignee = userName;
            }
            return new Result("200", "success",
                    flowService.historicTaskByAssignee(new Page<>(request, response),
                            assignee, etpName, createStartDate, createEndDate, productName));
        } catch (Exception e) {
            return new Result("200", "success", e.getMessage());
        }

    }

    /**
     * 已办任务节点列表
     *
     * @param processInstanceId
     * @return Result
     */
    @RequestMapping("historic-task/detail")
    public Result historicTaskList(@RequestParam(value = "processInstanceId", required = true
    ) String processInstanceId) {
        return new Result("200", "success", flowService.historicTaskDetail(processInstanceId));
    }


    /**
     * 详细列表中查看具体数据
     *
     * @param taskId
     * @return Result
     * @throws Exception Exception
     */
    @RequestMapping("historic-task/{taskId}")
    public Result historicForm(@PathVariable(value = "taskId") String taskId) throws Exception {
        return new Result("200", "success", flowService.findHistoricForm(taskId));
    }

    /**
     * 校验当前用户是否属于风控后台
     *
     * @return Result
     */
    @RequestMapping("financ")
    public Result financ() {
        try {
            String userName = URLDecoder.decode(request.getHeader(HeaderUtil.AUTH_USER), "UTF-8");
            return new Result("200", "success", flowService.rolesByName(userName));
        } catch (Exception e) {
            return new Result("400", "success", "获取登录信息失败");
        }
    }


    /**
     * @param processInstanceId
     * @param request
     * @param response
     * @throws Exception Exception
     */
    @RequestMapping("ddTask/{processInstanceId}")
    public void exportDdTaskExcel(@PathVariable("processInstanceId") String processInstanceId,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception {
        //查询流程数据
        Map<String, Object> map = flowService.exportdDMapByProId(processInstanceId);
        File file = null;
        InputStream inputStream = null;
        ServletOutputStream out = null;
        try {
            request.setCharacterEncoding("UTF-8");
            file = ExcelUtils.createExcel(this.getClass(), map, "myExcel", "ddTask.ftl"); //调用创建excel帮助类
            inputStream = new FileInputStream(file);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/msexcel");
            response.setHeader("content-disposition", "attachment;filename="
                    + URLEncoder.encode("尽调审批表" + ".xls", "UTF-8"));
            out = response.getOutputStream();
            byte[] buffer = new byte[BYTE_SIZE]; // 缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Excel文件的内容输出到浏览器中
            while ((bytesToRead = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
            out.flush();
        } catch (Exception e) {
            LOGGER.error("导出失败", e.getCause());
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }

            if (out != null) {
                out.close();
            }

            if (file != null) {
                file.delete();
            }
        }
    }


    /**
     * @param processInstanceId
     * @param request
     * @param response
     * @throws Exception Exception
     */
    @RequestMapping("register/{processInstanceId}")
    public void exportRegisterTaskExcel(@PathVariable("processInstanceId") String processInstanceId,
                                        HttpServletRequest request, HttpServletResponse response) throws Exception {
        //查询流程数据
        Map<String, Object> map = flowService.exportMapByTaskId(processInstanceId);
        File file = null;
        InputStream inputStream = null;
        ServletOutputStream out = null;
        try {
            request.setCharacterEncoding("UTF-8");
            file = ExcelUtils.createExcel(this.getClass(), map, "myExcel", "register.ftl"); //调用创建excel帮助类
            inputStream = new FileInputStream(file);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/msexcel");
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("融资登记信息报告" + ".xls", "UTF-8"));
            out = response.getOutputStream();
            byte[] buffer = new byte[BYTE_SIZE]; // 缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Excel文件的内容输出到浏览器中
            while ((bytesToRead = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
            out.flush();
        } catch (Exception e) {
            LOGGER.error("导出失败", e.getCause());
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }

            if (out != null) {
                out.close();
            }

            if (file != null) {
                file.delete();
            }
            // 删除临时文件
        }
    }


    /**
     * 完成其他平台任务
     *
     * @param map
     * @return ApiResponse
     * @throws Exception Exception
     */
    @PostMapping("task/complete")
    public ApiResponse completeTask(@RequestBody Map<String, String> map) throws Exception {
        return pushProjectApi.completeTask(map);
    }


    /**
     * 流程中找到贷款详细信息
     * @param flowId flowId
     * @return ApiResponse
     * @throws Exception Exception
     */
    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods={RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE, RequestMethod.OPTIONS,
            RequestMethod.HEAD, RequestMethod.PUT, RequestMethod.PATCH}, origins="*")
    @GetMapping("loanDetail/{flowId}")
    public ApiResponse findLoanDetailByFlowId(@PathVariable("flowId") String flowId) throws Exception {
        return flowService.findLoanDetailByFlowId(flowId);
    }

    /**
     * H5端首页数据
     *
     * @param assignee
     * @param productName
     * @return Result
     * @throws Exception Exception
     */
    @GetMapping("index")
    public Result indexData(@RequestParam int interfaceid, @RequestParam String assignee, @RequestParam String productName) throws Exception {
        int past = 7;
        Date dNow = new Date();   //当前时间
        Date dBefore = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow); //把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -past);  //设置为前一天
        dBefore = calendar.getTime();   //得到前一天的时间
        Calendar calendar1 = Calendar.getInstance(); //得到日历
        calendar1.setTime(dNow); //把当前时间赋给日历
        calendar1.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
        dNow = calendar1.getTime();   //得到前一天的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
        String createStartDate = sdf.format(dBefore);    //格式化过去第七天的日期。
        String createEndDate = sdf.format(dNow); //格式化当前时间
        return new Result("200", "success",
                flowService.historicTaskByAssigneeList(interfaceid, assignee, createStartDate, createEndDate, productName));
    }


    /**
     * 三大报告之客户信息报告
     *
     * @param
     * @return String
     * @throws Exception Exception
     */
    @RequestMapping("customer/{processInstanceId}")
    public Result customer(@PathVariable("processInstanceId") String processInstanceId) throws Exception {
        try {
            String jsonStr = flowService.fieldTemplate("1");
            if (jsonStr == null || jsonStr.isEmpty()) {
                return new Result("200", "success", "未配置客户信息报告模板！");
            }
            //处理进件信息
            Map allInfo = flowService.intoData(processInstanceId);
            if (allInfo == null || allInfo.isEmpty()) {
                return new Result("200", "success", "未查询到该流程信息！");
            }
            Map etpMap = new HashMap();
            if (allInfo.containsKey("etp") && allInfo.get("etp") != null) {
                //处理企业征信信息（etp）
                JSONObject etpInfo = JSONObject.parseObject(allInfo.get("etp").toString());
                etpMap = ThreeReportUtils.etpUtils(etpInfo);
            }
            Map selfMap = new HashMap();
            if (allInfo.containsKey("self") && allInfo.get("self") != null) {
                //处理实际控制人征信情况（self）
                JSONObject selfInfo = JSONObject.parseObject(allInfo.get("self").toString());
                selfMap = ThreeReportUtils.selfUtils(selfInfo);
            }
            allInfo.putAll(etpMap);
            allInfo.putAll(selfMap);
            if (allInfo == null || allInfo.isEmpty()) {
                return new Result("200", "success", "未获取到客户信息报告的任何信息！");
            }
            //处理数据格式
            List<Map> list = flowService.fieldInfo();
            int c1 = 0;
            JSONArray jsonArray = JSONArray.parseArray(jsonStr);
            for (Object js : jsonArray) {
                JSONObject child1 = JSON.parseObject(String.valueOf(js));
                JSONArray childArray1 = (JSONArray) child1.get("child");
                int c2 = 0;
                for (Object js1 : childArray1) {
                    JSONObject child2 = JSON.parseObject(String.valueOf(js1));
                    JSONArray childArray2 = (JSONArray) child2.get("child");
                    int c3 = 0;
                    for (Object js2 : childArray2) {
                        JSONObject child3 = JSON.parseObject(String.valueOf(js2));
                        Object key = child3.get("key");
                        for (Map map : list) {
                            if (map.get("businesskey").equals(key)) {
                                child3.put("value", allInfo.get(map.get("dbkey")));
//                                child3.put("name", map.get("name"));
                            }
                        }
                        childArray2.set(c3, child3);
                        c3++;
                    }
                    child2.put("child", childArray2);
                    childArray1.set(c2, child2);
                    c2++;
                }
                child1.put("child", childArray1);
                jsonArray.set(c1, child1);
                c1++;
            }
            String s = jsonArray.toString();
            return new Result("200", "success", jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("400", "success", "客户信息报告获取失败！");
        }
    }

    /**
     * 三大报告之信息采集报告
     *
     * @param
     * @return String
     * @throws Exception Exception
     */
    @RequestMapping("collection/{processInstanceId}")
    public Result dataCollection(@PathVariable("processInstanceId") String processInstanceId) throws Exception {
        try {
            String jsonStr = flowService.fieldTemplate("2");
            List<DdDataControlDTO> ld = new ArrayList<>(); //所有字段信息汇总
            if (jsonStr == null || jsonStr.isEmpty()) {
                return new Result("200", "success", "未配置客户信息报告模板！");
            }
            //获取进件信息
            Map allInfo = flowService.intoData(processInstanceId);
            if (allInfo == null || allInfo.isEmpty()) {
                return new Result("200", "success", "未查询到该流程进件信息！");
            }
            if (allInfo.containsKey("etp") && allInfo.get("etp") != null) {
                //获取征信报告时间字段值
                JSONObject etpInfo = JSONObject.parseObject(allInfo.get("etp").toString());
                allInfo.put("reportDate", etpInfo.get("reportDate"));
            }
            if (allInfo.keySet().contains("guarantMode")) {
                allInfo.remove("guarantMode");
            }
            if (allInfo.keySet().contains("ratingResult")) {
                allInfo.remove("ratingResult");
            }
            //获取尽调数据
            Map mapdd = flowService.taskData(processInstanceId);
            if (mapdd.keySet().contains("businessReportDepartment")) {
                System.out.println("-------");
            }

            if (mapdd.keySet().contains("guarantMode")) {
                String value = mapdd.get("guarantMode").toString();
                switch (value) {
                    case "theFirstGuarante":
                        value = "I类担保";
                        break;
                    case "theSecondGuarante":
                        value = "II类担保";
                        break;
                    case "theThirdGuarante":
                        value = "III类担保";
                        break;
                    case "theForthGuarante":
                        value = "IV类担保";
                        break;
                    default:
                        break;
                }
                mapdd.put("guarantMode", value);
            }
            //获取数据字段数据
            List<Map> list = flowService.fieldInfo();
            //汇总字段数据
            for (Map map : list) {
                DdDataControlDTO dd = new DdDataControlDTO();
                if (map.get("dbkey").equals("loanRate") || map.get("dbkey").equals("borrowRate")) {
                    System.out.println("111");
                } else {
                    if (allInfo.containsKey(map.get("dbkey"))) {
                        dd.setLabel(String.valueOf(map.get("name")));
                        dd.setControlKey(String.valueOf(map.get("businesskey")));
                        dd.setValue(String.valueOf(allInfo.get(map.get("dbkey"))));
                        ld.add(dd);
                    } else if (mapdd.containsKey(map.get("dbkey"))) {
                        dd.setLabel(String.valueOf(map.get("name")));
                        dd.setControlKey(String.valueOf(map.get("businesskey")));
                        dd.setValue(String.valueOf(mapdd.get(map.get("dbkey"))));
                        ld.add(dd);
                    } else {
                        dd.setLabel(String.valueOf(map.get("name")));
                        dd.setControlKey(String.valueOf(map.get("businesskey")));
                        dd.setValue("");
                        ld.add(dd);
                    }
                }
            }
            int c1 = 0;
            JSONArray jsonArray = JSONArray.parseArray(jsonStr);
            for (Object js : jsonArray) {
                JSONObject child1 = JSON.parseObject(String.valueOf(js));
                JSONArray childArray1 = (JSONArray) child1.get("child");
                int c2 = 0;
                for (Object js1 : childArray1) {
                    JSONObject child2 = JSON.parseObject(String.valueOf(js1));
                    JSONArray childArray2 = (JSONArray) child2.get("child");
                    int c3 = 0;
                    for (Object js2 : childArray2) {
                        JSONObject child3 = JSON.parseObject(String.valueOf(js2));
                        Object key = child3.get("key");
                        for (DdDataControlDTO dct : ld) {
                            if (dct.getControlKey().equals(key)) {
                                child3.put("value", dct.getValue());
//                                child3.put("name", dct.getLabel());
                            }
                        }
                        childArray2.set(c3, child3);
                        c3++;
                    }
                    child2.put("child", childArray2);
                    childArray1.set(c2, child2);
                    c2++;
                }
                child1.put("child", childArray1);
                jsonArray.set(c1, child1);
                c1++;
            }
            String s = jsonArray.toString();
            return new Result("200", "success", jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result("400", "success", "客户信息报告获取失败！");
        }
    }

    /**
     * 综合审批报告
     *
     * @param
     * @return String
     * @throws Exception Exception
     */
    @GetMapping("comprehensive/{processInstanceId}")
    public Result comprehensive(@PathVariable("processInstanceId") String processInstanceId) throws Exception {

        String jsonStr = flowService.fieldTemplate("3");
        if (jsonStr == null || jsonStr.isEmpty()) {
            return new Result("200", "success", "未配置客户信息报告模板！");
        }
        //获取进件信息
        Map allInfo = flowService.intoData(processInstanceId);
        if (allInfo == null || allInfo.isEmpty()) {
            return new Result("200", "success", "未查询到该流程进件信息！");
        }
        //获取征信拆解信息
        Map etpMap = new HashMap();
        if (allInfo.containsKey("etp") && allInfo.get("etp") != null) {
            //处理企业征信信息（etp）
            JSONObject etpInfo = JSONObject.parseObject(allInfo.get("etp").toString());
            etpMap = ThreeReportUtils.etpUtils(etpInfo);
        }
        Map selfMap = new HashMap();
        if (allInfo.containsKey("self") && allInfo.get("self") != null) {
            //处理实际控制人征信情况（self）
            JSONObject selfInfo = JSONObject.parseObject(allInfo.get("self").toString());
            selfMap = ThreeReportUtils.selfUtils(selfInfo);
        }
        allInfo.putAll(etpMap);
        allInfo.putAll(selfMap);
        if (allInfo.keySet().contains("guarantMode")) {
            allInfo.remove("guarantMode");
        }
        if (allInfo.keySet().contains("ratingResult")) {
            allInfo.remove("ratingResult");
        }
        List<DdDataControlDTO> ld = new ArrayList<>();
        //获取尽调数据
        Map mapdd = flowService.taskData(processInstanceId);
        if (mapdd.keySet().contains("ratingResult")) {
            mapdd.remove("ratingResult");
        }
        if (mapdd.keySet().contains("guarantMode")) {
            String value = mapdd.get("guarantMode").toString();
            switch (value) {
                case "theFirstGuarante":
                    value = "I类担保";
                    break;
                case "theSecondGuarante":
                    value = "II类担保";
                    break;
                case "theThirdGuarante":
                    value = "III类担保";
                    break;
                case "theForthGuarante":
                    value = "IV类担保";
                    break;
                default:
                    break;
            }
            mapdd.put("guarantMode", value);
        }
        //获取流程节点(loanApprover)的数据
        Map<String, Object> mappro = flowService.processData(processInstanceId);
        allInfo.put("wetherMatchDisclosureProgram", "不符合");
        if (allInfo.keySet().contains("amount") && allInfo.keySet().contains("term")) {
            if (mappro.keySet().contains("finalLoanTerm") && mappro.keySet().contains("finalLoanAmount")) {
                if (allInfo.get("amount").equals(mappro.get("finalLoanAmount")) && allInfo.get("finalLoanTerm").equals(mappro.get("finalLoanTerm"))) {
                    allInfo.put("wetherMatchDisclosureProgram", "符合");
                }
            }
        }
        allInfo.putAll(mappro);
        //获取字段数据
        List<Map> list = flowService.fieldInfo();
        //汇总字段数据
        for (Map map : list) {
            DdDataControlDTO dd = new DdDataControlDTO();
            if (allInfo.containsKey(map.get("dbkey"))) {
                dd.setLabel(String.valueOf(map.get("name")));
                dd.setControlKey(String.valueOf(map.get("businesskey")));
                dd.setValue(String.valueOf(allInfo.get(map.get("dbkey"))));
                ld.add(dd);
            } else if (mapdd.containsKey(map.get("dbkey"))) {
                dd.setLabel(String.valueOf(map.get("name")));
                dd.setControlKey(String.valueOf(map.get("businesskey")));
                dd.setValue(String.valueOf(mapdd.get(map.get("dbkey"))));
                ld.add(dd);
            } else {
                dd.setLabel(String.valueOf(map.get("name")));
                dd.setControlKey(String.valueOf(map.get("businesskey")));
                dd.setValue("");
                ld.add(dd);
            }
        }
        int c1 = 0;
        JSONArray jsonArray = JSONArray.parseArray(jsonStr);
        for (Object js : jsonArray) {
            JSONObject child1 = JSON.parseObject(String.valueOf(js));
            JSONArray childArray1 = (JSONArray) child1.get("child");
            int c2 = 0;
            for (Object js1 : childArray1) {
                JSONObject child2 = JSON.parseObject(String.valueOf(js1));
                JSONArray childArray2 = (JSONArray) child2.get("child");
                int c3 = 0;
                for (Object js2 : childArray2) {
                    JSONObject child3 = JSON.parseObject(String.valueOf(js2));
                    Object key = child3.get("key");
                    for (DdDataControlDTO dct : ld) {
                        if (dct.getControlKey().equals(key)) {
                            child3.put("value", dct.getValue());
//                            child3.put("name", dct.getLabel());
                        }
                    }
                    childArray2.set(c3, child3);
                    c3++;
                }
                child2.put("child", childArray2);
                childArray1.set(c2, child2);
                c2++;
            }
            child1.put("child", childArray1);
            jsonArray.set(c1, child1);
            c1++;
        }
        String s = jsonArray.toString();
        return new Result("200", "success", jsonArray);
    }
}
