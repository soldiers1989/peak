package com.masspick.peak.guest.common.redis;

import com.masspick.peak.common.redis.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * RedisUtil
 */
@Component
public class RedisUtil {

    /**
     * MOBILE_VER_CODE
     */
    private static final String MOBILE_VER_CODE = "ver-code:"; //手机验证码

    /**
     * time
     */
    private static final long TIME = 60 * 10;

    /**
     * redisRepository
     */
    @Autowired
    private RedisRepository redisRepository;

    /**
     * @param mobile
     * @param code
     */
    public void putVerCodeMobile(String mobile, String code) {
        String key = MOBILE_VER_CODE + mobile;
        redisRepository.setExpire(key, code, TIME); //时间60S
    }


    /**
     * @param mobile
     * @return String
     */
    public String getVerCodeByMobile(String mobile) {
        String key = MOBILE_VER_CODE + mobile;
        return redisRepository.get(key);
    }
}
