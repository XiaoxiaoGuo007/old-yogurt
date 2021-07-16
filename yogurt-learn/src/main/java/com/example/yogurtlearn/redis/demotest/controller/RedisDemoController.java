package com.example.yogurtlearn.redis.demotest.controller;

import com.example.yogurtlearn.redis.demotest.service.impl.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RedisDemoController {

    @Autowired
    private RedisService redisService;

    @PostMapping("/redis/testDemo")
    public void testRedisDemoController(){
        String s = redisService.redisHandler();
        System.out.println(s);
        System.out.println("执行成功!!!");
    }
}
