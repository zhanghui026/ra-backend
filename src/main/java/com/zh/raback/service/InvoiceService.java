package com.zh.raback.service;

import com.zh.raback.domain.Invoice;
import com.zh.raback.service.dto.InvoiceDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.zh.raback.domain.Invoice}.
 */
public interface InvoiceService {

    /**
     * Save a invoice.
     *
     * @param invoiceDTO the entity to save.
     * @return the persisted entity.
     */
    InvoiceDTO save(InvoiceDTO invoiceDTO);

    /**
     * Get all the invoices.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<InvoiceDTO> findAll(Pageable pageable);

    /**
     * Get the "id" invoice.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<InvoiceDTO> findOne(Long id);

    /**
     * Delete the "id" invoice.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    List<InvoiceDTO> findAllInIds(List<Long> ids);

    Page<InvoiceDTO> findAllBySearch(Specification<Invoice> specification, Pageable pageable);

    void deleteIds(List<Long> ids);
}
