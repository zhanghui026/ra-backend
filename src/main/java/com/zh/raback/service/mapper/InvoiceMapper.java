package com.zh.raback.service.mapper;


import com.zh.raback.domain.*;
import com.zh.raback.service.dto.InvoiceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Invoice} and its DTO {@link InvoiceDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface InvoiceMapper extends EntityMapper<InvoiceDTO, Invoice> {
    @Mapping(target = "date",dateFormat = "yyyy-MM-dd")
    @Override
    InvoiceDTO toDto(Invoice entity);

    @Mapping(target = "date",dateFormat = "yyyy-MM-dd")
    @Override
    Invoice toEntity(InvoiceDTO dto);

    default Invoice fromId(Long id) {
        if (id == null) {
            return null;
        }
        Invoice invoice = new Invoice();
        invoice.setId(id);
        return invoice;
    }
}
