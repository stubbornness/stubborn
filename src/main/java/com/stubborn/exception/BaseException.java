package com.stubborn.exception;


import com.stubborn.message.MsgInfo;

/**
 * Created by moccanism on 17/12/7.
 */
public abstract class BaseException extends RuntimeException {

    /** 消息枚举 */
    protected MsgInfo errorInfo;
    /** 消息参数 */
    protected String[] args;

    BaseException() {
        super();
    }

    BaseException(Throwable cause) {
        super(cause);
    }

    public MsgInfo getErrorInfo() {
        return errorInfo;
    }

    public String[] getArgs() {
        return this.args;
    }
}
