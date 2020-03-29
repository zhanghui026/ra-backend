package com.zh.raback.service.mapper;


import com.alibaba.fastjson.JSON;
import com.zh.raback.domain.*;
import com.zh.raback.service.dto.ClientDTO;

import com.zh.raback.web.rest.dto.AddressDTO;
import com.zh.raback.web.rest.dto.CompanyDTO;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.*;
import org.springframework.stereotype.Service;

/**
 * Mapper for the entity {@link Client} and its DTO {@link ClientDTO}.
 */
@Service
@Slf4j
public class ClientMapper {



    public ClientDTO toDto(Client client) {

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setAddress(asAddress(client.getAddress()));
        clientDTO.setCompany(asCompony(client.getCompany()));
        clientDTO.setEmail(client.getEmail());
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setUsername(client.getUsername());
        clientDTO.setWebsite(client.getWebsite());

        return clientDTO;
    }


    public Client toEntity(ClientDTO client) {
        Client clientDTO = new Client();
        clientDTO.setAddress(mapAddress(client.getAddress()));
        clientDTO.setCompany(mapCompony(client.getCompany()));
        clientDTO.setEmail(client.getEmail());
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setUsername(client.getUsername());
        clientDTO.setWebsite(client.getWebsite());
        return clientDTO;

    }
    private String mapAddress(AddressDTO address) {

        return address != null ? JSON.toJSONString(address): null;
    }
    private String mapCompony(CompanyDTO address) {

        return address != null ? JSON.toJSONString(address): null;
    }

    public AddressDTO asAddress(String address){
        try {
            return address != null ? JSON.parseObject(address, AddressDTO.class) : null;
        } catch (Exception e){
            log.error("出现解析Address失败");
        }
        return null;
    }

    public CompanyDTO asCompony(String company){
        try {
            return company != null ? JSON.parseObject(company, CompanyDTO.class) : null;
        } catch (Exception e){
            log.error("出现解析Address失败");
        }
        return null;
    }
}
