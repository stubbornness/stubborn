package com.stubborn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * 测试
 *
 * @author 丁少东
 * @create 2018-05-25 下午3:32
 **/
@RestController
@RequestMapping("test")
public class TestController {

    /*@GetMapping("/show")
    public Object show(){
        return 123;
    }


    public static void main(String[] args) {
        List<List<String>> lists  = new ArrayList<>();
        List<String> list1 = new ArrayList<>(Arrays.asList("1","1"));
        List<String> list2 = new ArrayList<>(Arrays.asList("2","2_1"));
        List<String> list3 = new ArrayList<>(Arrays.asList("2","2"));
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        List<List<String>> lists1  = new ArrayList<>();
        for (int i = 0; i < lists.size() ; i++) {
            List<String> slist = lists.get(i);
            for (int j = 0; j < slist.size() ; j++) {
                if (slist.get(j).contains("_")){

                }
            }

        }

    }
*/

    /*public static void main(String[] args) {
        Map<String, BigDecimal> map = new HashMap<>();
       // map.put("1",new BigDecimal(10));
        map.put("2",new BigDecimal(-10));
        //map.put("3",new BigDecimal(0));
       // map.put("4",new BigDecimal(-10));

        System.out.println(riskManageMap(map));
    }
*/
 /*   public static String riskManageMap(Map<String, BigDecimal> map) {
        if (map == null) return null;
        List<Map.Entry<String,BigDecimal>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (o1, o2) -> (o1.getValue().subtract(o2.getValue()).intValue()));
        BigDecimal value = list.get(0).getValue();
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < list.size() ; i++) {
            if (value.compareTo(list.get(i).getValue()) == 0){
                list1.add(list.get(i).getKey());
            }
        }
        int index = new Random().nextInt(list1.size());
        return list1.get(index);
    }*/

    public static String riskManageMap(Map<String, BigDecimal> map) {
        if (map == null) return null;
        List<Map.Entry<String, BigDecimal>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (o1, o2) -> (o1.getValue().subtract(o2.getValue()).intValue()));
        BigDecimal value = list.get(0).getValue();
        List<String> list1 = new ArrayList<>();
        for (Map.Entry<String, BigDecimal> entry : map.entrySet()) {
            if (entry.getValue().compareTo(value) == 0) {
                list1.add(entry.getKey());
            }
        }
        int index = new Random().nextInt(list1.size());
        return list1.get(index);
    }

 /*   public static void main(String[] args) {
        BigDecimal jackpotBalance = new BigDecimal(100);
        BigDecimal riskLimit = new BigDecimal(100);

        if (jackpotBalance.compareTo(riskLimit) < 0){
            System.out.println("hh");
        }
    }*/

    public static void main(String[] args) {
        List <String> list = new ArrayList<>(Arrays.asList("1","2"));
        System.out.println(outputWinningNumber(list));
    }

    public static String outputWinningNumber(List<String> list){
        String winningNumber = null;
        int size = list.size();
        if (size == 1){
            winningNumber =  list.get(0);
            return winningNumber;
        }else{
            if (size == 2 && list.contains("0") && list.contains("37")){
                int randomZero1 = new Random().nextInt(2);
                if (randomZero1 == 0){
                    winningNumber = "0";
                    return winningNumber;
                }else {
                    winningNumber = "37";
                    return winningNumber;
                }
            }
            int randomZero = new Random().nextInt(1000);
            if (list.contains("0")){
                if (randomZero >= 0 && randomZero < 14){
                    winningNumber = "0";
                    return winningNumber;
                }

            }
            if(list.contains("37")){
                if (randomZero >= 14 && randomZero < 28){
                    winningNumber = "37";
                    return winningNumber;
                }

            }
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()){
                String element = iterator.next();
                if ("0".equals(element) || "37".equals(element)){
                    iterator.remove();
                }
            }
            int randomOter = new Random().nextInt(list.size());
            winningNumber = list.get(randomOter);
            return winningNumber;
        }


    }



}
