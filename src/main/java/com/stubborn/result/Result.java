package com.stubborn.result;

import com.stubborn.message.DefaultMsgInfo;
import com.stubborn.message.MsgInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 返回体
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Result extends BaseResult {

    /**
     * 响应结果
     */
    private Object resp;

    public static Result response() {
        return new Result("");
    }

    public static Result response(MsgInfo errorInfo) {
        return new Result(errorInfo);
    }

    public static Result response(MsgInfo errorInfo, String... args) {
        return new Result(errorInfo, args);
    }

    public static Result response(Object resp) {
        return new Result(resp);
    }

    /**
     * 构造函数
     * @param errorInfo 消息枚举类型s
     */
    private Result(MsgInfo errorInfo) {
        super(errorInfo);
    }

    /**
     * 构造函数
     * @param errorInfo 错误枚举信息
     * @param args 消息参数
     */
    private Result(MsgInfo errorInfo, String... args) {
        super(errorInfo, args);
    }

    /**
     * 构造函数，code=0;msg=Success;
     * @param resp 请求成功时的实际返回信息
     */
    private Result(Object resp) {
        super.setCode(DefaultMsgInfo.SUCCESS.getCode());
        super.setMsg(DefaultMsgInfo.SUCCESS.getMessage());
        this.resp = resp;
    }
}