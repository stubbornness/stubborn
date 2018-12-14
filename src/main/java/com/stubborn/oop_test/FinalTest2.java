package com.stubborn.oop_test;

/**
 * 测试final修饰的对象地址不可变
 *
 * @author 丁少东
 * @create 2018-11-16 上午9:30
 **/
public class FinalTest2 {

    public  void main(String[] args) {
        final Other other = new Other();
        //other = new Other();

    }

    class Other{
        private String name;
    }

}
