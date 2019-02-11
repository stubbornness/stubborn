package com.stubborn.controller;

import com.alibaba.fastjson.JSONObject;
import com.stubborn.util.HttpServiceUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author 丁少东
 * @create 2019-01-26 下午6:13
 **/
@Component
public class TestSixGameRisk {

    public final static long EXECUTION_TIME =  45 * 1000;


    //接口地址
    @Value("${sixPeriodUrl}")
    private String sixPeriodUrl;

    @Value("${sixBetOrderUrl}")
    private String sixBetOrderUrl;

    //@Scheduled(fixedDelay = EXECUTION_TIME)
    public void testGameRisk() {

        String periodRes = HttpServiceUtils.sendRequest(sixPeriodUrl);
        JSONObject period = JSONObject.parseObject(JSONObject.parseObject(periodRes).getString("resp"));
        Long betTime = period.getLongValue("countDown");
        String periodId = period.getString("periodId");
        String token1 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwibW9iaWxlIjoiMDc2NTQzMjEwNyIsImV4cCI6MTU1NDExOTM0OTI1MCwidXNlcklkIjoiMDA5MDAxNTQ4OTMzMzE5NTQwMzM5MzYzMTgiLCJjaGFubmVsSWQiOiIwMDkifQ.t-9NhRlhnZurNZoyFDKMzZhMAar-TasZh-7mhDSTvO0.hvFTVSrTw3KTNXHmC2TGzG";
        String token2 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwiZXhwIjoxNTU0MDM0NzM4MjUzLCJ1c2VySWQiOiIwMDkwMDE1NDg4NDYxNTgzMzA4MzIzNDY0MCIsImNoYW5uZWxJZCI6IjAwOSJ9.ZlDcsYFKGQqcHcxZJ8INK8-pqMLeGvNsm5N2w5P6FII.yPiNnMKqAib5bwi6H6NwxW";
        String token3 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwibW9iaWxlIjoiMDc2NTQzMjEwOCIsImV4cCI6MTU1NDExOTM3NzU4MiwidXNlcklkIjoiMDA5MDAxNTQ4OTMzNDQwNzE3ODg2NzE3MjkiLCJjaGFubmVsSWQiOiIwMDkifQ.RkSJNSXQRkyM8x-KIhy6pXca5q-Sybz4uLSd3X_jcbM.zyZCvMB2a5ttFXaR8wHAbG";
        String token4 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwiZXhwIjoxNTU0MDM0ODA1NzY2LCJ1c2VySWQiOiIwMDkwMDE1NDg4NDYxNTg3ODc2ODI1MDQzNyIsImNoYW5uZWxJZCI6IjAwOSJ9.3NJjkxLwvSLpkqDdYw2ReijcspuzL8oP5HL-xav9SOk.5T9g25aHNihzJC2C2xTddM";
        String token5 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwiZXhwIjoxNTU0MDM0ODQyMDgxLCJ1c2VySWQiOiIwMDkwMDE1NDg4NDYxNTkxMTkzMjUyMTg5MSIsImNoYW5uZWxJZCI6IjAwOSJ9.Cn1bT5-syK1x3n5QxXJTXiCF_s-3GKj6Q_vGkmxZyLM.Btgo5AenCrUfCbrfBQVikY";
        String token6 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwiZXhwIjoxNTU0MDM0ODc4OTQ4LCJ1c2VySWQiOiIwMDkwMDE1NDg4NDYxNTg2ODgyODMwMTczNSIsImNoYW5uZWxJZCI6IjAwOSJ9.MNLYXfKpca9nV-nJj-lwFHGhd0EOJH4WEU3tLGBzjLQ.HHd9BJKxpew5Chbqez3kRL";
        String token7 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwibW9iaWxlIjoiMDc2NTQzMjEwOSIsImV4cCI6MTU1NDExOTQxNTAzNiwidXNlcklkIjoiMDA5MDAxNTQ4OTMzNDk1NzkwMzc1MDE2OTkiLCJjaGFubmVsSWQiOiIwMDkifQ._U2HMV8X2FA2v-0gcdYNAkpp0bKxGFIqScyGmPGBPGQ.YaxrGVWjvAgLdbiBMz2h9X";
        String token8 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwiZXhwIjoxNTU0MDM0OTM1NTM3LCJ1c2VySWQiOiIwMDkwMDE1NDg4NDYxNTg1ODI0NzA4OTgyNCIsImNoYW5uZWxJZCI6IjAwOSJ9.kxWU3icFtWgvauRJxZZ9Z6Ut4-dU-eCaCRz4FSBGOIk.xxLdLn8gNpwSJus8LG4mgL";
        String token9 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwiZXhwIjoxNTU0MDM0OTYyODI4LCJ1c2VySWQiOiIwMDkwMDE1NDg4NDYxODgyMDA4Mzg1NzM2MyIsImNoYW5uZWxJZCI6IjAwOSJ9.kYOEP0CHPnHAU-adFE2heFdxezHhZdk9i1CCSyS7J-k.bkHJJMAkC4TvUzQuBTXhVh";

        String betOpt = null;
        String betAmount = null;
        Integer randomNum = null;
        List<String> list001 = new ArrayList<>(Arrays.asList("1","2"));
        List<String> list002 = new ArrayList<>(Arrays.asList("1","2"));
        List<String> list003 = new ArrayList<>(Arrays.asList("3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18"));
        List<String> list004 = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7"));
        List<String> list005 = new ArrayList<>(Arrays.asList("1","2","3","4","5","6"));
        List<String> list006 = new ArrayList<>(Arrays.asList("11","22","33","44","55","66"));
        List<String> list007 = new ArrayList<>(Arrays.asList("112","113","114","115","116","221","223","224","225","226","331","332","334","335","336","441","442","443","445","446","661","662","663","664","665"));
        List<String> list008 = new ArrayList<>(Arrays.asList("12","13","14","15","16","23","24","25","26","34","35","36","45","46","56"));
        List<String> list009 = new ArrayList<>(Arrays.asList("123","124","125","126","134","135","136","145","146","156","234","235","236","245","246","256","345","346","356","456"));

        if (betTime > 3){
            for(String key : list001){
                randomNum = new Random().nextInt(5);
                String betAmountStr = "20,100,1000,10000,50000";
                String [] betAmountArr = betAmountStr.split(",");
                betAmount = betAmountArr[randomNum];
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(sixBetOrderUrl+"&token="+token1+"&rawNumber="+periodId+"%23"+"001"+"%7c"+betOpt+"~"+betAmount);
                System.out.println("001"+betOrderRes);
            }
            for(String key : list002){
                randomNum = new Random().nextInt(5);
                String betAmountStr = "20,100,1000,10000,50000";
                String [] betAmountArr = betAmountStr.split(",");
                betAmount = betAmountArr[randomNum];
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(sixBetOrderUrl+"&token="+token2+"&rawNumber="+periodId+"%23"+"002"+"%7c"+betOpt+"~"+betAmount);
                System.out.println("002"+betOrderRes);
            }
            for(String key : list003){
                String betAmountStr = "20,100,1000,10000";
                String [] betAmountArr = betAmountStr.split(",");
                randomNum = new Random().nextInt(4);
                betAmount = betAmountArr[randomNum];
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(sixBetOrderUrl+"&token="+token3+"&rawNumber="+periodId+"%23"+"003"+"%7c"+betOpt+"~"+betAmount);
                System.out.println("003"+betOrderRes);
            }
            for(String key : list004){
                String betAmountStr = "20,100,1000";
                String [] betAmountArr = betAmountStr.split(",");
                randomNum = new Random().nextInt(3);
                betAmount = betAmountArr[randomNum];
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(sixBetOrderUrl+"&token="+token4+"&rawNumber="+periodId+"%23"+"004"+"%7c"+betOpt+"~"+betAmount);
                System.out.println("004"+betOrderRes);
            }
            for(String key : list005){
                String betAmountStr = "20,100,1000";
                String [] betAmountArr = betAmountStr.split(",");
                randomNum = new Random().nextInt(3);
                betAmount = betAmountArr[randomNum];
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(sixBetOrderUrl+"&token="+token5+"&rawNumber="+periodId+"%23"+"005"+"%7c"+betOpt+"~"+betAmount);
                System.out.println("005"+betOrderRes);
            }
            for(String key : list006){
                String betAmountStr = "20,100,1000";
                String [] betAmountArr = betAmountStr.split(",");
                randomNum = new Random().nextInt(3);
                betAmount = betAmountArr[randomNum];
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(sixBetOrderUrl+"&token="+token6+"&rawNumber="+periodId+"%23"+"006"+"%7c"+betOpt+"~"+betAmount);
                System.out.println("006"+betOrderRes);
            }
            for(String key : list007){
                String betAmountStr = "20,100,1000";
                String [] betAmountArr = betAmountStr.split(",");
                randomNum = new Random().nextInt(3);
                betAmount = betAmountArr[randomNum];
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(sixBetOrderUrl+"&token="+token7+"&rawNumber="+periodId+"%23"+"007"+"%7c"+betOpt+"~"+betAmount);
                System.out.println("007"+betOrderRes);
            }
            for(String key : list008){
                String betAmountStr = "20,100,1000";
                String [] betAmountArr = betAmountStr.split(",");
                randomNum = new Random().nextInt(3);
                betAmount = betAmountArr[randomNum];
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(sixBetOrderUrl+"&token="+token8+"&rawNumber="+periodId+"%23"+"008"+"%7c"+betOpt+"~"+betAmount);
                System.out.println("008"+betOrderRes);
            }
            for(String key : list009){
                String betAmountStr = "20,100,1000";
                String [] betAmountArr = betAmountStr.split(",");
                randomNum = new Random().nextInt(3);
                betAmount = betAmountArr[randomNum];
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(sixBetOrderUrl+"&token="+token9+"&rawNumber="+periodId+"%23"+"009"+"%7c"+betOpt+"~"+betAmount);
                System.out.println("009"+betOrderRes);
            }

        }

    }

}
