package com.stubborn.java.strategyPattern;

/**
 * @author 丁少东
 * @create 2018-12-21 下午2:35
 **/
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}