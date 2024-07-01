package com.assac453.automatedworkstation.mapper;

import com.assac453.automatedworkstation.dto.EmploymentInfoDto;
import com.assac453.automatedworkstation.entity.EmploymentInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmploymentInfoMapper {

    EmploymentInfoDto entityToDto(EmploymentInfo employmentInfo);

    EmploymentInfo dtoToEntity(EmploymentInfoDto employmentInfoDto);

}
