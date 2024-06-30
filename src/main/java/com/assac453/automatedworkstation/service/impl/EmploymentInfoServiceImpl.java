package com.assac453.automatedworkstation.service.impl;

import com.assac453.automatedworkstation.dto.ClientDto;
import com.assac453.automatedworkstation.dto.EmploymentInfoDto;
import com.assac453.automatedworkstation.entity.Client;
import com.assac453.automatedworkstation.entity.EmploymentInfo;
import com.assac453.automatedworkstation.mapper.ClientMapper;
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

    @Override
    public int save(EmploymentInfoDto employmentInfoDto) {
        EmploymentInfo employmentInfo = EmploymentInfoMapper.INSTANCE.dtoToEntity(employmentInfoDto);
        ClientDto byId = clientService.findById(employmentInfoDto.getClientId());
        Client client = ClientMapper.INSTANCE.dtoToEntity(byId);
        employmentInfo.setClient(client);
        return employmentInfoRepository.save(employmentInfo);
    }

    @Override
    public EmploymentInfoDto findById(int id) {
        return EmploymentInfoMapper.INSTANCE.entityToDto(employmentInfoRepository.findById(id));
    }

    @Override
    public List<EmploymentInfoDto> findAll() {
        return employmentInfoRepository.findAll().stream().map(EmploymentInfoMapper.INSTANCE::entityToDto).toList();
    }

    @Override
    public void update(EmploymentInfoDto employmentInfoDto, int id) {
        EmploymentInfo employmentInfo = EmploymentInfoMapper.INSTANCE.dtoToEntity(employmentInfoDto);
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
}
