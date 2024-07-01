package com.assac453.automatedworkstation.controller.mvc;

import com.assac453.automatedworkstation.dto.ClientDto;
import com.assac453.automatedworkstation.dto.EmploymentInfoDto;
import com.assac453.automatedworkstation.service.ClientService;
import com.assac453.automatedworkstation.service.EmploymentInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientControllerMvc {

    private final ClientService clientService;
    private final EmploymentInfoService infoService;

    @GetMapping
    public String index(Model model) {
        List<ClientDto> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "client/client";
    }

    @PostMapping("/search")
    public String searchClients(@RequestParam("searchType") String searchType,
                                @RequestParam("searchValue") String searchValue,
                                Model model) {
        List<ClientDto> clients = new LinkedList<>();

        switch (searchType) {
            case "fio":
                List<ClientDto> byFio = clientService.findByFio(searchValue);
                if (!byFio.isEmpty()) clients.addAll(byFio);
                break;
            case "passport":
                List<ClientDto> byPassport = clientService.findByPassport(searchValue);
                if (!byPassport.isEmpty()) clients.addAll(byPassport);
                break;
            case "contactPhone":
                List<ClientDto> byContactPhone = clientService.findByContactPhone(searchValue);
                if (!byContactPhone.isEmpty()) clients.addAll(byContactPhone);
                break;
            default:
                break;
        }

        model.addAttribute("clients", clients);
        return "client/client";
    }

    @GetMapping("/search/reset")
    public String resetSearch() {
        return "redirect:/client";
    }

    @PostMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") Integer id) {
        clientService.delete(id);
        return "redirect:/client";
    }

    @GetMapping("/edit/{id}")
    public String editClientForm(@PathVariable("id") Integer id, Model model) {
        ClientDto client = clientService.findById(id);
        model.addAttribute("client", client);
        return "client/editClient";
    }

    @PostMapping("/update")
    public String updateClient(@ModelAttribute ClientDto client) {
        clientService.update(client, client.getId());
        return "redirect:/client";
    }

    @GetMapping("/{id}")
    public String showClientForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("client", clientService.findById(id));
        List<EmploymentInfoDto> byClientId = infoService.findByClientId(id);
        model.addAttribute("employmentInfos", byClientId);
        return "client/concreteClient";
    }
}
