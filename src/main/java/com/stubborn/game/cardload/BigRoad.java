package com.stubborn.game.cardload;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 丁少东
 * @create 2018-12-12 下午6:49
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BigRoad implements Serializable {

    private final List<GameRaw> gameRawList = new LinkedList<>();

    private String preResut;

    private GameRaw gameRaw;

/*    public List<GameRaw> add(List<String> list1) {
        for (String result : list1 ){
            if (preResut != null && !StringUtils.equals(result, "3") && !StringUtils.equals(result, preResut)) {
                Boolean flag = false;
                for (ResultInfo res : gameRawList.get(gameRawList.size() - 1).getResultInfoList()){
                    if (res.getResult().equals(result)){
                        flag = true;
                    }
                }
                if (!flag){
                    gameRawList.add(new GameRaw());
                }
            }
            gameRaw = last();
            gameRaw.add(result);
            preResut = result;
        }
        return gameRawList;
    }*/

    public List<GameRaw> add(List<String> list1) {
        for (String result : list1 ){
            if (preResut != null && !StringUtils.equals(result, "3") && !StringUtils.equals(result, preResut)) {
                Boolean flag = false;
                for (ResultInfo res : gameRaw.getResultInfoList()){
                    if (res.getResult().equals(result)){
                        flag = true;
                    }
                }
                if (!flag){
                    gameRawList.add(new GameRaw());
                }
            }
            gameRaw = last();
            gameRaw.add(result);
            preResut = result;
        }
        return gameRawList;
    }


    private GameRaw last() {
        if (gameRawList.isEmpty()) {
            gameRawList.add(new GameRaw());
        }
        return gameRawList.get(gameRawList.size() - 1);
    }

    public String toString() {
        return gameRawList.toString();
    }

}
