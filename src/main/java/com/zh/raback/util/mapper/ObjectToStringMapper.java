package com.zh.raback.util.mapper;


import com.alibaba.fastjson.JSON;
import com.zh.raback.service.dto.CommandDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectToStringMapper {

    @BasketElement
    public String basketToString(List<CommandDTO.Basket> basket){
        if (basket != null){
            return JSON.toJSONString(basket);
        }else {
            return null;
        }
    }

    @BasketString
    public List<CommandDTO.Basket> parseBasket(String basket) {
        if (StringUtils.isNoneBlank(basket)){
            return JSON.parseArray(basket, CommandDTO.Basket.class);
        } else {
            return null;
        }
    }

}
