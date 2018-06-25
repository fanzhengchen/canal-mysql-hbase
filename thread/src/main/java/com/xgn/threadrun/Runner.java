package com.xgn.threadrun;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2018-06-23
 * Time: 1:59 AM
 *
 * @author: MarkFan
 * @since v1.0.0
 */
@Component
public class Runner implements ApplicationRunner {

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println("ww " + t.toString());
                    }
                });
                for (; ; ) {
                    try {
                        Thread.sleep(300);
                        System.out.println(System.currentTimeMillis());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
