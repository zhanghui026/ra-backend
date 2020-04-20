package com.zh.raback.service.mapper;

import com.zh.raback.domain.Painting;
import com.zh.raback.service.dto.PaintingDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-18T22:53:02+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.3 (Oracle Corporation)"
)
@Component
public class PaintingMapperImpl implements PaintingMapper {

    @Override
    public Painting toEntity(PaintingDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Painting painting = new Painting();

        painting.setId( dto.getId() );
        painting.setName( dto.getName() );
        painting.setRsName( dto.getRsName() );
        painting.setEnName( dto.getEnName() );
        painting.setArtistId( dto.getArtistId() );
        painting.setMaterialId( dto.getMaterialId() );
        painting.setArtTypeId( dto.getArtTypeId() );
        painting.setMuseumId( dto.getMuseumId() );
        painting.setAge( dto.getAge() );
        painting.setTags( dto.getTags() );
        painting.setWidth( dto.getWidth() );
        painting.setHeight( dto.getHeight() );
        painting.setRawImg( dto.getRawImg() );
        painting.setWebImg( dto.getWebImg() );
        painting.setThumbnailImg( dto.getThumbnailImg() );
        painting.setPin( dto.getPin() );
        painting.setPinImg( dto.getPinImg() );
        painting.setReference( dto.getReference() );
        painting.setCategoryStatusId( dto.getCategoryStatusId() );
        painting.setSentence( dto.getSentence() );
        painting.setRsSentence( dto.getRsSentence() );
        painting.setEnSentence( dto.getEnSentence() );
        painting.setBrief( dto.getBrief() );
        painting.setRsBrief( dto.getRsBrief() );
        painting.setEnBrief( dto.getEnBrief() );
        painting.setInfo( dto.getInfo() );
        painting.setRsArtInfo( dto.getRsArtInfo() );
        painting.setEnArtInfo( dto.getEnArtInfo() );
        painting.setRating( dto.getRating() );
        painting.setCreateDate( dto.getCreateDate() );
        painting.setUpdateDate( dto.getUpdateDate() );
        painting.setUseArtistInfo( dto.isUseArtistInfo() );

        return painting;
    }

    @Override
    public PaintingDTO toDto(Painting entity) {
        if ( entity == null ) {
            return null;
        }

        PaintingDTO paintingDTO = new PaintingDTO();

        paintingDTO.setId( entity.getId() );
        paintingDTO.setName( entity.getName() );
        paintingDTO.setRsName( entity.getRsName() );
        paintingDTO.setEnName( entity.getEnName() );
        paintingDTO.setArtistId( entity.getArtistId() );
        paintingDTO.setMaterialId( entity.getMaterialId() );
        paintingDTO.setArtTypeId( entity.getArtTypeId() );
        paintingDTO.setMuseumId( entity.getMuseumId() );
        paintingDTO.setAge( entity.getAge() );
        paintingDTO.setTags( entity.getTags() );
        paintingDTO.setWidth( entity.getWidth() );
        paintingDTO.setHeight( entity.getHeight() );
        paintingDTO.setRawImg( entity.getRawImg() );
        paintingDTO.setWebImg( entity.getWebImg() );
        paintingDTO.setThumbnailImg( entity.getThumbnailImg() );
        paintingDTO.setPin( entity.getPin() );
        paintingDTO.setPinImg( entity.getPinImg() );
        paintingDTO.setReference( entity.getReference() );
        paintingDTO.setCategoryStatusId( entity.getCategoryStatusId() );
        paintingDTO.setSentence( entity.getSentence() );
        paintingDTO.setRsSentence( entity.getRsSentence() );
        paintingDTO.setEnSentence( entity.getEnSentence() );
        paintingDTO.setBrief( entity.getBrief() );
        paintingDTO.setRsBrief( entity.getRsBrief() );
        paintingDTO.setEnBrief( entity.getEnBrief() );
        paintingDTO.setInfo( entity.getInfo() );
        paintingDTO.setRsArtInfo( entity.getRsArtInfo() );
        paintingDTO.setEnArtInfo( entity.getEnArtInfo() );
        paintingDTO.setRating( entity.getRating() );
        paintingDTO.setCreateDate( entity.getCreateDate() );
        paintingDTO.setUpdateDate( entity.getUpdateDate() );
        paintingDTO.setUseArtistInfo( entity.isUseArtistInfo() );

        return paintingDTO;
    }

    @Override
    public List<Painting> toEntity(List<PaintingDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Painting> list = new ArrayList<Painting>( dtoList.size() );
        for ( PaintingDTO paintingDTO : dtoList ) {
            list.add( toEntity( paintingDTO ) );
        }

        return list;
    }

    @Override
    public List<PaintingDTO> toDto(List<Painting> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PaintingDTO> list = new ArrayList<PaintingDTO>( entityList.size() );
        for ( Painting painting : entityList ) {
            list.add( toDto( painting ) );
        }

        return list;
    }
}
