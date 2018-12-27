package com.stubborn.game;

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

    public static void main(String[] args) {
        openAwardHandler();
    }

    public static Map<String,String> openAwardHandler(){
        String resulst = outEvent();
        switch (resulst) {
            case OPEN_AWARD_EVENT1:
                BjlOpenAwardDemo1.openAwardEvent1();
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
        Integer randomEvent1 = GameUtil.commonOutputCard(1000000, 1);
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
        Integer randomEvent2 = GameUtil.commonOutputCard(1000000, 1);
        if (0 <= randomEvent2 && randomEvent2 <= 76499){
            eventResult2 = "4_";
            result = result + eventResult2;
        }
        //开庄对
        Integer randomEvent3 = GameUtil.commonOutputCard(1000000, 1);
        if (0 <= randomEvent3 && randomEvent3 <= 76499){
            eventResult3 = "5_";
            result = result + eventResult3;
        }

        result = result.substring(0,result.length() - 1);
        return result;
    }


}
