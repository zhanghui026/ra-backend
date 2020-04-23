package com.zh.raback.web.rest;

import com.zh.raback.service.MuseumService;
import com.zh.raback.web.rest.errors.BadRequestAlertException;
import com.zh.raback.service.dto.MuseumDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.zh.raback.domain.Museum}.
 */
@RestController
@RequestMapping("/api")
public class MuseumResource {

    private final Logger log = LoggerFactory.getLogger(MuseumResource.class);

    private static final String ENTITY_NAME = "museum";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MuseumService museumService;

    public MuseumResource(MuseumService museumService) {
        this.museumService = museumService;
    }

    /**
     * {@code POST  /museums} : Create a new museum.
     *
     * @param museumDTO the museumDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new museumDTO, or with status {@code 400 (Bad Request)} if the museum has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/museums")
    public ResponseEntity<MuseumDTO> createMuseum(@Valid @RequestBody MuseumDTO museumDTO) throws URISyntaxException {
        log.debug("REST request to save Museum : {}", museumDTO);
        if (museumDTO.getId() != null) {
            throw new BadRequestAlertException("A new museum cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MuseumDTO result = museumService.save(museumDTO);
        return ResponseEntity.created(new URI("/api/museums/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /museums} : Updates an existing museum.
     *
     * @param museumDTO the museumDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated museumDTO,
     * or with status {@code 400 (Bad Request)} if the museumDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the museumDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/museums")
    public ResponseEntity<MuseumDTO> updateMuseum(@Valid @RequestBody MuseumDTO museumDTO) throws URISyntaxException {
        log.debug("REST request to update Museum : {}", museumDTO);
        if (museumDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MuseumDTO result = museumService.save(museumDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, museumDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /museums} : get all the museums.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of museums in body.
     */
    @GetMapping("/museums")
    public List<MuseumDTO> getAllMuseums(@RequestParam(value = "search",required = false) String search, Pageable pageable) {
        log.debug("REST request to get all Museums");
        return museumService.findAll();
    }

    /**
     * {@code GET  /museums/:id} : get the "id" museum.
     *
     * @param id the id of the museumDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the museumDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/museums/{id}")
    public ResponseEntity<MuseumDTO> getMuseum(@PathVariable Long id) {
        log.debug("REST request to get Museum : {}", id);
        Optional<MuseumDTO> museumDTO = museumService.findOne(id);
        return ResponseUtil.wrapOrNotFound(museumDTO);
    }

    /**
     * {@code DELETE  /museums/:id} : delete the "id" museum.
     *
     * @param id the id of the museumDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/museums/{id}")
    public ResponseEntity<Void> deleteMuseum(@PathVariable Long id) {
        log.debug("REST request to delete Museum : {}", id);
        museumService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
