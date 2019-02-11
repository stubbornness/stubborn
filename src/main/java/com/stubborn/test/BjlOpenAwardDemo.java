package com.stubborn.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author 丁少东
 * @create 2018-12-06 上午9:24
 **/
public class BjlOpenAwardDemo {

    public static final String OPEN_AWARD_EVENT1 = "1";
    public static final String OPEN_AWARD_EVENT2 = "2";
    public static final String OPEN_AWARD_EVENT3 = "3";
    public static final String OPEN_AWARD_EVENT1_4 = "1_4";
    public static final String OPEN_AWARD_EVENT1_5 = "1_5";
    public static final String OPEN_AWARD_EVENT2_4 = "2_4";
    public static final String OPEN_AWARD_EVENT2_5 = "2_5";
    public static final String OPEN_AWARD_EVENT3_4 = "3_4";
    public static final String OPEN_AWARD_EVENT3_5 = "3_5";
    public static final String OPEN_AWARD_EVENT1_4_5 = "1_4_5";
    public static final String OPEN_AWARD_EVENT2_4_5 = "2_4_5";
    public static final String OPEN_AWARD_EVENT3_4_5 = "3_4_5";

    public static final int TEN = 10;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;


    public static void main(String[] args) {

    }

    public static Map<String,String> openAwardHandler(){
        String resulst = outEvent();
        switch (resulst) {
            case OPEN_AWARD_EVENT1:
                openAwardEvent1();
                break;
            case OPEN_AWARD_EVENT2:
                break;
            case OPEN_AWARD_EVENT3:
                break;
            case OPEN_AWARD_EVENT1_4:
                break;
            case OPEN_AWARD_EVENT1_5:
                break;
            case OPEN_AWARD_EVENT2_4:
                break;
            case OPEN_AWARD_EVENT2_5:
                break;
            case OPEN_AWARD_EVENT3_4:
                break;
            case OPEN_AWARD_EVENT3_5:
                break;
            case OPEN_AWARD_EVENT1_4_5:
                break;
            case OPEN_AWARD_EVENT2_4_5:
                break;
            case OPEN_AWARD_EVENT3_4_5:
                break;
        }
        return null;
    }

    public static String outEvent(){
        String eventResult1 = "";
        String eventResult2 = "";
        String eventResult3 = "";
        String result = "";

        //开闲和庄
        Integer randomEvent1 = outRandomNumber(999999);
        if (1 <= randomEvent1 && randomEvent1 <= 458597){
            eventResult1 = "1_";//开闲
            result = result + eventResult1;
        }else if(randomEvent1 <= 904844){
            eventResult1 = "2_";//开庄
            result = result + eventResult1;
        }else {
            eventResult1 = "3_";//开和
            result = result + eventResult1;
        }
        //开闲对
        Integer randomEvent2 = outRandomNumber(999999);
        if (0 <= randomEvent2 && randomEvent2 <= 76499){
            eventResult2 = "4_";
            result = result + eventResult2;
        }
        //开庄对
        Integer randomEvent3 = outRandomNumber(999999);
        if (0 <= randomEvent3 && randomEvent3 <= 76499){
            eventResult3 = "5_";
            result = result + eventResult3;
        }

        result = result.substring(0,result.length()-1);
        return result;
    }

    public static Integer outRandomNumber(int num){
        Integer randomEvent = new Random().nextInt(num) + 1;
        return randomEvent;
    }

    public static Integer outRandomNumber1(int num){
        Integer randomEvent = new Random().nextInt(9);
        return randomEvent;
    }

    /**
     * 产生牌的数字
     * @return
     */
    public static int outputCard(){
        int colorRandom = new Random().nextInt(12) + 1;
        //10,11,12,13  代表 0
        if (colorRandom == TEN || colorRandom == JACK || colorRandom == QUEEN || colorRandom == KING) {
            colorRandom = 0;
        }
        return colorRandom;
    }

