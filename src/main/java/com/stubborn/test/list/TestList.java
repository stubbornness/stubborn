package com.stubborn.test.list;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 丁少东
 * @create 2018-06-08 上午10:48
 **/
public class TestList {
    public static void main(String[] args) {
        List<Cinema> list1 = new ArrayList<>();
        Cinema cinema1 = new Cinema("1","tom");
        Cinema cinema2 = new Cinema("2","tom");

        list1.add(cinema1);
        list1.add(cinema2);
        final CopyOnWriteArrayList<Cinema> cowList = new CopyOnWriteArrayList<Cinema>(list1);

        for (Cinema cinema : cowList){
            if (cinema.getId().equals("1")){
                cowList.remove(cinema);
            }
        }
        System.out.println(list1);





    }


}
