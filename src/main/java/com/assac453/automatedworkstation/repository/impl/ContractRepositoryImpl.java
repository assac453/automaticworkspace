package com.assac453.automatedworkstation.repository.impl;

import com.assac453.automatedworkstation.entity.Contract;
import com.assac453.automatedworkstation.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ContractRepositoryImpl implements ContractRepository {

    private final SessionFactory sessionFactory;

    @Override
    public int save(Contract contract) {
        return (int) sessionFactory.getCurrentSession().save(contract);
    }

    @Override
    public Contract findById(Integer id) {
        return sessionFactory.getCurrentSession().get(Contract.class, id);
    }

    @Override
    public List<Contract> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Contract", Contract.class)
                .list();
    }

    @Override
    public List<Contract> findBySignedStatus(Boolean signedStatus) {
        return sessionFactory.getCurrentSession().createQuery("from Contract where signedStatus = :signedStatus", Contract.class)
                .setParameter("signedStatus", signedStatus)
                .list();
    }

    @Override
    public void update(Contract contract) {
        sessionFactory.getCurrentSession().saveOrUpdate(contract);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(findById(id));
    }
}
