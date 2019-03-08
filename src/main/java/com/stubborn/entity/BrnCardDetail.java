package com.stubborn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author 丁少东
 * @create 2018-12-20 上午10:33
 **/
@NoArgsConstructor
@Data
@ToString
public class BrnCardDetail {

    private Integer index;
    private List<CardDetail> cardDetails;
    private Integer niuNum;
    private String upCard;
    private Integer maxNum;
    private Integer maxNumColor;


    public BrnCardDetail(Integer index, List<CardDetail> cardDetails, Integer niuNum, String upCard, Integer maxNum, Integer maxNumColor) {
        this.index = index;
        this.cardDetails = cardDetails;
        this.niuNum = niuNum;
        this.upCard = upCard;
        this.maxNum = maxNum;
        this.maxNumColor = maxNumColor;
    }
}