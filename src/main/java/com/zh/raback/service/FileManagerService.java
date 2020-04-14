package com.zh.raback.service;

import com.zh.raback.service.dto.FileManagerDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.zh.raback.domain.FileManager}.
 */
public interface FileManagerService {

    /**
     * Save a fileManager.
     *
     * @param fileManagerDTO the entity to save.
     * @return the persisted entity.
     */
    FileManagerDTO save(FileManagerDTO fileManagerDTO);

    /**
     * Get all the fileManagers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<FileManagerDTO> findAll(Pageable pageable);

    /**
     * Get the "id" fileManager.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<FileManagerDTO> findOne(Long id);

    /**
     * Delete the "id" fileManager.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    Optional<FileManagerDTO> findByFileNo(String imageNo);
}
