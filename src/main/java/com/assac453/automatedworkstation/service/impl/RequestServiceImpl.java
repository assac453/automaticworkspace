package com.assac453.automatedworkstation.service.impl;

import com.assac453.automatedworkstation.dto.RequestDto;
import com.assac453.automatedworkstation.dto.request.RequestDtoRequest;
import com.assac453.automatedworkstation.dto.response.RequestClientDtoResponse;
import com.assac453.automatedworkstation.entity.Client;
import com.assac453.automatedworkstation.entity.Contract;
import com.assac453.automatedworkstation.entity.EmploymentInfo;
import com.assac453.automatedworkstation.entity.Request;
import com.assac453.automatedworkstation.mapper.RequestMapper;
import com.assac453.automatedworkstation.repository.RequestRepository;
import com.assac453.automatedworkstation.service.ClientService;
import com.assac453.automatedworkstation.service.ContractService;
import com.assac453.automatedworkstation.service.EmploymentInfoService;
import com.assac453.automatedworkstation.service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
@AllArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;

    private final ClientService clientService;
    private final EmploymentInfoService employmentInfoService;

    private final ContractService contractService;

    private final RequestMapper requestMapper;

    @Override
    public List<RequestDto> findAll() {
        return requestRepository.findAll().stream().map(requestMapper::entityToDto).toList();
    }

    @Override
    public RequestDto findById(int id) {
        return requestMapper.entityToDto(requestRepository.findById(id));
    }

    @Override
    public int create(RequestDto requestDto) {
        return requestRepository.save(requestMapper.dtoToEntity(requestDto));
    }

    @Override
    public void update(RequestDto requestDto, int id) {
        Request request = requestMapper.dtoToEntity(requestDto);
        request.setId(id);
        requestRepository.update(request);
    }

    @Override
    public void delete(int id) {
        requestRepository.delete(id);
    }

    @Override
    public RequestDto serve(RequestDtoRequest requestDtoRequest) {
        Client client = Client.builder()
                .fio(requestDtoRequest.getFio())
                .passport(requestDtoRequest.getPassport())
                .registrationAddress(requestDtoRequest.getRegistrationAddress())
                .contactPhone(requestDtoRequest.getContactPhone())
                .familyStatus(requestDtoRequest.getFamilyStatus())
                .build();

        List<EmploymentInfo> infos = new LinkedList<>();
        for (var item : requestDtoRequest.getEmployments()) {
            EmploymentInfo info = EmploymentInfo.builder()
                    .client(client)
                    .organization(item.getOrganization())
                    .position(item.getPosition())
                    .workPeriod(item.getWorkPeriod())
                    .build();
            infos.add(info);
        }

        Request request = Request.builder()
                .approvedStatus(new Random().nextBoolean())
                .approvedAmount(requestDtoRequest.getRequestAmount())
                .approvedTerm(new Random().nextInt(1, 12) * 30)
                .client(client)
                .build();


        clientService.create(client);
        requestRepository.save(request);
        employmentInfoService.saveAll(infos);
        decisionContract(request);

        return RequestDto.builder()
                .id(request.getId())
                .clientId(client.getId())
                .approvedStatus(request.getApprovedStatus())
                .approvedAmount(request.getApprovedAmount())
                .approvedTerm(request.getApprovedTerm())
                .build();
    }

    @Override
    public List<RequestClientDtoResponse> findAllRequestClients() {
        List<RequestClientDtoResponse> list = new LinkedList<>();
        List<Request> requests = requestRepository.findAll();
        for (Request request : requests) {
            list.add
                    (
                            RequestClientDtoResponse.builder()
                                    .term(request.getApprovedTerm())
                                    .amount(request.getApprovedAmount())
                                    .status(request.getApprovedStatus())
                                    .fio(request.getClient().getFio())
                                    .build()
                    );
        }
        return list;
    }

    private void decisionContract(Request request) {
        if (request.getApprovedStatus()) {
            contractService.save(
                    Contract.builder()
                            .request(request)
                            .signedStatus(false)
                            .build()
            );
        }
    }
}
