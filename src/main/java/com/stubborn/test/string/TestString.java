package com.stubborn.test.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 丁少东
 * @create 2018-06-10 上午11:17
 **/
public class TestString {
    public static void main(String[] args) {
        String str = "abcdefg";
     String [] arr = str.split("");
     List<String> list = Arrays.asList(arr);
     Collections.reverse(list);
        System.out.println(list);
    }
}
