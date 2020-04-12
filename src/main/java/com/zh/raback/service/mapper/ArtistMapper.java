package com.zh.raback.service.mapper;


import com.zh.raback.domain.*;
import com.zh.raback.service.dto.ArtistDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Artist} and its DTO {@link ArtistDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ArtistMapper extends EntityMapper<ArtistDTO, Artist> {



    default Artist fromId(Long id) {
        if (id == null) {
            return null;
        }
        Artist artist = new Artist();
        artist.setId(id);
        return artist;
    }
}
