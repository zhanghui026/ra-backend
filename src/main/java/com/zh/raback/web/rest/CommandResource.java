package com.zh.raback.web.rest;

import com.google.common.base.Splitter;
import com.zh.raback.domain.Command;
import com.zh.raback.domain.Customer;
import com.zh.raback.service.CommandService;
import com.zh.raback.service.dto.CustomerDTO;
import com.zh.raback.service.dto.ProductDTO;
import com.zh.raback.util.RsqlUtils;
import com.zh.raback.web.rest.errors.BadRequestAlertException;
import com.zh.raback.service.dto.CommandDTO;

import com.zh.raback.web.rest.rsql.CustomRsqlVisitor;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.C;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * REST controller for managing {@link com.zh.raback.domain.Command}.
 */
@RestController
@RequestMapping("/api")
public class CommandResource {

    private final Logger log = LoggerFactory.getLogger(CommandResource.class);

    private static final String ENTITY_NAME = "command";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CommandService commandService;

    public CommandResource(CommandService commandService) {
        this.commandService = commandService;
    }

    /**
     * {@code POST  /commands} : Create a new command.
     *
     * @param commandDTO the commandDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new commandDTO, or with status {@code 400 (Bad Request)} if the command has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/commands")
    public ResponseEntity<CommandDTO> createCommand(@RequestBody CommandDTO commandDTO) throws URISyntaxException {
        log.debug("REST request to save Command : {}", commandDTO);
        if (commandDTO.getId() != null) {
            throw new BadRequestAlertException("A new command cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CommandDTO result = commandService.save(commandDTO);
        return ResponseEntity.created(new URI("/api/commands/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /commands} : Updates an existing command.
     *
     * @param commandDTO the commandDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated commandDTO,
     * or with status {@code 400 (Bad Request)} if the commandDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the commandDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/commands")
    public ResponseEntity<CommandDTO> updateCommand(@RequestBody CommandDTO commandDTO) throws URISyntaxException {
        log.debug("REST request to update Command : {}", commandDTO);
        if (commandDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CommandDTO result = commandService.save(commandDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, commandDTO.getId().toString()))
            .body(result);
    }



    /**
     * {@code GET  /commands/:id} : get the "id" command.
     *
     * @param id the id of the commandDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the commandDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/commands/{id}")
    public ResponseEntity<CommandDTO> getCommand(@PathVariable Long id) {
        log.debug("REST request to get Command : {}", id);
        Optional<CommandDTO> commandDTO = commandService.findOne(id);
        return ResponseUtil.wrapOrNotFound(commandDTO);
    }

    /**
     * {@code DELETE  /commands/:id} : delete the "id" command.
     *
     * @param id the id of the commandDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/commands/{id}")
    public ResponseEntity<Void> deleteCommand(@PathVariable Long id) {
        log.debug("REST request to delete Command : {}", id);
        commandService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code GET  /commands} : get all the commands.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of commands in body.
     */
    @GetMapping("/commands")
    public ResponseEntity<List<CommandDTO>> getAllCommands(@RequestParam(value = "search",required = false) String search,
                                                           @RequestParam(value = "ids",required = false) List<Long> ids,
                                                           Pageable pageable) {
        log.debug("REST request to get a page of Commands");
        if (ids != null) {
            List<CommandDTO> list = commandService.findAllInIds(ids);
            return ResponseEntity.ok().body(list);
        } else if (StringUtils.isNotBlank(search)){

            List<String> qSearchFieldList = new ArrayList<>();
            qSearchFieldList.add("reference");
            Set<String> starFields = new HashSet<>();

            String wrapperSearch = RsqlUtils.search2rsqlStr(search,qSearchFieldList,starFields);

            Node rootNode = new RSQLParser().parse(wrapperSearch);
            Specification<Command> specification = rootNode.accept(new CustomRsqlVisitor<Command>());
            Page<CommandDTO> page = commandService.findAllBySearch(specification, pageable);
            HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
            return ResponseEntity.ok().headers(headers).body(page.getContent());
        } else {

            Page<CommandDTO> page = commandService.findAll(pageable);
            HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
            return ResponseEntity.ok().headers(headers).body(page.getContent());
        }
    }


    /**
     * {@code DELETE  /posts/:id} : delete the "id" post.
     *
     * @param ids the id of the post to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/commands")
    public ResponseEntity<Void> deleteAll(@RequestParam(value = "id") List<Long> ids) {
        log.debug("REST request to delete commands : {}", ids);
        commandService.deleteIds(ids);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, ids.toString())).build();
    }
}
