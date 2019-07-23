package com.stubborn.exception;


import com.stubborn.message.MsgInfo;

/**
 * 统一业务异常
 */
public class BizException extends BaseException {

    public BizException() {
        super();
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(MsgInfo errorInfo, String... args) {
        this.errorInfo = errorInfo;
        this.args = args;
    }

    public BizException(Throwable cause, MsgInfo errorInfo, String... args) {
        super(cause);
        this.errorInfo = errorInfo;
        this.args = args;
    }

}
