package com.masspick.peak.jwt.filter;

import com.masspick.peak.common.util.StringHelper;
import com.masspick.peak.jwt.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by admin on 2018/6/8 0008.
 */
public class AuthenticationTokenFilter extends GenericFilterBean {

    /**
     * 携带Token的HTTP头
     */
    public static final String TOKEN_HEADER = "Authorization";

    /**
     * Token工具类
     */
    @Autowired
    private TokenUtil jwtTokenUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authHeader = httpRequest.getHeader(TOKEN_HEADER);

        if (authHeader == null || !authHeader.startsWith(TokenUtil.TOKEN_TYPE_BEARER)) {
            chain.doFilter(request, response);
            return;
        }

        //这里对Header的传来的数据进行校验 不规范 打算换成CAS校验模式

        final String authToken = StringHelper.substring(authHeader, 7);
        String username = StringHelper.isNotBlank(authToken) ? jwtTokenUtil.getUsernameFromToken(authToken) : null;

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null && jwtTokenUtil.validateToken(authToken)) {
            UserDetails userDetails = (UserDetails) jwtTokenUtil.getUserDetails(authToken);
            UsernamePasswordAuthenticationToken authentication
                    = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }
}
