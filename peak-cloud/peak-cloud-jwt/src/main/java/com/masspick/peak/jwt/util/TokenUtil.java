package com.masspick.peak.jwt.util;

import com.masspick.peak.common.util.AbstractTokenUtil;
import com.masspick.peak.common.util.JacksonUtils;
import com.masspick.peak.jwt.user.AuthUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2018/5/22 0022.
 */
@Configuration
@Component
public class TokenUtil extends AbstractTokenUtil {

    /**
     * 生成 Token
     *
     * @return String
     */
    @Override
    public String generateToken(Object object, Boolean rememberMe) {
        UserDetails userDetails = (UserDetails) object;
        if (rememberMe) {
            setExpiration(getMaxExpiration());
        } else {
            setExpiration(getMinExpiration());
        }
        String token = Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setExpiration(generateExpired())
                .signWith(SignatureAlgorithm.HS512, getSecret())
                .compact();
        String key = REDIS_PREFIX_AUTH + userDetails.getUsername();
        getRedisRepository().setExpire(key, token, getExpiration());
        putUserDetails(userDetails);
        return token;
    }

    @Override
    public void putUserDetails(Object object) {
        UserDetails userDetails = (UserDetails) object;
        String key = REDIS_PREFIX_USER + userDetails.getUsername();
        getRedisRepository().setExpire(key, JacksonUtils.toJSon(userDetails), getExpiration());

    }

    @Override
    public Object getUserDetails(String token) {
        String userDetailsString = getUserDetailsString(token);
        if (userDetailsString != null) {
            return JacksonUtils.readValue(userDetailsString, AuthUser.class);
        }
        return null;
    }
}
