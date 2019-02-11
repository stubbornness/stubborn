package com.stubborn.test;

import com.stubborn.util.CommonUtil;
import java.util.*;

/**
 * @author 丁少东
 * @create 2019-01-18 上午9:51
 **/
public class TestRemoveList {


    private static final String LOONG_WIN = "1";

    private static final String TIGER_WIN = "3";

    private static final String HE = "2";
 /*   public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("3","3","1","3","2","3"));
        System.out.println(removeTieList(list));

    }*/


 /*   public static List<String> removeTieList(List<String> list){
        Iterator<String> it = list.iterator();
        int x = 0;
        int y = 0;
        while (it.hasNext()){
            if (it.next().contains("3")){
                if (x == y){
                    it.remove();
                    y++;
                }
            }
            x++;

        }
        return list;

    }


  *//*  public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("1","2","3"));
        list.get(4);
    }*//*

    public static void main(String[] args) {
       *//* String str = "008_11_12";
        str = str.substring(0,4);
        System.out.println(str);*//*
        BigDecimal totalAmount = new BigDecimal(4000);
        BigDecimal returnAmount = new BigDecimal(6000);//总返奖金额

        if ((totalAmount.subtract(returnAmount).compareTo(new BigDecimal(-1000)) > 0)){
            System.out.println(1);

        }

    }*/


 /*   public final static Map<String, String> initMap = new HashMap();

    static {
        initMap.put("1", "1,2,3,4,5");
        initMap.put("2", "7,8,9,10,11");
        initMap.put("3", "6");
    }*/

    public static final String DA = "1";
    public static final String XIAO = "2";
    public static final String FA = "3";

/*    public static void main(String[] args) {
        TestRemoveList testRemoveList = new TestRemoveList();
        testRemoveList.openAward(12L,"12");
    }*/

    /*   public static void main(String[] args) {
           String prePeriodId = String.valueOf(Long.parseLong("218201901231056") - 1);
           System.out.println(prePeriodId);

       }*/
    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            System.out.println(riskManage(new ArrayList<>(Arrays.asList("1","3"))));
        }
    }

    public static Map<String, String> riskManage(List<String> list){
        int size = list.size();
        if (size == 0 || size ==3){
            return commonOutputCase();
        }else if (size == 1){
            return specialOutputCase(list.get(0));
        }else{
            StringBuffer sb = new StringBuffer();
            for (String element : list){
                if (LOONG_WIN.equals(element)){
                    sb.append("1,2,3,4,5,6");

                }
                if (TIGER_WIN.equals(element)){
                    sb.append("8,9,10,11,12,13");
                }
                if (HE.equals(element)){
                    sb.append("7");
                }
                sb.append(",");
            }
            System.out.println("sb"+sb.toString());
            String [] randomNumArr = sb.toString().split(",");
            int randomNum = new Random().nextInt(randomNumArr.length);
            int gameNum = Integer.valueOf(randomNumArr[randomNum]);
            return specialOutputCase(outputGameCaseByNumber(gameNum));
        }
    }

    public static String outputGameCaseByNumber(int randomNum){
        String result = null;
        if (randomNum > 7) {
            result = TIGER_WIN;
        } else if (randomNum < 7) {
            result = LOONG_WIN;
        } else {
            result = HE;
        }
        return result;
    }



    public static Map<String, String> specialOutputCase(String symbol){
        String winningNumber = null;
        int randomLoong = new Random().nextInt(13) + 1;
        int randomTiger = new Random().nextInt(13) + 1;
        if (LOONG_WIN.equals(symbol)){
            if (randomLoong > randomTiger){
                winningNumber =  CommonUtil.mergeStr(randomLoong,"_",randomTiger,"_",LOONG_WIN);
            }else if (randomLoong < randomTiger){
                winningNumber =  CommonUtil.mergeStr(randomTiger,"_",randomLoong,"_",LOONG_WIN);
            }else {
                if (randomLoong == 1){
                    winningNumber =  CommonUtil.mergeStr(randomLoong + 1,"_",randomTiger,"_",LOONG_WIN);
                }else {
                    winningNumber =  CommonUtil.mergeStr(randomLoong,"_",randomTiger - 1,"_",LOONG_WIN);
                }
            }
        }else if (TIGER_WIN.equals(symbol)){
            if (randomLoong > randomTiger){
                winningNumber =  CommonUtil.mergeStr(randomTiger,"_",randomLoong,"_",TIGER_WIN);
            }else if (randomLoong < randomTiger){
                winningNumber =  CommonUtil.mergeStr(randomLoong,"_",randomTiger,"_",TIGER_WIN);
            }else {
                if (randomLoong == 1){
                    winningNumber =  CommonUtil.mergeStr(randomLoong,"_",randomTiger+1,"_",TIGER_WIN);
                }else {
                    winningNumber =  CommonUtil.mergeStr(randomLoong-1,"_",randomTiger,"_",TIGER_WIN);
                }
            }
        }else {
            System.out.println("haha"+symbol);
            winningNumber =  CommonUtil.mergeStr(randomLoong,"_",randomLoong,"_",HE);
        }
        Map<String, String> map = new HashMap<>();
        map.put("result", symbol);
        map.put("winningNumber", winningNumber);
        return map;
    }


    public static Map<String,String> commonOutputCase(){
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
        Map<String, String> map = new HashMap<>();
        map.put("result", winningNumber);
        winningNumber =  CommonUtil.mergeStr(randomLoong,"_",randomTiger,"_",winningNumber);
        map.put("winningNumber", winningNumber);
        return map;
    }









}
