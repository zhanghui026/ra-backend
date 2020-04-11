package com.zh.raback.service.mapper;

import com.zh.raback.domain.Invoice;
import com.zh.raback.service.dto.InvoiceDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-11T11:20:00+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.3 (Oracle Corporation)"
)
@Component
public class InvoiceMapperImpl implements InvoiceMapper {

    @Override
    public List<Invoice> toEntity(List<InvoiceDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Invoice> list = new ArrayList<Invoice>( arg0.size() );
        for ( InvoiceDTO invoiceDTO : arg0 ) {
            list.add( toEntity( invoiceDTO ) );
        }

        return list;
    }

    @Override
    public List<InvoiceDTO> toDto(List<Invoice> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<InvoiceDTO> list = new ArrayList<InvoiceDTO>( arg0.size() );
        for ( Invoice invoice : arg0 ) {
            list.add( toDto( invoice ) );
        }

        return list;
    }

    @Override
    public InvoiceDTO toDto(Invoice entity) {
        if ( entity == null ) {
            return null;
        }

        InvoiceDTO invoiceDTO = new InvoiceDTO();

        invoiceDTO.setId( entity.getId() );
        if ( entity.getDate() != null ) {
            invoiceDTO.setDate( new SimpleDateFormat( "yyyy-MM-dd" ).format( entity.getDate() ) );
        }
        invoiceDTO.setCustomerId( entity.getCustomerId() );
        invoiceDTO.setCommandId( entity.getCommandId() );
        invoiceDTO.setTotalExTaxes( entity.getTotalExTaxes() );
        invoiceDTO.setDeliveryFees( entity.getDeliveryFees() );
        invoiceDTO.setTaxRate( entity.getTaxRate() );
        invoiceDTO.setTaxes( entity.getTaxes() );
        invoiceDTO.setTotal( entity.getTotal() );

        return invoiceDTO;
    }

    @Override
    public Invoice toEntity(InvoiceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Invoice invoice = new Invoice();

        invoice.setId( dto.getId() );
        try {
            if ( dto.getDate() != null ) {
                invoice.setDate( new SimpleDateFormat( "yyyy-MM-dd" ).parse( dto.getDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        invoice.setCustomerId( dto.getCustomerId() );
        invoice.setCommandId( dto.getCommandId() );
        invoice.setTotalExTaxes( dto.getTotalExTaxes() );
        invoice.setDeliveryFees( dto.getDeliveryFees() );
        invoice.setTaxRate( dto.getTaxRate() );
        invoice.setTaxes( dto.getTaxes() );
        invoice.setTotal( dto.getTotal() );

        return invoice;
    }
}
