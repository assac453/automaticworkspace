package com.assac453.automatedworkstation.mapper;

import com.assac453.automatedworkstation.dto.ClientDto;
import com.assac453.automatedworkstation.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto entityToDto(Client client);

    Client dtoToEntity(ClientDto clientDto);
}
