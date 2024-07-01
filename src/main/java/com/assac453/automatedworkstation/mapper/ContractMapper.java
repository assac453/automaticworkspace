package com.assac453.automatedworkstation.mapper;

import com.assac453.automatedworkstation.dto.ContractDto;
import com.assac453.automatedworkstation.entity.Contract;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContractMapper {
    Contract dtoToEntity(ContractDto contractDto);

    ContractDto entityToDto(Contract contract);
}
