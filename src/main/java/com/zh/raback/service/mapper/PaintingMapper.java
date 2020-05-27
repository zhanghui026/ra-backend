package com.zh.raback.service.mapper;


import com.zh.raback.domain.*;
import com.zh.raback.service.dto.PaintingDTO;

import com.zh.raback.util.mapper.IterableNonInterableUtil;
import com.zh.raback.util.mapper.JoinElement;
import com.zh.raback.util.mapper.SplitElement;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Painting} and its DTO {@link PaintingDTO}.
 */
@Mapper(componentModel = "spring", uses = {IterableNonInterableUtil.class})
public interface PaintingMapper extends EntityMapper<PaintingDTO, Painting> {



    @Mappings({
        @Mapping(target = "tags",source = "tags", qualifiedBy = SplitElement.class),
        @Mapping(target = "imageNo",ignore = true)

    })
    @Override
    PaintingDTO toDto(Painting entity);


    @Mappings({
        @Mapping(target = "tags",source = "tags", qualifiedBy = JoinElement.class)
    })
    @Override
    Painting toEntity(PaintingDTO dto);

    default Painting fromId(Long id) {
        if (id == null) {
            return null;
        }
        Painting painting = new Painting();
        painting.setId(id);
        return painting;
    }
}
