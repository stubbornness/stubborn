package com.stubborn.test.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author 丁少东
 * @create 2018-12-29 上午9:53
 **/
public class RemoveList {
    public static void main(String[] args) {
        List<Cinema> list = new ArrayList<>(Arrays.asList(new Cinema("1","tom"), new Cinema("2","tom")));
        Iterator<Cinema> iterator = list.iterator();
        List<Cinema> list1 = new ArrayList<>();
        while(iterator.hasNext()){
            Cinema cinema = iterator.next();
            if ("1".equals(cinema.getId())){
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
