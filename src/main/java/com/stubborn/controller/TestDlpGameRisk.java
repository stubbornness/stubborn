package com.stubborn.controller;

import com.alibaba.fastjson.JSONObject;
import com.stubborn.util.HttpServiceUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author 丁少东
 * @create 2019-01-26 下午6:13
 **/
@Component
public class TestDlpGameRisk {

    public final static long EXECUTION_TIME =  45 * 1000;
    //接口地址
    @Value("${periodUrl}")
    private String periodUrl;

    @Value("${betOrderUrl}")
    private String betOrderUrl;


    /**
     大轮盘前后端约定规则
     投注选项   ======    前后端约定代号
     0~36      ======    0-36
     00        ======    37
     并1       ======    38
     并2       ======    39
     并3       ======    40
     前12      ======    41
     中12      ======    42
     后12      ======    43
     1-18      ======   44
     偶数      ======    45
     绿色      ======    46
     红色      ======    47
     奇数      ======    48
     19-36     ======   49
     */
    public final static Map<String,String> dlpMap  = new LinkedHashMap<>();
    static {
        dlpMap.put("0", "0");
        dlpMap.put("1", "1,38,41,44,46,48");//当开奖结果是1是时候，其他中奖的选项
        dlpMap.put("2", "2,39,41,44,47,45");
        dlpMap.put("3", "3,40,41,44,46,48");
        dlpMap.put("4", "4,38,41,44,47,45");
        dlpMap.put("5", "5,39,41,44,46,48");
        dlpMap.put("6", "6,40,41,44,47,45");
        dlpMap.put("7", "7,38,41,44,46,48");
        dlpMap.put("8", "8,39,41,44,47,45");
        dlpMap.put("9", "9,40,41,44,46,48");
        dlpMap.put("10", "10,38,41,44,47,45");
        dlpMap.put("11", "11,39,41,44,47,48");
        dlpMap.put("12", "12,40,41,44,46,45");
        dlpMap.put("13", "13,38,42,44,47,48");
        dlpMap.put("14", "14,39,42,44,46,45");
        dlpMap.put("15", "15,40,42,44,47,48");
        dlpMap.put("16", "16,38,42,44,46,45");
        dlpMap.put("17", "17,39,42,44,47,48");
        dlpMap.put("18", "18,40,42,44,46,45");
        dlpMap.put("19", "19,38,42,49,46,48");
        dlpMap.put("20", "20,39,42,49,47,45");
        dlpMap.put("21", "21,40,42,49,46,48");
        dlpMap.put("22", "22,38,42,49,47,45");
        dlpMap.put("23", "23,39,42,49,46,48");
        dlpMap.put("24", "24,40,42,49,47,45");
        dlpMap.put("25", "25,38,43,49,46,48");
        dlpMap.put("26", "26,39,43,49,47,45");
        dlpMap.put("27", "27,40,43,49,46,48");
        dlpMap.put("28", "28,38,43,49,47,45");
        dlpMap.put("29", "29,39,43,49,47,48");
        dlpMap.put("30", "30,40,43,49,46,45");
        dlpMap.put("31", "31,38,43,49,47,48");
        dlpMap.put("32", "32,39,43,49,46,45");
        dlpMap.put("33", "33,40,43,49,47,48");
        dlpMap.put("34", "34,38,43,49,46,45");
        dlpMap.put("35", "35,39,43,49,47,48");
        dlpMap.put("36", "36,40,43,49,46,45");
        dlpMap.put("37", "37");
        dlpMap.put("38", "37");
        dlpMap.put("39", "37");
        dlpMap.put("40", "37");
        dlpMap.put("41", "37");
        dlpMap.put("42", "37");
        dlpMap.put("43", "37");
        dlpMap.put("44", "37");
        dlpMap.put("45", "37");
        dlpMap.put("46", "37");
        dlpMap.put("47", "37");
        dlpMap.put("48", "37");
        dlpMap.put("49", "37");

    }


