package com.assac453.automatedworkstation.repository.impl;

import com.assac453.automatedworkstation.entity.Client;
import com.assac453.automatedworkstation.entity.EmploymentInfo;
import com.assac453.automatedworkstation.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {
    private final SessionFactory sessionFactory;

    @Override
    public int save(Client client) {
        return (int) sessionFactory.getCurrentSession().save(client);
    }

    @Override
    public Client findById(Integer id) {
        return sessionFactory.getCurrentSession().find(Client.class, id);
    }

    @Override
    public List<Client> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Client", Client.class).list();
    }

    @Override
    public void update(Client client) {
        sessionFactory.getCurrentSession().saveOrUpdate(client);
    }

    @Override
    public void delete(Client client) {
        sessionFactory.getCurrentSession().delete(client);
    }

    @Override
    public void delete(Integer id) {
        sessionFactory.getCurrentSession().delete(findById(id));
    }

    @Override
    public List<EmploymentInfo> findEmploymentInfoByClient(Integer id) {
        return sessionFactory.getCurrentSession()
                .createQuery("from EmploymentInfo where client.id=:id", EmploymentInfo.class)
                .setParameter("id", id)
                .list();
    }

    @Override
    public List<Client> findByFio(String fio) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Client where fio ilike :fio", Client.class)
                .setParameter("fio", "%" + fio + "%")
                .list();
    }

    @Override
    public List<Client> findByPassport(String passport) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Client where passport like :passport", Client.class)
                .setParameter("passport", "%" + passport + "%")
                .list();
    }

    @Override
    public List<Client> findByContactPhone(String contactPhone) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Client where contactPhone like :contactPhone", Client.class)
                .setParameter("contactPhone", "%" + contactPhone + "%")
                .list();
    }

}
