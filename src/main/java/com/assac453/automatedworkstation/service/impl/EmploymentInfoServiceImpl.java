package com.assac453.automatedworkstation.service.impl;

import com.assac453.automatedworkstation.dto.EmploymentInfoDto;
import com.assac453.automatedworkstation.entity.EmploymentInfo;
import com.assac453.automatedworkstation.mapper.EmploymentInfoMapper;
import com.assac453.automatedworkstation.repository.EmploymentInfoRepository;
import com.assac453.automatedworkstation.service.ClientService;
import com.assac453.automatedworkstation.service.EmploymentInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class EmploymentInfoServiceImpl implements EmploymentInfoService {

    private final EmploymentInfoRepository employmentInfoRepository;
    private final ClientService clientService;

    private final EmploymentInfoMapper employmentInfoMapper;

    @Override
    public int save(EmploymentInfoDto employmentInfoDto) {
        EmploymentInfo employmentInfo = employmentInfoMapper.dtoToEntity(employmentInfoDto);
//        ClientDto byId = clientService.findById(employmentInfoDto.getClientId());
//        Client client = clientMapper.dtoToEntity(byId);
//        employmentInfo.setClient(client);
        return employmentInfoRepository.save(employmentInfo);
    }

    @Override
    public EmploymentInfoDto findById(int id) {
        return employmentInfoMapper.entityToDto(employmentInfoRepository.findById(id));
    }

    @Override
    public List<EmploymentInfoDto> findAll() {
        return employmentInfoRepository.findAll().stream().map(employmentInfoMapper::entityToDto).toList();
    }

    @Override
    public void update(EmploymentInfoDto employmentInfoDto, int id) {
        EmploymentInfo employmentInfo = employmentInfoMapper.dtoToEntity(employmentInfoDto);
        employmentInfo.setId(id);
        employmentInfoRepository.update(employmentInfo);
    }

    @Override
    public void delete(int id) {
        employmentInfoRepository.delete(id);
    }

    @Override
    public void saveAll(List<EmploymentInfo> infos) {
        employmentInfoRepository.saveAll(infos);
    }

    @Override
    public List<EmploymentInfoDto> findByClientId(int clientId) {
        return employmentInfoRepository.findByClientId(clientId).stream().map(employmentInfoMapper::entityToDto).toList();
    }
}
