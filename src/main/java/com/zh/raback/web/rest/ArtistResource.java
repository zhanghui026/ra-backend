package com.zh.raback.web.rest;

import com.zh.raback.domain.Artist;
import com.zh.raback.service.ArtistService;
import com.zh.raback.service.FileManagerService;
import com.zh.raback.service.dto.FileManagerDTO;
import com.zh.raback.util.RsqlUtils;
import com.zh.raback.web.rest.errors.BadRequestAlertException;
import com.zh.raback.service.dto.ArtistDTO;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * REST controller for managing {@link Artist}.
 */
@RestController
@RequestMapping("/api")
public class ArtistResource {

    private final Logger log = LoggerFactory.getLogger(ArtistResource.class);

    private static final String ENTITY_NAME = "artist";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ArtistService artistService;

    private final FileManagerService fileManagerService;

    public ArtistResource(ArtistService artistService,FileManagerService fileManagerService) {
        this.artistService = artistService;
        this.fileManagerService = fileManagerService;
    }

    /**
     * {@code POST  /artists} : Create a new artist.
     *
     * @param artistDTO the artistDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new artistDTO, or with status {@code 400 (Bad Request)} if the artist has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/artists")
    public ResponseEntity<ArtistDTO> createArtist(@RequestBody ArtistDTO artistDTO) throws URISyntaxException {
        log.debug("REST request to save Artist : {}", artistDTO);
        if (artistDTO.getId() != null) {
            throw new BadRequestAlertException("A new artist cannot already have an ID", ENTITY_NAME, "idexists");
        }
        changeImg(artistDTO);
        ArtistDTO result = artistService.save(artistDTO);
        return ResponseEntity.created(new URI("/api/artists/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    private void changeImg(ArtistDTO artistDTO) {
        if (StringUtils.isNotBlank(artistDTO.getImageNo())) {
            Optional<FileManagerDTO> imageNo = fileManagerService.findByFileNo(artistDTO.getImageNo());
            imageNo.ifPresent(file -> {

                artistDTO.setAvatar(file.getDefaultUrl());
            });
        }
    }

    /**
     * {@code PUT  /artists} : Updates an existing artist.
     *
     * @param artistDTO the artistDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated artistDTO,
     * or with status {@code 400 (Bad Request)} if the artistDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the artistDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/artists")
    public ResponseEntity<ArtistDTO> updateArtist(@RequestBody ArtistDTO artistDTO) throws URISyntaxException {
        log.debug("REST request to update Artist : {}", artistDTO);
        if (artistDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        changeImg(artistDTO);

        ArtistDTO result = artistService.save(artistDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, artistDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /artists} : get all the artists.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of artists in body.
     */
    @GetMapping("/artists")
    public ResponseEntity<List<ArtistDTO>> getAllArtists(@RequestParam(value = "search", required = false) String search, @RequestParam(value = "ids", required = false) List<Long> ids,
                                                         Pageable pageable) {
        log.debug("REST request to get a page of Artists");
        if (ids != null) {

            List<ArtistDTO> list = artistService.findAllInIds(ids);
            return ResponseEntity.ok().body(list);
        } else if (StringUtils.isNotBlank(search)) {
            List<String> qSearchFieldList = new ArrayList<>();
            qSearchFieldList.add("name");
            qSearchFieldList.add("rsName");
            qSearchFieldList.add("enName");
            qSearchFieldList.add("sentence");
            qSearchFieldList.add("rsSentence");
            qSearchFieldList.add("enSentence");
            qSearchFieldList.add("brief");
            qSearchFieldList.add("rsBrief");
            qSearchFieldList.add("enBrief");
            qSearchFieldList.add("artInfo");
            qSearchFieldList.add("rsArtInfo");
            qSearchFieldList.add("enArtInfo");


            Set<String> starFields = new HashSet<>();
            starFields.add("name");
            starFields.add("rsName");
            starFields.add("enName");
            starFields.add("sentence");
            starFields.add("rsSentence");
            starFields.add("enSentence");
            starFields.add("brief");
            starFields.add("rsBrief");
            starFields.add("enBrief");
            starFields.add("artInfo");
            starFields.add("rsArtInfo");
            starFields.add("enArtInfo");

            String wrapperSearch = RsqlUtils.search2rsqlStr(search, qSearchFieldList, starFields);
            Node rootNode = new RSQLParser().parse(wrapperSearch);
            Specification<Artist> specification = rootNode.accept(new CustomRsqlVisitor<Artist>());
            Page<ArtistDTO> page = artistService.findAllBySearch(specification, pageable);
            HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
            return ResponseEntity.ok().headers(headers).body(page.getContent());
        } else {
            Page<ArtistDTO> page = artistService.findAll(pageable);
            HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
            return ResponseEntity.ok().headers(headers).body(page.getContent());
        }
    }

    /**
     * {@code GET  /artists/:id} : get the "id" artist.
     *
     * @param id the id of the artistDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the artistDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/artists/{id}")
    public ResponseEntity<ArtistDTO> getArtist(@PathVariable Long id) {
        log.debug("REST request to get Artist : {}", id);
        Optional<ArtistDTO> artistDTO = artistService.findOne(id);
        return ResponseUtil.wrapOrNotFound(artistDTO);
    }

    /**
     * {@code DELETE  /artists/:id} : delete the "id" artist.
     *
     * @param id the id of the artistDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/artists/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        log.debug("REST request to delete Artist : {}", id);
        artistService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }


     /**
          * {@code DELETE  /artists} : delete all.
          *
          * @param ids the id of the post to delete.
          * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
          */
         @DeleteMapping("/artists")
         public ResponseEntity<Void> deleteAll(@RequestParam(value = "id") List<Long> ids) {
             log.debug("REST request to delete artists : {}", ids);
             artistService.deleteIds(ids);
             return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, ids.toString())).build();
         }
}
