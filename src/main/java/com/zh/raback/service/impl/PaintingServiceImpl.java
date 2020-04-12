package com.zh.raback.service.impl;

import com.zh.raback.service.PaintingService;
import com.zh.raback.domain.Painting;
import com.zh.raback.repository.PaintingRepository;
import com.zh.raback.service.dto.PaintingDTO;
import com.zh.raback.service.mapper.PaintingMapper;
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
 * Service Implementation for managing {@link Painting}.
 */
@Service
@Transactional
public class PaintingServiceImpl implements PaintingService {

    private final Logger log = LoggerFactory.getLogger(PaintingServiceImpl.class);

    private final PaintingRepository paintingRepository;

    private final PaintingMapper paintingMapper;

    public PaintingServiceImpl(PaintingRepository paintingRepository, PaintingMapper paintingMapper) {
        this.paintingRepository = paintingRepository;
        this.paintingMapper = paintingMapper;
    }

    /**
     * Save a painting.
     *
     * @param paintingDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public PaintingDTO save(PaintingDTO paintingDTO) {
        log.debug("Request to save Painting : {}", paintingDTO);
        Painting painting = paintingMapper.toEntity(paintingDTO);
        painting = paintingRepository.save(painting);
        return paintingMapper.toDto(painting);
    }

    /**
     * Get all the paintings.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PaintingDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Paintings");
        return paintingRepository.findAll(pageable)
            .map(paintingMapper::toDto);
    }

    /**
     * Get one painting by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<PaintingDTO> findOne(Long id) {
        log.debug("Request to get Painting : {}", id);
        return paintingRepository.findById(id)
            .map(paintingMapper::toDto);
    }

    /**
     * Delete the painting by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Painting : {}", id);
        paintingRepository.deleteById(id);
    }

    @Override
    public List<PaintingDTO> findAllInIds(List<Long> ids) {
        log.debug("Request to findAllInIds: {}", ids);
        return paintingRepository.findAllById(ids).stream().map(paintingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Page<PaintingDTO> findAllBySearch(Specification<Painting> specification, Pageable pageable) {
        log.debug("Request to findAllBySearch: {} {}", specification, pageable);
        return paintingRepository.findAll(specification,pageable).map(paintingMapper::toDto);
    }

    @Override
    public void deleteIds(List<Long> ids) {
        log.debug("Request to deleteIds: {}", ids);
        List<Painting> allById = paintingRepository.findAllById(ids);
        paintingRepository.deleteAll(allById);
    }
}
