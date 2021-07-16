package com.example.yogurtlearn.redis.distributedLock.distributedlocksample;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: old_yogurt
 * @date 2021/7/16 19:13
 */
public class LockWithDeamon {

    private RedisTemplate redisTemplate;

    public Boolean tryLock(String key, String value, long expireTime) {
        try {
            //自旋上限(次数)
            int waitCount = 1000;
            while (waitCount > 0) {
                //SET命令返回OK ，则证明获取锁成功
                Boolean setIfAbsent = redisTemplate.opsForValue().setIfAbsent(key, value, expireTime, TimeUnit.SECONDS);
                if (setIfAbsent) {
                    //续命
                    Thread demo = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (true) {
                                Boolean expire = redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
                                //有可能已经主动删除key,不需要在续命
                                if(!expire){
                                    return;
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                    demo.setDaemon(true);
                    demo.start();
                    return true;
                }
                //否则循环等待，在timeout时间内仍未获取到锁，则获取失败
                Thread.sleep(3000);
                waitCount--;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
        //没设置到锁，即表示超时了
        return false;
    }
}
