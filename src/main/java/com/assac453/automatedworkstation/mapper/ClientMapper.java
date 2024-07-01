package com.assac453.automatedworkstation.mapper;

import com.assac453.automatedworkstation.dto.ClientDto;
import com.assac453.automatedworkstation.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDto entityToDto(Client client);

    Client dtoToEntity(ClientDto clientDto);
}
