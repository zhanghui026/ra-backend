package com.zh.raback.service.mapper;

import com.zh.raback.domain.Artist;
import com.zh.raback.service.dto.ArtistDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-02T12:57:25+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.3 (Oracle Corporation)"
)
@Component
public class ArtistMapperImpl implements ArtistMapper {

    @Override
    public Artist toEntity(ArtistDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Artist artist = new Artist();

        artist.setId( dto.getId() );
        artist.setName( dto.getName() );
        artist.setRsName( dto.getRsName() );
        artist.setEnName( dto.getEnName() );
        artist.setAvatar( dto.getAvatar() );
        artist.setCitizenship( dto.getCitizenship() );
        artist.setBornAge( dto.getBornAge() );
        artist.setSentence( dto.getSentence() );
        artist.setRsSentence( dto.getRsSentence() );
        artist.setEnSentence( dto.getEnSentence() );
        artist.setBrief( dto.getBrief() );
        artist.setRsBrief( dto.getRsBrief() );
        artist.setEnBrief( dto.getEnBrief() );
        artist.setArtInfo( dto.getArtInfo() );
        artist.setRsArtInfo( dto.getRsArtInfo() );
        artist.setEnArtInfo( dto.getEnArtInfo() );
        artist.setCreateDate( dto.getCreateDate() );
        artist.setUpdateDate( dto.getUpdateDate() );

        return artist;
    }

    @Override
    public ArtistDTO toDto(Artist entity) {
        if ( entity == null ) {
            return null;
        }

        ArtistDTO artistDTO = new ArtistDTO();

        artistDTO.setId( entity.getId() );
        artistDTO.setName( entity.getName() );
        artistDTO.setRsName( entity.getRsName() );
        artistDTO.setEnName( entity.getEnName() );
        artistDTO.setAvatar( entity.getAvatar() );
        artistDTO.setCitizenship( entity.getCitizenship() );
        artistDTO.setBornAge( entity.getBornAge() );
        artistDTO.setSentence( entity.getSentence() );
        artistDTO.setRsSentence( entity.getRsSentence() );
        artistDTO.setEnSentence( entity.getEnSentence() );
        artistDTO.setBrief( entity.getBrief() );
        artistDTO.setRsBrief( entity.getRsBrief() );
        artistDTO.setEnBrief( entity.getEnBrief() );
        artistDTO.setArtInfo( entity.getArtInfo() );
        artistDTO.setRsArtInfo( entity.getRsArtInfo() );
        artistDTO.setEnArtInfo( entity.getEnArtInfo() );
        artistDTO.setCreateDate( entity.getCreateDate() );
        artistDTO.setUpdateDate( entity.getUpdateDate() );

        return artistDTO;
    }

    @Override
    public List<Artist> toEntity(List<ArtistDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Artist> list = new ArrayList<Artist>( dtoList.size() );
        for ( ArtistDTO artistDTO : dtoList ) {
            list.add( toEntity( artistDTO ) );
        }

        return list;
    }

    @Override
    public List<ArtistDTO> toDto(List<Artist> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ArtistDTO> list = new ArrayList<ArtistDTO>( entityList.size() );
        for ( Artist artist : entityList ) {
            list.add( toDto( artist ) );
        }

        return list;
    }
}
