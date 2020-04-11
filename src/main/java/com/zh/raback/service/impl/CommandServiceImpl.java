package com.zh.raback.service.impl;

import com.zh.raback.service.CommandService;
import com.zh.raback.domain.Command;
import com.zh.raback.repository.CommandRepository;
import com.zh.raback.service.dto.CommandDTO;
import com.zh.raback.service.mapper.CommandMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Command}.
 */
@Service
@Transactional
public class CommandServiceImpl implements CommandService {

    private final Logger log = LoggerFactory.getLogger(CommandServiceImpl.class);

    private final CommandRepository commandRepository;

    private final CommandMapper commandMapper;

    public CommandServiceImpl(CommandRepository commandRepository, CommandMapper commandMapper) {
        this.commandRepository = commandRepository;
        this.commandMapper = commandMapper;
    }

    /**
     * Save a command.
     *
     * @param commandDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public CommandDTO save(CommandDTO commandDTO) {
        log.debug("Request to save Command : {}", commandDTO);
        Command command = commandMapper.toEntity(commandDTO);
        command = commandRepository.save(command);
        return commandMapper.toDto(command);
    }

    /**
     * Get all the commands.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CommandDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Commands");
        return commandRepository.findAll(pageable)
            .map(commandMapper::toDto);
    }

    /**
     * Get one command by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CommandDTO> findOne(Long id) {
        log.debug("Request to get Command : {}", id);
        return commandRepository.findById(id)
            .map(commandMapper::toDto);
    }

    /**
     * Delete the command by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Command : {}", id);
        commandRepository.deleteById(id);
    }

    @Override
    public Page<CommandDTO> findAllBySearch(Specification<Command> specification, Pageable pageable) {
        return commandRepository.findAll(specification,pageable).map(commandMapper::toDto);
    }

    @Override
    public void deleteIds(List<Long> ids) {
        for (Long id : ids) {
            delete(id);
        }
    }
}
