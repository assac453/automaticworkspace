package com.assac453.automatedworkstation.controller.mvc;

import com.assac453.automatedworkstation.dto.RequestDto;
import com.assac453.automatedworkstation.dto.request.RequestDtoRequest;
import com.assac453.automatedworkstation.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequestMapping("/request")
@RequiredArgsConstructor
public class RequestControllerMvc {

    private final RequestService requestService;

    @GetMapping("/new")
    public String request() {
        return "request/request";
    }

    @PostMapping("")
    public String create(RequestDtoRequest requestDtoRequest) {
        RequestDto served = requestService.serve(requestDtoRequest);
        if (served.getApprovedStatus()) {
            return String.format("redirect:request/result?term=%s&amount=%s", served.getApprovedTerm(), served.getApprovedAmount());
        }
        return "redirect:request/result";
    }


    @GetMapping("/result")
    public String result
            (
                    Model model,
                    @RequestParam(name = "term", required = false) String term,
                    @RequestParam(name = "amount", required = false) String amount
            ) {
        RequestDto requestDto;
        if (term != null && amount != null) {
            requestDto = RequestDto
                    .builder()
                    .approvedTerm(Integer.valueOf(term))
                    .approvedAmount
                            (
                                    BigDecimal.valueOf
                                            (
                                                    Double.parseDouble(amount)
                                            )
                            )
                    .approvedStatus(true)
                    .build();
            model.addAttribute("request", requestDto);
            return "request/result";
        }
        requestDto = RequestDto.builder().approvedStatus(false).build();
        model.addAttribute("request", requestDto);
        return "request/result";
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("requests", requestService.findAllRequestClients());
        return "request/index";
    }
}
