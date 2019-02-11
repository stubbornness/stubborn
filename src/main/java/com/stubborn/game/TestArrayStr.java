package com.stubborn.game;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stubborn.util.CommonUtil;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author 丁少东
 * @create 2019-01-03 上午9:08
 **/
public class TestArrayStr {

    public final static Map<String,String> dlpMap = new LinkedHashMap<>();

    static {
        dlpMap.put("0", "0");//
        dlpMap.put("1", "1");//
        dlpMap.put("2", "2");//
        dlpMap.put("3", "3");//
        dlpMap.put("4", "4");//
        dlpMap.put("5", "5");//
        dlpMap.put("6", "6");//
        dlpMap.put("7", "7");//
        dlpMap.put("8", "8");//
        dlpMap.put("9", "9");//
        dlpMap.put("10", "10");//
        dlpMap.put("11", "11");//
        dlpMap.put("12", "12");//
        dlpMap.put("13", "13");//
        dlpMap.put("14", "14");//
        dlpMap.put("15", "15");//
        dlpMap.put("16", "16");//
        dlpMap.put("17", "17");//
        dlpMap.put("18", "18");//
        dlpMap.put("19", "19");//
        dlpMap.put("20", "20");//
        dlpMap.put("21", "21");//
        dlpMap.put("22", "22");//
        dlpMap.put("23", "23");//
        dlpMap.put("24", "24");//
        dlpMap.put("25", "25");//
        dlpMap.put("26", "26");//
        dlpMap.put("27", "27");//
        dlpMap.put("28", "28");//
        dlpMap.put("29", "29");//
        dlpMap.put("30", "30");//
        dlpMap.put("31", "31");//
        dlpMap.put("32", "32");//
        dlpMap.put("33", "33");//
        dlpMap.put("34", "34");//
        dlpMap.put("35", "35");//
        dlpMap.put("36", "36");//
        dlpMap.put("37", "37");//
        dlpMap.put("38", "38");//
        dlpMap.put("39", "39");//
        dlpMap.put("40", "40");//
        dlpMap.put("41", "41");//
        dlpMap.put("42", "42");//
        dlpMap.put("43", "43");//
        dlpMap.put("44", "44");//
        dlpMap.put("45", "45");//
        dlpMap.put("46", "46");//
        dlpMap.put("47", "47");//
        dlpMap.put("48", "48");//
        dlpMap.put("49", "49");//
    }


    public static void main(String[] args) {
        /*String str = "1_2_3_4_5";
        str =  str.substring(str.lastIndexOf("3"),str.length());
        System.out.println(str);*/
      /*  BigDecimal betAmount = BigDecimal.ZERO;
        BigDecimal returnAmountAdd = BigDecimal.ZERO;
        BigDecimal riskLimit = new BigDecimal(-1000);
        if(betAmount.subtract(returnAmountAdd).compareTo(riskLimit) > 0){

        }*/

        /*String str = "8_1_";
        System.out.println(str.substring(0, str.length() - 1));*/



    /*    String str = "1";
        str = str.substring(0,1);
        System.out.println(str);*/

/*    List<String> list = new ArrayList<>(Arrays.asList("1","2","3"));
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String element = iterator.next();
            if ("1".equals(element)){
                iterator.remove();
            }
        }
        System.out.println(list.size());
        System.out.println(list);*/

/*    BigDecimal b1 = BigDecimal.ZERO;
    BigDecimal b2 = new BigDecimal(100);
        System.out.println(b2.multiply(new BigDecimal(-1)));*/


/*     String str1 = "1 2 3";
     String str2 = "123";
        String str3 = CommonUtil.mergeStr(
                1,
                " ", 2,
                " ", 3);
     if (str1.equals(str2)){
         System.out.println("hhah");
     }

     if (str1.equals(str3)){
         System.out.println("yes");
     }


        JSONObject json = JSON.parseObject("122");
        //投注的点数出现的次数
        int num = json.getIntValue("2");
        System.out.println(num);*/

 /*     String str = "005_1_1_3,006_11";
      String [] arrs = str.split(",");
      Map<String,String> map = new HashMap<>();
      for (String s : arrs){
          if (s.contains("005")){
              String [] arr = s.split("_");


              System.out.println("hahah");
          }
      }*/


            Map<String, Integer> map = new HashMap<>();
            String str = "005_1_1_6";
            String playCode = str.substring(0,3);
            str = str.substring(4,str.length());
            String arrs [] = str.split("_");
            String key = null;
            Integer value = null;
            for (String element : arrs){
                key = CommonUtil.mergeStr(playCode,"_",element);
                if (map.containsKey(key)){
                    value = map.get(key);
                    value++;
                    map.put(key,value);
                }else {
                    map.put(key,1);
                }
            }
        System.out.println(map);







    }
}
