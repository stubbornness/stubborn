package com.stubborn.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 丁少东
 * @create 2018-12-12 下午6:38
 **/
public class TestRemoveList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s1 = "3";
        String s2 = "3";
        String s3 = "3";
        String s4 = "1";
        String s5 = "3";
        String s6 = "2";
        String s7 = "3";
        String s8 = "2";
        String s9 = "2";
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);
        list.add(s7);
        list.add(s8);
        list.add(s9);

        Iterator<String> it = list.iterator();
        int x = 0;
        int y = 0;
        while (it.hasNext()){
            if ("3".equals(it.next())){
                if (x == y){
                    it.remove();
                    y++;
                }
            }
            x++;

        }

        System.out.println(list);



    }
}
