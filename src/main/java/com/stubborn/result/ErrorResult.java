package com.stubborn.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stubborn.message.DefaultMsgInfo;
import com.stubborn.message.MsgInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 错误信息
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class ErrorResult extends BaseResult {

    /**
     * 开发者关心的信息
     */
    @JsonIgnore
    private String developerMsg = "";

    /**
     * 请求URL
     */
    @JsonIgnore
    private String path = "";

    public static ErrorResult response() {
        return new ErrorResult(DefaultMsgInfo.SERVER_ERROR.getCode(), "Internal Server Error");
    }

    public static ErrorResult response(String code, String msg) {
        return new ErrorResult(code, msg);
    }

    public static ErrorResult response(String msg) {
        return new ErrorResult(DefaultMsgInfo.SERVER_ERROR, new String[]{msg});
    }

    public static ErrorResult response(MsgInfo errorInfo) {
        return new ErrorResult(errorInfo);
    }

    public static ErrorResult response(MsgInfo errorInfo, String... args) {
        return new ErrorResult(errorInfo, args);
    }

    public static ErrorResult response(MsgInfo errorInfo, String developerMsg, String path) {
        return new ErrorResult(errorInfo, developerMsg, path);
    }

    public static ErrorResult response(MsgInfo errorInfo, String developerMsg, String path, String... args) {
        return new ErrorResult(errorInfo, developerMsg, path, args);
    }

    /**
     * 构造函数
     * @param code 错误信息枚举
     * @param msg 请求路径
     */
    private ErrorResult(String code, String msg) {
        super(code, msg);
    }

    /**
     * 构造函数
     * @param errorInfo 错误信息枚举
     * @param args 自定义消息参数
     */
    private ErrorResult(MsgInfo errorInfo, String... args) {
        super(errorInfo, args);
    }

    /**
     * 构造函数
     * @param errorInfo 错误信息枚举
     * @param path 请求路径
     * @param args 自定义消息参数
     */
    private ErrorResult(MsgInfo errorInfo, String path, String... args) {
        super(errorInfo, args);
//        this.path = path;
    }

    /**
     * 构造函数
     * @param errorInfo 错误信息枚举
     * @param developerMsg 面向开发者的信息
     * @param path 请求路径
     */
    private ErrorResult(MsgInfo errorInfo, String developerMsg, String path) {
        super(errorInfo);
//        this.developerMsg = developerMsg;
//        this.path = path;
    }

    /**
     * 构造函数
     * @param errorInfo 错误信息枚举
     * @param developerMsg 面向开发者的信息
     * @param path 请求路径
     */
    private ErrorResult(MsgInfo errorInfo, String developerMsg, String path, String... args) {
        super(errorInfo, args);
//        this.developerMsg = developerMsg;
//        this.path = path;
    }
}
