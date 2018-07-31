/*
package com.caiqr.quizzes.service.activity.impl;

import com.alibaba.fastjson.JSONObject;
import com.caiqr.quizzes.cache.GameCache;
import com.caiqr.quizzes.constant.CommonConstant;
import com.caiqr.quizzes.constant.LogConstant;
import com.caiqr.quizzes.constant.RedisConstant;
import com.caiqr.quizzes.constant.ResultConstant;
import com.caiqr.quizzes.dao.activity.NoviceVictoryDao;
import com.caiqr.quizzes.dao.activity.NoviceVictoryRecordDao;
import com.caiqr.quizzes.dao.core.UserThirdLoginInfoDao;
import com.caiqr.quizzes.entity.activity.po.ActivityNoviceVictoryPo;
import com.caiqr.quizzes.entity.activity.po.NoviceVictoryRecordPo;
import com.caiqr.quizzes.entity.core.po.*;
import com.caiqr.quizzes.exception.BusinessException;
import com.caiqr.quizzes.redis.base.RedisService;
import com.caiqr.quizzes.service.activity.NoviceVictoryService;
import com.caiqr.quizzes.service.activity.RewardService;
import com.caiqr.quizzes.service.core.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

*/
/**
 * 新手必中活动
 *
 * @author 丁少东
 * @create 2018-06-05 上午10:11
 **//*

@Service
public class NoviceVictoryServiceImpl implements NoviceVictoryService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private NoviceVictoryDao noviceVictoryDao;

    @Autowired
    private NoviceVictoryRecordDao noviceVictoryRecordDao;

    @Autowired
    private RedisService redisService;

    @Autowired
    private UserThirdLoginInfoDao userThirdLoginInfoDao;

    @Autowired
    private RewardService rewardService;

    public static final int NO_RECEIVEPRIVILEGES_ERROR = 1949;

    public static final int ACTIVITY_STOP_ERROR = 1997;

    public static final int USER_LOGINED_ERROR = 1999;

    public static final String ACTIVITY_NOVICE_CONFIG = "ACTIVITY_NOVICE_CONFIG";

    public static final long LIMIT_TIME = 1519833600000L;

    protected Logger log = LogConstant.commonLog;

    private static final int USING_STATUS = 1;//使用中

    private static final int EXPIRED_STATUS = 2;//已过期

    private static final int USED_STATUS = 3;//已使用

    */
/**
     * 新手必中活动获取特权
     * @param token
     * @return
     *//*

    public Object receivePrivileges(String token){
        UserInfo userInfo = userInfoService.getUserByToken(token);
        Map<String, Object> result = new HashMap<>();
        Timestamp userCreateTime = null;
        if (userInfo == null) {
            result.put("respCode", ResultConstant.INSTANT_GAME_TOKEN_ERROR);
            result.put("respMsg", "身份认证失败，请重新登录");
            return result;
        }else{
            if (StringUtils.isEmpty(userInfo.getThirdId())){
                userCreateTime = userInfo.getCreateTime();
            }else {
                ThirdUserPo thirdUserPo = userThirdLoginInfoDao.getInfoByUserCodeThirdId(userInfo.getUserId(), userInfo.getThirdId());
                userCreateTime = thirdUserPo.getCreateTime();
            }
        }
        JSONObject jsonObject = redisService.hessian2Get(ACTIVITY_NOVICE_CONFIG);
        if (jsonObject == null) {
            throw new BusinessException("activity_novice_victory config info is empty!");
        }
        String activeSwitch =  jsonObject.getString("activeSwitch");
        if ("0".equals(activeSwitch)){
            result.put("respCode", ACTIVITY_STOP_ERROR);
            result.put("respMsg", "活动已截至");
            return result;
        }
        int maxBonus =  Integer.parseInt(jsonObject.getString("maxBonus"));//新手活动用户获取的金豆配置（取自后端配缓存配置）
        int expireTime = Integer.parseInt(jsonObject.getString("expireTime"));//单位是天
        if (userCreateTime.after(new Timestamp(LIMIT_TIME))){//2018年3月以后注册的用户
            ActivityNoviceVictoryPo po =  noviceVictoryDao.selectNoviceByUserCode(userInfo.getUserId());
            if (po == null){
                ActivityNoviceVictoryPo activityNoviceVictoryPo = new ActivityNoviceVictoryPo(userInfo.getUserId(), USING_STATUS, maxBonus,"", new Timestamp(System.currentTimeMillis() + expireTime * 86400000L));
                noviceVictoryDao.insertNoviceVictory(activityNoviceVictoryPo);
            }else{
                result.put("respCode", USER_LOGINED_ERROR);
                result.put("respMsg", "该用户已领取特权");
                return result;
            }
        }
        return result;
    }

    */
/**
     * 查询使用特权(登录已经领取)
     * @param token
     * @return
     *//*

    @Override
    public Object checkUserPrivileges(String token) {
        Map<String, Object> result = new HashMap<>();
        UserInfo userInfo = userInfoService.getUserByToken(token);
        if (userInfo == null) {
            result.put("respCode", ResultConstant.INSTANT_GAME_TOKEN_ERROR);
            result.put("respMsg", "身份认证失败，请重新登录");
            return result;
        }
        ActivityNoviceVictoryPo po =  noviceVictoryDao.selectNoviceByUserCode(userInfo.getUserId());
        if (po == null){
            result.put("respCode", NO_RECEIVEPRIVILEGES_ERROR);
            result.put("respMsg", "该用户还没有领取特权");
            return result;
        }
        //特权使用状态：非空，1：使用中，2：已过期，3：已使用
        switch (po.getStatus()) {
            case 1:
                result.put("countDownTime", po.getExpireTime().getTime() - System.currentTimeMillis());
                break;
            case 2:
                result.put("countDownTime", 0);
            default:
                break;
        }
        result.put("status",po.getStatus());
        return result;
    }

    */
