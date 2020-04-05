package com.zh.raback.service.mapper;


import com.zh.raback.domain.*;
import com.zh.raback.service.dto.FileManagerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link FileManager} and its DTO {@link FileManagerDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FileManagerMapper extends EntityMapper<FileManagerDTO, FileManager> {



    default FileManager fromId(Long id) {
        if (id == null) {
            return null;
        }
        FileManager fileManager = new FileManager();
        fileManager.setId(id);
        return fileManager;
    }
}
