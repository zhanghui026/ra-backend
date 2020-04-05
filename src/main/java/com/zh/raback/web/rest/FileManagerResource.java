package com.zh.raback.web.rest;

import com.zh.raback.service.FileManagerService;
import com.zh.raback.web.rest.errors.BadRequestAlertException;
import com.zh.raback.service.dto.FileManagerDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.zh.raback.domain.FileManager}.
 */
@RestController
@RequestMapping("/api")
public class FileManagerResource {

    private final Logger log = LoggerFactory.getLogger(FileManagerResource.class);

    private static final String ENTITY_NAME = "fileManager";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FileManagerService fileManagerService;

    public FileManagerResource(FileManagerService fileManagerService) {
        this.fileManagerService = fileManagerService;
    }

    /**
     * {@code POST  /file-managers} : Create a new fileManager.
     *
     * @param fileManagerDTO the fileManagerDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new fileManagerDTO, or with status {@code 400 (Bad Request)} if the fileManager has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/file-managers")
    public ResponseEntity<FileManagerDTO> createFileManager(@Valid @RequestBody FileManagerDTO fileManagerDTO) throws URISyntaxException {
        log.debug("REST request to save FileManager : {}", fileManagerDTO);
        if (fileManagerDTO.getId() != null) {
            throw new BadRequestAlertException("A new fileManager cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FileManagerDTO result = fileManagerService.save(fileManagerDTO);
        return ResponseEntity.created(new URI("/api/file-managers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /file-managers} : Updates an existing fileManager.
     *
     * @param fileManagerDTO the fileManagerDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated fileManagerDTO,
     * or with status {@code 400 (Bad Request)} if the fileManagerDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the fileManagerDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/file-managers")
    public ResponseEntity<FileManagerDTO> updateFileManager(@Valid @RequestBody FileManagerDTO fileManagerDTO) throws URISyntaxException {
        log.debug("REST request to update FileManager : {}", fileManagerDTO);
        if (fileManagerDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        FileManagerDTO result = fileManagerService.save(fileManagerDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, fileManagerDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /file-managers} : get all the fileManagers.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of fileManagers in body.
     */
    @GetMapping("/file-managers")
    public ResponseEntity<List<FileManagerDTO>> getAllFileManagers(Pageable pageable) {
        log.debug("REST request to get a page of FileManagers");
        Page<FileManagerDTO> page = fileManagerService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /file-managers/:id} : get the "id" fileManager.
     *
     * @param id the id of the fileManagerDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the fileManagerDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/file-managers/{id}")
    public ResponseEntity<FileManagerDTO> getFileManager(@PathVariable Long id) {
        log.debug("REST request to get FileManager : {}", id);
        Optional<FileManagerDTO> fileManagerDTO = fileManagerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(fileManagerDTO);
    }

    /**
     * {@code DELETE  /file-managers/:id} : delete the "id" fileManager.
     *
     * @param id the id of the fileManagerDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/file-managers/{id}")
    public ResponseEntity<Void> deleteFileManager(@PathVariable Long id) {
        log.debug("REST request to delete FileManager : {}", id);
        fileManagerService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
