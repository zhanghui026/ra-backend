package com.zh.raback.service.mapper;


import com.zh.raback.domain.*;
import com.zh.raback.service.dto.CommandDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Command} and its DTO {@link CommandDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CommandMapper extends EntityMapper<CommandDTO, Command> {



    default Command fromId(Long id) {
        if (id == null) {
            return null;
        }
        Command command = new Command();
        command.setId(id);
        return command;
    }
}
