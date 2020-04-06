package com.zh.raback.web.rest;

import com.zh.raback.RabackApp;
import com.zh.raback.domain.Customer;
import com.zh.raback.repository.CustomerRepository;
import com.zh.raback.service.CustomerService;
import com.zh.raback.service.dto.CustomerDTO;
import com.zh.raback.service.mapper.CustomerMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link CustomerResource} REST controller.
 */
@SpringBootTest(classes = RabackApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class CustomerResourceIT {

    private static final String DEFAULT_FIRST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FIRST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_LAST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_LAST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_ZIPCODE = "AAAAAAAAAA";
    private static final String UPDATED_ZIPCODE = "BBBBBBBBBB";

    private static final String DEFAULT_CITY = "AAAAAAAAAA";
    private static final String UPDATED_CITY = "BBBBBBBBBB";

    private static final String DEFAULT_AVATAR = "AAAAAAAAAA";
    private static final String UPDATED_AVATAR = "BBBBBBBBBB";

    private static final Instant DEFAULT_BIRTHDAY = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_BIRTHDAY = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_FIRST_SEEN = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_FIRST_SEEN = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_LAST_SEEN = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_LAST_SEEN = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_HAS_ORDERED = false;
    private static final Boolean UPDATED_HAS_ORDERED = true;

    private static final Instant DEFAULT_LATEST_PURCHASE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_LATEST_PURCHASE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_HAS_NEWSLETTER = false;
    private static final Boolean UPDATED_HAS_NEWSLETTER = true;

    private static final String DEFAULT_GROUPS = "AAAAAAAAAA";
    private static final String UPDATED_GROUPS = "BBBBBBBBBB";

    private static final Integer DEFAULT_NB_COMMANDS = 1;
    private static final Integer UPDATED_NB_COMMANDS = 2;

    private static final Integer DEFAULT_TOTAL_SPEND = 1;
    private static final Integer UPDATED_TOTAL_SPEND = 2;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCustomerMockMvc;

    private Customer customer;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Customer createEntity(EntityManager em) {
        Customer customer = new Customer()
            .firstName(DEFAULT_FIRST_NAME)
            .lastName(DEFAULT_LAST_NAME)
            .email(DEFAULT_EMAIL)
            .address(DEFAULT_ADDRESS)
            .zipcode(DEFAULT_ZIPCODE)
            .city(DEFAULT_CITY)
            .avatar(DEFAULT_AVATAR)
            .birthday(DEFAULT_BIRTHDAY)
            .firstSeen(DEFAULT_FIRST_SEEN)
            .lastSeen(DEFAULT_LAST_SEEN)
            .hasOrdered(DEFAULT_HAS_ORDERED)
            .latestPurchase(DEFAULT_LATEST_PURCHASE)
            .hasNewsletter(DEFAULT_HAS_NEWSLETTER)
            .groups(DEFAULT_GROUPS)
            .nbCommands(DEFAULT_NB_COMMANDS)
            .totalSpend(DEFAULT_TOTAL_SPEND);
        return customer;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Customer createUpdatedEntity(EntityManager em) {
        Customer customer = new Customer()
            .firstName(UPDATED_FIRST_NAME)
            .lastName(UPDATED_LAST_NAME)
            .email(UPDATED_EMAIL)
            .address(UPDATED_ADDRESS)
            .zipcode(UPDATED_ZIPCODE)
            .city(UPDATED_CITY)
            .avatar(UPDATED_AVATAR)
            .birthday(UPDATED_BIRTHDAY)
            .firstSeen(UPDATED_FIRST_SEEN)
            .lastSeen(UPDATED_LAST_SEEN)
            .hasOrdered(UPDATED_HAS_ORDERED)
            .latestPurchase(UPDATED_LATEST_PURCHASE)
            .hasNewsletter(UPDATED_HAS_NEWSLETTER)
            .groups(UPDATED_GROUPS)
            .nbCommands(UPDATED_NB_COMMANDS)
            .totalSpend(UPDATED_TOTAL_SPEND);
        return customer;
    }

    @BeforeEach
    public void initTest() {
        customer = createEntity(em);
    }

    @Test
    @Transactional
    public void createCustomer() throws Exception {
        int databaseSizeBeforeCreate = customerRepository.findAll().size();

        // Create the Customer
        CustomerDTO customerDTO = customerMapper.toDto(customer);
        restCustomerMockMvc.perform(post("/api/customers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(customerDTO)))
            .andExpect(status().isCreated());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeCreate + 1);
        Customer testCustomer = customerList.get(customerList.size() - 1);
        assertThat(testCustomer.getFirstName()).isEqualTo(DEFAULT_FIRST_NAME);
        assertThat(testCustomer.getLastName()).isEqualTo(DEFAULT_LAST_NAME);
        assertThat(testCustomer.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testCustomer.getAddress()).isEqualTo(DEFAULT_ADDRESS);
        assertThat(testCustomer.getZipcode()).isEqualTo(DEFAULT_ZIPCODE);
        assertThat(testCustomer.getCity()).isEqualTo(DEFAULT_CITY);
        assertThat(testCustomer.getAvatar()).isEqualTo(DEFAULT_AVATAR);
        assertThat(testCustomer.getBirthday()).isEqualTo(DEFAULT_BIRTHDAY);
        assertThat(testCustomer.getFirstSeen()).isEqualTo(DEFAULT_FIRST_SEEN);
        assertThat(testCustomer.getLastSeen()).isEqualTo(DEFAULT_LAST_SEEN);
        assertThat(testCustomer.isHasOrdered()).isEqualTo(DEFAULT_HAS_ORDERED);
        assertThat(testCustomer.getLatestPurchase()).isEqualTo(DEFAULT_LATEST_PURCHASE);
        assertThat(testCustomer.isHasNewsletter()).isEqualTo(DEFAULT_HAS_NEWSLETTER);
        assertThat(testCustomer.getGroups()).isEqualTo(DEFAULT_GROUPS);
        assertThat(testCustomer.getNbCommands()).isEqualTo(DEFAULT_NB_COMMANDS);
        assertThat(testCustomer.getTotalSpend()).isEqualTo(DEFAULT_TOTAL_SPEND);
    }

    @Test
    @Transactional
    public void createCustomerWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = customerRepository.findAll().size();

        // Create the Customer with an existing ID
        customer.setId(1L);
        CustomerDTO customerDTO = customerMapper.toDto(customer);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCustomerMockMvc.perform(post("/api/customers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(customerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllCustomers() throws Exception {
        // Initialize the database
        customerRepository.saveAndFlush(customer);

        // Get all the customerList
        restCustomerMockMvc.perform(get("/api/customers?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(customer.getId().intValue())))
            .andExpect(jsonPath("$.[*].firstName").value(hasItem(DEFAULT_FIRST_NAME)))
            .andExpect(jsonPath("$.[*].lastName").value(hasItem(DEFAULT_LAST_NAME)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].address").value(hasItem(DEFAULT_ADDRESS)))
            .andExpect(jsonPath("$.[*].zipcode").value(hasItem(DEFAULT_ZIPCODE)))
            .andExpect(jsonPath("$.[*].city").value(hasItem(DEFAULT_CITY)))
            .andExpect(jsonPath("$.[*].avatar").value(hasItem(DEFAULT_AVATAR)))
            .andExpect(jsonPath("$.[*].birthday").value(hasItem(DEFAULT_BIRTHDAY.toString())))
            .andExpect(jsonPath("$.[*].firstSeen").value(hasItem(DEFAULT_FIRST_SEEN.toString())))
            .andExpect(jsonPath("$.[*].lastSeen").value(hasItem(DEFAULT_LAST_SEEN.toString())))
            .andExpect(jsonPath("$.[*].hasOrdered").value(hasItem(DEFAULT_HAS_ORDERED.booleanValue())))
            .andExpect(jsonPath("$.[*].latestPurchase").value(hasItem(DEFAULT_LATEST_PURCHASE.toString())))
            .andExpect(jsonPath("$.[*].hasNewsletter").value(hasItem(DEFAULT_HAS_NEWSLETTER.booleanValue())))
            .andExpect(jsonPath("$.[*].groups").value(hasItem(DEFAULT_GROUPS)))
            .andExpect(jsonPath("$.[*].nbCommands").value(hasItem(DEFAULT_NB_COMMANDS)))
            .andExpect(jsonPath("$.[*].totalSpend").value(hasItem(DEFAULT_TOTAL_SPEND)));
    }
    
    @Test
    @Transactional
    public void getCustomer() throws Exception {
        // Initialize the database
        customerRepository.saveAndFlush(customer);

        // Get the customer
        restCustomerMockMvc.perform(get("/api/customers/{id}", customer.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(customer.getId().intValue()))
            .andExpect(jsonPath("$.firstName").value(DEFAULT_FIRST_NAME))
            .andExpect(jsonPath("$.lastName").value(DEFAULT_LAST_NAME))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.address").value(DEFAULT_ADDRESS))
            .andExpect(jsonPath("$.zipcode").value(DEFAULT_ZIPCODE))
            .andExpect(jsonPath("$.city").value(DEFAULT_CITY))
            .andExpect(jsonPath("$.avatar").value(DEFAULT_AVATAR))
            .andExpect(jsonPath("$.birthday").value(DEFAULT_BIRTHDAY.toString()))
            .andExpect(jsonPath("$.firstSeen").value(DEFAULT_FIRST_SEEN.toString()))
            .andExpect(jsonPath("$.lastSeen").value(DEFAULT_LAST_SEEN.toString()))
            .andExpect(jsonPath("$.hasOrdered").value(DEFAULT_HAS_ORDERED.booleanValue()))
            .andExpect(jsonPath("$.latestPurchase").value(DEFAULT_LATEST_PURCHASE.toString()))
            .andExpect(jsonPath("$.hasNewsletter").value(DEFAULT_HAS_NEWSLETTER.booleanValue()))
            .andExpect(jsonPath("$.groups").value(DEFAULT_GROUPS))
            .andExpect(jsonPath("$.nbCommands").value(DEFAULT_NB_COMMANDS))
            .andExpect(jsonPath("$.totalSpend").value(DEFAULT_TOTAL_SPEND));
    }

    @Test
    @Transactional
    public void getNonExistingCustomer() throws Exception {
        // Get the customer
        restCustomerMockMvc.perform(get("/api/customers/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCustomer() throws Exception {
        // Initialize the database
        customerRepository.saveAndFlush(customer);

        int databaseSizeBeforeUpdate = customerRepository.findAll().size();

        // Update the customer
        Customer updatedCustomer = customerRepository.findById(customer.getId()).get();
        // Disconnect from session so that the updates on updatedCustomer are not directly saved in db
        em.detach(updatedCustomer);
        updatedCustomer
            .firstName(UPDATED_FIRST_NAME)
            .lastName(UPDATED_LAST_NAME)
            .email(UPDATED_EMAIL)
            .address(UPDATED_ADDRESS)
            .zipcode(UPDATED_ZIPCODE)
            .city(UPDATED_CITY)
            .avatar(UPDATED_AVATAR)
            .birthday(UPDATED_BIRTHDAY)
            .firstSeen(UPDATED_FIRST_SEEN)
            .lastSeen(UPDATED_LAST_SEEN)
            .hasOrdered(UPDATED_HAS_ORDERED)
            .latestPurchase(UPDATED_LATEST_PURCHASE)
            .hasNewsletter(UPDATED_HAS_NEWSLETTER)
            .groups(UPDATED_GROUPS)
            .nbCommands(UPDATED_NB_COMMANDS)
            .totalSpend(UPDATED_TOTAL_SPEND);
        CustomerDTO customerDTO = customerMapper.toDto(updatedCustomer);

        restCustomerMockMvc.perform(put("/api/customers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(customerDTO)))
            .andExpect(status().isOk());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
        Customer testCustomer = customerList.get(customerList.size() - 1);
        assertThat(testCustomer.getFirstName()).isEqualTo(UPDATED_FIRST_NAME);
        assertThat(testCustomer.getLastName()).isEqualTo(UPDATED_LAST_NAME);
        assertThat(testCustomer.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testCustomer.getAddress()).isEqualTo(UPDATED_ADDRESS);
        assertThat(testCustomer.getZipcode()).isEqualTo(UPDATED_ZIPCODE);
        assertThat(testCustomer.getCity()).isEqualTo(UPDATED_CITY);
        assertThat(testCustomer.getAvatar()).isEqualTo(UPDATED_AVATAR);
        assertThat(testCustomer.getBirthday()).isEqualTo(UPDATED_BIRTHDAY);
        assertThat(testCustomer.getFirstSeen()).isEqualTo(UPDATED_FIRST_SEEN);
        assertThat(testCustomer.getLastSeen()).isEqualTo(UPDATED_LAST_SEEN);
        assertThat(testCustomer.isHasOrdered()).isEqualTo(UPDATED_HAS_ORDERED);
        assertThat(testCustomer.getLatestPurchase()).isEqualTo(UPDATED_LATEST_PURCHASE);
        assertThat(testCustomer.isHasNewsletter()).isEqualTo(UPDATED_HAS_NEWSLETTER);
        assertThat(testCustomer.getGroups()).isEqualTo(UPDATED_GROUPS);
        assertThat(testCustomer.getNbCommands()).isEqualTo(UPDATED_NB_COMMANDS);
        assertThat(testCustomer.getTotalSpend()).isEqualTo(UPDATED_TOTAL_SPEND);
    }

    @Test
    @Transactional
    public void updateNonExistingCustomer() throws Exception {
        int databaseSizeBeforeUpdate = customerRepository.findAll().size();

        // Create the Customer
        CustomerDTO customerDTO = customerMapper.toDto(customer);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCustomerMockMvc.perform(put("/api/customers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(customerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Customer in the database
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCustomer() throws Exception {
        // Initialize the database
        customerRepository.saveAndFlush(customer);

        int databaseSizeBeforeDelete = customerRepository.findAll().size();

        // Delete the customer
        restCustomerMockMvc.perform(delete("/api/customers/{id}", customer.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Customer> customerList = customerRepository.findAll();
        assertThat(customerList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
