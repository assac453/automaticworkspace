package com.assac453.automatedworkstation.repository;

import com.assac453.automatedworkstation.entity.Request;

import java.util.List;

public interface RequestRepository {
    int save(Request request);

    Request findById(Integer id);

    List<Request> findAll();

    List<Request> findByApprovedStatus(Boolean approvedStatus);

    void update(Request request);

    void delete(int id);
}
