package com.stubborn.exception;

/**
 * @author 丁少东
 * @create 2019-01-17 下午1:16
 **/
public class TestException {
   /* public static void main(String[] args) {
        String str = "1,2,3";
        String arr [] = str.split(",");
        String str1 = arr[2];
        if (str1.equals("3")){
            throw new BusinessException("hhah");
        }
        System.out.println("123");//不会执行123
    }*/


    public static void main(String[] args) {
        String str = "1,2,3";
        String arr [] = str.split(",");
        try{
            String str1 = arr[4];
            System.out.println("001");
        }catch (Exception e){
            System.out.println("002");
        }
        System.out.println("003");
    }
}
