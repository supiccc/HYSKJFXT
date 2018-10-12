package com.scau.hyskjf.service;

/**
 * Created by supiccc on 2018-10-12 15:45
 */
public interface RedisService {
    void set(String key, String value, long time);
    Object get(String key);
}
