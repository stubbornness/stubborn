package com.stubborn.java.strategyPattern.bjlgame;

import java.util.Map;

/**
 * @author 丁少东
 * @create 2018-12-06 上午9:24
 **/
public class BjlOpenAwardDemo1_4 implements BjlOpenAwardInterface {

    public  Map<String,Integer> outputCard(){

        Map<String, Integer> map = GameUtil.outputCard( 0,  1);
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
            }
            if (result == 3){//和
                map.put("1",cardRandom1);
                map.put("3",cardRandom3);
                if (10 <= cardRandom4 && cardRandom4 <= 13){
                    cardRandom2 = GameUtil.commonOutputCard(7, 1);
                }else{
                    if (cardRandom4 == 1){
                        cardRandom2 = GameUtil.commonOutputCard(6, 1);
                    }else{
                        cardRandom4 = cardRandom4 - 1;
                    }
                }
                map.put("2",cardRandom2);
                map.put("4",cardRandom4);
                return map;
            }
            if (result == 2){//重新开特定的牌
                return newOutputRandom(map);
            }
        }

        int cardRandom5 = 0;//闲家补牌
        int cardRandom6 = 0;//庄家补牌
        if (playAdd >= 0 && playAdd <= 5){//  一闲家补牌(闲家有闲对：０，２，４，６)
            if (bankAdd == 7){// 庄不补牌
                if (playAdd == 0){
                    String str = "8,9";
                    cardRandom5 = GameUtil.outRandomNumByStr(str);
                }
                if (playAdd == 2){
                    String str = "6,7";
                    cardRandom5 = GameUtil.outRandomNumByStr(str);
                }
                if (playAdd == 4){
                    String str = "4,5";
                    cardRandom5 = GameUtil.outRandomNumByStr(str);
                }
                map.put("5",cardRandom5);
                return map;
            }else{
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

                    if (bankAdd == 1){//闲和是0，庄和是1
                        cardRandom5 = GameUtil.commonOutputCard(9, 1);//[1,9]
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 1){
                            map.put("6",9);
                            return map;
                        }
                        if (cardRandom5 == 2){
                            String str = "9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){
                            String str = "1,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 4){
                            String str = "1,2,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 5){
                            String str = "1,2,3,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 6){
                            String str = "1,2,3,4,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 7){
                            String str = "1,2,3,4,5,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 8){
                            String str = "1,2,3,4,5,6,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 9){
                            String str = "1,2,3,4,5,6,7,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }

                    }
                    if (bankAdd == 2){//闲和是0，庄和是1
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
                    if (bankAdd == 3){//playAdd = 0 , bankAdd = 3
                        cardRandom5 = GameUtil.commonOutputCard(9, 1);//1到9
                        map.put("5",cardRandom5);
                        if (cardRandom5 == 8){
                            return map;
                        }else{
                            if (cardRandom5 == 1){
                                map.put("6", 7);
                                return map;
                            }
                            if (cardRandom5 == 2){
                                String str = "7,8";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 3){
                                String str = "7,8,9";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 4){
                                String str = "7,8,9,10,11,12,13";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 5){
                                String str = "1,7,8,9,10,11,12,13";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 6){
                                String str = "1,2,7,8,9,10,11,12,13";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 7){
                                String str = "1,2,3,7,8,9,10,11,12,13";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 9){
                                String str = "1,2,3,4,5,7,8,9,10,11,12,13";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
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
                    if (bankAdd == 5){
                        cardRandom5 = GameUtil.commonOutputCard(13, 1);//4.5.6.7
                        map.put("5", cardRandom5);
                        if (4 <= cardRandom5 && cardRandom5 <= 7){
                            if (cardRandom5 == 4){
                                String str = "5,6,7,8";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 5){
                                String str = "5,6,7,8,9";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 6){
                                String str = "5,6,7,8,9,10,11,12,13";
                                cardRandom6 = GameUtil.outRandomNumByStr(str);
                                map.put("6", cardRandom6);
                                return map;
                            }
                            if (cardRandom5 == 7){
                                String str = "1,5,6,7,8,9,10,11,12,13";
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
                    if (bankAdd == 1){//闲和是2，庄和也是1的时候
                        String str1 = "1,2,3,4,5,6,7,9,10,11,12,13";//  闲的和不能是0
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5",cardRandom5);
                        if(cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){
                            String str = "9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;                        }
                        if (cardRandom5 == 1){//3
                            String str = "1,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 2){//4
                            String str = "1,2,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){//5
                            String str = "1,2,3,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 4){//6
                            String str = "1,2,3,4,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 5){//7
                            String str = "1,2,3,4,5,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 6){//8
                            String str = "1,2,3,4,5,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 7){//9
                            String str = "1,2,3,4,5,6,7,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 9){//9+2=1
                            map.put("6", 9);//1+9=0
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

                    //闲的和是2，庄家的和是3
                    if (bankAdd == 3){
                        String str1 = "1,2,3,4,5,6,7,9,10,11,12,13";//闲家不能补8
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        if(cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//2
                            String str = "7,8";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 1){//3
                            String str = "7,8,9";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 2){//4
                            String str = "7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 3){//5
                            String str = "1,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 4){//6
                            String str = "1,2,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 5){//7
                            String str = "1,2,3,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 6){//8
                            String str = "1,2,3,4,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 7){//9
                            String str = "1,2,3,4,5,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 9){//1
                            map.put("6", 7);
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
                    if (bankAdd == 5){
                        cardRandom5 = GameUtil.commonOutputCard(4, 4);//4.5.6.7
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 4){//6
                            String str = "5,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 5){//7
                            String str = "1,5,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 6){//8
                            String str = "1,2,5,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 7){//9
                            String str = "1,2,3,5,6,7,8,9,10,11,12,13";
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
                if (bankAdd == 1){//闲和是4，庄和也是1的时候
                    String str1 = "1,2,3,4,5,7,8,9,10,11,12,13";
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5", cardRandom5);//
                    if(cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){
                        String str = "1,2,9,10,11,12,13";//4
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 1){//5
                        String str = "1,2,3,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 2){//6
                        String str = "1,2,3,4,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 3){//7
                        String str = "1,2,3,4,5,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 4){//8
                        String str = "1,2,3,4,5,6,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 5){//9
                        String str = "1,2,3,4,5,6,7,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 7){//1
                        map.put("6", 9);
                        return map;
                    }
                    if (cardRandom5 == 8){//2
                        String str = "9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 9){//3
                        String str = "1,9,10,11,12,13";
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

                //闲的和是4，庄家的和是3
                if (bankAdd == 3){
                    String str1 = "1,2,3,4,5,7,9,10,11,12,13";//闲家不能补6,8
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5",cardRandom5);
                    if(cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){
                        String str = "7,8,9,10,11,12,13";//4
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6", cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 1){//5
                        String str = "1,7,8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6", cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 2){//6
                        String str = "1,2,7,8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6", cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 3){//7
                        String str = "1,2,3,7,8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6", cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 4){//8
                        String str = "1,2,3,4,7,8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6", cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 5){//9
                        String str = "1,2,3,4,5,7,8,9,10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6", cardRandom6);
                        return map;
                    }
                    if (cardRandom5 == 7){//1
                        map.put("6", 7);//0
                        return map;
                    }
                    if (cardRandom5 == 9){//2
                        String str = "7,8";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6", cardRandom6);
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

                if (bankAdd == 5){//闲的和是4，庄家的和是5
                    String str1 = "2,3,4,5,7";
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5", cardRandom5);
                    if (cardRandom5 >= 4 && cardRandom5 <= 7){
                        if (cardRandom5 == 4){//8
                            String str = "1,2,5,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 5){//9
                            String str = "1,2,3,5,6,7,8,9,10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 7){//1
                            map.put("6", 5);
                            return map;
                        }
                    }else{
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

        }}else{//playAdd = 6,7 闲不补牌
            if (playAdd == 6){// 庄不补牌
                if (bankAdd == 6 || bankAdd == 7){ //闲不补牌
                    map = dealPlayWin(map);
                    return map;
                }
                if (bankAdd == 0){//闲的和为6庄和是0
                    String str = "1,2,3,4,5,10,11,12,13";
                    cardRandom6 = GameUtil.outRandomNumByStr(str);
                    map.put("6",cardRandom6);
                    return map;
                }
                if (bankAdd == 1){//闲和是6，庄和也是1的时候
                    String str = "1,2,3,4,10,11,12,13";
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
                if (bankAdd == 3){
                    String str = "1,2,10,11,12,13";
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
                if (bankAdd == 5){
                    String str = "10,11,12,13";
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
        return GameUtil.outMapRandomNumByStr("2", "4" ,str1, str2, map);
    }

    private  Map<String,Integer> dealPlayWin(Map<String, Integer> map){
        int cardRandom6 = 0;
        int index = GameUtil.commonOutputCard(6, 0);
        if (index == 0){
            //闲的和为7庄和是0
            String str1 = "3,4,6,7,10,11,12,13";
            String str2 = "7,6,4,3,13,12,11,10";
            map = GameUtil.outMapRandomNumByStr("2", "4",str1, str2, map);
            String str = "1,2,3,4,5,10,11,12,13";
            cardRandom6 = GameUtil.outRandomNumByStr(str);
            map.put("6",cardRandom6);
            return map;
        }
        if (index == 1){
            //闲的和为7庄和是1
            String str1 = "1,1,1,1,4,5,6,7";
            String str2 = "10,11,12,13,7,6,5,4";
            map = GameUtil.outMapRandomNumByStr("2", "4", str1, str2, map);
            String str = "1,2,3,4,10,11,12,13";
            cardRandom6 = GameUtil.outRandomNumByStr(str);
            map.put("6",cardRandom6);
            return map;
        }
        if (index == 2){
            //闲的和为7庄和是2
            String str1 = "2,2,2,2,5,7";
            String str2 = "10,11,12,13,7,5";
            map = GameUtil.outMapRandomNumByStr("2", "4", str1, str2, map);
            String str = "1,2,3,10,11,12,13";
            cardRandom6 = GameUtil.outRandomNumByStr(str);
            map.put("6",cardRandom6);
            return map;
        }
        if (index == 3){
            //闲的和为7庄和是3
            String str1 = "3,3,3,3,6,7";
            String str2 = "10,11,12,13,7,6";
            map = GameUtil.outMapRandomNumByStr("2", "4",str1, str2, map);
            String str = "1,2,10,11,12,13";
            cardRandom6 = GameUtil.outRandomNumByStr(str);
            map.put("6",cardRandom6);
            return map;
        }
        if (index == 4){
            //闲的和为7庄和是4
            String str1 = "4,4,4,4";
            String str2 = "10,11,12,13";
            map = GameUtil.outMapRandomNumByStr("2", "4", str1, str2, map);
            String str = "1,10,11,12,13";
            cardRandom6 = GameUtil.outRandomNumByStr(str);
            map.put("6",cardRandom6);
            return map;
        }
        if (index == 5){
            //闲的和为7庄和是5
            String str1 = "5,5,5,5";
            String str2 = "10,11,12,13";
            map = GameUtil.outMapRandomNumByStr("2", "4",str1, str2, map);
            String str = "10,11,12,13";
            cardRandom6 = GameUtil.outRandomNumByStr(str);
            map.put("6",cardRandom6);
            return map;
        }
        return null;
    }

}

