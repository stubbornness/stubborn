package com.stubborn.test.delayQueue;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延迟队列model
 *
 * @author 丁少东
 * @create 2018-05-25 上午11:45
 **/
@Data
@NoArgsConstructor
@ToString
public class DelayQueueTask implements Delayed {
    private Long doTime;
    private String name;


    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(doTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (o == null || !(o instanceof DelayQueueTask)) {
            return 1;
        }
        if (o == this) {
            return 0;
        }
        DelayQueueTask delayedBetTask = (DelayQueueTask) o;
        if (this.doTime > delayedBetTask.doTime) {
            return 1;
        } else if (this.doTime == delayedBetTask.doTime) {
            return 0;
        } else {
            return -1;
        }
    }

}
