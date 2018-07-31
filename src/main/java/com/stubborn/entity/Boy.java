package com.stubborn.entity;

/**
 * @author 丁少东
 * @create 2018-07-30 上午10:49
 **/
public class Boy {
    private String code;
    private int num;

    public Boy() {
    }

    public Boy(String code, int num) {
        this.code = code;
        this.num = num;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
