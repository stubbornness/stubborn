package com.stubborn.constant;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogConstant {

    public static final Logger commonLog = LoggerFactory.getLogger(CommonConstant.PROJECT);

    public static Logger getLogger(String strEnum) {
        return LoggerFactory.getLogger(strEnum);
    }
}