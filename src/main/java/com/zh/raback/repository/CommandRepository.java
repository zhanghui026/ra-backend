package com.zh.raback.repository;

import com.zh.raback.domain.Command;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data  repository for the Command entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CommandRepository extends JpaRepository<Command, Long>,JpaSpecificationExecutor<Command> {

    List<Command> findAllByIdIn(List<Long> id);

}
