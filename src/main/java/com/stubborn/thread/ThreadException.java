package com.stubborn.thread;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stubborn.java.strategyPattern.bjlgame.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 丁少东
 * @create 2019-05-15 上午10:53
 **/
public class ThreadException {

       /* public void taskProcess() {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(() -> {
                while (true) {
                    JSONObject json = null;
                    try {

                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }
            });
        }*/

 /*   public static void main(String[] args) {
        int i=getInt();
        System.out.println(i);
    }

    private static int getInt() {
        // TODO Auto-generated method stub
        try {
            //return 0;
            System.out.println(0);
            return 0;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //return 1;
            System.out.println(2);
            return 1;
        }
    }*/

    private int a=1;
    public static void main(String[] args) {
        ThreadException t2 = null;
        System.out.println(t2.a);
    }
}
