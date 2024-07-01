package com.assac453.automatedworkstation.service.impl;

import com.assac453.automatedworkstation.dto.ContractDto;
import com.assac453.automatedworkstation.dto.response.ContractClientDtoResponse;
import com.assac453.automatedworkstation.dto.response.ContractRequestDtoResponse;
import com.assac453.automatedworkstation.entity.Contract;
import com.assac453.automatedworkstation.entity.Request;
import com.assac453.automatedworkstation.mapper.ContractMapper;
import com.assac453.automatedworkstation.repository.ContractRepository;
import com.assac453.automatedworkstation.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final ContractMapper contractMapper;

    @Override
    public int save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public void update(ContractDto contractDto, int id) {
        Contract contract = contractMapper.dtoToEntity(contractDto);
        contract.setId(id);
        contractRepository.update(contract);
    }

    @Override
    public void delete(int id) {
        contractRepository.delete(id);
    }

    @Override
    public List<ContractDto> findAll() {
        return contractRepository
                .findAll()
                .stream().map(contractMapper::entityToDto)
                .toList();
    }

    private List<Contract> findAllEntity() {
        return contractRepository.findAll();
    }

    public List<ContractRequestDtoResponse> findAllContractRequest() {
        List<ContractRequestDtoResponse> list = new LinkedList<>();
        List<Contract> contracts = findAllEntity();
        for (Contract contract : contracts) {
            Request request = contract.getRequest();
            list.add
                    (
                            ContractRequestDtoResponse.builder()
                                    .approvedTerm(request.getApprovedTerm())
                                    .approvedAmount(request.getApprovedAmount())
                                    .approvedStatus(request.getApprovedStatus())
                                    .signedDate(contract.getSignedDate())
                                    .signedStatus(contract.getSignedStatus())
                                    .build()
                    );
        }
        return list;
    }

    @Override
    public List<ContractClientDtoResponse> findAllContractClient() {
        List<Contract> contracts = findAllEntity();
        List<ContractClientDtoResponse> list = new LinkedList<>();
        for (Contract contract : contracts) {
            list.add(
                    ContractClientDtoResponse.builder()
                            .id(contract.getId())
                            .fio(
                                    contract
                                            .getRequest()
                                            .getClient()
                                            .getFio()
                            )
                            .signedDate(contract.getSignedDate())
                            .signedStatus(contract.getSignedStatus())
                            .term(contract.getRequest().getApprovedTerm())
                            .amount(contract.getRequest().getApprovedAmount())
                            .status(contract.getRequest().getApprovedStatus())
                            .build()
            );
        }
        return list;
    }

    @Override
    public ContractDto findById(int id) {
        return contractMapper.entityToDto(contractRepository.findById(id));
    }

    @Override
    public List<ContractDto> findBySignedStatus(Boolean signedStatus) {
        return contractRepository
                .findBySignedStatus(signedStatus)
                .stream().map(contractMapper::entityToDto)
                .toList();
    }

    @Override
    public void signContract(int id) {
        Contract byId = contractRepository.findById(id);
        byId.setSignedStatus(true);
        byId.setSignedDate(new Date(System.currentTimeMillis()));
        contractRepository.update(byId);
    }
}
