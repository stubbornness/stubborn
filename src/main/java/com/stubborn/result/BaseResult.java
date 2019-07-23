package com.stubborn.result;

import com.stubborn.message.MsgInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.MessageFormat;

/**
 * 远程接口返回值的基类
 */
@Data
@NoArgsConstructor
abstract class BaseResult {

    /**
     * 错误代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 构造函数
     * @param code 消息Code
     * @param msg 信息内容
     */
    BaseResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 构造函数
     * @param errorInfo 消息枚举类型s
     */
    BaseResult(MsgInfo errorInfo) {
        this.code = errorInfo.getCode();
        this.msg = errorInfo.getMessage();
    }

    /**
     * 构造函数
     * @param errorInfo 错误枚举信息
     * @param args 消息参数
     */
    BaseResult(MsgInfo errorInfo, String... args) {
        this.code = errorInfo.getCode();
        this.msg = MessageFormat.format(errorInfo.getMessage(), (Object[]) args);
    }

}
