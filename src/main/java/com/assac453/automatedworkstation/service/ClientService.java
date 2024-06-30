package com.assac453.automatedworkstation.service;

import com.assac453.automatedworkstation.dto.ClientDto;
import com.assac453.automatedworkstation.entity.Client;

import java.util.List;

public interface ClientService {
    List<ClientDto> findAll();

    ClientDto findById(int id);

    List<ClientDto> findByFio(String fio);

    ClientDto findByPassport(String passport);

    ClientDto findByContactPhone(String contactPhone);

    void update(ClientDto clientDto, int id);

    void delete(int id);

    int create(Client client);


}
