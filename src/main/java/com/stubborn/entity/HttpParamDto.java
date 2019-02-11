package com.stubborn.entity;

/**
 * http对外接口参数
 */
public class HttpParamDto {
    public static final String METHOD_TYPE_GET = "GET";
    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final String CHARSET_GBK = "GBK";
    /**
     * 默认连接超时为20秒
     */
    public static final int CONNECTION_TIME_OUT = 20000;
    /**
     * 默认数据传输超时为20秒
     */
    public static final int SO_TIME_OUT = 20000;

    public static final int DEFAULT_CONNECT_TIME_OUT = 10000;

    public static final int DEFAULT_READ_TIME_OUT = 30000;

    public static final int MEIZU_ORDER_SEND_READ_TIME_OUT = 35000;

    public static final int MEIZU_ORDER_SEND_CONNECT_TIME_OUT = 20000;
    // 默认最小值的阀值
    public static final int DEFAULT_MIN_VALUE = 3000;
    // 默认最大值的阀值
    public static final int DEFAULT_MAX_VALUE = 10000;

    /**
     * 与外部交互的统一接口url
     */
    private String url;
    /**
     * post请求发送的参数串
     */
    private String content = "";
    /**
     * 交互方式,默认为get
     */
    private String methodType = METHOD_TYPE_GET;
    /**
     * 编码类型,默认是utf-8
     */
    private String charset = DEFAULT_CHARSET;
    /**
     * 超时时间
     */
    private int connectionTimeOut = CONNECTION_TIME_OUT;
    /**
     * 超时时间
     */
    private int soTimeOut = SO_TIME_OUT;
    /**
     * 是否压缩，默认为不压缩
     */
    private boolean compress = false;
    /**
     * 是否返回单行，默认是false，不返回单行
     */
    private boolean returnSingle = false;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public int getConnectionTimeOut() {
        return connectionTimeOut;
    }

    public void setConnectionTimeOut(int connectionTimeOut) {
        this.connectionTimeOut = connectionTimeOut;
    }

    public int getSoTimeOut() {
        return soTimeOut;
    }

    public void setSoTimeOut(int soTimeOut) {
        this.soTimeOut = soTimeOut;
    }

    public boolean isCompress() {
        return compress;
    }

    public void setCompress(boolean compress) {
        this.compress = compress;
    }

    public boolean isReturnSingle() {
        return returnSingle;
    }

    public void setReturnSingle(boolean returnSingle) {
        this.returnSingle = returnSingle;
    }

    @Override
    public String toString() {
        return "HttpParams [url=" + url + ", methodType=" + methodType
                + ", charset=" + charset + ", connectionTimeOut="
                + connectionTimeOut + ", soTimeOut=" + soTimeOut
                + ", compress=" + compress + ", returnSingle=" + returnSingle
                + "]";
    }

}
