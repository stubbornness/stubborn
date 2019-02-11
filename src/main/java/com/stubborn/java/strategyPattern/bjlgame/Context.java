package com.stubborn.java.strategyPattern.bjlgame;

import java.util.Map;

/**
 * @author 丁少东
 * @create 2018-12-21 下午2:35
 **/
public class Context {
    private BjlOpenAwardInterface bjlOpenAwardInterface;

    public Context(BjlOpenAwardInterface bjlOpenAwardInterface){
        this.bjlOpenAwardInterface = bjlOpenAwardInterface;
    }

    public Map<String,Integer> executeStrategy(){
        return bjlOpenAwardInterface.outputCard();
    }
}