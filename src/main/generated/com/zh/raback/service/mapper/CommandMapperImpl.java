package com.zh.raback.service.mapper;

import com.zh.raback.domain.Command;
import com.zh.raback.service.dto.CommandDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-09T21:43:59+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.3 (Oracle Corporation)"
)
@Component
public class CommandMapperImpl implements CommandMapper {

    @Override
    public Command toEntity(CommandDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Command command = new Command();

        command.setId( dto.getId() );
        command.setReference( dto.getReference() );
        if ( dto.getDate() != null ) {
            command.setDate( Date.from( dto.getDate() ) );
        }
        command.setCustomerId( dto.getCustomerId() );
        command.setBasket( dto.getBasket() );
        command.setTotalExTaxes( dto.getTotalExTaxes() );
        command.setDeliveryFees( dto.getDeliveryFees() );
        command.setTaxRate( dto.getTaxRate() );
        command.setTaxes( dto.getTaxes() );
        command.setTotal( dto.getTotal() );
        command.setStatus( dto.getStatus() );
        command.setReturned( dto.isReturned() );

        return command;
    }

    @Override
    public CommandDTO toDto(Command entity) {
        if ( entity == null ) {
            return null;
        }

        CommandDTO commandDTO = new CommandDTO();

        commandDTO.setId( entity.getId() );
        commandDTO.setReference( entity.getReference() );
        if ( entity.getDate() != null ) {
            commandDTO.setDate( entity.getDate().toInstant() );
        }
        commandDTO.setCustomerId( entity.getCustomerId() );
        commandDTO.setBasket( entity.getBasket() );
        commandDTO.setTotalExTaxes( entity.getTotalExTaxes() );
        commandDTO.setDeliveryFees( entity.getDeliveryFees() );
        commandDTO.setTaxRate( entity.getTaxRate() );
        commandDTO.setTaxes( entity.getTaxes() );
        commandDTO.setTotal( entity.getTotal() );
        commandDTO.setStatus( entity.getStatus() );
        commandDTO.setReturned( entity.isReturned() );

        return commandDTO;
    }

    @Override
    public List<Command> toEntity(List<CommandDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Command> list = new ArrayList<Command>( dtoList.size() );
        for ( CommandDTO commandDTO : dtoList ) {
            list.add( toEntity( commandDTO ) );
        }

        return list;
    }

    @Override
    public List<CommandDTO> toDto(List<Command> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CommandDTO> list = new ArrayList<CommandDTO>( entityList.size() );
        for ( Command command : entityList ) {
            list.add( toDto( command ) );
        }

        return list;
    }
}
