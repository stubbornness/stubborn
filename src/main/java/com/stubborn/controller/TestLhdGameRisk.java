package com.stubborn.controller;

import com.alibaba.fastjson.JSONObject;
import com.stubborn.util.HttpServiceUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author 丁少东
 * @create 2019-01-26 下午6:13
 **/
@Component
public class TestLhdGameRisk {

    public final static long EXECUTION_TIME =  45 * 1000;

    public final static Map<String, String> initMap = new HashMap();

    static {
        initMap.put("1", "1,2,3,4,5");
        initMap.put("2", "7,8,9,10,11");
        initMap.put("3", "6");
    }

    @Value("${lhdPeriodUrl}")
    private String lhdPeriodUrl;

    @Value("${lhdBetOrderUrl}")
    private String lhdBetOrderUrl;

    @Scheduled(fixedDelay = EXECUTION_TIME)
    public void testGameRisk() {
        String periodRes = HttpServiceUtils.sendRequest(lhdPeriodUrl);
        JSONObject period = JSONObject.parseObject(JSONObject.parseObject(periodRes).getString("resp"));
        Long betTime = period.getLongValue("countDown");
        String periodId = period.getString("periodId");
        String token1 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwibW9iaWxlIjoiMDc2NTQzMjEwNSIsImV4cCI6MTU1NDExOTI4NzI3MCwidXNlcklkIjoiMDA5MDAxNTQ4OTMzMTkyOTM4NjQwOTM1NjEiLCJjaGFubmVsSWQiOiIwMDkifQ.poHG-dhXiRXUaAHfuQA8Q2KEoQEIM0m0yt5tKQgcQnA.xmZKbDj5RkA4U4mziwdu9S";
        String token2 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwibW9iaWxlIjoiMDc2NTQzMjEwNiIsImV4cCI6MTU1NDExOTMxMjc3MSwidXNlcklkIjoiMDA5MDAxNTQ4OTMzMjUzMDU5MTg3NzM3NDMiLCJjaGFubmVsSWQiOiIwMDkifQ.rljHibUn75-ymk81PvNtRETOIbdxZUQwpLR054uRBcM.sekbPV8uNibDG5hXnJhDGa";
        String betOpt = null;
        String betAmount = null;
        String betAmountStr = "20,100,1000,10000,50000";
        String [] betAmountArr = betAmountStr.split(",");
        Integer randomNum = null;
        if (betTime > 3){
            for(String key : initMap.keySet()){
                randomNum = new Random().nextInt(3);
                betAmount = betAmountArr[randomNum];
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(lhdBetOrderUrl+"&token="+token1+"&gameEn=lhd&betFlag=0"+"&rawNumber="+periodId+"%23"+"001"+"%7c"+betOpt+"~"+betAmount);
                System.out.println("lhd1"+betOrderRes);
            }
            for(String key : initMap.keySet()){
                betAmount = "10000";
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(lhdBetOrderUrl+"&token="+token2+"&gameEn=lhd&betFlag=0"+"&rawNumber="+periodId+"%23"+"001"+"%7c"+betOpt+"~"+betAmount);
                System.out.println("lhd2"+betOrderRes);
            }
        }

    }

}
