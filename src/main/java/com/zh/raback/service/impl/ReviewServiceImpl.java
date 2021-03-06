package com.zh.raback.service.impl;

import com.zh.raback.service.ReviewService;
import com.zh.raback.domain.Review;
import com.zh.raback.repository.ReviewRepository;
import com.zh.raback.service.dto.ReviewDTO;
import com.zh.raback.service.mapper.ReviewMapper;
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
 * Service Implementation for managing {@link Review}.
 */
@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private final Logger log = LoggerFactory.getLogger(ReviewServiceImpl.class);

    private final ReviewRepository reviewRepository;

    private final ReviewMapper reviewMapper;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    /**
     * Save a review.
     *
     * @param reviewDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ReviewDTO save(ReviewDTO reviewDTO) {
        log.debug("Request to save Review : {}", reviewDTO);
        Review review = reviewMapper.toEntity(reviewDTO);
        review = reviewRepository.save(review);
        return reviewMapper.toDto(review);
    }

    /**
     * Get all the reviews.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ReviewDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Reviews");
        return reviewRepository.findAll(pageable)
            .map(reviewMapper::toDto);
    }

    /**
     * Get one review by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ReviewDTO> findOne(Long id) {
        log.debug("Request to get Review : {}", id);
        return reviewRepository.findById(id)
            .map(reviewMapper::toDto);
    }

    /**
     * Delete the review by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Review : {}", id);
        reviewRepository.deleteById(id);
    }

    @Override
    public void updateBatchStatus(List<Long> ids, String status) {
        log.debug("Request to updateBatchStatus : {} {}", ids, status);
        List<Review> reviews = reviewRepository.findAllByIdInAndStatusNot(ids,status);

        for (Review review : reviews) {
            review.setStatus(status);
        }

        reviewRepository.saveAll(reviews);
    }

    @Override
    public void deleteIds(List<Long> ids) {
        List<Review> allById = reviewRepository.findAllById(ids);
        reviewRepository.deleteAll(allById);
    }

    @Override
    public List<ReviewDTO> findAllInIds(List<Long> ids) {
        return reviewRepository.findAllById(ids).stream().map(reviewMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Page<ReviewDTO> findAllBySearch(Specification<Review> specification, Pageable pageable) {
        return reviewRepository.findAll(specification,pageable).map(reviewMapper::toDto);
    }
}
