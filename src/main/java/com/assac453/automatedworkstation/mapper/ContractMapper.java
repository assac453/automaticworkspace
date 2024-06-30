package com.assac453.automatedworkstation.mapper;

import com.assac453.automatedworkstation.dto.ContractDto;
import com.assac453.automatedworkstation.entity.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContractMapper {
    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    Contract dtoToEntity(ContractDto contractDto);

    ContractDto entityToDto(Contract contract);
}
