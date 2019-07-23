package com.stubborn.test.testGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 丁少东
 * @create 2019-03-19 上午11:05
 **/
public class TestThread {

    /* public static void main(String[] args) throws ExecutionException, InterruptedException {
         Executors.newSingleThreadExecutor().submit(
                 new Runnable() {
                     @Override
                     public void run() {
                         while (true) {
                             System.out.println("111");
                         }
                     }
                 }
         );
     }*/
    public static void main(String[] args) {
        int id = 0;
        String[] zeroArray = {"00", "0", ""};
        for (int i = 0; i < 14 ; i++) {
            String strId = String.valueOf(id++);
            String orderInfoId = new StringBuilder("abc").append(zeroArray[strId.length() - 1]).append(strId).toString();
            System.out.println(orderInfoId);
        }
    }



}
