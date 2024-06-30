package com.assac453.automatedworkstation.repository.impl;

import com.assac453.automatedworkstation.entity.EmploymentInfo;
import com.assac453.automatedworkstation.repository.EmploymentInfoRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class EmploymentInfoRepositoryImpl implements EmploymentInfoRepository {

    private final SessionFactory sessionFactory;

    @Override
    public int save(EmploymentInfo employmentInfo) {
        return (int) sessionFactory.getCurrentSession().save(employmentInfo);
    }

    @Override
    public EmploymentInfo findById(Integer id) {
        return sessionFactory.getCurrentSession().get(EmploymentInfo.class, id);
    }

    @Override
    public List<EmploymentInfo> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from EmploymentInfo", EmploymentInfo.class).list();
    }

    @Override
    public void update(EmploymentInfo employmentInfo) {
        sessionFactory.getCurrentSession().saveOrUpdate(employmentInfo);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(findById(id));
    }

    @Override
    public void saveAll(List<EmploymentInfo> infos) {
        for (EmploymentInfo info : infos) {
            sessionFactory.getCurrentSession().saveOrUpdate(info);
        }
    }
}
