package com.stubborn.util;

/*import com.caiqr.quizzes.cache.GameCache;
import com.caiqr.quizzes.entity.core.po.Game;*/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Singal
 */
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
    public static final int PAGE_COUNT = 10;//订单列表每页显示的数据数量
    public static final int BEAN_LIST_PAGE_COUNT = 20;//金豆明细列表每页显示的数据数量

    public static final String THRID_CPS_MZ_BALANCER = "mzbalancer";

    public static final String COMMON_GAME_STOP_ALERT_20_CLOCK = "20:00:00";
    public static final String COMMON_GAME_STOP_ALERT_12_CLOCK = "12:00:00";

    //分隔符
    public static final String SEPARATOR_LINE = System.getProperty("line.separator");
    public static final String SEPARATOR_FILE = System.getProperty("file.separator");

    public final static String BEAN_NAME_GAME_ID = "gameId";
    public final static String BEAN_NAME_TASK_ID = "taskId";
    public final static String BEAN_NAME_PLATFORM_ID = "platformId";
    public final static String[] BEAN_NAME_ALL_ARRAY = new String[]{BEAN_NAME_GAME_ID, BEAN_NAME_TASK_ID,
            BEAN_NAME_PLATFORM_ID};
    public final static String[] BEAN_NAME_GAME_ARRAY = new String[]{BEAN_NAME_GAME_ID};
    public final static String[] BEAN_NAME_GAME_TASK_ARRAY = new String[]{BEAN_NAME_GAME_ID, BEAN_NAME_TASK_ID};

    //tableShard
    public static final String SHARD_BY_USER_CODE = "userCode";
    public static final String SHARD_BY_GAME_ID = "gameId";
    public static final String SHARD_BY_PERIOD_ID = "periodId";
    public static final String SHARD_BY_ORDER_ID = "orderId";

    public final static Map<String, String> SCHEDULE_BEAN_MAP = new HashMap<>();


    public static final String DEFAULT_STOP_SALE_MESSAGE = "大爷，这会儿暂停接客啦，您晚点再来呗~";

    public static final String DESK_SERVICE_KEY_WORD = "[ServiceDesk]:";

    public static final String BET_SINGLE = "1";

    public static final String PERIOD_STATUS_INIT = "000";
    public static final String OPEN_AWARD = "110";
    public static final String DISTRIBUTE_AWARD = "111";

    //玩法类型，1:单双。2:大小
    public static final String ODD_OR_EVEN = "001";
    public static final String BIG_OR_SMALL = "002";
//app urlheader的app信息
    public static final String APP_INFO = "App-Info";
    public static final String APP_SYS_IOS = "ios";
    public static final String APP_SYS_ANDROID = "android";

    //红包类型可用
    public static final Integer RED_PACKET_NOT_ACTIVE = 0;
    public static final Integer RED_PACKET_STATUS = 1;
    public final static Integer RED_PACKET_IS_USE = 3;//红包类型已使用
    public final static Integer RED_PACKET_ALEARD_USE = 4;//红包类型使用中
    //红包未派发
    public final static String RED_PACKET_NOT_SEND = "2";
    //红包已派发
    public final static String RED_PACKET_SEND = "1";
    //红包可paifa
    public final static String RED_PACKET_CAN_SEND = "0";
    /** app审核状态 - 已审核 */
    public static final Integer APP_VERSION_COMMITED = 0;
    /** app审核状态 - 审核中 */
    public static final Integer APP_VERSION_AUDITING = 1;

   /* static {
        SCHEDULE_BEAN_MAP.put(CommonUtil.mergeUnionKey(Game.GAME_TYPE_COMMON, BEAN_NAME_GAME_ID), "digitalGameBean");
        SCHEDULE_BEAN_MAP.put(CommonUtil.mergeUnionKey(Game.GAME_TYPE_COMMON, BEAN_NAME_TASK_ID), "digitalPeriodBean");
        SCHEDULE_BEAN_MAP.put(CommonUtil.mergeUnionKey(Game.GAME_TYPE_COMMON, BEAN_NAME_PLATFORM_ID),
                "digitalPlatformBean");
        SCHEDULE_BEAN_MAP.put(CommonUtil.mergeUnionKey(Game.GAME_TYPE_HIGH_FREQUENCY, BEAN_NAME_GAME_ID),
                "digitalGameBean");
        SCHEDULE_BEAN_MAP.put(CommonUtil.mergeUnionKey(Game.GAME_TYPE_HIGH_FREQUENCY, BEAN_NAME_TASK_ID),
                "digitalPeriodBean");
        SCHEDULE_BEAN_MAP.put(CommonUtil.mergeUnionKey(Game.GAME_TYPE_HIGH_FREQUENCY, BEAN_NAME_PLATFORM_ID),
                "digitalPlatformBean");
    }

    public static String getBeanName(Long gameId, String beanType) {
        Game game = GameCache.getGame(gameId);
        return SCHEDULE_BEAN_MAP.get(CommonUtil.mergeUnionKey(game.getGameType(), beanType));
    }
*/
    public static String generateHandleId(List<Object> params) {
        StringBuffer sb = new StringBuffer();
        params.forEach(sb::append);
        return sb.toString();
    }
}