package com.example.lettuce.service;

import com.example.lettuce.model.TestRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TestService  {

    private final RedisTemplate<String, String> redisTemplate;

    public TestService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setRedisKey(TestRequest request) {
        String key = String.format("%s_%s", "USER", request.getUserId());
        String value = request.getValue();
        redisTemplate.opsForValue().set(key, value, 5, TimeUnit.MINUTES);
    }

    public String getRedisKey(Integer id) {
        String key = String.format("%s_%s", "USER", id);
        return redisTemplate.opsForValue().get(key);
    }
}
