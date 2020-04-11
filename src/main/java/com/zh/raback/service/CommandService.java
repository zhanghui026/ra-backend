package com.zh.raback.service;

import com.zh.raback.domain.Command;
import com.zh.raback.service.dto.CommandDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.zh.raback.domain.Command}.
 */
public interface CommandService {

    /**
     * Save a command.
     *
     * @param commandDTO the entity to save.
     * @return the persisted entity.
     */
    CommandDTO save(CommandDTO commandDTO);

    /**
     * Get all the commands.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CommandDTO> findAll(Pageable pageable);

    /**
     * Get the "id" command.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CommandDTO> findOne(Long id);

    /**
     * Delete the "id" command.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    Page<CommandDTO> findAllBySearch(Specification<Command> specification, Pageable pageable);

    void deleteIds(List<Long> ids);
}
