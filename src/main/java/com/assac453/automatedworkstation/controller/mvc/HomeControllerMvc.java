package com.assac453.automatedworkstation.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControllerMvc {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
