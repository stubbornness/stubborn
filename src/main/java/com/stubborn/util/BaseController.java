package com.stubborn.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseController {
    //protected static Logger log = LogConstant.commonLog;

    public Object buildSuccJson() {
        return buildJson(ResultConstant.SUCCESS, "success");
    }

    public Object buildSuccJson(Object data) {
        return buildJson(ResultConstant.SUCCESS, "success", data);
    }

    public Object buildJson(int code, String msg) {
        return buildJson(code, msg, null);
    }

    public Object buildJson(String code, String msg) {
        return buildJson(code, msg, null);
    }

    public Object buildErrJson(String msg) {
        return buildJson(ResultConstant.ERROR, msg, null);
    }

    public Object buildSysErrJson() {
        return buildErrJson("system error");
    }

    public Object buildJson(int code, String msg, Object data) {
        String time = DateUtil.getCurrentDate();
        if (data == null) {
            return CommonUtil.asMap("code", code, "msg", msg, "serverTime", time, "resp", "");
        } else {
            return CommonUtil.asMap("code", code, "msg", msg, "serverTime", time, "resp", data);
        }
    }

    public Object buildJson(String code, String msg, Object data) {
        String time = DateUtil.getCurrentDate();
        return CommonUtil.asMap("code", code, "msg", msg, "serverTime", time, "resp", data);
    }

    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        long now = System.currentTimeMillis();//统一时间戳
        HttpServletResponse response = CommonConstant.responseTL.get();
        response.setCharacterEncoding("UTF-8");
        try {
            String msg = e.getMessage();
            if (ResultConstant.NEED_RELOGIN.equals(msg)) {
                //response.getWriter().print(JSONObject.toJSONString(buildJson(ResultConstant.SIGN_ERROR, "需要重新登录")));
            } else {
                if (StringUtils.isBlank(e.getMessage())) {
                    //log.info("[BaseControllerException]", e);
                }
                //response.getWriter().print(JSONObject.toJSONString(buildErrJson(e.getMessage())));
            }
        } catch (Exception ex) {
            //log.error("Error" + now + ":", ExceptionUtil.getExceptionInfo(ex));
            /*Map<String, Object> mailBodyMap = new HashMap<>();
            mailBodyMap.put("error", ex);*/
            //MailUtil.sendMail("Error", ExceptionUtil.getExceptionInfo(ex), MailUtil.MOBILES.split(",")[0],
                   // Boolean.FALSE, Boolean.TRUE, 5, MailUtil.EMAILS, MailUtil.DEV);
        }
        //String logWarnWhiteListStr = IniCache.getIniValue(IniConstant.LOG_WARN_WHITE_LIST);
        //if (!logWarnWhiteListStr.contains(e.getMessage())) {
            //log.error("Error" + now + ":", ExceptionUtil.getExceptionInfo(e));
            /*Map<String, Object> mailBodyMap = new HashMap<>();
            mailBodyMap.put("error", e);*/
           // MailUtil.sendMail("Error", ExceptionUtil.getExceptionInfo(e), MailUtil.MOBILES.split(",")[0],
                    //Boolean.FALSE, Boolean.TRUE, 5, MailUtil.EMAILS, MailUtil.DEV);
       // }
    }
}
