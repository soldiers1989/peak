package com.masspick.peak.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * SpringContextHolder
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {

    // Spring应用上下文环境
    /**
     * applicationContext
     */
    private static ApplicationContext applicationContext;

    /**
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    /**
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取对象
     *
     * @param name
     * @return Object
     * @throws BeansException BeansException
     */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    /**
     * @param clazz
     * @return Object
     * @throws BeansException BeansException
     */
    public static Object getBean(Class clazz) throws BeansException {
        return applicationContext.getBean(clazz);
    }
}
