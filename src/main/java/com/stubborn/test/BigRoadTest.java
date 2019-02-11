package com.stubborn.test;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author 丁少东
 * @create 2018-12-12 下午2:55
 **/
public class BigRoadTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s1 = "1";
        String s2 = "2";
        String s3 = "3";
        String s4 = "1";
        String s5 = "3";
        String s6 = "2";
        String s7 = "3";
        String s8 = "2";
        String s9 = "2";
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);
        list.add(s7);
        list.add(s8);
        list.add(s9);
        List<List<Map<String,Integer>>> listMaps =  new ArrayList<>();
        BigRoadTest t = new BigRoadTest();
        BigRoad a = t.new BigRoad();
        List<GameRaw> list2 = a.add(list);
        System.out.println(list2);

    }

    private class ResultInfo {
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

    private class  GameRaw {
        private final List<ResultInfo> list = new LinkedList<>();

        private ResultInfo pre;

        public void add (String result) {
            if (pre == null || !StringUtils.equals(result, "3")) {
                list.add(new ResultInfo(result));
                pre = last();
            } else {
                pre.incr();
            }

        }

        private ResultInfo last() {
            return list.isEmpty() ? null : list.get(list.size() - 1);
        }

        public String toString() {
            return list.toString();
        }
    }

    private class BigRoad {
        private final List<GameRaw> list = new LinkedList<>();

        private String preResut;

        private GameRaw preList;

        public List<GameRaw> add(List<String> list1) {
            for(String result : list1){
                result = result.split("_")[0];
                if (preResut != null && !StringUtils.equals(result, "3") && !StringUtils.equals(result, preResut)) {
                    list.add(new GameRaw());
                }
                preList = last();
                preList.add(result);
                preResut = result;
            }
            return list;

        }

        private GameRaw last() {
            if (list.isEmpty()) {
                list.add(new GameRaw());
            }
            return list.get(list.size() - 1);
        }

        public String toString() {
            return list.toString();
        }
    }


}
