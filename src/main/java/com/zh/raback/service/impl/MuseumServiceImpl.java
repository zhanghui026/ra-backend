package com.zh.raback.service.impl;

import com.zh.raback.service.MuseumService;
import com.zh.raback.domain.Museum;
import com.zh.raback.repository.MuseumRepository;
import com.zh.raback.service.dto.MuseumDTO;
import com.zh.raback.service.mapper.MuseumMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Museum}.
 */
@Service
@Transactional
public class MuseumServiceImpl implements MuseumService {

    private final Logger log = LoggerFactory.getLogger(MuseumServiceImpl.class);

    private final MuseumRepository museumRepository;

    private final MuseumMapper museumMapper;

    public MuseumServiceImpl(MuseumRepository museumRepository, MuseumMapper museumMapper) {
        this.museumRepository = museumRepository;
        this.museumMapper = museumMapper;
    }

    /**
     * Save a museum.
     *
     * @param museumDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public MuseumDTO save(MuseumDTO museumDTO) {
        log.debug("Request to save Museum : {}", museumDTO);
        Museum museum = museumMapper.toEntity(museumDTO);
        museum = museumRepository.save(museum);
        return museumMapper.toDto(museum);
    }

    /**
     * Get all the museums.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<MuseumDTO> findAll() {
        log.debug("Request to get all Museums");
        return museumRepository.findAll().stream()
            .map(museumMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one museum by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<MuseumDTO> findOne(Long id) {
        log.debug("Request to get Museum : {}", id);
        return museumRepository.findById(id)
            .map(museumMapper::toDto);
    }

    /**
     * Delete the museum by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Museum : {}", id);
        museumRepository.deleteById(id);
    }
}
