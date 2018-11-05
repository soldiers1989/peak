package com.masspick.peak.dd.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.cas.CasSubjectFactory;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by admin on 2018/5/11 0011.
 */
@Configuration
public class ShiroConfig {

    /**
     * 路径不能改
     */
    private static final String CAS_FILTER_URL_PATTERN = "/shiro-cas";


    /**
     * 实例化SecurityManager，该类是shiro的核心类
     *
     * @param casServerUrlPrefix
     * @param shiroServerUrlPrefix
     * @param myShiroRealm
     * @return DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Value("${shiro.cas}") String casServerUrlPrefix,
                                                                  @Value("${shiro.server}") String
                                                                          shiroServerUrlPrefix, MyShiroRealm
                                                                          myShiroRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm);
        securityManager.setSubjectFactory(new CasSubjectFactory());
        return securityManager;
    }

    /**
     * @param casServerUrlPrefix
     * @param shiroServerUrlPrefix
     * @return MyShiroRealm
     */
    @Bean
    public MyShiroRealm getShiroRealm(@Value("${shiro.cas}") String casServerUrlPrefix,
                                      @Value("${shiro.server}") String shiroServerUrlPrefix) {
        //将MyRealm改成你自己的类,其他不动
        MyShiroRealm casRealm = new MyShiroRealm();
        casRealm.setCachingEnabled(true);
        casRealm.setCasServerUrlPrefix(casServerUrlPrefix);
        casRealm.setCasService(shiroServerUrlPrefix + CAS_FILTER_URL_PATTERN);
        casRealm.setCacheManager(getEhCacheManager());
        return casRealm;
    }

    /**
     * 配置缓存
     *
     * @return EhCacheManager
     */
    @Bean
    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:xml/ehcache-shiro.xml");
        return em;
    }




    /**
     * 注册单点登出的listener
     *
     * @return ServletListenerRegistrationBean<?>
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public ServletListenerRegistrationBean<?> singleSignOutHttpSessionListener() {

        // 优先级需要高于Cas的Filter
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean();
        bean.setListener(new SingleSignOutHttpSessionListener());
        bean.setEnabled(true);
        return bean;
    }


    /**
     * 注册单点登出filter
     *
     * @return FilterRegistrationBean
     */
    @Bean(name = "singleSignOutFilter")
    public FilterRegistrationBean singleSignOutFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setName("singleSignOutFilter");
        bean.setFilter(new SingleSignOutFilter());
        bean.addUrlPatterns("/*");
        bean.setEnabled(true);
        return bean;
    }


    /**
     * 注册DelegatingFilterProxy（Shiro）
     *
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean delegatingFilterProxy() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        filterRegistration.addInitParameter("targetFilterLifecycle", "true");
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*");
        return filterRegistration;
    }

    /**
     * 下面两个配置主要用来开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持;
     *
     * @return LifecycleBeanPostProcessor
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;  加入该bean然后再加上注解@RequiresPermissions("userInfo:add")//权限管理;，权限管理才能生效
     *
     * @return DefaultAdvisorAutoProxyCreator
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    /**
     * 开启shiro aop注解支持.
     * 权限管理;，权限管理才能生效
     * 使用代理方式;所以需要开启代码支持;  加入该bean然后再加上注解@RequiresPermissions("userInfo:add")
     *
     * @param securityManager
     * @return AuthorizationAttributeSourceAdvisor
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(
            DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new
                AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


    //按你业务修改
    //anon表示不过滤
    //casFilter自定义过滤器:验证成功跳转地址/验证失败跳转地址
    //logout:自定义过滤器:过滤单点登录退出请求
    private void loadShiroFilterChain(ShiroFilterFactoryBean shiroFilterFactoryBean) {
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//        filterChainDefinitionMap.put("logout", "singleSignOutFilter");
        //你需要CAS校验的请求
        filterChainDefinitionMap.put(CAS_FILTER_URL_PATTERN, "casFilter");
        //你需要CAS校验的请求
        filterChainDefinitionMap.put("/login", "authc");
        //你需要CAS校验的请求
        filterChainDefinitionMap.put("/user/*", "authc");
        //不需要拦截的静态文件请求
        filterChainDefinitionMap.put("/static/**", "anon");
        //单点登录退出请求拦截
        filterChainDefinitionMap.put("/logout", "logoutFilter");
        //不过滤其他业务系统请求
        filterChainDefinitionMap.put("/templates/*", "anon");
        //不过滤其他业务系统请求
        filterChainDefinitionMap.put("/task/resultInfo", "anon");
        //不过滤其他业务系统请求
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    }


    /**
     * 定义 CAS Filter
     * @param casServerUrlPrefix
     * @param shiroServerUrlPrefix
     * @return CasFilter
     */
    @Bean(name = "casFilter")
    public CasFilter getCasFilter(@Value("${shiro.cas}") String casServerUrlPrefix,
                                  @Value("${shiro.server}") String shiroServerUrlPrefix) {
        CasFilter casFilter = new CasFilter();
        casFilter.setName("casFilter");
        casFilter.setEnabled(true);
        //校验失败地址，这里失败继续重定向单点登录界面//!!!!验证失败并没有跳转
        String failUrl = casServerUrlPrefix + "/login?service=" + shiroServerUrlPrefix + CAS_FILTER_URL_PATTERN;
        //校验成功地址，登录成功后重定向的地址
        String successUrl = shiroServerUrlPrefix + "/index";
        casFilter.setFailureUrl(failUrl);
        casFilter.setSuccessUrl(successUrl);
        return casFilter;
    }

    /**
     * @param securityManager
     * @param casFilter
     * @param casServerUrlPrefix
     * @param shiroServerUrlPrefix
     * @return ShiroFilterFactoryBean
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager, CasFilter
            casFilter, @Value("${shiro.cas}") String casServerUrlPrefix, @Value("${shiro.server}") String
                                                                    shiroServerUrlPrefix) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        String loginUrl = casServerUrlPrefix + "/login?service=" + shiroServerUrlPrefix + CAS_FILTER_URL_PATTERN;
        shiroFilterFactoryBean.setLoginUrl(loginUrl);
        shiroFilterFactoryBean.setSuccessUrl("/");
        Map<String, Filter> filters = new HashMap<>();
        filters.put("casFilter", casFilter);

        LogoutFilter logoutFilter = new LogoutFilter();
        ///logout过滤后重定向到下面的路径
        logoutFilter.setRedirectUrl(casServerUrlPrefix + "/logout?service=" + shiroServerUrlPrefix);
        filters.put("logoutFilter", logoutFilter);

        shiroFilterFactoryBean.setFilters(filters);
        loadShiroFilterChain(shiroFilterFactoryBean);
        return shiroFilterFactoryBean;
    }

    /**
     *
     * @return ShiroDialect
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
