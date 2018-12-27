package com.stubborn.game;

import java.util.Map;
import java.util.Random;

/**
 * @author 丁少东
 * @create 2018-12-25 下午6:59
 **/
public class BjlOpenAwardDemo3 {
    //和赢
    public static Map<String,Integer> openAwardEvent3(){
        Map<String, Integer> map = GameUtil.outputCard( 1,  1);
        int cardRandom1 = map.get("1");
        int cardRandom2 = map.get("2");
        int cardRandom3 = map.get("3");
        int cardRandom4 = map.get("4");
        int playAdd = map.get("playAdd");
        int bankAdd = map.get("bankAdd");

        if(bankAdd == 9 || bankAdd == 8 || playAdd == 9 || playAdd == 8){
            return GameUtil.outMapRandomNumByStr();
        }

        int cardRandom5 = 0;//闲家补牌
        int cardRandom6 = 0;//庄家补牌
        if (playAdd >= 0 && playAdd <= 5){//  一闲家补牌
            if (bankAdd == 7){// 庄不补牌
                if (playAdd == 0){
                    cardRandom5 = 7;
                }
                if (playAdd == 1){
                    cardRandom5 = 6;
                }
                if (playAdd == 2){
                    cardRandom5 = 5;
                }
                if (playAdd == 3){
                    cardRandom5 = 4;
                }
                if (playAdd == 4){
                    cardRandom5 = 3;
                }
                if (playAdd == 5){
                    cardRandom5 = 2;
                }
                map.put("5",cardRandom5);
                return map;
            }else{
                if (playAdd == 0){
                    if (bankAdd == 0){
                        String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5",cardRandom5);
                        map.put("6",cardRandom5);
                    }
                    if (bankAdd == 1){//闲和是0，庄和是1
                        String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5",cardRandom5);
                        if (cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//1
                            map.put("6", 9);
                            return map;
                        }else if (cardRandom5 == 1){
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }else{
                            map.put("6",cardRandom5 - 1);
                        }
                    }

                    if (bankAdd == 2){//闲和是0，庄和是2
                        String str1 = "1,2,3,4,5,6,7,8,10,11,12,13";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){
                            map.put("6", 8);
                            return map;
                        }else if (cardRandom5 == 1){
                            map.put("6", 9);
                            return map;
                        }else if (cardRandom5 == 2){
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }else{
                            map.put("6",cardRandom5 - 2);
                        }

                    }

                    if (bankAdd == 3){//playAdd = 0 , bankAdd = 3
                        String str1 = "1,2,3,4,5,6,7,9,10,11,12,13";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){
                            map.put("6", 7);
                            return map;
                        }else if (cardRandom5 == 1){
                            map.put("6", 8);
                            return map;
                        }else if (cardRandom5 == 2){
                            map.put("6", 9);
                            return map;
                        }else if (cardRandom5 == 3){
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }else{
                            map.put("6",cardRandom5 - 3);
                        }
                    }

                    if (bankAdd == 4){//playAdd = 0 , bankAdd = 4
                        String str1 = "2,3,4,5,6,7";//没有8,9
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);//闲家补的牌是1.8.9.10,11,12,13的话，庄家不补牌
                        if (cardRandom5 == 2){//2
                            map.put("6", 8);
                            return map;
                        }
                        if (cardRandom5 == 3){//3
                            map.put("6", 9);
                            return map;
                        }
                        if (cardRandom5 == 4){//4
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 5){//5
                            map.put("6", 1);
                            return map;
                        }
                        if (cardRandom5 == 6){//6
                            map.put("6", 2);
                            return map;
                        }
                        if (cardRandom5 == 7){//7
                            map.put("6", 3);
                            return map;
                        }
                    }

                    if (bankAdd == 5){
                        String str1 = "4,5,6,7";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 4){
                            map.put("6", 9);
                            return map;
                        }
                        if (cardRandom5 == 5){
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 6){
                            map.put("6", 1);
                            return map;
                        }
                        if (cardRandom5 == 7){
                            map.put("6", 2);
                            return map;
                        }

                    }

                    if (bankAdd == 6){
                        String str1 = "6,7";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        if (6 == cardRandom5){
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }
                        if (cardRandom5 == 7){
                            map.put("6", 1);
                            return map;
                        }
                    }
                }


