package com.assac453.automatedworkstation.controller.rest;

import com.assac453.automatedworkstation.dto.response.ContractRequestDtoResponse;
import com.assac453.automatedworkstation.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contract")
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;

    @GetMapping
    public List<ContractRequestDtoResponse> getContracts() {
        return contractService.findAllContractRequest();
    }
}
