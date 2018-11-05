/*
package com.masspick.peak.utils;


import com.masspick.peak.common.util.AbstractTokenUtil;
import com.masspick.peak.common.util.JacksonUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

*/
/**
 * FlowTokenUtil
 *//*

@Component
@ConfigurationProperties("security.jwt")
public class FlowTokenUtil extends AbstractTokenUtil {


    @Override
    public String generateToken(Object object, Boolean rememberMe) {
        return null;
    }

    @Override
    public void putUserDetails(Object object) {

    }

    */
/**
     * @param token
     * @return UserDetails
     *//*

    @Override
    public UserDetails getUserDetails(String token) {
        String userDetailsString = getUserDetailsString(token);
        if (userDetailsString != null) {
            return JacksonUtils.readValue(userDetailsString, User.class);
        }
        return null;
    }
}
*/
