package com.stubborn.game.cardload;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 丁少东
 * @create 2018-12-29 下午3:18
 **/
public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("1","1","2","2","3","2","1"));
        BigRoad bigRoad = new BigRoad();
        System.out.println(bigRoad.add(list));
    }
}
