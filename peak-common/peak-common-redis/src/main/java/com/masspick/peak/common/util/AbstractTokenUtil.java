package com.masspick.peak.common.util;

import com.masspick.peak.common.redis.RedisRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * Created by admin on 2018/5/22 0022.
 */
public abstract class AbstractTokenUtil {
    /**
     * Logger
     */
    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractTokenUtil.class);

    /**
     * 携带Token的HTTP头
     */
    public static final String TOKEN_HEADER = "Authorization";
    /**
     * Token 类型
     */
    public static final String TOKEN_TYPE_BEARER = "Bearer";
    /**
     * 权限缓存前缀
     */
    public static final String REDIS_PREFIX_AUTH = "auth:";
    /**
     * 用户信息缓存前缀
     */
    public static final String REDIS_PREFIX_USER = "user-details:";

    /**
     * MILLISECOND
     */
    public static final int MILLISECOND = 1000;

    /**
     * redis repository
     */
    @Autowired
    private RedisRepository redisRepository;

    /**
     * secret
     */
    @Value("${security.jwt.secret}")
    private String secret;
    /**
     * 过期时间
     */

    private Long expiration;

    /**
     * maxExpiration
     */
    @Value("${security.jwt.max-expiration}")
    private Long maxExpiration;

    /**
     * minExpiration
     */
    @Value("${security.jwt.min-expiration}")
    private Long minExpiration;

    /**
     * 获取用户名
     *
     * @param token Token
     * @return String
     */
    public String getUsernameFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims != null ? claims.getSubject() : null;
    }

    /**
     * 获得 Claims
     *
     * @param token Token
     * @return Claims
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            LOGGER.warn("getClaimsFromToken exception", e);
            claims = null;
        }
        return claims;
    }

    /**
     * 计算过期时间
     *
     * @return Date
     */
    public Date generateExpired() {
        return new Date(System.currentTimeMillis() + expiration * MILLISECOND);
    }

    /**
     * 判断 Token 是否过期
     *
     * @param token Token
     * @return Boolean
     */
    private Boolean isTokenExpired(String token) {
        Date expirationDate = getExpiredFromToken(token);
        return expirationDate.before(new Date());
    }

    /**
     * 获取过期时间
     *
     * @param token Token
     * @return Date
     */
    public Date getExpiredFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims != null ? claims.getExpiration() : null;
    }

    /**
     * 生成 Token
     *
     * @return String
     */
    public abstract String generateToken(Object object, Boolean rememberMe);

    /**
     * 存储用户信息
     *
     */
    public abstract void putUserDetails(Object object);

    /**
     *
     * @param token
     * @return Object
     */
    public abstract Object getUserDetails(String token);

    /**
     * 获得用户信息 Json 字符串
     *
     * @param token Token
     * @return String
     */
    public String getUserDetailsString(String token) {
        final String username = getUsernameFromToken(token);
        String key = REDIS_PREFIX_USER + username;
        return redisRepository.get(key);
    }

    /**
     * 验证 Token
     *
     * @param token Token
     * @return Boolean
     */
    public Boolean validateToken(String token) {
        final String username = getUsernameFromToken(token);
        String key = REDIS_PREFIX_AUTH + username;
        String redisToken = redisRepository.get(key);
        return StringHelper.isNotEmpty(token) && !isTokenExpired(token) && token.equals(redisToken);
    }

    /**
     * 移除 Token
     *
     * @param token Token
     */
    public void removeToken(String token) {
        final String username = getUsernameFromToken(token);
        String key = REDIS_PREFIX_AUTH + username;
        redisRepository.del(key);
        delUserDetails(username);
    }

    /**
     * 删除用户信息
     *
     * @param username 用户名
     */
    private void delUserDetails(String username) {
        String key = REDIS_PREFIX_USER + username;
        redisRepository.del(key);
    }

    /**
     * Gets secret
     *
     * @return value of secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     * @param secret
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * Gets expiration
     *
     * @return value of expiration
     */
    public Long getExpiration() {
        return expiration;
    }

    /**
     * @param expiration
     */
    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    /**
     * Gets maxExpiration
     *
     * @return value of maxExpiration
     */
    public Long getMaxExpiration() {
        return maxExpiration;
    }

    /**
     * @param maxExpiration
     */
    public void setMaxExpiration(Long maxExpiration) {
        this.maxExpiration = maxExpiration;
    }

    /**
     * Gets minExpiration
     *
     * @return value of minExpiration
     */
    public Long getMinExpiration() {
        return minExpiration;
    }

    /**
     * @param minExpiration
     */
    public void setMinExpiration(Long minExpiration) {
        this.minExpiration = minExpiration;
    }

    /**
     * Gets redisRepository
     *
     * @return value of redisRepository
     */
    public RedisRepository getRedisRepository() {
        return redisRepository;
    }

    /**
     * @param redisRepository
     */
    public void setRedisRepository(RedisRepository redisRepository) {
        this.redisRepository = redisRepository;
    }
}
