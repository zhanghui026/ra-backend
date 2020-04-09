package com.zh.raback.util;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;

public class CommonUtils {


    public static int toRandomInt(int min,int max) {
        return new Faker().random().nextInt(min,max);
    }


    public static String join(String init,String sep){
        if (StringUtils.isBlank(init))
        {
            return sep;
        } else {
            return init +","+sep;
        }
    }
}
