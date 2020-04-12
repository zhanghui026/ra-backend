package com.zh.raback.web.rest;

import com.zh.raback.RabackApp;
import com.zh.raback.domain.Artist;
import com.zh.raback.repository.ArtistRepository;
import com.zh.raback.service.ArtistService;
import com.zh.raback.service.dto.ArtistDTO;
import com.zh.raback.service.mapper.ArtistMapper;

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
 * Integration tests for the {@link ArtistResource} REST controller.
 */
@SpringBootTest(classes = RabackApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class ArtistResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_RS_NAME = "AAAAAAAAAA";
    private static final String UPDATED_RS_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EN_NAME = "AAAAAAAAAA";
    private static final String UPDATED_EN_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_AVATAR = "AAAAAAAAAA";
    private static final String UPDATED_AVATAR = "BBBBBBBBBB";

    private static final String DEFAULT_CITIZENSHIP = "AAAAAAAAAA";
    private static final String UPDATED_CITIZENSHIP = "BBBBBBBBBB";

    private static final String DEFAULT_BORN_AGE = "AAAAAAAAAA";
    private static final String UPDATED_BORN_AGE = "BBBBBBBBBB";

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

    private static final String DEFAULT_ART_INFO = "AAAAAAAAAA";
    private static final String UPDATED_ART_INFO = "BBBBBBBBBB";

    private static final String DEFAULT_RS_ART_INFO = "AAAAAAAAAA";
    private static final String UPDATED_RS_ART_INFO = "BBBBBBBBBB";

    private static final String DEFAULT_EN_ART_INFO = "AAAAAAAAAA";
    private static final String UPDATED_EN_ART_INFO = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATE_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_UPDATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATE_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private ArtistMapper artistMapper;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restArtistMockMvc;

    private Artist artist;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Artist createEntity(EntityManager em) {
        Artist artist = new Artist()
            .name(DEFAULT_NAME)
            .rsName(DEFAULT_RS_NAME)
            .enName(DEFAULT_EN_NAME)
            .avatar(DEFAULT_AVATAR)
            .citizenship(DEFAULT_CITIZENSHIP)
            .bornAge(DEFAULT_BORN_AGE)
            .sentence(DEFAULT_SENTENCE)
            .rsSentence(DEFAULT_RS_SENTENCE)
            .enSentence(DEFAULT_EN_SENTENCE)
            .brief(DEFAULT_BRIEF)
            .rsBrief(DEFAULT_RS_BRIEF)
            .enBrief(DEFAULT_EN_BRIEF)
            .artInfo(DEFAULT_ART_INFO)
            .rsArtInfo(DEFAULT_RS_ART_INFO)
            .enArtInfo(DEFAULT_EN_ART_INFO)
            .createDate(DEFAULT_CREATE_DATE)
            .updateDate(DEFAULT_UPDATE_DATE);
        return artist;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Artist createUpdatedEntity(EntityManager em) {
        Artist artist = new Artist()
            .name(UPDATED_NAME)
            .rsName(UPDATED_RS_NAME)
            .enName(UPDATED_EN_NAME)
            .avatar(UPDATED_AVATAR)
            .citizenship(UPDATED_CITIZENSHIP)
            .bornAge(UPDATED_BORN_AGE)
            .sentence(UPDATED_SENTENCE)
            .rsSentence(UPDATED_RS_SENTENCE)
            .enSentence(UPDATED_EN_SENTENCE)
            .brief(UPDATED_BRIEF)
            .rsBrief(UPDATED_RS_BRIEF)
            .enBrief(UPDATED_EN_BRIEF)
            .artInfo(UPDATED_ART_INFO)
            .rsArtInfo(UPDATED_RS_ART_INFO)
            .enArtInfo(UPDATED_EN_ART_INFO)
            .createDate(UPDATED_CREATE_DATE)
            .updateDate(UPDATED_UPDATE_DATE);
        return artist;
    }

    @BeforeEach
    public void initTest() {
        artist = createEntity(em);
    }

    @Test
    @Transactional
    public void createArtist() throws Exception {
        int databaseSizeBeforeCreate = artistRepository.findAll().size();

        // Create the Artist
        ArtistDTO artistDTO = artistMapper.toDto(artist);
        restArtistMockMvc.perform(post("/api/artists")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(artistDTO)))
            .andExpect(status().isCreated());

        // Validate the Artist in the database
        List<Artist> artistList = artistRepository.findAll();
        assertThat(artistList).hasSize(databaseSizeBeforeCreate + 1);
        Artist testArtist = artistList.get(artistList.size() - 1);
        assertThat(testArtist.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testArtist.getRsName()).isEqualTo(DEFAULT_RS_NAME);
        assertThat(testArtist.getEnName()).isEqualTo(DEFAULT_EN_NAME);
        assertThat(testArtist.getAvatar()).isEqualTo(DEFAULT_AVATAR);
        assertThat(testArtist.getCitizenship()).isEqualTo(DEFAULT_CITIZENSHIP);
        assertThat(testArtist.getBornAge()).isEqualTo(DEFAULT_BORN_AGE);
        assertThat(testArtist.getSentence()).isEqualTo(DEFAULT_SENTENCE);
        assertThat(testArtist.getRsSentence()).isEqualTo(DEFAULT_RS_SENTENCE);
        assertThat(testArtist.getEnSentence()).isEqualTo(DEFAULT_EN_SENTENCE);
        assertThat(testArtist.getBrief()).isEqualTo(DEFAULT_BRIEF);
        assertThat(testArtist.getRsBrief()).isEqualTo(DEFAULT_RS_BRIEF);
        assertThat(testArtist.getEnBrief()).isEqualTo(DEFAULT_EN_BRIEF);
        assertThat(testArtist.getArtInfo()).isEqualTo(DEFAULT_ART_INFO);
        assertThat(testArtist.getRsArtInfo()).isEqualTo(DEFAULT_RS_ART_INFO);
        assertThat(testArtist.getEnArtInfo()).isEqualTo(DEFAULT_EN_ART_INFO);
        assertThat(testArtist.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testArtist.getUpdateDate()).isEqualTo(DEFAULT_UPDATE_DATE);
    }

    @Test
    @Transactional
    public void createArtistWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = artistRepository.findAll().size();

        // Create the Artist with an existing ID
        artist.setId(1L);
        ArtistDTO artistDTO = artistMapper.toDto(artist);

        // An entity with an existing ID cannot be created, so this API call must fail
        restArtistMockMvc.perform(post("/api/artists")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(artistDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Artist in the database
        List<Artist> artistList = artistRepository.findAll();
        assertThat(artistList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllArtists() throws Exception {
        // Initialize the database
        artistRepository.saveAndFlush(artist);

        // Get all the artistList
        restArtistMockMvc.perform(get("/api/artists?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(artist.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].rsName").value(hasItem(DEFAULT_RS_NAME)))
            .andExpect(jsonPath("$.[*].enName").value(hasItem(DEFAULT_EN_NAME)))
            .andExpect(jsonPath("$.[*].avatar").value(hasItem(DEFAULT_AVATAR)))
            .andExpect(jsonPath("$.[*].citizenship").value(hasItem(DEFAULT_CITIZENSHIP)))
            .andExpect(jsonPath("$.[*].bornAge").value(hasItem(DEFAULT_BORN_AGE)))
            .andExpect(jsonPath("$.[*].sentence").value(hasItem(DEFAULT_SENTENCE)))
            .andExpect(jsonPath("$.[*].rsSentence").value(hasItem(DEFAULT_RS_SENTENCE)))
            .andExpect(jsonPath("$.[*].enSentence").value(hasItem(DEFAULT_EN_SENTENCE)))
            .andExpect(jsonPath("$.[*].brief").value(hasItem(DEFAULT_BRIEF)))
            .andExpect(jsonPath("$.[*].rsBrief").value(hasItem(DEFAULT_RS_BRIEF)))
            .andExpect(jsonPath("$.[*].enBrief").value(hasItem(DEFAULT_EN_BRIEF)))
            .andExpect(jsonPath("$.[*].artInfo").value(hasItem(DEFAULT_ART_INFO)))
            .andExpect(jsonPath("$.[*].rsArtInfo").value(hasItem(DEFAULT_RS_ART_INFO)))
            .andExpect(jsonPath("$.[*].enArtInfo").value(hasItem(DEFAULT_EN_ART_INFO)))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.toString())));
    }

    @Test
    @Transactional
    public void getArtist() throws Exception {
        // Initialize the database
        artistRepository.saveAndFlush(artist);

        // Get the artist
        restArtistMockMvc.perform(get("/api/artists/{id}", artist.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(artist.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.rsName").value(DEFAULT_RS_NAME))
            .andExpect(jsonPath("$.enName").value(DEFAULT_EN_NAME))
            .andExpect(jsonPath("$.avatar").value(DEFAULT_AVATAR))
            .andExpect(jsonPath("$.citizenship").value(DEFAULT_CITIZENSHIP))
            .andExpect(jsonPath("$.bornAge").value(DEFAULT_BORN_AGE))
            .andExpect(jsonPath("$.sentence").value(DEFAULT_SENTENCE))
            .andExpect(jsonPath("$.rsSentence").value(DEFAULT_RS_SENTENCE))
            .andExpect(jsonPath("$.enSentence").value(DEFAULT_EN_SENTENCE))
            .andExpect(jsonPath("$.brief").value(DEFAULT_BRIEF))
            .andExpect(jsonPath("$.rsBrief").value(DEFAULT_RS_BRIEF))
            .andExpect(jsonPath("$.enBrief").value(DEFAULT_EN_BRIEF))
            .andExpect(jsonPath("$.artInfo").value(DEFAULT_ART_INFO))
            .andExpect(jsonPath("$.rsArtInfo").value(DEFAULT_RS_ART_INFO))
            .andExpect(jsonPath("$.enArtInfo").value(DEFAULT_EN_ART_INFO))
            .andExpect(jsonPath("$.createDate").value(DEFAULT_CREATE_DATE.toString()))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingArtist() throws Exception {
        // Get the artist
        restArtistMockMvc.perform(get("/api/artists/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateArtist() throws Exception {
        // Initialize the database
        artistRepository.saveAndFlush(artist);

        int databaseSizeBeforeUpdate = artistRepository.findAll().size();

        // Update the artist
        Artist updatedArtist = artistRepository.findById(artist.getId()).get();
        // Disconnect from session so that the updates on updatedArtist are not directly saved in db
        em.detach(updatedArtist);
        updatedArtist
            .name(UPDATED_NAME)
            .rsName(UPDATED_RS_NAME)
            .enName(UPDATED_EN_NAME)
            .avatar(UPDATED_AVATAR)
            .citizenship(UPDATED_CITIZENSHIP)
            .bornAge(UPDATED_BORN_AGE)
            .sentence(UPDATED_SENTENCE)
            .rsSentence(UPDATED_RS_SENTENCE)
            .enSentence(UPDATED_EN_SENTENCE)
            .brief(UPDATED_BRIEF)
            .rsBrief(UPDATED_RS_BRIEF)
            .enBrief(UPDATED_EN_BRIEF)
            .artInfo(UPDATED_ART_INFO)
            .rsArtInfo(UPDATED_RS_ART_INFO)
            .enArtInfo(UPDATED_EN_ART_INFO)
            .createDate(UPDATED_CREATE_DATE)
            .updateDate(UPDATED_UPDATE_DATE);
        ArtistDTO artistDTO = artistMapper.toDto(updatedArtist);

        restArtistMockMvc.perform(put("/api/artists")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(artistDTO)))
            .andExpect(status().isOk());

        // Validate the Artist in the database
        List<Artist> artistList = artistRepository.findAll();
        assertThat(artistList).hasSize(databaseSizeBeforeUpdate);
        Artist testArtist = artistList.get(artistList.size() - 1);
        assertThat(testArtist.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testArtist.getRsName()).isEqualTo(UPDATED_RS_NAME);
        assertThat(testArtist.getEnName()).isEqualTo(UPDATED_EN_NAME);
        assertThat(testArtist.getAvatar()).isEqualTo(UPDATED_AVATAR);
        assertThat(testArtist.getCitizenship()).isEqualTo(UPDATED_CITIZENSHIP);
        assertThat(testArtist.getBornAge()).isEqualTo(UPDATED_BORN_AGE);
        assertThat(testArtist.getSentence()).isEqualTo(UPDATED_SENTENCE);
        assertThat(testArtist.getRsSentence()).isEqualTo(UPDATED_RS_SENTENCE);
        assertThat(testArtist.getEnSentence()).isEqualTo(UPDATED_EN_SENTENCE);
        assertThat(testArtist.getBrief()).isEqualTo(UPDATED_BRIEF);
        assertThat(testArtist.getRsBrief()).isEqualTo(UPDATED_RS_BRIEF);
        assertThat(testArtist.getEnBrief()).isEqualTo(UPDATED_EN_BRIEF);
        assertThat(testArtist.getArtInfo()).isEqualTo(UPDATED_ART_INFO);
        assertThat(testArtist.getRsArtInfo()).isEqualTo(UPDATED_RS_ART_INFO);
        assertThat(testArtist.getEnArtInfo()).isEqualTo(UPDATED_EN_ART_INFO);
        assertThat(testArtist.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testArtist.getUpdateDate()).isEqualTo(UPDATED_UPDATE_DATE);
    }

    @Test
    @Transactional
    public void updateNonExistingArtist() throws Exception {
        int databaseSizeBeforeUpdate = artistRepository.findAll().size();

        // Create the Artist
        ArtistDTO artistDTO = artistMapper.toDto(artist);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restArtistMockMvc.perform(put("/api/artists")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(artistDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Artist in the database
        List<Artist> artistList = artistRepository.findAll();
        assertThat(artistList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteArtist() throws Exception {
        // Initialize the database
        artistRepository.saveAndFlush(artist);

        int databaseSizeBeforeDelete = artistRepository.findAll().size();

        // Delete the artist
        restArtistMockMvc.perform(delete("/api/artists/{id}", artist.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Artist> artistList = artistRepository.findAll();
        assertThat(artistList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
