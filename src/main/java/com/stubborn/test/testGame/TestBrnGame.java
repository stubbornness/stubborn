//package com.stubborn.test.testGame;
//
///**
// * @author 丁少东
// * @create 2019-03-08 上午10:22
// **/
//package com.caiqr.casino.service.core.game.frequencygame;
//
//import com.caiqr.casino.cache.GameCache;
//import com.caiqr.casino.cache.IniCache;
//import com.caiqr.casino.constant.RedisConstant;
//import com.caiqr.casino.dao.core.GamePeriodDao;
//import com.caiqr.casino.dao.core.GameRiskDetailDao;
//import com.caiqr.casino.dao.core.OrderInfoDetailDao;
//import com.caiqr.casino.entity.core.bo.*;
//import com.caiqr.casino.entity.core.po.*;
//import com.caiqr.casino.entity.core.vo.AwardInfoVo;
//import com.caiqr.casino.enums.core.CaiDaXiaoPlayEnum;
//import com.caiqr.casino.enums.core.GameEnum;
//import com.caiqr.casino.redis.base.PeriodRedisService;
//import com.caiqr.casino.redis.base.RedisService;
//import com.caiqr.casino.service.core.MessagePushService;
//import com.caiqr.casino.service.core.game.bjlgame.GameUtil;
//import com.caiqr.casino.util.DateUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//import java.sql.Timestamp;
//import java.util.*;
//
//
///**
// * 百人牛牛游戏
// */
//@Component
//public class BrnGame extends FrequencyGame {
//
//    @Autowired
//    private GamePeriodDao gamePeriodDao;
//    @Autowired
//    private RedisService redisService;
//    @Autowired
//    private PeriodRedisService periodRedisService;
//    @Autowired
//    private MessagePushService messagePushService;
//    @Autowired
//    private OrderInfoDetailDao orderInfoDetailDao;
//    @Autowired
//    private GameRiskDetailDao gameRiskDetailDao;
//
//    public static final String JACKPOT_DEFAULT_VALUE = "jackPotDefaultValue";
//
//    public static final Integer GAME_SWITCH = 0;
//
//    public static final String GAME_ALARM_SWITCH = "1";
//
//    private final static Map<String, BigDecimal> initMap = new HashMap<>();
//
//    static {
//        initMap.put("1", BigDecimal.ZERO);
//        initMap.put("2", BigDecimal.ZERO);
//        initMap.put("3", BigDecimal.ZERO);
//        initMap.put("5", BigDecimal.ZERO);
//        initMap.put("6", BigDecimal.ZERO);
//    }
//
//    public final static Map<String, String> brnCardMap = new LinkedHashMap<>();
//
//    static {
//        brnCardMap.put("0_1_2", "3_4");
//        brnCardMap.put("0_1_3", "2_4");
//        brnCardMap.put("0_1_4", "2_3");
//        brnCardMap.put("0_2_3", "1_4");
//        brnCardMap.put("0_2_4", "1_3");
//        brnCardMap.put("0_3_4", "1_2");
//        brnCardMap.put("1_2_3", "0_4");
//        brnCardMap.put("1_2_4", "0_3");
//        brnCardMap.put("1_3_4", "0_2");
//    }
//
//    public final static Map<String, String> gameCaseMap = new LinkedHashMap<>();
//
//    static {
//        gameCaseMap.put("1", "1_4_2_3_5_6,1_4_3_2_6_5");
//        gameCaseMap.put("1_2", "1_2_4_3_5_6,1_2_4_3_6_5");
//        gameCaseMap.put("1_3", "1_3_4_2_5_6,1_3_4_2_6_5");
//        gameCaseMap.put("1_4", "1_4_3_6_5_2,1_4_3_5_2_6");
//        gameCaseMap.put("1_5", "1_5_4_2_5_6,1_5_4_2_6_5");
//        gameCaseMap.put("1_6", "1_6_4_2_5_3,1_6_4_3_2_5");
//
//    }
//
//
//    @Override
//    public Game getGame() {
//        return GameEnum.BRN.getGame();
//    }
//
//    @Override
//    public Integer getDailyPeriod() {
//        return CaiDaXiaoPlayEnum.DAILY_PERIOD;
//    }
//
//    @Override
//    public Integer getPeriodInterval() {
//        return CaiDaXiaoPlayEnum.TIME_INTERVAL;
//    }
//
//    @Override
//    public String getInitPeriodFormat() {
//        return CaiDaXiaoPlayEnum.INIT_PERIOD_FORMAT;
//    }
//
//    @Override
//    public String getPeriodDateFormat() {
//        return DateUtil.DATE_FORMAT_YYYYMMDD;
//    }
//
//
//    @Override
//    public String openAward(long gameId, String periodId) {
//
//        BigDecimal betAmount = BigDecimal.ZERO;//总投注金额
//        BigDecimal returnAmount = BigDecimal.ZERO;//总返奖金额
//        BigDecimal jackpotBalance = BigDecimal.ZERO;//奖池余额
//        BigDecimal totalAmount = BigDecimal.ZERO;
//        Map<String, Object> commonMap = new HashMap<>();
//        Game game = GameCache.getGame(gameId);
//        BigDecimal riskLimit = new BigDecimal(game.getRiskLimit());
//        Integer riskSwitch = game.getRiskSwitch();
//        String prePeriodId = String.valueOf(Long.parseLong(periodId) - 1);
//        GameRiskDetail gameRiskDetail = gameRiskDetailDao.selectGameRiskDetail(gameId, prePeriodId);
//        if (gameRiskDetail == null){
//            String jackpotBalanceStr = IniCache.getIniValue(JACKPOT_DEFAULT_VALUE);
//            if (jackpotBalanceStr != null){//BigDecimal.ZERO 奖池余额
//                jackpotBalance = new BigDecimal(jackpotBalanceStr);
//            }
//        }else {
//            jackpotBalance = gameRiskDetail.getJackpotBalance();
//            if (GAME_ALARM_SWITCH.equals(game.getAlarmSwitch())){
//                if (jackpotBalance.compareTo(riskLimit) < 0){
//                    Map<String,Object> riskMap = new HashMap<>();
//                    riskMap.put("游戏名称", game.getGameEn());
//                    riskMap.put("期次ID", prePeriodId);
//                    riskMap.put("风控阈值", riskLimit.toString());
//                    riskMap.put("奖池金额", jackpotBalance.toString());
//                    GameUtil.gameRiskReport(riskMap);
//                }
//            }
//        }
//        List<RiskManageOrderDetail> riskManageOrderDetails = orderInfoDetailDao.queryBetInfoAndAwardByPeriodId(periodId);
//        commonMap = commonOutputCase();
//        if (riskManageOrderDetails.size() == 0){
//            List<BrnCardDetail> cardList = (List<BrnCardDetail>)commonMap.get("cardList");
//            Map<String, Object> resultMap = caculateBetArea(cardList);
//            gameRiskDetail = new GameRiskDetail(gameId, periodId, betAmount, returnAmount, jackpotBalance);
//            handleOpenAwardInfo(gameRiskDetail, commonMap, resultMap);
//            return null;
//        }
//
//        Map<String, BigDecimal> betMap = new HashMap<>();
//        BigDecimal optBetAmount = BigDecimal.ZERO;
//        //计算每个选项的投注金额
//        for (RiskManageOrderDetail detail: riskManageOrderDetails){
//            optBetAmount = detail.getBetAmount().setScale(0, BigDecimal.ROUND_HALF_EVEN);
//            betMap.put(detail.getBetInfo(), optBetAmount);
//        }
//
//        totalAmount = betAmount.add(jackpotBalance);
//        List<BrnCardDetail> cardList = (List<BrnCardDetail>)commonMap.get("cardList");
//        //没开风控
//        if (GAME_SWITCH == riskSwitch){
//            Map<String, Object> resultMap = caculateBetArea(cardList);
//            Map<Integer, String> winMap = (Map<Integer, String>)resultMap.get("winMap");
//            Integer bankNum = Integer.parseInt(resultMap.get("bankNum").toString());
//            returnAmount = caculateReturnAmount(winMap,betMap,bankNum);
//            if (returnAmount == null){
//                returnAmount = BigDecimal.ZERO;
//            }
//            jackpotBalance = totalAmount.subtract(returnAmount);
//            gameRiskDetail = new GameRiskDetail(gameId, periodId, betAmount, returnAmount, jackpotBalance);
//            handleOpenAwardInfo(gameRiskDetail, commonMap, resultMap);
//        }else {
//            List<String> tempList = new ArrayList<>();
//            Map<String, BigDecimal> returnAmountMap = new HashMap<>();
//            Map<String, BigDecimal> minReturnAmountMap = new HashMap<>();
//            Map<String, Object> cardListMap = new HashMap<>();
//            String valueArr [] = null;
//            Integer niuNum = null;
//            Integer bankNum = null;
//            String result = null;
//            for (String key : gameCaseMap.keySet()) {
//                valueArr = gameCaseMap.get(key).split(",");
//                Integer index = new Random().nextInt(valueArr.length);
//                result = valueArr[index];
//                String [] betInfoArr = result.split("_");
//                sortBrnCardDetails(cardList);//排序
//                List<BrnCardDetail> newCardList = outputSortCard(cardList, result);//换牌
//                Map<String, Integer> indexNumMap = new HashMap<>();
//                for (BrnCardDetail brnCardDetail : newCardList){
//                    indexNumMap.put(String.valueOf(brnCardDetail.getIndex()), brnCardDetail.getNiuNum());
//                }
//                bankNum = indexNumMap.get("4");
//                BigDecimal returnAmountAdd = BigDecimal.ZERO;
//                for (String betInfo : betInfoArr){
//                    if ("4".equals(betInfo)){
//                        continue;
//                    }
//                    BigDecimal oneBetAmount = betMap.get(betInfo+"_"+"0");
//                    BigDecimal doubleBetAmount = betMap.get(betInfo+"_"+"1");
//                    niuNum = indexNumMap.get(betInfo);
//                    if (key.contains(betInfo)){
//                        if (oneBetAmount == null){
//                            oneBetAmount = BigDecimal.ZERO;
//                        }else{
//                            oneBetAmount.multiply(new BigDecimal(1950)).divide(new BigDecimal(1000));
//                        }
//                        if (doubleBetAmount == null){
//                            doubleBetAmount = BigDecimal.ZERO;
//                        }else{
//                            if (niuNum == 10){
//                                doubleBetAmount = doubleBetAmount.multiply(new BigDecimal(3950)).divide(new BigDecimal(1000));
//                            }else if (6 < niuNum && niuNum < 10){
//                                doubleBetAmount = doubleBetAmount.multiply(new BigDecimal(2950)).divide(new BigDecimal(1000));
//                            }else{
//                                doubleBetAmount = doubleBetAmount.multiply(new BigDecimal(1950)).divide(new BigDecimal(1000));
//                            }
//                        }
//                    }else{
//                        if (oneBetAmount == null){
//                            oneBetAmount = BigDecimal.ZERO;
//                        }
//                        if (doubleBetAmount == null){
//                            doubleBetAmount = BigDecimal.ZERO;
//                        }else{
//                            if (bankNum == 10){
//                                doubleBetAmount = doubleBetAmount.multiply(new BigDecimal(-2));
//                            }else if (6 < bankNum && bankNum < 10){
//                                doubleBetAmount = doubleBetAmount.multiply(new BigDecimal(-1));
//                            }else{
//                                doubleBetAmount = BigDecimal.ZERO;
//                            }
//                        }
//                    }
//                    returnAmountAdd = returnAmountAdd.add(oneBetAmount.add(doubleBetAmount));
//                }
//                if ((totalAmount.subtract(returnAmountAdd).compareTo(riskLimit) > 0)){
//                    tempList.add(key);
//                    returnAmountMap.put(key, returnAmountAdd);
//                }
//                minReturnAmountMap.put(key, returnAmountAdd);
//                cardListMap.put(key,newCardList);
//            }
//            if (tempList.isEmpty()){
//                String gameCase = GameUtil.riskManageMap(minReturnAmountMap);//12中开奖情况中的一种
//                returnAmount = minReturnAmountMap.get(gameCase);//返奖金额
//                jackpotBalance = totalAmount.subtract(returnAmount);
//                gameRiskDetail = new GameRiskDetail(gameId, periodId, betAmount, returnAmount, jackpotBalance);
//                List<BrnCardDetail> brnCardDetailList = (List<BrnCardDetail>)cardListMap.get(gameCase);
//                Map<String, Object> resultMap = caculateBetArea(brnCardDetailList);
//                commonMap.put("cardList",brnCardDetailList);
//                handleOpenAwardInfo(gameRiskDetail, commonMap, resultMap);
//                return null;
//            }else {
//                String gameCase = riskManageList(tempList);//12中开奖情况中的一种
//                returnAmount = returnAmountMap.get(gameCase);//返奖金额
//                jackpotBalance = totalAmount.subtract(returnAmount);
//                gameRiskDetail = new GameRiskDetail(gameId, periodId, betAmount, returnAmount, jackpotBalance);
//                Map<String, Object> resultMap = caculateBetArea(cardList);
//                commonMap.put("cardList",cardListMap.get(gameCase));
//                handleOpenAwardInfo(gameRiskDetail, commonMap, resultMap);
//                return null;
//            }
//        }
//        return null;
//    }
//
//    public List<BrnCardDetail> outputSortCard(List<BrnCardDetail> list, String value){
//        List<BrnCardDetail> newList = new LinkedList<>();
//        String [] valueArr = value.split(",");
//        Integer index = new Random().nextInt(valueArr.length);
//        String [] arr = valueArr[index].split("_");
//        int j = 0;
//        BrnCardDetail brnCardDetail = null;
//        for (int i = 5; i >= 0; i--) {
//            brnCardDetail = list.get(i);
//            brnCardDetail.setIndex(Integer.parseInt(arr[j]));
//            newList.add(brnCardDetail);
//            j++;
//        }
//        return newList;
//    }
//
//
//    public String riskManageList(List<String> list){
//        int random = new Random().nextInt(list.size());
//        return list.get(random);
//    }
//
//    public BigDecimal caculateReturnAmount (Map<Integer, String> awardInfoMap, Map<String, BigDecimal> betInfoMap, Integer bankNum){
//        String[] betInfoArr = null;
//        String[] awardInfoArr = null;
//        BigDecimal betOptAmount = BigDecimal.ZERO;
//        BigDecimal totalReturnAmount = BigDecimal.ZERO;
//        BigDecimal specialReturnAmount = BigDecimal.ZERO;
//        for (String betInfo : betInfoMap.keySet()) {
//            betInfoArr = betInfo.split("_");
//            String betOpt = betInfoArr[0];
//            String doubleTime = betInfoArr[1];
//            String awardInfo = awardInfoMap.get(Integer.parseInt(betOpt));
//            awardInfoArr = awardInfo.split("_");
//            String result = awardInfoArr[0];
//            Integer niuNum = Integer.parseInt(awardInfoArr[1]);
//            betOptAmount = betInfoMap.get(betInfo);
//            if ("1".equals(result)) {
//                if ("1".equals(doubleTime)) {
//                    if (niuNum == 10) {
//                        specialReturnAmount = betOptAmount.multiply(new BigDecimal(3950)).divide(new BigDecimal(1000));
//                    } else if (6 < niuNum && niuNum < 10) {
//                        specialReturnAmount = betOptAmount.multiply(new BigDecimal(2950)).divide(new BigDecimal(1000));
//                    } else {
//                        specialReturnAmount = betOptAmount.multiply(new BigDecimal(1950)).divide(new BigDecimal(1000));
//                    }
//                } else {
//                    specialReturnAmount = betOptAmount.multiply(new BigDecimal(1950)).divide(new BigDecimal(1000));
//                }
//            } else {
//                if ("1".equals(doubleTime)) {
//                    if (bankNum == 10) {
//                        specialReturnAmount = betOptAmount.multiply(new BigDecimal(-2));
//                    } else if (6 < bankNum && bankNum < 10) {
//                        specialReturnAmount = betOptAmount.multiply(new BigDecimal(-1));
//                    } else {
//                        specialReturnAmount = BigDecimal.ZERO;
//                    }
//                }
//            }
//            totalReturnAmount = totalReturnAmount.add(specialReturnAmount);
//        }
//        return totalReturnAmount;
//    }
//
//    /**
//     * 处理开奖信息
//     * @param gameRiskDetail
//     * @param commonMap
//     */
//    public void handleOpenAwardInfo(GameRiskDetail gameRiskDetail, Map<String, Object> commonMap, Map<String, Object> resultMap){
//        long gameId = gameRiskDetail.getGameId();
//        String periodId = gameRiskDetail.getPeriodId();
//        String gameEn = GameCache.getGame(gameId).getGameEn();
//        Map<String, String> ifWinMap = (Map<String, String>)resultMap.get("ifWinMap");
//        String ifAllKill = resultMap.get("ifAllKill").toString();
//        commonMap.put("ifWinMap",ifWinMap);
//        commonMap.put("ifAllKill",ifAllKill);
//        messagePushService.openAwardPush(gameEn, periodId, commonMap);
//        gameRiskDetailDao.insertGameRiskDetail(gameRiskDetail);
//        Map<Integer, String> winMap = (Map<Integer, String>)resultMap.get("winMap");
//        gamePeriodDao.updateGamePeriodWinningNumbers(gameId, periodId, winMap.toString());
//        winMap.put(4, resultMap.get("bankNum").toString());
//        redisService.hessian2SetEx(RedisConstant.FREQUENCY_GAME_AWARD_RESULT + periodId,5 * 60, winMap);
//        Set<String> periods = new HashSet<>();
//        periods.add(periodId);
//        periodRedisService.consumePeriods(gameId, periods);
//    }
//
//    public Map<String, Object> commonOutputCase(){
//        Map<String, Object> commonMap = new HashMap<>();
//        Map<String, Integer> diceMap = outputDiceInfo();
//        List<BrnCardDetail> cardList = outputCardInfo();
//        commonMap.put("diceMap",diceMap);
//        commonMap.put("cardList",cardList);
//        return commonMap;
//    }
//
//    public Map<String, Integer> outputDiceInfo(){
//        Map<String, Integer> map = new HashMap<>();
//        Integer diceLeft = new Random().nextInt(6) + 1;
//        Integer diceRight = new Random().nextInt(6) + 1;
//        Integer diceSum = diceLeft + diceRight;
//        map.put("diceLeft", diceLeft);
//        map.put("diceRight", diceRight);
//        map.put("diceSum", diceSum);
//        return map;
//    }
//
//    public void sortBrnCardDetails(List<BrnCardDetail> list){
//        list.sort(Comparator.comparing(BrnCardDetail::getNiuNum).thenComparing(BrnCardDetail::getMaxNum).thenComparing(BrnCardDetail::getMaxNumColor));
//    }
//
//    public Map<String, Object> caculateBetArea(List<BrnCardDetail> list) {
//        Map<Integer, String> map = new HashMap<>();
//        Map<String, String> ifWinMap = new HashMap<>();
//        Map<String, Object> totalMap = new HashMap<>();
//        BrnCardDetail bankCard = null;
//        for (BrnCardDetail brnCardDetail : list){
//            if (brnCardDetail.getIndex() == 4){
//                bankCard = brnCardDetail;
//                totalMap.put("bankNum",bankCard.getNiuNum());
//                break;
//            }
//        }
//        Integer bankNum = bankCard.getNiuNum();
//        Integer maxColor = bankCard.getMaxNumColor();
//        Integer maxNum = bankCard.getMaxNum();
//        for (BrnCardDetail brnCardDetail : list){
//            if (brnCardDetail.getIndex() == 4){
//                continue;
//            }
//            int niuNum = brnCardDetail.getNiuNum();
//            if (bankNum > niuNum){
//                map.put(brnCardDetail.getIndex(), "0" + "_" + niuNum);
//            }else if (bankNum < niuNum){
//                map.put(brnCardDetail.getIndex(), "1" + "_" + niuNum);
//                ifWinMap.put(brnCardDetail.getIndex().toString(), "1");
//            }else {
//                Integer color = brnCardDetail.getMaxNumColor();
//                Integer num = brnCardDetail.getMaxNum();
//                if (maxNum > num){
//                    map.put(brnCardDetail.getIndex(), "0" + "_" + niuNum);
//                }else if (maxNum < num){
//                    map.put(brnCardDetail.getIndex(), "1" + "_" + niuNum);
//                    ifWinMap.put(brnCardDetail.getIndex().toString(), "1");
//                }else {
//                    if (maxColor > color){
//                        map.put(brnCardDetail.getIndex(), "0" + "_" + niuNum);
//                    }else{
//                        map.put(brnCardDetail.getIndex(), "1" + "_" + niuNum);
//                        ifWinMap.put(brnCardDetail.getIndex().toString(), "1");
//                    }
//                }
//            }
//        }
//        totalMap.put("winMap",map);
//        totalMap.put("ifWinMap",ifWinMap);//前端高亮显示
//        String ifAllKill = "2";
//        if (ifWinMap.size() == 5){
//            ifAllKill = "0";
//        }
//        if (ifWinMap.size() == 0){
//            ifAllKill = "1";
//        }
//        totalMap.put("ifAllKill",ifAllKill);
//        return totalMap;
//    }
//
//    public List<BrnCardDetail> outputCardInfo(){
//        List<BrnCardDetail> list = new ArrayList<>();
//        BrnCardDetail brnCardDetail = null;
//        Integer maxIndex = null;
//        Integer maxNum = null;
//        Integer maxNumColor = null;
//        for (int i = 0; i < 6; i++) {
//            List<CardDetail> cardDetails = outputSingleCardInfo(i);
//            maxIndex = getMaxNum(cardDetails);
//            String [] keyArr = null;
//            Integer niuNum = 0;
//            String maxKey = null;
//            Integer maxValue = 0;
//            for (String key : brnCardMap.keySet()){
//                Integer sum = 0;
//                keyArr = key.split("_");
//                for (String key1 : keyArr){
//                    int num = cardDetails.get(Integer.valueOf(key1)).getNum();
//                    if (num > 10){
//                        num = 10;
//                    }
//                    sum = sum + num;
//                }
//                if (sum % 10 == 0){
//                    String valueArr [] = brnCardMap.get(key).split("_");
//                    Integer value1 = cardDetails.get(Integer.parseInt(valueArr[0])).getNum();
//                    if (value1 > 10){
//                        value1 = 10;
//                    }
//                    Integer value2 = cardDetails.get(Integer.parseInt(valueArr[1])).getNum();
//                    if (value2 > 10){
//                        value2 = 10;
//                    }
//                    Integer sumValue =  value1 + value2;
//                    if (sumValue > 10){
//                        niuNum = sumValue - 10;
//                    }else {
//                        niuNum = sumValue;
//                    }
//                    if (maxValue < niuNum){
//                        maxValue = niuNum;
//                        maxKey = key;
//                    }
//                }
//            }
//            maxNum = cardDetails.get(maxIndex).getNum();
//            maxNumColor = Integer.parseInt(cardDetails.get(maxIndex).getColor());
//            if (maxKey == null){
//                brnCardDetail = new BrnCardDetail(i+1,cardDetails,0,"",maxNum,maxNumColor);
//            }else{
//                brnCardDetail = new BrnCardDetail(i+1,cardDetails,maxValue, brnCardMap.get(maxKey),maxNum,maxNumColor);
//            }
//            list.add(brnCardDetail);
//        }
//        return list;
//    }
//
//    public List<CardDetail> outputSingleCardInfo(int index){
//        String[] nums = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" };
//        String[] colors = { "3", "2", "1", "0" };
//        ArrayList<String> pokerList = new ArrayList<>();
//        for (String num : nums) {
//            for (String color : colors) {
//                pokerList.add(num + "_" + color);
//            }
//        }
//        //洗牌,将List集合的元素打乱顺序
//        Collections.shuffle(pokerList);
//        int start = 0;
//        switch(index){
//            case 1:
//                start = 0;
//                break;
//            case 2:
//                start = 5;
//                break;
//            case 3:
//                start = 10;
//                break;
//            case 4:
//                start = 15;
//                break;
//            case 5:
//                start = 20;
//                break;
//            case 6:
//                start = 25;
//        }
//        List<String> list = pokerList.subList(start, start + 5);
//        List<CardDetail> cardDetails = new ArrayList<>();
//        String [] valueArr = null;
//        CardDetail cardDetail = null;
//        for (int i = 0; i < 5 ; i++) {
//            valueArr = list.get(i).split("_");
//            cardDetail = new CardDetail(String.valueOf(i), Integer.parseInt(valueArr[0]) ,valueArr[1]);
//            cardDetails.add(cardDetail);
//        }
//        return cardDetails;
//
//    }
//
//    public Integer getMaxNum(List<CardDetail> list) {
//        Integer maxNum = 0;
//        String maxIndex = null;
//        for (CardDetail cardDetail : list){
//            if (cardDetail.getNum() > maxNum){
//                maxNum = cardDetail.getNum();
//                maxIndex = cardDetail.getIndex();
//            }
//        }
//        return Integer.parseInt(maxIndex);
//    }
//
//    @Override
//    public AwardInfoVo calcWinningNumber(GamePeriod gamePeriod) {
//        return null;
//    }
//
//    @Override
//    public GameBean validateAndParse(String lotteryNumberStr, String gameExtra) {
//        return null;
//    }
//
//    @Override
//    public Timestamp getOfficialStartTime(GamePeriod gamePeriod) {
//        return null;
//    }
//
//    @Override
//    protected List<GameBean> splitGameBeanListForAmountByScheme(GameBean userGameBean) {
//        return null;
//    }
//
//    @Override
//    protected boolean ifExceedDantuoRedBallLimits(GameBean gameBean) {
//        return false;
//    }
//
//    @Override
//    public int[] analyseBidAwardLevels(String bidBalls, String targetBalls, String playType, String extra) {
//        return new int[0];
//    }
//
//    @Override
//    protected int getWinningNumberLength() {
//        return 0;
//    }
//
//    @Override
//    protected String getWinningNumberRegexp() {
//        return null;
//    }
//
//    @Override
//    public List<AwardInfo> getDefaultAwardInfoList() {
//        return null;
//    }
//
//    @Override
//    public String generatePeriodDatePrefix() {
//        return null;
//    }
//
//    @Override
//    public String generatePeriodNextDatePrefix() {
//        return null;
//    }
//}
//
