package com.stubborn.model;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延迟队列model
 *
 * @author 丁少东
 * @create 2018-05-25 上午11:45
 **/
public class DelayQueueTask implements Delayed {
    private Long doTime;
    private String name;


    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
