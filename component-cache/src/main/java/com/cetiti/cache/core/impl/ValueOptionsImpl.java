package com.cetiti.cache.core.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cetiti.cache.ValueOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@Service
public class ValueOptionsImpl<T> implements ValueOptions<T> {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ValueOperations<String, T> valueOperations;

    @Override
    public void setValue(String key, T val) {
        valueOperations.set(key, val);
    }

    @Override
    public T getValue(String key) {
        return valueOperations.get(key);
    }
}
