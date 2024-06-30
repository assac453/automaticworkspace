package com.assac453.automatedworkstation.service;

import com.assac453.automatedworkstation.dto.ContractDto;
import com.assac453.automatedworkstation.dto.response.ContractClientDtoResponse;
import com.assac453.automatedworkstation.dto.response.ContractRequestDtoResponse;
import com.assac453.automatedworkstation.entity.Contract;

import java.util.List;

public interface ContractService {
    int save(Contract contract);

    void update(ContractDto contractDto, int id);

    void delete(int id);

    List<ContractDto> findAll();

    ContractDto findById(int id);

    List<ContractDto> findBySignedStatus(Boolean signedStatus);

    void signContract(int id);

    List<ContractRequestDtoResponse> findAllContractRequest();

    List<ContractClientDtoResponse>findAllContractClient();
}
