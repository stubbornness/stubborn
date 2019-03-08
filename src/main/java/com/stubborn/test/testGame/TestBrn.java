package com.stubborn.test.testGame;

import com.stubborn.entity.BrnCardDetail;
import com.stubborn.entity.CardDetail;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author 丁少东
 * @create 2019-03-05 下午3:08
 **/
public class TestBrn {


    public static final String JACKPOT_DEFAULT_VALUE = "jackPotDefaultValue";

    public static final Integer GAME_SWITCH = 0;

    public static final String GAME_ALARM_SWITCH = "1";

    private final static Map<String, BigDecimal> initMap = new HashMap<>();

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

    public final static Map<String, String> gameCaseMap = new LinkedHashMap<>();

    static {//
        gameCaseMap.put("1", "1_4_2_3_5_6");
    }


    public Map<String, Object> caculateReturnAmount (Map<Integer, String> awardInfoMap, Map<String, BigDecimal> betInfoMap){
        String[] betInfoArr = null;
        String[] awardInfoArr = null;
        BigDecimal betOptAmount = BigDecimal.ZERO;
        BigDecimal totalReturnAmount = BigDecimal.ZERO;
        BigDecimal specialReturnAmount = BigDecimal.ZERO;
        Map<String, BigDecimal> specialOptReturnAmountMap = new HashMap<>();
        for (String betInfo : betInfoMap.keySet()) {
            betInfoArr = betInfo.split("_");
            String doubleTime = betInfoArr[1];
            String betOpt = betInfoArr[0];
            String awardInfo = awardInfoMap.get(betOpt);
            awardInfoArr = awardInfo.split("_");
            String result = awardInfoArr[0];
            Integer niuNum = Integer.parseInt(awardInfoArr[1]);
            betOptAmount = betInfoMap.get(betInfo);
            if ("1".equals(result)) {
                if ("1".equals(doubleTime)) {
                    if (niuNum == 10) {
                        specialReturnAmount = betOptAmount.multiply(new BigDecimal(2.95));
                    } else if (6 < niuNum && niuNum < 10) {
                        specialReturnAmount = betOptAmount.multiply(new BigDecimal(1.95));
                    } else {
                        specialReturnAmount = betOptAmount.multiply(new BigDecimal(0.95));
                    }
                } else {
                    specialReturnAmount = betOptAmount.multiply(new BigDecimal(0.95));
                }

            } else {
                if ("1".equals(doubleTime)) {
                    if (niuNum == 10) {
                        specialReturnAmount = betOptAmount.multiply(new BigDecimal(2.95));
                    } else if (6 < niuNum && niuNum < 10) {
                        specialReturnAmount = betOptAmount.multiply(new BigDecimal(1.95));
                    } else {
                        specialReturnAmount = betOptAmount.multiply(new BigDecimal(0.95));
                    }
                }
            }
            specialOptReturnAmountMap.put(betInfo, specialReturnAmount);
            totalReturnAmount = totalReturnAmount.add(specialReturnAmount);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("specialOptReturnAmountMap", specialOptReturnAmountMap);
        map.put("totalReturnAmount", totalReturnAmount);
        return map;
    }

    /**
     * 计算每一个选项的返奖金额
     * @param specialOptReturnAmountMap
     * @return
     */
    public Map<String, BigDecimal> outputReturnAmountMap (Map<String, BigDecimal> specialOptReturnAmountMap){
        Map<String, BigDecimal> commonReturnAmountMap = new HashMap<>();
        String opt0 = null;
        String opt1 = null;
        BigDecimal optAmount0 = null;
        BigDecimal optAmount1 = null;
        BigDecimal optAmount = null;
        for (String key : initMap.keySet()) {
            opt0 = key + "_0";
            opt1 = key + "_1";
            optAmount0 = specialOptReturnAmountMap.get(opt0);
            optAmount1 = specialOptReturnAmountMap.get(opt1);
            if (optAmount0 == null) {
                optAmount0 = BigDecimal.ZERO;
            }
            if (optAmount1 == null) {
                optAmount1 = BigDecimal.ZERO;
            }
            optAmount = optAmount0.add(optAmount1);
            commonReturnAmountMap.put(key, optAmount);
        }
        return commonReturnAmountMap;

    }


    public static void main(String[] args) {
        TestBrn testBrn = new TestBrn();
        Map<String, Object> map = testBrn.commonOutputCase();
        List<BrnCardDetail> list = (List<BrnCardDetail>)map.get("cardList");
        String value = gameCaseMap.get("1");
        List<BrnCardDetail> newList = new LinkedList<>();//0_3_1_2_4_5
        String [] valueArr = value.split(",");
        Integer index = new Random().nextInt(valueArr.length);
        String [] arr = valueArr[index].split("_");
        int j = 0;
        BrnCardDetail brnCardDetail = null;
        for (int i = 5; i >= 0; i--) {
            brnCardDetail = list.get(i);
            brnCardDetail.setIndex(Integer.parseInt(arr[j]));
            newList.add(brnCardDetail);
            j++;
        }
        System.out.println(newList);

    }


    /**
     * 正常开奖
     * @return
     */
    public Map<String, Object> commonOutputCase () {
        Map<String, Object> commonMap = new HashMap<>();
        Map<String, Integer> diceMap = outputDiceInfo();
        List<BrnCardDetail> cardList = outputCardInfo();
        sortBrnCardDetails(cardList);
        commonMap.put("diceMap", diceMap);
        commonMap.put("cardList", cardList);
        return commonMap;
    }

    public Map<String, Integer> outputDiceInfo () {
        Map<String, Integer> map = new HashMap<>();
        Integer diceLeft = new Random().nextInt(6) + 1;
        Integer diceRight = new Random().nextInt(6) + 1;
        Integer diceSum = diceLeft + diceRight;
        map.put("diceLeft", diceLeft);
        map.put("diceRight", diceRight);
        map.put("diceSum", diceSum);
        return map;
    }

    public void sortBrnCardDetails (List<BrnCardDetail> list) {
        list.sort(Comparator.comparing(BrnCardDetail::getNiuNum).thenComparing(BrnCardDetail::getMaxNum).thenComparing(BrnCardDetail::getMaxNumColor));
    }


    /*public Map<Integer, String> caculateBetArea(List<BrnCardDetail> list) {
        Map<Integer, String> map = new HashMap<>();
        Integer bankNum = list.get(3).getNiuNum();
        List<CardDetail> cardDetails = list.get(3).getCardDetails();
        String maxIndex = getMaxNum(cardDetails);
        CardDetail maxCardDetail = cardDetails.get(Integer.parseInt(maxIndex));
        Integer maxColor = Integer.parseInt(maxCardDetail.getColor());
        Integer maxNum = maxCardDetail.getNum();
        int size = list.size();
        for (int i = 0; i < size ; i++) {
            if (i == 3){
                continue;
            }
            int niuNum = list.get(i).getNiuNum();
            if (bankNum > niuNum){
                map.put(i, "1" + "_" + niuNum);
            }else if (bankNum < niuNum){
                map.put(i, "0" + "_" + niuNum);
            }else {
                List<CardDetail> cardDetailList = list.get(i).getCardDetails();
                String index = getMaxNum(cardDetailList);
                CardDetail cardDetail = cardDetailList.get(Integer.parseInt(index));
                Integer color = Integer.parseInt(cardDetail.getColor());
                Integer num = cardDetail.getNum();
                if (maxNum > num){
                    map.put(i, "1" + "_" + niuNum);
                }else if (maxNum < num){
                    map.put(i, "0" + "_" + niuNum);
                }else {
                    if (maxColor > color){
                        map.put(i, "1" + "_" + niuNum);
                    }else{
                        map.put(i, "0" + "_" + niuNum);
                    }
                }
            }
        }
        return map;
    }
*/

    public List<BrnCardDetail> outputCardInfo () {
        List<BrnCardDetail> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        BrnCardDetail brnCardDetail = null;
        Integer maxIndex = null;
        Integer maxNum = null;
        Integer maxNumColor = null;
        for (int i = 0; i < 6; i++) {
            List<CardDetail> cardDetails = outputSingleCardInfo(i);
            maxIndex = getMaxNum(cardDetails);
            String[] keyArr = null;
            Integer niuNum = 0;
            String maxKey = null;
            Integer maxValue = 0;
            for (String key : brnCardMap.keySet()) {
                Integer sum = 0;
                keyArr = key.split("_");
                for (String key1 : keyArr) {
                    int num = cardDetails.get(Integer.valueOf(key1)).getNum();
                    if (num > 10) {
                        num = 10;
                    }
                    sum = sum + num;
                }
                if (sum % 10 == 0) {
                    String valueArr[] = brnCardMap.get(key).split("_");
                    Integer value1 = cardDetails.get(Integer.parseInt(valueArr[0])).getNum();
                    if (value1 > 10) {
                        value1 = 10;
                    }
                    Integer value2 = cardDetails.get(Integer.parseInt(valueArr[1])).getNum();
                    if (value2 > 10) {
                        value2 = 10;
                    }
                    Integer sumValue = value1 + value2;
                    if (sumValue > 10) {
                        niuNum = sumValue - 10;
                    } else {
                        niuNum = sumValue;
                    }
                    if (maxValue < niuNum) {
                        maxValue = niuNum;
                        maxKey = key;
                    }
                }
            }
            maxNum = cardDetails.get(maxIndex).getNum();
            maxNumColor = Integer.parseInt(cardDetails.get(maxIndex).getColor());
            if (maxKey == null) {
                brnCardDetail = new BrnCardDetail(i+1, cardDetails, 0, "", maxNum, maxNumColor);
            } else {
                brnCardDetail = new BrnCardDetail(i+1, cardDetails, maxValue, brnCardMap.get(maxKey), maxNum, maxNumColor);
            }
            list.add(brnCardDetail);
        }
        return list;
    }


    public List<CardDetail> outputSingleCardInfo ( int index){
        String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
        String[] colors = {"3", "2", "1", "0"};
        ArrayList<String> pokerList = new ArrayList<>();
        for (String num : nums) {
            for (String color : colors) {
                pokerList.add(num + "_" + color);
            }
        }
        //洗牌,将List集合的元素打乱顺序
        Collections.shuffle(pokerList);
        int start = 0;
        switch (index) {
            case 1:
                start = 0;
                break;
            case 2:
                start = 5;
                break;
            case 3:
                start = 10;
                break;
            case 4:
                start = 15;
                break;
            case 5:
                start = 20;
                break;
            case 6:
                start = 25;
        }
        List<String> list = pokerList.subList(start, start + 5);
        List<CardDetail> cardDetails = new ArrayList<>();
        String[] valueArr = null;
        CardDetail cardDetail = null;
        for (int i = 0; i < 5; i++) {
            valueArr = list.get(i).split("_");
            cardDetail = new CardDetail(String.valueOf(i), Integer.parseInt(valueArr[0]), valueArr[1]);
            cardDetails.add(cardDetail);
        }
        return cardDetails;

    }


    public Integer getMaxNum(List<CardDetail> list){
        Integer maxNum = 0;
        String maxIndex = null;
        for (CardDetail cardDetail : list) {
            if (cardDetail.getNum() > maxNum) {
                maxNum = cardDetail.getNum();
                maxIndex = cardDetail.getIndex();
            }
        }
        return Integer.parseInt(maxIndex);
    }


}
