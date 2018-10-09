package com.stubborn.test;

import com.stubborn.entity.Boy;
import com.stubborn.util.CommonUtil;

import java.util.*;

/**
 * @author 丁少东
 * @create 2018-08-21 下午2:36
 **/
public class TesstString {
    public static void main(String[] args) {
            String winningNumber = null;
            int randomLoong = new Random().nextInt(13) + 1;
            int randomTiger = new Random().nextInt(13) + 1;
            if (randomLoong > randomTiger){
                winningNumber = "1";//龙盈
            }else if (randomLoong < randomTiger){
                winningNumber = "3";//虎赢
            }else{
                winningNumber = "2";//和
            }
            winningNumber =  CommonUtil.mergeStr(randomLoong,"_",null,"_",null);
            if (winningNumber.equals("1")||winningNumber.equals("2")||winningNumber.equals("3")){
                System.out.println("haha");
            }



    }
}
