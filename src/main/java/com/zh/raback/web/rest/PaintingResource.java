package com.zh.raback.web.rest;

import com.zh.raback.domain.Painting;
import com.zh.raback.service.PaintingService;
import com.zh.raback.util.RsqlUtils;
import com.zh.raback.web.rest.errors.BadRequestAlertException;
import com.zh.raback.service.dto.PaintingDTO;

import com.zh.raback.web.rest.rsql.CustomRsqlVisitor;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.apache.commons.lang3.StringUtils;
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

/**
 * REST controller for managing {@link com.zh.raback.domain.Painting}.
 */
@RestController
@RequestMapping("/api")
public class PaintingResource {

    private final Logger log = LoggerFactory.getLogger(PaintingResource.class);

    private static final String ENTITY_NAME = "painting";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PaintingService paintingService;

    public PaintingResource(PaintingService paintingService) {
        this.paintingService = paintingService;
    }

    /**
     * {@code POST  /paintings} : Create a new painting.
     *
     * @param paintingDTO the paintingDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new paintingDTO, or with status {@code 400 (Bad Request)} if the painting has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/paintings")
    public ResponseEntity<PaintingDTO> createPainting(@RequestBody PaintingDTO paintingDTO) throws URISyntaxException {
        log.debug("REST request to save Painting : {}", paintingDTO);
        if (paintingDTO.getId() != null) {
            throw new BadRequestAlertException("A new painting cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PaintingDTO result = paintingService.save(paintingDTO);
        return ResponseEntity.created(new URI("/api/paintings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /paintings} : Updates an existing painting.
     *
     * @param paintingDTO the paintingDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated paintingDTO,
     * or with status {@code 400 (Bad Request)} if the paintingDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the paintingDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/paintings")
    public ResponseEntity<PaintingDTO> updatePainting(@RequestBody PaintingDTO paintingDTO) throws URISyntaxException {
        log.debug("REST request to update Painting : {}", paintingDTO);
        if (paintingDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PaintingDTO result = paintingService.save(paintingDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, paintingDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /paintings} : get all the paintings.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paintings in body.
     */
    @GetMapping("/paintings")
    public ResponseEntity<List<PaintingDTO>> getAllPaintings(@RequestParam(value = "search", required = false) String search,
                                                             @RequestParam(value = "ids", required = false) List<Long> ids, Pageable pageable) {
        log.debug("REST request to get a page of Paintings");
        if (ids != null) {
            List<PaintingDTO> list = paintingService.findAllInIds(ids);
            return ResponseEntity.ok().body(list);
        } else if (StringUtils.isNotBlank(search)) {
            List<String> qSearchFieldList = new ArrayList<>();
            qSearchFieldList.add("name");
            qSearchFieldList.add("rsName");
            qSearchFieldList.add("enName");
            qSearchFieldList.add("reference");
            qSearchFieldList.add("sentence");
            qSearchFieldList.add("rsSentence");
            qSearchFieldList.add("enSentence");
            qSearchFieldList.add("brief");
            qSearchFieldList.add("rsBrief");
            qSearchFieldList.add("enBrief");
            qSearchFieldList.add("info");
            qSearchFieldList.add("rsArtInfo");
            qSearchFieldList.add("enArtInfo");

            Set<String> starFields = new HashSet<>();
            starFields.add("name");
            starFields.add("rsName");
            starFields.add("enName");
            starFields.add("reference");
            starFields.add("sentence");
            starFields.add("rsSentence");
            starFields.add("enSentence");
            starFields.add("brief");
            starFields.add("rsBrief");
            starFields.add("enBrief");
            starFields.add("info");
            starFields.add("rsArtInfo");
            starFields.add("enArtInfo");

            String wrapperSearch = RsqlUtils.search2rsqlStr(search, qSearchFieldList, starFields);
            Node rootNode = new RSQLParser().parse(wrapperSearch);
            Specification<Painting> specification = rootNode.accept(new CustomRsqlVisitor<Painting>());
            Page<PaintingDTO> page = paintingService.findAllBySearch(specification, pageable);
            HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
            return ResponseEntity.ok().headers(headers).body(page.getContent());
        }

        Page<PaintingDTO> page = paintingService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /paintings/:id} : get the "id" painting.
     *
     * @param id the id of the paintingDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paintingDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/paintings/{id}")
    public ResponseEntity<PaintingDTO> getPainting(@PathVariable Long id) {
        log.debug("REST request to get Painting : {}", id);
        Optional<PaintingDTO> paintingDTO = paintingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paintingDTO);
    }

    /**
     * {@code DELETE  /paintings/:id} : delete the "id" painting.
     *
     * @param id the id of the paintingDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/paintings/{id}")
    public ResponseEntity<Void> deletePainting(@PathVariable Long id) {
        log.debug("REST request to delete Painting : {}", id);
        paintingService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }


    /**
     * {@code DELETE  /paintings} : delete all.
     *
     * @param ids the id of the post to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/paintings")
    public ResponseEntity<Void> deleteAll(@RequestParam(value = "id") List<Long> ids) {
        log.debug("REST request to delete paintings : {}", ids);
        paintingService.deleteIds(ids);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, ids.toString())).build();
    }
}
