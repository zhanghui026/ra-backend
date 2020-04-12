package com.zh.raback.service.impl;

import com.zh.raback.domain.Artist;
import com.zh.raback.service.ArtistService;
import com.zh.raback.repository.ArtistRepository;
import com.zh.raback.service.dto.ArtistDTO;
import com.zh.raback.service.mapper.ArtistMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Artist}.
 */
@Service
@Transactional
public class ArtistServiceImpl implements ArtistService {

    private final Logger log = LoggerFactory.getLogger(ArtistServiceImpl.class);

    private final ArtistRepository artistRepository;

    private final ArtistMapper artistMapper;

    public ArtistServiceImpl(ArtistRepository artistRepository, ArtistMapper artistMapper) {
        this.artistRepository = artistRepository;
        this.artistMapper = artistMapper;
    }

    /**
     * Save a artist.
     *
     * @param artistDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ArtistDTO save(ArtistDTO artistDTO) {
        log.debug("Request to save Artist : {}", artistDTO);
        Artist artist = artistMapper.toEntity(artistDTO);
        artist = artistRepository.save(artist);
        return artistMapper.toDto(artist);
    }

    /**
     * Get all the artists.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ArtistDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Artists");
        return artistRepository.findAll(pageable)
            .map(artistMapper::toDto);
    }

    /**
     * Get one artist by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ArtistDTO> findOne(Long id) {
        log.debug("Request to get Artist : {}", id);
        return artistRepository.findById(id)
            .map(artistMapper::toDto);
    }

    /**
     * Delete the artist by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Artist : {}", id);
        artistRepository.deleteById(id);
    }

    @Override
    public List<ArtistDTO> findAllInIds(List<Long> ids) {
        log.debug("Request to findAllInIds: {}", ids);
        return artistRepository.findAllById(ids)
            .stream().map(artistMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Page<ArtistDTO> findAllBySearch(Specification<Artist> specification, Pageable pageable) {
        return artistRepository.findAll(specification,pageable).map(artistMapper::toDto);
    }

    @Override
    public void deleteIds(List<Long> ids) {
        List<Artist> allById = artistRepository.findAllById(ids);
        artistRepository.deleteAll(allById);
    }
}
