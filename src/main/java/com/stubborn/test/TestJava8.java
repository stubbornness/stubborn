package com.stubborn.test;

import com.stubborn.entity.Boy;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 丁少东
 * @create 2019-01-16 下午4:43
 **/
public class TestJava8 {
    public static void main(String[] args) {

        List<Boy> list = new ArrayList<>(Arrays.asList(new Boy("001",1),new Boy("002",2)));
        list.stream().filter(code-> "001".equals(code.getCode())).collect(Collectors.toList());

    }
}
