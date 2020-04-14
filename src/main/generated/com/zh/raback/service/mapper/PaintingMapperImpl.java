package com.zh.raback.service.mapper;

import com.zh.raback.domain.Painting;
import com.zh.raback.service.dto.PaintingDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-15T03:23:06+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.3 (Oracle Corporation)"
)
@Component
public class PaintingMapperImpl implements PaintingMapper {

    @Override
    public Painting toEntity(PaintingDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Painting painting = new Painting();

        painting.setId( arg0.getId() );
        painting.setName( arg0.getName() );
        painting.setRsName( arg0.getRsName() );
        painting.setEnName( arg0.getEnName() );
        painting.setArtistId( arg0.getArtistId() );
        painting.setMaterialId( arg0.getMaterialId() );
        painting.setArtTypeId( arg0.getArtTypeId() );
        painting.setMuseumId( arg0.getMuseumId() );
        painting.setAge( arg0.getAge() );
        painting.setTags( arg0.getTags() );
        painting.setWidth( arg0.getWidth() );
        painting.setHeight( arg0.getHeight() );
        painting.setRawImg( arg0.getRawImg() );
        painting.setWebImg( arg0.getWebImg() );
        painting.setThumbnailImg( arg0.getThumbnailImg() );
        painting.setPin( arg0.getPin() );
        painting.setPinImg( arg0.getPinImg() );
        painting.setReference( arg0.getReference() );
        painting.setCategoryStatusId( arg0.getCategoryStatusId() );
        painting.setSentence( arg0.getSentence() );
        painting.setRsSentence( arg0.getRsSentence() );
        painting.setEnSentence( arg0.getEnSentence() );
        painting.setBrief( arg0.getBrief() );
        painting.setRsBrief( arg0.getRsBrief() );
        painting.setEnBrief( arg0.getEnBrief() );
        painting.setInfo( arg0.getInfo() );
        painting.setRsArtInfo( arg0.getRsArtInfo() );
        painting.setEnArtInfo( arg0.getEnArtInfo() );
        painting.setRating( arg0.getRating() );
        painting.setCreateDate( arg0.getCreateDate() );
        painting.setUpdateDate( arg0.getUpdateDate() );
        painting.setUseArtistInfo( arg0.isUseArtistInfo() );

        return painting;
    }

    @Override
    public PaintingDTO toDto(Painting arg0) {
        if ( arg0 == null ) {
            return null;
        }

        PaintingDTO paintingDTO = new PaintingDTO();

        paintingDTO.setId( arg0.getId() );
        paintingDTO.setName( arg0.getName() );
        paintingDTO.setRsName( arg0.getRsName() );
        paintingDTO.setEnName( arg0.getEnName() );
        paintingDTO.setArtistId( arg0.getArtistId() );
        paintingDTO.setMaterialId( arg0.getMaterialId() );
        paintingDTO.setArtTypeId( arg0.getArtTypeId() );
        paintingDTO.setMuseumId( arg0.getMuseumId() );
        paintingDTO.setAge( arg0.getAge() );
        paintingDTO.setTags( arg0.getTags() );
        paintingDTO.setWidth( arg0.getWidth() );
        paintingDTO.setHeight( arg0.getHeight() );
        paintingDTO.setRawImg( arg0.getRawImg() );
        paintingDTO.setWebImg( arg0.getWebImg() );
        paintingDTO.setThumbnailImg( arg0.getThumbnailImg() );
        paintingDTO.setPin( arg0.getPin() );
        paintingDTO.setPinImg( arg0.getPinImg() );
        paintingDTO.setReference( arg0.getReference() );
        paintingDTO.setCategoryStatusId( arg0.getCategoryStatusId() );
        paintingDTO.setSentence( arg0.getSentence() );
        paintingDTO.setRsSentence( arg0.getRsSentence() );
        paintingDTO.setEnSentence( arg0.getEnSentence() );
        paintingDTO.setBrief( arg0.getBrief() );
        paintingDTO.setRsBrief( arg0.getRsBrief() );
        paintingDTO.setEnBrief( arg0.getEnBrief() );
        paintingDTO.setInfo( arg0.getInfo() );
        paintingDTO.setRsArtInfo( arg0.getRsArtInfo() );
        paintingDTO.setEnArtInfo( arg0.getEnArtInfo() );
        paintingDTO.setRating( arg0.getRating() );
        paintingDTO.setCreateDate( arg0.getCreateDate() );
        paintingDTO.setUpdateDate( arg0.getUpdateDate() );
        paintingDTO.setUseArtistInfo( arg0.isUseArtistInfo() );

        return paintingDTO;
    }

    @Override
    public List<Painting> toEntity(List<PaintingDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Painting> list = new ArrayList<Painting>( arg0.size() );
        for ( PaintingDTO paintingDTO : arg0 ) {
            list.add( toEntity( paintingDTO ) );
        }

        return list;
    }

    @Override
    public List<PaintingDTO> toDto(List<Painting> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<PaintingDTO> list = new ArrayList<PaintingDTO>( arg0.size() );
        for ( Painting painting : arg0 ) {
            list.add( toDto( painting ) );
        }

        return list;
    }
}
