package com.stubborn.test;

import java.math.BigDecimal;

/**
 * @author 丁少东
 * @create 2018-09-07 下午2:03
 **/
public class TestLong {
    public static void main(String[] args) {
       /* BigDecimal bonus = new BigDecimal(0.19);
        System.out.println((bonus.setScale(0, BigDecimal.ROUND_HALF_UP)));*/
       TestLong testLong = new TestLong();
       System.out.println(testLong.fun());
    }

    public Object fun(){
        try{
            String str = "zhangqi";
            int num = Integer.parseInt(str);
        } catch (Exception e){
            System.out.println(e);
            return e.getMessage();
        } finally {
            System.out.println("11111111");
        }
        return null;
    }
}
