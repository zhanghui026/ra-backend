package com.zh.raback.repository;

import com.zh.raback.domain.Artist;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Artist entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>,JpaSpecificationExecutor<Artist> {
}
