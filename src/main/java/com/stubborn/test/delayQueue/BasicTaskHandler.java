package com.stubborn.test.delayQueue;



import java.util.concurrent.DelayQueue;


public class BasicTaskHandler {

    protected static DelayQueue<DelayQueueTask> delayQueueTasks = new DelayQueue<>();

    public static DelayQueue<DelayQueueTask> getDelayQueueTasks() {
        return delayQueueTasks;
    }

    public static void setDelayQueueTasks(DelayQueue<DelayQueueTask> delayQueueTasks) {
        BasicTaskHandler.delayQueueTasks = delayQueueTasks;
    }
}
