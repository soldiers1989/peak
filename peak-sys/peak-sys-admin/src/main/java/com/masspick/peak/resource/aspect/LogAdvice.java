package com.masspick.peak.resource.aspect;

import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.resource.anno.Log;
import com.masspick.peak.resource.entity.SysLog;
import com.masspick.peak.resource.service.ISysLogService;
import com.masspick.peak.resource.utils.HeaderUtil;
import com.masspick.peak.resource.utils.SpringContextHolder;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Date;
import java.util.UUID;

/**
 * Created by admin on 2018/8/9 0009.
 */
@Aspect
@Component
public class LogAdvice {

    /**
     * LOGGER
     */
    public static final Logger LOGGER = Logger.getLogger(LogAdvice.class);

    /**
     * controllerAspect
     */
    @Pointcut("@annotation(com.masspick.peak.resource.anno.Log)")
    public void controllerAspect() {

    }

    /**
     * httpServletRequest
     */
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * 当方法正常返回是执行
     *
     * @param joinPoint joinPoint
     */
    @AfterReturning("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        try {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method method = methodSignature.getMethod();
            Log log = method.getAnnotation(Log.class);
            if (log != null) {
                SysLog sysLog = new SysLog();
                sysLog.setId(UUID.randomUUID().toString());
                sysLog.setCreateTime(new Date());
                sysLog.setTitle(log.value());
                LOGGER.info("user name:" + httpServletRequest.getHeader(HeaderUtil.AUTH_USER));

                if (SpringContextHolder.getActiveProfile().equals("dev")) {
                    sysLog.setUserName("admin");
                } else {
                    sysLog.setUserName(URLDecoder.decode(httpServletRequest.getHeader(HeaderUtil.AUTH_USER), "UTF-8"));
                }
                sysLog.setUrl(httpServletRequest.getRequestURI().toString());
                sysLog.setMethod(httpServletRequest.getMethod());
                sysLog.setParams(JacksonUtils.toJSon(httpServletRequest.getParameterMap()));
                ISysLogService iSysLogService = (ISysLogService) SpringContextHolder.getBean(ISysLogService.class);
                iSysLogService.insert(sysLog);
            }
        } catch (Exception ex) {
            LOGGER.error("记录日志异常:", ex);
        }
    }

}
