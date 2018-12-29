package com.stubborn.java.strategyPattern.bjlgame;



import java.util.Map;

/**
 * @author 丁少东
 * @create 2018-12-28 上午9:59
 **/
public class Test {
    public static void main(String[] args) {
        Class<? extends BjlOpenAwardInterface> aClass = GameUtil.outEvent();
       // BjlOpenAwardInterface bean = SpringContextHolder.getBean(aClass);
       // Map<String, Integer> stringIntegerMap = bean.outputCard();

    }
}
