package com.stubborn.entity;

/**
 * 扑克牌信息
 *
 * @author 丁少东
 * @create 2018-11-30 下午2:47
 **/
public class CardModel {

    private int number;
    private int color;

    public CardModel() {
    }

    public CardModel(int number, int color) {
        this.number = number;
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
