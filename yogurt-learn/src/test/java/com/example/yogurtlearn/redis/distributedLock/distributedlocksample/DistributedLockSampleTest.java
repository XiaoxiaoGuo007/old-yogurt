package com.example.yogurtlearn.redis.distributedLock.distributedlocksample;

import com.example.yogurtlearn.BaseTest;
import com.example.yogurtlearn.concurrent.threadpoolconfig.ThreadPoolUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class DistributedLockSampleTest extends BaseTest {

    @Autowired
    private DistributedLockSample distributedLockSample;

    /**
     * 线程池
     */
    ThreadPoolExecutor threadPool = ThreadPoolUtil.getThreadPool();
    AtomicInteger atomicInteger = new AtomicInteger(1);

//    @Test
//    public void testDistributedLockSample() {
//        for (int i = 0; i < 5; i++) {
//            Thread thread = new Thread(){
//                @Override
//                public void run() {
//                    Long aLong = distributedLockSample.distributedLock("lock1", "okk");
//                    if(aLong>0){
//                        System.out.println("lock success!");
//                    }else {
//                        try {
//                            TimeUnit.SECONDS.sleep(10);
//                            System.out.println(Thread.currentThread().getName()+",lock fail!");
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            };
//            thread.setName("threadId:"+atomicInteger.getAndIncrement());
//            thread.start();
//        }
////        Long aLong = distributedLockSample.distributedLock("lock", "ok");
////        System.out.println(aLong);
//    }

    @Test
    public void getDistributedLockSample() {
        distributedLockSample.testDistributedLockSample();
    }
}

