package com.zh.raback.repository;

import com.zh.raback.domain.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Customer entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>,JpaSpecificationExecutor<Customer> {


    List<Customer> findAllByIdIn(List<Long> ids);
}
