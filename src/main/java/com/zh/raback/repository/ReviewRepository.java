package com.zh.raback.repository;

import com.zh.raback.domain.Review;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Review entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>,JpaSpecificationExecutor<Review> {


    List<Review> findAllByIdInAndStatusNot(List<Long> ids, String status);
}
