package com.stubborn.oop_test;

/**
 * final修饰测试case
 *
 * @author 丁少东
 * @create 2018-11-13 下午4:28
 **/
public class FinalTest {
    final FinalTestModel finalTestModel = new FinalTestModel();

    public static void main(String[] args) {
        FinalTest finalTest = new FinalTest();
        finalTest.finalTestModel.setName("jack");
        System.out.println(finalTest.finalTestModel.getName());

    }
}
