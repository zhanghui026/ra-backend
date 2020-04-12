package com.zh.raback.repository;

import com.zh.raback.domain.Painting;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Painting entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaintingRepository extends JpaRepository<Painting, Long>,JpaSpecificationExecutor<Painting> {
}
