package com.zh.raback.service;

import com.github.javafaker.Faker;
import com.google.common.collect.Lists;
import com.zh.raback.domain.Category;
import com.zh.raback.domain.Product;
import com.zh.raback.repository.CategoryRepository;
import com.zh.raback.repository.ProductRepository;
import com.zh.raback.util.CommonUtils;
import com.zh.raback.web.rest.CategoryResource;
import com.zh.raback.web.rest.ProductResource;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MockService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void init (){
        if (categoryRepository.count() == 0) {
            List<String> categories = Lists.newArrayList("animals",
                "beard", "business", "cars", "city",
                "flowers", "food", "nature", "people", "sports", "tech", "travel", "water");
            List<Category> cats = categories.stream().map(it -> {
                Category category = new Category();
                category.setName(it);
                return category;
            }).collect(Collectors.toList());
            categoryRepository.saveAll(cats);
        }
        if (productRepository.count() == 0) {
            List<Category> cats = categoryRepository.findAll();
            List<Product> products = cats.stream().map(it -> {
                return IntStream.range(0, 10).mapToObj(index -> {
                    int width = CommonUtils.toRandomInt(10, 40);
                    int height = CommonUtils.toRandomInt(10, 40);
                    int price = CommonUtils.toRandomInt(5, 20);
                    String thumbnail = "https://marmelab.com/posters/" + it.getName() + "-" + (index + 1) + ".jpeg";
                    String image = "https://marmelab.com/posters/" + it.getName() + "-" + (index + 1) + ".jpeg";
                    Product product = new Product();
                    char c = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()[Faker.instance().random().nextInt(26)];
                    product.categoryId(it.getId())
                        .reference(it.getName().substring(0, 2) +
                            "-" + RandomStringUtils.randomAlphabetic(5) +
                            "-" + c
                        ).width((long) width)
                        .height((long) height)
                        .price((long) price)
                        .thumbnail(thumbnail)
                        .image(image)
                        .description(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                        .stock((long) CommonUtils.toRandomInt(0, 250));
                    return product;
                }).collect(Collectors.toList());
            }).flatMap(List::stream).collect(Collectors.toList());

            productRepository.saveAll(products);
        }
    }
}
