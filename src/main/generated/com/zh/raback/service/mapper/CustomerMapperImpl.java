package com.zh.raback.service.mapper;

import com.zh.raback.domain.Customer;
import com.zh.raback.service.dto.CustomerDTO;
import com.zh.raback.util.mapper.IterableNonInterableUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-09T21:43:59+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.3 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Autowired
    private IterableNonInterableUtil iterableNonInterableUtil;

    @Override
    public List<Customer> toEntity(List<CustomerDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( dtoList.size() );
        for ( CustomerDTO customerDTO : dtoList ) {
            list.add( toEntity( customerDTO ) );
        }

        return list;
    }

    @Override
    public List<CustomerDTO> toDto(List<Customer> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CustomerDTO> list = new ArrayList<CustomerDTO>( entityList.size() );
        for ( Customer customer : entityList ) {
            list.add( toDto( customer ) );
        }

        return list;
    }

    @Override
    public Customer toEntity(CustomerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setGroups( iterableNonInterableUtil.join( dto.getGroups() ) );
        customer.setId( dto.getId() );
        customer.setFirstName( dto.getFirstName() );
        customer.setLastName( dto.getLastName() );
        customer.setEmail( dto.getEmail() );
        customer.setAddress( dto.getAddress() );
        customer.setZipcode( dto.getZipcode() );
        customer.setCity( dto.getCity() );
        customer.setAvatar( dto.getAvatar() );
        try {
            if ( dto.getBirthday() != null ) {
                customer.setBirthday( new SimpleDateFormat( "yyyy-MM-dd" ).parse( dto.getBirthday() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        try {
            if ( dto.getFirstSeen() != null ) {
                customer.setFirstSeen( new SimpleDateFormat( "yyyy-MM-dd" ).parse( dto.getFirstSeen() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        try {
            if ( dto.getLastSeen() != null ) {
                customer.setLastSeen( new SimpleDateFormat( "yyyy-MM-dd" ).parse( dto.getLastSeen() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        customer.setHasOrdered( dto.isHasOrdered() );
        try {
            if ( dto.getLatestPurchase() != null ) {
                customer.setLatestPurchase( new SimpleDateFormat( "yyyy-MM-dd" ).parse( dto.getLatestPurchase() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        customer.setHasNewsletter( dto.isHasNewsletter() );
        customer.setNbCommands( dto.getNbCommands() );
        if ( dto.getTotalSpend() != null ) {
            customer.setTotalSpend( dto.getTotalSpend().floatValue() );
        }

        return customer;
    }

    @Override
    public CustomerDTO toDto(Customer entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setGroups( iterableNonInterableUtil.split( entity.getGroups() ) );
        customerDTO.setId( entity.getId() );
        customerDTO.setFirstName( entity.getFirstName() );
        customerDTO.setLastName( entity.getLastName() );
        customerDTO.setEmail( entity.getEmail() );
        customerDTO.setAddress( entity.getAddress() );
        customerDTO.setZipcode( entity.getZipcode() );
        customerDTO.setCity( entity.getCity() );
        customerDTO.setAvatar( entity.getAvatar() );
        if ( entity.getBirthday() != null ) {
            customerDTO.setBirthday( new SimpleDateFormat( "yyyy-MM-dd" ).format( entity.getBirthday() ) );
        }
        if ( entity.getFirstSeen() != null ) {
            customerDTO.setFirstSeen( new SimpleDateFormat( "yyyy-MM-dd" ).format( entity.getFirstSeen() ) );
        }
        if ( entity.getLastSeen() != null ) {
            customerDTO.setLastSeen( new SimpleDateFormat( "yyyy-MM-dd" ).format( entity.getLastSeen() ) );
        }
        customerDTO.setHasOrdered( entity.isHasOrdered() );
        if ( entity.getLatestPurchase() != null ) {
            customerDTO.setLatestPurchase( new SimpleDateFormat( "yyyy-MM-dd" ).format( entity.getLatestPurchase() ) );
        }
        customerDTO.setHasNewsletter( entity.isHasNewsletter() );
        customerDTO.setNbCommands( entity.getNbCommands() );
        if ( entity.getTotalSpend() != null ) {
            customerDTO.setTotalSpend( entity.getTotalSpend().intValue() );
        }

        return customerDTO;
    }
}
