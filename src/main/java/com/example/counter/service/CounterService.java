package com.example.counter.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CounterService {
    private final StringRedisTemplate redisTemplate;
    private static final String COUNTER_KEY = "visit:count";

    public CounterService(StringRedisTemplate redisTemplate) { // lombok 추가하면 굳이 작성 안 해도 되는 코드
        this.redisTemplate = redisTemplate;
    }

    public Long increment() {
        return redisTemplate.opsForValue().increment(COUNTER_KEY);
    }

    public Long getCount() {
        String count = redisTemplate.opsForValue().get(COUNTER_KEY);
        return count == null ? 0L : Long.parseLong(count);
    }
}
