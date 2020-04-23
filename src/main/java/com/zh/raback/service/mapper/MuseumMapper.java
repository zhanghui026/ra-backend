package com.zh.raback.service.mapper;


import com.zh.raback.domain.*;
import com.zh.raback.service.dto.MuseumDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Museum} and its DTO {@link MuseumDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MuseumMapper extends EntityMapper<MuseumDTO, Museum> {



    default Museum fromId(Long id) {
        if (id == null) {
            return null;
        }
        Museum museum = new Museum();
        museum.setId(id);
        return museum;
    }
}
