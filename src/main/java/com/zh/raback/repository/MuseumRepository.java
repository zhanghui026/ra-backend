package com.zh.raback.repository;

import com.zh.raback.domain.Museum;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Museum entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MuseumRepository extends JpaRepository<Museum, Long> {
}
