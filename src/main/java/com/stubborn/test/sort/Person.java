package com.stubborn.test.sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author 丁少东
 * @create 2018-05-25 下午5:51
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable,Comparable<Person> {
    private String id;
    private String name;
    private Timestamp createTime;


    @Override
    public int compareTo(Person o) {
        return this.createTime.compareTo(o.createTime);
    }
}
