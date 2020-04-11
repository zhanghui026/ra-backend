package com.zh.raback.repository;

import com.zh.raback.domain.Product;

import com.zh.raback.domain.Product_;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Product entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>,JpaSpecificationExecutor<Product> {
    List<Product> findAllByIdIn(List<Long> ids);
}
