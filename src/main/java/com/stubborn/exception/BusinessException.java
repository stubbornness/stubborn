package com.stubborn.exception;


import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;

public class BusinessException extends RuntimeException {

    public BusinessException() {
        super();
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(Object message) {
        super(message.toString());
    }


    public static void main(String[] args) {
        for (int i = 0; i <1000 ; i++) {
            System.out.println(getChipsSet(12L));
        }
    }

    protected static Set<BigDecimal> getChipsSet(long gameId) {
        Set<BigDecimal> amountSet = new HashSet<>();
        String    chipsValue = "20,100,1000_10000,1000";
        String [] chips = chipsValue.split("_");
        int chipsCont = 0;
        int chipsFree = 0;
        if (0 == chips.length) {
            return amountSet;
        }
        List<String> chipsList = new ArrayList<>();
        if (StringUtils.isNotBlank(chips[0])) {
            String [] free = chips[0].split(",");
            chipsFree = free.length;
            chipsList.addAll(Arrays.asList(free));
        }
        if (StringUtils.isNotBlank(chips[1])) {
            String [] contro = chips[1].split(",");
            chipsCont = contro.length;
            chipsList.addAll(Arrays.asList(contro));
        }
        Random random = new Random();
        int num = chipsList.size();
        int count = random.nextInt(3) + 2;
        int crisis = chipsFree * 2 + chipsCont;
        for (int i = 0; i < count; i ++) {
            int next = random.nextInt(num * 2);
            int index = 0;
            if (crisis <= next) {
                index = random.nextInt(chipsCont) + chipsFree;
            } else {
                index = random.nextInt(chipsFree);
            }
            amountSet.add(new BigDecimal(chipsList.get(index)));
        }
        return amountSet;
    }
}
