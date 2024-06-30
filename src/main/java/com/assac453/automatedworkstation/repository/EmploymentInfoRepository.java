package com.assac453.automatedworkstation.repository;

import com.assac453.automatedworkstation.entity.EmploymentInfo;

import java.util.List;

public interface EmploymentInfoRepository {
    int save(EmploymentInfo employmentInfo);

    EmploymentInfo findById(Integer id);

    List<EmploymentInfo> findAll();

    void update(EmploymentInfo employmentInfo);

    void delete(int id);

    void saveAll(List<EmploymentInfo> infos);
}
