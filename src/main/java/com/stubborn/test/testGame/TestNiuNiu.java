package com.stubborn.test.testGame;

import com.stubborn.entity.BrnCardDetail;
import com.stubborn.entity.CardDetail;
import com.stubborn.test.TestLong;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author 丁少东
 * @create 2019-03-12 下午3:16
 **/
public class TestNiuNiu {

    public static void main(String[] args) {
        int i =0;
        if (i == 0){
            System.out.println(0);
        }
        System.out.println(1);
    }


   /* private final static Map<String, BigDecimal> initMap = new HashMap<>();

    static {
        initMap.put("1", BigDecimal.ZERO);
        initMap.put("2", BigDecimal.ZERO);
        initMap.put("3", BigDecimal.ZERO);
        initMap.put("5", BigDecimal.ZERO);
        initMap.put("6", BigDecimal.ZERO);
    }

    public final static Map<String, String> brnCardMap = new LinkedHashMap<>();

    static {
        brnCardMap.put("0_1_2", "3_4");
        brnCardMap.put("0_1_3", "2_4");
        brnCardMap.put("0_1_4", "2_3");
        brnCardMap.put("0_2_3", "1_4");
        brnCardMap.put("0_2_4", "1_3");
        brnCardMap.put("0_3_4", "1_2");
        brnCardMap.put("1_2_3", "0_4");
        brnCardMap.put("1_2_4", "0_3");
        brnCardMap.put("1_3_4", "0_2");
    }

    public static void main(String[] args) {
        TestNiuNiu test = new TestNiuNiu();
        List<BrnCardDetail> list = test.outputCardInfo();
    }


    public List<BrnCardDetail> outputCardInfo(){
        List<BrnCardDetail> list = new ArrayList<>();
        BrnCardDetail brnCardDetail = null;
        Integer maxIndex = null;
        Integer maxNum = null;
        Integer maxNumColor = null;
        for (int i = 0; i < 6; i++) {
            List<CardDetail> cardDetails = outputSingleCardInfo(i);
            maxIndex = getMaxNum(cardDetails);
            String [] keyArr = null;
            Integer niuNum = 0;
            String maxKey = null;
            Integer maxValue = 0;
            for (String key : brnCardMap.keySet()){
                Integer sum = 0;
                keyArr = key.split("_");
                for (String key1 : keyArr){
                    int num = cardDetails.get(Integer.valueOf(key1)).getNum();
                    if (num > 10){
                        num = 10;
                    }
                    sum = sum + num;
                }
                if (sum % 10 == 0){
                    String valueArr [] = brnCardMap.get(key).split("_");
                    Integer value1 = cardDetails.get(Integer.parseInt(valueArr[0])).getNum();
                    if (value1 > 10){
                        value1 = 10;
                    }
                    Integer value2 = cardDetails.get(Integer.parseInt(valueArr[1])).getNum();
                    if (value2 > 10){
                        value2 = 10;
                    }
                    Integer sumValue =  value1 + value2;
                    if (sumValue > 10){
                        niuNum = sumValue - 10;
                    }else {
                        niuNum = sumValue;
                    }
                    if (maxValue < niuNum){
                        maxValue = niuNum;
                        maxKey = key;
                    }
                }
            }
            maxNum = cardDetails.get(maxIndex).getNum();
            maxNumColor = Integer.parseInt(cardDetails.get(maxIndex).getColor());
            if (maxKey == null){
                brnCardDetail = new BrnCardDetail(i+1,cardDetails,0,"",maxNum,maxNumColor);
            }else{
                brnCardDetail = new BrnCardDetail(i+1,cardDetails,maxValue, brnCardMap.get(maxKey),maxNum,maxNumColor);
            }
            list.add(brnCardDetail);
        }
        return list;
    }



    public List<CardDetail> outputSingleCardInfo(int index){
        if (index == 0){
            List<CardDetail> cardDetails = new ArrayList<>();
            CardDetail cardDetail0 = new CardDetail("0",12,"1");
            CardDetail cardDetail1 = new CardDetail("1",2,"1");
            CardDetail cardDetail2 = new CardDetail("2",8,"1");
            CardDetail cardDetail3 = new CardDetail("3",9,"1");
            CardDetail cardDetail4 = new CardDetail("4",5,"1");
            cardDetails.add(cardDetail0);
            cardDetails.add(cardDetail1);
            cardDetails.add(cardDetail2);
            cardDetails.add(cardDetail3);
            cardDetails.add(cardDetail4);
            return cardDetails;
        }
        if (index == 1){
            List<CardDetail> cardDetails = new ArrayList<>();
            CardDetail cardDetail0 = new CardDetail("0",9,"1");
            CardDetail cardDetail1 = new CardDetail("1",10,"1");
            CardDetail cardDetail2 = new CardDetail("2",6,"1");
            CardDetail cardDetail3 = new CardDetail("3",8,"1");
            CardDetail cardDetail4 = new CardDetail("4",13,"1");
            cardDetails.add(cardDetail0);
            cardDetails.add(cardDetail1);
            cardDetails.add(cardDetail2);
            cardDetails.add(cardDetail3);
            cardDetails.add(cardDetail4);
            return cardDetails;
        }    if (index == 2){
            List<CardDetail> cardDetails = new ArrayList<>();
            CardDetail cardDetail0 = new CardDetail("0",12,"1");
            CardDetail cardDetail1 = new CardDetail("1",11,"1");
            CardDetail cardDetail2 = new CardDetail("2",4,"1");
            CardDetail cardDetail3 = new CardDetail("3",7,"1");
            CardDetail cardDetail4 = new CardDetail("4",2,"1");
            cardDetails.add(cardDetail0);
            cardDetails.add(cardDetail1);
            cardDetails.add(cardDetail2);
            cardDetails.add(cardDetail3);
            cardDetails.add(cardDetail4);
            return cardDetails;
        }    if (index == 3){
            List<CardDetail> cardDetails = new ArrayList<>();
            CardDetail cardDetail0 = new CardDetail("0",4,"1");
            CardDetail cardDetail1 = new CardDetail("1",3,"1");
            CardDetail cardDetail2 = new CardDetail("2",3,"1");
            CardDetail cardDetail3 = new CardDetail("3",1,"1");
            CardDetail cardDetail4 = new CardDetail("4",1,"1");
            cardDetails.add(cardDetail0);
            cardDetails.add(cardDetail1);
            cardDetails.add(cardDetail2);
            cardDetails.add(cardDetail3);
            cardDetails.add(cardDetail4);
            return cardDetails;
        }    if (index == 4){
            List<CardDetail> cardDetails = new ArrayList<>();
            CardDetail cardDetail0 = new CardDetail("0",11,"1");
            CardDetail cardDetail1 = new CardDetail("1",9,"1");
            CardDetail cardDetail2 = new CardDetail("2",5,"1");
            CardDetail cardDetail3 = new CardDetail("3",10,"1");
            CardDetail cardDetail4 = new CardDetail("4",9,"1");
            cardDetails.add(cardDetail0);
            cardDetails.add(cardDetail1);
            cardDetails.add(cardDetail2);
            cardDetails.add(cardDetail3);
            cardDetails.add(cardDetail4);
            return cardDetails;
        }    if (index == 5){
            List<CardDetail> cardDetails = new ArrayList<>();
            CardDetail cardDetail0 = new CardDetail("0",7,"1");
            CardDetail cardDetail1 = new CardDetail("1",8,"1");
            CardDetail cardDetail2 = new CardDetail("2",1,"1");
            CardDetail cardDetail3 = new CardDetail("3",6,"1");
            CardDetail cardDetail4 = new CardDetail("4",10,"1");
            cardDetails.add(cardDetail0);
            cardDetails.add(cardDetail1);
            cardDetails.add(cardDetail2);
            cardDetails.add(cardDetail3);
            cardDetails.add(cardDetail4);
            return cardDetails;
        }
        return null;

    }



    public Integer getMaxNum(List<CardDetail> list) {
        Integer maxNum = 0;
        String maxIndex = null;
        for (CardDetail cardDetail : list){
            if (cardDetail.getNum() > maxNum){
                maxNum = cardDetail.getNum();
                maxIndex = cardDetail.getIndex();
            }
        }
        return Integer.parseInt(maxIndex);
    }
*/

}
