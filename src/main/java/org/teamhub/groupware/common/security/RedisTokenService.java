package org.teamhub.groupware.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisTokenService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void storeRefreshToken(String refreshToken, String username) {
        redisTemplate.opsForValue().set(refreshToken, username);
        // set expiration for the refresh token if needed
        redisTemplate.expire(refreshToken, 7, TimeUnit.DAYS);
    }

    public boolean validateRefreshToken(String refreshToken) {
        return redisTemplate.hasKey(refreshToken);
    }

    public void deleteRefreshToken(String refreshToken) {
        redisTemplate.delete(refreshToken);
    }
}
