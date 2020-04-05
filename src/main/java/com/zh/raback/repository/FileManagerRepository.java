package com.zh.raback.repository;

import com.zh.raback.domain.FileManager;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the FileManager entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FileManagerRepository extends JpaRepository<FileManager, Long> {
}
