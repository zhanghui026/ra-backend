package com.zh.raback.util;

import com.github.javafaker.Faker;

public class CommonUtils {


    public static int toRandomInt(int min,int max) {
        return new Faker().random().nextInt(min,max);
    }
}
