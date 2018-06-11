package com.stubborn.test.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author 丁少东
 * @create 2018-06-10 上午11:16
 **/
public class TestTime {
    public static void main(String[] args) {
        Long time = 192640342L;
        Long day = time / 86400000L;
        Long sfm = time % 86400000L;

        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(sfm);
        SimpleDateFormat fmat=new SimpleDateFormat("HH:mm:ss");
        String time1=fmat.format(calendar.getTime());
        System.out.println(day);
        System.out.println(time1);
    }
}
