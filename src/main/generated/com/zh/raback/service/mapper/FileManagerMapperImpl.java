package com.zh.raback.service.mapper;

import com.zh.raback.domain.FileManager;
import com.zh.raback.service.dto.FileManagerDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-10T22:10:20+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.3 (Oracle Corporation)"
)
@Component
public class FileManagerMapperImpl implements FileManagerMapper {

    @Override
    public FileManager toEntity(FileManagerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        FileManager fileManager = new FileManager();

        fileManager.setId( dto.getId() );
        fileManager.setFileNo( dto.getFileNo() );
        fileManager.setBizCode( dto.getBizCode() );
        fileManager.setDefaultUrl( dto.getDefaultUrl() );
        fileManager.setDefaultPath( dto.getDefaultPath() );
        fileManager.setDefaultFileName( dto.getDefaultFileName() );
        fileManager.setIsImg( dto.isIsImg() );
        fileManager.setSize( dto.getSize() );
        fileManager.setIsThumbnail( dto.isIsThumbnail() );
        fileManager.setIsCommit( dto.isIsCommit() );
        fileManager.setCreateTime( dto.getCreateTime() );
        fileManager.setUpdateTime( dto.getUpdateTime() );

        return fileManager;
    }

    @Override
    public FileManagerDTO toDto(FileManager entity) {
        if ( entity == null ) {
            return null;
        }

        FileManagerDTO fileManagerDTO = new FileManagerDTO();

        fileManagerDTO.setId( entity.getId() );
        fileManagerDTO.setFileNo( entity.getFileNo() );
        fileManagerDTO.setBizCode( entity.getBizCode() );
        fileManagerDTO.setDefaultUrl( entity.getDefaultUrl() );
        fileManagerDTO.setDefaultPath( entity.getDefaultPath() );
        fileManagerDTO.setDefaultFileName( entity.getDefaultFileName() );
        fileManagerDTO.setIsImg( entity.isIsImg() );
        fileManagerDTO.setSize( entity.getSize() );
        fileManagerDTO.setIsThumbnail( entity.isIsThumbnail() );
        fileManagerDTO.setIsCommit( entity.isIsCommit() );
        fileManagerDTO.setCreateTime( entity.getCreateTime() );
        fileManagerDTO.setUpdateTime( entity.getUpdateTime() );

        return fileManagerDTO;
    }

    @Override
    public List<FileManager> toEntity(List<FileManagerDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<FileManager> list = new ArrayList<FileManager>( dtoList.size() );
        for ( FileManagerDTO fileManagerDTO : dtoList ) {
            list.add( toEntity( fileManagerDTO ) );
        }

        return list;
    }

    @Override
    public List<FileManagerDTO> toDto(List<FileManager> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<FileManagerDTO> list = new ArrayList<FileManagerDTO>( entityList.size() );
        for ( FileManager fileManager : entityList ) {
            list.add( toDto( fileManager ) );
        }

        return list;
    }
}
