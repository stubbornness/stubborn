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
public class TestCdxGameRisk {

    public final static long EXECUTION_TIME =  45 * 1000;

    public final static Map<String, String> initMap = new HashMap();

    static {
        initMap.put("1", "1,2,3,4,5");
        initMap.put("2", "7,8,9,10,11");
        initMap.put("3", "6");
    }


    //接口地址
    @Value("${cdxPeriodUrl}")
    private String cdxPeriodUrl;

    @Value("${cdxBetOrderUrl}")
    private String cdxBetOrderUrl;

    @Scheduled(fixedDelay = EXECUTION_TIME)
    public void testGameRisk() {
        String periodRes = HttpServiceUtils.sendRequest(cdxPeriodUrl);
        JSONObject period = JSONObject.parseObject(JSONObject.parseObject(periodRes).getString("resp"));
        Long betTime = period.getLongValue("countDown");
        String periodId = period.getString("periodId");
        String token1 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwibW9iaWxlIjoiMDc2NTQzMjEwMyIsImV4cCI6MTU1NDExOTE3MTYzNywidXNlcklkIjoiMDA5MDAxNTQ4OTMzMDMyODc0Mjc2MzMwNTciLCJjaGFubmVsSWQiOiIwMDkifQ.E-Vhr_RQDliPak1RMc1ueouwNm3kUsLe7df1YbzlL2Q.duVRypALWhkmw6upKFXjDi";
        String token2 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwibW9iaWxlIjoiMDc2NTQzMjEwNCIsImV4cCI6MTU1NDExOTIwNzY1NSwidXNlcklkIjoiMDA5MDAxNTQ4OTMzMTM1MDczMjA4OTgxNzYiLCJjaGFubmVsSWQiOiIwMDkifQ.daIGYg6U3kOi856A-n84llDoLr1CeDpIFRdzQSkuNGk.GfmFzYii4d38Tq4htuvJmE";
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
                String betOrderRes =  HttpServiceUtils.sendRequest(cdxBetOrderUrl+"&token="+token1+"&rawNumber="+periodId+"%23"+"001"+"%7c"+betOpt+"~"+betAmount);
                System.out.println("cdx1"+betOrderRes);
            }
            for(String key : initMap.keySet()){
                betAmount = "10000";
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(cdxBetOrderUrl+"&token="+token2+"&rawNumber="+periodId+"%23"+"001"+"%7c"+betOpt+"~"+betAmount);
                System.out.println("cdx2"+betOrderRes);
            }
        }

    }

}
