package com.assac453.automatedworkstation.mapper;

import com.assac453.automatedworkstation.dto.EmploymentInfoDto;
import com.assac453.automatedworkstation.entity.EmploymentInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmploymentInfoMapper {
    EmploymentInfoMapper INSTANCE = Mappers.getMapper(EmploymentInfoMapper.class);

    EmploymentInfoDto entityToDto(EmploymentInfo employmentInfo);

    EmploymentInfo dtoToEntity(EmploymentInfoDto employmentInfoDto);

}
