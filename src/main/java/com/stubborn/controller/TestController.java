package com.stubborn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author 丁少东
 * @create 2018-05-25 下午3:32
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("/show")
    public Object show(){
        return 123;
    }
}
