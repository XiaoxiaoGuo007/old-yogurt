//package com.example.yogurtlearn.redis.distributedLock.distributedlocksample;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * 这里写一个任务，一个线程获取锁
// * 1.如果获取锁成功，打印lock success!
// * 2.如果获取锁失败，打印 线程名+ ,lock fail!
// */
//@Component
//public class DistributedLockSampleRunnable implements Runnable{
//
//    @Autowired
//    private DistributedLockSample lock;
//
//    @Override
//    public void run() {
//        Long aLong = lock.distributedLock("lock", "ok");
//
//        if(aLong!=null){
//            System.out.println("lock success!");
//        }else {
//            try {
//                TimeUnit.SECONDS.sleep(10);
//                System.out.println(Thread.currentThread().getName()+",lock fail!");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//}
