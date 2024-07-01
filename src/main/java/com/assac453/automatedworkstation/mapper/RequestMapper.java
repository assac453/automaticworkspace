package com.assac453.automatedworkstation.mapper;

import com.assac453.automatedworkstation.dto.RequestDto;
import com.assac453.automatedworkstation.entity.Request;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequestMapper {

    Request dtoToEntity(RequestDto requestDto);

    RequestDto entityToDto(Request request);
}
