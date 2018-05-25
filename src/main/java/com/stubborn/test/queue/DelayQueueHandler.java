package com.stubborn.test.queue;

import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 执行延迟队列
 *
 * @author 丁少东
 * @create 2018-05-25 下午2:42
 **/
@Component
public class DelayQueueHandler extends BasicTaskHandler {

    public void init() {
        Executors.newSingleThreadExecutor().submit(
                new Runnable() {
                    DelayQueueTask delayQueue = null;
                    @Override
                    public void run() {
                        while (true) {
                            try {
                                //等待5s，如果5s内拿不到的话，程序接着向下走
                                delayQueue = delayQueueTasks.poll(5, TimeUnit.SECONDS);
                                if (delayQueue != null){
                                    System.out.println(delayQueue.getName());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        );
    }



}
