package com.stubborn;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author 丁少东
 * @create 2019-01-29 上午9:46
 **/
public class TestMap {


    public static void main(String[] args) {
        Map<String, BigDecimal> returnAmountMap = new HashMap<>();
        returnAmountMap.put("1",new BigDecimal(100));
        returnAmountMap.put("2",new BigDecimal(-10));
        returnAmountMap.put("3",new BigDecimal(0));

        System.out.println(getMinValue(returnAmountMap));

    }

    public static Object getMinValue(Map<String, BigDecimal> map) {
        if (map == null) return null;
        List<Map.Entry<String,BigDecimal>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (o1, o2) -> (o1.getValue().subtract(o2.getValue()).intValue()));
        return list.get(0).getKey();

    }

}