    public final static Map<String,String> dlpMap1  = new LinkedHashMap<>();
    static {
        dlpMap1.put("0", "0");
        dlpMap1.put("1", "1,38,41,44,46,48");//当开奖结果是1是时候，其他中奖的选项
        dlpMap1.put("2", "2,39,41,44,47,45");
        dlpMap1.put("3", "3,40,41,44,46,48");
        dlpMap1.put("4", "4,38,41,44,47,45");
        dlpMap1.put("5", "5,39,41,44,46,48");
        dlpMap1.put("6", "6,40,41,44,47,45");
        dlpMap1.put("7", "7,38,41,44,46,48");
        dlpMap1.put("8", "8,39,41,44,47,45");
        dlpMap1.put("9", "9,40,41,44,46,48");
    }

    public final static Map<String,String> dlpMap2  = new LinkedHashMap<>();
    static {
        dlpMap2.put("10", "10,38,41,44,47,45");
        dlpMap2.put("11", "11,39,41,44,47,48");
        dlpMap2.put("12", "12,40,41,44,46,45");
        dlpMap2.put("13", "13,38,42,44,47,48");
        dlpMap2.put("14", "14,39,42,44,46,45");
        dlpMap2.put("15", "15,40,42,44,47,48");
        dlpMap2.put("16", "16,38,42,44,46,45");
        dlpMap2.put("17", "17,39,42,44,47,48");
        dlpMap2.put("18", "18,40,42,44,46,45");
        dlpMap2.put("19", "19,38,42,49,46,48");
        dlpMap2.put("20", "20,39,42,49,47,45");
    }

    public final static Map<String,String> dlpMap3  = new LinkedHashMap<>();
    static {
        dlpMap3.put("21", "21,40,42,49,46,48");
        dlpMap3.put("22", "22,38,42,49,47,45");
        dlpMap3.put("23", "23,39,42,49,46,48");
        dlpMap3.put("24", "24,40,42,49,47,45");
        dlpMap3.put("25", "25,38,43,49,46,48");
        dlpMap3.put("26", "26,39,43,49,47,45");
        dlpMap3.put("27", "27,40,43,49,46,48");
        dlpMap3.put("28", "28,38,43,49,47,45");
        dlpMap3.put("29", "29,39,43,49,47,48");
        dlpMap3.put("30", "30,40,43,49,46,45");
    }

    public final static Map<String,String> dlpMap4  = new LinkedHashMap<>();
    static {
        dlpMap4.put("30", "30,40,43,49,46,45");
        dlpMap4.put("31", "31,38,43,49,47,48");
        dlpMap4.put("32", "32,39,43,49,46,45");
        dlpMap4.put("33", "33,40,43,49,47,48");
        dlpMap4.put("34", "34,38,43,49,46,45");
        dlpMap4.put("35", "35,39,43,49,47,48");
        dlpMap4.put("36", "36,40,43,49,46,45");
        dlpMap4.put("37", "37");
        dlpMap4.put("38", "37");
        dlpMap4.put("39", "37");
        dlpMap4.put("40", "37");
    }

    public final static Map<String,String> dlpMap5  = new LinkedHashMap<>();
    static {
        dlpMap5.put("41", "37");
        dlpMap5.put("42", "37");
        dlpMap5.put("43", "37");
        dlpMap5.put("44", "37");
        dlpMap5.put("45", "37");
        dlpMap5.put("46", "37");
        dlpMap5.put("47", "37");
        dlpMap5.put("48", "37");
        dlpMap5.put("49", "37");
    }






