package com.zh.raback.web.rest;

import com.zh.raback.RabackApp;
import com.zh.raback.domain.Museum;
import com.zh.raback.repository.MuseumRepository;
import com.zh.raback.service.MuseumService;
import com.zh.raback.service.dto.MuseumDTO;
import com.zh.raback.service.mapper.MuseumMapper;

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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link MuseumResource} REST controller.
 */
@SpringBootTest(classes = RabackApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class MuseumResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_RS_NAME = "AAAAAAAAAA";
    private static final String UPDATED_RS_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EN_NAME = "AAAAAAAAAA";
    private static final String UPDATED_EN_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_FULL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FULL_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_RS_FULL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_RS_FULL_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EN_FULL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_EN_FULL_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_RS_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_RS_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_EN_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_EN_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_BRIEF = "AAAAAAAAAA";
    private static final String UPDATED_BRIEF = "BBBBBBBBBB";

    private static final String DEFAULT_EN_BRIEF = "AAAAAAAAAA";
    private static final String UPDATED_EN_BRIEF = "BBBBBBBBBB";

    private static final String DEFAULT_RS_BRIEF = "AAAAAAAAAA";
    private static final String UPDATED_RS_BRIEF = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_NUM = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_NUM = "BBBBBBBBBB";

    private static final String DEFAULT_CONTACT_PERSON = "AAAAAAAAAA";
    private static final String UPDATED_CONTACT_PERSON = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_CREATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CREATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_UPDATE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UPDATE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_MAIN_IMG = "AAAAAAAAAA";
    private static final String UPDATED_MAIN_IMG = "BBBBBBBBBB";

    @Autowired
    private MuseumRepository museumRepository;

    @Autowired
    private MuseumMapper museumMapper;

    @Autowired
    private MuseumService museumService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restMuseumMockMvc;

    private Museum museum;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Museum createEntity(EntityManager em) {
        Museum museum = new Museum()
            .name(DEFAULT_NAME)
            .rsName(DEFAULT_RS_NAME)
            .enName(DEFAULT_EN_NAME)
            .fullName(DEFAULT_FULL_NAME)
            .rsFullName(DEFAULT_RS_FULL_NAME)
            .enFullName(DEFAULT_EN_FULL_NAME)
            .address(DEFAULT_ADDRESS)
            .rsAddress(DEFAULT_RS_ADDRESS)
            .enAddress(DEFAULT_EN_ADDRESS)
            .brief(DEFAULT_BRIEF)
            .enBrief(DEFAULT_EN_BRIEF)
            .rsBrief(DEFAULT_RS_BRIEF)
            .phoneNum(DEFAULT_PHONE_NUM)
            .contactPerson(DEFAULT_CONTACT_PERSON)
            .createDate(DEFAULT_CREATE_DATE)
            .updateDate(DEFAULT_UPDATE_DATE)
            .mainImg(DEFAULT_MAIN_IMG);
        return museum;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Museum createUpdatedEntity(EntityManager em) {
        Museum museum = new Museum()
            .name(UPDATED_NAME)
            .rsName(UPDATED_RS_NAME)
            .enName(UPDATED_EN_NAME)
            .fullName(UPDATED_FULL_NAME)
            .rsFullName(UPDATED_RS_FULL_NAME)
            .enFullName(UPDATED_EN_FULL_NAME)
            .address(UPDATED_ADDRESS)
            .rsAddress(UPDATED_RS_ADDRESS)
            .enAddress(UPDATED_EN_ADDRESS)
            .brief(UPDATED_BRIEF)
            .enBrief(UPDATED_EN_BRIEF)
            .rsBrief(UPDATED_RS_BRIEF)
            .phoneNum(UPDATED_PHONE_NUM)
            .contactPerson(UPDATED_CONTACT_PERSON)
            .createDate(UPDATED_CREATE_DATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .mainImg(UPDATED_MAIN_IMG);
        return museum;
    }

    @BeforeEach
    public void initTest() {
        museum = createEntity(em);
    }

    @Test
    @Transactional
    public void createMuseum() throws Exception {
        int databaseSizeBeforeCreate = museumRepository.findAll().size();

        // Create the Museum
        MuseumDTO museumDTO = museumMapper.toDto(museum);
        restMuseumMockMvc.perform(post("/api/museums")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(museumDTO)))
            .andExpect(status().isCreated());

        // Validate the Museum in the database
        List<Museum> museumList = museumRepository.findAll();
        assertThat(museumList).hasSize(databaseSizeBeforeCreate + 1);
        Museum testMuseum = museumList.get(museumList.size() - 1);
        assertThat(testMuseum.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testMuseum.getRsName()).isEqualTo(DEFAULT_RS_NAME);
        assertThat(testMuseum.getEnName()).isEqualTo(DEFAULT_EN_NAME);
        assertThat(testMuseum.getFullName()).isEqualTo(DEFAULT_FULL_NAME);
        assertThat(testMuseum.getRsFullName()).isEqualTo(DEFAULT_RS_FULL_NAME);
        assertThat(testMuseum.getEnFullName()).isEqualTo(DEFAULT_EN_FULL_NAME);
        assertThat(testMuseum.getAddress()).isEqualTo(DEFAULT_ADDRESS);
        assertThat(testMuseum.getRsAddress()).isEqualTo(DEFAULT_RS_ADDRESS);
        assertThat(testMuseum.getEnAddress()).isEqualTo(DEFAULT_EN_ADDRESS);
        assertThat(testMuseum.getBrief()).isEqualTo(DEFAULT_BRIEF);
        assertThat(testMuseum.getEnBrief()).isEqualTo(DEFAULT_EN_BRIEF);
        assertThat(testMuseum.getRsBrief()).isEqualTo(DEFAULT_RS_BRIEF);
        assertThat(testMuseum.getPhoneNum()).isEqualTo(DEFAULT_PHONE_NUM);
        assertThat(testMuseum.getContactPerson()).isEqualTo(DEFAULT_CONTACT_PERSON);
        assertThat(testMuseum.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testMuseum.getUpdateDate()).isEqualTo(DEFAULT_UPDATE_DATE);
        assertThat(testMuseum.getMainImg()).isEqualTo(DEFAULT_MAIN_IMG);
    }

    @Test
    @Transactional
    public void createMuseumWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = museumRepository.findAll().size();

        // Create the Museum with an existing ID
        museum.setId(1L);
        MuseumDTO museumDTO = museumMapper.toDto(museum);

        // An entity with an existing ID cannot be created, so this API call must fail
        restMuseumMockMvc.perform(post("/api/museums")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(museumDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Museum in the database
        List<Museum> museumList = museumRepository.findAll();
        assertThat(museumList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = museumRepository.findAll().size();
        // set the field null
        museum.setName(null);

        // Create the Museum, which fails.
        MuseumDTO museumDTO = museumMapper.toDto(museum);

        restMuseumMockMvc.perform(post("/api/museums")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(museumDTO)))
            .andExpect(status().isBadRequest());

        List<Museum> museumList = museumRepository.findAll();
        assertThat(museumList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllMuseums() throws Exception {
        // Initialize the database
        museumRepository.saveAndFlush(museum);

        // Get all the museumList
        restMuseumMockMvc.perform(get("/api/museums?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(museum.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].rsName").value(hasItem(DEFAULT_RS_NAME)))
            .andExpect(jsonPath("$.[*].enName").value(hasItem(DEFAULT_EN_NAME)))
            .andExpect(jsonPath("$.[*].fullName").value(hasItem(DEFAULT_FULL_NAME)))
            .andExpect(jsonPath("$.[*].rsFullName").value(hasItem(DEFAULT_RS_FULL_NAME)))
            .andExpect(jsonPath("$.[*].enFullName").value(hasItem(DEFAULT_EN_FULL_NAME)))
            .andExpect(jsonPath("$.[*].address").value(hasItem(DEFAULT_ADDRESS)))
            .andExpect(jsonPath("$.[*].rsAddress").value(hasItem(DEFAULT_RS_ADDRESS)))
            .andExpect(jsonPath("$.[*].enAddress").value(hasItem(DEFAULT_EN_ADDRESS)))
            .andExpect(jsonPath("$.[*].brief").value(hasItem(DEFAULT_BRIEF)))
            .andExpect(jsonPath("$.[*].enBrief").value(hasItem(DEFAULT_EN_BRIEF)))
            .andExpect(jsonPath("$.[*].rsBrief").value(hasItem(DEFAULT_RS_BRIEF)))
            .andExpect(jsonPath("$.[*].phoneNum").value(hasItem(DEFAULT_PHONE_NUM)))
            .andExpect(jsonPath("$.[*].contactPerson").value(hasItem(DEFAULT_CONTACT_PERSON)))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].mainImg").value(hasItem(DEFAULT_MAIN_IMG)));
    }
    
    @Test
    @Transactional
    public void getMuseum() throws Exception {
        // Initialize the database
        museumRepository.saveAndFlush(museum);

        // Get the museum
        restMuseumMockMvc.perform(get("/api/museums/{id}", museum.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(museum.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.rsName").value(DEFAULT_RS_NAME))
            .andExpect(jsonPath("$.enName").value(DEFAULT_EN_NAME))
            .andExpect(jsonPath("$.fullName").value(DEFAULT_FULL_NAME))
            .andExpect(jsonPath("$.rsFullName").value(DEFAULT_RS_FULL_NAME))
            .andExpect(jsonPath("$.enFullName").value(DEFAULT_EN_FULL_NAME))
            .andExpect(jsonPath("$.address").value(DEFAULT_ADDRESS))
            .andExpect(jsonPath("$.rsAddress").value(DEFAULT_RS_ADDRESS))
            .andExpect(jsonPath("$.enAddress").value(DEFAULT_EN_ADDRESS))
            .andExpect(jsonPath("$.brief").value(DEFAULT_BRIEF))
            .andExpect(jsonPath("$.enBrief").value(DEFAULT_EN_BRIEF))
            .andExpect(jsonPath("$.rsBrief").value(DEFAULT_RS_BRIEF))
            .andExpect(jsonPath("$.phoneNum").value(DEFAULT_PHONE_NUM))
            .andExpect(jsonPath("$.contactPerson").value(DEFAULT_CONTACT_PERSON))
            .andExpect(jsonPath("$.createDate").value(DEFAULT_CREATE_DATE.toString()))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.toString()))
            .andExpect(jsonPath("$.mainImg").value(DEFAULT_MAIN_IMG));
    }

    @Test
    @Transactional
    public void getNonExistingMuseum() throws Exception {
        // Get the museum
        restMuseumMockMvc.perform(get("/api/museums/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateMuseum() throws Exception {
        // Initialize the database
        museumRepository.saveAndFlush(museum);

        int databaseSizeBeforeUpdate = museumRepository.findAll().size();

        // Update the museum
        Museum updatedMuseum = museumRepository.findById(museum.getId()).get();
        // Disconnect from session so that the updates on updatedMuseum are not directly saved in db
        em.detach(updatedMuseum);
        updatedMuseum
            .name(UPDATED_NAME)
            .rsName(UPDATED_RS_NAME)
            .enName(UPDATED_EN_NAME)
            .fullName(UPDATED_FULL_NAME)
            .rsFullName(UPDATED_RS_FULL_NAME)
            .enFullName(UPDATED_EN_FULL_NAME)
            .address(UPDATED_ADDRESS)
            .rsAddress(UPDATED_RS_ADDRESS)
            .enAddress(UPDATED_EN_ADDRESS)
            .brief(UPDATED_BRIEF)
            .enBrief(UPDATED_EN_BRIEF)
            .rsBrief(UPDATED_RS_BRIEF)
            .phoneNum(UPDATED_PHONE_NUM)
            .contactPerson(UPDATED_CONTACT_PERSON)
            .createDate(UPDATED_CREATE_DATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .mainImg(UPDATED_MAIN_IMG);
        MuseumDTO museumDTO = museumMapper.toDto(updatedMuseum);

        restMuseumMockMvc.perform(put("/api/museums")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(museumDTO)))
            .andExpect(status().isOk());

        // Validate the Museum in the database
        List<Museum> museumList = museumRepository.findAll();
        assertThat(museumList).hasSize(databaseSizeBeforeUpdate);
        Museum testMuseum = museumList.get(museumList.size() - 1);
        assertThat(testMuseum.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testMuseum.getRsName()).isEqualTo(UPDATED_RS_NAME);
        assertThat(testMuseum.getEnName()).isEqualTo(UPDATED_EN_NAME);
        assertThat(testMuseum.getFullName()).isEqualTo(UPDATED_FULL_NAME);
        assertThat(testMuseum.getRsFullName()).isEqualTo(UPDATED_RS_FULL_NAME);
        assertThat(testMuseum.getEnFullName()).isEqualTo(UPDATED_EN_FULL_NAME);
        assertThat(testMuseum.getAddress()).isEqualTo(UPDATED_ADDRESS);
        assertThat(testMuseum.getRsAddress()).isEqualTo(UPDATED_RS_ADDRESS);
        assertThat(testMuseum.getEnAddress()).isEqualTo(UPDATED_EN_ADDRESS);
        assertThat(testMuseum.getBrief()).isEqualTo(UPDATED_BRIEF);
        assertThat(testMuseum.getEnBrief()).isEqualTo(UPDATED_EN_BRIEF);
        assertThat(testMuseum.getRsBrief()).isEqualTo(UPDATED_RS_BRIEF);
        assertThat(testMuseum.getPhoneNum()).isEqualTo(UPDATED_PHONE_NUM);
        assertThat(testMuseum.getContactPerson()).isEqualTo(UPDATED_CONTACT_PERSON);
        assertThat(testMuseum.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testMuseum.getUpdateDate()).isEqualTo(UPDATED_UPDATE_DATE);
        assertThat(testMuseum.getMainImg()).isEqualTo(UPDATED_MAIN_IMG);
    }

    @Test
    @Transactional
    public void updateNonExistingMuseum() throws Exception {
        int databaseSizeBeforeUpdate = museumRepository.findAll().size();

        // Create the Museum
        MuseumDTO museumDTO = museumMapper.toDto(museum);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restMuseumMockMvc.perform(put("/api/museums")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(museumDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Museum in the database
        List<Museum> museumList = museumRepository.findAll();
        assertThat(museumList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteMuseum() throws Exception {
        // Initialize the database
        museumRepository.saveAndFlush(museum);

        int databaseSizeBeforeDelete = museumRepository.findAll().size();

        // Delete the museum
        restMuseumMockMvc.perform(delete("/api/museums/{id}", museum.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Museum> museumList = museumRepository.findAll();
        assertThat(museumList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
