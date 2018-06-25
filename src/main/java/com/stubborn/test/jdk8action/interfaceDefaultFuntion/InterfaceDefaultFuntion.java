package com.stubborn.test.jdk8action.interfaceDefaultFuntion;


/**
 * Java 8允许我们给接口添加一个非抽象的方法实现，
 * 只需要使用 default关键字即可，这个特征又叫做扩展方法，示例如下：
 */
public interface InterfaceDefaultFuntion {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
