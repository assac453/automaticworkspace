package com.assac453.automatedworkstation.service;

import com.assac453.automatedworkstation.dto.RequestDto;
import com.assac453.automatedworkstation.dto.request.RequestDtoRequest;
import com.assac453.automatedworkstation.dto.response.RequestClientDtoResponse;

import java.util.List;

public interface RequestService {
    List<RequestDto> findAll();

    RequestDto findById(int id);

    int create(RequestDto request);

    void update(RequestDto request, int id);

    void delete(int id);

    void serve(RequestDtoRequest requestDtoRequest);

    boolean isApproved(Integer id);
    RequestDto isApproved(String pass);
    List<RequestClientDtoResponse> findAllRequestClients();
}