package com.stubborn.java.strategyPattern;

/**
 * @author 丁少东
 * @create 2018-12-21 下午2:35
 **/
public class OperationMultiply implements Strategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
