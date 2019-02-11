package com.stubborn.util;

/**
 * Created by Singal
 */
public class ResultConstant {
    public static final int SUCCESS = 0;
    public static final int ERROR = -1;
    public static final int TOKEN_ERROR = -2;//未登录认证
    public static final int SIGN_ERROR = -3;//验签有误

    public static final String NEED_RELOGIN = "2007";

    /*认证失败，重新登录*/
    public static final int SPORTS_BET_TOKEN_ERROR = 2001;
    /*投注信息错误*/
    public static final int SPORTS_BET_INFO_ERROR = 2002;
    /*金币不足*/
    public static final int SPORTS_BET_ACCOUNT_INSUFFICIENT = 2003;
    /*赔率发生变化*/
    public static final int SPORTS_BET_ODDS_CHANGED = 2004;
    /*选项单次投注上限*/
    public static final int SPORTS_BET_OPTION_UPPER_LIMITER = 2005;
    /*玩法累计投注上限*/
    public static final int SPORTS_BET_PLAY_UPPER_LIMITER = 2006;
    /*比赛累计投注上限*/
    public static final int SPORTS_BET_PERIOD_UPPER_LIMITER = 2007;
    /*部分比赛截止*/
    public static final int SPORTS_BET_PART_PERIOD_STOP = 2008;
    /*全部比赛截止*/
    public static final int SPORTS_BET_ALL_PERIOD_STOP = 2009;
    /*部分玩法截止*/
    public static final int SPORTS_BET_PART_PLAY_STOP = 2010;
    /*全部玩法截止*/
    public static final int SPORTS_BET_ALL_PLAY_STOP = 2011;
    /*部分选项截止*/
    public static final int SPORTS_BET_PART_OPTION_STOP = 2012;
    /*部分选项截止*/
    public static final int SPORTS_BET_ALL_OPTION_STOP = 2013;
    /*投注选项过多*/
    public static final int SPORTS_BET_EXCESSIVE_OPTIONS = 2014;
    /*投注信息错误*/
    public static final int SPORTS_BET_RISK = 2015;
    //竞猜事件选择错误
    public static final int CQR_BET_EVENT_ERROR = 1992;

    /*其他服务异常*/
    public static final int SPORTS_BET_SERVICE_ERROR = 2100;
    /*网络异常*/
    public static final int SPORTS_BET_SERVICE_INVOKE_ERROR = 4004;
    /*高频游戏*/
    /*token无效*/
    public static final int HF_GAME_TOKEN_ERROR = 3001;
    /*游戏不存在*/
    public static final int HF_GAME_GAME_NOT_EXIST = 3002;
    /*期次截止*/
    public static final int HF_GAME_PERIOD_END = 3003;
    /*期次截止*/
    public static final int HF_GAME_GET_PERIOD_FAIL = 3005;
    /*订单撤销失败*/
    public static final int HF_GAME_ORDER_CANCEL_FAILED = 3004;

    /*即时游戏*/
    /*token无效*/
    public static final int INSTANT_GAME_TOKEN_ERROR = 4001;
    /*游戏不存在*/
    public static final int INSTANT_GAME_NOT_EXIST = 4002;
    public static final int INSTANT_GAME_PAYMENT_EXCEPTION = 4003;
    /*免费游戏机会为0*/
    public static final int INSTANT_GAME_NONE_FREE_CHANCE = 4004;
    public static final int INSTANT_GAME_TIMES_CHANCE = 4005;//即时游戏投注倍数为0

    public static final int INSTANT_GAME_NO_CHANCE = 4006;
    public static final int INSTANT_GAME_COSTBEAN = 4007;
    //指路明灯只能投注一个选项
    public static final int GUIDE_BET_EORROR = 4008;






}
