package com.stubborn.util;

import com.stubborn.constant.CommonConstant;
import com.stubborn.constant.LogConstant;
import com.stubborn.entity.HttpParamDto;
import com.stubborn.exception.RemoteInvocationFailureException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


@Service
public class HttpServiceUtils {
    private static final Logger log = LogConstant.commonLog;

    public static String sendRequest(String url, int connectTimeout, int readTimeout, String charset, boolean
            returnSingle) throws RemoteInvocationFailureException {
        return sendRequest(url, connectTimeout, readTimeout, charset, returnSingle, null, null);
    }

    public static String sendRequest(String url, int connectTimeout, int readTimeout, String charset, boolean
            returnSingle, String contentType, String acceptCharset) throws RemoteInvocationFailureException {
        BufferedReader in = null;
        HttpURLConnection conn = null;
        try {
            if (StringUtils.isBlank(charset)) {
                charset = HttpParamDto.DEFAULT_CHARSET;
            }
            conn = getURLConnection(url, connectTimeout, readTimeout, contentType, acceptCharset);
            in = new BufferedReader(new InputStreamReader(connect(conn),
                    charset));

            String result = null;
            result = getReturnResult(in, returnSingle);
            if (StringUtils.isBlank(result)) {
                throw new RemoteInvocationFailureException("网络异常，" + url
                        + " 返回数据为空");
            }
            return result;
        } catch (IOException e) {
            log.warn("", e);
            throw new RemoteInvocationFailureException("网络IO异常[" + url + "]", e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                log.warn("", e);
            }
        }
    }

    public static String sendRequest(String url) throws RemoteInvocationFailureException {
        return sendRequest(url, HttpParamDto.DEFAULT_CONNECT_TIME_OUT, HttpParamDto.DEFAULT_READ_TIME_OUT,
                HttpParamDto.DEFAULT_CHARSET, false);
    }


    public static String sendRequest(String url, boolean returnSingle) throws RemoteInvocationFailureException {
        return sendRequest(url, HttpParamDto.DEFAULT_CONNECT_TIME_OUT,
                HttpParamDto.DEFAULT_READ_TIME_OUT,
                HttpParamDto.DEFAULT_CHARSET, returnSingle);
    }

    public static String sendPostRequest(String url, String content, String charset, int connectTimeout, int
            readTimeout, boolean needCompress, String contentType, boolean returnSingle) {
        return sendPostRequest(url, content, charset, connectTimeout, readTimeout, needCompress, contentType,
                returnSingle, null);
    }

    public static String sendPostRequest(String url, String content, String charset, int connectTimeout, int
            readTimeout, boolean needCompress, String contentType, boolean returnSingle, String userAgent)
            throws RemoteInvocationFailureException {
        BufferedReader in = null;
        HttpURLConnection httpConn = null;
        try {
            httpConn = getURLConnection(url, connectTimeout, readTimeout,
                    contentType, null);
            if (StringUtils.isBlank(charset)) {
                charset = HttpParamDto.DEFAULT_CHARSET;
            }

            if (StringUtils.isNotBlank(userAgent)) {
                httpConn.setRequestProperty("User-agent", userAgent);
            }
            InputStream stream = postConnect(httpConn, content, charset,
                    needCompress);

            in = new BufferedReader(new InputStreamReader(stream, charset));
            String result = getReturnResult(in, returnSingle);
            // log.debug("请求返回结果:" + result);
            if (StringUtils.isBlank(result)) {
                throw new RemoteInvocationFailureException("网络异常，" + url
                        + "无法联通");
            }
            return result;
        } catch (IOException e) {
            log.warn("", e);
            throw new RemoteInvocationFailureException("网络IO异常[" + url + "]", e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                // if (httpConn != null)
                // {
                // httpConn.disconnect();
                // }
            } catch (IOException e) {
                log.warn("", e);
            }
        }
    }

    public static String sendPostRequest(String url, String content, String charset) {
        return sendPostRequest(url, content, charset,
                HttpParamDto.DEFAULT_CONNECT_TIME_OUT,
                HttpParamDto.DEFAULT_READ_TIME_OUT);
    }

    public static String sendPostRequest(String url, String content, String charset,
                                         int connectTimeout, int readTimeout)
            throws RemoteInvocationFailureException {
        return sendPostRequest(url, content, charset, connectTimeout,
                readTimeout, false);
    }

    public static String sendPostRequest(String url, String content, String charset,
                                         boolean needCompress) throws RemoteInvocationFailureException {
        return sendPostRequest(url, content, charset,
                HttpParamDto.DEFAULT_CONNECT_TIME_OUT,
                HttpParamDto.DEFAULT_READ_TIME_OUT, needCompress);
    }

    public static String sendPostRequest(String url, String content, String charset,
                                         int connectTimeout, int readTimeout, String contentType)
            throws RemoteInvocationFailureException {
        return sendPostRequest(url, content, charset, connectTimeout,
                readTimeout, false, contentType, false);
    }

