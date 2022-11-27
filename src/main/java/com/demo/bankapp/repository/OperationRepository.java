package com.demo.bankapp.repository;

import com.demo.bankapp.entity.Client;
import com.demo.bankapp.entity.Operation;

import java.util.List;

public interface OperationRepository {
    void create(Operation operation);
    List<Operation> findAll();
    Client findByDate(String date);
    Client findById(Long id);
    Client findByName(Long id);
    void update(Long id, Operation operation);
    void delete(Long id);
    boolean clientExist(Long id);
}
