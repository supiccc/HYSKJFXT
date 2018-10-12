package com.scau.hyskjf.service.impl;

import com.scau.hyskjf.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by supiccc on 2018-10-12 15:46
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void set(String key, String value, long time) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        ValueOperations<String, String> vo = redisTemplate.opsForValue();
        vo.set(key, value, time, TimeUnit.MINUTES);
    }

    @Override
    public Object get(String key) {
        ValueOperations<String, String> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }
}
