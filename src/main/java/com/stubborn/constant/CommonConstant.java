package com.stubborn.constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CommonConstant {
    public static final ThreadLocal<HttpServletRequest> requestTL = new ThreadLocal<>(); //保存request的threadlocal
    public static final ThreadLocal<HttpServletResponse> responseTL = new ThreadLocal<>(); //保存response的threadlocal
    public static final ThreadLocal<HttpSession> sessionTL = new ThreadLocal<>(); //保存session的threadlocal

    public final static String SPACE_SPLIT_STR = " ";
    public final static String PERCENT_SPLIT_STR = "%";
    public final static String COMMON_SPLIT_STR = "_";
    public final static String COMMON_DASH_STR = "-";
    public final static String COMMA_SPLIT_STR = ",";
    public final static String SEMICOLON_SPLIT_STR = ";";
    public final static String COMMON_VERTICAL_STR = "|";
    public final static String URL_SPLIT_STR = "/";
    public final static String DOUBLE_SLASH_STR = "//";
    public final static String POUND_SPLIT_STR = "#";
    public final static String COMMON_ESCAPE_STR = "\\";
    public final static String COMMON_AT_STR = "@";
    public final static String COMMON_DOLLAR_STR = "$";
    public final static String COMMON_WAVE_STR = "~";
    public final static String COMMON_STAR_STR = "*";
    public final static String COMMON_COLON_STR = ":";
    public final static String COMMON_DOT_STR = ".";
    public final static String COMMON_EQUAL_STR = "=";
    public final static String COMMON_AND_STR = "&";
    public final static String UP_ARROW_STR = "^";
    public final static String COMMON_BRACKET_LEFT = "(";
    public final static String COMMON_BRACKET_RIGHT = ")";
    public final static String DOUBLE_DASH_STR = "--";
    public final static String COMMON_PLUS_STR = "+";
    public static final int ORDER_ID_LENGTH = 23;
    public static final int FOLLOW_ID_LENGTH = 18;
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int BAK_INSERT_ERROR = -1;
    public static final int BAK_DEL_ERROR = -2;
    public static final int SMALLORDOUBLE = 1;
    public static final int BIGORSMALL = 2;
    public static final int PAGECOUNT = 15;
    public static final int BEAN_LIST_PAGE_COUNT = 20;//金豆明细列表每页显示的数据数量
    //工程
    public static final String PROJECT = "admin";
    //分隔符
    public static final String SEPARATOR_LINE = System.getProperty("line.separator");
    public static final String SEPARATOR_FILE = System.getProperty("file.separator");

    public static final int MAX_COMPRESS_TIME = 1000;//Gzip压缩和解压缩时间限制MS
    public final static Map<String, String> SCHEDULE_BEAN_MAP = new HashMap<>();

    public static final String SWITCH_OFF = "OFF";
    public static final String SWITCH_ON = "ON";

    //tableShard
    public static final String SHARD_BY_USER_CODE = "userCode";
    public static final String SHARD_BY_GAME_ID = "gameId";
    public static final String SHARD_BY_PERIOD_ID = "periodId";

    public static final String RECHAGE_STATISTICS_WHITE_LIST = "RECHAGE_STATISTICS_WHITE_LIST";
    public static final String all_white_list = "all_white_list";

    public static String generateHandleId(List<Object> params) {
        StringBuffer sb = new StringBuffer();
        params.forEach(sb::append);
        return sb.toString();
    }
}