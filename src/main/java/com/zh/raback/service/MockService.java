package com.zh.raback.service;

import com.github.javafaker.Faker;
import com.google.common.collect.Lists;
import com.zh.raback.domain.Category;
import com.zh.raback.domain.Customer;
import com.zh.raback.domain.Product;
import com.zh.raback.repository.CategoryRepository;
import com.zh.raback.repository.CustomerRepository;
import com.zh.raback.repository.ProductRepository;
import com.zh.raback.util.CommonUtils;
import com.zh.raback.web.rest.CategoryResource;
import com.zh.raback.web.rest.ProductResource;
import liquibase.pro.packaged.F;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MockService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

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
        if (customerRepository.count() == 0){
            initCustomer();
        }
    }


    public void initCustomer() {
        List<Customer> list = IntStream.range(0, 900).mapToObj(it -> {

            Instant firstSeen = Instant.ofEpochMilli(randomDate(300).getTime());
            Instant lastSeen = Instant.ofEpochMilli(randomDate(100).getTime());

            Boolean hasOrdered = Faker.instance().bool().bool();

            String firstName = Faker.instance().name().firstName();

            String lastName = Faker.instance().name().lastName();

            String email = Faker.instance().internet().emailAddress();

            Date birthDay = Faker.instance().date().birthday();

            return new Customer().firstName(firstName)
                .lastName(lastName)
                .email(email)
                .address(hasOrdered ? Faker.instance().address().streetName() : null)
                .zipcode(hasOrdered ? Faker.instance().address().zipCode() : null)
                .city(hasOrdered ? Faker.instance().address().city() : null)
                .avatar(Faker.instance().avatar().image())
                .birthday(birthDay.toInstant())
                .firstSeen(firstSeen)
                .lastSeen(lastSeen)
                .hasOrdered(hasOrdered)
                .latestPurchase(null)
                .hasNewsletter(hasOrdered)
                .groups(null)
                .nbCommands(0)
                .totalSpend(0);

        }).collect(Collectors.toList());

        customerRepository.saveAll(list);
    }


    public Date randomDate(int lastDays) {
        Faker faker = new Faker();
        Date past = faker.date().past(lastDays, TimeUnit.DAYS);
        return past;
    }
}
