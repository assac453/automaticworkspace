package com.assac453.automatedworkstation.controller.rest;

import com.assac453.automatedworkstation.dto.request.RequestDtoRequest;
import com.assac453.automatedworkstation.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/request")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @PostMapping
    public void createRequest(@RequestBody RequestDtoRequest requestDtoRequest) {
        requestService.serve(requestDtoRequest);
    }


}
