package com.assac453.automatedworkstation.repository.impl;

import com.assac453.automatedworkstation.entity.Request;
import com.assac453.automatedworkstation.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RequestRepositoryImpl implements RequestRepository {
    private final SessionFactory sessionFactory;

    public int save(Request request) {
        return (int) sessionFactory.getCurrentSession().save(request);
    }

    @Override
    public Request findById(Integer id) {
        return sessionFactory.getCurrentSession().get(Request.class, id);
    }

    @Override
    public List<Request> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Request", Request.class).list();
    }

    @Override
    public List<Request> findByApprovedStatus(Boolean approvedStatus) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Request where approvedStatus = :approvedStatus", Request.class)
                .setParameter("approvedStatus", approvedStatus)
                .list();
    }

    @Override
    public void update(Request request) {
        sessionFactory.getCurrentSession().saveOrUpdate(request);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(findById(id));
    }

}