    /**
     * 大轮盘筹码20,100,500,1000,5000
     * dlpMap1 = 9383348939
     * dlpMap2 =
     *
     * dlpMap3 = 6418721638
     * dlpMap4 = 5523419377
     * dlpMap5 = 8463423526
     *
     */
    //@Scheduled(fixedDelay = EXECUTION_TIME)
    public void testGameRisk() {
        String periodRes = HttpServiceUtils.sendRequest(periodUrl);
        JSONObject period = JSONObject.parseObject(JSONObject.parseObject(periodRes).getString("resp"));
        Long betTime = period.getLongValue("countDown");
        String periodId = period.getString("periodId");
        String token1 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwibW9iaWxlIjoiMDc2NTQzMjEwMiIsImV4cCI6MTU1NDExOTEzMjE2OSwidXNlcklkIjoiMDA5MDAxNTQ4OTMyOTM1MDM5NTAyNzc0NDAiLCJjaGFubmVsSWQiOiIwMDkifQ.MUAPGLzIjkwCp29ivZSxgtTSmg1BaGNZJ9o-q5R-h2Q.nTSpu7sidc6VzneUwxY5iM";
        String token2 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwiZXhwIjoxNTUzOTQ0MTAwNzk1LCJ1c2VySWQiOiIwMDkwMDE1NDg2NjIzNjYyOTc5MDAxMDgzMSIsImNoYW5uZWxJZCI6IjAwOSJ9.jI0xtA_lYF3NEAnhyfFCOBHY4Ea-vj_NrXAXfO1HGH4.k4Ko6m8fGMP75iGuRYVt48";
        String token3 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwiZXhwIjoxNTUzOTQ0MTMyMzAxLCJ1c2VySWQiOiIwMDkwMDE1NDg2NjIzNjM4NjQxODcyMTYzOCIsImNoYW5uZWxJZCI6IjAwOSJ9.SPQpbANjnJLC94YE58-Ns74e5yix4V3T_EpuD7qYBUc.vXkfcneosw8Toji8JYvTsA";
        String token4 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwiZXhwIjoxNTUzOTQ0MTYzNDAwLCJ1c2VySWQiOiIwMDkwMDE1NDg2NjIzNTQyNTUyMzQxOTM3NyIsImNoYW5uZWxJZCI6IjAwOSJ9.fu4-r9N-1K-45meWamjWhoGvBByvnfjEkV6GW9gpLmc.5opDCWZtXKK2fBFoeVqUyD";
        String token5 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwiZXhwIjoxNTUzOTQ0MTg3NzQwLCJ1c2VySWQiOiIwMDkwMDE1NDg2NjIzNTEzODQ2MzQyMzUyNiIsImNoYW5uZWxJZCI6IjAwOSJ9.SH-I2hj6OuKFMjkaG0RGGyGnoZSfY4JtBBnBDX6TomQ.pYzFaWZm7yLmRRmyzijb4V";
        String betOpt = null;
        String betAmount = null;
        String betAmountStr = "20,100,500,1000,5000";
        String [] betAmountArr = betAmountStr.split(",");
        Integer randomNum = null;
        if (betTime > 3){
            for(String key : dlpMap1.keySet()){
                randomNum = new Random().nextInt(5);
                betAmount = betAmountArr[randomNum];
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(betOrderUrl+"periodId="+periodId+"&gameEn=dlp&playCode=001&betOpt="+betOpt+"&betAmount="+betAmount+"&token="+token1);
                System.out.println("dlpMap1"+betOrderRes);
            }
            for(String key : dlpMap2.keySet()){
                randomNum = new Random().nextInt(5);
                betAmount = betAmountArr[randomNum];
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(betOrderUrl+"periodId="+periodId+"&gameEn=dlp&playCode=001&betOpt="+betOpt+"&betAmount="+betAmount+"&token="+token2);
                System.out.println("dlpMap2"+betOrderRes);
            }
            for(String key : dlpMap3.keySet()){
                randomNum = new Random().nextInt(5);
                betAmount = betAmountArr[randomNum];
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(betOrderUrl+"periodId="+periodId+"&gameEn=dlp&playCode=001&betOpt="+betOpt+"&betAmount="+betAmount+"&token="+token3);
                System.out.println("dlpMap3"+betOrderRes);
            }
            for(String key : dlpMap4.keySet()){
                randomNum = new Random().nextInt(5);
                betAmount = betAmountArr[randomNum];
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(betOrderUrl+"periodId="+periodId+"&gameEn=dlp&playCode=001&betOpt="+betOpt+"&betAmount="+betAmount+"&token="+token4);
                System.out.println("dlpMap4"+betOrderRes);
            }
            for(String key : dlpMap5.keySet()){
                randomNum = new Random().nextInt(5);
                betAmount = betAmountArr[randomNum];
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(betOrderUrl+"periodId="+periodId+"&gameEn=dlp&playCode=001&betOpt="+betOpt+"&betAmount="+betAmount+"&token="+token5);
                System.out.println("dlpMap5"+betOrderRes);
            }
        }

    }

}
