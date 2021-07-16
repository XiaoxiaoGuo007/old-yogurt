package com.example.yogurtlearn.redis.demotest.service.impl;

import com.example.yogurtlearn.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class RedisServiceImplTest extends BaseTest {

    @Autowired
    private RedisServiceImpl redisService;

    @Test
    void redisHandler() {
        String s = redisService.redisHandler();
        System.out.println(s);
    }
}