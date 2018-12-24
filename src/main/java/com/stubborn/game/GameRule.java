package com.stubborn.game;

/**
 * @author 丁少东
 * @create 2018-12-19 下午3:49
 **/
public class GameRule implements StrategyInterface{

    private String rule;

    private StrategyInterface strategyInterface;

    public GameRule() {
    }

    public GameRule(String rule) {
        this.rule = rule;
    }

    public void openAward(){
        System.out.println("haha");
    }



}
