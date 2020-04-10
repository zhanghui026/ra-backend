package com.zh.raback.service.mapper;


import com.zh.raback.domain.*;
import com.zh.raback.service.dto.CommandDTO;

import com.zh.raback.util.mapper.BasketElement;
import com.zh.raback.util.mapper.BasketString;
import com.zh.raback.util.mapper.ObjectToStringMapper;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Command} and its DTO {@link CommandDTO}.
 */
@Mapper(componentModel = "spring", uses = {ObjectToStringMapper.class})
public interface CommandMapper extends EntityMapper<CommandDTO, Command> {

    @Mappings({
        @Mapping(target = "date",dateFormat = "yyyy-MM-dd"),
        @Mapping(target = "basket",source = "basket",qualifiedBy = BasketElement.class)
    })
    @Override
    Command toEntity(CommandDTO dto);

    @Mappings({
        @Mapping(target = "date",dateFormat = "yyyy-MM-dd"),
        @Mapping(target = "basket",source = "basket",qualifiedBy = BasketString.class)
    })
    @Override
    CommandDTO toDto(Command entity);

    default Command fromId(Long id) {
        if (id == null) {
            return null;
        }
        Command command = new Command();
        command.setId(id);
        return command;
    }
}
