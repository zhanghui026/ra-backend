package com.zh.raback.service;

import com.zh.raback.service.dto.MuseumDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.zh.raback.domain.Museum}.
 */
public interface MuseumService {

    /**
     * Save a museum.
     *
     * @param museumDTO the entity to save.
     * @return the persisted entity.
     */
    MuseumDTO save(MuseumDTO museumDTO);

    /**
     * Get all the museums.
     *
     * @return the list of entities.
     */
    List<MuseumDTO> findAll();

    /**
     * Get the "id" museum.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<MuseumDTO> findOne(Long id);

    /**
     * Delete the "id" museum.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
