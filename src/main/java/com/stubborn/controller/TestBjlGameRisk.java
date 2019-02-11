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
public class TestBjlGameRisk {

    public final static long EXECUTION_TIME =  45 * 1000;

    public final static Map<String,String> map = new LinkedHashMap<>();
    static {//闲对||庄对：0.076499
        map.put("1", "1");//闲:0.458597
        map.put("2", "2");//庄:0.446247
        map.put("3", "1_2_3");//和:0.095156//开三的话要退还押和的钱
        map.put("4", "1_4");//
        map.put("5", "1_5");//
    }


    //接口地址
    @Value("${bjlPeriodUrl}")
    private String bjlPeriodUrl;

    @Value("${bjlBetOrderUrl}")
    private String bjlBetOrderUrl;



    //@Scheduled(fixedDelay = EXECUTION_TIME)
    public void testGameRisk() {
        //gameEn=bjl&betFlag=0&rawNumber=218201901031349%23001%7c1~100|2~100|3~100|
        String periodRes = HttpServiceUtils.sendRequest(bjlPeriodUrl);
        JSONObject period = JSONObject.parseObject(JSONObject.parseObject(periodRes).getString("resp"));
        Long betTime = period.getLongValue("countDown");
        String periodId = period.getString("periodId");
        String token1 = "eyJhbGciOiJIUzI1NiJ9.eyJpc1NldFBhc3N3ZCI6dHJ1ZSwibW9iaWxlIjoiMDc2NTQzMjEwMSIsImV4cCI6MTU1NDExODk1OTY3NCwidXNlcklkIjoiMDA5MDAxNTQ4OTMyODQ3MzkwMzg4MDk2MjEiLCJjaGFubmVsSWQiOiIwMDkifQ.f6aA-wVABfmnyAKwbn0o0JdmQrEKxlPC6UK3fh3NITw.yFGhEiYWgSHLiPgLPpKjC4";
        String betOpt = null;
        String betAmount = null;
        String betAmountStr = "20,100,1000,10000";
        String [] betAmountArr = betAmountStr.split(",");
        Integer randomNum = null;
        if (betTime > 3){
            for(String key : map.keySet()){
                randomNum = new Random().nextInt(4);
                betAmount = betAmountArr[randomNum];
                betOpt = key;
                String betOrderRes =  HttpServiceUtils.sendRequest(bjlBetOrderUrl+"&token="+token1+"&gameEn=bjl&betFlag=0"+"&rawNumber="+periodId+"%23"+"001"+"%7c"+betOpt+"~"+betAmount);
                System.out.println("bjl1"+betOrderRes);
            }
        }

    }

}
