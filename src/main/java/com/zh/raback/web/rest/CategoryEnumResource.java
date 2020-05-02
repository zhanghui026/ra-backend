package com.zh.raback.web.rest;

import com.zh.raback.domain.CategoryEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CategoryEnumControllerResource controller
 */
@RestController
@RequestMapping("/api")
public class CategoryEnumResource {

    private final Logger log = LoggerFactory.getLogger(CategoryEnumResource.class);

    /**
    * GET findAll
    */
    @GetMapping("/category-enum")
    public List<CategoryEnumDTO> findAll() {


        List<CategoryEnumDTO> categories = Arrays.stream(CategoryEnum.values()).map(it -> {
            Integer ordinal = it.ordinal();
            String desc = it.getDesc();
            String name = it.name();
            CategoryEnumDTO categoryEnumDTO = new CategoryEnumDTO();

            categoryEnumDTO.setId((long) ordinal);
            categoryEnumDTO.setDesc(desc);
            categoryEnumDTO.setName(name);
            return categoryEnumDTO;

        }).collect(Collectors.toList());

        return categories;
    }



    @Data
    @NoArgsConstructor
    public static class CategoryEnumDTO {

        private Long id;

        private String name;


        private String desc;

    }




}
