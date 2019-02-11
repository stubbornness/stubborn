package com.stubborn.java;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author 丁少东
 * @create 2018-12-21 下午2:32
 **/
public class Test {

    public final static Map<String, String> initMap = new HashMap();

    static {
        initMap.put("1", "1,2,3,4,5");
        initMap.put("2", "7,8,9,10,11");
        initMap.put("3", "6");
    }

    public static void main(String[] args) {
   /*     String str = "123a456";
        str = str.substring(0,3);
        System.out.println(str);*/
     /*   String value = "1";
        if (value.contains("3")){
            value = value.substring(value.lastIndexOf("3"),value.length());
        }
        System.out.println(value);*/

      /*  Map<String, BigDecimal> map = new HashMap<>();
        map.put("1",BigDecimal.ZERO);

            BigDecimal returnAmountAdd = BigDecimal.ZERO;
            BigDecimal tempNum = map.get(1);
            System.out.println(tempNum);*/

      /*  String randomNumStr = "1,2,3,4,5";
        String [] randomNumArr = randomNumStr.split(",");
        int randomNum = new Random().nextInt(randomNumArr.length);
        String str = randomNumArr[randomNum];
        System.out.println(str);*/
    /*    List<String> list = new ArrayList<>(Arrays.asList("3"));
        int size = list.size();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size ; i++) {
            sb.append(initMap.get(list.get(i))).append(",");
        }
        String [] randomNumArr = sb.toString().split(",");
        int randomNum = new Random().nextInt(randomNumArr.length);
        System.out.println(randomNumArr[randomNum]);
*/
/*
        String value = "1_3_2";
        value = value.substring(value.lastIndexOf("2"),value.length());
        System.out.println(value);*/


      /*  List<String> list = new ArrayList<>(Arrays.asList("1","3","2"));
        if (list.contains("1") && list.contains("3") ){
            System.out.println("1");
        }*/





    }
}
