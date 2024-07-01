package com.assac453.automatedworkstation.service;

import com.assac453.automatedworkstation.dto.EmploymentInfoDto;
import com.assac453.automatedworkstation.entity.EmploymentInfo;

import java.util.List;

public interface EmploymentInfoService {
    int save(EmploymentInfoDto employmentInfoDto);

    EmploymentInfoDto findById(int id);

    List<EmploymentInfoDto> findAll();

    void update(EmploymentInfoDto employmentInfoDto, int id);

    void delete(int id);

    void saveAll(List<EmploymentInfo> infos);

    List<EmploymentInfoDto> findByClientId(int clientId);
}