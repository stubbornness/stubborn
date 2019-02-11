package com.stubborn.game.cardload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 丁少东
 * @create 2018-12-12 下午6:50
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameRaw implements Serializable {
    private final List<ResultInfo> resultInfoList = new LinkedList<>();

    private ResultInfo resultInfo;

    public void add (String result) {
        if (resultInfo == null || !StringUtils.equals(result, "3")) {
            resultInfoList.add(new ResultInfo(result));
            resultInfo = last();
        } else {
            resultInfo.incr();
        }
    }

    public ResultInfo last() {
        return resultInfoList.isEmpty() ? null : resultInfoList.get(resultInfoList.size() - 1);
    }

    public String toString() {
        return resultInfoList.toString();
    }
}
