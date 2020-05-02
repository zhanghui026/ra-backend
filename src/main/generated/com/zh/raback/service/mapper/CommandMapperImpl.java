package com.zh.raback.service.mapper;

import com.zh.raback.domain.Command;
import com.zh.raback.service.dto.CommandDTO;
import com.zh.raback.util.mapper.ObjectToStringMapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-02T12:57:25+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.3 (Oracle Corporation)"
)
@Component
public class CommandMapperImpl implements CommandMapper {

    @Autowired
    private ObjectToStringMapper objectToStringMapper;

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

    @Override
    public Command toEntity(CommandDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Command command = new Command();

        command.setBasket( objectToStringMapper.basketToString( dto.getBasket() ) );
        command.setId( dto.getId() );
        command.setReference( dto.getReference() );
        try {
            if ( dto.getDate() != null ) {
                command.setDate( new SimpleDateFormat( "yyyy-MM-dd" ).parse( dto.getDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        command.setCustomerId( dto.getCustomerId() );
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

        commandDTO.setBasket( objectToStringMapper.parseBasket( entity.getBasket() ) );
        commandDTO.setId( entity.getId() );
        commandDTO.setReference( entity.getReference() );
        if ( entity.getDate() != null ) {
            commandDTO.setDate( new SimpleDateFormat( "yyyy-MM-dd" ).format( entity.getDate() ) );
        }
        commandDTO.setCustomerId( entity.getCustomerId() );
        commandDTO.setTotalExTaxes( entity.getTotalExTaxes() );
        commandDTO.setDeliveryFees( entity.getDeliveryFees() );
        commandDTO.setTaxRate( entity.getTaxRate() );
        commandDTO.setTaxes( entity.getTaxes() );
        commandDTO.setTotal( entity.getTotal() );
        commandDTO.setStatus( entity.getStatus() );
        commandDTO.setReturned( entity.isReturned() );

        return commandDTO;
    }
}
