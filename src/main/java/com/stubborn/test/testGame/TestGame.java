package com.stubborn.test.testGame;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author 丁少东
 * @create 2019-02-27 上午11:30
 **/
public class TestGame {

    private final static Map<String, BigDecimal> initMap = new HashMap<>();
    static {
        initMap.put("1", BigDecimal.ZERO);
        initMap.put("2", BigDecimal.ZERO);
        initMap.put("3", BigDecimal.ZERO);
        initMap.put("5", BigDecimal.ZERO);
        initMap.put("6", BigDecimal.ZERO);
    }


    public static void main(String[] args) {

        Map<String, BigDecimal> map = new HashMap<>();
        map.put("1_0", new BigDecimal(0));
        map.put("1_1", new BigDecimal(2));
        map.put("2_0", new BigDecimal(3));
        map.put("2_1", new BigDecimal(4));
        map.put("3_0", new BigDecimal(5));
        map.put("3_1", new BigDecimal(6));
        Map<String, BigDecimal> newMap = new HashMap<>();
        String keyArr [] = null;
        String opt0 = null;
        String opt1 = null;
        BigDecimal optAmount0 = null;
        BigDecimal optAmount1 = null;
        BigDecimal optAmount = null;
        for (String key : initMap.keySet()){
            opt0 = key+"_0";
            opt1 = key+"_1";
            optAmount0 = map.get(opt0);
            optAmount1 = map.get(opt1);
            if (optAmount0 == null){
                optAmount0 = BigDecimal.ZERO;
            }
            if (optAmount1 == null){
                optAmount1 = BigDecimal.ZERO;
            }
            optAmount = optAmount0.add(optAmount1);
            newMap.put(key, optAmount);
        }
        System.out.println(newMap);

    }

}
