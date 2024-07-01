package com.assac453.automatedworkstation.controller.mvc;


import com.assac453.automatedworkstation.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
@RequiredArgsConstructor
public class ContractControllerMvc {

    private final ContractService contractService;

    @GetMapping
    public String index(Model model) {
        // добавить информацию из заявки
        model.addAttribute("contracts", contractService.findAllContractClient());
        return "contract/index";
    }

    @GetMapping("/{id}/sign")
    public String sign(@PathVariable int id, Model model) {
        contractService.signContract(id);
        model.addAttribute("contracts", contractService.findAllContractClient());
        return "redirect:/contract";
    }

}
