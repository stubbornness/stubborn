package com.stubborn.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author 丁少东
 * @create 2019-05-10 上午9:23
 **/
public class TestBigdecimal {
    public static void main(String[] args) {
       /* BigDecimal betAmount = new BigDecimal(100.00);
        BigDecimal bonusSp = new BigDecimal(950);
        BigDecimal oddsMultiples = new BigDecimal(1000);
        BigDecimal bonus = betAmount.multiply(bonusSp).divide(oddsMultiples, 2, BigDecimal.ROUND_HALF_EVEN);

        //四舍六入五留双
        System.out.println(bonus.toString());*/

      /*  JSONObject betOrder = new JSONObject();
        BigDecimal decimal = new BigDecimal(100.49);
        betOrder.put("amount", decimal.longValue());
        String str = JSON.toJSONString(betOrder);

        JSONObject json = JSONObject.parseObject(str);
        BigDecimal amount = json.getBigDecimal("amount");
        amount = amount.multiply(new BigDecimal(100));
        System.out.println(amount);*/


  /*      BigDecimal betAmount = new BigDecimal("100.01");
        BigDecimal bonusSp = new BigDecimal(100);
        BigDecimal bonus = betAmount.multiply(bonusSp);

        //四舍六入五留双
        System.out.println(bonus.toString());*/


        //投注金额
 /*       BigDecimal betAmout = new BigDecimal(10.00);
        BigDecimal bonus = BigDecimal.ZERO;

        BigDecimal bonusOdds = new BigDecimal("0.24");
        bonus = betAmout.multiply(bonusOdds);
        bonus.setScale(2,BigDecimal.ROUND_HALF_EVEN);
        System.out.println(bonus.toString());*/


 /*       BigDecimal bonus = BigDecimal.ZERO;
        int betAmout = new BigDecimal(10.00).intValue();
        bonus = bonus.add(new BigDecimal(Double.parseDouble("0.24") * betAmout));
        bonus.setScale(2,BigDecimal.ROUND_HALF_EVEN);
        System.out.println(bonus);*/


        BigDecimal betAmout = new BigDecimal(4.80);

        BigDecimal bonus = betAmout.setScale(2,BigDecimal.ROUND_HALF_EVEN);
        System.out.println(bonus);









    }
}
