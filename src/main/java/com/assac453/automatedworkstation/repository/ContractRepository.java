package com.assac453.automatedworkstation.repository;

import com.assac453.automatedworkstation.entity.Contract;

import java.util.List;

public interface ContractRepository {
    int save(Contract contract);

    Contract findById(Integer id);

    List<Contract> findAll();

    List<Contract> findBySignedStatus(Boolean signedStatus);

    void update(Contract contract);

    void delete(int id);
}
