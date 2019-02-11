package com.stubborn.game.cardload;

import com.stubborn.game.GameUtil;

import java.util.*;

/**
 * @author 丁少东
 * @create 2019-01-02 上午11:25
 **/
public class TestRiskManage {

    public static final String OPEN_AWARD_EVENT1 = "1";
    public static final String OPEN_AWARD_EVENT2 = "2";
    public static final String OPEN_AWARD_EVENT3 = "3";
    public static final String OPEN_AWARD_EVENT1_4 = "1_4";
    public static final String OPEN_AWARD_EVENT1_5 = "1_5";
    public static final String OPEN_AWARD_EVENT2_4 = "2_4";
    public static final String OPEN_AWARD_EVENT2_5 = "2_5";
    public static final String OPEN_AWARD_EVENT3_4 = "3_4";
    public static final String OPEN_AWARD_EVENT3_5 = "3_5";
    public static final String OPEN_AWARD_EVENT1_4_5 = "1_4_5";
    public static final String OPEN_AWARD_EVENT2_4_5 = "2_4_5";
    public static final String OPEN_AWARD_EVENT3_4_5 = "3_4_5";


    public final static Map<String, Integer> initMap = new HashMap();

    static {
        initMap.put("1", 446247);
        initMap.put("2", 458597);
        initMap.put("3", 95156);
        initMap.put("1_4", 34173);
        initMap.put("1_5", 34173);
        initMap.put("2_4", 35082);
        initMap.put("2_5", 35082);
        initMap.put("3_4", 7279);
        initMap.put("3_5", 7279);
        initMap.put("1_4_5", 2614);
        initMap.put("2_4_5", 2684);
        initMap.put("3_4_5", 557);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("1_4","1_5","1_4_5"));
        System.out.println(riskManage(list));
    }


    public static String riskManage(List<String> list){
        Map<String, Integer> map1 = new HashMap<>();
        String index = "";
        Integer total = 0;

        for (int i = 0; i < list.size() ; i++) {
            index = list.get(i);
            Integer value = initMap.get(index);
            map1.put(index, initMap.get(index));
            total += value;
        }

        Integer randomEvent = GameUtil.commonOutputCard(total, 1);
        Integer start = 0;
        Integer end = 0;
        String result = "";
        for (String key : map1.keySet()){
            end = map1.get(key);
            end = end + start;
            if (start < randomEvent && randomEvent <= end){
                result = key;
                break;
            }
            start = end;
        }
        return result;
    }

}
