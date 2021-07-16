package com.example.yogurtlearn.redis.distributedLock.distributedlocksample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 基于redis实现分布式锁所满足的一些场景实现
 * @author: old_yogurt
 * @date 2021/7/16 9:57
 */
@Component
public class DistributedLockSample {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private static JedisPool jedisPool;

    /**
     * @param key
     * @param value
     * @return
     */
    public static Long distributedLock(String key,String value){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            return jedis.setnx(key, value);
        }catch (Exception e){
            return -1L;
        }finally {
            //归还连接
            jedisPool.close();
        }
    }

    static AtomicInteger atomicInteger = new AtomicInteger(1);
    static CountDownLatch latch = new CountDownLatch(5);

    public void testDistributedLockSample() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    JedisPool jedisPool = null;
                    try{


                        jedisPool = new JedisPool("127.0.0.1", 6379);
                        Jedis jedis = jedisPool.getResource();
                        jedis.auth("123456");

                        latch.countDown();
                        System.out.println("5个线程都来到这里");
                        Long setnx = jedis.setnx("lock1", "okk");
                        if(setnx>0){
                            System.out.println("lock success!");
                        }else {
                            try {
                                TimeUnit.SECONDS.sleep(5);
                                System.out.println(Thread.currentThread().getName()+",lock fail!");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        jedisPool.close();
                    }
                }
            };
            thread.setName("threadId:"+atomicInteger.getAndIncrement());
            thread.start();
        }
    }

    public static void main(String[] args) {
        DistributedLockSample lock = new DistributedLockSample();
        lock.testDistributedLockSample();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
