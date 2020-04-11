package com.zh.raback.util;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RsqlUtils {


    public static String search2rsqlStr(String search, List<String> qSearchFields, Set<String> starsFields){
        List<String> splits = Splitter.on(";").splitToList(search);
        String wrapperSearch = splits.stream().map(it -> {
            List<String> values = Splitter.on("==").splitToList(it);
            String key = values.get(0);
            String value = values.get(1);
            if (key.equals("q")) {
                String join = qSearchFields.stream().map(q -> q + "==" + value+"*").collect(Collectors.joining(","));
                return join;
            } else if (key.contains("_gte"))
            {
                return key.substring(0,key.length() - 4)+"=ge="+value;
            } else if (key.contains("_lte")){
                return key.substring(0,key.length() - 4)+"=le="+value;
            } else  if (key.contains("_ge")){
                return key.substring(0,key.length() - 3)+"=gt="+value;
            } else if (key.contains("_le")){
                return key.substring(0,key.length() - 3)+"=lt="+value;
            } else if(starsFields.contains(key)){
                return key+"=="+value+"*";
            }
            else {
                return it;
            }

        }).collect(Collectors.joining(";"));
        return wrapperSearch;
    }
}