/**
     * 新手活动算奖
     * @return
     *//*

    @Transactional(value = "txManagerActivityDataSource")
    public void noviceCalcAward(){
        //获取参与新手必中活动的游戏id
        List<Long> gameIds = getNoviceActivityGameConfig();
        //查询特权使用中的用户记录
        List<ActivityNoviceVictoryPo> novices = noviceVictoryDao.selectAllNoviceUsers(USING_STATUS);
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        final CopyOnWriteArrayList<ActivityNoviceVictoryPo> cowList = new CopyOnWriteArrayList<ActivityNoviceVictoryPo>(novices);
        List<String> expireNovices = new ArrayList<>();
        for (ActivityNoviceVictoryPo po : cowList){
            if(currentTime.after(po.getExpireTime())){
                expireNovices.add(po.getUserCode());
                cowList.remove(po);//移除已过期的数据
            }
        }
        if (expireNovices.size() > 0){
            noviceVictoryDao.batchUpdateNovices(expireNovices, EXPIRED_STATUS);//更新用户记录为已过期状态
        }
        //从合表中查出每条订单的亏损记录
        List<NoviceVictoryRecordPo> noviceVictoryRecordPos = noviceVictoryRecordDao.selectNoviceLossRecordWithGameIds(cowList, gameIds);
        //插入到新手活动记录表中
        if (noviceVictoryRecordPos.size() >0){
            noviceVictoryRecordDao.batchInsertNoviceLossRecord(noviceVictoryRecordPos);
            //查询未派奖的用户订单记录
            List<NoviceVictoryRecordPo> originRecords = noviceVictoryRecordDao.selectNoviceLossRecord(cowList);
            if (originRecords.size() > 0){
                List<ActivityNoviceVictoryPo> activityNoviceVictoryPos = new ArrayList<>();
                //计算派奖
                for (NoviceVictoryRecordPo po : originRecords) {
                    String key = "novice"+po.getUserCode();
                    String amoutStr  = redisService.hessian2Get(key);
                    if (amoutStr == null){
                        ActivityNoviceVictoryPo user = noviceVictoryDao.selectNoviceByUserCode(po.getUserCode());
                        redisService.hessian2SetEx(key,60, String.valueOf(user.getBonus()));
                        amoutStr  = redisService.hessian2Get(key);
                    }
                    int amout = Integer.parseInt(amoutStr);
                    int returnAward = Math.abs(po.getTotalAmount());
                    int status = USING_STATUS;//特权使用中
                    if(amout <= returnAward){
                        returnAward = amout;
                        status = USED_STATUS;//特权金豆已使用
                    }
                    int bonus = amout - returnAward;
                    if (bonus < 0){
                        bonus = 0;
                    }
                    redisService.hessian2SetEx(key,60, String.valueOf(bonus));
                    //调派奖接口派奖
                    if (returnAward > 0){
                        returnAward(po.getUserCode(), returnAward);
                    }
                    ActivityNoviceVictoryPo activityNoviceVictoryPo = new ActivityNoviceVictoryPo(po.getUserCode(), status, bonus);
                    activityNoviceVictoryPos.add(activityNoviceVictoryPo);
                }
                //更新新手用户活动表
                noviceVictoryDao.batchUpdateNoviceList(activityNoviceVictoryPos);
                //更新派奖记录
                List<String> orderIds = noviceVictoryRecordDao.selectNoviceLossOrderId(cowList);
                noviceVictoryRecordDao.batchUpdateNoviceRecord(orderIds);
            }
        }
    }

    */
/**
     * 新手活动定时任务接口
     *//*

    @Override
    public void noviceVictoryAward(){
        //syncNoviceVictoryToQueue();
        noviceCalcAward();
    }

    */
/**
     * 加入redis的开关
     *//*

    @Override
    public void syncNoviceVictoryToQueue() {
        //redisService.lpushWithPrefix(RedisConstant.NOVICE_VICTORY_CALCAWARD_QUEUE, "1");
    }

    */
/**
     * 调派奖接口派奖
     * @param userCode
     * @param returnAmount
     *//*

    public void returnAward(String userCode, long returnAmount) {
        rewardService.reward(userCode, returnAmount, UserAccount.NOVICE_VICTORY_ACTIVITY);
    }

    */
/**
     *  获取新手配置的游戏
     * @return
     *//*

    public List<Long> getNoviceActivityGameConfig(){
        JSONObject jsonObject = redisService.hessian2Get(ACTIVITY_NOVICE_CONFIG);
        if (jsonObject == null) {
            throw new BusinessException("activity_novice_victory config info is empty!");
        }
        String [] arrs = jsonObject.getString("gameENs").split(CommonConstant.SEMICOLON_SPLIT_STR);
        List<Long> gameIds = new ArrayList<>();
        for (int i = 0; i < arrs.length ; i++) {
            gameIds.add(GameCache.getGame(arrs[i]).getGameId());
        }
        return gameIds;
    }

}
*/
