package com.zh.raback.service.dto;

import com.zh.raback.web.rest.dto.AddressDTO;
import com.zh.raback.web.rest.dto.CompanyDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.zh.raback.domain.Client} entity.
 */
@ApiModel(description = "The Client entity.\n@author A true hipster")
@Data
public class ClientDTO implements Serializable {

    private Long id;

    private String name;

    private String username;

    private String email;

    private AddressDTO address;

    private String phone;

    private String website;

    private CompanyDTO company;



}
