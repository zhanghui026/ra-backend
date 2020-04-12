package com.zh.raback.service;

import com.zh.raback.domain.Artist;
import com.zh.raback.service.dto.ArtistDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Artist}.
 */
public interface ArtistService {

    /**
     * Save a artist.
     *
     * @param artistDTO the entity to save.
     * @return the persisted entity.
     */
    ArtistDTO save(ArtistDTO artistDTO);

    /**
     * Get all the artists.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ArtistDTO> findAll(Pageable pageable);

    /**
     * Get the "id" artist.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ArtistDTO> findOne(Long id);

    /**
     * Delete the "id" artist.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    List<ArtistDTO> findAllInIds(List<Long> ids);

    Page<ArtistDTO> findAllBySearch(Specification<Artist> specification, Pageable pageable);

    void deleteIds(List<Long> ids);

}
