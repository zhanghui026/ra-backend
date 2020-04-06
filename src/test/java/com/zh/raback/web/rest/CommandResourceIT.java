package com.zh.raback.web.rest;

import com.zh.raback.RabackApp;
import com.zh.raback.domain.Command;
import com.zh.raback.repository.CommandRepository;
import com.zh.raback.service.CommandService;
import com.zh.raback.service.dto.CommandDTO;
import com.zh.raback.service.mapper.CommandMapper;

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
 * Integration tests for the {@link CommandResource} REST controller.
 */
@SpringBootTest(classes = RabackApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class CommandResourceIT {

    private static final String DEFAULT_REFERENCE = "AAAAAAAAAA";
    private static final String UPDATED_REFERENCE = "BBBBBBBBBB";

    private static final Instant DEFAULT_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CUSTOMER_ID = 1L;
    private static final Long UPDATED_CUSTOMER_ID = 2L;

    private static final String DEFAULT_BASKET = "AAAAAAAAAA";
    private static final String UPDATED_BASKET = "BBBBBBBBBB";

    private static final Float DEFAULT_TOTAL_EX_TAXES = 1F;
    private static final Float UPDATED_TOTAL_EX_TAXES = 2F;

    private static final Float DEFAULT_DELIVERY_FEES = 1F;
    private static final Float UPDATED_DELIVERY_FEES = 2F;

    private static final Float DEFAULT_TAX_RATE = 1F;
    private static final Float UPDATED_TAX_RATE = 2F;

    private static final Float DEFAULT_TAXES = 1F;
    private static final Float UPDATED_TAXES = 2F;

    private static final Float DEFAULT_TOTAL = 1F;
    private static final Float UPDATED_TOTAL = 2F;

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final Boolean DEFAULT_RETURNED = false;
    private static final Boolean UPDATED_RETURNED = true;

    @Autowired
    private CommandRepository commandRepository;

    @Autowired
    private CommandMapper commandMapper;

    @Autowired
    private CommandService commandService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCommandMockMvc;

    private Command command;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Command createEntity(EntityManager em) {
        Command command = new Command()
            .reference(DEFAULT_REFERENCE)
            .date(DEFAULT_DATE)
            .customerId(DEFAULT_CUSTOMER_ID)
            .basket(DEFAULT_BASKET)
            .totalExTaxes(DEFAULT_TOTAL_EX_TAXES)
            .deliveryFees(DEFAULT_DELIVERY_FEES)
            .taxRate(DEFAULT_TAX_RATE)
            .taxes(DEFAULT_TAXES)
            .total(DEFAULT_TOTAL)
            .status(DEFAULT_STATUS)
            .returned(DEFAULT_RETURNED);
        return command;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Command createUpdatedEntity(EntityManager em) {
        Command command = new Command()
            .reference(UPDATED_REFERENCE)
            .date(UPDATED_DATE)
            .customerId(UPDATED_CUSTOMER_ID)
            .basket(UPDATED_BASKET)
            .totalExTaxes(UPDATED_TOTAL_EX_TAXES)
            .deliveryFees(UPDATED_DELIVERY_FEES)
            .taxRate(UPDATED_TAX_RATE)
            .taxes(UPDATED_TAXES)
            .total(UPDATED_TOTAL)
            .status(UPDATED_STATUS)
            .returned(UPDATED_RETURNED);
        return command;
    }

    @BeforeEach
    public void initTest() {
        command = createEntity(em);
    }

    @Test
    @Transactional
    public void createCommand() throws Exception {
        int databaseSizeBeforeCreate = commandRepository.findAll().size();

        // Create the Command
        CommandDTO commandDTO = commandMapper.toDto(command);
        restCommandMockMvc.perform(post("/api/commands")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(commandDTO)))
            .andExpect(status().isCreated());

        // Validate the Command in the database
        List<Command> commandList = commandRepository.findAll();
        assertThat(commandList).hasSize(databaseSizeBeforeCreate + 1);
        Command testCommand = commandList.get(commandList.size() - 1);
        assertThat(testCommand.getReference()).isEqualTo(DEFAULT_REFERENCE);
        assertThat(testCommand.getDate()).isEqualTo(DEFAULT_DATE);
        assertThat(testCommand.getCustomerId()).isEqualTo(DEFAULT_CUSTOMER_ID);
        assertThat(testCommand.getBasket()).isEqualTo(DEFAULT_BASKET);
        assertThat(testCommand.getTotalExTaxes()).isEqualTo(DEFAULT_TOTAL_EX_TAXES);
        assertThat(testCommand.getDeliveryFees()).isEqualTo(DEFAULT_DELIVERY_FEES);
        assertThat(testCommand.getTaxRate()).isEqualTo(DEFAULT_TAX_RATE);
        assertThat(testCommand.getTaxes()).isEqualTo(DEFAULT_TAXES);
        assertThat(testCommand.getTotal()).isEqualTo(DEFAULT_TOTAL);
        assertThat(testCommand.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testCommand.isReturned()).isEqualTo(DEFAULT_RETURNED);
    }

    @Test
    @Transactional
    public void createCommandWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = commandRepository.findAll().size();

        // Create the Command with an existing ID
        command.setId(1L);
        CommandDTO commandDTO = commandMapper.toDto(command);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCommandMockMvc.perform(post("/api/commands")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(commandDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Command in the database
        List<Command> commandList = commandRepository.findAll();
        assertThat(commandList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllCommands() throws Exception {
        // Initialize the database
        commandRepository.saveAndFlush(command);

        // Get all the commandList
        restCommandMockMvc.perform(get("/api/commands?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(command.getId().intValue())))
            .andExpect(jsonPath("$.[*].reference").value(hasItem(DEFAULT_REFERENCE)))
            .andExpect(jsonPath("$.[*].date").value(hasItem(DEFAULT_DATE.toString())))
            .andExpect(jsonPath("$.[*].customerId").value(hasItem(DEFAULT_CUSTOMER_ID.intValue())))
            .andExpect(jsonPath("$.[*].basket").value(hasItem(DEFAULT_BASKET)))
            .andExpect(jsonPath("$.[*].totalExTaxes").value(hasItem(DEFAULT_TOTAL_EX_TAXES.doubleValue())))
            .andExpect(jsonPath("$.[*].deliveryFees").value(hasItem(DEFAULT_DELIVERY_FEES.doubleValue())))
            .andExpect(jsonPath("$.[*].taxRate").value(hasItem(DEFAULT_TAX_RATE.doubleValue())))
            .andExpect(jsonPath("$.[*].taxes").value(hasItem(DEFAULT_TAXES.doubleValue())))
            .andExpect(jsonPath("$.[*].total").value(hasItem(DEFAULT_TOTAL.doubleValue())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].returned").value(hasItem(DEFAULT_RETURNED.booleanValue())));
    }
    
    @Test
    @Transactional
    public void getCommand() throws Exception {
        // Initialize the database
        commandRepository.saveAndFlush(command);

        // Get the command
        restCommandMockMvc.perform(get("/api/commands/{id}", command.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(command.getId().intValue()))
            .andExpect(jsonPath("$.reference").value(DEFAULT_REFERENCE))
            .andExpect(jsonPath("$.date").value(DEFAULT_DATE.toString()))
            .andExpect(jsonPath("$.customerId").value(DEFAULT_CUSTOMER_ID.intValue()))
            .andExpect(jsonPath("$.basket").value(DEFAULT_BASKET))
            .andExpect(jsonPath("$.totalExTaxes").value(DEFAULT_TOTAL_EX_TAXES.doubleValue()))
            .andExpect(jsonPath("$.deliveryFees").value(DEFAULT_DELIVERY_FEES.doubleValue()))
            .andExpect(jsonPath("$.taxRate").value(DEFAULT_TAX_RATE.doubleValue()))
            .andExpect(jsonPath("$.taxes").value(DEFAULT_TAXES.doubleValue()))
            .andExpect(jsonPath("$.total").value(DEFAULT_TOTAL.doubleValue()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.returned").value(DEFAULT_RETURNED.booleanValue()));
    }

    @Test
    @Transactional
    public void getNonExistingCommand() throws Exception {
        // Get the command
        restCommandMockMvc.perform(get("/api/commands/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCommand() throws Exception {
        // Initialize the database
        commandRepository.saveAndFlush(command);

        int databaseSizeBeforeUpdate = commandRepository.findAll().size();

        // Update the command
        Command updatedCommand = commandRepository.findById(command.getId()).get();
        // Disconnect from session so that the updates on updatedCommand are not directly saved in db
        em.detach(updatedCommand);
        updatedCommand
            .reference(UPDATED_REFERENCE)
            .date(UPDATED_DATE)
            .customerId(UPDATED_CUSTOMER_ID)
            .basket(UPDATED_BASKET)
            .totalExTaxes(UPDATED_TOTAL_EX_TAXES)
            .deliveryFees(UPDATED_DELIVERY_FEES)
            .taxRate(UPDATED_TAX_RATE)
            .taxes(UPDATED_TAXES)
            .total(UPDATED_TOTAL)
            .status(UPDATED_STATUS)
            .returned(UPDATED_RETURNED);
        CommandDTO commandDTO = commandMapper.toDto(updatedCommand);

        restCommandMockMvc.perform(put("/api/commands")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(commandDTO)))
            .andExpect(status().isOk());

        // Validate the Command in the database
        List<Command> commandList = commandRepository.findAll();
        assertThat(commandList).hasSize(databaseSizeBeforeUpdate);
        Command testCommand = commandList.get(commandList.size() - 1);
        assertThat(testCommand.getReference()).isEqualTo(UPDATED_REFERENCE);
        assertThat(testCommand.getDate()).isEqualTo(UPDATED_DATE);
        assertThat(testCommand.getCustomerId()).isEqualTo(UPDATED_CUSTOMER_ID);
        assertThat(testCommand.getBasket()).isEqualTo(UPDATED_BASKET);
        assertThat(testCommand.getTotalExTaxes()).isEqualTo(UPDATED_TOTAL_EX_TAXES);
        assertThat(testCommand.getDeliveryFees()).isEqualTo(UPDATED_DELIVERY_FEES);
        assertThat(testCommand.getTaxRate()).isEqualTo(UPDATED_TAX_RATE);
        assertThat(testCommand.getTaxes()).isEqualTo(UPDATED_TAXES);
        assertThat(testCommand.getTotal()).isEqualTo(UPDATED_TOTAL);
        assertThat(testCommand.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testCommand.isReturned()).isEqualTo(UPDATED_RETURNED);
    }

    @Test
    @Transactional
    public void updateNonExistingCommand() throws Exception {
        int databaseSizeBeforeUpdate = commandRepository.findAll().size();

        // Create the Command
        CommandDTO commandDTO = commandMapper.toDto(command);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCommandMockMvc.perform(put("/api/commands")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(commandDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Command in the database
        List<Command> commandList = commandRepository.findAll();
        assertThat(commandList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCommand() throws Exception {
        // Initialize the database
        commandRepository.saveAndFlush(command);

        int databaseSizeBeforeDelete = commandRepository.findAll().size();

        // Delete the command
        restCommandMockMvc.perform(delete("/api/commands/{id}", command.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Command> commandList = commandRepository.findAll();
        assertThat(commandList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
