package com.zh.raback.service.mapper;

import com.zh.raback.domain.Museum;
import com.zh.raback.service.dto.MuseumDTO;
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
public class MuseumMapperImpl implements MuseumMapper {

    @Override
    public Museum toEntity(MuseumDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Museum museum = new Museum();

        museum.setId( dto.getId() );
        museum.setName( dto.getName() );
        museum.setRsName( dto.getRsName() );
        museum.setEnName( dto.getEnName() );
        museum.setFullName( dto.getFullName() );
        museum.setRsFullName( dto.getRsFullName() );
        museum.setEnFullName( dto.getEnFullName() );
        museum.setAddress( dto.getAddress() );
        museum.setRsAddress( dto.getRsAddress() );
        museum.setEnAddress( dto.getEnAddress() );
        museum.setBrief( dto.getBrief() );
        museum.setEnBrief( dto.getEnBrief() );
        museum.setRsBrief( dto.getRsBrief() );
        museum.setPhoneNum( dto.getPhoneNum() );
        museum.setContactPerson( dto.getContactPerson() );
        museum.setCreateDate( dto.getCreateDate() );
        museum.setUpdateDate( dto.getUpdateDate() );
        museum.setMainImg( dto.getMainImg() );

        return museum;
    }

    @Override
    public MuseumDTO toDto(Museum entity) {
        if ( entity == null ) {
            return null;
        }

        MuseumDTO museumDTO = new MuseumDTO();

        museumDTO.setId( entity.getId() );
        museumDTO.setName( entity.getName() );
        museumDTO.setRsName( entity.getRsName() );
        museumDTO.setEnName( entity.getEnName() );
        museumDTO.setFullName( entity.getFullName() );
        museumDTO.setRsFullName( entity.getRsFullName() );
        museumDTO.setEnFullName( entity.getEnFullName() );
        museumDTO.setAddress( entity.getAddress() );
        museumDTO.setRsAddress( entity.getRsAddress() );
        museumDTO.setEnAddress( entity.getEnAddress() );
        museumDTO.setBrief( entity.getBrief() );
        museumDTO.setEnBrief( entity.getEnBrief() );
        museumDTO.setRsBrief( entity.getRsBrief() );
        museumDTO.setPhoneNum( entity.getPhoneNum() );
        museumDTO.setContactPerson( entity.getContactPerson() );
        museumDTO.setCreateDate( entity.getCreateDate() );
        museumDTO.setUpdateDate( entity.getUpdateDate() );
        museumDTO.setMainImg( entity.getMainImg() );

        return museumDTO;
    }

    @Override
    public List<Museum> toEntity(List<MuseumDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Museum> list = new ArrayList<Museum>( dtoList.size() );
        for ( MuseumDTO museumDTO : dtoList ) {
            list.add( toEntity( museumDTO ) );
        }

        return list;
    }

    @Override
    public List<MuseumDTO> toDto(List<Museum> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<MuseumDTO> list = new ArrayList<MuseumDTO>( entityList.size() );
        for ( Museum museum : entityList ) {
            list.add( toDto( museum ) );
        }

        return list;
    }
}
