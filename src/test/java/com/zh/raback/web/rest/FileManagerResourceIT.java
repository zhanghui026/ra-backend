package com.zh.raback.web.rest;

import com.zh.raback.RabackApp;
import com.zh.raback.domain.FileManager;
import com.zh.raback.repository.FileManagerRepository;
import com.zh.raback.service.FileManagerService;
import com.zh.raback.service.dto.FileManagerDTO;
import com.zh.raback.service.mapper.FileManagerMapper;

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
 * Integration tests for the {@link FileManagerResource} REST controller.
 */
@SpringBootTest(classes = RabackApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class FileManagerResourceIT {

    private static final String DEFAULT_FILE_NO = "AAAAAAAAAA";
    private static final String UPDATED_FILE_NO = "BBBBBBBBBB";

    private static final String DEFAULT_BIZ_CODE = "AAAAAAAAAA";
    private static final String UPDATED_BIZ_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_URL = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_URL = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_PATH = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_PATH = "BBBBBBBBBB";

    private static final String DEFAULT_DEFAULT_FILE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_DEFAULT_FILE_NAME = "BBBBBBBBBB";

    private static final Boolean DEFAULT_IS_IMG = false;
    private static final Boolean UPDATED_IS_IMG = true;

    private static final Long DEFAULT_SIZE = 1L;
    private static final Long UPDATED_SIZE = 2L;

    private static final Boolean DEFAULT_IS_THUMBNAIL = false;
    private static final Boolean UPDATED_IS_THUMBNAIL = true;

    private static final Boolean DEFAULT_IS_COMMIT = false;
    private static final Boolean UPDATED_IS_COMMIT = true;

    private static final Instant DEFAULT_CREATE_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATE_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_UPDATE_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATE_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private FileManagerRepository fileManagerRepository;

    @Autowired
    private FileManagerMapper fileManagerMapper;

    @Autowired
    private FileManagerService fileManagerService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restFileManagerMockMvc;

    private FileManager fileManager;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FileManager createEntity(EntityManager em) {
        FileManager fileManager = new FileManager()
            .fileNo(DEFAULT_FILE_NO)
            .bizCode(DEFAULT_BIZ_CODE)
            .defaultUrl(DEFAULT_DEFAULT_URL)
            .defaultPath(DEFAULT_DEFAULT_PATH)
            .defaultFileName(DEFAULT_DEFAULT_FILE_NAME)
            .isImg(DEFAULT_IS_IMG)
            .size(DEFAULT_SIZE)
            .isThumbnail(DEFAULT_IS_THUMBNAIL)
            .isCommit(DEFAULT_IS_COMMIT)
            .createTime(DEFAULT_CREATE_TIME)
            .updateTime(DEFAULT_UPDATE_TIME);
        return fileManager;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FileManager createUpdatedEntity(EntityManager em) {
        FileManager fileManager = new FileManager()
            .fileNo(UPDATED_FILE_NO)
            .bizCode(UPDATED_BIZ_CODE)
            .defaultUrl(UPDATED_DEFAULT_URL)
            .defaultPath(UPDATED_DEFAULT_PATH)
            .defaultFileName(UPDATED_DEFAULT_FILE_NAME)
            .isImg(UPDATED_IS_IMG)
            .size(UPDATED_SIZE)
            .isThumbnail(UPDATED_IS_THUMBNAIL)
            .isCommit(UPDATED_IS_COMMIT)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME);
        return fileManager;
    }

    @BeforeEach
    public void initTest() {
        fileManager = createEntity(em);
    }

    @Test
    @Transactional
    public void createFileManager() throws Exception {
        int databaseSizeBeforeCreate = fileManagerRepository.findAll().size();

        // Create the FileManager
        FileManagerDTO fileManagerDTO = fileManagerMapper.toDto(fileManager);
        restFileManagerMockMvc.perform(post("/api/file-managers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fileManagerDTO)))
            .andExpect(status().isCreated());

        // Validate the FileManager in the database
        List<FileManager> fileManagerList = fileManagerRepository.findAll();
        assertThat(fileManagerList).hasSize(databaseSizeBeforeCreate + 1);
        FileManager testFileManager = fileManagerList.get(fileManagerList.size() - 1);
        assertThat(testFileManager.getFileNo()).isEqualTo(DEFAULT_FILE_NO);
        assertThat(testFileManager.getBizCode()).isEqualTo(DEFAULT_BIZ_CODE);
        assertThat(testFileManager.getDefaultUrl()).isEqualTo(DEFAULT_DEFAULT_URL);
        assertThat(testFileManager.getDefaultPath()).isEqualTo(DEFAULT_DEFAULT_PATH);
        assertThat(testFileManager.getDefaultFileName()).isEqualTo(DEFAULT_DEFAULT_FILE_NAME);
        assertThat(testFileManager.isIsImg()).isEqualTo(DEFAULT_IS_IMG);
        assertThat(testFileManager.getSize()).isEqualTo(DEFAULT_SIZE);
        assertThat(testFileManager.isIsThumbnail()).isEqualTo(DEFAULT_IS_THUMBNAIL);
        assertThat(testFileManager.isIsCommit()).isEqualTo(DEFAULT_IS_COMMIT);
        assertThat(testFileManager.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testFileManager.getUpdateTime()).isEqualTo(DEFAULT_UPDATE_TIME);
    }

    @Test
    @Transactional
    public void createFileManagerWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = fileManagerRepository.findAll().size();

        // Create the FileManager with an existing ID
        fileManager.setId(1L);
        FileManagerDTO fileManagerDTO = fileManagerMapper.toDto(fileManager);

        // An entity with an existing ID cannot be created, so this API call must fail
        restFileManagerMockMvc.perform(post("/api/file-managers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fileManagerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the FileManager in the database
        List<FileManager> fileManagerList = fileManagerRepository.findAll();
        assertThat(fileManagerList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkFileNoIsRequired() throws Exception {
        int databaseSizeBeforeTest = fileManagerRepository.findAll().size();
        // set the field null
        fileManager.setFileNo(null);

        // Create the FileManager, which fails.
        FileManagerDTO fileManagerDTO = fileManagerMapper.toDto(fileManager);

        restFileManagerMockMvc.perform(post("/api/file-managers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fileManagerDTO)))
            .andExpect(status().isBadRequest());

        List<FileManager> fileManagerList = fileManagerRepository.findAll();
        assertThat(fileManagerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllFileManagers() throws Exception {
        // Initialize the database
        fileManagerRepository.saveAndFlush(fileManager);

        // Get all the fileManagerList
        restFileManagerMockMvc.perform(get("/api/file-managers?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(fileManager.getId().intValue())))
            .andExpect(jsonPath("$.[*].fileNo").value(hasItem(DEFAULT_FILE_NO)))
            .andExpect(jsonPath("$.[*].bizCode").value(hasItem(DEFAULT_BIZ_CODE)))
            .andExpect(jsonPath("$.[*].defaultUrl").value(hasItem(DEFAULT_DEFAULT_URL)))
            .andExpect(jsonPath("$.[*].defaultPath").value(hasItem(DEFAULT_DEFAULT_PATH)))
            .andExpect(jsonPath("$.[*].defaultFileName").value(hasItem(DEFAULT_DEFAULT_FILE_NAME)))
            .andExpect(jsonPath("$.[*].isImg").value(hasItem(DEFAULT_IS_IMG.booleanValue())))
            .andExpect(jsonPath("$.[*].size").value(hasItem(DEFAULT_SIZE.intValue())))
            .andExpect(jsonPath("$.[*].isThumbnail").value(hasItem(DEFAULT_IS_THUMBNAIL.booleanValue())))
            .andExpect(jsonPath("$.[*].isCommit").value(hasItem(DEFAULT_IS_COMMIT.booleanValue())))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(DEFAULT_CREATE_TIME.toString())))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME.toString())));
    }
    
    @Test
    @Transactional
    public void getFileManager() throws Exception {
        // Initialize the database
        fileManagerRepository.saveAndFlush(fileManager);

        // Get the fileManager
        restFileManagerMockMvc.perform(get("/api/file-managers/{id}", fileManager.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(fileManager.getId().intValue()))
            .andExpect(jsonPath("$.fileNo").value(DEFAULT_FILE_NO))
            .andExpect(jsonPath("$.bizCode").value(DEFAULT_BIZ_CODE))
            .andExpect(jsonPath("$.defaultUrl").value(DEFAULT_DEFAULT_URL))
            .andExpect(jsonPath("$.defaultPath").value(DEFAULT_DEFAULT_PATH))
            .andExpect(jsonPath("$.defaultFileName").value(DEFAULT_DEFAULT_FILE_NAME))
            .andExpect(jsonPath("$.isImg").value(DEFAULT_IS_IMG.booleanValue()))
            .andExpect(jsonPath("$.size").value(DEFAULT_SIZE.intValue()))
            .andExpect(jsonPath("$.isThumbnail").value(DEFAULT_IS_THUMBNAIL.booleanValue()))
            .andExpect(jsonPath("$.isCommit").value(DEFAULT_IS_COMMIT.booleanValue()))
            .andExpect(jsonPath("$.createTime").value(DEFAULT_CREATE_TIME.toString()))
            .andExpect(jsonPath("$.updateTime").value(DEFAULT_UPDATE_TIME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingFileManager() throws Exception {
        // Get the fileManager
        restFileManagerMockMvc.perform(get("/api/file-managers/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFileManager() throws Exception {
        // Initialize the database
        fileManagerRepository.saveAndFlush(fileManager);

        int databaseSizeBeforeUpdate = fileManagerRepository.findAll().size();

        // Update the fileManager
        FileManager updatedFileManager = fileManagerRepository.findById(fileManager.getId()).get();
        // Disconnect from session so that the updates on updatedFileManager are not directly saved in db
        em.detach(updatedFileManager);
        updatedFileManager
            .fileNo(UPDATED_FILE_NO)
            .bizCode(UPDATED_BIZ_CODE)
            .defaultUrl(UPDATED_DEFAULT_URL)
            .defaultPath(UPDATED_DEFAULT_PATH)
            .defaultFileName(UPDATED_DEFAULT_FILE_NAME)
            .isImg(UPDATED_IS_IMG)
            .size(UPDATED_SIZE)
            .isThumbnail(UPDATED_IS_THUMBNAIL)
            .isCommit(UPDATED_IS_COMMIT)
            .createTime(UPDATED_CREATE_TIME)
            .updateTime(UPDATED_UPDATE_TIME);
        FileManagerDTO fileManagerDTO = fileManagerMapper.toDto(updatedFileManager);

        restFileManagerMockMvc.perform(put("/api/file-managers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fileManagerDTO)))
            .andExpect(status().isOk());

        // Validate the FileManager in the database
        List<FileManager> fileManagerList = fileManagerRepository.findAll();
        assertThat(fileManagerList).hasSize(databaseSizeBeforeUpdate);
        FileManager testFileManager = fileManagerList.get(fileManagerList.size() - 1);
        assertThat(testFileManager.getFileNo()).isEqualTo(UPDATED_FILE_NO);
        assertThat(testFileManager.getBizCode()).isEqualTo(UPDATED_BIZ_CODE);
        assertThat(testFileManager.getDefaultUrl()).isEqualTo(UPDATED_DEFAULT_URL);
        assertThat(testFileManager.getDefaultPath()).isEqualTo(UPDATED_DEFAULT_PATH);
        assertThat(testFileManager.getDefaultFileName()).isEqualTo(UPDATED_DEFAULT_FILE_NAME);
        assertThat(testFileManager.isIsImg()).isEqualTo(UPDATED_IS_IMG);
        assertThat(testFileManager.getSize()).isEqualTo(UPDATED_SIZE);
        assertThat(testFileManager.isIsThumbnail()).isEqualTo(UPDATED_IS_THUMBNAIL);
        assertThat(testFileManager.isIsCommit()).isEqualTo(UPDATED_IS_COMMIT);
        assertThat(testFileManager.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testFileManager.getUpdateTime()).isEqualTo(UPDATED_UPDATE_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingFileManager() throws Exception {
        int databaseSizeBeforeUpdate = fileManagerRepository.findAll().size();

        // Create the FileManager
        FileManagerDTO fileManagerDTO = fileManagerMapper.toDto(fileManager);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFileManagerMockMvc.perform(put("/api/file-managers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(fileManagerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the FileManager in the database
        List<FileManager> fileManagerList = fileManagerRepository.findAll();
        assertThat(fileManagerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteFileManager() throws Exception {
        // Initialize the database
        fileManagerRepository.saveAndFlush(fileManager);

        int databaseSizeBeforeDelete = fileManagerRepository.findAll().size();

        // Delete the fileManager
        restFileManagerMockMvc.perform(delete("/api/file-managers/{id}", fileManager.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<FileManager> fileManagerList = fileManagerRepository.findAll();
        assertThat(fileManagerList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
