package com.stubborn.test;

import com.stubborn.entity.Boy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 丁少东
 * @create 2018-07-30 上午10:50
 **/
public class TestList {
    public static void main(String[] args) {
/*        List<Boy> boyList1 = new ArrayList<>();
        Boy boy1 = new Boy("001",1);
        Boy boy2 = new Boy("002",2);
        Boy boy3 = new Boy("003",3);
        boyList1.add(boy1);
        boyList1.add(boy2);
        boyList1.add(boy3);

        List<Boy> boyList2 = new ArrayList<>();
        Boy boy11 = new Boy("001",0);
        Boy boy22 = new Boy("005",0);
        Boy boy33 = new Boy("006",0);
        boyList2.add(boy11);
        boyList2.add(boy22);
        boyList2.add(boy33);

        Map<String,Object> maps = new HashMap<>();
        for (Boy boy : boyList2){
            maps.put(boy.getCode(),boy);
        }
        for (Boy boy : boyList1){
            maps.put(boy.getCode(),boy);
        }

        System.out.println(maps.values());*/

        BigDecimal bonus = BigDecimal.ZERO;
        bonus = new BigDecimal(100);
        System.out.println(bonus);

    }
}
