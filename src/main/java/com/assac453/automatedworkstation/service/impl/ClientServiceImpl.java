package com.assac453.automatedworkstation.service.impl;

import com.assac453.automatedworkstation.dto.ClientDto;
import com.assac453.automatedworkstation.entity.Client;
import com.assac453.automatedworkstation.mapper.ClientMapper;
import com.assac453.automatedworkstation.repository.ClientRepository;
import com.assac453.automatedworkstation.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<ClientDto> findAll() {
        return clientRepository
                .findAll()
                .stream().map(ClientMapper.INSTANCE::entityToDto)
                .toList();
    }

    @Override
    public ClientDto findById(int id) {
        return ClientMapper.INSTANCE.entityToDto(clientRepository.findById(id));
    }

    @Override
    public List<ClientDto> findByFio(String fio) {
        return clientRepository.findByFio(fio).stream().map(ClientMapper.INSTANCE::entityToDto).toList();
//        return ClientMapper.INSTANCE.entityToDto();
    }

    @Override
    public ClientDto findByPassport(String passport) {
        return ClientMapper.INSTANCE.entityToDto(clientRepository.findByPassport(passport));
    }

    @Override
    public ClientDto findByContactPhone(String contactPhone) {
        return ClientMapper.INSTANCE.entityToDto(clientRepository.findByContactPhone(contactPhone));
    }

    @Override
    public void update(ClientDto clientDto, int id) {
        Client client = ClientMapper.INSTANCE.dtoToEntity(clientDto);
        client.setId(id);
        clientRepository.update(client);
    }

    @Override
    public void delete(int id) {
        clientRepository.delete(id);
    }

    @Override
    public int create(Client client) {
        return clientRepository.save(client);
    }
}
