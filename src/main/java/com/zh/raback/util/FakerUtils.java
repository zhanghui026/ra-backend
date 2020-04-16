package com.zh.raback.util;

import com.github.javafaker.Faker;
import com.google.common.collect.Streams;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class FakerUtils {

    public static final Logger log = LoggerFactory.getLogger(FakerUtils.class);

    /**
     * 给出两列数据，数据以及权重，生成一个数组，并且得到一个数组随机值
     */
    public static <T> T weightedArrayElement(List<T> values, List<Integer> weights) {

        List<T> result = Streams.zip(values.stream(), weights.stream(), (value, weight) -> {
            return Collections.nCopies(weight, value);
        }).flatMap(List::stream).collect(Collectors.toList());


        int index = RandomUtils.nextInt(0, result.size());

        return result.get(index);
    }


    public static boolean weightedBoolean(int likelyhood) {
        return RandomUtils.nextInt(0,99) < likelyhood;
    }


    public static Date randomDate(Date minDate , Date maxDate) {

       minDate =  minDate == null? DateUtils.addDays(new Date(),-365 * 5):minDate;
       maxDate =  maxDate == null? new Date():maxDate;

        long diff = maxDate.getTime() - minDate.getTime();
        long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        return DateUtils.addDays(minDate,RandomUtils.nextInt(0,(int)days));

    }

    public static float randomFloat(float min,float max) {
        double d = Faker.instance().random().nextInt((int)min * 100 ,(int)max* 100) / 100;
        return new BigDecimal(d).setScale(2, RoundingMode.HALF_EVEN).floatValue();
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();
    }


    public static <T> T arrayElement(List<T> list){

        int i = RandomUtils.nextInt(0, list.size() - 1);
        return list.get(i);

    }


    public static void main(String[] args) {
        System.out.println(Faker.instance(Locale.CHINA).name().name());
        System.out.println(Faker.instance(Locale.forLanguageTag("ru")).name().name());
        System.out.println(Faker.instance().name().name());
        System.out.println(Faker.instance(Locale.CHINA).avatar().image());
        System.out.println(Faker.instance().avatar().image());
        System.out.println(Faker.instance().avatar().image());
//        System.out.println(Faker.instance().avatar().image());
//
//                        Date firstSeen = FakerUtils.randomDate(null, null);
//                Date lastSeen = FakerUtils.randomDate(firstSeen, null);
//        System.out.println(firstSeen + " - " + lastSeen);
//
//
//        for (int i = 0 ;i < 50000 ; i++) {
////            Integer integer = Faker.instance().random().nextInt(1, 10 * 13);
////            if (integer <0){
////                System.out.println(integer);
////            }
////
////            if (integer > 130) {
////                System.out.println(integer);
////            }
////
////            randomDate(null,null);
//
//                Date firstSeen = FakerUtils.randomDate(null, null);
//                Date lastSeen = FakerUtils.randomDate(firstSeen, null);
//
////            if (firstSeen.compareTo(lastSeen) > 0){
//                System.out.println(firstSeen + " - " + lastSeen);
//
////            }
//        }


    }

}
