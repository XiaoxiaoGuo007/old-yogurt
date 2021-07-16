package com.example.yogurtlearn.redis.distributedLock.distributedlocksample;

import com.example.yogurtlearn.redis.contants.LockConstants;
import com.mysql.cj.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static com.example.yogurtlearn.redis.distributedLock.distributedlocksample.DistributedLockSample.atomicInteger;

/**
 * @description:
 * @author: old_yogurt
 * @date 2021/7/16 17:28
 */
@Service
public class RedisTest {
    @Autowired
    private JedisPool jedisPool;

    //做一个线程id
    static AtomicInteger atomicInteger = new AtomicInteger(1);

    /**
     * @Author: old_yogurt
     * @Description:
     *      最简单的分布式锁，基于redis的setnx保证get,set操作的原子性
     *          存在的问题：锁一直不会释放；如果拿到锁的线程执行业务逻辑，不论抛不抛异常，出不出错，锁都不会释放
     *      那么后面的线程就永远那拿不到锁。
     * @Param: [key, value]
     * @return: java.lang.Long
     */
    public Long distributedLock(String key,String value){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            return jedis.setnx(key, value);
        }catch (Exception e){
            return -1L;
        }finally {
            returnResource(jedisPool, jedis);
        }
    }

    /**
     * @Author: old_yogurt
     * @Description:
     * @Param: [key, value, time, unit]
     * @return: java.lang.String
     */
    public String distributedLockWithExpireTime(String key, String value, Long time){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            /**
             * @param key
             * @param value
             * @param nxxx NX|XX, NX -- Only set the key if it does not already exist.
             *                    XX -- Only set the keyif it already exist.
             *        这个nxxx参数是关键，保证了 get,set value和过期时间的原子性
             * @param expx EX|PX, expire time units: EX = seconds; PX = milliseconds
             * @param time expire time in the units of expx
             * @return Status code reply
             */
            return jedis.set(key, value , LockConstants.NOT_EXIST,LockConstants.SECONDS,time);
        }catch (Exception e){
            return "";
        }finally {
            returnResource(jedisPool, jedis);
        }
    }

    public void testLock(){
        String lock = distributedLockWithExpireTime("lockWithExpireTime", "1", 60L);
        System.out.println(lock);
    }

    public void testLock2(){
        Long lock = distributedLock("lockWithExpireTime", "1");
        System.out.println(lock);
    }


    public void testDistributedLockSample() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    try{
                        System.out.println("5个线程都来到这里");
                        String lock = distributedLockWithExpireTime("lockWithExpireTime", "1", 60L);
                        if(LockConstants.OK.equals(lock)){
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
                    }
                }
            };
            thread.setName("threadId:"+atomicInteger.getAndIncrement());
            thread.start();
        }
    }

    /**
     * 返还到连接池
     * @param jedisPool
     * @param jedis
     */
    public static void returnResource(JedisPool jedisPool, Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }


}
