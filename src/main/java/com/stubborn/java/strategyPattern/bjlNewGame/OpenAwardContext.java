package com.stubborn.java.strategyPattern.bjlNewGame;

/**
 * @author 丁少东
 * @create 2018-12-24 下午4:38
 **/
public class OpenAwardContext {

    private OpenAwardInterface openAwardInterface;

    public OpenAwardContext(OpenAwardInterface openAwardInterface) {
        this.openAwardInterface = openAwardInterface;
    }

    public void executeStrategy(String cardInfo){
         openAwardInterface.outputCardDetail(cardInfo);
    }
}
