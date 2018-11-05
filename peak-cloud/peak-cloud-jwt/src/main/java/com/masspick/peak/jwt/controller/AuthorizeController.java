package com.masspick.peak.jwt.controller;

import com.masspick.peak.common.util.ApiResponse;
import com.masspick.peak.jwt.controller.vo.UserVO;
import com.masspick.peak.jwt.filter.AuthenticationTokenFilter;
import com.masspick.peak.jwt.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 与用户登陆授权有关的接口访问
 */
@RestController
@RequestMapping(value = "/auth")
public class AuthorizeController {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizeController.class);

    /**
     * tokenUtil
     */
    @Autowired
    private TokenUtil tokenUtil;

    /**
     * authenticationManager
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * @param userVO
     * @return ApiResponse
     */
    @PostMapping(value = "/login")
    public ApiResponse createAuthenticationToken(@RequestBody UserVO userVO) {

        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userVO.getLoginName(), userVO.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        final String token = tokenUtil.generateToken(userDetails, userVO.getRememberMe());
        ApiResponse apiResponse = ApiResponse.getInstances();

        // Return the token
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("type", TokenUtil.TOKEN_TYPE_BEARER);
        tokenMap.put("expires", tokenUtil.getExpiration());
        apiResponse.success();
        apiResponse.setResult(tokenMap);
        return apiResponse;
    }

    /**
     * @param request
     * @return ApiResponse
     */
    @DeleteMapping
    public ApiResponse deleteAuth(HttpServletRequest request) {
        String tokenHeader = request.getHeader(AuthenticationTokenFilter.TOKEN_HEADER);
        String token = tokenHeader.split(" ")[1];
        tokenUtil.removeToken(token);

        ApiResponse apiResponse = ApiResponse.getInstances();
        apiResponse.success();
        return apiResponse;
    }
}
