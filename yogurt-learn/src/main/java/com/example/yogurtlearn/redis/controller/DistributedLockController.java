package com.example.yogurtlearn.redis.controller;

import com.example.yogurtlearn.redis.distributedLock.distributedlocksample.RedisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: old_yogurt
 * @date 2021/7/16 18:01
 */

@RestController
public class DistributedLockController {

    @Autowired
    private RedisTest redisTest;

    @PostMapping(value = "/testLock")
    public void test(){
        redisTest.testDistributedLockSample();
    }

    @PostMapping(value = "/testLock1")
    public void test1(){
        redisTest.testLock();
    }

    @PostMapping(value = "/testLock2")
    public void test2(){
        redisTest.testLock2();
    }
}
