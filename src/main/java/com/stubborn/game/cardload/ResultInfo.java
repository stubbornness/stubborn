package com.stubborn.game.cardload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 丁少东
 * @create 2018-12-12 下午6:50
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo implements Serializable {

    private String result;
    private int count;

    ResultInfo (String result) {
        this.result = result;
    }

    public void incr() {
        ++count;
    }

    public String toString() {
        return result + (count > 0 ? "_" + count:"");
    }

}
