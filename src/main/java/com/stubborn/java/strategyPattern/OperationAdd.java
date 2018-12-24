package com.stubborn.java.strategyPattern;

/**
 * @author 丁少东
 * @create 2018-12-21 下午2:34
 **/
public class OperationAdd implements Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