//第二种情况
                if (playAdd == 1){//闲的和为1
                    if (bankAdd == 0){//闲的和为1庄和是0
                        String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";//
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//1
                            map.put("6", 1);
                            return map;
                        }else if (cardRandom5 == 9){
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }else {
                            map.put("6", cardRandom5 + 1);
                            return map;
                        }

                    }

                    if (bankAdd == 1){//闲和是1，庄和也是1的时候
                        String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5",cardRandom5);
                        map.put("6",cardRandom6);
                    }

                    if (bankAdd == 2){//闲的和是1，庄家的和是2
                        String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5",cardRandom5);
                        if(cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//1
                            map.put("6", 9);
                            return map;
                        }else if (cardRandom5 == 1){//2
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }else {
                            map.put("6", cardRandom5 - 1);
                            return map;
                        }
                    }

                    //闲的和是1，庄家的和是3
                    if (bankAdd == 3){
                        String str1 = "1,2,3,4,5,6,7,9,10,11,12,13";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){
                            map.put("6", 7);
                            return map;
                        }else if (cardRandom5 == 1){
                            map.put("6", 8);
                            return map;
                        }else if (cardRandom5 == 2){
                            map.put("6", 9);
                            return map;
                        }else if (cardRandom5 == 3){
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }else{
                            map.put("6",cardRandom5 - 3);
                        }
                    }

                    if (bankAdd == 4){//闲的和是1，庄家的和是4
                        String str1 = "2,3,4,5,6,7";//没有8,9
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);//闲家补的牌是1.8.9.10,11,12,13的话，庄家不补牌
                        if (cardRandom5 == 2){//3
                            map.put("6", 9);
                            return map;
                        } else if (cardRandom5 == 3){//4
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }else {
                            map.put("6", cardRandom5 - 3);
                            return map;
                        }
                    }

                    if (bankAdd == 5){//闲的和是1，庄家的和是5
                        String str1 = "4,5,6,7";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 4){//5
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }else {
                            map.put("6", cardRandom5 - 4);
                            return map;
                        }
                    }

                    if (bankAdd == 6){//闲的和是1，庄家的和是6
                        String str1 = "5,6,7";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        if (5 == cardRandom5){
                            return map;
                        }
                        if (6 == cardRandom5){//7
                            map.put("6", 1);
                            return map;
                        }
                        if (cardRandom5 == 7){//8
                            map.put("6", 2);
                            return map;
                        }
                    }
                }

                //第三种情况
                if (playAdd == 2){//闲和为2
                    if (bankAdd == 0){//闲的和为2庄和是0
                        String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//2
                            map.put("6", 2);
                            return map;
                        }else if (cardRandom5 == 9){//1
                            map.put("6", 1);
                            return map;
                        }else if (cardRandom5 == 8) {//0
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }else {
                            map.put("6", cardRandom5 + 2);
                            return map;
                        }
                    }
                    if (bankAdd == 1){//闲和是2，庄和也是1的时候
                        String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";//
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5",cardRandom5);
                        if(cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//2
                            map.put("6", 1);
                            return map;
                        }else if (cardRandom5 == 9){//1
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }else{
                            map.put("6",cardRandom5 + 1);
                            return map;
                        }
                    }

                    if (bankAdd == 2){//闲的和是2，庄家的和是2
                        String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5",cardRandom5);
                        map.put("6",cardRandom5);
                    }

                    //闲的和是2，庄家的和是3
                    if (bankAdd == 3){
                        String str1 = "1,2,3,4,5,6,7,9,10,11,12,13";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//2
                            map.put("6", 9);
                            return map;
                        }else if (cardRandom5 == 1){
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6",cardRandom6);
                            return map;
                        }else{
                            map.put("6",cardRandom5 - 1);
                        }
                    }

                    //playAdd = 2, bankAdd = 4;
                    if (bankAdd == 4){
                        String str1 = "2,3,4,5,6,7";//没有8,9
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);//闲家补的牌是1.8.9.10,11,12,13的话，庄家不补牌
                        if (cardRandom5 == 2){//4
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }else {
                            map.put("6", cardRandom5 - 2);
                            return map;
                        }
                    }

                    if (bankAdd == 5){//playAdd =2
                        String str1 = "4,5,6,7";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        map.put("6", cardRandom5 - 3);
                    }

                    if (bankAdd == 6){//playAdd =2
                        String str1 = "6,7";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        if (6 == cardRandom5){//8
                            map.put("6", 2);
                            return map;
                        }else {
                            map.put("6", 3);//9
                            return map;
                        }
                    }
                }


