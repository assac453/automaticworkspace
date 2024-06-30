package com.assac453.automatedworkstation.controller.mvc;

import com.assac453.automatedworkstation.dto.request.RequestDtoRequest;
import com.assac453.automatedworkstation.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

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
        requestService.serve(requestDtoRequest);
        String passport = requestDtoRequest.getPassport();
        String encodedPassportBase = Base64.getEncoder().encodeToString(passport.getBytes(StandardCharsets.UTF_8));
        String encodedPassportURL = URLEncoder.encode(encodedPassportBase, StandardCharsets.UTF_8);
        return "redirect:request/result" + "?pass=" + encodedPassportURL;
    }


    @GetMapping("/result")
    public String result(Model model, @RequestParam(name = "pass") String pass) {
        String decodePassportURL = URLDecoder.decode(pass, StandardCharsets.UTF_8);
        String decodedPassportBase = new String(Base64.getDecoder().decode(decodePassportURL), StandardCharsets.UTF_8);
        model.addAttribute("request", requestService.isApproved(decodedPassportBase));
        return "request/result";
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("requests", requestService.findAllRequestClients());
        return "request/index";
    }
}
