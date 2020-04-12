package com.zh.raback.web.rest;

import com.zh.raback.RabackApp;
import com.zh.raback.domain.Painting;
import com.zh.raback.repository.PaintingRepository;
import com.zh.raback.service.PaintingService;
import com.zh.raback.service.dto.PaintingDTO;
import com.zh.raback.service.mapper.PaintingMapper;

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
 * Integration tests for the {@link PaintingResource} REST controller.
 */
@SpringBootTest(classes = RabackApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class PaintingResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_RS_NAME = "AAAAAAAAAA";
    private static final String UPDATED_RS_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EN_NAME = "AAAAAAAAAA";
    private static final String UPDATED_EN_NAME = "BBBBBBBBBB";

    private static final Long DEFAULT_ARTIST_ID = 1L;
    private static final Long UPDATED_ARTIST_ID = 2L;

    private static final Long DEFAULT_MATERIAL_ID = 1L;
    private static final Long UPDATED_MATERIAL_ID = 2L;

    private static final Long DEFAULT_ART_TYPE_ID = 1L;
    private static final Long UPDATED_ART_TYPE_ID = 2L;

    private static final Long DEFAULT_MUSEUM_ID = 1L;
    private static final Long UPDATED_MUSEUM_ID = 2L;

    private static final String DEFAULT_AGE = "AAAAAAAAAA";
    private static final String UPDATED_AGE = "BBBBBBBBBB";

    private static final String DEFAULT_TAGS = "AAAAAAAAAA";
    private static final String UPDATED_TAGS = "BBBBBBBBBB";

    private static final Float DEFAULT_WIDTH = 1F;
    private static final Float UPDATED_WIDTH = 2F;

    private static final Float DEFAULT_HEIGHT = 1F;
    private static final Float UPDATED_HEIGHT = 2F;

    private static final String DEFAULT_RAW_IMG = "AAAAAAAAAA";
    private static final String UPDATED_RAW_IMG = "BBBBBBBBBB";

    private static final String DEFAULT_WEB_IMG = "AAAAAAAAAA";
    private static final String UPDATED_WEB_IMG = "BBBBBBBBBB";

    private static final String DEFAULT_THUMBNAIL_IMG = "AAAAAAAAAA";
    private static final String UPDATED_THUMBNAIL_IMG = "BBBBBBBBBB";

    private static final String DEFAULT_PIN = "AAAAAAAAAA";
    private static final String UPDATED_PIN = "BBBBBBBBBB";

    private static final String DEFAULT_PIN_IMG = "AAAAAAAAAA";
    private static final String UPDATED_PIN_IMG = "BBBBBBBBBB";

    private static final String DEFAULT_REFERENCE = "AAAAAAAAAA";
    private static final String UPDATED_REFERENCE = "BBBBBBBBBB";

    private static final Long DEFAULT_CATEGORY_STATUS_ID = 1L;
    private static final Long UPDATED_CATEGORY_STATUS_ID = 2L;

    private static final String DEFAULT_SENTENCE = "AAAAAAAAAA";
    private static final String UPDATED_SENTENCE = "BBBBBBBBBB";

    private static final String DEFAULT_RS_SENTENCE = "AAAAAAAAAA";
    private static final String UPDATED_RS_SENTENCE = "BBBBBBBBBB";

    private static final String DEFAULT_EN_SENTENCE = "AAAAAAAAAA";
    private static final String UPDATED_EN_SENTENCE = "BBBBBBBBBB";

    private static final String DEFAULT_BRIEF = "AAAAAAAAAA";
    private static final String UPDATED_BRIEF = "BBBBBBBBBB";

    private static final String DEFAULT_RS_BRIEF = "AAAAAAAAAA";
    private static final String UPDATED_RS_BRIEF = "BBBBBBBBBB";

    private static final String DEFAULT_EN_BRIEF = "AAAAAAAAAA";
    private static final String UPDATED_EN_BRIEF = "BBBBBBBBBB";

    private static final String DEFAULT_INFO = "AAAAAAAAAA";
    private static final String UPDATED_INFO = "BBBBBBBBBB";

    private static final String DEFAULT_RS_ART_INFO = "AAAAAAAAAA";
    private static final String UPDATED_RS_ART_INFO = "BBBBBBBBBB";

    private static final String DEFAULT_EN_ART_INFO = "AAAAAAAAAA";
    private static final String UPDATED_EN_ART_INFO = "BBBBBBBBBB";

    private static final Integer DEFAULT_RATING = 1;
    private static final Integer UPDATED_RATING = 2;

    private static final Instant DEFAULT_CREATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATE_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_UPDATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATE_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_USE_ARTIST_INFO = false;
    private static final Boolean UPDATED_USE_ARTIST_INFO = true;

    @Autowired
    private PaintingRepository paintingRepository;

    @Autowired
    private PaintingMapper paintingMapper;

    @Autowired
    private PaintingService paintingService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPaintingMockMvc;

    private Painting painting;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Painting createEntity(EntityManager em) {
        Painting painting = new Painting()
            .name(DEFAULT_NAME)
            .rsName(DEFAULT_RS_NAME)
            .enName(DEFAULT_EN_NAME)
            .artistId(DEFAULT_ARTIST_ID)
            .materialId(DEFAULT_MATERIAL_ID)
            .artTypeId(DEFAULT_ART_TYPE_ID)
            .museumId(DEFAULT_MUSEUM_ID)
            .age(DEFAULT_AGE)
            .tags(DEFAULT_TAGS)
            .width(DEFAULT_WIDTH)
            .height(DEFAULT_HEIGHT)
            .rawImg(DEFAULT_RAW_IMG)
            .webImg(DEFAULT_WEB_IMG)
            .thumbnailImg(DEFAULT_THUMBNAIL_IMG)
            .pin(DEFAULT_PIN)
            .pinImg(DEFAULT_PIN_IMG)
            .reference(DEFAULT_REFERENCE)
            .categoryStatusId(DEFAULT_CATEGORY_STATUS_ID)
            .sentence(DEFAULT_SENTENCE)
            .rsSentence(DEFAULT_RS_SENTENCE)
            .enSentence(DEFAULT_EN_SENTENCE)
            .brief(DEFAULT_BRIEF)
            .rsBrief(DEFAULT_RS_BRIEF)
            .enBrief(DEFAULT_EN_BRIEF)
            .info(DEFAULT_INFO)
            .rsArtInfo(DEFAULT_RS_ART_INFO)
            .enArtInfo(DEFAULT_EN_ART_INFO)
            .rating(DEFAULT_RATING)
            .createDate(DEFAULT_CREATE_DATE)
            .updateDate(DEFAULT_UPDATE_DATE)
            .useArtistInfo(DEFAULT_USE_ARTIST_INFO);
        return painting;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Painting createUpdatedEntity(EntityManager em) {
        Painting painting = new Painting()
            .name(UPDATED_NAME)
            .rsName(UPDATED_RS_NAME)
            .enName(UPDATED_EN_NAME)
            .artistId(UPDATED_ARTIST_ID)
            .materialId(UPDATED_MATERIAL_ID)
            .artTypeId(UPDATED_ART_TYPE_ID)
            .museumId(UPDATED_MUSEUM_ID)
            .age(UPDATED_AGE)
            .tags(UPDATED_TAGS)
            .width(UPDATED_WIDTH)
            .height(UPDATED_HEIGHT)
            .rawImg(UPDATED_RAW_IMG)
            .webImg(UPDATED_WEB_IMG)
            .thumbnailImg(UPDATED_THUMBNAIL_IMG)
            .pin(UPDATED_PIN)
            .pinImg(UPDATED_PIN_IMG)
            .reference(UPDATED_REFERENCE)
            .categoryStatusId(UPDATED_CATEGORY_STATUS_ID)
            .sentence(UPDATED_SENTENCE)
            .rsSentence(UPDATED_RS_SENTENCE)
            .enSentence(UPDATED_EN_SENTENCE)
            .brief(UPDATED_BRIEF)
            .rsBrief(UPDATED_RS_BRIEF)
            .enBrief(UPDATED_EN_BRIEF)
            .info(UPDATED_INFO)
            .rsArtInfo(UPDATED_RS_ART_INFO)
            .enArtInfo(UPDATED_EN_ART_INFO)
            .rating(UPDATED_RATING)
            .createDate(UPDATED_CREATE_DATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .useArtistInfo(UPDATED_USE_ARTIST_INFO);
        return painting;
    }

    @BeforeEach
    public void initTest() {
        painting = createEntity(em);
    }

    @Test
    @Transactional
    public void createPainting() throws Exception {
        int databaseSizeBeforeCreate = paintingRepository.findAll().size();

        // Create the Painting
        PaintingDTO paintingDTO = paintingMapper.toDto(painting);
        restPaintingMockMvc.perform(post("/api/paintings")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(paintingDTO)))
            .andExpect(status().isCreated());

        // Validate the Painting in the database
        List<Painting> paintingList = paintingRepository.findAll();
        assertThat(paintingList).hasSize(databaseSizeBeforeCreate + 1);
        Painting testPainting = paintingList.get(paintingList.size() - 1);
        assertThat(testPainting.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testPainting.getRsName()).isEqualTo(DEFAULT_RS_NAME);
        assertThat(testPainting.getEnName()).isEqualTo(DEFAULT_EN_NAME);
        assertThat(testPainting.getArtistId()).isEqualTo(DEFAULT_ARTIST_ID);
        assertThat(testPainting.getMaterialId()).isEqualTo(DEFAULT_MATERIAL_ID);
        assertThat(testPainting.getArtTypeId()).isEqualTo(DEFAULT_ART_TYPE_ID);
        assertThat(testPainting.getMuseumId()).isEqualTo(DEFAULT_MUSEUM_ID);
        assertThat(testPainting.getAge()).isEqualTo(DEFAULT_AGE);
        assertThat(testPainting.getTags()).isEqualTo(DEFAULT_TAGS);
        assertThat(testPainting.getWidth()).isEqualTo(DEFAULT_WIDTH);
        assertThat(testPainting.getHeight()).isEqualTo(DEFAULT_HEIGHT);
        assertThat(testPainting.getRawImg()).isEqualTo(DEFAULT_RAW_IMG);
        assertThat(testPainting.getWebImg()).isEqualTo(DEFAULT_WEB_IMG);
        assertThat(testPainting.getThumbnailImg()).isEqualTo(DEFAULT_THUMBNAIL_IMG);
        assertThat(testPainting.getPin()).isEqualTo(DEFAULT_PIN);
        assertThat(testPainting.getPinImg()).isEqualTo(DEFAULT_PIN_IMG);
        assertThat(testPainting.getReference()).isEqualTo(DEFAULT_REFERENCE);
        assertThat(testPainting.getCategoryStatusId()).isEqualTo(DEFAULT_CATEGORY_STATUS_ID);
        assertThat(testPainting.getSentence()).isEqualTo(DEFAULT_SENTENCE);
        assertThat(testPainting.getRsSentence()).isEqualTo(DEFAULT_RS_SENTENCE);
        assertThat(testPainting.getEnSentence()).isEqualTo(DEFAULT_EN_SENTENCE);
        assertThat(testPainting.getBrief()).isEqualTo(DEFAULT_BRIEF);
        assertThat(testPainting.getRsBrief()).isEqualTo(DEFAULT_RS_BRIEF);
        assertThat(testPainting.getEnBrief()).isEqualTo(DEFAULT_EN_BRIEF);
        assertThat(testPainting.getInfo()).isEqualTo(DEFAULT_INFO);
        assertThat(testPainting.getRsArtInfo()).isEqualTo(DEFAULT_RS_ART_INFO);
        assertThat(testPainting.getEnArtInfo()).isEqualTo(DEFAULT_EN_ART_INFO);
        assertThat(testPainting.getRating()).isEqualTo(DEFAULT_RATING);
        assertThat(testPainting.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testPainting.getUpdateDate()).isEqualTo(DEFAULT_UPDATE_DATE);
        assertThat(testPainting.isUseArtistInfo()).isEqualTo(DEFAULT_USE_ARTIST_INFO);
    }

    @Test
    @Transactional
    public void createPaintingWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = paintingRepository.findAll().size();

        // Create the Painting with an existing ID
        painting.setId(1L);
        PaintingDTO paintingDTO = paintingMapper.toDto(painting);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPaintingMockMvc.perform(post("/api/paintings")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(paintingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Painting in the database
        List<Painting> paintingList = paintingRepository.findAll();
        assertThat(paintingList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkUseArtistInfoIsRequired() throws Exception {
        int databaseSizeBeforeTest = paintingRepository.findAll().size();
        // set the field null
        painting.setUseArtistInfo(null);

        // Create the Painting, which fails.
        PaintingDTO paintingDTO = paintingMapper.toDto(painting);

        restPaintingMockMvc.perform(post("/api/paintings")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(paintingDTO)))
            .andExpect(status().isBadRequest());

        List<Painting> paintingList = paintingRepository.findAll();
        assertThat(paintingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllPaintings() throws Exception {
        // Initialize the database
        paintingRepository.saveAndFlush(painting);

        // Get all the paintingList
        restPaintingMockMvc.perform(get("/api/paintings?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(painting.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].rsName").value(hasItem(DEFAULT_RS_NAME)))
            .andExpect(jsonPath("$.[*].enName").value(hasItem(DEFAULT_EN_NAME)))
            .andExpect(jsonPath("$.[*].artistId").value(hasItem(DEFAULT_ARTIST_ID.intValue())))
            .andExpect(jsonPath("$.[*].materialId").value(hasItem(DEFAULT_MATERIAL_ID.intValue())))
            .andExpect(jsonPath("$.[*].artTypeId").value(hasItem(DEFAULT_ART_TYPE_ID.intValue())))
            .andExpect(jsonPath("$.[*].museumId").value(hasItem(DEFAULT_MUSEUM_ID.intValue())))
            .andExpect(jsonPath("$.[*].age").value(hasItem(DEFAULT_AGE)))
            .andExpect(jsonPath("$.[*].tags").value(hasItem(DEFAULT_TAGS)))
            .andExpect(jsonPath("$.[*].width").value(hasItem(DEFAULT_WIDTH.doubleValue())))
            .andExpect(jsonPath("$.[*].height").value(hasItem(DEFAULT_HEIGHT.doubleValue())))
            .andExpect(jsonPath("$.[*].rawImg").value(hasItem(DEFAULT_RAW_IMG)))
            .andExpect(jsonPath("$.[*].webImg").value(hasItem(DEFAULT_WEB_IMG)))
            .andExpect(jsonPath("$.[*].thumbnailImg").value(hasItem(DEFAULT_THUMBNAIL_IMG)))
            .andExpect(jsonPath("$.[*].pin").value(hasItem(DEFAULT_PIN)))
            .andExpect(jsonPath("$.[*].pinImg").value(hasItem(DEFAULT_PIN_IMG)))
            .andExpect(jsonPath("$.[*].reference").value(hasItem(DEFAULT_REFERENCE)))
            .andExpect(jsonPath("$.[*].categoryStatusId").value(hasItem(DEFAULT_CATEGORY_STATUS_ID.intValue())))
            .andExpect(jsonPath("$.[*].sentence").value(hasItem(DEFAULT_SENTENCE)))
            .andExpect(jsonPath("$.[*].rsSentence").value(hasItem(DEFAULT_RS_SENTENCE)))
            .andExpect(jsonPath("$.[*].enSentence").value(hasItem(DEFAULT_EN_SENTENCE)))
            .andExpect(jsonPath("$.[*].brief").value(hasItem(DEFAULT_BRIEF)))
            .andExpect(jsonPath("$.[*].rsBrief").value(hasItem(DEFAULT_RS_BRIEF)))
            .andExpect(jsonPath("$.[*].enBrief").value(hasItem(DEFAULT_EN_BRIEF)))
            .andExpect(jsonPath("$.[*].info").value(hasItem(DEFAULT_INFO)))
            .andExpect(jsonPath("$.[*].rsArtInfo").value(hasItem(DEFAULT_RS_ART_INFO)))
            .andExpect(jsonPath("$.[*].enArtInfo").value(hasItem(DEFAULT_EN_ART_INFO)))
            .andExpect(jsonPath("$.[*].rating").value(hasItem(DEFAULT_RATING)))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].useArtistInfo").value(hasItem(DEFAULT_USE_ARTIST_INFO.booleanValue())));
    }
    
    @Test
    @Transactional
    public void getPainting() throws Exception {
        // Initialize the database
        paintingRepository.saveAndFlush(painting);

        // Get the painting
        restPaintingMockMvc.perform(get("/api/paintings/{id}", painting.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(painting.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.rsName").value(DEFAULT_RS_NAME))
            .andExpect(jsonPath("$.enName").value(DEFAULT_EN_NAME))
            .andExpect(jsonPath("$.artistId").value(DEFAULT_ARTIST_ID.intValue()))
            .andExpect(jsonPath("$.materialId").value(DEFAULT_MATERIAL_ID.intValue()))
            .andExpect(jsonPath("$.artTypeId").value(DEFAULT_ART_TYPE_ID.intValue()))
            .andExpect(jsonPath("$.museumId").value(DEFAULT_MUSEUM_ID.intValue()))
            .andExpect(jsonPath("$.age").value(DEFAULT_AGE))
            .andExpect(jsonPath("$.tags").value(DEFAULT_TAGS))
            .andExpect(jsonPath("$.width").value(DEFAULT_WIDTH.doubleValue()))
            .andExpect(jsonPath("$.height").value(DEFAULT_HEIGHT.doubleValue()))
            .andExpect(jsonPath("$.rawImg").value(DEFAULT_RAW_IMG))
            .andExpect(jsonPath("$.webImg").value(DEFAULT_WEB_IMG))
            .andExpect(jsonPath("$.thumbnailImg").value(DEFAULT_THUMBNAIL_IMG))
            .andExpect(jsonPath("$.pin").value(DEFAULT_PIN))
            .andExpect(jsonPath("$.pinImg").value(DEFAULT_PIN_IMG))
            .andExpect(jsonPath("$.reference").value(DEFAULT_REFERENCE))
            .andExpect(jsonPath("$.categoryStatusId").value(DEFAULT_CATEGORY_STATUS_ID.intValue()))
            .andExpect(jsonPath("$.sentence").value(DEFAULT_SENTENCE))
            .andExpect(jsonPath("$.rsSentence").value(DEFAULT_RS_SENTENCE))
            .andExpect(jsonPath("$.enSentence").value(DEFAULT_EN_SENTENCE))
            .andExpect(jsonPath("$.brief").value(DEFAULT_BRIEF))
            .andExpect(jsonPath("$.rsBrief").value(DEFAULT_RS_BRIEF))
            .andExpect(jsonPath("$.enBrief").value(DEFAULT_EN_BRIEF))
            .andExpect(jsonPath("$.info").value(DEFAULT_INFO))
            .andExpect(jsonPath("$.rsArtInfo").value(DEFAULT_RS_ART_INFO))
            .andExpect(jsonPath("$.enArtInfo").value(DEFAULT_EN_ART_INFO))
            .andExpect(jsonPath("$.rating").value(DEFAULT_RATING))
            .andExpect(jsonPath("$.createDate").value(DEFAULT_CREATE_DATE.toString()))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.toString()))
            .andExpect(jsonPath("$.useArtistInfo").value(DEFAULT_USE_ARTIST_INFO.booleanValue()));
    }

    @Test
    @Transactional
    public void getNonExistingPainting() throws Exception {
        // Get the painting
        restPaintingMockMvc.perform(get("/api/paintings/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePainting() throws Exception {
        // Initialize the database
        paintingRepository.saveAndFlush(painting);

        int databaseSizeBeforeUpdate = paintingRepository.findAll().size();

        // Update the painting
        Painting updatedPainting = paintingRepository.findById(painting.getId()).get();
        // Disconnect from session so that the updates on updatedPainting are not directly saved in db
        em.detach(updatedPainting);
        updatedPainting
            .name(UPDATED_NAME)
            .rsName(UPDATED_RS_NAME)
            .enName(UPDATED_EN_NAME)
            .artistId(UPDATED_ARTIST_ID)
            .materialId(UPDATED_MATERIAL_ID)
            .artTypeId(UPDATED_ART_TYPE_ID)
            .museumId(UPDATED_MUSEUM_ID)
            .age(UPDATED_AGE)
            .tags(UPDATED_TAGS)
            .width(UPDATED_WIDTH)
            .height(UPDATED_HEIGHT)
            .rawImg(UPDATED_RAW_IMG)
            .webImg(UPDATED_WEB_IMG)
            .thumbnailImg(UPDATED_THUMBNAIL_IMG)
            .pin(UPDATED_PIN)
            .pinImg(UPDATED_PIN_IMG)
            .reference(UPDATED_REFERENCE)
            .categoryStatusId(UPDATED_CATEGORY_STATUS_ID)
            .sentence(UPDATED_SENTENCE)
            .rsSentence(UPDATED_RS_SENTENCE)
            .enSentence(UPDATED_EN_SENTENCE)
            .brief(UPDATED_BRIEF)
            .rsBrief(UPDATED_RS_BRIEF)
            .enBrief(UPDATED_EN_BRIEF)
            .info(UPDATED_INFO)
            .rsArtInfo(UPDATED_RS_ART_INFO)
            .enArtInfo(UPDATED_EN_ART_INFO)
            .rating(UPDATED_RATING)
            .createDate(UPDATED_CREATE_DATE)
            .updateDate(UPDATED_UPDATE_DATE)
            .useArtistInfo(UPDATED_USE_ARTIST_INFO);
        PaintingDTO paintingDTO = paintingMapper.toDto(updatedPainting);

        restPaintingMockMvc.perform(put("/api/paintings")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(paintingDTO)))
            .andExpect(status().isOk());

        // Validate the Painting in the database
        List<Painting> paintingList = paintingRepository.findAll();
        assertThat(paintingList).hasSize(databaseSizeBeforeUpdate);
        Painting testPainting = paintingList.get(paintingList.size() - 1);
        assertThat(testPainting.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testPainting.getRsName()).isEqualTo(UPDATED_RS_NAME);
        assertThat(testPainting.getEnName()).isEqualTo(UPDATED_EN_NAME);
        assertThat(testPainting.getArtistId()).isEqualTo(UPDATED_ARTIST_ID);
        assertThat(testPainting.getMaterialId()).isEqualTo(UPDATED_MATERIAL_ID);
        assertThat(testPainting.getArtTypeId()).isEqualTo(UPDATED_ART_TYPE_ID);
        assertThat(testPainting.getMuseumId()).isEqualTo(UPDATED_MUSEUM_ID);
        assertThat(testPainting.getAge()).isEqualTo(UPDATED_AGE);
        assertThat(testPainting.getTags()).isEqualTo(UPDATED_TAGS);
        assertThat(testPainting.getWidth()).isEqualTo(UPDATED_WIDTH);
        assertThat(testPainting.getHeight()).isEqualTo(UPDATED_HEIGHT);
        assertThat(testPainting.getRawImg()).isEqualTo(UPDATED_RAW_IMG);
        assertThat(testPainting.getWebImg()).isEqualTo(UPDATED_WEB_IMG);
        assertThat(testPainting.getThumbnailImg()).isEqualTo(UPDATED_THUMBNAIL_IMG);
        assertThat(testPainting.getPin()).isEqualTo(UPDATED_PIN);
        assertThat(testPainting.getPinImg()).isEqualTo(UPDATED_PIN_IMG);
        assertThat(testPainting.getReference()).isEqualTo(UPDATED_REFERENCE);
        assertThat(testPainting.getCategoryStatusId()).isEqualTo(UPDATED_CATEGORY_STATUS_ID);
        assertThat(testPainting.getSentence()).isEqualTo(UPDATED_SENTENCE);
        assertThat(testPainting.getRsSentence()).isEqualTo(UPDATED_RS_SENTENCE);
        assertThat(testPainting.getEnSentence()).isEqualTo(UPDATED_EN_SENTENCE);
        assertThat(testPainting.getBrief()).isEqualTo(UPDATED_BRIEF);
        assertThat(testPainting.getRsBrief()).isEqualTo(UPDATED_RS_BRIEF);
        assertThat(testPainting.getEnBrief()).isEqualTo(UPDATED_EN_BRIEF);
        assertThat(testPainting.getInfo()).isEqualTo(UPDATED_INFO);
        assertThat(testPainting.getRsArtInfo()).isEqualTo(UPDATED_RS_ART_INFO);
        assertThat(testPainting.getEnArtInfo()).isEqualTo(UPDATED_EN_ART_INFO);
        assertThat(testPainting.getRating()).isEqualTo(UPDATED_RATING);
        assertThat(testPainting.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testPainting.getUpdateDate()).isEqualTo(UPDATED_UPDATE_DATE);
        assertThat(testPainting.isUseArtistInfo()).isEqualTo(UPDATED_USE_ARTIST_INFO);
    }

    @Test
    @Transactional
    public void updateNonExistingPainting() throws Exception {
        int databaseSizeBeforeUpdate = paintingRepository.findAll().size();

        // Create the Painting
        PaintingDTO paintingDTO = paintingMapper.toDto(painting);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPaintingMockMvc.perform(put("/api/paintings")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(paintingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Painting in the database
        List<Painting> paintingList = paintingRepository.findAll();
        assertThat(paintingList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePainting() throws Exception {
        // Initialize the database
        paintingRepository.saveAndFlush(painting);

        int databaseSizeBeforeDelete = paintingRepository.findAll().size();

        // Delete the painting
        restPaintingMockMvc.perform(delete("/api/paintings/{id}", painting.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Painting> paintingList = paintingRepository.findAll();
        assertThat(paintingList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
