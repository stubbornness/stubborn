package com.stubborn.java.strategyPattern.bjlgame;

import java.util.Map;

/**
 * @author 丁少东
 * @create 2018-12-06 上午9:24
 **/
public class BjlOpenAwardDemo1_5 implements BjlOpenAwardInterface {

    //闲赢＋庄对
    public  Map<String,Integer> outputCard(){
        Map<String, Integer> map = GameUtil.outputCard( 1,  0);
        int cardRandom1 = map.get("1");
        int cardRandom2 = map.get("2");
        int cardRandom3 = map.get("3");
        int cardRandom4 = map.get("4");
        int playAdd = map.get("playAdd");
        int bankAdd = map.get("bankAdd");

        if(bankAdd == 9 || bankAdd == 8 || playAdd == 9 || playAdd == 8){
            int result = GameUtil.compare(bankAdd, playAdd);
            if (result == 1){//闲
                return map;
            }else {
                return newOutputRandom(map);
            }
        }

        int cardRandom5 = 0;//闲家补牌
        int cardRandom6 = 0;//庄家补牌
        if (playAdd >= 0 && playAdd <= 5){//  一闲家补牌
                if (playAdd == 0){
                    if (bankAdd == 0){
                        cardRandom5 = GameUtil.commonOutputCard(9,1);
                        map.put("5",cardRandom5);
                        if (cardRandom5 == 1){
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 2){
                            String str = "1,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){
                            String str = "1,2,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 4){
                            String str = "1,2,3,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 5){
                            String str = "1,2,3,4,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 6){
                            String str = "1,2,3,4,5,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 7){
                            String str = "1,2,3,4,5,6,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 8){
                            String str = "1,2,3,4,5,6,7,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 9){
                            String str = "1,2,3,4,5,6,7,8,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                    }
                    if (bankAdd == 2){
                        cardRandom5 = GameUtil.commonOutputCard(9, 1);//
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 1){//1
                            map.put("6", 8);
                            return map;
                        }
                        if (cardRandom5 == 2){//2
                            String str = "8,9";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){
                            String str = "8,9,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 4){
                            String str = "1,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 5){
                            String str = "1,2,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 6){
                            String str = "1,2,3,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 7){
                            String str = "1,2,3,4,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 8){
                            String str = "1,2,3,4,5,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 9){
                            String str = "1,2,3,4,5,6,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }

                    }
                    if (bankAdd == 4){
                        cardRandom5 = GameUtil.commonOutputCard(13, 1);//闲家补的牌是1.8.9.10,11,12,13的话，庄家不补牌
                        map.put("5", cardRandom5);
                        if (2 <= cardRandom5 && cardRandom5 <= 7){
                            if (cardRandom5 == 2){
                                String str = "6,7";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 3){
                                String str = "6,7,8";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 4){
                                String str = "6,7,8,9";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 5){
                                String str = "6,7,8,9,10,11,12,13";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 6){
                                String str = "1,6,7,8,9,10,11,12,13";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 7){
                                String str = "1,2,6,7,8,9,10,11,12,13";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                        }else{//闲家补的牌是1.8.9.10,11,12,13的话，庄家不补牌
                            String str = "8,9";
                            cardRandom5 = GameUtil.outRandomNumByStr(str);
                            map.put("5", cardRandom5);
                            return map;
                        }

                    }
                    if (bankAdd == 6){
                        cardRandom5 = GameUtil.commonOutputCard(13, 1);//6.7
                        map.put("5", cardRandom5);
                        if (6 <= cardRandom5 && cardRandom5 <= 7){
                            String str = "4,5,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }else{//1.2.3.4.5.8.9.10,11,12,13
                            String str = "8,9";
                            cardRandom5 = GameUtil.outRandomNumByStr(str);
                            map.put("5", cardRandom5);
                            return map;
                        }
                    }
                }

//第二种情况
                if (playAdd == 1){//闲的和为1
                    if (bankAdd == 0){//闲的和为1庄和是0
                        String str1 = "1,2,3,4,5,6,7,8,10,11,12,13";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//1
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 1){//2
                            String str = "1,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 2){//3
                            String str = "1,2,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){//4
                            String str = "1,2,3,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 4){//5
                            String str = "1,2,3,4,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 5){//6
                            String str = "1,2,3,4,5,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 6){//7
                            String str = "1,2,3,4,5,6,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 7){//8
                            String str = "1,2,3,4,5,6,7,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 8){//9
                            String str = "1,2,3,4,5,6,7,8,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                    }
                    if (bankAdd == 2){//闲的和是1，庄家的和是2
                        String str1 = "1,2,3,4,5,6,7,8,10,11,12,13";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5",cardRandom5);
                        if(cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){
                            map.put("6", 8);
                            return map;
                        }
                        if (cardRandom5 == 1){//2
                            String str = "8,9";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 2){//3
                            String str = "8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){//4
                            String str = "1,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 4){//5
                            String str = "1,2,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 5){//6
                            String str = "1,2,3,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 6){//7
                            String str = "1,2,3,4,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 7){//8
                            String str = "1,2,3,4,5,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 8){//9
                            String str = "1,2,3,4,5,6,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }

                    }

                    if (bankAdd == 4){
                        cardRandom5 = GameUtil.commonOutputCard(13, 1);//闲家补的牌是1.8.9.10,11,12,13的话，庄家不补牌
                        map.put("5", cardRandom5);
                        if (2 <= cardRandom5 && cardRandom5 <= 7){
                            if (cardRandom5 == 2){//3
                                String str = "6,7,8";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 3){//4
                                String str = "6,7,8,9";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 4){//5
                                String str = "6,7,8,9,10,11,12,13";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 5){//6
                                String str = "1,6,7,8,9,10,11,12,13";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 6){//7
                                String str = "1,2,6,7,8,9,10,11,12,13";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 7){//8
                                String str = "1,2,3,6,7,8,9,10,11,12,13";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                        }else{//闲家补的牌是1.8.9.10,11,12,13的话，庄家不补牌
                            map.put("5", 8);
                            return map;
                        }
                    }
                    if (bankAdd == 6){
                        cardRandom5 = GameUtil.commonOutputCard(13, 1);//6.7
                        map.put("5", cardRandom5);
                        if (6 <= cardRandom5 && cardRandom5 <= 7){
                            String str = "4,5,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }else{//1.2.3.4.5.8.9.10,11,12,13
                            String str = "8";
                            cardRandom5 = GameUtil.outRandomNumByStr(str);
                            map.put("5", cardRandom5);
                            return map;
                        }
                    }
                }

                //第三种情况
                if (playAdd == 2){//闲和为2
                    if (bankAdd == 0){//闲的和为2庄和是0
                        String str1 = "1,2,3,4,5,6,7,9,10,11,12,13";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);//[1,9]
                        if (cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//2
                            String str = "1,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 1){//3
                            String str = "1,2,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 2){//4
                            String str = "1,2,3,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){//5
                            String str = "1,2,3,4,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 4){//6
                            String str = "1,2,3,4,5,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 5){//7
                            String str = "1,2,3,4,5,6,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 6){//8
                            String str = "1,2,3,4,5,6,7,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 7){//9
                            String str = "1,2,3,4,5,6,7,8,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 9){//1
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                    }
                    if (bankAdd == 2){//闲的和是2，庄家的和是2
                        String str1 = "1,2,3,4,5,6,7,9,10,11,12,13";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5",cardRandom5);
                        if(cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//2
                            String str = "8,9";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;                        }
                        if (cardRandom5 == 1){//3
                            String str = "8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 2){//4
                            String str = "1,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){//5
                            String str = "1,2,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 4){//6
                            String str = "1,2,3,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 5){//7
                            String str = "1,2,3,4,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 6){//8
                            String str = "1,2,3,4,5,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 7){//9
                            String str = "1,2,3,4,5,6,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 9){//1
                            map.put("6", 8);//0=8+2
                            return map;

                        }

                    }

                    if (bankAdd == 4){//playAdd = 2, bankAdd = 4;
                        cardRandom5 = GameUtil.commonOutputCard(6, 2);//闲家补的牌是1.8.9.10,11,12,13的话，庄家不补牌
                        map.put("5", cardRandom5);//2-7
                        if (cardRandom5 == 2){//4
                            String str = "6,7,8,9";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){//5
                            String str = "6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 4){//6
                            String str = "1,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 5){//7
                            String str = "1,2,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 6){//8
                            String str = "1,2,3,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 7){//9
                            String str = "1,2,3,4,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                    }
                    if (bankAdd == 6){
                        cardRandom5 = GameUtil.commonOutputCard(3, 5);//5.6.7
                        map.put("5", cardRandom5);
                        if (6 <= cardRandom5 && cardRandom5 <= 7){//8,9
                            String str = "1,4,5,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }else{//1.2.3.4.5.8.9.10,11,12,13
                            map.put("5", 5);//5+2
                            return map;
                        }
                    }
                }


//第四种情况
                if (playAdd == 3){//当闲对的和是3的时候
                    if (bankAdd == 0){//闲的和为3庄和是0
                        String str1 = "1,2,3,4,5,6,8,9,10,11,12,13";//闲要赢补牌不能为7
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//3
                            String str = "1,2,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 1){//4
                            String str = "1,2,3,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 2){//5
                            String str = "1,2,3,4,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){//6
                            String str = "1,2,3,4,5,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 4){//7
                            String str = "1,2,3,4,5,6,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 5){//8
                            String str = "1,2,3,4,5,6,7,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }
                        if (cardRandom5 == 6){//9
                            String str = "1,2,3,4,5,6,7,8,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 8){//1
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 9){//2
                            String str = "1,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                    }
                    if (bankAdd == 2){//闲的和是3，庄家的和是2
                        String str1 = "1,2,3,4,5,6,8,9,10,11,12,13";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5",cardRandom5);
                        if(cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//3
                            String str = "8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 1){//4
                            String str = "1,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 2){//5
                            String str = "1,2,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){//6
                            String str = "1,2,3,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 4){//7
                            String str = "1,2,3,4,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 5){//8
                            String str = "1,2,3,4,5,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 6){//9
                            String str = "1,2,3,4,5,6,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 8){//1
                            map.put("6", 8);
                            return map;
                        }
                        if (cardRandom5 == 9){//2
                            String str = "8,9";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;

                        }

                    }

                    if (bankAdd == 4){
                        cardRandom5 = GameUtil.commonOutputCard(5,2);//闲家补的牌是1.8.9.10,11,12,13的话，庄家不补牌
                        map.put("5", cardRandom5);//[2,6]
                        if (cardRandom5 == 2){//5
                            String str = "6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){//6
                            String str = "1,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 4){//7
                            String str = "1,2,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 5){//8
                            String str = "1,2,3,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 6){//9
                            String str = "1,2,3,4,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                    }
                    if (bankAdd == 6){
                        String str1 = "4,5,6";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        if (6 <= cardRandom5 && cardRandom5 <= 7){
                            String str = "4,5,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }//1.2.3.4.5.8.9.10,11,12,13
                        return map;
                    }
                }

            //第五种情况
            if (playAdd == 4){//playAdd = 4,
                if (bankAdd == 0){//闲的和为4庄和是0
                    String str1 = "1,2,3,4,5,7,8,9,10,11,12,13";//闲要赢补牌不能为6
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5", cardRandom5);
                    if (cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//4
                        String str = "1,2,3,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 1){//5
                        String str = "1,2,3,4,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 2){//6
                        String str = "1,2,3,4,5,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 3){//7
                        String str = "1,2,3,4,5,6,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 4){//8
                        String str = "1,2,3,4,5,6,7,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 5){//9
                        String str = "1,2,3,4,5,6,7,8,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 7){//1
                        String str = "10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 8){//2
                        String str = "1,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 9){//3
                        String str = "1,2,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                }

                if (bankAdd == 2){//闲的和是4，庄家的和是2
                    String str1 = "1,2,3,4,5,7,8,9,10,11,12,13";
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5",cardRandom5);
                    if(cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//4
                        String str = "1,8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 1){//5
                        String str = "1,2,8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 2){//6
                        String str = "1,2,3,8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 3){//7
                        String str = "1,2,3,4,8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 4){//8
                        String str = "1,2,3,4,5,8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 5){//9
                        String str = "1,2,3,4,5,6,8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 7){//1
                        map.put("6", 8);
                        return map;
                    }
                    if (cardRandom5 == 8){//2
                        String str = "8,9";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 9){//3
                        String str = "8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                }

                if (bankAdd == 4){
                    String str1 = "1,2,3,4,5,7";//闲家不能补6
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);//闲家补的牌是1.8.9.10,11,12,13的话，庄家不补牌
                    map.put("5", cardRandom5);//[2,6]
                    if (cardRandom5 >=2 && cardRandom5 <=7){
                        if (cardRandom5 == 2){//6
                            String str = "1,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){//7
                            String str = "1,2,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 4){//8
                            String str = "1,2,3,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 5){//9
                            String str = "1,2,3,4,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 7){//1
                            map.put("6", 6);
                            return map;
                        }
                    }else{
                        map.put("5", 1);
                        return map;

                    }
                }

                if (bankAdd == 6){
                    String str1 = "1,2,3,4,5,7,8,9";
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5", cardRandom5);
                    if (cardRandom5 == 7){
                        map.put("6", 4);
                        return map;
                    }else{//1.2.3.4.5.8.9.10,11,12,13
                        String str = "3,4,5";
                        cardRandom5 = GameUtil.outRandomNumByStr(str);
                        map.put("5", cardRandom5);
                        return map;
                    }
                }
            }



            //第五种情况
            if (playAdd == 5){//
                if (bankAdd == 0){//闲的和为5庄和是0
                    String str1 = "1,2,3,4,6,7,8,9,10,11,12,13";//闲要赢补牌不能为5
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5", cardRandom5);
                    if (cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//5
                        String str = "1,2,3,4,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 1){//6
                        String str = "1,2,3,4,5,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 2){//7
                        String str = "1,2,3,4,5,6,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 3){//8
                        String str = "1,2,3,4,5,6,7,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 4){//9
                        String str = "1,2,3,4,5,6,7,8,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 6){//1
                        String str = "10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 7){//2
                        String str = "1,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 8){//3
                        String str = "1,2,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 9){//4
                        String str = "1,2,3,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                }

                if (bankAdd == 2){//闲的和是5，庄家的和是2
                    String str1 = "1,2,3,4,6,7,8,9,10,11,12,13";
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5",cardRandom5);
                    if(cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//5
                        String str = "1,2,8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 1){//6
                        String str = "1,2,3,8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 2){//7
                        String str = "1,2,3,4,8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 3){//8
                        String str = "1,2,3,4,5,8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 4){//9
                        String str = "1,2,3,4,5,6,8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 6){//1
                        map.put("6", 8);
                        return map;
                    }
                    if (cardRandom5 == 7){//2
                        String str = "8,9";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 8){//3
                        String str = "8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 9){//4
                        String str = "1,8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                }

                if (bankAdd == 4){
                    String str1 = "1,2,3,4,6,7,10,11,12,13";//闲家不能补5
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);//闲家补的牌是1.8.9.10,11,12,13的话，庄家不补牌
                    map.put("5", cardRandom5);//[2,6]
                    if (cardRandom5 >=2 && cardRandom5 <=7){
                        if (cardRandom5 == 2){//7
                            String str = "1,2,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){//8
                            String str = "1,2,3,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 4){//9
                            String str = "1,2,3,4,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 6){//1
                            map.put("6", 6);
                            return map;
                        }
                        if (cardRandom5 == 7){//2
                            String str = "6,7";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                    }
                    //1,10,11,12,13
                    return map;

                }

                if (bankAdd == 6){
                    String str1 = "2,3,4,6,7";
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5", cardRandom5);
                    if (cardRandom5 == 6){
                        map.put("6", 4);
                        return map;
                    }
                    if (cardRandom5 == 7){
                        String str = "4,5";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6", cardRandom6);
                        return map;
                    }
                    return map;
                }
            }
        }else{//playAdd = 6,7 闲不补牌
            if (playAdd == 6){// 庄不补牌
                if (bankAdd == 6){ //闲不补牌
                    map = dealPlayWin(map);
                    return map;
                }
                if (bankAdd == 0){//闲的和为6庄和是0
                    String str = "1,2,3,4,5,10,11,12,13";
                    cardRandom6 = GameUtil.outRandomNumByStr(str);
                    map.put("6",cardRandom6);
                    return map;
                }
                if (bankAdd == 2){//闲的和是6，庄家的和是2
                    String str = "1,2,3,10,11,12,13";
                    cardRandom6 = GameUtil.outRandomNumByStr(str);
                    map.put("6",cardRandom6);
                    return map;
                }
                if (bankAdd == 4){
                    String str = "1,10,11,12,13";
                    cardRandom6 = GameUtil.outRandomNumByStr(str);
                    map.put("6",cardRandom6);
                    return map;
                }
            }

            if (playAdd == 7){// 闲家不补牌
                if (bankAdd == 6){ // 庄家不补牌
                    return map;
                }
                if (bankAdd == 0){//闲的和为7庄和是0
                    String str = "1,2,3,4,5,10,11,12,13";
                    cardRandom6 = GameUtil.outRandomNumByStr(str);
                    map.put("6",cardRandom6);
                    return map;
                }
                if (bankAdd == 2){//闲的和是6，庄家的和是2
                    String str = "1,2,3,10,11,12,13";
                    cardRandom6 = GameUtil.outRandomNumByStr(str);
                    map.put("6",cardRandom6);
                    return map;
                }
                if (bankAdd == 4){
                    String str = "1,10,11,12,13";
                    cardRandom6 = GameUtil.outRandomNumByStr(str);
                    map.put("6",cardRandom6);
                    return map;
                }
            }
        }

        return null;

    }

    private  Map<String,Integer> newOutputRandom(Map<String, Integer> map) {
        map.put("1", 9);
        map.put("3", 9);
        String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";
        String str2 = "10,11,12,13,1,4,5,6,2,1,13,7,3,5";
        return GameUtil.outMapRandomNumByStr("2", "4", str1, str2, map);
    }

    public  Map<String, Integer> dealPlayWin(Map<String, Integer> map){
        String st = "0,2,4";
        int index = GameUtil.outRandomNumByStr(st);
        int cardRandom6 = 0;
        if (index == 0){
            //闲的和为7庄和是0
            String str1 = "10,11,12,13";
            String str2 = "10,11,12,13";
            map = GameUtil.outMapRandomNumByStr("2", "4",str1, str2, map);
            String str = "1,2,3,4,5,10,11,12,13";
            cardRandom6 = GameUtil.outRandomNumByStr(str);
            map.put("6",cardRandom6);
            return map;
        }
        if (index == 2){
            //闲的和为7庄和是2
            map.put("2",1);
            map.put("4",1);
            String str = "1,2,3,10,11,12,13";
            cardRandom6 = GameUtil.outRandomNumByStr(str);
            map.put("6",cardRandom6);
            return map;
        }
        if (index == 4){
            //闲的和为7庄和是4
            map.put("2",2);
            map.put("4",2);
            String str = "1,10,11,12,13";
            cardRandom6 = GameUtil.outRandomNumByStr(str);
            map.put("6",cardRandom6);
            return map;
        }
        return null;
    }


}

