package com.stubborn.message;

/**
 * SYS模块错误码
 */
public enum DefaultMsgInfo implements MsgInfo {

    SUCCESS("0", "Success"),

    //HTTP STASTUS 状态码
    BAD_REQUEST("400", "Bad Request"),
    UNAUTHORIZED("401", "{0}"),
    FORBIDDEN("403", "Forbidden"),
    NOT_FOUND("404", "Not Found"),
    METHOD_NOT_ALLOWED("405", "Method Not Allowed"),
    NOT_ACCEPTABLE("406", "Not Acceptable"),
    UNSUPPORTED_MEDIA_TYPE("415", "Unsupported Media Type"),
    TOO_MANY_REQUESTS("429", "Too Many Requests"),

//    SERVER_ERROR("500", "Internal Server Error"),
    SERVER_ERROR("SYS0000", "{0}");

    private String code;
    private String message;

    private DefaultMsgInfo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return "[" + this.code + "]" + this.message;
    }
}
