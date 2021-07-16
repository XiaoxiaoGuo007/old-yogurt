package com.example.yogurtlearn.concurrent.threadpoolconfig;

import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 线程池
 * @author: old_yogurt
 * @date 2021/7/16 9:57
 */
@Component
public class ThreadPoolUtil {
    static final int NCUP = Runtime.getRuntime().availableProcessors();
    static MyTheadFactory myTheadFactory = new MyTheadFactory("threadPool");

    static final ThreadPoolExecutor threadPool =
            new ThreadPoolExecutor(NCUP,2*NCUP,
                                   1,TimeUnit.MINUTES,
                                   new LinkedBlockingQueue<>(100),
                                   myTheadFactory,
                                   new ThreadPoolExecutor.CallerRunsPolicy());

    static class MyTheadFactory implements ThreadFactory {
        private final String threadNamePrefix;
        private final AtomicInteger nextThreadId = new AtomicInteger(1);

        public MyTheadFactory(String namePrefix) {
            this.threadNamePrefix = namePrefix + ",线程id: ";
        }

        @Override
        public Thread newThread(Runnable r) {
            String threadName = threadNamePrefix + nextThreadId.getAndIncrement();
            Thread thread = new Thread(null, r, threadName, 0);
            return thread;
        }
    }

    public static ThreadPoolExecutor getThreadPool() {
        return threadPool;
    }
}
