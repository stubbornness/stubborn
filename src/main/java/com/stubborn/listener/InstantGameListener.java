package com.stubborn.listener;

import com.stubborn.annotation.InstantGame;
import com.stubborn.exception.BusinessException;
import com.stubborn.util.SpringContextHolder;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import service.InstantGameService;

import java.util.HashMap;
import java.util.Map;


@Component
public class InstantGameListener implements ApplicationListener<ContextRefreshedEvent> {

    public static Map<String, InstantGameService> instantGameMap = new HashMap<>();

    @Value("${project.data.gameSwitch}")
    private String gameSwitch;

    private final static String switchOn = "true";

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            getAllInstantGameInst();
        }
    }

    private void getAllInstantGameInst() {
        if (!switchOn.equals(gameSwitch)) {
            return;
        }
        ApplicationContext ctx = SpringContextHolder.getApplicationContext();
        Map<String, Object> beanMap = ctx.getBeansWithAnnotation(InstantGame.class);
        for (Object bean: beanMap.values()) {
            if (bean instanceof InstantGameService) {
                Class<?> clazz = AopUtils.getTargetClass(bean);
                InstantGame instantGame = clazz.getAnnotation(InstantGame.class);
                if (instantGame != null) {
                    InstantGameService instantGameService = (InstantGameService)bean;
                    String gameEn = instantGame.gameEn();
                    if (instantGameMap.containsKey(gameEn)) {
                        throw new BusinessException("gameEn is repeat in service");
                    }
                    instantGameMap.put(instantGame.gameEn(), instantGameService);
                }
            }
        }
    }
}
