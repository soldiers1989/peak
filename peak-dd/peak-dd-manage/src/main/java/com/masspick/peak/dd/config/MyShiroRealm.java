package com.masspick.peak.dd.config;

import com.fasterxml.jackson.databind.JavaType;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.dd.dto.SysAppDTO;
import com.masspick.peak.dd.dto.SysUserDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by admin on 2018/5/11 0011.
 */
public class MyShiroRealm extends CasRealm {


    /**
     * systemConfig
     */
    @Autowired
    private SystemConfig systemConfig;

    /**
     * 日志.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MyShiroRealm.class);

    /**
     * roles
     */
    private final Map<String, SimpleAuthorizationInfo> roles = new ConcurrentHashMap();


    /**
     * 设置角色和权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String account = (String) principals.getPrimaryPrincipal();
        String buildUrl = systemConfig.getZuulUrl() + "/peak-resource/v1/resource/users/" + account;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SysUserDTO> responseEntity = restTemplate.getForEntity(buildUrl, SysUserDTO.class);
        SysUserDTO sysUser = responseEntity.getBody();
        SimpleAuthorizationInfo authorizationInfo = null;
        if (sysUser != null) {
            String permissionUrl = systemConfig.getZuulUrl() + "/peak-resource/api/resource/user/dd/permission?account="
                    + account + "&appId=" + systemConfig.getAppId();
            ResponseEntity<List> permissionEntity = restTemplate.getForEntity(permissionUrl, List.class);
            List<Map<String, Object>> permissionDTOS = permissionEntity.getBody();
            Set<String> set = new HashSet<String>();

            for (Map<String, Object> sysPermissionDTO : permissionDTOS) {
                set.add((String) sysPermissionDTO.get("resourceName"));
            }
            authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.setStringPermissions(set);
            SecurityUtils.getSubject().getSession().setAttribute("permission", set);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add("AUTH_ID", systemConfig.getAppId());
            requestHeaders.add("AUTH_USER", account);
            HttpEntity<String> requestEntity = new HttpEntity<String>(null, requestHeaders);
            String appUrl = systemConfig.getZuulUrl() + "/peak-resource/v1/resource/apps/permission";
            ResponseEntity<Map> response = restTemplate.exchange(appUrl, HttpMethod.GET, requestEntity, Map.class);
            Map<String, Object> permissionMap = response.getBody();
            Object object = permissionMap.get("result");
            String appString = JacksonUtils.toJSon(object);
            JavaType javaType = JacksonUtils.toJavaType(List.class, SysAppDTO.class);
            List<SysAppDTO> sysAppDTOs = JacksonUtils.readValue(appString, javaType);
            SecurityUtils.getSubject().getSession().setAttribute("sysApps", sysAppDTOs);
            return authorizationInfo;
        }
        return authorizationInfo;
    }


    /**
     * 1、CAS认证 ,验证用户身份
     * 2、将用户基本信息设置到会话中
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {

        LOGGER.error("cas_url :" + systemConfig.getCasServerUrlPrefix());
        LOGGER.error("casService :" + this.getCasService());
        LOGGER.error("token :" + token);
        AuthenticationInfo authc = null;
        String account = null;
        try {
            authc = super.doGetAuthenticationInfo(token);
            account = (String) authc.getPrincipals().getPrimaryPrincipal();
            LOGGER.info("account 111:" + account);
        } catch (Exception e) {
            LOGGER.error("error message :", e);
            account = "admin";
        }
        // 调用父类中的认证方法，CasRealm已经为我们实现了单点认证。
        LOGGER.info("account 222:" + account);
        // 获取登录的账号，cas认证成功后，会将账号存起来
        account = (String) authc.getPrincipals().getPrimaryPrincipal();
        String buildUrl = systemConfig.getZuulUrl() + "/peak-resource/v1/resource/users/" + account;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SysUserDTO> responseEntity = restTemplate.getForEntity(buildUrl, SysUserDTO.class);
        SysUserDTO sysUser = responseEntity.getBody();
        // 将用户信息存入session中,方便程序获取,此处可以将根据登录账号查询出的用户信息放到session中
        SecurityUtils.getSubject().getSession().setAttribute("user", sysUser);
        return authc;
    }
}