//第四种情况
                if (playAdd == 3){//当闲对的和是3的时候
                    if (bankAdd == 0){//闲的和为3庄和是0
                        String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//3
                            map.put("6", 3);
                            return map;
                        }else if (cardRandom5 == 9){//2
                            map.put("6", 2);
                            return map;
                        }else if (cardRandom5 == 8) {//1
                            map.put("6", 1);
                            return map;
                        }else if (cardRandom5 == 7){//0
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        } else {
                            map.put("6", cardRandom5 + 3);
                            return map;
                        }
                    }

                    if (bankAdd == 1){//闲和是3，庄和也是1的时候
                        String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";//
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5",cardRandom5);
                        if(cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//3
                            map.put("6", 2);
                            return map;
                        }else if (cardRandom5 == 9){//2
                            map.put("6", 1);
                            return map;
                        }else if (cardRandom5 == 8){//1
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        } else {
                            map.put("6",cardRandom5 + 2);
                            return map;
                        }
                    }

                    if (bankAdd == 2){//闲的和是3，庄家的和是2
                        String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";//
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5",cardRandom5);
                        if(cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//3
                            map.put("6", 1);
                            return map;
                        }else if (cardRandom5 == 9){//2
                            String str = "10,11,12,13";
                            cardRandom6 = GameUtil.outRandomNumByStr(str);
                            map.put("6", cardRandom6);
                            return map;
                        }else {
                            map.put("6",cardRandom5 + 1);
                            return map;
                        }

                    }

                    //闲的和是3，庄家的和是3
                    if (bankAdd == 3){
                        String str1 = "1,2,3,4,5,6,7,9,10,11,12,13";//闲家不能补8
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5",cardRandom5);
                        map.put("6",cardRandom5);
                        return map;
                    }

                    if (bankAdd == 4){//playAdd = 3
                        String str1 = "1,2,3,4,5,6,7";//没有8,9
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);//闲家补的牌是1.8.9.10,11,12,13的话，庄家不补牌
                        if (cardRandom5 == 1){
                            return map;
                        }
                        map.put("6", cardRandom5 - 1);
                        return map;
                    }

                    if (bankAdd == 5){//playAdd = 3
                        String str1 = "2,4,5,6,7";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 2){
                            return map;
                        }
                        map.put("6", cardRandom5 - 2);
                    }

                    if (bankAdd == 6){//playAdd = 3
                        String str1 = "3,6,7";
                        cardRandom5 = GameUtil.outRandomNumByStr(str1);
                        map.put("5", cardRandom5);
                        if (cardRandom5 == 3){
                            return map;
                        }
                        if (6 == cardRandom5){//9
                            map.put("6", 3);
                            return map;
                        }else {
                            map.put("6", 4);//9
                            return map;
                        }
                    }
                }

            }


            //第五种情况
            if (playAdd == 4){//playAdd = 4,
                if (bankAdd == 0){//闲的和为4庄和是0
                    String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5", cardRandom5);
                    if (cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//4
                        map.put("6",4);
                        return map;
                    }else if (cardRandom5 == 6){//0
                        String str = "10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }else {
                        int tempNum = cardRandom5 + 4;
                        if (tempNum > 10){
                            tempNum = tempNum - 10;
                        }
                        map.put("6", tempNum);
                    }
                }

                if (bankAdd == 1){//闲和是4，庄和也是1的时候
                    String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5",cardRandom5);
                    if(cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//4
                        map.put("6", 3);
                        return map;
                    }else if (cardRandom5 == 9){//3
                        map.put("6", 2);
                        return map;
                    }else if (cardRandom5 == 8){//2
                        map.put("6", 1);
                        return map;
                    }else if (cardRandom5 == 7){//1
                        String str = "10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6", cardRandom6);
                        return map;
                    }else {
                        map.put("6",cardRandom5 + 3);
                        return map;
                    }
                }

                if (bankAdd == 2){//闲的和是4，庄家的和是2
                    String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";//
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5",cardRandom5);
                    if(cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//4
                        map.put("6", 2);
                        return map;
                    }else if (cardRandom5 == 9){//3
                        map.put("6", 1);
                        return map;
                    }else if (cardRandom5 == 8){//2
                        String str = "10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6", cardRandom6);
                        return map;
                    }else {
                        map.put("6",cardRandom5 + 2);
                        return map;
                    }
                }

                //闲的和是4，庄家的和是3
                if (bankAdd == 3){
                    String str1 = "1,2,3,4,6,7,9,10,11,12,13";//闲家不能补8
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5",cardRandom5);
                    if (cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//4
                        map.put("6", 1);
                        return map;
                    }else if (cardRandom5 == 9){
                        String str = "10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }else{
                        map.put("6",cardRandom5 + 1);
                    }
                }
                if (bankAdd == 4){//闲的和是4，庄家的和是4
                    String str1 = "2,3,4,5,6,7";//没有8,9
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5",cardRandom5);
                    map.put("6",cardRandom5);
                    return map;
                }

                if (bankAdd == 5){//闲的和是4，庄家的和是5
                    String str1 = "4,5,6,7";
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5", cardRandom5);
                    map.put("6", cardRandom5 - 1);
                }

                if (bankAdd == 6){//playAdd = 4
                    String str1 = "6,7";
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5", cardRandom5);
                    if (6 == cardRandom5){//0
                        map.put("6", 4);
                        return map;
                    }else {
                        map.put("6", 5);//1
                        return map;
                    }
                }
            }



            //第五种情况
            if (playAdd == 5){//
                if (bankAdd == 0){//闲的和为5庄和是0
                    String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5", cardRandom5);
                    if (cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//5
                        map.put("6", 5);
                        return map;
                    }else if (cardRandom5 == 5){//0
                        String str = "10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }else {
                        int tempNum = cardRandom5 + 5;
                        if (tempNum > 10){
                            tempNum = tempNum - 10;
                        }
                        map.put("6", tempNum);

                    }
                }
                if (bankAdd == 1){//闲和是5，庄和也是1的时候
                    String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5",cardRandom5);
                    if(cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//5
                        map.put("6", 4);
                        return map;
                    }else if (cardRandom5 == 9){//4
                        map.put("6", 3);
                        return map;
                    }else if (cardRandom5 == 8){//3
                        map.put("6", 2);
                        return map;
                    }else if (cardRandom5 == 7){//2
                        map.put("6", 1);
                        return map;
                    }else if (cardRandom5 == 6){//1
                        String str = "10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6", cardRandom6);
                        return map;
                    }else {
                        map.put("6",cardRandom5 + 4);
                        return map;
                    }
                }

                if (bankAdd == 2){//闲的和是5，庄家的和是2
                    String str1 = "1,2,3,4,5,6,7,8,9,10,11,12,13";//
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5",cardRandom5);
                    if(cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//5
                        map.put("6", 3);
                        return map;
                    }else if (cardRandom5 == 9){//4
                        map.put("6", 2);
                        return map;
                    }else if (cardRandom5 == 8){//3
                        map.put("6", 1);
                        return map;
                    }else if (cardRandom5 == 7){//2
                        String str = "10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6", cardRandom6);
                        return map;
                    }else {
                        map.put("6",cardRandom5 + 3);
                        return map;
                    }
                }

                //闲的和是5，庄家的和是3
                if (bankAdd == 3){
                    String str1 = "1,2,3,4,6,7,9,10,11,12,13";//闲家不能补8
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5",cardRandom5);
                    if (cardRandom5 == 10 || cardRandom5 == 11 || cardRandom5 == 12 || cardRandom5 == 13){//5
                        map.put("6", 2);
                        return map;
                    }else if (cardRandom5 == 9){//4
                        map.put("6", 1);
                        return map;
                    }else if (cardRandom5 == 8){//3
                        String str = "10,11,12,13";
                        cardRandom6 = GameUtil.outRandomNumByStr(str);
                        map.put("6",cardRandom6);
                        return map;
                    }else{
                        map.put("6",cardRandom5 + 2);
                    }
                }

                if (bankAdd == 4){//playAdd = 5
                    String str1 = "2,3,4,5,6,7";//没有8,9
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5", cardRandom5);//闲家补的牌是1.8.9.10,11,12,13的话，庄家不补牌
                    map.put("6", cardRandom5 + 1);
                    return map;
                }

                if (bankAdd == 5){//playAdd = 5
                    String str1 = "4,5,6,7";
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5", cardRandom5);
                    map.put("6", cardRandom5);
                }

                if (bankAdd == 6){//playAdd = 5
                    String str1 = "6,7";
                    cardRandom5 = GameUtil.outRandomNumByStr(str1);
                    map.put("5", cardRandom5);
                    if (6 == cardRandom5){//1
                        map.put("6", 5);
                        return map;
                    }else {
                        map.put("6", 6);//2
                        return map;
                    }
                }
            }
        }else{//playAdd = 6,7 闲不补牌
            if (playAdd == 6){// 庄不补牌
                if (bankAdd == 6){ //闲不补牌
                    return map;
                }
                if (bankAdd == 7){
                    return dealPlayWin(map, 6);
                }
                map.put("6",6 - bankAdd);
                return map;
            }

            if (playAdd == 7){// 闲家不补牌
                if (bankAdd == 6){ // 庄家不补牌
                    return dealPlayWin(map, 7);
                }
                if (bankAdd == 7){
                    return map;
                }
                map.put("6", 7 - bankAdd);
                return map;
            }
        }

        return null;

    }


    public static Map<String, Integer> dealPlayWin(Map<String, Integer> map, int index){
        if (index == 6){
            String str1 = "1,2,5,4,10,11,12,13";
            String str2 = "5,4,1,2,6,6,6,6";
            map = GameUtil.outMapRandomNumByStr(str1, str2, map);
            return map;
        }else {
            String str1 = "1,2,3,4,5,6,10,11,12,13";
            String str2 = "6,5,4,3,2,1,7,7,7,7";
            map = GameUtil.outMapRandomNumByStr(str1, str2, map);
            return map;
        }
    }
}
