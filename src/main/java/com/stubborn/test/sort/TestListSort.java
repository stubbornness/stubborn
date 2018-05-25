package com.stubborn.test.sort;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 丁少东
 * @create 2018-05-25 下午5:57
 **/
public class TestListSort {
    public static void main(String[] args) {
        Person p1 = new Person("001","jack",new Timestamp(1527242294000L));
        Person p2 = new Person("002","tom",new Timestamp(1527242394000L));
        Person p3 = new Person("003","lily",new Timestamp(1527244294000L));
        Person p4 = new Person("004","mark",new Timestamp(1527245294000L));

        List<Person> list = new ArrayList<Person>();
        list.add(p2);
        list.add(p1);
        list.add(p4);
        list.add(p3);

        Collections.sort(list);
        Collections.reverse(list);



    }
}
