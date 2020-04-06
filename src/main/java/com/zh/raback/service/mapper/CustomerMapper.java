package com.zh.raback.service.mapper;


import com.google.common.base.Splitter;
import com.zh.raback.domain.*;
import com.zh.raback.service.dto.CustomerDTO;

import com.zh.raback.util.mapper.IterableNonInterableUtil;
import com.zh.raback.util.mapper.JoinElement;
import com.zh.raback.util.mapper.SplitElement;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for the entity {@link Customer} and its DTO {@link CustomerDTO}.
 */
@Mapper(componentModel = "spring", uses = {IterableNonInterableUtil.class})
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {


    @Mappings({
        @Mapping(target = "groups",source = "groups", qualifiedBy = JoinElement.class)
    })
    @Override
    Customer toEntity(CustomerDTO dto);


    @Mappings({
        @Mapping(target = "groups",source = "groups", qualifiedBy = SplitElement.class)
    })
    @Override
    CustomerDTO toDto(Customer entity);

    default Customer fromId(Long id) {
        if (id == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(id);
        return customer;
    }


}
