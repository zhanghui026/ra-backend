package com.zh.raback.service.impl;

import com.zh.raback.service.FileManagerService;
import com.zh.raback.domain.FileManager;
import com.zh.raback.repository.FileManagerRepository;
import com.zh.raback.service.dto.FileManagerDTO;
import com.zh.raback.service.mapper.FileManagerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link FileManager}.
 */
@Service
@Transactional
public class FileManagerServiceImpl implements FileManagerService {

    private final Logger log = LoggerFactory.getLogger(FileManagerServiceImpl.class);

    private final FileManagerRepository fileManagerRepository;

    private final FileManagerMapper fileManagerMapper;

    public FileManagerServiceImpl(FileManagerRepository fileManagerRepository, FileManagerMapper fileManagerMapper) {
        this.fileManagerRepository = fileManagerRepository;
        this.fileManagerMapper = fileManagerMapper;
    }

    /**
     * Save a fileManager.
     *
     * @param fileManagerDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public FileManagerDTO save(FileManagerDTO fileManagerDTO) {
        log.debug("Request to save FileManager : {}", fileManagerDTO);
        FileManager fileManager = fileManagerMapper.toEntity(fileManagerDTO);
        fileManager = fileManagerRepository.save(fileManager);
        return fileManagerMapper.toDto(fileManager);
    }

    /**
     * Get all the fileManagers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<FileManagerDTO> findAll(Pageable pageable) {
        log.debug("Request to get all FileManagers");
        return fileManagerRepository.findAll(pageable)
            .map(fileManagerMapper::toDto);
    }

    /**
     * Get one fileManager by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<FileManagerDTO> findOne(Long id) {
        log.debug("Request to get FileManager : {}", id);
        return fileManagerRepository.findById(id)
            .map(fileManagerMapper::toDto);
    }

    /**
     * Delete the fileManager by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete FileManager : {}", id);
        fileManagerRepository.deleteById(id);
    }

    @Override
    public Optional<FileManagerDTO> findByFileNo(String imageNo) {
        log.debug("Request to findByFileNo: {}", imageNo);

        return fileManagerRepository.findByFileNo(imageNo).map(fileManagerMapper::toDto);
    }
}
