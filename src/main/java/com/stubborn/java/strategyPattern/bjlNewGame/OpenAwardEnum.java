package com.stubborn.java.strategyPattern.bjlNewGame;

public enum OpenAwardEnum {
    PLAY("闲赢", "1"), BANK("庄赢", "2"), TIE("和赢", "3"),
    PLAY_PLAYPAIR("闲赢+闲对", "1_4"), PLAY_BANKPAIR("闲赢+庄对", "1_5"),
    BANK_PLAYPAIR("闲赢+闲对", "2_4"), BANK_BANKPAIR("闲赢+庄对", "2_5"),
    TIE_PLAYPAIR("闲赢+闲对", "2_4"), TIE_BANKPAIR("闲赢+庄对", "2_5"),
    PLAY_PLAYPAIR_BANKPAIR("闲赢+闲对+庄对", "1_4_5"), BANK_PLAYPAIR_BANKPAIR("庄赢+闲对+庄对", "2_4_5"),
    TIE_PLAYPAIR_BANKPAIR("和赢+闲对+庄对", "3_4_5");




    private String name;
    private String value;

    OpenAwardEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    OpenAwardEnum() {
    }

    public static void getName(String value){
        for (OpenAwardEnum openAwardEnum : OpenAwardEnum.values()){
            if (openAwardEnum.value.equals(value)){
               // return

            }
        }

    }





}
