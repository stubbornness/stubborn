package com.stubborn.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author 丁少东
 * @create 2018-12-24 下午4:03
 **/
public class GameUtil {
    /**
     * 换牌
     * @param map
     * @return
     */
    public static Map<String, Integer> changeCard(Map<String, Integer> map){
        Map<String, Integer> result = new HashMap<>();
        map.put("1", map.get("2"));
        map.put("2", map.get("1"));
        map.put("3", map.get("4"));
        map.put("4", map.get("3"));
        return  result;
    }

    /**
     * 防止对子的产生
     * @param cardRandom
     * @return
     */
    public static int removeCardPair(int cardRandom){
        String randomStr1 = String.valueOf(cardRandom);
        String str = "1,2,3,4,5,6,7,8,9,10,11,12,13";
        str = str.replace(randomStr1, "");
        return outRandomNumByStr(str);
    }

    /**
     * 产生牌的数字
     * @return
     */
    public static int commonOutputCard(int start, int end){
        int colorRandom = new Random().nextInt(start) + end;
        return colorRandom;
    }

    public static Map<String,Integer> outputCard(int playPair, int bankPair){
        Map<String, Integer> map = new HashMap<>();
        //1,3张牌发给闲家   2,4张牌发给庄家
        int cardRandom1 = commonOutputCard(13, 1);
        int cardRandom2 = commonOutputCard(13, 1);
        int cardRandom3 = commonOutputCard(13, 1);
        int cardRandom4 = commonOutputCard(13, 1);
        if (playPair == 1){
            //去除闲对
            if (cardRandom1 == cardRandom3){
                cardRandom3 = removeCardPair(cardRandom1);
            }
        }else{//闲对
            cardRandom3 = cardRandom1;
        }
        if (bankPair == 1){
            //去除庄对
            if (cardRandom2 == cardRandom4){
                cardRandom4 = removeCardPair(cardRandom2);
            }
        }else {//庄对
            cardRandom4 = cardRandom2;
        }
        //闲的和
        int playAdd = 0;
        playAdd = specialHandleRandom(cardRandom1, cardRandom3);//两个牌的和可能是0点
        //庄的和
        int bankAdd = 0;
        bankAdd = specialHandleRandom(cardRandom2, cardRandom4);//两个牌的和可能是0点
        map.put("1", cardRandom1);
        map.put("2", cardRandom2);
        map.put("3", cardRandom3);
        map.put("4", cardRandom4);
        map.put("playAdd", playAdd);
        map.put("bankAdd", bankAdd);
        return map;
    }

    public static Integer specialHandleRandom(int num1, int num2){
        if (num1 >= 10){
            num1 = 0;
        }
        if (num2 >= 10){
            num2 = 0;
        }
        int sum = num1 + num2;
        if (sum >= 10){
            sum = sum - 10;
            return sum;
        }
        return sum;
    }

    //庄闲比较大小
    public static int compare(int bank, int play){
        if (bank > play){
            return 1;//闲赢
        } else if (bank == play){
            return 3;//和
        }else {
            return 2;//庄赢
        }
    }

    public static int outRandomNumByStr(String str){
        int index = commonOutputCard(str.length(), 0);
        return Integer.parseInt(str.split(",")[index]);
    }

    public static Map<String,Integer> outMapRandomNumByStr(String str1, String str2, Map<String,Integer> map){
        int random = commonOutputCard(str1.length(), 0);
        map.put("2", Integer.parseInt(str1.split(",")[random]));
        map.put("4", Integer.parseInt(str2.split(",")[random]));
        return map;
    }
    public static Map<String,Integer> outMapRandomNumByString(String str1, String str2 , Map<String,Integer> map){
        int random1 = commonOutputCard(str1.length(), 0);
        int random2 = commonOutputCard(str1.length(), 0);
        map.put("1", Integer.parseInt(str1.split(",")[random1]));
        map.put("3", Integer.parseInt(str2.split(",")[random1]));
        map.put("2", Integer.parseInt(str1.split(",")[random2]));
        map.put("4", Integer.parseInt(str2.split(",")[random2]));
        return map;
    }

    public static Map<String,Integer> outMapRandomNumByStr(){
        Map<String, Integer> map = new HashMap<>();
        int index = new Random().nextInt(2) + 8;
        if (index == 8){
            String str1 = "10,11,12,13,1,2,3,5,6,7,8,8,8,8";
            String str2 = "8,8,8,8,7,6,5,3,2,1,10,11,12,13";
            map = GameUtil.outMapRandomNumByString(str1, str2, map);
            return map;
        }else {
            String str1 = "10,11,12,13,1,2,3,4,5,6,7,8,9,9,9,9";
            String str2 = "9,9,9,9,8,7,6,5,4,3,2,1,10,11,12,13";
            map = GameUtil.outMapRandomNumByString(str1, str2 , map);
            return map;

        }
    }


}
