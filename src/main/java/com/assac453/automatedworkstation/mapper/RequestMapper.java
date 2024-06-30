package com.assac453.automatedworkstation.mapper;

import com.assac453.automatedworkstation.dto.RequestDto;
import com.assac453.automatedworkstation.entity.Request;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RequestMapper {
    RequestMapper INSTANCE = Mappers.getMapper(RequestMapper.class);

    Request dtoToEntity(RequestDto requestDto);

    RequestDto entityToDto(Request request);
}
