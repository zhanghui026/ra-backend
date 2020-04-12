package com.zh.raback.service;

import com.zh.raback.domain.Painting;
import com.zh.raback.service.dto.PaintingDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.zh.raback.domain.Painting}.
 */
public interface PaintingService {

    /**
     * Save a painting.
     *
     * @param paintingDTO the entity to save.
     * @return the persisted entity.
     */
    PaintingDTO save(PaintingDTO paintingDTO);

    /**
     * Get all the paintings.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PaintingDTO> findAll(Pageable pageable);

    /**
     * Get the "id" painting.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaintingDTO> findOne(Long id);

    /**
     * Delete the "id" painting.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    List<PaintingDTO> findAllInIds(List<Long> ids);

    Page<PaintingDTO> findAllBySearch(Specification<Painting> specification, Pageable pageable);

    void deleteIds(List<Long> ids);

}
