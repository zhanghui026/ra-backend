package com.zh.raback.service.mapper;


import com.zh.raback.domain.*;
import com.zh.raback.service.dto.PaintingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Painting} and its DTO {@link PaintingDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PaintingMapper extends EntityMapper<PaintingDTO, Painting> {



    default Painting fromId(Long id) {
        if (id == null) {
            return null;
        }
        Painting painting = new Painting();
        painting.setId(id);
        return painting;
    }
}
