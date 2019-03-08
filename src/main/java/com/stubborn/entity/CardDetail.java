package com.stubborn.entity;

/**
 * @author 丁少东
 * @create 2018-12-20 上午10:33
 **/
public class CardDetail {

    private String index;
    private Integer num;
    private String color;


    public CardDetail() {
    }

    public CardDetail(String index, Integer num, String color) {
        this.index = index;
        this.num = num;
        this.color = color;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
