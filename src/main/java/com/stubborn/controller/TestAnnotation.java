package com.stubborn.controller;

import com.stubborn.exception.BusinessException;
import com.stubborn.listener.InstantGameListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.InstantGameService;

/**
 * @author 丁少东
 * @create 2018-10-15 上午11:32
 **/
@RestController("/test")
public class TestAnnotation {


    @RequestMapping("/initGame")
    @ResponseBody
    public Object initGame(@RequestParam String gameEn) {

        InstantGameService instantGameService = InstantGameListener.instantGameMap.get(gameEn);
        if (instantGameService == null) {
            throw new BusinessException(gameEn + " game is not define");
        }
        //return buildSuccJson(instantGameService.initGame(gameEn));
        return null;
    }

}
