package com.stubborn.test.iterator;

import com.stubborn.entity.Girl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 丁少东
 * @create 2018-07-17 上午10:39
 **/
public class TestIterator {
    public static void main(String[] args) {

        List<Girl> girlList = new ArrayList<>();
        Girl girl1 = new Girl(1L, "tom", 26, 5000.00D, "shanghai");
        Girl girl2 = new Girl(2L, "jack", 24, 4000.00D, "xian");
        Girl girl3 = new Girl(3L, "bob", 28, 9000.00D, "beijing");

        girlList.add(girl1);
        girlList.add(girl2);
        girlList.add(girl3);

        Iterator<Girl> iterators = girlList.iterator();
        while (iterators.hasNext()){
            Girl girl = iterators.next();
            if (girl.getAge()==24){
                iterators.remove();
            }
        }

    }
}