    public static String sendPostRequest(String url, String content, String charset,
                                         int connectTimeout, int readTimeout, boolean needCompress)
            throws RemoteInvocationFailureException {
        return sendPostRequest(url, content, charset, connectTimeout,
                readTimeout, needCompress, null, false);
    }

    /**
     * post方式发送请求
     *
     * @param url
     * @param content
     * @param connectTimeout
     * @param readTimeout
     * @param needCompress
     * @param sslContext
     * @return
     * @throws IOException
     * @throws MalformedURLException
     */
    public static String sendPostRequest(String url, String content, String charset,
                                         int connectTimeout, int readTimeout, boolean needCompress,
                                         SSLContext sslContext) throws MalformedURLException, IOException {
        InputStream is = null;
        // BufferedReader in = null;
        HttpURLConnection httpConn = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        charset = StringUtils.isBlank(charset) ? HttpParamDto.DEFAULT_CHARSET
                : charset;
        try {
            httpConn = getURLConnection(url, connectTimeout, readTimeout, null, null);
            if (StringUtils.isBlank(charset)) {
                charset = HttpParamDto.DEFAULT_CHARSET;
            }
            is = postConnect(httpConn, content, charset, needCompress);
            int ch;
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(baos);
            while ((ch = bis.read()) != -1) {
                bos.write(ch);
            }
            bos.flush();
            bis.close();
            return new String(baos.toByteArray(), HttpParamDto.DEFAULT_CHARSET);
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (httpConn != null) {
                    httpConn.disconnect();
                }
            } catch (Exception e) {
                throw new IOException("[连接关闭异常]", e);
            }
        }
    }

    public static String sendHttpsPostRequest(String url, String content,
                                              String charset, int connectTimeout, int readTimeout,
                                              boolean needCompress, String contentType, boolean returnSingle)
            throws RemoteInvocationFailureException {
        BufferedReader in = null;
        HttpsURLConnection httpsConn = null;
        try {
            httpsConn = getHttpsURLConnection(url, connectTimeout, readTimeout,
                    contentType);
            if (StringUtils.isBlank(charset)) {
                charset = HttpParamDto.DEFAULT_CHARSET;
            }
            InputStream stream = postConnect(httpsConn, content, charset,
                    needCompress);

            in = new BufferedReader(new InputStreamReader(stream, charset));
            String result = getReturnResult(in, returnSingle);
            if (StringUtils.isBlank(result)) {
                throw new RemoteInvocationFailureException("网络异常，" + url
                        + "无法联通");
            }
            return result;
        } catch (IOException e) {
            log.warn("", e);
            throw new RemoteInvocationFailureException("网络IO异常[" + url + "]", e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                log.warn("", e);
            }
        }
    }

    public static String sendHttpsPostRequest(String url, String content,
                                              String charset) {
        return sendHttpsPostRequest(url, content, charset,
                HttpParamDto.DEFAULT_CONNECT_TIME_OUT,
                HttpParamDto.DEFAULT_READ_TIME_OUT, false, null, false);
    }

    private static InputStream postConnect(HttpURLConnection httpConn, String content,
                                           String charset, boolean needCompress) {
        String urlStr = httpConn.getURL().toString();
        try {
            if (StringUtils.isBlank(charset)) {
                charset = HttpParamDto.DEFAULT_CHARSET;
            }
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true,
            // 默认情况下是false;
            httpConn.setDoOutput(true);
            // Post 请求不能使用缓存
            httpConn.setUseCaches(false);
            // 设定请求的方法为"POST"，默认是GET
            httpConn.setRequestMethod("POST");
            if (needCompress) {
                sendCompressRequest(content, charset, httpConn);
            } else {
                sendNoCompressRequest(content, charset, httpConn);
            }
            // 接收数据
            if (needCompress) {
                return new GZIPInputStream(httpConn.getInputStream());
            }
            return httpConn.getInputStream();
        } catch (MalformedURLException e) {
            log.warn("", e);
            throw new RemoteInvocationFailureException(
                    "远程访问异常[" + urlStr + "]", e);
        } catch (IOException e) {
            log.warn("", e);
            throw new RemoteInvocationFailureException(
                    "网络IO异常[" + urlStr + "]", e);
        }
    }

    private static void sendCompressRequest(String content, String charset,
                                            HttpURLConnection httpConn) {
        GZIPOutputStream out = null;
        try {
            httpConn.setRequestProperty("Content-Type", "application/x-gzip");
            httpConn.setRequestProperty("Accept", "application/x-gzip");
            out = new GZIPOutputStream(httpConn.getOutputStream());
            out.write(content.getBytes("GBK"));
            out.flush();
        } catch (IOException e) {
            log.warn("", e);
            throw new RemoteInvocationFailureException("网络IO异常["
                    + httpConn.getURL().toString() + "]", e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    log.warn(e.getMessage(), e);
                }
            }
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 发送原始消息
     *
     * @param content
     * @param charset
     * @param httpConn
     */
    private static void sendNoCompressRequest(String content, String charset,
                                              HttpURLConnection httpConn) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new OutputStreamWriter(
                    httpConn.getOutputStream(), charset));
            out.write(content);
            out.flush();
        } catch (IOException e) {
            log.warn("", e);
            throw new RemoteInvocationFailureException("网络IO异常["
                    + httpConn.getURL().toString() + "]", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 建立远程连接
     *
     * @return
     */
    private static InputStream connect(HttpURLConnection httpConn) {
        String urlStr = httpConn.getURL().toString();
        try {
            if (httpConn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                log.info(urlStr + "|ResponseCode="
                        + httpConn.getResponseCode());
                throw new RemoteInvocationFailureException("远程访问" + urlStr
                        + "出错，返回结果为：" + httpConn.getResponseCode());
            }
            return httpConn.getInputStream();
        } catch (IOException e) {
            log.warn("", e);
            throw new RemoteInvocationFailureException(
                    "网络IO异常[" + urlStr + "]", e);
        }
    }

    /**
     * 构造URLConnnection
     *
     * @param urlStr
     * @param connectTimeout
     * @param readTimeout
     * @param contentType    content-type类型
     * @return
     * @throws RemoteInvocationFailureException
     */
    private static HttpURLConnection getURLConnection(String urlStr, int connectTimeout, int readTimeout, String
            contentType, String acceptCharset)
            throws RemoteInvocationFailureException {
        try {
            URL remoteUrl = new URL(urlStr);
            HttpURLConnection httpConn = (HttpURLConnection) remoteUrl
                    .openConnection();
            httpConn.setConnectTimeout(connectTimeout);
            httpConn.setReadTimeout(readTimeout);
            if (StringUtils.isNotBlank(contentType)) {
                httpConn.setRequestProperty("Content-type", contentType);
            }
            if (StringUtils.isNotBlank(acceptCharset)) {
                httpConn.setRequestProperty("Accept-Charset", acceptCharset);
            }
            return httpConn;
        } catch (MalformedURLException e) {
            log.warn("", e);
            throw new RemoteInvocationFailureException(
                    "远程访问异常[" + urlStr + "]", e);
        } catch (IOException e) {
            log.warn("", e);
            throw new RemoteInvocationFailureException(
                    "网络IO异常[" + urlStr + "]", e);
        }
    }

    /**
     * 构造URLConnnection
     *
     * @param urlStr
     * @param connectTimeout
     * @param readTimeout
     * @param contentType    content-type类型
     * @return
     * @throws RemoteInvocationFailureException
     */
    private static HttpsURLConnection getHttpsURLConnection(String urlStr,
                                                            int connectTimeout, int readTimeout, String contentType)
            throws RemoteInvocationFailureException {
        try {
            URL remoteUrl = new URL(urlStr);
            HttpsURLConnection httpConn = (HttpsURLConnection) remoteUrl
                    .openConnection();
            httpConn.setConnectTimeout(connectTimeout);
            httpConn.setReadTimeout(readTimeout);
            if (contentType != null) {
                httpConn.setRequestProperty("content-type", contentType);
            }
            return httpConn;
        } catch (MalformedURLException e) {
            log.warn("", e);
            throw new RemoteInvocationFailureException(
                    "远程访问异常[" + urlStr + "]", e);
        } catch (IOException e) {
            log.warn("", e);
            throw new RemoteInvocationFailureException(
                    "网络IO异常[" + urlStr + "]", e);
        }
    }

    private static HttpURLConnection getURLConnection(String urlStr, int connectTimeout, int readTimeout)
            throws RemoteInvocationFailureException {
        return getURLConnection(urlStr, connectTimeout, readTimeout, null, null);
    }

    private static String getReturnResult(BufferedReader in, boolean returnSingleLine)
            throws IOException {
        if (returnSingleLine) {
            return in.readLine();
        } else {
            StringBuffer sb = new StringBuffer();
            String result = "";
            while ((result = in.readLine()) != null) {
//                log.debug("从中心返回：" + result);
                sb.append(StringUtils.trimToEmpty(result));
            }
            return sb.toString();
        }
    }

    public static String getRequestFileStr(String urlStr) {
        BufferedReader in = null;
        HttpURLConnection conn = null;
        try {
            String charset = HttpParamDto.DEFAULT_CHARSET;
            conn = getURLConnection(urlStr, HttpParamDto.DEFAULT_CONNECT_TIME_OUT, HttpParamDto.DEFAULT_READ_TIME_OUT);
            in = new BufferedReader(new InputStreamReader(connect(conn),
                    charset));
            StringBuffer sb = new StringBuffer();
            String result = "";
            while ((result = in.readLine()) != null) {
                sb.append(StringUtils.trimToEmpty(result) + CommonConstant.SEPARATOR_LINE);
            }
//            if (StringUtils.isBlank(sb.toString())) {
//                throw new RemoteInvocationFailureException("网络异常，" + urlStr
//                        + " 返回数据为空");
//            }
            return sb.toString();
        } catch (IOException e) {
            log.warn("", e);
            throw new RemoteInvocationFailureException("网络IO异常[" + urlStr + "]", e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                log.warn("", e);
            }
        }
    }
}
