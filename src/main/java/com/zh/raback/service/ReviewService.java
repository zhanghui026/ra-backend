package com.zh.raback.service;

import com.zh.raback.domain.Review;
import com.zh.raback.service.dto.ReviewDTO;

import com.zh.raback.web.rest.ReviewResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.zh.raback.domain.Review}.
 */
public interface ReviewService {

    /**
     * Save a review.
     *
     * @param reviewDTO the entity to save.
     * @return the persisted entity.
     */
    ReviewDTO save(ReviewDTO reviewDTO);

    /**
     * Get all the reviews.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ReviewDTO> findAll(Pageable pageable);

    /**
     * Get the "id" review.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ReviewDTO> findOne(Long id);

    /**
     * Delete the "id" review.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);


    void updateBatchStatus(List<Long> ids, String status);

    void deleteIds(List<Long> ids);

    List<ReviewDTO> findAllInIds(List<Long> ids);

    Page<ReviewDTO> findAllBySearch(Specification<Review> specification, Pageable pageable);
}
