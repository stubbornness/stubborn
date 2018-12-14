package com.stubborn.test;

import com.stubborn.entity.CardModel;

import java.util.*;

/**
 * @author 丁少东
 * @create 2018-11-30 上午9:55
 **/
public class BjlOpenAward {

    public static final int TEN = 10;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;



    public static void main(String[] args) {
        sendCard();
    }

    /**
     1.闲赢：1赔1，闲区域获胜
     2.庄赢：1赔0.95，庄区域获胜
     3.和：   1赔8，庄闲点数相同
     4.闲对：1赔11，闲家前两张牌是对子
     5.庄对：1赔11，庄家前两张牌是对子
     */
    public static Map<String, Object> sendCard(){

        Map<String, Object> map = new HashMap<>();
        Map<String, Integer> cardMap = new LinkedHashMap<>();


        //1,3张牌发给闲家   2,4张牌发给庄家
        int cardRandom1 = outputCard();
        int cardRandom2 = outputCard();
        int cardRandom3 = outputCard();
        int cardRandom4 = outputCard();

        cardMap.put("1",cardRandom1);
        cardMap.put("2",cardRandom2);
        cardMap.put("3",cardRandom3);
        cardMap.put("4",cardRandom4);

        //闲的和

        int playAdd = cardRandom1 + cardRandom3;
        //庄的和

        int bankAdd = cardRandom2 + cardRandom4;

        //闲对
        if (cardRandom1 == cardRandom3){
            map.put("playPair",4);
        }

        //庄对
        if (cardRandom2 == cardRandom4){
            map.put("bankPair",5);
        }

        if(bankAdd == 9 || bankAdd == 8 || playAdd == 9 || playAdd == 8){
            map.put("openAwardResult", compare(bankAdd, playAdd));
            return map;
        }
        int cardRandom5 = -1;//闲家补牌
        int cardRandom6 = -1;//庄家补牌
        if (playAdd >= 0 && playAdd <= 5){
            cardRandom6 = outputCard();//闲家补牌
            playAdd = playAdd + cardRandom6;
        }
        cardMap.put("5",cardRandom5);

        if (bankAdd >= 0 && bankAdd <= 2){
            cardRandom5 = outputCard();//庄家补牌
            bankAdd = bankAdd + cardRandom5;
        }
        if (bankAdd == 3 && cardRandom6 != 8){//闲家第三张是8不补牌
            cardRandom5 = outputCard();//庄家补牌
            bankAdd = bankAdd + cardRandom5;
        }
        if (bankAdd == 4 && 1 < cardRandom6 && cardRandom6 < 8){//闲家第三张牌0、1、8、9庄家不补牌
            cardRandom5 = outputCard();//庄家补牌
            bankAdd = bankAdd + cardRandom5;
        }
        if (bankAdd == 5 && 3 < cardRandom6 && cardRandom6 < 8){//闲家第三张牌0、1、2、3、8、9庄家不补牌
            cardRandom5 = outputCard();//庄家补牌
            bankAdd = bankAdd + cardRandom5;
        }
        if (bankAdd == 6 && 5 < cardRandom6 && cardRandom6 < 8){//闲家第三张牌0、1、2、3、8、9庄家不补牌
            cardRandom5 = outputCard();//庄家补牌
            bankAdd = bankAdd + cardRandom5;
        }
        cardMap.put("6",cardRandom6);
        map.put("openAwardResult", compare(bankAdd, playAdd));
        return map;

    }

    /**
     * 产生牌的数字
     * @return
     */
    public static int outputCard(){
        int colorRandom = new Random().nextInt(12) + 1;
        if (colorRandom == TEN || colorRandom == JACK || colorRandom == QUEEN || colorRandom == KING) {
            colorRandom = 0;
        }
        return colorRandom;
    }

    //庄闲比较大小
    public static int compare(int bank, int play){
        if (bank > play){
            return 1;
        } else if (bank == play){
            return 3;
        }else {
            return 2;
        }
    }

    //颜色
    public static int outputColor(){
        return new Random().nextInt(4) + 1;
    }

}
