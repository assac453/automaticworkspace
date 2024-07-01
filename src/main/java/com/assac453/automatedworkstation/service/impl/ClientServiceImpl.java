package com.assac453.automatedworkstation.service.impl;

import com.assac453.automatedworkstation.dto.ClientDto;
import com.assac453.automatedworkstation.entity.Client;
import com.assac453.automatedworkstation.mapper.ClientMapper;
import com.assac453.automatedworkstation.mapper.EmploymentInfoMapper;
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

    private final ClientMapper clientMapper;

    private final EmploymentInfoMapper employmentInfoMapper;

    @Override
    public List<ClientDto> findAll() {
        return clientRepository
                .findAll()
                .stream().map(clientMapper::entityToDto)
                .toList();
    }

    @Override
    public ClientDto findById(int id) {
        return clientMapper.entityToDto(clientRepository.findById(id));
    }

    @Override
    public List<ClientDto> findByFio(String fio) {
        return clientRepository.findByFio(fio).stream().map(clientMapper::entityToDto).toList();
    }

    @Override
    public List<ClientDto> findByPassport(String passport) {
        return clientRepository.findByPassport(passport).stream().map(clientMapper::entityToDto).toList();
    }

    @Override
    public List<ClientDto> findByContactPhone(String contactPhone) {
        return clientRepository.findByContactPhone(contactPhone).stream().map(clientMapper::entityToDto).toList();
    }

    @Override
    public void update(ClientDto clientDto, int id) {
        Client client = clientMapper.dtoToEntity(clientDto);
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


    @Override
    public Client findByIdEntity(int id) {
        return clientRepository.findById(id);
    }

}
