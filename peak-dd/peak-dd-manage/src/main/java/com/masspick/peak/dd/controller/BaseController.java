package com.masspick.peak.dd.controller;

import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.dd.controller.vo.Result;
import com.masspick.peak.dd.util.StringEscapeEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2018/5/17 0017.
 */
public abstract class BaseController {

    /**
     * 日志.
     */
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * reponse注入.
     */
    @Autowired
    private HttpServletResponse response;
    /**
     * Request注入.
     */
    @Autowired
    private HttpServletRequest request;


    /**
     * 初始化initBinder.
     *
     * @param binder
     * @Title: initBinder
     */
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        /**
         * 自动转换日期类型的字段格式
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));

        /**
         * 防止XSS攻击
         */
        binder.registerCustomEditor(String.class, new StringEscapeEditor(true,
                false));
    }

    /**
     * ajax失败.
     *
     * @param msg 失败的消息
     * @return {Object}
     */
    public Object renderError(String msg) {
        Result result = new Result();
        result.setMsg(msg);
        return result;
    }

    /**
     * ajax成功.
     *
     * @return {Object}
     */
    public Object renderSuccess() {
        Result result = new Result();
        result.setSuccess(true);
        return result;
    }

    /**
     * ajax成功.
     *
     * @param msg 消息
     * @return {Object}
     */
    public Object renderSuccess(String msg) {
        Result result = new Result();
        result.setSuccess(true);
        result.setMsg(msg);
        return result;
    }

    /**
     * ajax成功.
     *
     * @param obj 成功时的对象
     * @return {Object}
     */
    public Object renderSuccess(Object obj) {
        Result result = new Result();
        result.setSuccess(true);
        result.setObj(obj);
        return result;
    }

    /**
     * json返回.
     *
     * @param str
     */
    public void renderJsonJStr(String str) {
        PrintWriter out;
        try {
            out = response.getWriter();
            out.println(str);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * JsonObject返回.
     *
     * @param obj
     */
    public void renderJsonJObject(Object obj) {
        String jsom = JacksonUtils.toJSon(obj);
        response.setCharacterEncoding("utf-8");
        PrintWriter out;
        try {
            out = response.getWriter();
            out.println(jsom);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