    public static int commonOutputCard(int start, int end){
        int colorRandom = new Random().nextInt(start) + end;
        return colorRandom;
    }
    //第一种情况闲获胜
    public static Map<String,Integer> openAwardEvent1(){
        //1,3张牌发给闲家   2,4张牌发给庄家
        int cardRandom1 = outputCard();
        int cardRandom2 = outputCard();
        int cardRandom3 = outputCard();
        int cardRandom4 = outputCard();

        //去除闲对
        if (cardRandom1 == cardRandom3){
            if (cardRandom1 == 0){
                cardRandom3 = cardRandom3 + 1;
            }else{
                cardRandom3 = cardRandom3 - 1;
            }
        }
        //去除庄对
        if (cardRandom2 == cardRandom4){
            if (cardRandom2 == 0){
                cardRandom2 = cardRandom4 + 1;
            }else{
                cardRandom4 = cardRandom4 - 1;
            }
        }
        //闲的和
        int playAdd = 0;
        playAdd = cardRandom1 + cardRandom3;
        playAdd = specialHandleRandom2(playAdd);//两个牌的和可能是0点
        //庄的和
        int bankAdd = 0;
        bankAdd = cardRandom2 + cardRandom4;
        bankAdd = specialHandleRandom2(bankAdd);//两个牌的和可能是0点

        Map<String, Integer> map = new HashMap<>();
        if(bankAdd == 9 || bankAdd == 8 || playAdd == 9 || playAdd == 8){
            int result = compare(bankAdd, playAdd);
            if (result == 1){//闲
                map.put("1",cardRandom1);
                map.put("2",cardRandom2);
                map.put("3",cardRandom3);
                map.put("4",cardRandom4);
            }
            if (result == 3){//和
                map.put("1",cardRandom1);
                map.put("2",cardRandom2);
                map.put("3",cardRandom3);
                cardRandom4 = cardRandom4 - 1;
                map.put("4",cardRandom4);
            }
            if (result == 2){//庄赢(相互换牌)
                map.put("1",cardRandom2);
                map.put("2",cardRandom1);
                map.put("3",cardRandom4);
                map.put("4",cardRandom3);
            }
            return map;
        }

        int cardRandom5 = 0;//闲家补牌
        int cardRandom6 = 0;//庄家补牌
        if (playAdd >= 0 && playAdd <= 5){//  一闲家补牌
            if (bankAdd == 7){// 庄不补牌
                if (playAdd == 0){
                    String str = "8,9";
                    cardRandom5 = outRandomNumByStr(str);
                }
                if (playAdd == 1){
                    String str = "7,8";
                    cardRandom5 = outRandomNumByStr(str);
                }
                if (playAdd == 2){
                    String str = "6,7";
                    cardRandom5 = outRandomNumByStr(str);
                }
                if (playAdd == 3){
                    String str = "5,6";
                    cardRandom5 = outRandomNumByStr(str);
                }
                if (playAdd == 4){
                    String str = "4,5";
                    cardRandom5 = outRandomNumByStr(str);
                }
                if (playAdd == 5){//
                    String str = "3,4";
                    cardRandom5 = outRandomNumByStr(str);
                }
                playAdd = playAdd + cardRandom5;//闲家补牌求和
                playAdd = specialHandleRandom2(playAdd);//两个牌的和可能是0点
                map.put("5",cardRandom5);
                //map.put("6",-1);//庄家不补牌。
                return map;
            }else{
                if (playAdd == 0){
                    if (bankAdd == 0){
                        cardRandom5 = commonOutputCard(9,1);
                        map.put("5",cardRandom5);
                        if (cardRandom5 == 1){
                            String str = "10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 2){
                            String str = "1,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){
                            String str = "1,2,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 4){
                            String str = "1,2,3,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 5){
                            String str = "1,2,3,4,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 6){
                            String str = "1,2,3,4,5,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 7){
                            String str = "1,2,3,4,5,6,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 8){
                            String str = "1,2,3,4,5,6,7,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 9){
                            String str = "1,2,3,4,5,6,7,8,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                    }
                    if (bankAdd == 1){
                        cardRandom5 = commonOutputCard(8, 2);
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 2){
                            String str = "9,10";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){
                            String str = "1,9,10,11";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 4){
                            String str = "1,2,9,10,11,12";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 5){
                            String str = "1,2,3,9,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 6){
                            String str = "1,2,3,4,9,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 7){
                            String str = "1,2,3,4,5,9,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 8){
                            String str = "1,2,3,4,5,6,9,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 9){
                            String str = "1,2,3,4,5,6,7,9,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }

                    }
                    if (bankAdd == 2){
                        cardRandom5 = commonOutputCard(7, 3);//3-9
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 3){
                            String str = "8,9";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 4){
                            String str = "1,8,9,10";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 5){
                            String str = "1,2,8,9,10,11";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 6){
                            String str = "1,2,3,8,9,10,11,12";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 7){
                            String str = "1,2,3,4,8,9,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 8){
                            String str = "1,2,3,4,5,8,9,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 9){
                            String str = "1,2,3,4,5,6,8,9,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }

                    }
                    if (bankAdd == 3){
                        cardRandom5 = commonOutputCard(13, 1);
                        if (cardRandom5 == 8){
                            map.put("5",cardRandom5);
                            return map;
                        }else{
                            String str = "1,2,3,4,5,7,8,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            if (cardRandom6 == 1){
                                String str1 = "5,6,7,9";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 2){
                                String str1 = "6,7,9";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 3){
                                String str1 = "7,9";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 4 || cardRandom6 == 5 ){
                                map.put("5",9);
                                return map;
                            }
                            if (cardRandom6 == 7){
                                String str1 = "1,2,3,4,5,6,7,9";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 8){
                                String str1 = "2,3,4,5,6,7,9,12,13";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 10 || cardRandom6 == 11 || cardRandom6 == 12 || cardRandom6 == 13){
                                String str1 = "4,5,6,7,9";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5",cardRandom5);
                                return map;
                            }
                        }
                    }
                    if (bankAdd == 4){
                        cardRandom5 = commonOutputCard(13, 1);//闲家补的牌是1.8.9.10的话，庄家不补牌
                        if (2 <= cardRandom5 && cardRandom5 <= 7){
                            String str = "1,2,6,7,8,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            if (cardRandom6 == 1){
                                String str1 = "6,7";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 2){
                                String str1 = "7";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 6 || cardRandom6 == 7){
                                String str1 = "2,3,4,5,6,7";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 8){
                                String str1 = "3,4,5,6,7,";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 9){
                                String str1 = "4,5,6,7";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 10 || cardRandom6 == 11 || cardRandom6 == 12 || cardRandom6 == 13){
                                String str1 = "5,6,7";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5",cardRandom5);
                                return map;
                            }
                        }else{//闲家补的牌是1.8.9.10的话，庄家不补牌
                            String str = "8,9";
                            cardRandom5 = outRandomNumByStr(str);
                            map.put("5", cardRandom5);
                            return map;
                        }

                    }
                    if (bankAdd == 5){
                        cardRandom5 = commonOutputCard(13, 1);//4.5.6.7
                        map.put("5", cardRandom5);
                        if (4 <= cardRandom5 && cardRandom5 <= 7){
                            if (cardRandom5 == 4){
                                String str = "5,6,7,8";
                                cardRandom6 = outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 5){
                                String str = "5,6,7,8,9";
                                cardRandom6 = outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 6){
                                String str = "5,6,7,8,9,10,11,12,13";
                                cardRandom6 = outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 7){
                                String str = "1,5,6,7,8,9,10,11,12,13";
                                cardRandom6 = outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                        }else{//闲家补的牌是1.8.9.10的话，庄家不补牌
                            String str = "8,9";
                            cardRandom5 = outRandomNumByStr(str);
                            map.put("5", cardRandom5);
                            return map;
                        }

                    }
                    if (bankAdd == 6){
                        cardRandom5 = commonOutputCard(13, 1);//6.7
                        map.put("5", cardRandom5);
                        if (6 <= cardRandom5 && cardRandom5 <= 7){
                                String str = "4,5,6,7,8,9,10,11,12,13";
                                cardRandom6 = outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                        }else{//1.2.3.4.5.8.9.10
                            String str = "8,9";
                            cardRandom5 = outRandomNumByStr(str);
                            map.put("5", cardRandom5);
                            return map;
                        }
                    }
                }
                if (playAdd == 1){//闲的和为1
                    if (bankAdd == 0){
                        String str1 = "1,2,3,4,5,6,7,8,10,11,12,13";
                        cardRandom5 = outRandomNumByStr(str1);
                        map.put("5",cardRandom5);
                        if (cardRandom5 == 1){
                            String str = "1,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 2){
                            String str = "1,2,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){
                            String str = "1,2,3,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 4){
                            String str = "1,2,3,4,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 5){
                            String str = "1,2,3,4,5,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 6){
                            String str = "1,2,3,4,5,6,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 7){
                            String str = "1,2,3,4,5,6,7,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 8){
                            String str = "1,2,3,4,5,6,7,8,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                    }
                    if (bankAdd == 1){
                        cardRandom5 = commonOutputCard(8, 2);
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 2){
                            String str = "9,10";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){
                            String str = "1,9,10,11";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 4){
                            String str = "1,2,9,10,11,12";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 5){
                            String str = "1,2,3,9,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 6){
                            String str = "1,2,3,4,9,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 7){
                            String str = "1,2,3,4,5,9,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 8){
                            String str = "1,2,3,4,5,6,9,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 9){
                            String str = "1,2,3,4,5,6,7,9,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }

                    }
                    if (bankAdd == 2){
                        cardRandom5 = commonOutputCard(7, 3);//3-9
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 3){
                            String str = "8,9";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 4){
                            String str = "1,8,9,10";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 5){
                            String str = "1,2,8,9,10,11";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 6){
                            String str = "1,2,3,8,9,10,11,12";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 7){
                            String str = "1,2,3,4,8,9,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 8){
                            String str = "1,2,3,4,5,8,9,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 9){
                            String str = "1,2,3,4,5,6,8,9,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }

                    }
                    if (bankAdd == 3){
                        cardRandom5 = commonOutputCard(13, 1);
                        if (cardRandom5 == 8){
                            map.put("5",cardRandom5);
                            return map;
                        }else{
                            String str = "1,2,3,4,5,7,8,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            if (cardRandom6 == 1){
                                String str1 = "5,6,7,9";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 2){
                                String str1 = "6,7,9";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 3){
                                String str1 = "7,9";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 4 || cardRandom6 == 5 ){
                                map.put("5",9);
                                return map;
                            }
                            if (cardRandom6 == 7){
                                String str1 = "1,2,3,4,5,6,7,9";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 8){
                                String str1 = "2,3,4,5,6,7,9,12,13";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 10 || cardRandom6 == 11 || cardRandom6 == 12 || cardRandom6 == 13){
                                String str1 = "4,5,6,7,9";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5",cardRandom5);
                                return map;
                            }
                        }
                    }
                    if (bankAdd == 4){
                        cardRandom5 = commonOutputCard(13, 1);//闲家补的牌是1.8.9.10的话，庄家不补牌
                        if (2 <= cardRandom5 && cardRandom5 <= 7){
                            String str = "1,2,6,7,8,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            if (cardRandom6 == 1){
                                String str1 = "6,7";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 2){
                                String str1 = "7";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 6 || cardRandom6 == 7){
                                String str1 = "2,3,4,5,6,7";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 8){
                                String str1 = "3,4,5,6,7,";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 9){
                                String str1 = "4,5,6,7";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5", cardRandom5);
                                return map;
                            }
                            if (cardRandom6 == 10 || cardRandom6 == 11 || cardRandom6 == 12 || cardRandom6 == 13){
                                String str1 = "5,6,7";
                                cardRandom5 = outRandomNumByStr(str1);
                                map.put("5",cardRandom5);
                                return map;
                            }
                        }else{//闲家补的牌是1.8.9.10的话，庄家不补牌
                            String str = "8,9";
                            cardRandom5 = outRandomNumByStr(str);
                            map.put("5", cardRandom5);
                            return map;
                        }

                    }
                    if (bankAdd == 5){
                        cardRandom5 = commonOutputCard(13, 1);//4.5.6.7
                        map.put("5", cardRandom5);
                        if (4 <= cardRandom5 && cardRandom5 <= 7){
                            if (cardRandom5 == 4){
                                String str = "5,6,7,8";
                                cardRandom6 = outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 5){
                                String str = "5,6,7,8,9";
                                cardRandom6 = outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 6){
                                String str = "5,6,7,8,9,10,11,12,13";
                                cardRandom6 = outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 7){
                                String str = "1,5,6,7,8,9,10,11,12,13";
                                cardRandom6 = outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                        }else{//闲家补的牌是1.8.9.10的话，庄家不补牌
                            String str = "8,9";
                            cardRandom5 = outRandomNumByStr(str);
                            map.put("5", cardRandom5);
                            return map;
                        }

                    }
                    if (bankAdd == 6){
                        cardRandom5 = commonOutputCard(13, 1);//6.7
                        map.put("5", cardRandom5);
                        if (6 <= cardRandom5 && cardRandom5 <= 7){
                            String str = "4,5,6,7,8,9,10,11,12,13";
                            cardRandom6 = outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }else{//1.2.3.4.5.8.9.10
                            String str = "8,9";
                            cardRandom5 = outRandomNumByStr(str);
                            map.put("5", cardRandom5);
                            return map;
                        }
                    }
                }
                if (playAdd == 2){//
                    String str = "1,2,3,4,5,6,7,9,10,11,12,13";//闲家必须要大于0
                    cardRandom5 = outRandomNumByStr(str);
                }
                if (playAdd == 3){//
                    String str = "1,2,3,4,5,6,8,9,10,11,12,13";//闲家必须要大于0
                    cardRandom5 = outRandomNumByStr(str);
                }
                if (playAdd == 4){//
                    String str = "1,2,3,4,5,7,8,9,10,11,12,13";//闲家必须要大于0
                    cardRandom5 = outRandomNumByStr(str);
                }
                if (playAdd == 5){//
                    String str = "1,2,3,4,6,7,8,9,10,11,12,13";//闲家必须要大于0
                    cardRandom5 = outRandomNumByStr(str);
                }
                playAdd = playAdd + cardRandom5;//闲家补牌求和
                playAdd = specialHandleRandom2(playAdd);//两个牌的和可能是0点
                map.put("5",cardRandom5);
            }




        }
        if (bankAdd >= 0 && bankAdd <= 2){
            if (playAdd > bankAdd){  //庄可以补10,11,12,13
                cardRandom6 = commonOutputCard(4,10);
                map.put("6",cardRandom6);
                return map;
            }
            if (playAdd == bankAdd){//
                if (bankAdd == 1){
                    cardRandom6 = 9;
                    map.put("6",cardRandom6);
                    return map;
                }
                if (bankAdd == 2){//8,9
                    cardRandom6 = commonOutputCard(2,8);
                    map.put("6",cardRandom6);
                    return map;
                }
            }
            if (playAdd < bankAdd){// playAdd = 1, bankAdd = 2
                cardRandom6 = 8;
                map.put("6",cardRandom6);
                return map;
            }
        }

        //闲家如不增牌(6,7)，庄家0,1,2,3,4,5点必须增牌，6点不得增牌
        if (playAdd < 0){
            if (0 <= bankAdd && bankAdd <= 5){
                //闲家不增牌6,7
                if (bankAdd == 0){//
                    String str = "1,2,3,4,5,10,11,12,13";//9个；庄家可以开这9种
                    cardRandom6 = outRandomNumByStr(str);
                    map.put("6",cardRandom6);
                    return map;
                }
                if (bankAdd == 1){//
                    String str = "1,2,3,4,10,11,12,13";//8个；庄家可以开这9种
                    cardRandom6 = outRandomNumByStr(str);
                    map.put("6",cardRandom6);
                    return map;
                }
                if (bankAdd == 2){//
                    String str = "1,2,3,10,11,12,13";//7个；庄家可以开这9种
                    cardRandom6 = outRandomNumByStr(str);
                    map.put("6",cardRandom6);
                    return map;
                }
                if (bankAdd == 3){//
                    String str = "1,2,10,11,12,13";//6个；庄家可以开这9种
                    cardRandom6 = outRandomNumByStr(str);
                    map.put("6",cardRandom6);
                    return map;
                }
                if (bankAdd == 4){//
                    String str = "1,10,11,12,13";//5个；庄家可以开这9种
                    cardRandom6 = outRandomNumByStr(str);
                    map.put("6",cardRandom6);
                    return map;
                }
                if (bankAdd == 5){//
                    String str = "10,11,12,13";//4个；庄家可以开这9种
                    cardRandom6 = outRandomNumByStr(str);
                    map.put("6",cardRandom6);
                    return map;
                }
            }else if (bankAdd == 6){

            }

        }

        if (cardRandom5 != 8){
            if (bankAdd == 3){
                cardRandom6 = outputCard();
                bankAdd = bankAdd + cardRandom6;
                bankAdd = specialHandleRandom2(bankAdd);//两个牌的和可能是0点
                if (playAdd > bankAdd){
                    map.put("6",cardRandom6);
                }
                if (playAdd == bankAdd){
                    cardRandom6 = cardRandom6 - 1;
                }
                if (playAdd < bankAdd){//playAdd 不可能为0,最小是1
                    if (playAdd == 1){//闲要赢,庄补的牌只能是7
                        cardRandom6 = 7;
                    }
                    if (playAdd == 2){//闲要赢,庄补的牌只能是7,8
                        String str = "7,8";
                        int index = outRandomNumber1(str.length());
                        cardRandom6 = Integer.parseInt(str.split(",")[index]);//庄家补牌
                    }
                    if (playAdd == 3){//闲要赢,庄补的牌只能是7,8,9
                        String str = "7,8,9";
                        int index = outRandomNumber1(str.length());
                        cardRandom6 = Integer.parseInt(str.split(",")[index]);//庄家补牌
                    }
                    if (playAdd == 4){//闲要赢,庄补的牌只能是7,8,9,10,11,12,13
                        String str = "7,8,9,10,11,12,13";
                        int index = outRandomNumber1(str.length());
                        cardRandom6 = Integer.parseInt(str.split(",")[index]);//庄家补牌
                    }
                    if (playAdd == 5){//闲要赢,庄补的牌只能是1,7,8,9,10,11,12,13
                        String str = "1,7,8,9,10,11,12,13";
                        int index = outRandomNumber1(str.length());
                        cardRandom6 = Integer.parseInt(str.split(",")[index]);//庄家补牌
                    }
                }
            }
        }else{

        }
        if (bankAdd == 4 && 1 < cardRandom5 && cardRandom5 < 8){//闲家第三张牌0、1、8、9庄家不补牌
            cardRandom6 = outputCard();//庄家补牌
            bankAdd = bankAdd + cardRandom6;
            bankAdd = specialHandleRandom2(bankAdd);//两个牌的和可能是0点
        }
        if (bankAdd == 5 && 3 < cardRandom5 && cardRandom5 < 8){//闲家第三张牌0、1、2、3、8、9庄家不补牌
            cardRandom6 = outputCard();//庄家补牌
            bankAdd = bankAdd + cardRandom6;
            bankAdd = specialHandleRandom2(bankAdd);//两个牌的和可能是0点
        }
        if (bankAdd == 6 && (5 < cardRandom5 && cardRandom5 < 8)){//闲家第三张牌0、1、2、3、8、9庄家不补牌
            cardRandom6 = outputCard();//庄家补牌
            bankAdd = bankAdd + cardRandom6;
            bankAdd = specialHandleRandom2(bankAdd);//两个牌的和可能是0点
        }
        int result = compare(bankAdd, playAdd);
        if (result == 1){
            map.put("5",cardRandom5);
            map.put("6",cardRandom6);
        }
        if (result == 2){

        }
        if (result == 3){

        }
        return null;

    }

    public static Integer specialHandleRandom2(int colorRandom){
        if (colorRandom >= 10) {
            colorRandom = colorRandom - 10;
            return colorRandom;
        }
        return colorRandom;
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
        int index = outRandomNumber1(str.length());
        return Integer.parseInt(str.split(",")[index]);
    }

}
