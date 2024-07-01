package com.assac453.automatedworkstation.repository;

import com.assac453.automatedworkstation.entity.Client;
import com.assac453.automatedworkstation.entity.EmploymentInfo;

import java.util.List;

public interface ClientRepository {
    int save(Client client);

    Client findById(Integer id);

    List<Client> findAll();

    List<Client> findByContactPhone(String contactPhone);

    List<Client> findByFio(String fio);

    List<Client> findByPassport(String passport);

    void update(Client client);

    void delete(Client client);

    void delete(Integer id);

    List<EmploymentInfo> findEmploymentInfoByClient(Integer id);
}
