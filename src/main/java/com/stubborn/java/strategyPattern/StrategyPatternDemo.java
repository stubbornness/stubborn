package com.stubborn.java.strategyPattern;

/**
 *
 * 策略模式
 *
 * @author 丁少东
 * @create 2018-12-21 下午2:36
 **/
public class StrategyPatternDemo {
    public static void main(String[] args) {

        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
