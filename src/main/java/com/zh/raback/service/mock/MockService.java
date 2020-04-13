package com.zh.raback.service.mock;

import com.alibaba.fastjson.JSON;
import com.github.javafaker.Faker;
import com.google.common.collect.Lists;
import com.zh.raback.domain.*;
import com.zh.raback.repository.*;
import com.zh.raback.util.CommonUtils;
import com.zh.raback.util.FakerUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.zh.raback.util.FakerUtils.weightedArrayElement;
import static com.zh.raback.util.FakerUtils.weightedBoolean;

@Service
public class MockService {

    private static final Logger log = LoggerFactory.getLogger(MockService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CommandRepository commandRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    public void init (){

        //初始化customer
//        if (customerRepository.count() == 0){
            generateCustomers();
//        }

//
//        //初始化category
//        if (categoryRepository.count() == 0) {
            generateCategories();
//        }
//
//        //初始化products
//        if (productRepository.count() == 0) {
            generateProducts();
//        }
////
//        //初始化command
//        if (commandRepository.count() == 0){
            generateCommands();
//        }
//
//
//        if (invoiceRepository.count() == 0){
            generateInvoices();
//        }
//
//
//        if (reviewRepository.count() == 0){
            generateReviews();
//
//        }
//
//
        finalizeMock();
    }

    private void generateReviews() {
      Date today = new Date();
      Date aMonthAgo = DateUtils.addDays(today,-30);


        List<Customer> customers = customerRepository.findAll();

        List<Long> reviews = customers.stream().filter(customer -> customer.isHasOrdered())
            .filter(customer -> weightedBoolean(60))
            .map(customer -> customer.getId()).collect(Collectors.toList());


        List<Command> commands = commandRepository.findAll();

        List<Review> reviewResult = commands.stream().filter(command -> reviews.contains(command.getCustomerId()))
            .map(command -> {
                String basketStr = command.getBasket();
                List<Basket> baskets = JSON.parseArray(basketStr, Basket.class);

                List<Review> reviewList = baskets.stream().filter(basket ->
                    weightedBoolean(40)).map(basket -> {
                    Date date = FakerUtils.randomDate(command.getDate(), null);
                    String status = aMonthAgo.compareTo(date) > 0 ? weightedArrayElement(
                        Lists.newArrayList("accepted", "rejected"), Lists.newArrayList(3, 1)
                    ) : weightedArrayElement(Lists.newArrayList("pending", "accepted", "rejected"), Lists.newArrayList(5, 3, 1));


                    return new Review().date(date).status(status)
                        .commandId(command.getId())
                        .productId(Long.valueOf(basket.getProductId() + ""))
                        .customerId(command.getCustomerId())
                        .rating(RandomUtils.nextInt(1, 6))
                        .comment(Faker.instance().lorem().sentence(120));

                }).collect(Collectors.toList());

                return reviewList;
            }).flatMap(List::stream).collect(Collectors.toList());

        reviewRepository.saveAll(reviewResult);

    }

    private void generateInvoices() {
        List<Command> all = commandRepository.findAll();

        List<Invoice> invoices = all.stream().filter(it -> !it.getStatus().equals("delivered"))
            .sorted((a, b) -> a.getDate().compareTo(b.getDate()))
            .map(item -> {
                Invoice invoice = new Invoice();

                invoice.setDate(item.getDate());
                invoice.customerId(item.getCustomerId())
                    .commandId(item.getId())
                    .totalExTaxes(item.getTotalExTaxes())
                    .deliveryFees(item.getDeliveryFees())
                    .taxRate(item.getTaxRate())
                    .taxes(item.getTaxes())
                    .total(item.getTotal());
                return invoice;

            }).collect(Collectors.toList());

        invoiceRepository.saveAll(invoices);
    }

    private void generateCommands() {
        Date today = new Date();
        Date aMonthAgo = DateUtils.addDays(today,-30);

        List<Command> commands = IntStream.range(0, 600).mapToObj(index -> {

            List<Integer> values = Arrays.stream(IntStream.range(1, 11).toArray()).mapToObj(i -> Integer.valueOf(i)).collect(Collectors.toList());


            Integer weights[] = {30, 20, 5, 2, 1, 1, 1, 1, 1, 1};

            List<Integer> weightList = Arrays.asList(weights);

            Integer nbProducts = FakerUtils.weightedArrayElement(values, weightList);


            List<Basket> basket = IntStream.range(0, nbProducts).mapToObj(it -> new Basket(Faker.instance().random().nextInt(1, 10 * 13),
                FakerUtils.weightedArrayElement(Lists.newArrayList(1, 2, 3, 4, 5), Lists.newArrayList(10, 5, 3, 2, 1))))
                .collect(Collectors.toList());

            Float totalExTaxes = basket.stream().map(it -> {
                try {
                    Product product = productRepository.findById((long) it.getProductId()).get();
                    return product.getPrice() * product.getQuantity();
                } catch (Exception e) {
                    log.error("出现问题" + it, e);
                    return null;
                }


            }).reduce(0f, (item, it) -> item + it);

            float deliveryFees = FakerUtils.randomFloat(3, 8);

            ArrayList<Float> floats = Lists.newArrayList(0.12f, 0.17f, 0.2f);
            float taxRate = FakerUtils.arrayElement(floats);


            float taxes = BigDecimal.valueOf((totalExTaxes + deliveryFees) * taxRate).setScale(2, RoundingMode.HALF_EVEN).floatValue();

            List<Customer> customers = customerRepository.findAll().stream().filter(customer -> customer.isHasOrdered()).collect(Collectors.toList());

            Customer customer = FakerUtils.arrayElement(customers);
            String status = null;
            Date date = null;
            try {
             date = FakerUtils.randomDate(customer.getFirstSeen(), customer.getLastSeen());


             status = date.compareTo(aMonthAgo) > 0 ? "ordered" : FakerUtils.weightedArrayElement(Lists.newArrayList("delivered", "cancelled"), Lists.newArrayList(10, 1));
            }catch (Exception e) {
                e.printStackTrace();;
            }

            return new Command()
                .reference(RandomStringUtils.random(6, true, true))
                .date(date)
                .customerId(customer.getId())
                .basket(JSON.toJSONString(basket))
                .totalExTaxes(totalExTaxes)
                .deliveryFees(deliveryFees)
                .taxRate(taxRate)
                .taxes(taxes)
                .total(totalExTaxes + deliveryFees + taxes)
                .status(status)
                .returned(status.equals("delivered") ? weightedBoolean(10) : false);


        }).collect(Collectors.toList());
        commandRepository.saveAll(commands);

    }

    private void finalizeMock() {

        List<Command> commands = commandRepository.findAll();

        // set latest purchase
        commands.stream().forEach(command -> {
            Optional<Customer> customer = customerRepository.findById(command.getCustomerId());

            if (customer.isPresent() && (customer.get().getLatestPurchase() == null || customer.get().getLatestPurchase().compareTo(command.getDate()) < 0)){
                customer.get().setLatestPurchase(command.getDate());
            }

            customer.get().setTotalSpend(customer.get().getTotalSpend() + command.getTotal());
            customer.get().setNbCommands(customer.get().getNbCommands() + 1);

            customerRepository.save(customer.get());

        });

            // set collects
        Map<Long,Map<String,Integer>> collectors = new HashMap<>();
        for (Command command : commands) {
            Long customerId = command.getCustomerId();
            String basketStr = command.getBasket();
            int size = JSON.parseArray(basketStr).size();
            if(!collectors.containsKey(customerId)) {
                Map<String,Integer> nbProducts = new HashMap<>();
                nbProducts.put("nbProducts",0);
                collectors.put(customerId,nbProducts);
            }

            Integer nbProducts = collectors.get(customerId).get("nbProducts");
            collectors.get(customerId).put("nbProducts",nbProducts+size);
        }

        for (Long customerId : collectors.keySet()) {
            if (collectors.get(customerId).get("nbProducts") > 10){
                Customer customer = customerRepository.findById(customerId).get();
                String group = "collector";
                fillGroup(customer, group);
                customerRepository.save(customer);
            }
        }

        // add ordered_once group
        customerRepository.findAll().stream().forEach(customer -> {

            if (customer.getNbCommands() == 1) {
                fillGroup(customer,"ordered_once");
            }

            if (customer.getTotalSpend() > 1500) {
                fillGroup(customer,"compulsive");
            }

            if (weightedBoolean(20)){
                fillGroup(customer,"regular");
            }

            customerRepository.save(customer);

        });


        commandRepository.findAll().stream().filter(command -> command.isReturned()).forEach(it -> {
            Customer customer = customerRepository.findById(it.getCustomerId()).get();
            if (StringUtils.isNotBlank(customer.getGroups())  && customer.getGroups().indexOf("returns") < 0)
            {
                fillGroup(customer,"returned");
            }
        });


        reviewRepository.findAll().forEach(review -> {
            Optional<Customer> byId = customerRepository.findById(review.getCustomerId());

            if (byId.isPresent() && StringUtils.isNotBlank(byId.get().getGroups()) && byId.get().getGroups().contains("reviewer") )
            {
                fillGroup(byId.get(),"reviewer");
            }
        });



    }

    private void fillGroup(Customer customer, String group) {
        String groups = customer.getGroups();
        String join = CommonUtils.join(groups, group);
        customer.setGroups(join);
    }

    private void generateProducts() {
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
                    .price((float) price)
                    .thumbnail(thumbnail)
                    .image(image)
                    .description(StringUtils.substring(Faker.instance().lorem().paragraph(),0,255))
                    .stock((long) CommonUtils.toRandomInt(0, 250));
                return product;
            }).collect(Collectors.toList());
        }).flatMap(List::stream).collect(Collectors.toList());

        productRepository.saveAll(products);
    }

    private void generateCategories() {
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


    public void generateCustomers() {
        List<Customer> list = IntStream.range(0, 900).mapToObj(it -> {

            Date firstSeen = FakerUtils.randomDate(null,null);
            Date lastSeen = FakerUtils.randomDate(firstSeen,null);

            Boolean hasOrdered = FakerUtils.weightedBoolean(25);

            String firstName = Faker.instance().name().firstName();

            String lastName = Faker.instance().name().lastName();

            String email = Faker.instance().internet().emailAddress();

            Date birthDay = hasOrdered? DateUtils.addDays(new Date(), -60) : null;

            return new Customer().firstName(firstName)
                .lastName(lastName)
                .email(email)
                .address(hasOrdered ? Faker.instance().address().streetName() : null)
                .zipcode(hasOrdered ? Faker.instance().address().zipCode() : null)
                .city(hasOrdered ? Faker.instance().address().city() : null)
                .avatar(Faker.instance().avatar().image())
                .birthday(birthDay)
                .firstSeen(firstSeen)
                .lastSeen(lastSeen)
                .hasOrdered(hasOrdered)
                .latestPurchase(null)
                .hasNewsletter(hasOrdered)
                .groups(null)
                .nbCommands(0)
                .totalSpend(0f);

        }).collect(Collectors.toList());

        customerRepository.saveAll(list);
    }


//    public Date randomDate(int lastDays) {
//        Faker faker = new Faker();
//        Date past = faker.date().past(lastDays, TimeUnit.DAYS);
//        return past;
//    }

    @Data
    @AllArgsConstructor
    public static class Basket{
        int productId;
        int quantity;
    }
}
